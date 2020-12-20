package com.yusuf.learning.notes;

import com.yusuf.learning.controller.HomeController;
import com.yusuf.learning.configuration.SecurityConfigurer;

/**
 *  - We built 3 api's in @see{@link HomeController} class and created user() and admin()
 *  - user() is for 'USER' and 'ADMIN' role and admin() is only for 'ADMIN' role
 *  - HttpSecurity lets us configure what are the path's and what are the access restrictions for those paths
 *  - To get hold of HttpSecurity, we need to extend the class and override configure(HttpSecurity)
 *  - We write a Configuration class extending WebSecurityConfigurerAdapter @see {@link SecurityConfigurer}
 *  - We use the authorizeRequests in the method to open the method chaining specifying paths to the role
 *  - Specify the path using the method antMatchers().
 *  - We use wildcards to specify the path and generally do not mention about each and every paths
 *  - The /** matches all the paths from the current level to the nested levels
 *  - The hasRole, hasAnyRole() and permitAll() methods are used mainly while overriding
 *  - After mentioning about paths and role, we also specify the type of login we want spring security to do
 *  - Like login page, it also provides logout page to log the user off
 *  - We need to configure the role of ADMIN using the hasAnyRole().
 *  - By default, it would treat USER and ADMIN roles differently
 *  - We start from the most restrictive to the most specific ones in the configure()
 */

public class _5SpringSecurityAuthorizationConfiguration {

    public static void main(String[] args) {

    }

}
