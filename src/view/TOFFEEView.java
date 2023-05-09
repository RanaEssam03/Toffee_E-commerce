package view;

import Item.CatalogManager;
import Item.Item;
import Order.Order;
import Order.OrderManger;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class TOFFEEView {

    private final CatalogManager catalogManager = new CatalogManager();
    private final RegisterAndLoginView registerAndLoginView;
    private final OrderManger orderManger = new OrderManger(catalogManager);

    public TOFFEEView() throws IOException {
        registerAndLoginView = new RegisterAndLoginView(this);
        registerAndLoginView.start();
    }

    public void viewCatalog() {
        System.out.println("    -> 0. main menu <-");
        for (Map.Entry<Integer, Item> set : catalogManager.getCatalog().entrySet()) {
            System.out.print(set.getKey() + "." + set.getValue().getName() + " " + set.getValue().getPrice() + " "
                    + set.getValue().getQuantity() + " " + set.getValue().getBrand());
            System.out.println();
        }
        System.out.println("_________________________________________________");
    }

    private void shopping() throws IOException {
        Scanner scan = new Scanner(System.in);
        int x;
        Order order = orderManger.creatOrder(5);

        while (true) {
            System.out.println("Please select itemId to add to cart ");
            viewCatalog();
            int id = scan.nextInt();
            if (id == 0) {
                checkOut();
                break;
            }
            System.out.print("please select quantity=> ");
            int quantity = scan.nextInt();
            int check = catalogManager.checkQuantity(id, quantity);
            while (check == 1) {
                System.out.print("The Limit is 50, please change the quantity entered: ");
                quantity = scan.nextInt();
                check = catalogManager.checkQuantity(id, quantity);
            }
            while (check != 2) {
                System.out.print("The quantity available is:" + check +
                        ", please choose within available quantity: ");
                quantity = scan.nextInt();
                check = catalogManager.checkQuantity(id, quantity);
                while (check == 1) {
                    System.out.print("The Limit is 50, please change the quantity entered: ");
                    quantity = scan.nextInt();
                    check = catalogManager.checkQuantity(id, quantity);
                }
            }
            catalogManager.decreaseQuantity(id, quantity);
            order.addToCart(quantity, catalogManager.getCatalog().get(id));
            System.out.println("_________________________________________________");

        }
    }

    public void start() throws IOException {

        catalogManager.loadData();
        System.out.println("        Welcome to TOFFEE\n\n");

        while (true) {
            System.out.println("1.Start Shopping");
            System.out.println("2. Exit");
            Scanner scan = new Scanner(System.in);

            int x = scan.nextInt();
            System.out.println("_________________________________________________");

            if (x == 2) {
                break;
            }


            while (true) {
                System.out.println("1. view Catalog");
                System.out.println("2. CheckOut");
                x = scan.nextInt();
                System.out.println("_________________________________________________");

                if (x == 1) {
                    shopping();
                    break;
                }
                if (x == 2) {
                    checkOut();
                    break;
                }

            }
        }
        System.out.println("SEE YOU SOON");

    }

    void checkOut() throws IOException {
        System.out.println("        #Order Checkout#");
        orderManger.checkOutOrder();
        System.out.println("_________________________________________________");
    }
}


