package unibuc.lab.homework.services;

import org.springframework.stereotype.Service;
import unibuc.lab.homework.model.Product;

import java.util.List;

public interface ProductService {

    void addProduct(Product product);

    List<Product> getProducts();
}
