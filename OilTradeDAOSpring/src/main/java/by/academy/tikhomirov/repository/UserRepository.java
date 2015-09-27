package by.academy.tikhomirov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import by.academy.tikhomirov.pojos.Role;
import by.academy.tikhomirov.pojos.User;
import by.academy.tikhomirov.vo.RoleVO;

public interface UserRepository extends JpaRepository<User, Integer> {
	@Query("select u from User u where u.login = :login and u.password=:password")
	User getAuthorizedUser(@Param("login") String login, @Param("password") String password);

	@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM User u WHERE u.login = :login and u.password=:password")
	boolean existsByUserLoginAndPassword(@Param("login") String login, @Param("password") String password);

	
}
