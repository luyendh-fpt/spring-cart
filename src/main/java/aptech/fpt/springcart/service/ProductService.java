package aptech.fpt.springcart.service;

import aptech.fpt.springcart.entity.Product;
import aptech.fpt.springcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface ProductService {

    void save(Product product);

    Product getById(long id);

    List<Product> getList();

}
