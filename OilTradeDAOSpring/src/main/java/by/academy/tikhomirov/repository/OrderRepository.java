package by.academy.tikhomirov.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import by.academy.tikhomirov.pojos.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
