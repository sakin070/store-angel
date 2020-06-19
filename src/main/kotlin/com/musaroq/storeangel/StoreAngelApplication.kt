package com.musaroq.storeangel

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import java.util.*


@SpringBootApplication
class StoreAngelApplication

@Bean
fun corsConfigurationSource(): CorsConfigurationSource? {
	val configuration = CorsConfiguration()
	configuration.allowedOrigins = Arrays.asList("*")
	configuration.allowedMethods = Arrays.asList("*")
	configuration.allowedHeaders = Arrays.asList("*")
	configuration.allowCredentials = true
	val source = UrlBasedCorsConfigurationSource()
	source.registerCorsConfiguration("/**", configuration)
	return source
}
fun main(args: Array<String>) {
	runApplication<StoreAngelApplication>(*args)
}
