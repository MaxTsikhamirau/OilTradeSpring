package by.academy.tikhomirov.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import by.academy.tikhomirov.pojos.Offer;


public interface OfferRepository extends JpaRepository<Offer, Integer> {

	@Query("select o from Offer o where o.sort.sort_name= :sort_name and o.quantity>=:quantity and o.price<=:price")
	List<Offer> getAppropriateOffers(@Param("sort_name") String sort_name, @Param("quantity") int quantity,
			@Param("price") int price);

	@Query("select o from Offer o where o.user.user_id= :user_id")
	List<Offer> getOffersByUserId(@Param("user_id") int user_id);

}
