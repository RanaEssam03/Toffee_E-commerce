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
import java.util.Objects;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class TOFFEEView {

    private final CatalogManager catalogManager = new CatalogManager();
    /**
     * This RegisterAndLoginView object is used to manage the register and login process
     * @see LoginView
     */
    private final LoginView registerAndLoginView;
    /**
     * This OrderManger object is used to manage the order process
     * @see OrderManger
     */
    private final OrderManger orderManger = new OrderManger(catalogManager);
    /**
     * This CatalogManager object is used to manage the catalog
     * @see CatalogManager
     */
    int customerId ;
    /**
     * TOFFEEView constructor that starts the register and login process
     * @throws IOException
     */
    public TOFFEEView() throws IOException {
        registerAndLoginView = new LoginView(this);
        registerAndLoginView.start();
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    /**
     * This method is used to view the catalog
     * @throws IOException
     */
    public void viewCatalog() {
        System.out.printf("| %-3s | %-15s | %5s| %5s |%n", "ID", "NAME", "PRICE","Available Quantity","Brand" );
        System.out.printf("--------------------------------%n");

        for (Map.Entry<Integer, Item> set : catalogManager.getCatalog().entrySet()) {
            System.out.printf("| %-3s | %-15s | %5s| %5s |%n",set.getKey().toString() , set.getValue().getName().toString(),
                    set.getValue().getPrice(), set.getValue().getQuantity() ,set.getValue().getBrand());
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
        Order order = orderManger.creatOrder(getCustomerId());

        while (true) {
            System.out.println("\n___________Catalog__________ ");
            viewCatalog();
            System.out.print("___enter item id Or 0 to main menu : ");
            int id = scan.nextInt();
            while ( id < 0 || id > catalogManager.getCatalog().size()) {
                System.out.print("please enter a valid id 0R 0 to main menu=> ");
                id = scan.nextInt();
            }


            if (id == 0) {
                return;
            }
            System.out.print("please select quantity=> ");
            String quantity = scan.next();
            while (!quantity.matches("[0-9]+")) {
                System.out.print("please enter a valid quantity=> ");
                quantity = scan.next();
            }
            int check = catalogManager.checkQuantity(id, parseInt(quantity));
            while (check == 1) {
                System.out.print("The Limit is 50, please change the quantity entered: ");
                 quantity = scan.next();
                while (!quantity.matches("[0-9]+")) {
                    System.out.print("please enter a valid quantity=> ");
                    quantity = scan.next();
                }
                check = catalogManager.checkQuantity(id, parseInt(quantity));
            }
            while (check != 2) {
                System.out.print("The quantity available is:" + check +
                        ", please choose within available quantity: ");
                quantity = scan.next();
                while (!quantity.matches("[0-9]+")) {
                    System.out.print("please enter a valid quantity=> ");
                    quantity = scan.next();
                }
                check = catalogManager.checkQuantity(id, parseInt(quantity));
                while (check == 1) {
                    System.out.print("The Limit is 50, please change the quantity entered: ");
                       quantity = scan.next();
                    while (!quantity.matches("[0-9]+")) {
                        System.out.print("please enter a valid quantity=> ");
                        quantity = scan.next();
                    }
                    check = catalogManager.checkQuantity(id, parseInt(quantity));
                }
            }
            catalogManager.decreaseQuantity(id, parseInt(quantity));
            order.addToCart(parseInt(quantity), catalogManager.getCatalog().get(id));
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
            String x = scan.next();
            while (!Objects.equals(x, "1") && !Objects.equals(x, "2")) {
                System.out.print("please enter a valid option: ");
                x = scan.next();
            }

            if (Objects.equals(x, "2")) {
                break;
            } else if (Objects.equals(x, "1")){

            while (true) {
                System.out.println("\n___________Main Menu__________ ");
                System.out.println("1. view Catalog");
                System.out.println("2. CheckOut");
                System.out.println("3. Back");
                System.out.print("___pick one option:");
                x = scan.next();
                while (!Objects.equals(x, "1") && !Objects.equals(x, "2") && !Objects.equals(x, "3")){
                    System.out.print("please enter a valid option: ");
                    x = scan.next();
                }

                if (Objects.equals(x, "1")) {
                    shopping();
                }
                else if (Objects.equals(x, "2")) {
                    checkOut();
                    break;
                }
                else if(Objects.equals(x, "3")){
                    break;
                }

            }
            }

            System.out.println("_________________________________________________");
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


