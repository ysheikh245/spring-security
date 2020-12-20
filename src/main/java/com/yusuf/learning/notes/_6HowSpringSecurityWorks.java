package com.yusuf.learning.notes;

import org.springframework.security.core.userdetails.UserDetails;

/**
 *  - How Spring Security does this under the hood ?
 *
 *  - As soon as we add Spring Security dependency, it injects itself as a Filter component
 *  - DelegatingFilterProxy is responsible for this in case of Spring Boot application.
 *  - In case of non-Spring Boot application, we need to add this dependency manually
 *  - The DelegatingFilterProxy delegates the requests to a chain of Filters to do the magic
 *  - AuthenticationFilter is one of them which does the job of authenticating the user
 *  - AuthorizationFilter is one of them which does the job of authorizing the user
 *  - The input to Authentication are the credentials and the output is just not a Boolean
 *    value indicating the authentication was successful. Instead it is a Principal object
 *  - The Spring Security keeps track of the input and the output via the Authentication object
 *  - Think of it as an Data Transfer Object
 *  - The AuthenticationProvider is responsible for doing the actual authentication
 *  - For our custom implementation, we implement the interface and override authenticate()
 *  - For e.g.
 *         - (Step1) someone entering the credentials and passing as an input.
 *         The Authenticate object will contain the credentials
 *         - (Step2) the authenticate method is invoked and if its successful, it clears the
 *         credentials object and returns back Principal object contained in Authenticate object
 *  - There could be multiple authentication strategies used in the application.
 *    For e.g. PasswordAuthentication, OAuthAuthentication, LDAPAuthentication etc.
 *  - We use AuthenticationManager to co-ordinate among all. ProviderManager implements AuthenticationManager
 *  - Depending on the authentication type, it picks up the right AuthenticationProvider using the supports()
 *  and invokes the authenticate()
 *  - It goes a little further with the AuthenticationProvider. Lets assume we are one of the Providers
 *      (Step1): We need to take the credentials and go to the identity store and lookup the user info
 *  - Almost all of the Providers, need to do a similar thing (lookup the User).
 *  - Once the User is retrieved, all the other checks are the same (p/w not expired, valid user etc.)
 *  - Spring Security has abstracted all the checks and retrieves the User via UserDetailsService
 *      input=userName, output=UserDetails (@see{@link UserDetails}
 *
 * --- The entire flow ---
 *  - AuthenticationFilter intercepts the request.
 *  - It creates an Authentication object filling the credentials information
 *  - It passes the request to AuthenticationManager
 *  - The AuthenticationManager finds the right AuthenticationProvider using the supports()
 *  - After finding the right provider, it calls the Authentication Provider's authenticate(Authetication)
 *  - The Authentication Provider uses the USerDetails service to lookup the user
 *  - The UserDetails service returns the USerDetails instance which the provider verifies
 *  - It does the actual authentication using the authenticate() and if successful returns Authentication object
 *    with the Principal and Authorities filled in
 *  - If its not successful, AuthenticationException is thrown back from AuthenticationProvider to AuthenticationManager
 *  - If successful, it puts the Authentication object into the SecurityContext in the ThreadLocal object
 *  - To associate the SecurityContext with the session, another filter is used to put in the Session object
 *  - This filter is also responsible to take it from Session object and put in the current request for
 *    subsequent requests
 *
 *
 */

public class _6HowSpringSecurityWorks  {

    public static void main(String[] args) {

    }

}
