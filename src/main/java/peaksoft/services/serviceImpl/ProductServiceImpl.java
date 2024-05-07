package peaksoft.services.serviceImpl;

import peaksoft.dao.ProductDao;
import peaksoft.dao.daoImpl.ProductDaoImpl;
import peaksoft.models.Product;
import peaksoft.services.ProductService;

import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    ProductDao productDao = new ProductDaoImpl();

    @Override
    public void createProductTable() {
    productDao.createProductTable();
    }

    @Override
    public String addProduct(Product Product) {
        return productDao.addProduct(Product);
    }

    @Override
    public Product getProductById(Long id) {
        return productDao.getProductById(id);
    }

    @Override
    public String updateProductPhoneNumber(Long id, Product newProduct) {
        return productDao.updateProductPhoneNumber(id,newProduct);
    }

    @Override
    public void deleteProductById(Long id) {
        productDao.deleteProductById(id);

    }

    @Override
    public List<Product> getLowRatingProducts() {
        return productDao.getLowRatingProducts();
    }

    @Override
    public Map<Integer, Product> getProductsWithPriceRange(double min_price, double max_price) {
        return productDao.getProductsWithPriceRange(min_price,max_price);
    }
}
