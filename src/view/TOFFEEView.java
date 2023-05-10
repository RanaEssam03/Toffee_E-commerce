/**
 * TOFFEEView class is the main class of the program view.
 *
 * @auther Rana Essam & Noor Eyad
 * @version 1.0
 * @see RegisterAndLoginView
 * @see CatalogManager
 * @see OrderManger
 * @see Order
 */
package view;

import Item.CatalogManager;
import Item.Item;
import Order.Order;
import Order.OrderManger;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class TOFFEEView {

    /**
     * This CatalogManager object is used to manage the catalog
     * @see CatalogManager
     */
    private final CatalogManager catalogManager = new CatalogManager();
    /**
     * This RegisterAndLoginView object is used to manage the register and login process
     * @see RegisterAndLoginView
     */
    private final RegisterAndLoginView registerAndLoginView;
    /**
     * This OrderManger object is used to manage the order process
     * @see OrderManger
     */
    private final OrderManger orderManger = new OrderManger(catalogManager);

    /**
     * TOFFEEView constructor that starts the register and login process
     * @throws IOException
     */
    public TOFFEEView() throws IOException {
        registerAndLoginView = new RegisterAndLoginView(this);
        registerAndLoginView.start();
    }

    /**
     * This method is used to view the catalog
     * @throws IOException
     */
    public void viewCatalog() {
        for (Map.Entry<Integer, Item> set : catalogManager.getCatalog().entrySet()) {
            System.out.print(set.getKey() + "." + set.getValue().getName() + " " + set.getValue().getPrice() + " "
                    + set.getValue().getQuantity() + " " + set.getValue().getBrand());
            System.out.println();
        }
        System.out.println("_________________________________________________");
    }

    /**
     * This method is used to view the orders
     * @throws IOException
     */
    private void shopping() throws IOException {
        Scanner scan = new Scanner(System.in);
        int x;
        Order order = orderManger.creatOrder(5);

        while (true) {
            System.out.println("\n___________Catalog__________ ");
            viewCatalog();
            System.out.print("___enter item id Or 0 to main menu : ");

            int id = scan.nextInt();
            if (id == 0) {
                return;
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

    /**
     * This method is used to start the main menu of the program and view the catalog
     * @throws IOException
     */
    public void start() throws IOException {

        catalogManager.loadData();
        System.out.println("\n----------Welcome to TOFFEE----------\n");

        while (true) {
            System.out.println("1.Start Shopping");
            System.out.println("2. Exit");
            Scanner scan = new Scanner(System.in);
            System.out.print("___pick one option: ");
            int x = scan.nextInt();

            if (x == 2) {
                break;
            }


            while (true) {
                System.out.println("\n___________Main Menu__________ ");
                System.out.println("1. view Catalog");
                System.out.println("2. CheckOut");
                System.out.print("___pick one option:");
                x = scan.nextInt();

                if (x == 1) {
                    shopping();
                }
                if (x == 2) {
                    checkOut();
                    break;
                }

            }
        }
        System.out.println("\n____________SEE YOU SOON________________");
    }

    /**
     * This method is used to check out the order view the order details
     * @throws IOException
     */
    void checkOut() throws IOException {
        System.out.println("------------Order Checkout------------");
        orderManger.checkOutOrder();
    }
}


