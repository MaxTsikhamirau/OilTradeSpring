package by.academy.tikhomirov.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import by.academy.tikhomirov.servise.impl.RoleServiseImpl;
import by.academy.tikhomirov.servise.impl.UserServiseImpl;
import by.academy.tikhomirov.servise.interf.RoleServise;
import by.academy.tikhomirov.servise.interf.UserServise;

@Configuration
public class Beans {
	@Bean
	public UserServise userServise() {
		return new UserServiseImpl();
	}
	@Bean
	public RoleServise roleServise() {
		return new RoleServiseImpl();
	}
}
