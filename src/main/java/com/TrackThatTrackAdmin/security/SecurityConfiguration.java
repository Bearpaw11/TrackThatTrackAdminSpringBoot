package com.TrackThatTrackAdmin.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
  
  @Autowired
  private PasswordEncoder passwordEncoder;
  
  @Bean
  public PasswordEncoder passwordEncoder () {
    return new BCryptPasswordEncoder();
  }
  
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth
      .inMemoryAuthentication()
      .passwordEncoder(passwordEncoder)
      .withUser("TrackAdmin")
      .password("$2a$10$2suRuckudJT79zHe2uk3m.UYFsYH3nmCK/BLUodujUSVixLFpNOEe")
      .roles("USER", "ADMIN");
  }
  
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .csrf().disable()
      .authorizeRequests()
        .antMatchers("/admin/**").hasAnyRole("ADMIN")
        .anyRequest().hasAnyRole("USER").and()
      .formLogin()
        .loginPage("/login")
        .defaultSuccessUrl("/user/list")
        .permitAll();
  }
//this allows access to the resources and static folders
  @Override
  public void configure(WebSecurity web) throws Exception {
      web
              .ignoring()
              .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/icon/**");
  }
}
