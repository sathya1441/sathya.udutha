package com.satya.springecom.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satya.springecom.Models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
