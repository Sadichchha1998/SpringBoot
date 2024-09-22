package com.masai.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Generate unique IDs for email
    private int mailId;
    private String email;
    private Date createdDate;

    
    @OneToOne(mappedBy = "email") // `mappedBy` indicates this is the inverse side of the relationship
    private User user; // Reference to the User
}
