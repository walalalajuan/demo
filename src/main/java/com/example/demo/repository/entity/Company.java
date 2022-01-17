package com.example.demo.repository.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Alan.Juan
 *
 */

@Entity
@Table(name = "company")
@DynamicUpdate
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "created_by", updatable = false)
    private String created_by;
    
    @Column(name = "created_at", updatable = false)
    private ZonedDateTime created_at;
    
    @Column(name = "updated_by")
    private String updated_by;
    
    @Column(name = "updated_at")
    private ZonedDateTime updated_at;

}
