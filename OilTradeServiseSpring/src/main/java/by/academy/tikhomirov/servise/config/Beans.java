package by.academy.tikhomirov.servise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import by.academy.tikhomirov.dao.config.DataConfig;
import by.academy.tikhomirov.servise.impl.OfferServiseImpl;
import by.academy.tikhomirov.servise.impl.RoleServiseImpl;
import by.academy.tikhomirov.servise.impl.SortServiseImpl;
import by.academy.tikhomirov.servise.impl.UserDetailsServiseImpl;
import by.academy.tikhomirov.servise.impl.UserServiseImpl;
import by.academy.tikhomirov.servise.interf.OfferServise;
import by.academy.tikhomirov.servise.interf.RoleServise;
import by.academy.tikhomirov.servise.interf.SortServise;
import by.academy.tikhomirov.servise.interf.UserServise;

@Configuration
@ComponentScan(basePackages = {"by.academy.tikhomirov.servise"})
@Import(DataConfig.class)
public class Beans {
	@Bean
	public UserServise userServise() {
		return new UserServiseImpl();
	}
	@Bean
	public OfferServise offerServise() {
		return new OfferServiseImpl();
	}
	@Bean
	public SortServise sortServise() {
		return new SortServiseImpl();
	}
	@Bean
	public RoleServise roleServise() {
		return new RoleServiseImpl();
	}
	@Bean
	public UserDetailsService getUserDetailsServise(){
	    return new UserDetailsServiseImpl();
	}
}
