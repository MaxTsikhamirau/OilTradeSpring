package by.academy.tikhomirov.servise.interf;

import java.util.List;
import by.academy.tikhomirov.vo.OfferVO;


public interface OfferServise {

	List<OfferVO> getAppropriateOffers(String sort_name, int quantity, int price);

	List<OfferVO> getAll();

	List<OfferVO> getOffersByUserId(int user_id);

	void edit(OfferVO offerVO);
	
	void add(OfferVO offerVO);

}
