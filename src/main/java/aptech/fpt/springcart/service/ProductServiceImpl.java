package aptech.fpt.springcart.service;

import aptech.fpt.springcart.entity.Product;
import aptech.fpt.springcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product getById(long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getList() {
        return productRepository.findAll();
    }

}
