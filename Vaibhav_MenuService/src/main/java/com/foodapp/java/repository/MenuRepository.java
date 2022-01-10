package com.foodapp.java.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.foodapp.java.dto.MenuRequestDto;
import com.foodapp.java.dto.MenuResponseProjection;
import com.foodapp.java.entity.Menu;


@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer>{

	List<MenuResponseProjection> findByFoodNameContaining(String foodName);

}
