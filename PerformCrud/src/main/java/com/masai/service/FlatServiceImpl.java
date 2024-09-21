package com.masai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.FlatException;
import com.masai.model.Flat;
import com.masai.model.repository.FlatRepo;

@Service
public class FlatServiceImpl implements FlatService {
	@Autowired
	private FlatRepo fRepo;

	@Override
	public Flat addFlat(Flat flat) {
		return fRepo.save(flat);

	}

	@Override
	public Flat deleteFlat(int id) {

		Flat flatp = fRepo.findById(id).orElseThrow(() -> new FlatException("No flat is present with this id"));

		fRepo.delete(flatp);
		return flatp;

	}

	@Override
	public Flat updateFlat(int id, Flat updateFlat) {
		Flat ExistingFlat = fRepo.findById(id).orElseThrow(() -> new FlatException("No flat is present "));

		ExistingFlat.setBuildingName(updateFlat.getBuildingName());
		ExistingFlat.setNoOfRooms(updateFlat.getNoOfRooms());
		ExistingFlat.setDate_of_manufacturing(updateFlat.getDate_of_manufacturing());
		ExistingFlat.setType(updateFlat.getType());
		ExistingFlat.setPrice(updateFlat.getPrice());
		ExistingFlat.setDescription(updateFlat.getDescription());

		return fRepo.save(ExistingFlat);

	}

	@Override
	public List<Flat> getAllFlat() {
		return fRepo.findAll();
	}

	@Override
	public List<Flat> findFlatByPriceLessThan(int price) {

		return fRepo.findByPriceLessThan(price);
	}

	@Override
	public List<Flat> findFlatByPriceLessThanEqualTo(int price) {
		// TODO Auto-generated method stub
		return fRepo.findByPriceLessThanEqual(price);
	}

	@Override
	public List<Flat> findFlatByPriceGreaterThan(int price) {
	return fRepo.findByPriceGreaterThan(price);
	}

	@Override
	public List<Flat> findFlatByPriceBetween(int s_price, int e_price) {
		// TODO Auto-generated method stub
		return fRepo.findByPriceBetween(s_price, e_price);
	}

}
