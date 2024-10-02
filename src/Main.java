import catalog.Customer;
import catalog.Order;
import catalog.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        List<Product> products = new ArrayList<>();
        products.add(new Product("Il signore degli anelli", "Book",101));
        products.add(new Product("Il signore degli asinelli", "Book",101));
        products.add(new Product("Il signore dei fornelli", "Baby",50));
        products.add(new Product("Le signore al bagno ci mettono tanto", "Boys",10000));
        products.add(new Product("Il signore", "Baby",90));
        List<Customer> customers = new ArrayList<>();
        customers.add(new  Customer("Pippo Franco", 3));
        customers.add(new Customer("Pippo Qualcos'altro", 2));
        customers.add(new Customer("Pippo QuellodiTopolino", 2));
        List<Order> orders = new ArrayList<>();
        orders.add(new Order(customers.get(0)));
        orders.add(new Order(customers.get(1)));
        orders.add(new Order(customers.get(2)));
        orders.get(0).addProduct(products.get(0));
        orders.get(0).addProduct(products.get(1));
        orders.get(0).addProduct(products.get(1));
        orders.get(1).addProduct(products.get(1));
        orders.get(2).addProduct(products.get(1));
        orders.get(0).order();
        orders.get(1).setOrderDate("2021-02-01");
        orders.get(2).setOrderDate("2021-04-01");
        orders.get(0).shipped();
        System.out.println(orders.get(0));
        System.out.println("---------------FilerProd-------------------");
        List<Product> filterProd =  products.stream().filter(product -> product.getCategory().equals("Book") && product.getPrice() > 100).toList();
        System.out.println(filterProd);
        List<Order> filterOrd = orders.stream().filter(order -> order.getProducts().stream().anyMatch(product -> product.getCategory().equals("Baby"))).toList();
        System.out.println("---------------FilerOrd-------------------");
        System.out.println(filterOrd);
        System.out.println("---------------10%Boys---------------------------");
        List<Product> filter10Prod = products.stream().filter(product -> product.getCategory().equals("Boys")).map(product -> {
            product.setPrice(product.getPrice() * 0.9);
            return product;
        }).toList();
        System.out.println(filter10Prod);
        System.out.println("---------------Ordinati da 2--------------------");
        List<Order> ordinatiLiv2 = orders.stream()
                .filter(order -> order.getCustomer().getTier() == 2 && (order.getOrderDate().isAfter(LocalDate.of(2021, 1, 31)) && order.getOrderDate().isBefore(LocalDate.of(2021, 5, 1))))
                .toList();
        System.out.println(ordinatiLiv2);




    }
}