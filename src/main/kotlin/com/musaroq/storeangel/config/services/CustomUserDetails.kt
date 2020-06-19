package com.musaroq.storeangel.config.services

import com.musaroq.storeangel.entities.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.stream.Collectors

class CustomUserDetails: UserDetails{
    private val user: User

    constructor(user: User){
        this.user = user
    }


    override fun getAuthorities(): MutableCollection<out GrantedAuthority> {
        return user.roles.stream().map {role ->
            SimpleGrantedAuthority(role.name)
        }.collect(Collectors.toList())
    }

    override fun isEnabled(): Boolean {
        return user.enabled
    }

    override fun getUsername(): String {
       return user.userName
    }

    override fun isCredentialsNonExpired(): Boolean {
        return user.credentialsNonExpired
    }

    override fun getPassword(): String {
        return user.hashedPassword
    }

    override fun isAccountNonExpired(): Boolean {
        return user.accountNonExpired
    }

    override fun isAccountNonLocked(): Boolean {
        return user.accountNonLocked
    }
}