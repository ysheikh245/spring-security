package com.yusuf.learning.notes;


/**
 *  - Sample JWT token a.b.c (separated by periods)
 *      Part a = header. Part b = payload. Part c = signature
 *  - jwt.io is where we can play with JWT Tokens
 *  - We send this token on all subsequent requests
 *  - Everything in JWT is a Base64 encoded value
 *  - The header and signature gives us the authencity
 *  - In the header, we have algorithm and type of the token
 *  - The algorithm is what is used in the signature for encryption
 *  - The payload is a plain text. When the server gets the token,
 *    using the signature, only it can calculate the hash of the message
 *    Any change in the message will not result into the same hash.
 *  - The signature is created by the algorithm mentioned in the header
 *  - The algorithm needs a secret key which is only known to the server (crytography hash)
 *  - base64Encode(header) + base64Encode(payload) signed by the secret key gives the signature value
 *  -
 *
 *  ---- Walkthrough ----
 *  - Clients sends userId/password to the server.
 *  - The server authenticates the user and password using other mechanism
 *    and once the user is authenticated, the server creates a JWT token for
 *    future interactions with the server.
 *  - JWT is *NOT USED* for authentication. It is specific for authorization
 *  - Once the client gets the JWT token, it sends the JWT token in the HTTP header
 *  - The header used to send the value is a key-value pair
 *      Key = Authorization
 *      Value = "Bearer" + <Token>
 *  - Once the server gets the token, it validates the token as explained above
 *  - If someone gets hold of the JWT token, they can impersonate the user
 *  - So the way we transmit JWT also needs to be careful. Typically https is used
 *  - OAuth is also used for authentication/authorization and has its own way of protecting the session
 *  - Drawbacks: if someone steals the sessionId, the user can logoff the session and it terminates the session
 *  - Similarly, in JWT we can also have expiration time
 *  - Incase if JWT is stolen, the server blacklists the JWT and stores it at the server level
 *  - For any incoming request, it will check if the incoming JWT is a blacklisted one or not
 *
 *
 *
 */
public class _11_JSON_Token_Structure {

    public static void main(String[] args) {

    }

}
