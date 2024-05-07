package peaksoft.services;

import peaksoft.models.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    void createProductTable();
    String addProduct(Product Product);
    Product getProductById(Long id);
    String updateProductPhoneNumber(Long id, Product newProduct );
    void deleteProductById(Long id);
    List<Product> getLowRatingProducts();
    Map<Integer,Product> getProductsWithPriceRange(double min_price, double max_price);

}
