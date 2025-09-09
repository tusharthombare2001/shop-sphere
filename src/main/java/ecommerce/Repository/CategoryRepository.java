package ecommerce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ecommerce.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
