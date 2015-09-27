package by.academy.tikhomirov.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.academy.tikhomirov.pojos.Offer;

public interface OfferRepository extends JpaRepository<Offer, Integer> {

}
