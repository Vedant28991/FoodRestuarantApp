package com.foodapp.java.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.mock;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.foodapp.java.controller.MenuController;
import com.foodapp.java.dto.MenuResponseProjection;
import com.foodapp.java.entity.Menu;
import com.foodapp.java.entity.Menus;
import com.foodapp.java.repository.MenuRepository;
import com.foodapp.java.serviceImpl.MenuServiceImpl;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class MenuTest {
	@Autowired
	Menu menu;

	@InjectMocks
	MenuServiceImpl menuServiceImpl;

	@Mock
	MenuController menuController;
	
	@Mock
	MenuRepository menuRepo;

	@BeforeEach
	public void setup() {
		menu = new Menu(101, "Wada", 40, "veg");
	}

	@AfterEach
	public void teardown() {
		menuRepo.deleteById(101);
	}

	@Test
	public void testgetFoodItems() {
		ResponseEntity list=new ResponseEntity<List<Menu>>(HttpStatus.ACCEPTED) ;
		when(menuController.getFoodItems()).thenReturn(list);
		ResponseEntity<List<Menu>> actualList=menuController.getFoodItems();
		assertEquals(list, actualList);
		}

	@Test
	public void testsearchFood() {
		Menu menu1 = new Menu(101, "Wada", 40, "veg");
		menuRepo.save(menu1);
		List<MenuResponseProjection> menuList = menuRepo.findByFoodNameContaining("Wada");
		assertEquals("menu1", menuList.get(0));
	}

}
