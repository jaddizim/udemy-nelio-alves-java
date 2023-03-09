package application;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities_enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import static entities_enums.OrderStatus.PROCESSING;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner t = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

        System.out.println("Enter client data:");

        System.out.print("Name: ");
        String clientName = t.nextLine();
        System.out.print("Email: ");
        String clientEmail = t.nextLine();
        System.out.print("Birth date: (DD/MM/YYY): ");
        Date clientBirthDate = sdf.parse(t.nextLine());

        Client client = new Client(clientName, clientEmail, clientBirthDate);

        System.out.println("Enter order data:");

        System.out.print("Status: ");
        OrderStatus orderStatus = OrderStatus.valueOf(t.nextLine());

        Order order = new Order(new Date(), orderStatus, client);

        System.out.print("How many items to this order? ");
        int qtItems = t.nextInt();
        t.nextLine();
        for (int i = 1; i <= qtItems; i++) {
            System.out.println("Enter #" + i + " item data: ");
            System.out.print("Product name: ");
            String productName = t.nextLine();
            System.out.print("Product price: ");
            Double productPrice = t.nextDouble();
            System.out.print("Quantity: ");
            Integer productQuantity = t.nextInt();
            t.nextLine();
            OrderItem orderItem = new OrderItem(productQuantity, productPrice, new Product(productName, productPrice));
            order.addItem(orderItem);
        }

        System.out.println(order);

        t.close();
    }
}