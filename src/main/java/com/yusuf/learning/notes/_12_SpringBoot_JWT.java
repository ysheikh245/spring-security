package com.yusuf.learning.notes;

import com.yusuf.learning.configuration.JWTSecurityConfiguration;
import com.yusuf.learning.controller.AuthenticationController;
import com.yusuf.learning.service.MyUserDetailsServiceImpl_HardCoded;
import com.yusuf.learning.filters.JWTRequestFilter;

/**
 *  ------ Creating the JWT Token ----- @see JwtUtil.java
 *  - We add the JWT dependency: jjwt, jaxb-api
 *  - claims is the authorities, the user can have
 *  - subject is the person who's authenticated
 *  - set the expiration date, time. finally, we create the signature of the message @see JWTUtil.java
 *
 *  ---- Step 1 ----
 *  - Create an AuthenticationController accepting username / password
 *  - Once the user is authenticated, we generate a JWT token using JwtUtil and return it in response
 *
 *  ---- Step 2 ----
 *  - We create the JWT token and send it in the response
 *  - We create Filter which reads this response, extracts the token and validates the token
 *
 *
 *  ---- What actually happens ----
 *  (1) As we have provided AMB.userDetailsService(userDetailsService) in the configure() of JWTSecurityConfiguration,
        it knows the type of the AuthenticationManager object
 *  (2) This dependency is injected into AuthenticationController.authenticationManager attribute
 *  (3) Calling AuthenticationManager.authenticate() invokes AbstractUserDetailsAuthenticationProvider.authenticate()
 *  (4) It thereby uses DaoAuthenticationProvider.retrieveUser() to find the correct UserDetailsService
 *  (5) Later, it finds the right instance of UserDetailsService and invokes loadUserByUsername().
 *      In our case, it is MyUserDetailsServiceImpl_HardCoded.loadUserByUsername()
 *  (6) The control goes back returning back the Authentication object
 *  (7) Later, we are creating a JWT token via the JWTUtil class and passing it in the Response
 *  (8) For subsequent requests, the JWT token is sent in the HTTP header
 *  (9) We intercept the request via a Filter and use JWTUtil to verify the token.
 *  (10) Once we verify the token, we re-create Authentication object and insert it back in the SessionContext
 *
 * @see JWTSecurityConfiguration,
 * @see AuthenticationController,
 * @see JWTRequestFilter
 * @see MyUserDetailsServiceImpl_HardCoded
 *
 */
public class _12_SpringBoot_JWT {

    public static void main(String[] args) {

    }
}
