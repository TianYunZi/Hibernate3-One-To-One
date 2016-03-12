package org.ahhn.com.manytomany;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by XJX on 2016/3/12.
 */
public class Item {
	private Integer id;
	private String name;

	private Set<Catagory> catagories = new HashSet<Catagory>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Catagory> getCatagories() {
		return catagories;
	}

	public void setCatagories(Set<Catagory> catagories) {
		this.catagories = catagories;
	}
}
