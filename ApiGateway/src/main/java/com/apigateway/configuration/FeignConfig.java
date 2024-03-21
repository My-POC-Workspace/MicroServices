package com.apigateway.configuration;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.ssl.SSLContexts;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Client;

@Configuration
public class FeignConfig {
	@Bean
	public Client feignClient() {
		return new Client.Default(getSSLSocketFactory(), new NoopHostnameVerifier());
	}

	private SSLSocketFactory getSSLSocketFactory() {
		try {
			SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, new TrustSelfSignedStrategy()).build();
			return sslContext.getSocketFactory();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

}
