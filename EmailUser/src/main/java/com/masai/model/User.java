package com.masai.model;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String phoneNo;
    @Past
    private Date dateOfBirth;

    //please check mapping onece program is working fine
    
    @OneToOne(cascade = CascadeType.ALL) // Cascade will handle operations on Email automatically
   // @JoinColumn(name = "email_id") // Create a foreign key column `email_id` in User table
    private Email email; 
}
