package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.repository.entity.Company;

/**
 * @author Alan.Juan
 *
 */
@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
