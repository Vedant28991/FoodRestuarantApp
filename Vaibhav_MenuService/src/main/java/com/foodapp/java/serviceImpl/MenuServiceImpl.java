package com.foodapp.java.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.foodapp.java.dto.MenuRequestDto;
import com.foodapp.java.dto.MenuResponseProjection;
import com.foodapp.java.entity.Menu;
import com.foodapp.java.exception.SelfMadeExceptions;
import com.foodapp.java.repository.MenuPageRepository;
import com.foodapp.java.repository.MenuRepository;
import com.foodapp.java.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {

	@Autowired
	MenuRepository menuRepo;
	
	@Autowired
	MenuPageRepository repository;

	@Override
	public List<Menu> getFoodItems() {
		
		

		List<Menu> foodItemList = new ArrayList<Menu>();
		Iterator<Menu> itt = menuRepo.findAll().iterator();
		while (itt.hasNext()) {
			Menu foodItems = new Menu();
			BeanUtils.copyProperties(itt.next(), foodItems);
			foodItemList.add(foodItems);
		}
		return foodItemList;

	}
	
	@Override
	public List<Menu> getFoodItemsPerPage(Integer pageNo, Integer pageSize)
    {
        Pageable paging = PageRequest.of(pageNo, pageSize);
 
        Page<Menu> pagedResult = repository.findAll(paging);
         
        if(pagedResult.hasContent()) {
            return pagedResult.getContent();
        } else {
            return new ArrayList<Menu>();
        }
    }
	

	@Override
	public List<MenuResponseProjection> searchFood(String foodName) {
		List<MenuResponseProjection> FoodList = menuRepo.findByFoodNameContaining(foodName);
        if(FoodList.isEmpty()) {throw new SelfMadeExceptions("No food with name "+foodName+" found");}
		return FoodList;
	}

	

}
