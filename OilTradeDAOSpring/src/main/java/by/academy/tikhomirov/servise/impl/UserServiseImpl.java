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
import org.apache.log4j.Logger;

@Service
public class UserServiseImpl implements UserServise {
	private static final Logger logger = Logger.getLogger(UserServiseImpl.class.getName());
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public void add(UserVO userVO) {
		logger.info("Start creating user: " + userVO);
		User user = transform(userVO);
		String login = user.getLogin();
		String password = user.getPassword();
		if (!existsByUserLoginAndPassword(login, password)) {
			logger.info("User to add doesn't exist. Start creating user");
			userRepository.saveAndFlush(user);
			logger.info("User: " + user + " was created");
		} else {
			logger.info("Can't create user. User already exists");
		}
	}

	private User transform(UserVO userVO) {
		logger.debug("Transformation userVO to user: start");
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
		logger.debug("Transformation userVO to user: complete");
		return user;
	}

	private Set<Role> transform(Set<RoleVO> rolesVO) {
		logger.debug("Transformation rolesVO to roles: start");
		Set<Role> roles = new HashSet<>();
		for (RoleVO r : rolesVO) {
			Role role = new Role();
			role.setRole_name(r.getRole_name());
			roles.add(role);
		}
		logger.debug("Transformation rolesVO to roles: complete");
		return roles;
	}

	@Override
	public List<UserVO> getAll() {
		logger.info("Getting list of users: start");
		List<User> users = new ArrayList<>();
		users = userRepository.findAll();
		List<UserVO> usersVO = extract(users);
		logger.info("Getting list of users: complete");
		return usersVO;
	}

	private List<UserVO> extract(List<User> users) {
		logger.debug("Extracting users to usersVO: start");
		List<UserVO> usersVO = new ArrayList<>();
		for (User user : users) {
			UserVO userVO = new UserVO();
			userVO = extract(user);
			usersVO.add(userVO);
		}
		logger.debug("Extracting users to usersVO: complete");
		return usersVO;
	}

	@Override
	public void delete(int id) {
		logger.info("Deleting user where user_id= " + id + " :start");
		userRepository.delete(id);
		logger.info("Deleting user where user_id= " + id + " :complete");
	}

	@Override
	public UserVO addUserRole(UserVO userVO, RoleVO roleVO) {
		logger.info("Adding a role: " + roleVO + " to user: " + userVO + " :start");
		User user = userRepository.findOne(userVO.getUser_id());
		Role role = roleRepository.findOne(roleVO.getRole_id());
		if (role != null) {
			Set<Role> roles = user.getRoles();
			roles.add(role);
			user.setRoles(roles);
		} else {
			logger.debug("Can't add a role: " + roleVO + " to user: " + userVO + " :role doesn't exist");
		}
		UserVO editedUserVO = extract(user);
		userRepository.saveAndFlush(user);
		logger.info("Adding a role: " + roleVO + " to user: " + userVO + " :complete. Edited user: " + editedUserVO);
		return editedUserVO;
	}

	@Override
	public UserVO getAuthorizedUser(String login, String password) {
		logger.info("Getting user with login: " + login + " and password: " + password + " :start");
		User user = new User();
		UserVO userVO = null;
		user = userRepository.getAuthorizedUser(login, password);
		if (user != null) {
			userVO = extract(user);
		} else {
			logger.debug("Can't get user with login: " + login + " and password: " + password + " :user doesn't exist");
		}
		logger.info("Getting user with login: " + login + " and password: " + password + " :complete");
		return userVO;
	}

	private UserVO extract(User user) {
		logger.debug("Extracting user to userVO: start");
		UserVO userVO = new UserVO();
		userVO.setUser_id(user.getUser_id());
		userVO.setUser_name(user.getUser_name());
		userVO.setLogin(user.getLogin());
		userVO.setPassword(user.getPassword());
		userVO.setCity(user.getUserDetail().getCity());
		userVO.setCountry(user.getUserDetail().getCountry());
		userVO.setTelephone(user.getUserDetail().getTelephone());
		userVO.setRolesVO(extract(user.getRoles()));
		logger.debug("Extracting user to userVO: complete");
		return userVO;
	}

	private Set<RoleVO> extract(Set<Role> roles) {
		logger.debug("Extracting roles to rolesVO: start");
		Set<RoleVO> rolesVO = new HashSet<>();
		for (Role r : roles) {
			RoleVO roleVO = new RoleVO();
			roleVO.setRole_name(r.getRole_name());
			rolesVO.add(roleVO);
		}
		logger.debug("Extracting roles to rolesVO: complete");
		return rolesVO;
	}

	@Override
	public boolean existsByUserLoginAndPassword(String login, String password) {
		logger.info("Check if user with login: " + login + " and password: " + password + " exist");
		return userRepository.existsByUserLoginAndPassword(login, password);
	}

}
