package me.springboot.tutorial.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity  //기본적인 Web 보안을 활성화 하겠다라는 의미.
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring()
                .antMatchers(
                        "/h2-console/**",
                        "/favicon.ico"
                );
        // h2콘솔 하위 모든 요청과 파비콘 관련 요청은 스프링 시큐리티 로직 수행하지 않도록 함
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()    // HttpServletRequest 사용하는 요청들에 대한 접근제한을 설정하겠다
                .antMatchers("/api/hello").permitAll()  // api/hello에 대한 요청은 인증없이 접근 허용
                .anyRequest().authenticated();  // 나머지 요청은 모두 인증 되어야 한다
    }
}
