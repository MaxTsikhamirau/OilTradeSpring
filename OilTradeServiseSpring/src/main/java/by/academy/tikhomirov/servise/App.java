//package by.academy.tikhomirov.servise;
//
//import java.util.Iterator;
//import java.util.List;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import by.academy.tikhomirov.dao.config.DataConfig;
//import by.academy.tikhomirov.pojos.User;
//import by.academy.tikhomirov.servise.config.Beans;
//import by.academy.tikhomirov.servise.impl.OfferServiseImpl;
//import by.academy.tikhomirov.servise.impl.UserServiseImpl;
//import by.academy.tikhomirov.servise.interf.OfferServise;
//import by.academy.tikhomirov.servise.interf.UserServise;
//import by.academy.tikhomirov.vo.OfferVO;
//import by.academy.tikhomirov.vo.SortVO;
//import by.academy.tikhomirov.vo.UserVO;
//
//
//
//public class App 
//{
//    public static void main( String[] args )
//    {
//    	 ApplicationContext context = new
//    			 AnnotationConfigApplicationContext(DataConfig.class,Beans.class);
//    	UserServise userBean=(context.getBean(UserServise.class));
//    	 UserVO userVO = new UserVO("night", "NIGHT", " morning",
// "day", "evening", "telephone");
//    	 userBean.add(userVO);
////    			// UserServise bean = context.getBean(UserServiseImpl.class);
////    			// RoleServise roleBean=context.getBean(RoleServiseImpl.class);
////    			// UserVO userVO = new UserVO("Gabriel", "NEWLOGIN", " password",
////    			// "city", "country", "telephone");
////    			//
////    			// userVO.setUser_id(123);
////
//////    			 UserVO authUser=userBean.getAuthorizedUser("minimus", "lloid");
//////    			 System.out.println("auth user: "+authUser);
////    			// RoleVO roleVO=new RoleVO();
////    			// roleVO.setRole_id(1);
////    			// System.out.println(authUser.getRolesVO());
////    			//
////    			// bean.addUserRole(authUser, roleVO);
////    			//
////    			// bean.editUser(userVO);
////
////    			// Set<RoleVO> rolesVO = new HashSet<>();
////    			// RoleVO roleVO = new RoleVO("admin");
////    			// rolesVO.add(roleVO);
////    			// userVO.setRolesVO(rolesVO);
////    			// System.out.println("Authorized User: " +
////    			// bean.getAuthorizedUser("minimus", "lloid"));
////    			// System.out.println("All users: "+bean.getAll());
////
////    			// System.out.println("before delete");
////    			// bean.delete(115);
////    			// System.out.println("deleted");
////    			// bean.add(userVO);
////    			// userVO = new UserVO("Gabriel", "login", " password", "city",
////    			// "country", "telephone");
////
////    			// System.out.println(bean.existsByUserLoginAndPassword(userVO.getLogin(),userVO.getPassword()));
////
////    			// Add offer block
////    			 OfferServise offerBean=context.getBean(OfferServiseImpl.class);
////    			 OfferVO offerVO=new OfferVO();
////    			 UserVO userVO=new UserVO();
////    			 userVO.setUser_id(56);
////    			 SortVO sortVO=new SortVO();
////    			 sortVO.setSort_name("Brent");
////    			 offerVO.setPrice(666);
////    			 offerVO.setQuantity(999);
////    			 offerVO.setSortVO(sortVO);
////    			 offerVO.setUserVO(userVO);
////    			 offerBean.add(offerVO);
////    			// End of Add offer block
////
////    			// Get all offers block
////    			// OfferServise offerBean=context.getBean(OfferServiseImpl.class);
//////    			 System.out.println(offerBean.getOffersByUserId(3));
//////    			 System.out.println(offerBean.getAppropriateOffers("Brent", 5,
//////    			 150));
////    			//// Editing offer block
////    			// OfferVO offerVO=new OfferVO(2, 200, 220);
////    			// SortVO sortVO=new SortVO(1, "WTI");
////    			// offerVO.setSortVO(sortVO);
////    			// offerBean.edit(offerVO);
////    			// }
//////    	}
////    	
//    }
//}
