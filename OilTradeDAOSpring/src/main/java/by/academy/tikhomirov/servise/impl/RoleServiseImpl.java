package by.academy.tikhomirov.servise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.academy.tikhomirov.pojos.Role;
import by.academy.tikhomirov.repository.RoleRepository;
import by.academy.tikhomirov.servise.interf.RoleServise;
import by.academy.tikhomirov.vo.RoleVO;

@Service
public class RoleServiseImpl implements RoleServise {
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public void add(RoleVO roleVO) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Role getRoleById(int id) {
		// TODO Auto-generated method stub
		return roleRepository.findOne(id);
	}

}
