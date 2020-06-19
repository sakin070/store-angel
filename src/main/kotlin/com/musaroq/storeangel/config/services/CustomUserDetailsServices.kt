package com.musaroq.storeangel.config.services

import com.musaroq.storeangel.entities.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service("userDetailsService")
class CustomUserDetailsServices (private val repository: UserRepository): UserDetailsService{
    override fun loadUserByUsername(username: String): UserDetails {
        return CustomUserDetails(repository.findByUserName(username))
    }

}