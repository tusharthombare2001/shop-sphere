package ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ecommerce.entity.Product;
import ecommerce.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping("/getProduct")
	public List<Product> getProducts() {
		return productService.getAllProducts();
	}

	@DeleteMapping("/{id}")
	public String deleteProduct(@PathVariable int id) {
		if (productService.existsById(id)) {
			productService.deleteProduct(id);
			return "Product Deleted Successfully";
		} else {
			return "Product Dosent Exists";
		}
	}

	@PostMapping("/saveProduct")
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
		Product product = productService.updateProduct(id, updatedProduct);
		return ResponseEntity.ok(product); // 200 OK with updated product
	}

}
