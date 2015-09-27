package by.academy.tikhomirov.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import by.academy.tikhomirov.pojos.Sort;

public interface SortRepository extends JpaRepository<Sort, Integer> {
	
	@Query("SELECT CASE WHEN COUNT(s) > 0 THEN true ELSE false END FROM Sort s WHERE s.sort_name = :sort_name")
	boolean existsBySortName(@Param("sort_name")String sort_name);
	
	@Query("select s from Sort s where s.sort_name = :sort_name")
	Sort getSortByName(@Param("sort_name")String sort_name);
	
}
