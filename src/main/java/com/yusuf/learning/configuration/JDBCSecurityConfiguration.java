package com.yusuf.learning.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

/**
 *  (1) We use AMB.jdbcAuthentication() to configure the AMB.
 *  (2) We use dataSource() to configure the DB
 *  (3) We use schema.sql to populate the schema. Likewise, data.sql for data population
 */
//@EnableWebSecurity
public class JDBCSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Override
    protected void configure(AuthenticationManagerBuilder amb) throws Exception {

        amb.jdbcAuthentication().dataSource(dataSource);

        // If we have custom schema (table structure), we need to use the following methods then:
        //amb.jdbcAuthentication().dataSource(dataSource).usersByUsernameQuery("");
        //amb.jdbcAuthentication().dataSource(dataSource).authoritiesByUsernameQuery("");
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
