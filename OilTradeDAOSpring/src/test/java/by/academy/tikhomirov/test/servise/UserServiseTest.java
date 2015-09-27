package by.academy.tikhomirov.test.servise;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//import org.springframework.test.context.web.WebAppConfiguration;

import by.academy.tikhomirov.config.Beans;
import by.academy.tikhomirov.config.TestDataBaseConfig;
import by.academy.tikhomirov.repository.UserRepository;
import by.academy.tikhomirov.servise.interf.UserServise;
import by.academy.tikhomirov.vo.RoleVO;
import by.academy.tikhomirov.vo.UserVO;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

@DirtiesContext
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestDataBaseConfig.class, Beans.class})
//@WebAppConfiguration
public class UserServiseTest {

	 @Resource
	    private EntityManagerFactory emf;
	    private EntityManager em;
	 
	    @Resource
	    private UserServise userServise;
	    
	 
	    @Before
	    public void setUp() throws Exception {
	        em = emf.createEntityManager();
	    }
	 
	    @Test
	    public void testAddUser() throws Exception {
	    	UserVO userVO=new UserVO("sdsd", "qqqq", "*****", "hyaat","China", "999");
	    	//userVO.setCity("Belgium");
	    	Set<RoleVO>rolesVO=new HashSet<>();
	        RoleVO roleVO=new RoleVO("admin");
	        rolesVO.add(roleVO);
	        userVO.setRolesVO(rolesVO);
	        userServise.add(userVO);
	    }
	    
	    @Test
	    public void testUser() throws Exception {
	    	UserVO userVO=new UserVO("sdsd", "qqqq", "*****", "hyaat","China", "999");
	    	//userVO.setCity("Belgium");
	    	Set<RoleVO>rolesVO=new HashSet<>();
	        RoleVO roleVO=new RoleVO("admin");
	        rolesVO.add(roleVO);
	        userVO.setRolesVO(rolesVO);
	        userServise.add(userVO);
	    }
	}
