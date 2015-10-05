package by.academy.tikhomirov.servise.interf;

import by.academy.tikhomirov.pojos.Role;
import by.academy.tikhomirov.vo.RoleVO;

public interface RoleServise {
	void add(RoleVO roleVO);

	Role getRoleById(int id);

}
