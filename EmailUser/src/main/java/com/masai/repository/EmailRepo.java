package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Email;
@Repository
public interface EmailRepo  extends JpaRepository<Email, Integer>{

}
