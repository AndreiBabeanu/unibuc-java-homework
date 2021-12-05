package unibuc.lab.homework.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import unibuc.lab.homework.model.Product;

import java.util.List;
import java.util.UUID;

@Repository
public class ProductRepoImpl implements ProductRepository{

    @Autowired
    private final JdbcTemplate jdbcTemplate;


    public ProductRepoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> findAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            String id = rs.getString("id");
            String name = rs.getString("name");
            Long price = rs.getLong("price");
            boolean inStock = rs.getBoolean("in_stock");
            return new Product(id, name, price, inStock);
        });
    }

    @Override
    public void insert(Product product) {
        String sql = "INSERT INTO products (id,  name, price, in_stock) VALUES (?,?,?,?)";
        product.setId(UUID.randomUUID().toString());
        int inStock;
        if (product.isInStock())
            inStock = 1;
        else inStock = 0;
        jdbcTemplate.update(sql, product.getId(), product.getName(), product.getPrice(), inStock);

    }
}
