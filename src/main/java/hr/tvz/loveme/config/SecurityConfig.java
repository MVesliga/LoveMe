package hr.tvz.loveme.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication()
                .withUser("user").password(passwordEncoder().encode("userpass")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("adminpass")).roles("ADMIN");*/
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select korisnicko_ime, lozinka, enabled from korisnik where korisnicko_ime=?")
                .authoritiesByUsernameQuery("select korisnicko_ime, uloga as role from korisnik_uloga where korisnicko_ime=?")
                .passwordEncoder(new BCryptPasswordEncoder(12));
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        String[] staticResources  =  {
                "/css/**",
                "/images/**",
                "/fonts/**",
                "/scripts/**",
        };

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/love-me/**").hasRole("USER")
                .antMatchers(staticResources).permitAll()
                .antMatchers("/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/prijava")
                .loginProcessingUrl("/prijava")
                .defaultSuccessUrl("/love-me/", true)
                .failureUrl("/prijava")
                .and()
                .logout()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID");

        http.headers().frameOptions().disable();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/h2-console/**");
    }
}
