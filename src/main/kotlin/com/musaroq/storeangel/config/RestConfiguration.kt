package com.musaroq.storeangel.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.rest.core.config.RepositoryRestConfiguration
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class RestConfiguration {
    @Bean
    fun forwardToIndex(): WebMvcConfigurer {
        return object : WebMvcConfigurer {
//            TODO: add html so as to allow it be served by spring
            override fun addViewControllers(registry: ViewControllerRegistry) {
                registry.addViewController("/login").setViewName("login")
                registry.addViewController("/").setViewName("forward:/index.html")
                registry.addViewController("/{x:[\\w\\-]+}")
                        .setViewName("forward:/index.html");
//                // Multi-level directory path, need to exclude "api" on the first part of the path
                registry.addViewController("/{x:^(?!api$).*$}/**/{y:[\\w\\-]+}")
                        .setViewName("forward:/index.html");
            }

        }


    }
}