package com.api.randomuserapi

import org.apache.http.conn.ssl.NoopHostnameVerifier
import org.apache.http.conn.ssl.SSLConnectionSocketFactory
import org.apache.http.conn.ssl.TrustSelfSignedStrategy
import org.apache.http.impl.client.HttpClients
import org.apache.http.ssl.SSLContextBuilder
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.web.client.RestTemplate

@SpringBootApplication
open class RandomUserApiApplication {
    @Bean
    open fun restTemplate(): RestTemplate {
        //javax.net.ssl.trustStore=/home/smith/.keystore

        System.setProperty("javax.net.ssl.trustStore","app.keystore")
        System.setProperty("javax.net.ssl.trustStorePassword","changeit")

        val sslContext = SSLContextBuilder()
            .loadTrustMaterial(TrustSelfSignedStrategy())
            .build()

        val sslConnectionSocketFactory = SSLConnectionSocketFactory(
            sslContext,
            NoopHostnameVerifier.INSTANCE
        )

        val closeableHttpClient = HttpClients
            .custom()
            .setSSLSocketFactory(sslConnectionSocketFactory)
            .build()

        val requestFactory = HttpComponentsClientHttpRequestFactory()
        requestFactory.httpClient = closeableHttpClient

        return RestTemplate(requestFactory)
    }

}

fun main(args: Array<String>) {
    runApplication<RandomUserApiApplication>(*args)
}
