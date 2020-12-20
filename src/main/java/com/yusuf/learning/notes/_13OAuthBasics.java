package com.yusuf.learning.notes;

/**
 * - The original intent for OAuth was Authorization (authorization between services)
 * - We are going to talk about a usecase. Photo printing website
 * - We want to allow users to import photos from Google cloud and use our service to print them
 * - We need to provide Google credentials to be able to access Google Cloud
 * - We can request users to give them their account details or somehow request Google to provide us access to the photos
 * - How do 3rd party service interact with Google w/o user giving them userId, password
 * - Here comes, OAuth (service interacting with each other on users behalf)
 * - version 2.0 is known an OAuth2
 * - Common analogy: a common valet key example (to avoid misuse of the master key and browsing the cars glove compartment, trunk, fuel tank etc.)
 * - Car Owner needs 2 service - car and valet
 * - The Valet service directly needs Car service (with limited access though)
 * -
 *
 * ---- The OAuth flow ----
 * - Photo service needs to access Google service
 * - The user is logged in both the services. Both the service knows the user but does not trust each other
 * - When the user requests to import photo from Google Cloud, photo printing service requests access to Google service
 * - Google service reaches out to the user and requests permission for access to be allowed or not ?
 * - Based on the response, Google Cloud service reaches out to Photo Print App (assuming, gave access)
 * - In the response, Google Service gives a token (Authorization token) with limited access - similar to a restricted valet key
 * - In all subsequent requests, Photo Service app will present the token and based on its validity, Google Cloud allows it
 * - The Authorization token containing data and is also secured (not modified or tampered_, we use JWT tokens
 */
public class _13OAuthBasics {

    public static void main(String[] args) {

    }

}
