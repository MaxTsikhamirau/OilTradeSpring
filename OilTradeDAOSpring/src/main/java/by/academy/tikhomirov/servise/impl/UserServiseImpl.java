package by.academy.tikhomirov.servise.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.academy.tikhomirov.pojos.Role;
import by.academy.tikhomirov.pojos.User;
import by.academy.tikhomirov.pojos.UserDetail;
import by.academy.tikhomirov.repository.RoleRepository;
import by.academy.tikhomirov.repository.UserRepository;
import by.academy.tikhomirov.servise.interf.UserServise;
import by.academy.tikhomirov.vo.RoleVO;
import by.academy.tikhomirov.vo.UserVO;

@Service
public class UserServiseImpl implements UserServise {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void add(UserVO userVO) {
		System.out.println("userVO "+userVO);
		User user = transform(userVO);
		
		String login = user.getLogin();
		String password = user.getPassword();
		System.out.println("Login "+login);
		System.out.println("password "+password);
		if (!existsByUserLoginAndPassword(login, password)) {
			userRepository.saveAndFlush(user);
			System.out.println("User added");
		}
		else{System.out.println("User already exists");}
	}

	private User transform(UserVO userVO) {
		User user = new User();
		Set<Role> roles = new HashSet<>();
		Set<RoleVO> rolesVO = userVO.getRolesVO();
		if (rolesVO != null) {
			roles = transform(rolesVO);

		}
		user.setUser_name(userVO.getUser_name());
		user.setLogin(userVO.getLogin());
		user.setPassword(userVO.getPassword());
		UserDetail userDetail = new UserDetail();
		userDetail.setCity(userVO.getCity());
		userDetail.setCountry(userVO.getCountry());
		userDetail.setTelephone(userVO.getTelephone());
		userDetail.setUser(user);
		user.setUserDetail(userDetail);
		user.setRoles(roles);
		return user;
	}

	private Set<Role> transform(Set<RoleVO> rolesVO) {
		Set<Role> roles = new HashSet<>();
		for (RoleVO r : rolesVO) {
			Role role = new Role();
			role.setRole_name(r.getRole_name());
			roles.add(role);
		}
			return roles;
	}

	@Override
	public List<UserVO> getAll() {
		List<User> users = new ArrayList<>();
		users = userRepository.findAll();
		List<UserVO> usersVO = extract(users);
		return usersVO;
	}

	private List<UserVO> extract(List<User> users) {

		List<UserVO> usersVO = new ArrayList<>();
		for (User user : users) {
			UserVO userVO = new UserVO();
			userVO = extract(user);
			usersVO.add(userVO);
		}
		return usersVO;
	}

	@Override
	public void delete(int id) {
		// User user = transform(userVO);
		userRepository.delete(id);
	}

	@Override
	public UserVO addUserRole(UserVO userVO, RoleVO roleVO) {
		
		User user=userRepository.findOne(userVO.getUser_id());
		Role role=roleRepository.findOne(roleVO.getRole_id());
		user.getRoles().add(role);
		UserVO editedUserVO=extract(user);
		
//		System.out.println("RolesVO; "+ userVO.getRolesVO());
//		User user=userRepository.findOne(userVO.getUser_id());
//		user.setLogin(userVO.getLogin());
//		user.setRoles(transform(userVO.getRolesVO()));
//		UserVO editedUserVO=extract(user);
		userRepository.saveAndFlush(user);
		System.out.println(editedUserVO.getRolesVO());
		return editedUserVO;
	}

	@Override
	public UserVO getAuthorizedUser(String login, String password) {
		User user = new User();
		UserVO userVO = null;
		user = userRepository.getAuthorizedUser(login, password);
		if (user != null) {
			userVO = extract(user);
		}

		return userVO;
	}

	private UserVO extract(User user) {
		UserVO userVO = new UserVO();
		userVO.setUser_id(user.getUser_id());
		userVO.setUser_name(user.getUser_name());
		userVO.setLogin(user.getLogin());
		userVO.setPassword(user.getPassword());
		userVO.setCity(user.getUserDetail().getCity());
		userVO.setCountry(user.getUserDetail().getCountry());
		userVO.setTelephone(user.getUserDetail().getTelephone());
		userVO.setRolesVO(extract(user.getRoles()));
		return userVO;
	}

	private Set<RoleVO> extract(Set<Role> roles) {
		Set<RoleVO> rolesVO = new HashSet<>();
		for (Role r : roles) {
			RoleVO roleVO = new RoleVO();
			roleVO.setRole_name(r.getRole_name());
			rolesVO.add(roleVO);
		}
		return rolesVO;
	}

	@Override
	public boolean existsByUserLoginAndPassword(String login, String password) {
		// TODO Auto-generated method stub
		return userRepository.existsByUserLoginAndPassword(login, password);
	}

	

}
