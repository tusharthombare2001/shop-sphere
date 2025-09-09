package ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.Repository.CategoryRepository;
import ecommerce.entity.Category;

@Service
public class CategoryService implements CategoryI {
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category saveCategory(Category category) {
		
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAll() {
	
		return categoryRepository.findAll();
	}

	
	@Override
	public Category getById(int id) {
	    return categoryRepository.findById((long) id)
	            .orElse(null); 
	}

	@Override
	public void delete(int id) {
		categoryRepository.deleteById((long) id); 	
	}

	@Override
	public Boolean existById(int id) {
		return categoryRepository.existsById((long) id);
	}

}
