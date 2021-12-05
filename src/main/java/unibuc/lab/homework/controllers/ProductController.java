package unibuc.lab.homework.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import unibuc.lab.homework.model.Product;
import unibuc.lab.homework.services.ProductService;

@Controller
@RequestMapping("/")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/")
    public String addProduct(
            @RequestParam("name") String name,
            @RequestParam("price") Long price,
            @RequestParam("inStock") boolean inStock,
            Model model){
        Product product = new Product(null, name, price, inStock);
        productService.addProduct(product);
        model.addAttribute("products", productService.getProducts());
        return "index";
    }

    @GetMapping("/")
    public String getProducts(Model model){
        model.addAttribute("products", productService.getProducts());
        return "index";
    }
}
