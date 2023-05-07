package TOFFEE;

import Item.CatalogManager;
import Order.Order;
import Order.OrderManger;

import java.io.IOException;
import java.util.Scanner;

public class TOFFEE {

    private CatalogManager catalogManager = new CatalogManager();
    private OrderManger orderManger = new OrderManger(catalogManager);
   private void viewCatalog(){
       Scanner scan = new Scanner(System.in);
       int x;
       Order order = orderManger.creatOrder(5);
                while (true) {
                    System.out.println("1. view Catalog");
                    System.out.println("2. CheckOut");

                    x = scan.nextInt();
                    System.out.println("_________________________________________________");

                    if(x == 0){

                        break;
                    }
                    if(x == 2){
                        System.out.println("        #Order Checkout#");
                        orderManger.checkOutOrder();
                        System.out.println("_________________________________________________");

                        break;
                    }

                    while (true)
                    {
                        System.out.println("Please select itemId to add to cart ");
                        catalogManager.viewCatalog();
                        int id = scan.nextInt();
                        if(id == 0){
                            break;
                        }
                        System.out.print("please select quantity=> ");
                        int quantity = scan.nextInt();
                        int check = catalogManager.checkQuantity(id, quantity);
                        while (check == 1){
                            System.out.print("The Limit is 50, please change the quantity entered: ");
                            quantity = scan.nextInt();
                            check = catalogManager.checkQuantity(id, quantity);
                        }
                        while (check != 2){
                            System.out.print("The quantity available is:" + check +
                                    ", please choose within available quantity: ");
                            quantity = scan.nextInt();
                            check = catalogManager.checkQuantity(id, quantity);
                            while (check == 1){
                                System.out.print("The Limit is 50, please change the quantity entered: ");
                                quantity = scan.nextInt();
                                check = catalogManager.checkQuantity(id, quantity);
                            }
                        }
                        order.addToCart(quantity, catalogManager.getCatalog().get(id));
                        System.out.println("_________________________________________________");

                    }
                }
   }

    public  void start() throws IOException {

        catalogManager.loadData("database.txt");
        System.out.println("        Welcome to TOFFEE\n\n");

        while (true)
        {
            System.out.println("1.Start Shopping");
            System.out.println("2. Exit");
            Scanner scan = new Scanner(System.in);

            int x = scan.nextInt();
            System.out.println("_________________________________________________");

            if(x ==2 ){
                break;
            }

            else if (x == 1) {
                this.viewCatalog();

            }
        }
        System.out.println("SEE YOU SOON");
    }
}
