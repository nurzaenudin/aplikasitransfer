/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nurzaenudin.aplikasitransfer.configuration;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 *
 * @author nurza
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    public static final String SQL_LOGIN="SELECT  u.username, up.password, u.active AS enabled FROM s_user u " +
            "LEFT JOIN s_user_password up ON u.id=up.user_id " +
            "WHERE u.username= ?";
    public static final String SQL_PERMISSION="SELECT u.username, p.name FROM s_user u " +
            "LEFT JOIN s_user_role ur ON u.id=ur.user_id " +
            "LEFT JOIN s_role r ON ur.role_id=r.id " +
            "LEFT JOIN s_role_permission rp ON r.id = rp.role_id " +
            "LEFT JOIN s_permission p ON rp.permission_id=p.id " +
            "WHERE u.username= ?";

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic()
                .and().formLogin().permitAll()
                .and().logout()
                .and().authorizeRequests().anyRequest().authenticated()
                .and().csrf().disable();
    }


    
            
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth
//                .inMemoryAuthentication()
//                .withUser("udin")
//                .authorities("USER_VIEW")
//                .password(passwordEncoder().encode("rahasia"));
//              
//               
//    }
    
    @Autowired
    private DataSource datasource;
    
    @Override    
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(datasource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery(SQL_LOGIN)
                .authoritiesByUsernameQuery(SQL_PERMISSION);
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    
    }

    
    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean(); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    @Bean
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean(); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    

    
    
    
}
