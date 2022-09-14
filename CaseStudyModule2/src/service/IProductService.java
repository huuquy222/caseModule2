package service;

import model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProducts();

    void add(Product newProduct);

    void update();

    void update(Product newProduct);

    Product getProductById(int id);

    boolean exist(int id);

    boolean existById(int id);

    void updateQuantity(int id, int quantity);

    boolean checkDuplicateName(String name);

    boolean checkDuplicateId(int id);

    void removeById(int id);


    List<Product> findAllOrderByPriceASC();

    List<Product> findAllOrderByPriceDESC();

//    List<Product> findAllOrderByPriceDESC();
}
