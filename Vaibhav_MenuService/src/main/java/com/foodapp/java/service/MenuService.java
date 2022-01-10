package com.foodapp.java.service;

import java.util.List;

import com.foodapp.java.dto.MenuRequestDto;
import com.foodapp.java.dto.MenuResponseProjection;
import com.foodapp.java.entity.Menu;

public interface MenuService {

	List<Menu> getFoodItems();

	List<MenuResponseProjection> searchFood(String foodName);

	List<Menu> getFoodItemsPerPage(Integer pageNo, Integer pageSize);

	

}
