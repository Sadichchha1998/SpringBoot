package com.masai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Flat;
import com.masai.model.repository.FlatRepo;
import com.masai.service.FlatService;

@RestController
@RequestMapping("/api")
public class FlatController {
      @Autowired
	private FlatService fService;
      @Autowired
      private FlatRepo fRepo;
      
      /*
       {
  "buildingName": " Valley ap",
  "noOfRooms": 10,
  "date_of_manufacturing": "2023-05-14",
  "type":"SOUTH",
  "price": 100000,
  "description": "A beautiful 3-bedroom flat in a serene environment."
}

       */
      @PostMapping("/flat")
      public ResponseEntity<Flat>  AddFlat(@RequestBody Flat flat) {
    	  Flat fadd=  fService.addFlat(flat);
    	  return new ResponseEntity<Flat>(fadd,HttpStatus.CREATED);
    	  
      }
      
     @DeleteMapping("/flatdel/{id}") 
    public  ResponseEntity<Flat> DeleteFalt(@PathVariable("id") int id){
    	
   Flat delFlat	=  fService.deleteFlat(id);
   return new ResponseEntity<>(delFlat,HttpStatus.OK);
      }
    
     @PutMapping("/flatUp/{id}")
 public ResponseEntity<Flat>  UpdateFlat(@PathVariable ("id") int id , @RequestBody Flat flat ){
	
    Flat updateFlat= 	 fService.updateFlat(id, flat);
    return new ResponseEntity<Flat>(updateFlat,HttpStatus.OK);
 }
     @GetMapping("/getAll")
     public ResponseEntity<List<Flat>> getAllFlat(){
   List<Flat> getFlat	=  fService.getAllFlat();
    	return new ResponseEntity<List<Flat>>(getFlat,HttpStatus.OK);
     }
  
     @GetMapping("/flats/{Price}")
     public ResponseEntity<List<Flat>> getListOfFlatPriceLessThan(@RequestParam ("price") int price){
    	 List<Flat> flates=  fService.findFlatByPriceLessThan(price);
    	 return new ResponseEntity<List<Flat>>(flates,HttpStatus.OK);
     }
    @GetMapping("/getprice") 
   public ResponseEntity<List<Flat>>  findPriceLessThanOrEqualTo(@RequestParam ("price") int price){
    return new ResponseEntity<List<Flat>>(fService.findFlatByPriceLessThanEqualTo(price),HttpStatus.OK);	 
     }
    
    @GetMapping("/greterThan") 
    public ResponseEntity<List<Flat>>  findPricegreaterThan(@RequestParam ("price") int price){
     return new ResponseEntity<List<Flat>>(fService.findFlatByPriceGreaterThan(price),HttpStatus.OK);	 
      }
    @GetMapping("/getpbetween") 
    public ResponseEntity<List<Flat>>  findPriceLessInBetween(@RequestParam ("s_price") int s_price, @RequestParam ("e_price") int e_price){
     return new ResponseEntity<List<Flat>>(fService.findFlatByPriceBetween(s_price, e_price),HttpStatus.OK);	 
      }
}
