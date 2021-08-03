import assetManagement.*;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

import static org.hamcrest.collection.IsIterableContainingInOrder.contains;

import static org.hamcrest.CoreMatchers.is;


import static org.junit.Assert.*;

public class FunctionUtilTest {
    University university;
    Order order1, order2, order3, order20, order21, order4, order9;
    OrderLine orderLine1, orderLine2, orderLine3;
    Product laptop, printer, chair, whiteBoard;
    Person per1, per2, per3;
    Manager man1,man2,man3;
    User user1, user2, user3;
    DataLoad dataLoad;

    @Before
    public void setUp() {

        dataLoad = new DataLoad();
        university = dataLoad.loadData();
        whiteBoard = new Product("p111", "whiteBoard", 100, 20);

        laptop = new Product("p100", "Dell2020", 1500, 30);
        printer = new Product("p101", "HP_Letherjet", 700, 15);
        chair = new Product("p102", "chair1", 130, 20);
        orderLine1 = new OrderLine(laptop, 2);
        orderLine2 = new OrderLine(chair, 1);
        orderLine3 = new OrderLine(whiteBoard, 3);
        LocalDateTime orderDate1 = LocalDateTime.of(2020, Month.JANUARY, 23, 2, 00);

        order1 = new Order("order101", orderDate1, null, Arrays.asList(orderLine1, orderLine2, orderLine3), OrderStatus.APPROVED);
        order2 = new Order("Order102", orderDate1, null, Arrays.asList(orderLine2, orderLine3, orderLine1), OrderStatus.DELIVERED);
        order3 = new Order("Order103", LocalDateTime.of(2021, Month.APRIL, 3, 8, 20), null, Arrays.asList(orderLine3, orderLine2), OrderStatus.DELIVERED);
        order4 = new Order("Order106", LocalDateTime.of(2021, Month.APRIL, 3, 8, 20), null, Arrays.asList(orderLine3, orderLine2), OrderStatus.REJECTED);


        // order4 = new Order("Order104", orderDate4, returnDate4, Arrays.asList(orderLine1), OrderStatus.DELIVERED);
        //order9 = new Order("Order109", orderDate2, returnDate2, Arrays.asList(orderLine3), OrderStatus.DELIVERED);

        //           order20 = new Order("order101", orderDate1, returnDate1, Arrays.asList(orderLine1, orderLine2), OrderStatus.APPROVED);
        // order21 = new Order("Order102", orderDate2, returnDate2, Arrays.asList(orderLine2), OrderStatus.APPROVED);


        per1 = new Person("389742", "Jet", "Lee", null);
        user1 = new User(per1, Arrays.asList(order2, order3));
        per1.getRoles().add(user1);
        man2 =new Manager(per1, Arrays.asList(order2,order3));
        per2 = new Person("12123", "khalid", "med", null);
        user2 = new User(per2, Arrays.asList(order2));
        per2.getRoles().add(user2);
        man1 = new Manager(per2, Arrays.asList(order1,order2));
        per2.getRoles().add((man1));

        per3 = new Person("97897", "Alehegne", "Engehela", null);
        user3 = new User(per3, Arrays.asList(order3, order2));
        per3.getRoles().add(user3);
        man3 = new Manager(per3, Arrays.asList(order1,order2,order3));


    }


    @Test
    public void getmanagers() {
        List<Manager> managers = FunctionUtil.getManagers.apply(university);
        assertEquals(4, managers.size());
    }

    @Test
    public void getusers() {
        List<User> users = FunctionUtil.getUsers.apply(university);
        assertEquals(20, users.size());
    }

    @Test
    public void getstockKeeper() {
        List<StockKeeper> keepers = FunctionUtil.getStockKeepers.apply(university);
        assertEquals(5, keepers.size());
    }

    @Test
    public void getpersons() {
        List<Person> persons = FunctionUtil.getPersons.apply(university);
        assertEquals(25, persons.size());
    }

    @Test
    public void getDepartByName() {
        Department department = FunctionUtil.getDepartByName.apply(university, "Computer Science");

        //assertNotNull(department);
        assertEquals("Computer Science", department.getName());
    }

    @Test
    public void getPersonsByDepartement() {
        List<Person> persons = FunctionUtil.getPersonsByDepartement.apply(university, "Computer Science");
        assertEquals(10, persons.size());
    }


    @Test
    public void getQuantityOfProductsInOrder() {
        int results = FunctionUtil.getQuatityOfProductsInOrder.apply(order3);
        assertEquals(4, results);
    }


    @Test
    public void getOrdersWithNProductInYear() {
        List<Order> orders = Arrays.asList(order1, order2, order3);
        List<Order> result = FunctionUtil.getOrdersWithNProductInYear.apply(Arrays.asList(order1, order2, order3), 6, 2020l);
        assertEquals(Arrays.asList(order1, order2), result);

    }

    @Test
    public void getKUserSortedByOrdersThatHaveNQuantityOfProductAtYear() {
        //  List<User> users = Arrays.asList(user1,user2,user3);
        List<User> result = FunctionUtil.getKUserSortedByNumberOfOrdersThatHaveNQuantityOfProductAtYear.apply(university, 7l, 6, 2020l);
        assertEquals("Jet", result.get(0).getPerson().getFirstName());
    }


    @Test
    public void getAllOrdersDelivredInYear() {
        long year = 2024l;

        List<Order> ordersDelivered = FunctionUtil.getAllOrdersDelivredInYear.apply(user1, year);
        for (Order o : ordersDelivered)
            if (o.getOrderStatus() != OrderStatus.DELIVERED)
                assertFalse(true);

        assertTrue(true);
    }

    @Test
    public void getAllOrdersDelivredInYearShouldFail() {
        long year = 1999l;

        List<Order> ordersDelivered = FunctionUtil.getAllOrdersDelivredInYear.apply(user1, year);
        assertEquals(0, ordersDelivered.size());
    }

    @Test
    public void getTheBestKProductInYearSortedByQntity() {

        List<Product> products = FunctionUtil.getTheBestKProductInYearSortedByQntity.apply(university, 5l, 2020l);
        assertEquals(5, products.size());
    }

    @Test
    public void getNumberUsersByDepartement(){
        Department d1 = new Department("12132", "Computer Science");
        d1.setPersonList(Arrays.asList(per1,per2,per3));
        long users= FunctionUtil.getNumberUsersByDepartement.apply(d1);
        assertEquals(3,users);
    }
    @Test
    public void getKGoodManagers(){
        List<Manager> managers= FunctionUtil.getKGoodManagers.apply(university,5l);
        assertEquals(4,managers.size());
    }
    @Test
    public void numberOfOrdersApproved(){
        long approvedOrders = FunctionUtil.numberOfOrdersApproved.apply(Arrays.asList(order1,order2,order4,order3));
        assertEquals(3,approvedOrders);
    }
    @Test
    public void numberOfOrdersApprovedByAManager(){
        man1.setOrders(Arrays.asList(order1,order2,order4,order3));
        long approvedOrders = FunctionUtil.numberOfOrdersApprovedByAManager.apply(man1);
        assertEquals(3,approvedOrders);
    }




    //Alehegn start testes


    @Test
    public void numberOfOrdersStockKeeperDeliver() {

        StockKeeper s = new StockKeeper(dataLoad.p1, Arrays.asList(dataLoad.order6, dataLoad.order5, dataLoad.order1));
        long actual = FunctionUtil.numberOfOrdersStockKeeperDeliver.apply(s, 2021);
        assertEquals(1, actual);
    }

    @Test
    public void numberOfOrdersStockKeeperDeliver1() {

        StockKeeper s = new StockKeeper(dataLoad.p10, Arrays.asList(dataLoad.order2, dataLoad.order3));
        long actual = FunctionUtil.numberOfOrdersStockKeeperDeliver.apply(s, 2020);
        //not Equal
        assertNotEquals(2l, actual);
    }

    @Test
    public void bestStockKeeper1() {
        String firstNameBestStockKeeper = FunctionUtil.bestStockKeeper.apply(university, 2020);
        assertEquals("BOND", firstNameBestStockKeeper);
    }

    @Test
    public void bestStockKeeper2() {
        String firstNameBestStockKeeper = FunctionUtil.bestStockKeeper.apply(university, 2021);
        assertEquals("FRIEND", firstNameBestStockKeeper);
    }

    @Test
    public void listOfProductsBySpecificUserInAYear1() {
        List<String> actualProductName = FunctionUtil.listOfProductsBySpecificUserInAYear.apply(university, "389742", 2021L);
        assertEquals(3, actualProductName.size());
        assertThat(actualProductName, contains("whiteBoard", "chair1", "waterBottle"));
    }


    //is not working for the moment
    @Test
    public void listOfProductsBySpecificUserInAYear2() {
        List<String> actualProductName = FunctionUtil.listOfProductsBySpecificUserInAYear.apply(university, "12123", 2020L);
        assertEquals(3, actualProductName.size());
      //  System.out.println(actualProductName);
        assertThat(actualProductName, contains("chair1", "whiteBoard", "Dell2020"));
    }

    @Test
    public void listOfProductsBySpecificUserInAYear3() {
        List<String> actualProductName = FunctionUtil.listOfProductsBySpecificUserInAYear.apply(university, "97897545", 2021L);
        assertEquals(1, actualProductName.size());
        assertThat(actualProductName, contains("waterBottle"));
    }

    @Test
    public void numberOfOrdersByCustomer1() {
        User u1 = new User(dataLoad.p1, Arrays.asList(dataLoad.order1, dataLoad.order2,
                dataLoad.order3, dataLoad.order4, dataLoad.order5, dataLoad.order6, dataLoad.order7, dataLoad.order8, dataLoad.order9, dataLoad.order10));
        long number = FunctionUtil.numberOfOrdersByCustomer.apply(u1, 2020);
        assertEquals(3, number);
    }

    @Test
    public void numberOfOrdersByCustomer2() {
        User u1 = new User(dataLoad.p1, Arrays.asList(dataLoad.order1, dataLoad.order2,
                dataLoad.order3, dataLoad.order4, dataLoad.order5, dataLoad.order6, dataLoad.order7, dataLoad.order8, dataLoad.order9, dataLoad.order10));
        long number = FunctionUtil.numberOfOrdersByCustomer.apply(u1, 2021);
        assertEquals(3, number);
    }

    @Test
    public void numberOfOrdersByCustomer3() {
        User u1 = new User(dataLoad.p1, Arrays.asList(dataLoad.order1, dataLoad.order2,
                dataLoad.order3, dataLoad.order4, dataLoad.order5, dataLoad.order6, dataLoad.order7, dataLoad.order8, dataLoad.order9, dataLoad.order10));
        long number = FunctionUtil.numberOfOrdersByCustomer.apply(u1, 2019);
        assertEquals(0, number);
    }

    @Test
    public void customersWhoGotManyOrdersInYear1() {
        List<String> names = FunctionUtil.customersWhoGotManyOrdersInYear.apply(university, 2020, 2l);
        assertEquals(2, names.size());
        assertThat(names, contains("Jet", "khalid"));

    }

    @Test
    public void customersWhoGotManyOrdersInYear2() {
        List<String> names = FunctionUtil.customersWhoGotManyOrdersInYear.apply(university, 2021, 4l);

        assertEquals(4, names.size());
        assertThat(names, contains("Jet", "Alehegne", "Alis", "Muluadam"));

    }

    //Alehegn end teste here



    //Muluadam Start Tests here


    /**
     * TODO:
     */

    @Test
    public void testTotalValueOfAssetHoldByUsers() {
        double TotalAount = 40476;
        Double totalPrice = FunctionUtil.getTotalAssetHoldByUsers.apply(university);

        assertTrue(TotalAount == totalPrice);
    }

    @Test
    public void testTotalAssetHoldByUsersShouldFail() {
        Double totalPrice = FunctionUtil.getTotalAssetHoldByUsers.apply(university);
        assertNotEquals(40, totalPrice.intValue());
    }

    @Test
    public void testUsersOverDue() {
        List<String> users = FunctionUtil.getUsersWhoShouldReturn.apply(university);
        assertEquals(3, users.size());
        assertThat(users, contains("Jet", "Alis", "Shoma"));
    }

    //usersOverDueWithProduct
    @Test
    public void testUsersOverDueWithProduct() {
        Map<String, Long> map = FunctionUtil.getUsersOverDueWithProduct.apply(university, 5);
        assertEquals(2, map.size());
        Map<String, Long> expected = new HashMap<>();
        expected.put("Order103", 2l);
        expected.put("Order113", 1l);


        //1. Test equal, ignore order
        assertThat(map, is(expected));
    }
    @Test
    public void testAmountOfProductsWaitingForDelivery() {
        Map<String, Long> map = FunctionUtil.getAmountOfProductsWaitingForDelivery.apply(university, 4);
        Map<String, Long> expected = new HashMap<>();
        expected.put("whiteBoard", 4l);
        expected.put("Dell2020", 3l);
        expected.put("chair1", 6l);
        expected.put("Ford2021", 1l);

      // System.out.println(map);
        //1. Test equal, ignore order
        assertThat(map, is(expected));
    }
    //

    @Test
    public void testhasUserOverDue() {
        Department d1 = new Department("12132", "Computer Science");
        Person p1 = new Person("389742", "Jet", "Lee", d1);
        LocalDateTime orderDate1 = LocalDateTime.of(2020, Month.JANUARY, 23, 2, 00);
        LocalDateTime returnDate1 = LocalDateTime.of(2020, Month.FEBRUARY, 23, 2, 00);
        LocalDateTime orderDate2 = LocalDateTime.of(2021, Month.MARCH, 10, 4, 30);
        LocalDateTime returnDate2 = LocalDateTime.of(2022, Month.MARCH, 10, 4, 30);


        university = new University("MIU1", "MIU");

        Product laptop = new Product("p100", "Dell2020", 1500, 30);
        Product printer = new Product("p101", "HP_Letherjet", 700, 15);
        Product chair = new Product("p102", "chair1", 130, 20);
        OrderLine orderLine1 = new OrderLine(laptop, 2);
        OrderLine orderLine2 = new OrderLine(chair, 1);


        Order order20 = new Order("order100", orderDate1, returnDate1, Arrays.asList(orderLine1, orderLine2), OrderStatus.DELIVERED);
        Order order21 = new Order("Order101", orderDate2, returnDate2, Arrays.asList(orderLine2), OrderStatus.APPROVED);
        User u1 = new User(p1, Arrays.asList(order20, order21));
        // User usr= User(p1, Arrays.asList(order20, order21));
        boolean val = FunctionUtil.hasUserOverDue.apply(u1);
        assertTrue(val);

    }

    @Test
    public void testTotalAssetHoldByUsersInaYear() {
        double amount = 39630;
        double totalAmount = FunctionUtil.getTotalAssetHoldByUsersInaYear.apply(university, 2020);
        assertTrue(amount == totalAmount);
    }

    @Test
    public void testTotalAssetHoldByUsersAverege(){
        double expectedAmount=3373.0;
        double averegeActual=FunctionUtil.getTotalAssetHoldByUsersAverege.apply(university);
       // System.out.println(averegeActual);
        assertTrue(expectedAmount==averegeActual);
    }


    @Test
    public void testProbablity(){

        Long rej= FunctionUtil.getNotApprovedProducts.apply(university,"whiteBoard");
        Long app= FunctionUtil.getApprovedProducts.apply(university,"whiteBoard");

     //   System.out.println(rej);
       // System.out.println(app);
        String actual=100.0*app*1.0/(rej*1.0+app)+" %";
     //   System.out.println("Acctual=="+actual);
        String expectedAmount=FunctionUtil.probability.apply(university,"whiteBoard");
        assertEquals(expectedAmount.substring(0,5),actual.substring(0,5));
    }


    //End Muluadam tests Here

}
