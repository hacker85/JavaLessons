package com.max.config.security;

//@Configuration
//@EnableWebSecurity
//@Import(MethodSecurityConfig.class)
public class SecurityConfig {// extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication().withUser("user").password("1").roles("ADMIN").and()
//                .withUser("root").password("1").roles("ADMIN");
//    }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/test").authenticated()
//                .anyRequest().permitAll().and().formLogin().loginPage("/login").permitAll()
//                .and().rememberMe().tokenValiditySeconds(9999999).key("secretKey")
//                .and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/home");
//    }
//
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/login");
//    }
}
