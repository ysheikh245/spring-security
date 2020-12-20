package com.yusuf.learning.notes;

/**
 *  - OAuth was not originally meant for Authorization. However, we will see it can also be used for Authentication
 *  - Use case: Photo printing service talks to Google Drive
 *  - When the user wants to print photos from Google Drive using photo printing service,
 *      - user has to authenticate to photo printing service. Only then he has the potential to request for Google Drive
 *      - instead we can directly rely on Google authentication and take it forward
 *      - here, we are leveraging OAuth for authentication as well
 *  - We will send the email id to one of the providers (Google, FB, Github etc.)
 *  - The provider will recognize a valid email and send the OAuth Token
 *  - The spring security app will extract the userName and put it in the Security Context of application to simulate authentication
 *  - We are not going to interact with the provider again. The interaction was only to authenticate the user and get the details
 *  - The spring security provides an Annotation to do all of this (because of common use case)
 *  - We import the dependencies in the pom xml
 *      <dependency>
 * 			<groupId>org.springframework.security.oauth.boot</groupId>
 * 			<artifactId>spring-security-oauth2-autoconfigure</artifactId>
 * 			<version>2.1.8.RELEASE</version>
 * 		</dependency>
 *  - EnableAuth2Sso, EnableAuth2Client are the annotations that needs to be present in the Spring application
 *  - EnableAuth2Client is when we don't want to leverage OAuth2 for authentication
 *  - EnableAuth2Sso is when we want to leverage OAuth2 for Authentication. It enables application for SSO authentication
 *  - What is the provider that needs to be communicated for SSO ?
 *  - We will provide configuration in application.properties file
 *  - As part of configuration, we need to setup our app and tell the provider about our application
 *  -
 */

public class _15_OAuth_FB_Authentication {

    public static void main(String[] args) {

    }

}
