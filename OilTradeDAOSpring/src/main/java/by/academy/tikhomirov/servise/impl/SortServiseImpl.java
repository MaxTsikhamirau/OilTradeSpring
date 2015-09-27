package by.academy.tikhomirov.servise.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import by.academy.tikhomirov.pojos.Role;
import by.academy.tikhomirov.pojos.Sort;
import by.academy.tikhomirov.repository.RoleRepository;
import by.academy.tikhomirov.repository.SortRepository;
import by.academy.tikhomirov.servise.interf.RoleServise;
import by.academy.tikhomirov.servise.interf.SortServise;
import by.academy.tikhomirov.vo.RoleVO;
import by.academy.tikhomirov.vo.SortVO;

@Service
public class SortServiseImpl implements SortServise {
	@Autowired
	private SortRepository sortRepository;
	//@Override
//	public void add(RoleVO roleVO) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Role getRoleById(int id) {
//		// TODO Auto-generated method stub
//		return roleRepository.findOne(id);
//	}
//
//	@Override
//	public void add(SortVO sortVO) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public boolean existsBySortName(String sort_name) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public Sort getSortByName(String sort_name) {
		System.out.println("sortbY name "+sortRepository.getSortByName(sort_name));
		return sortRepository.getSortByName(sort_name);
	}
	@Override
	public void add(SortVO sortVO) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean existsBySortName(String sort_name) {
		// TODO Auto-generated method stub
		return false;
	}

}
