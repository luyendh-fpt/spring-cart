package aptech.fpt.springcart.config;


import aptech.fpt.springcart.entity.Product;
import aptech.fpt.springcart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Component
public class Seeding implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger LOGGER = Logger.getLogger(Seeding.class.getSimpleName());

    @Autowired
    ProductRepository productRepository;


    private List<Product> products = new ArrayList<>();


    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        LOGGER.log(Level.INFO, String.format("Start seeding..."));
        productRepository.disableForeignKeyCheck();
        seedingProduct();
        productRepository.enableForeignKeyCheck();
        LOGGER.log(Level.INFO, String.format("Seeding success!"));
    }

    private void seedingProduct() {
        productRepository.deleteAll();
        productRepository.resetIncrement();

        products.add(Product.Builder.aProduct().withName("Product 01").withPrice(20000).build());
        products.add(Product.Builder.aProduct().withName("Product 02").withPrice(40000).build());
        products.add(Product.Builder.aProduct().withName("Product 03").withPrice(23000).build());
        products.add(Product.Builder.aProduct().withName("Product 04").withPrice(60000).build());
        products.add(Product.Builder.aProduct().withName("Product 05").withPrice(90000).build());
        products.add(Product.Builder.aProduct().withName("Product 06").withPrice(100000).build());
        products.add(Product.Builder.aProduct().withName("Product 07").withPrice(22000).build());
        products.add(Product.Builder.aProduct().withName("Product 08").withPrice(25000).build());
        products.add(Product.Builder.aProduct().withName("Product 09").withPrice(27000).build());
        products.add(Product.Builder.aProduct().withName("Product 10").withPrice(35000).build());

        productRepository.saveAll(products);
    }

}
