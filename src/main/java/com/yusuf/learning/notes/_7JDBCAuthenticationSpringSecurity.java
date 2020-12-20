package com.yusuf.learning.notes;

import com.yusuf.learning.configuration.DefaultSchemaJDBCSecurityConfiguration;

/**
 *  - AuthenticationManagerBuilder (AMB)
 *  - We use the AMB.jdbcAuthentication() using WebSecurityConfigurerAdapter.configure()
 *  - To talk to the database, we need to Autowire and configure the DataSource as well
 *  - As we are using H2, spring-security configures it by itself
 *  - Also, spring-security provides a default convention of configuring the DB.
 *  - We use the default by using withDefaultSchema()
 *
 *  - @see {@link DefaultSchemaJDBCSecurityConfiguration}
 *  - @see {@link DefaultSchemaJDBCSecurityConfiguration}
 *  -
 */

public class _7JDBCAuthenticationSpringSecurity {

    public static void main(String[] args) {

    }

}
