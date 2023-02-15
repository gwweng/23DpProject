package builder;

import java.math.BigDecimal;

// 简单对象的建造者模式
public class SimpleBuilder {
    public static void main(String[] args) {
        Product product = Product.builder().name("汽车").size(10).price(BigDecimal.TEN).build();
        System.out.println(product);
    }

}


class Product {
    private String name;
    private Integer size;
    private BigDecimal price;

    public Product(String name, Integer size, BigDecimal price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    public static Builder builder(){
        return new Builder();
    }


    static class Builder {
        private String name;
        private Integer size;
        private BigDecimal price;

        public Builder name(String name) {
            this.name = name;
            return this;
        }


        public Builder size(Integer size) {
            this.size = size;
            return this;
        }

        public Builder price(BigDecimal price) {
            this.price = price;
            return this;
        }


        public Product build(){
            return new Product(this.name, this.size, this.price);
        }

    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}

