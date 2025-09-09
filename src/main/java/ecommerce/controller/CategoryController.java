package ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.entity.Category;
import ecommerce.service.CategoryService;

@RestController
@RequestMapping("/Category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/saveCategory")
	public Category SaveCategory(@RequestBody Category category) {
		return categoryService.saveCategory(category);
	}
	
	@GetMapping("/getCategory")
	public List<Category> getallcategory(){
		return categoryService.getAll();
		
	}
	
	@GetMapping("/getCategory/{id}")
	public Category getByIdCa(@PathVariable int id){
		return categoryService.getById(id);
	}
	
	@DeleteMapping("/deleteCategory/{id}")
	public String deleteCategory(@PathVariable int id) {
		if(categoryService.existById(id)) {
			categoryService.delete(id);
			return "category delted successfully";
		}
		return "product not exist";
	}
	
	
	
	
	
	

}
