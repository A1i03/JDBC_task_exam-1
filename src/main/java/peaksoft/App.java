package peaksoft;

import peaksoft.config.DataBaseJdbc;
import peaksoft.models.Product;
import peaksoft.models.User;
import peaksoft.services.ProductService;
import peaksoft.services.UserService;
import peaksoft.services.serviceImpl.ProductServiceImpl;
import peaksoft.services.serviceImpl.UserServiceImpl;

import java.util.Scanner;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
       DataBaseJdbc.getConnection();
        UserService userService = new UserServiceImpl();
        ProductService productService = new ProductServiceImpl();
        Scanner scannerNum = new Scanner(System.in);
        Scanner scannerLn = new Scanner(System.in);



        //userService.createUserTable();
        //System.out.println(userService.addUser(new User("Ali", "alialiali", "artis")));
       // System.out.println(userService.getUserById(1L));
       // userService.getUserRole("artis");
        // userService.updateUser(1L,new User("Sultan","sdcfvbg","java"));
       // userService.deleteUserByID(1L);
        productService.createProductTable();

        while (true){
        System.out.println("""
        ------------------- Products -------------------
        1) Добавить продукт
        2) Получить продукт по ID
        3) Обновить продукт
        4) Удалить продукт
        5) Вывести продукты по рейтингу
        6) Вывести продукты по min_price, max_price
                            
        Ваша команда:
        """);
        switch (scannerNum.nextInt()) {

            case 1 -> {
                System.out.println("Введите название продукта: ");
                String name = scannerLn.nextLine();

                System.out.println("Введите рейтинг продукта: ");
                String rating = scannerLn.nextLine();

                System.out.println("Введите цену продукта: ");
                int price = scannerNum.nextInt();

                System.out.println(productService.addProduct(new Product(name, rating, price)));
            }
            case 2 -> {
                System.out.println("Введите ID продукта: ");
                System.out.println(productService.getProductById(scannerNum.nextLong()));
            }
            case 3 -> {
                System.out.println("Введите ID продукта которого хотите обновить: ");
                Long productId = scannerNum.nextLong();

                System.out.println("Введите новое название продукта: ");
                String name = scannerLn.nextLine();

                System.out.println("Введите новый рейтинг продукта: ");
                String rating = scannerLn.nextLine();

                System.out.println("Введите новую цену продукта: ");
                int price = new Scanner(System.in).nextInt();

                System.out.println(productService.updateProductPhoneNumber(productId, new Product(name, rating, price)));
            }
            case 4 -> {
                System.out.println("Введите ID продукта которого хотите удалить: ");

                productService.deleteProductById(scannerNum.nextLong());
            }
            case 5 -> {
                System.out.println(productService.getLowRatingProducts());
            }
            case 6 -> {
                System.out.println("Введите минимальную цену: ");
                int minPrice = scannerNum.nextInt();

                System.out.println("Введите максимальную цену: ");
                int maxPrice = scannerNum.nextInt();

                System.out.println(productService.getProductsWithPriceRange(minPrice, maxPrice));

            }
        }

        }
    }
}
