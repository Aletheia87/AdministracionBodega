package cl.desafiolatam.administracionBodega.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		.withUser("Archie")
		.password(encoder().encode("12345"))
		.roles("BODEGA")
		.and()
		.withUser("Alexander")
		.password(encoder().encode("56789"))
		.roles("BODEGA");

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/login").permitAll()
		.antMatchers("/materiales").hasRole("BODEGA")
		.anyRequest().authenticated()
		.and()
		.formLogin().loginPage("/login")
		.failureUrl("/login?error=true")
		.usernameParameter("username")
		.passwordParameter("password")
		.defaultSuccessUrl("/");

	}
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

}