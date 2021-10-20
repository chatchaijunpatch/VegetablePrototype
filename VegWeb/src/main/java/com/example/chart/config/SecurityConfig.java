package com.example.chart.config;

import com.example.chart.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    private UserService service;

    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/login*","/", "/home","/css/**","/js/**","/images/**","/register").permitAll()
                .antMatchers("/vegetable/add","admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").defaultSuccessUrl("/vegetable")
                .and()
                .logout()
                .logoutSuccessUrl("/login")
                .permitAll();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.jdbcAuthentication()
                    .dataSource(dataSource)
                    .usersByUsernameQuery(
                            "SELECT username, password, 'true' FROM users WHERE username=?")
                    .authoritiesByUsernameQuery(
                            "SELECT username, 'ROLE_USER' FROM users WHERE username=?");
        System.out.println(auth.inMemoryAuthentication().getUserDetailsService());

        auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("user")).roles("USER")
                .and()
                .withUser("user1").password(passwordEncoder().encode("user1")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception
//    {
//        auth.inMemoryAuthentication()
//                .withUser("user").password(passwordEncoder().encode("user")).roles("USER")
//                .and()
//                .withUser("user1").password(passwordEncoder().encode("user1")).roles("USER")
//                .and()
//                .withUser("admin").password(passwordEncoder().encode("admin")).roles("ADMIN");
//    }


//        http
//                .authorizeRequests()
//                .antMatchers("/", "/css/**", "/js/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .
//                .and()
//                .oauth2Login()
//                .defaultSuccessUrl("/").permitAll()
//                .and()
//                .logout()
//                .logoutSuccessUrl("/").permitAll();
}
