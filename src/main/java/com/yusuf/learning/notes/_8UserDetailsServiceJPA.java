package com.yusuf.learning.notes;

/**
 * (1) We are trying to provide UserDetailsServiceImpl implementation
 * (2) We are setting AMB.userDetailsService(UserDetailsService) @see UserServiceConfiguration_HardCoded
 * (3) We hard code user details in @see MyUserDetails_HardCoded.java
 * (4) We hard code user details service in @see MyUserDetailsServiceImpl_HardCoded.java
 * (5) AMB invokes MyUserDetailsServiceImpl_HardCoded.loadUserByUsername() to get the user details
 *     and continue forward
 * (6) Once the rails for the UserDetails is completed, we use JPA to talk to the database
 *     and return back the User results
 *
 */

public class _8UserDetailsServiceJPA {

    public static void main(String[] args) {

    }

}
