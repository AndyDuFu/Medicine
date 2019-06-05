//package com.medicine.config;
//
//import com.medicine.service.impl.MyUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.builders.WebSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configurers.DefaultLoginPageConfigurer;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;
//
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled=true)
//public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Bean
//    public BCryptPasswordEncoder bCryptPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Autowired
//    MyUserDetailsService myUserDetailsService;
//
//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//        authenticationProvider.setUserDetailsService(myUserDetailsService);
//        authenticationProvider.setPasswordEncoder(this.bCryptPasswordEncoder());
//        return authenticationProvider;
//    }
//
//    @Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(myUserDetailsService).passwordEncoder(this.bCryptPasswordEncoder());
//    }
//
//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring(). antMatchers("/swagger-ui.html")
//                .antMatchers("/webjars/**")
//                .antMatchers("/v2/**")
//                .antMatchers("/swagger-resources/**");
//    }
//
//    protected void configure(HttpSecurity http) throws Exception {
//        http.formLogin().loginProcessingUrl("user/login/").and()
//                .csrf().disable()
//                .addFilter(new WebAsyncManagerIntegrationFilter())
//                .exceptionHandling().and()
//                .headers().and()
//                .sessionManagement().and()
//                .securityContext().and()
//                .requestCache().and()
//                .anonymous().and()
//                .servletApi().and()
//                .apply(new DefaultLoginPageConfigurer<HttpSecurity>()).and()
//                .logout();
//    }
//
//}
