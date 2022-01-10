package com.foodapp.java.entity;

import java.util.ArrayList;
import java.util.List;

public class Menus {

	private List<Menu> menuList;

	public List<Menu> getMenuList() {
		   if(menuList == null) {
			   menuList = new ArrayList<>();
	        }
		return menuList;
	}

	public void setMenuList(List<Menu> menuList) {
		this.menuList = menuList;
	}
	
}
