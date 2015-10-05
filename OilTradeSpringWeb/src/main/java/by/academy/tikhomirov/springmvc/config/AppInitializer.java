package by.academy.tikhomirov.springmvc.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import by.academy.tikhomirov.dao.config.DataConfig;
import by.academy.tikhomirov.servise.config.Beans;
import by.academy.tikhomirov.servise.interf.UserServise;
import by.academy.tikhomirov.vo.UserVO;



public class AppInitializer implements WebApplicationInitializer {
	
	@Autowired
	private UserServise userServise;
	private static final Logger logger = Logger.getLogger(AppInitializer.class.getName());

	public void onStartup(ServletContext container) throws ServletException {
		logger.info("Start AppInitializer");
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.register(AppConfig.class);
		ctx.register(Beans.class);
		ctx.register(DataConfig.class);
	ctx.register(SecurityConfig.class);
		ctx.setServletContext(container);
		container.addListener(new ContextLoaderListener(ctx));

		ServletRegistration.Dynamic servlet = container.addServlet("dispatcher", new DispatcherServlet(ctx));

		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
		
		//userServise.add(new UserVO("rest", "rest", "rest", "rest", "rest", "rest"));
		
		logger.info("End AppInitializer");
	}

}
