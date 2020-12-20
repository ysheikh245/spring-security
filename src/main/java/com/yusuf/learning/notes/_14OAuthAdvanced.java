package com.yusuf.learning.notes;

/**
 * - Use case: Photo printing service wants to access Google Drive
 * - Terminologies:
 *      Resource        : what is being sought? (protected resource) - photos on Google Drive
 *      Resource Owner  : the person who has access to resource (the user/person who can grant access to protected resource)
 *      Resource Server : the server which holds the protected resource (Google Drive)
 *      Client          : Photo Printing Service (the application that needs access to protected resource on behalf of resource owner).
 *      Authorization server : The server issuing access tokens to the client
 * - Who has the burden of security?
 *      The resource owner is the one who owns protected resource.
 *      In our example, Google Drive holds responsible of security
 *      Typically, the resource server is coupled with Authorization server
 *      This Authorization server is responsible for ensuring proper access to the resource (having access)
 *      Google implements an Authorization server which uses OAuth2
 *      Authorization server can be separate or within the resource server
 *
 *  OAuth Flow 1 - Authorization Code Flow
 *      The user logged on Photo Printing service and requests to import photos from Google Drive
 *      Photo printing service talks (on behalf of user) to Authorization server and requests access to Google Drive
 *      Authorization Server contacts the resource owner (user who wants to print photos) to grant access or deny
 *      In addition to what is being sought, the requested permissions are also listed
 *      It presents an Auth token to the photo printing service
 *      The photo printing service presents this 'Auth Token' and requests for an 'Access Token'
 *      The photo printing service uses this 'Access Token' to talk to Google Drive
 *      Google Drive talks to the Authorization Server and validates the token
 *      Once the token is validated, it provides the protected resource to the photo printing service
 *
 *  OAuth Flow 2 - Implicit Flow
 *      The user logged on Photo Printing service and requests to import photos from Google Drive
 *      Photo printing service talks  (on behalf of user) to Authorization server and requests access to Google Drive
 *      Authorization Server contacts the resource owner (user who wants to print photos) to grant access or deny
 *      The resource owner grants access
 *      In this flow, instead of giving 'Auth Token' and later exchange an 'Access Token', it directly present 'Access Token'
 *      The photo printing service gives this Access Token to Google Drive which validates with Authorization Server and gives access
 *
 *  OAuth Flow 3 - Client Credentials Flow
 *      The client is well trusted for confidential clients
 *      Use case : MicroService1 --> MicroService2 --> Talks to Database
 *      MicroService1 talks to the Authorization Server and presents the clientId (identification)
 *      Authorization Server returns the 'Access Token'
 *      MicroService1 sends the 'Access Token' to MicroService2
 *      If Service1 requests anything other than specified 'Access Token', the access is denied
 *
 */
public class _14OAuthAdvanced {

    public static void main(String[] args) {

    }

}
