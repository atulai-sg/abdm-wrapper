package com.abdm.discovery;

import com.abdm.discovery.common.cache.CacheAdapter;
import com.abdm.discovery.common.cache.InMemoryCacheAdapter;
import io.vertx.pgclient.PgPool;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class DiscoveryApplication {
	public static void main(String[] args) {
		SpringApplication.run(DiscoveryApplication.class, args);
	}
	@Bean
	public String realm() {
		return "my-realm";
	}
	@Bean
	public CacheAdapter<String, String> cacheAdapter() {
		return new InMemoryCacheAdapter();
	}
}
