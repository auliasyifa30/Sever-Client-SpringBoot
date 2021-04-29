
package com.mii.server.configuration;

import com.mii.server.services.UserDetailService;
import com.mii.server.services.UserManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserManagementService userManagementService;

    @Autowired
    UserDetailService userDetailService;
    
    @Autowired
    PasswordEncoder passwordEncoder;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder);
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                //semua login, dan province diizinkan masuk (bisa dengan no auth)
                .antMatchers("/login").permitAll()
                //jika ingin mengunjungi district, maka perlu melakukan login dengan (basih auth)
                .antMatchers("/list-district","/logout").authenticated()
                .antMatchers("/dis-insert", "/dis-update/{id}", "/dis-delete/{id}").hasAnyRole("ADMIN")
                .and()
//                .logout().disable()
//                .formLogin().disable()
                .httpBasic();
    }
}

