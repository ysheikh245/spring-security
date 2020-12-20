package com.yusuf.learning.configuration;

import org.springframework.cglib.proxy.NoOp;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Step1 - comment the super.configure() to take control of overriding the configure()
 * Step2 - use the inMemoryAuthentication and provide the user, password and the roles
 * Step3 - Annotate the class with '@EnableWebSecurity' (this tells Spring Security that it is a web security configuration)
 * Step4 - Create a PasswordEncoder bean for encoding the password
 * Step5 - and() allows you to chain the Builder pattern and create more users
 *
 * Interestingly, if we comment the passwordEncoder(), we get the following runtime exception
 * in stacktrace after entering the userName/password:
 * java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id "null"
 * 	at org.springframework.security.crypto.password.DelegatingPasswordEncoder$UnmappedIdPasswordEncoder.matches(DelegatingPasswordEncoder.java:244) ~[spring-security-core-5.1.5.RELEASE.jar:5.1.5.RELEASE]
 * 	at org.springframework.security.crypto.password.DelegatingPasswordEncoder.matches(DelegatingPasswordEncoder.java:198) ~[spring-security-core-5.1.5.RELEASE.jar:5.1.5.RELEASE]
 *
 */

//@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder amb) throws Exception {
        //super.configure(auth);
        amb.inMemoryAuthentication()
           .withUser("blah")
            .password("blah")
            .roles("USER")
            .and()
            .withUser("foo")
            .password("foo")
            .roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // we want spring security to use form login
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
