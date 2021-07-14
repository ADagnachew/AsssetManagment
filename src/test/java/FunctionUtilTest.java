import assetManagement.*;
import org.junit.Before;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

public class FunctionUtilTest {

    University university;
    List<Product> products;
    List<Person> users;
    List<Person> managers;
    List<Person> stockKeepers;
    List<Person> people;
    List<Order> orders;


    Product laptop, printer,chair,bike,car,TV,dish,fork,mobilePhone,book,bottle,cooler,whiteBoard,refrigrator,spoon;
    Order order1, order2, order3, order4,order5,order6, order7,order8,order9,order10,
            order20, order21,order22, order23, order24,order25,order26, order27,order28,order29,order30,
            order11, order12, order13, order14,order15,order16, order17,order18,order19;
    OrderLine orderLine1,orderLine2,orderLine3,orderLine4,orderLine5;
    OrderLine orderLine6,orderLine7,orderLine8,orderLine9,orderLine10;
    OrderLine orderLine11,orderLine12,orderLine13,orderLine14,orderLine15;
    OrderLine orderLine16,orderLine17,orderLine18,orderLine19,orderLine20;
    OrderLine orderLine21,orderLine22,orderLine23,orderLine24,orderLine25;
    OrderLine orderLine26,orderLine27,orderLine28,orderLine29,orderLine30;

    //Person alehegn,khalid,muluadam,daniel,john,jim,rechardson,alicia,meron,

    @Before
    public void setUp(){

        university = new University("MIU1","MIU");

        laptop = new Product("p100","Dell2020",1500,30);
        printer = new Product("p101","HP_Letherjet",700,15);
        chair = new Product("p102","chair1",130,20);
        car = new Product("p103","Ford2021",35000,5);
        bike = new Product("p104","Mongoose",400,12);
        TV = new Product("p105","LG65Inch",1400,5);
        dish = new Product("p106","glassDish",20,50);
        fork = new Product("p107","IronFork",8,100);
        mobilePhone = new Product("p108","iPhone12Pro",1800,10);
        book = new Product("p109","javaBook",120,50);
        bottle = new Product("p110","waterBottle",12,60);
        whiteBoard = new Product("p111","whiteBoard",100,20);
        cooler = new Product("p112", "miniCooler",200,10);
        refrigrator = new Product("p113", "miniFrig",300,15);
        spoon = new Product("p114", "spoon",10,200);

        products = Arrays.asList(laptop,car,chair,fork,TV,dish,whiteBoard,bottle,cooler,book,printer,refrigrator,bike);

        orderLine1 = new OrderLine(laptop,2);
        orderLine2 = new OrderLine(chair,1);
        orderLine3 = new OrderLine(whiteBoard,3);
        orderLine4 = new OrderLine(printer,2);
        orderLine6 = new OrderLine(bottle, 1);
        orderLine7 = new OrderLine(cooler, 4);
        orderLine8 = new OrderLine(fork, 10);
        orderLine9 = new OrderLine(book, 2);
        orderLine10 = new OrderLine(printer, 1);
        orderLine11= new OrderLine(car, 1);
        orderLine12 = new OrderLine(bottle, 1);
        orderLine13 = new OrderLine(dish, 1);
        orderLine14 = new OrderLine(bottle, 19);
        orderLine15 = new OrderLine(laptop, 1);
        orderLine16 = new OrderLine(chair, 2);
        orderLine17 = new OrderLine(TV, 1);
        orderLine18 = new OrderLine(cooler, 1);
        orderLine19 = new OrderLine(bottle, 3);
        orderLine20 = new OrderLine(cooler, 2);
        orderLine21 = new OrderLine(bottle, 3);
        orderLine22 = new OrderLine(car, 2);
        orderLine23 = new OrderLine(spoon, 30);
        orderLine24 = new OrderLine(chair, 2);
        orderLine25 = new OrderLine(book, 10);
        orderLine26 = new OrderLine(laptop, 9);
        orderLine27 = new OrderLine(bottle, 5);
        orderLine28 = new OrderLine(TV, 2);
        orderLine29 = new OrderLine(dish, 13);
        orderLine30 = new OrderLine(fork, 11);

        LocalDateTime orderDate1 = LocalDateTime.of(2020, Month.JANUARY,23,2,00);
        LocalDateTime returnDate1 = LocalDateTime.of(2020,Month.FEBRUARY,23,2,00);

        LocalDateTime orderDate2 = LocalDateTime.of(2021,Month.MARCH,10,4,30);
        LocalDateTime returnDate2 = LocalDateTime.of(2022,Month.MARCH,10,4,30);

        LocalDateTime orderDate3 = LocalDateTime.of(1019,Month.JUNE,10,1,00);
        LocalDateTime returnDate3 = LocalDateTime.of(2019,Month.JANUARY,10,1,00);

        LocalDateTime orderDate4 = LocalDateTime.of(2020,Month.NOVEMBER,23,5,00);
        LocalDateTime returnDate4 = LocalDateTime.of(2021,Month.AUGUST,23,5,00);

        LocalDateTime orderDate5 = LocalDateTime.of(2021,Month.APRIL,3,8,20);
        LocalDateTime returnDate5 = LocalDateTime.of(2021,Month.SEPTEMBER,3,2,00);

        LocalDateTime orderDate6 = LocalDateTime.of(2021,Month.JULY,20,8,20);
        LocalDateTime returnDate6 = LocalDateTime.of(2021,Month.JULY,20,6,20);

        order1 = new Order("order101" ,orderDate1,returnDate1,Arrays.asList(orderLine1),OrderStatus.APPROVED);
        order2 = new Order("Order102",orderDate2,returnDate2,Arrays.asList(orderLine2),OrderStatus.DELIVERED);
        order3 = new Order("Order103",orderDate3,returnDate3,Arrays.asList(orderLine3),OrderStatus.DELIVERED);
        order4 = new Order("Order104",orderDate4,returnDate4,Arrays.asList(orderLine1),OrderStatus.DELIVERED);
        order5 = new Order("Order105",orderDate5,returnDate5,Arrays.asList(orderLine2),OrderStatus.REJECTED);
        order6 = new Order("Order106",orderDate6,returnDate6,Arrays.asList(orderLine4),OrderStatus.DELIVERED);
        order7 = new Order("Order107",orderDate1,returnDate2,Arrays.asList(orderLine5),OrderStatus.REJECTED);
        order8 = new Order("Order108",orderDate4,returnDate4,Arrays.asList(orderLine1),OrderStatus.DELIVERED);
        order9 = new Order("Order109",orderDate2,returnDate2,Arrays.asList(orderLine3),OrderStatus.DELIVERED);
        order10 = new Order("Order110",orderDate6,returnDate6,Arrays.asList(orderLine1,orderLine2),OrderStatus.CANCELED);

        List<Order> orders1 = Arrays.asList(order1,order2,order3,order3,order5,order6,order7,order8,order9,order10);

        Department d1 = new Department("12132","Computer Science");


         List<Person> people1 = Arrays.asList(
                new Person("12123","khalid","med",d1,Arrays.asList( new User(Arrays.asList(order1,order2)))),
                new Person("97897","Alehegne","Engehela",d1,Arrays.asList(new Manager(orders1), new User(Arrays.asList(order3,order8)))),
                new Person("97897","Ali","Klayn",d1,Arrays.asList( new User(Arrays.asList(order5,order4)))),
                new Person("23423","Muluadam","Madaulum",d1,Arrays.asList( new User(Arrays.asList(order6)))),
                new Person("23428","John","Sim",d1,Arrays.asList( new User(Arrays.asList(order7,order10,order9)))),

                new Person("87844","Jean","Friend",d1,Arrays.asList( new StockKeeper(Arrays.asList(order4,order9,order6)))),
                new Person("236745","Van","Dam",d1,Arrays.asList( new StockKeeper(Arrays.asList(order3,order2))))

        );






        order20 = new Order("order101" ,orderDate1,returnDate1,Arrays.asList(orderLine1,orderLine2),OrderStatus.APPROVED);
        order21 = new Order("Order102",orderDate2,returnDate2,Arrays.asList(orderLine2),OrderStatus.APPROVED);
        order23 = new Order("Order103",orderDate3,returnDate3,Arrays.asList(orderLine3),OrderStatus.APPROVED);
        order24 = new Order("Order104",orderDate4,returnDate4,Arrays.asList(orderLine1,orderLine3,orderLine2),OrderStatus.DELIVERED);
        order25 = new Order("Order105",orderDate5,returnDate5,Arrays.asList(orderLine2),OrderStatus.REJECTED);
        order26 = new Order("Order106",orderDate6,returnDate6,Arrays.asList(orderLine4),OrderStatus.DELIVERED);
        order27 = new Order("Order107",orderDate1,returnDate2,Arrays.asList(orderLine5,orderLine4),OrderStatus.REJECTED);
        order28 = new Order("Order108",orderDate4,returnDate4,Arrays.asList(orderLine1),OrderStatus.DELIVERED);
        order29 = new Order("Order109",orderDate2,returnDate2,Arrays.asList(orderLine3),OrderStatus.DELIVERED);
        order30 = new Order("Order110",orderDate6,returnDate6,Arrays.asList(orderLine1,orderLine2,orderLine3),OrderStatus.CANCELED);


        Department d2 = new Department("17568","Mathematics");
List<Order> listOrder1 = Arrays.asList(order20,order21,order24,order23);
        List<Order> listOrder2 = Arrays.asList(order25,order26,order27,order28,order29,order30);
        private List<Person> people2 = Arrays.asList(
                new Person("389742","Jet","Lee",d2,Arrays.asList( new User(Arrays.asList(order20,order21)))),
                new Person("23423","Khan","Sharo",d2,Arrays.asList(new Manager(listOrder1), new User(Arrays.asList(order21,order22)))),
                new Person("23428","Jamal","Kak",d2,Arrays.asList( new User(Arrays.asList(order24,order23)))),
                new Person("87844","Salah","Ali",d2,Arrays.asList( new User(Arrays.asList(order25,order25,order26)))),
                new Person("23428","Josie","Miso",d2,Arrays.asList( new User(Arrays.asList(order27,order28, order29,order30)))),
                new Person("236745","Anthony","Sander",d2,Arrays.asList( new Manager(listOrder2))),
                new Person("389742","Jims","Bond",d2,Arrays.asList( new StockKeeper(Arrays.asList(order24,order26,order28,order29))))

        );







        Department d3 = new Department("15632","Physics");
        order11 = new Order("order111" ,orderDate1,returnDate1,Arrays.asList(orderLine22),OrderStatus.APPROVED);
        order12 = new Order("Order112",orderDate2,returnDate2,Arrays.asList(orderLine12),OrderStatus.DELIVERED);
        order13 = new Order("Order113",orderDate3,returnDate3,Arrays.asList(orderLine23),OrderStatus.DELIVERED);
        order14 = new Order("Order114",orderDate4,returnDate4,Arrays.asList(orderLine11),OrderStatus.DELIVERED);
        order15 = new Order("Order115",orderDate5,returnDate5,Arrays.asList(orderLine9),OrderStatus.REJECTED);
        order16 = new Order("Order116",orderDate6,returnDate6,Arrays.asList(orderLine6),OrderStatus.DELIVERED);
        order17 = new Order("Order117",orderDate1,returnDate2,Arrays.asList(orderLine14),OrderStatus.REJECTED);
        order18 = new Order("Order118",orderDate4,returnDate4,Arrays.asList(orderLine17),OrderStatus.DELIVERED);
        order19 = new Order("Order119",orderDate2,returnDate2,Arrays.asList(orderLine27),OrderStatus.DELIVERED);
        order20 = new Order("Order120",orderDate6,returnDate6,Arrays.asList(orderLine29,orderLine7),OrderStatus.CANCELED)
        List<Order> listOrder3 = Arrays.asList(order11,order12,order13,order14,order15,order16,order17,order18,order19,order20);

         List<Person> people3 = Arrays.asList(
                new Person("90635","Hosie","Foo",d3,Arrays.asList( new User(Arrays.asList(order11,order12)))),
                new Person("44444","Shoma","Khar",d3,Arrays.asList(new Manager(listOrder3), new User(Arrays.asList(order13,order14)))),
                new Person("89783","Messi","Argentina",d3,Arrays.asList( new User(Arrays.asList(order15,order16)))),
                new Person("97897","Ronaldo","Cristiano",d3,Arrays.asList( new User(Arrays.asList(order16,order17)))),
                new Person("23423","Ronaldo","Rozario",d3,Arrays.asList( new User(Arrays.asList(order18,order19,order20)))),
                new Person("23428","Josie","Miso",d3,Arrays.asList(
                        new StockKeeper(Arrays.asList(order12,order13,order14)))),
                new Person("23428","Zidan","Zine",d3,Arrays.asList(
                        new StockKeeper(Arrays.asList(order16,order18,order19)))),

                new Person("389742","Sosan","Rais",d3,Arrays.asList( new User(Arrays.asList(order20,order12))))

        );

        university = new University("MIU1","MIU");

        university.setDepartments(Arrays.asList(d1,d2,d3));



    }





}
