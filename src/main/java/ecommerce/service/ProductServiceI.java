package ecommerce.service;

import java.util.List;

import ecommerce.entity.Product;

public interface ProductServiceI {
	  Product saveProduct(Product product);
	    Product getProductById(int id);
	    List<Product> getAllProducts();
	    void deleteProduct(int id);
	    boolean existsById(int id);
	    Product updateProduct(int id, Product updatedProduct);

}
