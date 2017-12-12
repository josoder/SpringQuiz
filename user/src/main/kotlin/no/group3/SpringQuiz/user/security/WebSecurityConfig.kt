package no.group3.SpringQuiz.user.security

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter



@EnableWebSecurity
open class WebSecurityConfig: WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity) {
        http.httpBasic()
                .and()
                .authorizeRequests()

                .antMatchers(HttpMethod.GET, "/**").authenticated()
                .antMatchers(HttpMethod.POST, "/**").permitAll()
                .antMatchers(HttpMethod.PUT, "/**").authenticated()
                .antMatchers(HttpMethod.PATCH, "/**").authenticated()
                .antMatchers(HttpMethod.DELETE, "/**").authenticated()
                .anyRequest().denyAll()
                .and()
                .csrf().disable()
    }

}