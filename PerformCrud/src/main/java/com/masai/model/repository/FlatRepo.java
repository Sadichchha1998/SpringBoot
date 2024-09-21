package com.masai.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Flat;

@Repository
public interface FlatRepo extends JpaRepository<Flat, Integer> {

	 	

	 	 // Flats with price less than the specified value
	     List<Flat> findByPriceLessThan(int price);

	     // Flats with price less than or equal to the specified value
	     List<Flat> findByPriceLessThanEqual(int price);

	     // Flats with price greater than the specified value
	     List<Flat> findByPriceGreaterThan(int price);

	     // Flats with price between start and end values
	     List<Flat> findByPriceBetween(int startPrice, int endPrice);

}
