package by.academy.tikhomirov.springmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import by.academy.tikhomirov.servise.impl.UserDetailsServiseImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiseImpl userDetailsServise;

	@Autowired
	public void registerGlobalAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServise).passwordEncoder(getShaPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// �������� ������ �� CSRF ����
		http.csrf().disable()
				// ��������� ������� ��������
				// �� ������� ����� ����������� ������ � �������� � ���������
				// ������
				.authorizeRequests().antMatchers("/resources/**", "/**").permitAll().anyRequest().permitAll().and();

		http.formLogin()
				// ��������� �������� � ������ ������
				.loginPage("/login")
				// ��������� action � ����� ������
				.loginProcessingUrl("/j_spring_security_check")
				// ��������� URL ��� ��������� ������
				.failureUrl("/login?error")
				// ��������� ��������� ������ � ������ � ����� ������
				.usernameParameter("j_username").passwordParameter("j_password")
				// ���� ������ � ����� ������ ����
				.permitAll();

		http.logout()
				// ��������� ������ ������ ����
				.permitAll()
				// ��������� URL �������
				.logoutUrl("/logout")
				// ��������� URL ��� ������� �������
				.logoutSuccessUrl("/login?logout")
				// ������ �� �������� ������� ������
				.invalidateHttpSession(true);

	}

	@Bean
	public ShaPasswordEncoder getShaPasswordEncoder() {
		return new ShaPasswordEncoder();
	}

}
