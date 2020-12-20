package com.yusuf.learning.notes;

/**
 * Authentication vs Authorization
 *
 * Authentication - Who is this user ? By showing some kind of an identification which identifies you
 * Authorization  - Are they allowed to do this ?
 *
 * Types of Authentication
 *      - Knowledge Based Authentication (password or middleName or zipCode etc.)
 *      - Possession Based Authentication (OTP / AccessCard to get into a building etc.)
 *      - Knowledge + Possession Based Authentication (Multi-factor authentication)
 *
 *  Authorization: Can the user do this (What the user can do) ?
 *
 *  We need Authentication before Authorization as we need to know who the user is before finding out whether
 *  the user is allowed to perform an operation
 *
 *  Principal:
 *      - Currently logged in user (it is that unique information or account that is tied to a specific person)
 *      - Once you give the user/password, application establishes the Principal & remembers it for a session
 *
 *  Authority:
 *      - The user would be allowed to do the operation only if the user was granted the authority via
 *        authorization from 'list of authorities' for an application
 *
 *  Role:
 *      - Assigning list of authorities and managing them for every user will be maintenance nightmare
 *      - We group the authorities to a role and assign the role to a user instead
 *        (for e.g. role_store_clerk, role_dept_mgr, role_store_mgr etc.)
 *
 *  Roles are coarse grained (grouped authorities) and authorities are fine grained
 *
 */

public class _2SpringSecurityConcepts {

    public static void main(String[] args) {

    }

}
