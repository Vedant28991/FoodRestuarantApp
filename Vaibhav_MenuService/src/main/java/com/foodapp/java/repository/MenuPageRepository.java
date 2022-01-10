package com.foodapp.java.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.foodapp.java.entity.Menu;

@Repository
public interface MenuPageRepository extends PagingAndSortingRepository<Menu, Integer> {

}
