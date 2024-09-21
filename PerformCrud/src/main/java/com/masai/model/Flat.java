package com.masai.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Flat {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int FlatId;

	private String BuildingName;

	private int NoOfRooms;
// (add validation no should be less than 10)
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate date_of_manufacturing;;

//LocalDate (JSON Format)
	@Enumerated(EnumType.STRING)
	private Facing type;
//(East, West, Nort, South)
	private int price;
	private String description;

}
