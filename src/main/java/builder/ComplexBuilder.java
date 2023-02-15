package builder;

import java.math.BigDecimal;

// 封装复杂对象的创建过程
public class ComplexBuilder {

    public static void main(String[] args) {
        ProductBuilder productBuilder = new DefaultProductBuilder();
        Director director = new Director(productBuilder);
        ComplexProduct product = director.makeProduct("复杂产品", 100, new BigDecimal(1000));
        System.out.println(product);
    }
}


class ComplexProduct {

    private String name;
    private Integer size;
    private BigDecimal price;

    public ComplexProduct(String name, Integer size, BigDecimal price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    @Override
    public String toString() {
        return "ComplexProduct{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", price=" + price +
                '}';
    }
}



interface ProductBuilder {
    void buildName(String name);

    void buildSize(Integer size);

    void buildPrice(BigDecimal price);

    ComplexProduct build();
}


class DefaultProductBuilder implements ProductBuilder {

    private String name;
    private Integer size;
    private BigDecimal price;



    @Override
    public void buildName(String name) {
        this.name = name;
    }

    @Override
    public void buildSize(Integer size) {
        this.size = size;

    }

    @Override
    public void buildPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public ComplexProduct build() {
        return new ComplexProduct(this.name, this.size, this.price);
    }
}

class Director {

    private ProductBuilder builder;

    public Director(ProductBuilder builder) {
        this.builder = builder;
    }

    public ComplexProduct makeProduct(String name, Integer size, BigDecimal price){
        builder.buildName(name);
        builder.buildSize(size);
        builder.buildPrice(price);

        ComplexProduct product = builder.build();
        return product;
    }
}


