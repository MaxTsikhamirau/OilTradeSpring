package by.academy.tikhomirov.servise.interf;

import java.util.List;
import by.academy.tikhomirov.vo.RoleVO;
import by.academy.tikhomirov.vo.UserVO;

public interface UserServise {
	void add(UserVO userVO);

	List<UserVO> getAll();

	void delete(int id);

	UserVO addUserRole(UserVO userVO, RoleVO roleVO);

	UserVO getAuthorizedUser(String login);

	boolean existsByUserLoginAndPassword(String login, String password);

}
