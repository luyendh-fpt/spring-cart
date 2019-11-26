package aptech.fpt.springcart.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private double price;
    private int status;

    public Product() {
        this.status = 1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }


    public static final class Builder {
        private String name;
        private double price;

        private Builder() {
        }

        public static Builder aProduct() {
            return new Builder();
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPrice(double price) {
            this.price = price;
            return this;
        }

        public Product build() {
            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
            return product;
        }
    }
}
