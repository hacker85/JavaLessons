package com.max.web.webconfig;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig {// extends WebSecurityConfigurerAdapter {
//    @Autowired
//    DataSource dataSource;
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("user").password("1").roles("USER").and()
//                .withUser("admin").password("2").roles("USER", "ADMIN");
//        auth.jdbcAuthentication().dataSource(dataSource)
////                .withDefaultSchema().withUser("user").password("1").roles("MODERATOR");
//                .usersByUsernameQuery("select username, password, enabled from users where username = ?")
//                .authoritiesByUsernameQuery("select username, authority from authorities where username = ?");
////                .passwordEncoder(new StandardPasswordEncoder());
//    }
////    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        http.authorizeRequests().antMatchers("/spring/test").hasRole("ADMIN").anyRequest().permitAll()
////                .and().formLogin().and().requiresChannel().antMatchers("/spring/test").requiresSecure();
////        http.authorizeRequests()
//////            .antMatchers("/spring/me", "/spring/bla").authenticated()
//////            .antMatchers(HttpMethod.POST, "/spring").authenticated()
//////            .regexMatchers("/spring/.*").authenticated()
//////            .antMatchers("/spring/me").hasAuthority("ROLE_ADMIN")
//////            .antMatchers("/spring/me").hasRole("ADMIN")
////            .antMatchers("/spring/*").hasRole("ADMIN")
////            .antMatchers("/spring/*").access("hasRole('ROLE_ADMIN')")
////            .anyRequest().permitAll();
//        http
//                .authorizeRequests()
//                .anyRequest().authenticated()
//                .and()
//                .formLogin().and()
//                .httpBasic();
//    }
}
