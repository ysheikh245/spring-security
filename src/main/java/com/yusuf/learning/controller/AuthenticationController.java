package com.yusuf.learning.controller;

import com.yusuf.learning.domains.AuthenticationRequest;
import com.yusuf.learning.domains.AuthenticationResponse;
import com.yusuf.learning.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */


//@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JWTUtil jwtUtil;

    /**
     * We are authenticating the user with AuthenticationManager.authenticate
     * It accepts UsernamePasswordAuthenticationToken object
     * @param request
     * @return
     */
    @RequestMapping(value = "/authenticate", method= RequestMethod.POST)
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequest request) {
        try {
            UsernamePasswordAuthenticationToken token =
                    new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword());
            authenticationManager.authenticate(token);
        } catch(Exception e) {
            throw new RuntimeException("Invalid credentials", e);
        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUserName());
        String token = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(token));
    }

}
