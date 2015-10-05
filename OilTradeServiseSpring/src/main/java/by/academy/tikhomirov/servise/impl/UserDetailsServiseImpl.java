package by.academy.tikhomirov.servise.impl;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import by.academy.tikhomirov.pojos.Role;
import by.academy.tikhomirov.pojos.User;
import by.academy.tikhomirov.servise.interf.UserServise;
import by.academy.tikhomirov.vo.RoleVO;
import by.academy.tikhomirov.vo.UserVO;

@Service
public class UserDetailsServiseImpl implements UserDetailsService {
	
	@Autowired
    private UserServise userServise;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		
		return (UserDetails) userServise.getAuthorizedUser(login);
		
		
	}

}
