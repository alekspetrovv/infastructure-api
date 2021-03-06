package com.example.group01.config;

import com.example.group01.filter.JWTAuthenticationFilter;
import com.example.group01.filter.JWTAuthorizationFilter;
import com.example.group01.service.AuthenticationUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final AuthenticationUserDetailsService authenticationUserDetailsService;


    @Override protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers("/**").permitAll()
//                .antMatchers(HttpMethod.POST,AuthenticationConfigConstants.SIGN_UP_URL).permitAll()
//               .antMatchers(HttpMethod.GET,"/maps/**","/zones/**","/floorplans/**","/readers/**","/controllers/**").hasAnyAuthority("RECEPTIONIST","ADMIN")
//              .antMatchers(HttpMethod.PUT,"/readers/**","/controllers/**").hasAnyAuthority("ENGINEER","ADMIN")
//               .antMatchers("**").hasAnyAuthority("ADMIN")
                .anyRequest().authenticated()
                .and()
                .addFilter(new JWTAuthenticationFilter(authenticationManager()))
                .addFilter(new JWTAuthorizationFilter(authenticationManager()))
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        ;
    }
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }


}
