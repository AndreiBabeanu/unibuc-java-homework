package unibuc.lab.homework.repositories;

import org.springframework.stereotype.Repository;
import unibuc.lab.homework.model.Product;

import java.util.List;


public interface ProductRepository {

    List<Product> findAll();

    void insert(Product product);


}
