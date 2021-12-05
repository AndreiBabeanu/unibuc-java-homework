package unibuc.lab.homework.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import unibuc.lab.homework.model.Product;
import unibuc.lab.homework.repositories.ProductRepoImpl;
import unibuc.lab.homework.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepo;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepo) {
        this.productRepo = productRepo;
    }

    @Override
    public void addProduct(Product product) {
        productRepo.insert(product);
    }

    @Override
    public List<Product> getProducts() {
        return productRepo.findAll();
    }
}
