package ecommerce.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ecommerce.Repository.ProductRepository;
import ecommerce.entity.Product;

@Service
public class ProductService implements ProductServiceI {

	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product saveProduct(Product product) {

		return productRepository.save(product);
	}

	@Override
	public Product getProductById(int id) {
		return productRepository.findById((long) id).orElse(null);
	}

	@Override
	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	@Override
	public void deleteProduct(int id) {
		productRepository.deleteById((long) id);
	}

	@Override
	public boolean existsById(int id) {
		return productRepository.existsById((long) id);
	}

	@Override
	public Product updateProduct(int id, Product updatedProduct) {
		return productRepository.findById((long) id).map(existingProduct -> {
			// update fields here
			existingProduct.setName(updatedProduct.getName());
			existingProduct.setPrice(updatedProduct.getPrice());

			return productRepository.save(existingProduct);
		}).orElse(null);
	}

}
