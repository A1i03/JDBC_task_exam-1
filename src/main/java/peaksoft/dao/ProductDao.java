package peaksoft.dao;

import peaksoft.models.Product;

import java.util.Map;

public interface ProductDao {
    void createProductTable();
    String addProduct(Product Product);
    Product getProductById(Long id);
    String updateProductPhoneNumber(Long id, Product newProduct );
    void deleteProductById(Long id);
    Product getLowRatingProducts(Long id);
    Map<Integer,Product> getProductsWithPriceRange(double min_price, double max_price);

}
