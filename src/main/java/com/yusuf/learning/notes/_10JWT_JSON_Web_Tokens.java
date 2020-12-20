package com.yusuf.learning.notes;

/**
 *  - Sometimes also called JaWT is widely used for Authorization
 *  - Authorization strategies
 *      : Session based
 *      : JSON web token
 *  - Why do we need them ? HTTP is a stateless protocol.
 *  - As it is stateless, HTTP is not capable to remember previous interactions by itself
 *  - All the information needed to communicate should be present in that interaction (request)
 *
 *  Session based
 *  - In the session based token, the sessionId is sent back to the client (via Cookies)
 *    The request went to Server1 and the sessionId was returned.
 *  - Assume a scenario where the server is sitting behind a load balance.
 *          Client --> Load Balancer --> Server1, Server2, Server3
 *          Server2, Server3 will not be able to understand the sessionId from Server1 unless they
 *          share the session log database or we use sticky sessions.
 *
 *  Token based authorization
 *  - The user information is sent back as a token. This information is signed so that it
 *    becomes very difficult to tamper it and re-use it later.
 *  - Later when the client presents this entire information to the server, the server
 *    validates the signature and only then converses later
 *
 *
 *
 */
public class _10JWT_JSON_Web_Tokens {

    public static void main(String[] args) {

    }

}
