package by.academy.tikhomirov.servise.interf;

import by.academy.tikhomirov.pojos.Sort;
import by.academy.tikhomirov.vo.SortVO;

public interface SortServise {
	void add(SortVO sortVO);

	boolean existsBySortName(String sort_name);
	
	Sort findByName(String sort_name);

}
