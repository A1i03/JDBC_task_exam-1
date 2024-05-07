package peaksoft.dao.daoImpl;

import peaksoft.config.DataBaseJdbc;
import peaksoft.dao.ProductDao;
import peaksoft.models.Product;

import java.sql.*;
import java.util.HashMap;
import java.util.Map;

public class  ProductDaoImpl implements ProductDao  {
    private final Connection connection = DataBaseJdbc.getConnection();

    @Override
    public void createProductTable() {
    String sql = """
            create table if not exists products(
            id serial primary key,
            name   varchar,
            rating varchar,
            price int)
            """;
    try (Statement statement = connection.createStatement()) {
        statement.executeUpdate(sql);
    }catch (SQLException e){
        System.out.println(e.getMessage());
        }
    }

    @Override
    public String addProduct(Product Product) {
        String sql = """
                insert into products(name,rating,price)
                values(?,?,?)
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setString(1,Product.getName());
            preparedStatement.setString(2,Product.getRating());
            preparedStatement.setInt(3,Product.getPrice());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error: "+e.getMessage());
        }
        return null;
    }

    @Override
    public Product getProductById(Long id) {
        Product product = new Product();
        String sql = "select * from products where id=?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setRating(resultSet.getString("rating"));
                product.setPrice(resultSet.getInt("price"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return product;
    }

    @Override
    public String updateProductPhoneNumber(Long id, Product newProduct) {
        String sql = """
                update products set name=?, rating=?, price = ? where id = ?
                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setLong(1,newProduct.getId());
            preparedStatement.setString(2,newProduct.getName());
            preparedStatement.setString(3,newProduct.getRating());
            preparedStatement.setInt(4,newProduct.getPrice());
            int i = preparedStatement.executeUpdate();
            if (i > 0) {
                System.out.println("Successfully updated");
            }else System.out.println("Not found with id ");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return "Success full";
    }

    @Override
    public void deleteProductById(Long id) {
        String sql = "delete from products where id = ? ";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            int deleteUsers = preparedStatement.executeUpdate();
            if (deleteUsers > 0) {
                System.out.println("Successfully deleted");
            } else System.out.println("Author id not found!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Product getLowRatingProducts(Long id) {
        return null;
    }

    @Override
    public Map<Integer, Product> getProductsWithPriceRange(double min_price, double max_price) {
        Map<Integer, Product> productsMap = new HashMap<>();
        String sql = "select *  from products where price >= ? and price <= ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)){
            statement.setDouble(1,min_price);
            statement.setDouble(2,max_price);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                Product product = new Product();
                int productId = resultSet.getInt("id");
                product.setId(resultSet.getLong("id"));
                product.setName(resultSet.getString("name"));
                product.setRating(resultSet.getString("ranting"));
                product.setPrice(resultSet.getInt("price"));
                productsMap.put(productId,product);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return productsMap;
    }

}
