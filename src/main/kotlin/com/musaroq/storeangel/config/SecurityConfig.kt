package com.musaroq.storeangel.config

import com.musaroq.storeangel.config.services.CustomUserDetails
import com.musaroq.storeangel.config.services.CustomUserDetailsServices
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder


@Configuration
@EnableWebSecurity

class SecurityConfig(
        private val customUserDetailsServices: CustomUserDetailsServices
): WebSecurityConfigurerAdapter(){

    override fun configure(auth: AuthenticationManagerBuilder) {
//        super.configure(auth)
//        My current fix for protecting posts and puts is to make sure no other manager is signed in
//        auth?.inMemoryAuthentication()
//                ?.withUser("user1")?.password(passwordEncoder().encode("user1Pass"))?.roles("USER")?.and()
//                ?.withUser("user2")?.password(passwordEncoder().encode("user2Pass"))?.roles("USER")?.and()
//                ?.withUser("admin")?.password(passwordEncoder().encode("adminPass"))?.roles("ADMIN")
        val authProvider = DaoAuthenticationProvider()
        authProvider.setUserDetailsService(customUserDetailsServices)
        authProvider.setPasswordEncoder(passwordEncoder())
        auth.authenticationProvider(authProvider)
    }

    override fun configure(http: HttpSecurity) {
        http.cors()
        http.csrf().disable()
        http.httpBasic()
        http
                .authorizeRequests()
                .antMatchers("/api/**").authenticated()
                .anyRequest().permitAll()


//                .httpBasic()
//                .and()
//                .authorizeRequests()
//                .antMatchers("/**").permitAll() /* Don't check for security here */
//                .antMatchers("/login", "/**", "/signup", "/api/**").permitAll() /* Don't check for security here */
//                .anyRequest().authenticated(); /* anything else. secure it for us */

    }

    @Bean
    fun passwordEncoder() = BCryptPasswordEncoder()

}