package by.academy.tikhomirov;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import by.academy.tikhomirov.config.Beans;
import by.academy.tikhomirov.config.DataConfig;
import by.academy.tikhomirov.pojos.User;
import by.academy.tikhomirov.servise.impl.RoleServiseImpl;
import by.academy.tikhomirov.servise.impl.UserServiseImpl;
import by.academy.tikhomirov.servise.interf.RoleServise;
import by.academy.tikhomirov.servise.interf.UserServise;
import by.academy.tikhomirov.vo.RoleVO;
import by.academy.tikhomirov.vo.UserVO;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class, Beans.class);
		UserServise bean = context.getBean(UserServiseImpl.class);
		RoleServise roleBean=context.getBean(RoleServiseImpl.class);
//		UserVO userVO = new UserVO("Gabriel", "NEWLOGIN", " password", "city", "country", "telephone");
//		
//		userVO.setUser_id(123);
		
		
		UserVO authUser=bean.getAuthorizedUser("alex", "alex123");
		System.out.println("auth user: "+authUser);
		RoleVO roleVO=new RoleVO("admin");
		roleVO.setRole_id(3);
		System.out.println(authUser.getRolesVO());
		
		bean.addUserRole(authUser, roleVO);
		
		//bean.editUser(userVO);
		
		
		
//		Set<RoleVO> rolesVO = new HashSet<>();
//		RoleVO roleVO = new RoleVO("admin");
//		rolesVO.add(roleVO);
//		userVO.setRolesVO(rolesVO);
//		System.out.println("Authorized User: " + bean.getAuthorizedUser("minimus", "lloid"));
//		System.out.println("All users: "+bean.getAll());
		
		
		
//		System.out.println("before delete");
//		bean.delete(115);
//		System.out.println("deleted");
		// bean.add(userVO);
		//userVO = new UserVO("Gabriel", "login", " password", "city", "country", "telephone");
		
		//System.out.println(bean.existsByUserLoginAndPassword(userVO.getLogin(),userVO.getPassword()));

	}
}
