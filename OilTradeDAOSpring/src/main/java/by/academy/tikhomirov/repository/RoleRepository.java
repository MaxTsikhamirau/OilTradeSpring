package by.academy.tikhomirov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import by.academy.tikhomirov.pojos.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
	@Query("select r from Role r where r.role_id = :id")
	Role getRoleById(@Param("id") int id);
}
