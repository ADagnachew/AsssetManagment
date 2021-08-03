package assetManagement;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {


    DataLoad dataLoad = new DataLoad();
    University university = dataLoad.loadData();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        init();
    }

    public static void init() {
        Main mainObject = new Main();

        System.out.println("*******************************************************************************************");
        System.out.println("****              WELCOME TO MIU ASSET MANAGEMENT SYSTEM                               ****");
        System.out.println("*******************************************************************************************");
        System.out.println("*                                                                                         *");
        System.out.println("*                                                                                         *");
        System.out.println("*                                                                                         *");
        System.out.println("*                       PLEASE SELECT ONE FROM THE MENU                                   *");
        System.out.println("*                                                                                         *");
        System.out.println("*    PRESS 1: TO GET LIST OF ALL STOCK KEEPERS                                            *");
        System.out.println("*    PRESS 2: TO GET USERS/CUSTOMERS                                                      *");
        System.out.println("*    PRESS 3: TO GET ALL MANAGERS                                                         *");
        System.out.println("*    PRESS 4: GET BEST STOCK KEEPER OF THE YEAR                                           *");
        System.out.println("*    PRESS 5: TO GET TOP K CUSTOMERS WHO GOT MANY ORDER IN A YEAR                         *");
        System.out.println("*    PRESS 6: TO GET LIST OF PRODUCTS A SPECIFIC CUSTOMER ORDER IN A YEAR                 *");
        System.out.println("*    PRESS 7: TO GET BEST k PRODUCTS IN A YEAR WITH HIGH ORDER SORTED BY  OF QUANTITY     *");
        System.out.println("*    PRESS 8: TO GET K USERS SORTED BY NUMBER OF ORDER THAT HAS N QUANTITY OF PRODUCT     *");
        System.out.println("*    PRESS 9: LIST PRODUCT WAITING FOR DELIVERY                                           *");
        System.out.println("*    PRESS 10: LIST OF USERS WHO SHOULD RETURN THE PRODUCT THEY TAKEN                     *");
        System.out.println("*    PRESS 11: GET TOTAL ASSETS HOLD BY CUSTOMERS                                         *");
        System.out.println("*    PRESS 12: YOP K BEST MANAGERS                                                        *");
        System.out.println("*    PRESS 0: TO EXIT FROM THE SYSTEM                                                     *");
        System.out.println("*                                                                                         *");
        System.out.println("*                                                                                         *");
        System.out.println("*                                                                                         *");
        System.out.println("*******************************************************************************************");


        int choice;
        do {
            choice = input.nextInt();
            switch (choice) {
                case 1:
                    mainObject.stockKeepers();
                case 2:
                    mainObject.user();
                case 3:
                    mainObject.manager();
                case 4:
                    mainObject.bestStockKeeperOfTheYear();
                case 5:
                    mainObject.topKCustomersWithManyOrdersInAYear();
                case 6:
                    mainObject.listOfProductsNameBySpecificUserInAYear();
                case 7:
                    mainObject.getTheBestKProductInYearSortedByQuantityOfOrder();
                case 8:
                    mainObject.getKUserSortedByNumberOfOrdersThatHaveNQuantityOfProductAtYear();
                case 9:
                    mainObject.getAmountOfProductsWaitingForDeliver();
                case 10:
                    mainObject.getUsersWhoShouldReturn();
                case 11:
                    mainObject.getTotalAssetHoldByUsersInaYear();
                case 12:
                    mainObject.getKGoodManagers();
                case 0:
                    System.exit(0);
                default: {
                    System.out.println("please enter correct choice");
                    init();
                }
            }

        } while (input.hasNextInt());

    }


    public void manager() {
        List<Manager> managers = FunctionUtil.getManagers.apply(university);

        for (Manager manager : managers)
            System.out.println(manager.getPerson().getFirstName());

        System.out.println("click any key to got back");
        input.next();
        init();

    }

    public void user() {
        List<User> users = FunctionUtil.getUsers.apply(university);

        for (User user : users)
            System.out.println(user.getPerson().getFirstName());

        System.out.println("click any key to got back");
        input.next();
        init();
    }

    public void stockKeepers() {
        List<StockKeeper> keepers = FunctionUtil.getStockKeepers.apply(university);

        for (StockKeeper keeper : keepers)
            System.out.println(keeper.getPerson().getFirstName());

        System.out.println("click any key to got back");
        input.next();
        init();
    }

    //This Function finds the the stock keeper who deliver a lot of products in a specific year
    // and prints their last name in Uppercase
    public void bestStockKeeperOfTheYear() {
        System.out.println("please insert a valid year 'YYYY'");
        int year = input.nextInt();
        String bestStockKeepers = FunctionUtil.bestStockKeeper.apply(university, year);

        if (bestStockKeepers == null)
            System.out.println("There there may be to Stock keepers have the same number of delivery");

        System.out.println(bestStockKeepers);

        System.out.println("click any key to got back");
        input.next();
        init();
    }

    //A Function to find top K list First Names of Customer who make high order in a specific year
    public void topKCustomersWithManyOrdersInAYear() {
        int year;
        long limit;

        System.out.println("please insert valid year 'YYYY' and valid limit like: 1,2,3");
        System.out.print("Please insert year: ");
        year = input.nextInt();
        System.out.print("please Insert limit: ");
        limit = input.nextInt();

        List<String> customers = FunctionUtil.customersWhoGotManyOrdersInYear.apply(university, year, limit);

        if (customers == null)
            System.out.println("Check the limit it may be above the available or the year may not be valid");
//        for (String customer : customers){
//            System.out.println(customer);
//        }
        System.out.println(customers);

        System.out.println("click any key to got back");
        input.next();
        init();
    }

    // list of product Name which by specific by specific user taken in the given year
    public void listOfProductsNameBySpecificUserInAYear() {
        long year;
        String customerId;

        System.out.println("please insert valid year 'YYYY' and valid customer/UserID");
        System.out.print("Please insert year: ");
        year = input.nextInt();
        // test using this id(from data populated):389742
        System.out.print("please Insert CustomerId (389742): ");
        customerId = input.next();

        List<String> productList = FunctionUtil.listOfProductsBySpecificUserInAYear.apply(university, customerId, year);

        if (productList == null)
            System.out.println("Check the limit it may be above the available or the year may not be valid");
//        for (String prodName : productList){
//            System.out.println(prodName);
//        }
        System.out.println(productList);

        System.out.println("click any key to got back");
        input.next();
        init();
    }

    // Khalids work

    // This Function prints the top k products that has high quantity of orders
    public void getTheBestKProductInYearSortedByQuantityOfOrder() {
        long year;
        long limit;

        System.out.println("please insert valid year 'YYYY' and valid limit like: 1,2,3");
        System.out.print("Please insert year: ");
        year = input.nextInt();
        System.out.print("please Insert limit: ");
        limit = input.nextInt();

        List<Product> productList = FunctionUtil.getTheBestKProductInYearSortedByQntity.apply(university, limit, year);

        if (productList == null)
            System.out.println("please be make sure that your inputs are correct");
        for (Product product : productList) {
            System.out.println(product.toString());
        }
        System.out.println("click any key to got back");
        input.next();
        init();
    }

    public void getKUserSortedByNumberOfOrdersThatHaveNQuantityOfProductAtYear() {
        long year;
        long limit;
        int n;

        System.out.println("get k users who have order/orders in a YEAR with N products, ordered by number of orders found ");
        System.out.print("Please insert year: ");
        year = input.nextInt();
        System.out.print("please Insert limit: ");
        limit = input.nextInt();
        System.out.print("please Insert Quantity: ");
        n = input.nextInt();

        List<User> userList = FunctionUtil.getKUserSortedByNumberOfOrdersThatHaveNQuantityOfProductAtYear
                .apply(university, limit, n, year);
        if (userList == null)
            System.out.println("make sure you have a data that satisfy your condition ");
        for (User user : userList) {
            System.out.println(user.toString());
            System.out.println();
        }
        System.out.println("click any key to got back");
        input.next();
        init();
    }

    // MuluAdams code
    public void getAmountOfProductsWaitingForDeliver() {
        System.out.println(" The total List of Products waiting to be delivered ");
        System.out.println("Enter amount \t");
        int amount = input.nextInt();
        Map<String, Long> data = FunctionUtil.getAmountOfProductsWaitingForDelivery.apply(university, amount);
        System.out.println(data);
        System.out.println("click any key to got back");
        input.next();
        init();
    }

    public void getTotalAssetHoldByUsers() {
        System.out.println(" The total List of Products waiting to be delivered ");

        Double data = FunctionUtil.getTotalAssetHoldByUsers.apply(university);
        System.out.println("Total Value of Assets :" + data);
        System.out.println("click any key to got back");
        input.next();
        init();
    }

    public void getUsersOverDueWithProduct() {
        System.out.println(" Users Who should return the borrowed Product ");
        System.out.println("Enter the number of users you need to see \t");
        int amount = input.nextInt();
        Map<String, Long> data = FunctionUtil.getUsersOverDueWithProduct.apply(university, amount);
        System.out.println(data);
        System.out.println("click any key to got back");
        input.next();
        init();
    }

    //  overdue
    public void getUsersWhoShouldReturn() {
        System.out.println(" Users Who should return the borrowed Product ");

        List<String> data = FunctionUtil.getUsersWhoShouldReturn.apply(university);
        System.out.println(data);
        System.out.println("click any key to got back");
        input.next();
        init();
    }

    public void getTotalAssetHoldByUsersInaYear() {
        System.out.println("Enter year \t");
        int year = input.nextInt();
        Double data = FunctionUtil.getTotalAssetHoldByUsersInaYear.apply(university, year);
        System.out.println("Total Value of Assets given In a " + year + " :" + data);
        System.out.println("click any key to got back");
        input.next();
        init();
    }

    public void getKGoodManagers() {
        System.out.println("Please insert valid limit to display the best managers");
        long limit = input.nextInt();
        List<Manager> managers = FunctionUtil.getKGoodManagers.apply(university, limit);

        for (Manager manager : managers)
            System.out.println(manager);


        System.out.println("click any key to got back");
        input.next();
        init();
    }
}
