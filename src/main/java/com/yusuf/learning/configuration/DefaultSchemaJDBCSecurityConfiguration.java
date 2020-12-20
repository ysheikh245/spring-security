package com.yusuf.learning.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 * Spring Security Documentation for Default User Configuration
 *
 * https://docs.spring.io/spring-security/site/docs/current/reference/html5/#user-schema
 */

//@EnableWebSecurity
public class DefaultSchemaJDBCSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder amb) throws Exception {

        /**
         *  (1) We use jdbcAuthentication() to configure the AMB.
         *  (2) We use dataSource() to configure the DB and withDefaultSchema() lets spring-security auto
         *  configure the application
         *  (3) withUser() lets you configure the users in the system
         */

        amb.jdbcAuthentication().dataSource(dataSource).withDefaultSchema()
           .withUser(User.withUsername("user").password("user").roles("USER"))
           .withUser(User.withUsername("admin").password("admin").roles("ADMIN"));
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers("/admin").hasRole("ADMIN")
                .antMatchers("/user").hasAnyRole("USER", "ADMIN")
                .antMatchers("/**").permitAll()
                .and().formLogin();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
