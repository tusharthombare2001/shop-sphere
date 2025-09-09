package ecommerce.service;

import java.util.List;

import ecommerce.entity.Category;

public interface CategoryI {
	Category saveCategory(Category category);

	List<Category> getAll();

	Category getById(int id);

	void delete(int id);
	Boolean existById(int id);

}
