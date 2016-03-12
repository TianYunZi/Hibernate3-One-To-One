package org.ahhn.com.manytomany;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by XJX on 2016/3/12.
 */
public class Catagory {
	private Integer id;
	private String name;

	private Set<Item> items=new HashSet<Item>();

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

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "Catagory{" +
				"id=" + id +
				", name='" + name + '\'' +
				", items=" + items +
				'}';
	}
}
