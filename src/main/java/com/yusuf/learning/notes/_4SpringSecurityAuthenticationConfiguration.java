package com.yusuf.learning.notes;

import com.yusuf.learning.configuration.SecurityConfigurer;

/**
 *  - Authentication Manager manages the authentication
 *  - AuthenticationManager.authenticate() checks the authentication and returns a boolean value
 *  - To affect the AM, we need to configure using the AuthenticationManagerBuilder class as follows:
 *      - Get hold of AMB
 *      - Set the configuration on it
 *  - While configuring the AMB, we tell that it is an in-memory AMB
 *  - Also, need to tell the username, password and the role. Thereby, it builds the userInfo object
 *  - Once AMB is configured, a new AM is created
 *  - We need to extend a class and override the method: configure(AuthenticationManagerBuilder abm)
 *  - We write a Configuration class extending WebSecurityConfigurerAdapter @see {@link SecurityConfigurer}
 *
 */

public class _4SpringSecurityAuthenticationConfiguration {

    public static void main(String[] args) {

    }



}
