package com.yusuf.learning.notes;

/**
 *  - It uses Filter technology to provide the Spring Security Framework
 *
 *  - To get started, we add the spring-security dependency in the pom xml
 *
 *  - The application is wrapped with an authentication screen except for the error screen with this entry
 *
 *  - If we do not provide any configuration, it generates the password at the server startup for the user.
 *
 *  - Default userId = user, password=generated security password at the server startup
 *
 *  - If we want to configure the default user and the password, we have to override following in
 *    application.properties
 *          - spring.security.user.name=
 *          - spring.security.user.password=
 *
 */

public class _3AddSpringSecurityToProject {

    public static void main(String[] args) {

    }

}
