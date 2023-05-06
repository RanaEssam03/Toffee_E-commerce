import Item.CatalogManager;
import Order.Order;
import Order.OrderManger;

import java.util.Scanner;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {
    public static void main(String[] args) {
        CatalogManager catalogManager = new CatalogManager();
        OrderManger orderManger = new OrderManger(catalogManager);
        catalogManager.updateCatalog("cotton candy", 25, "kids", " ", "egyFood");
        catalogManager.updateCatalog("Lollipop", 5, "kids", " ", "egyFood");
        System.out.println("Welcome to TOFFEE");

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
                        order.addToCart(quantity, catalogManager.getCatalog().get(id));
                        System.out.println("_________________________________________________");

                    }
                }
            }
        }
        System.out.println("SEE YOU SOON");
    }
}