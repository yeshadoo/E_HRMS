package com.dmu.hrms.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author : hadoo
 * @Date : 2020/12/20 19:01
 */
@EnableWebSecurity
public class MySecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailService myUserDetailsService;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //定制请求的授权规则
        http.authorizeRequests().antMatchers("/index","/info/**").permitAll()
                .antMatchers("/patient/**","/touch/**","/cure/**","/dead/**").hasRole("User")
                .antMatchers("/manager/**").hasRole("Admin")
                .and()
                .formLogin()
                //指定登录页是"/login"
                .loginPage("/login")
                //登录成功后默认跳转到
                .defaultSuccessUrl("/index");

        //开启自动配置的登录功能
        http.formLogin();
        //关闭csrf保护功能
        http.csrf().disable();
        http.logout().logoutUrl("/logout").logoutSuccessUrl("/login");
        //开启记住我功能
        http.rememberMe();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                //创建内存用户n-user
                .withUser("harden")
                //设置密码为123456
                .password( new BCryptPasswordEncoder().encode("111"))
                //权限是user
                .roles("admin");
        auth.authenticationProvider(authenticationProvider());
        System.out.println(new BCryptPasswordEncoder().encode("111"));
    }


    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder());
        authenticationProvider.setUserDetailsService(myUserDetailsService);
        return  authenticationProvider;

    }
}