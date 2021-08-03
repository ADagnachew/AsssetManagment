package assetManagement;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class DataLoad {

    University university;
    List<Product> products;
    List<Person> users;
    List<Person> managers;
    List<Person> stockKeepers;
    List<Person> people;
    List<Order> orders;

public DataLoad(){
    loadData();
}
    Product laptop, printer, chair, bike, car, TV, dish, fork, mobilePhone, book, bottle, cooler, whiteBoard, refrigrator, spoon;
    Order order1, order2, order3, order4, order5, order6, order7, order8, order9, order10,
            order20, order21, order22, order23, order24, order25, order26, order27, order28, order29, order30,
            order11, order12, order13, order14, order15, order16, order17, order18, order19;


    OrderLine orderLine1, orderLine2, orderLine3, orderLine4, orderLine5;
    OrderLine orderLine6, orderLine7, orderLine8, orderLine9, orderLine10;
    OrderLine orderLine11, orderLine12, orderLine13, orderLine14, orderLine15;
    OrderLine orderLine16, orderLine17, orderLine18, orderLine19, orderLine20;
    OrderLine orderLine21, orderLine22, orderLine23, orderLine24, orderLine25;
    OrderLine orderLine26, orderLine27, orderLine28, orderLine29, orderLine30;


    Person p1, p2, p3, p4, p5, p6, p7, p8, p9, p10;
    User u1, u2, u3, u4, u5, u6, u7, u8;
    Manager m1;
    StockKeeper s1, s2;


    Person p11, p12, p13, p14, p15, p16, p17;
    User u11, u12, u13, u14, u15, u16;
    Manager m11, m12;
    StockKeeper s11;

    Person p21, p22, p23, p24, p25, p26, p27, p28;
    User u21, u22, u23, u24, u25, u26;
    Manager m21;
    StockKeeper s21, s22;


    //Person alehegn,khalid,muluadam,daniel,john,jim,rechardson,alicia,meron,


    static LocalDateTime[] getOrderdAndDeliveredDates() {
        LocalDateTime[] dates = new LocalDateTime[2];
        Random rand = new Random();
        int month = rand.nextInt(10) + 1;
        dates[0] = LocalDateTime.of(2020, month, 23, 2, 00);
        dates[0] = LocalDateTime.of(2020, month + 1, 23, 2, 00);
        return dates;
    }


    public University loadData() {

        university = new University("MIU1", "MIU");

        laptop = new Product("p100", "Dell2020", 1500, 30);
        printer = new Product("p101", "HP_Letherjet", 700, 15);
        chair = new Product("p102", "chair1", 130, 20);
        car = new Product("p103", "Ford2021", 35000, 5);
        bike = new Product("p104", "Mongoose", 400, 12);
        TV = new Product("p105", "LG65Inch", 1400, 5);
        dish = new Product("p106", "glassDish", 20, 50);
        fork = new Product("p107", "IronFork", 8, 100);
        mobilePhone = new Product("p108", "iPhone12Pro", 1800, 10);
        book = new Product("p109", "javaBook", 120, 50);
        bottle = new Product("p110", "waterBottle", 12, 60);
        whiteBoard = new Product("p111", "whiteBoard", 100, 20);
        cooler = new Product("p112", "miniCooler", 200, 10);
        refrigrator = new Product("p113", "miniFrig", 300, 15);
        spoon = new Product("p114", "spoon", 10, 200);

        products = Arrays.asList(laptop, car, chair, fork, TV, dish, whiteBoard, bottle, cooler, book, printer, refrigrator, bike);

        orderLine1 = new OrderLine(laptop, 2);
        orderLine2 = new OrderLine(chair, 1);
        orderLine3 = new OrderLine(whiteBoard, 3);
        orderLine4 = new OrderLine(printer, 1);
        orderLine5 = new OrderLine(printer, 2);
        orderLine6 = new OrderLine(bottle, 1);
        orderLine7 = new OrderLine(cooler, 4);
        orderLine8 = new OrderLine(fork, 10);
        orderLine9 = new OrderLine(book, 2);
        orderLine10 = new OrderLine(printer, 1);
        orderLine11 = new OrderLine(car, 1);
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

        LocalDateTime orderDate1 = LocalDateTime.of(2020, Month.JANUARY, 23, 2, 00);
        LocalDateTime returnDate1 = LocalDateTime.of(2020, Month.FEBRUARY, 23, 2, 00);

        LocalDateTime orderDate2 = LocalDateTime.of(2021, Month.MARCH, 10, 4, 30);
        LocalDateTime returnDate2 = LocalDateTime.of(2022, Month.MARCH, 10, 4, 30);

        LocalDateTime orderDate3 = LocalDateTime.of(1019, Month.JUNE, 10, 1, 00);
        LocalDateTime returnDate3 = LocalDateTime.of(2019, Month.JANUARY, 10, 1, 00);

        LocalDateTime orderDate4 = LocalDateTime.of(2020, Month.NOVEMBER, 23, 5, 00);
        LocalDateTime returnDate4 = LocalDateTime.of(2021, Month.AUGUST, 23, 5, 00);

        LocalDateTime orderDate5 = LocalDateTime.of(2021, Month.APRIL, 3, 8, 20);
        LocalDateTime returnDate5 = LocalDateTime.of(2021, Month.SEPTEMBER, 3, 2, 00);

        LocalDateTime orderDate6 = LocalDateTime.of(2021, Month.JULY, 20, 8, 20);
        LocalDateTime returnDate6 = LocalDateTime.of(2021, Month.JULY, 20, 6, 20);

        LocalDateTime orderDate7 = LocalDateTime.of(2021, Month.JULY, 20, 8, 20);
        LocalDateTime returnDate7 = LocalDateTime.of(2021, Month.JULY, 20, 6, 20);

        LocalDateTime orderDate8 = LocalDateTime.of(2021, Month.JULY, 20, 8, 20);
        LocalDateTime returnDate8 = LocalDateTime.of(2021, Month.JULY, 20, 6, 20);

        LocalDateTime orderDate9 = LocalDateTime.of(2021, Month.JULY, 20, 8, 20);
        LocalDateTime returnDate9 = LocalDateTime.of(2021, Month.JULY, 20, 6, 20);


        LocalDateTime orderDate10 = LocalDateTime.of(2021, Month.JULY, 20, 8, 20);
        LocalDateTime returnDate10 = LocalDateTime.of(2021, Month.JULY, 20, 6, 20);


        LocalDateTime orderDate11 = LocalDateTime.of(2021, Month.JULY, 20, 8, 20);
        LocalDateTime returnDate11 = LocalDateTime.of(2021, Month.JULY, 20, 6, 20);

        LocalDateTime orderDate12 = LocalDateTime.of(2021, Month.JULY, 20, 8, 20);
        LocalDateTime returnDate12 = LocalDateTime.of(2021, Month.JULY, 20, 6, 20);


        LocalDateTime orderDate13 = LocalDateTime.of(2021, Month.JULY, 20, 8, 20);
        LocalDateTime returnDate13 = LocalDateTime.of(2021, Month.JULY, 20, 6, 20);

        LocalDateTime orderDate14 = LocalDateTime.of(2021, Month.JULY, 20, 8, 20);
        LocalDateTime returnDate14 = LocalDateTime.of(2021, Month.JULY, 20, 6, 20);

        order1 = new Order("order101",orderDate1, returnDate1, Arrays.asList(orderLine1,orderLine2,orderLine3), OrderStatus.APPROVED);
        order2 = new Order("Order102", orderDate1, returnDate2, Arrays.asList(orderLine2,orderLine3,orderLine1), OrderStatus.DELIVERED);
        order3 = new Order("Order103",orderDate2, returnDate3, Arrays.asList(orderLine3,orderLine2), OrderStatus.DELIVERED);
        order4 = new Order("Order104", orderDate4, returnDate4, Arrays.asList(orderLine1), OrderStatus.DELIVERED);
        order5 = new Order("Order105", orderDate5, returnDate5, Arrays.asList(orderLine2), OrderStatus.REJECTED);
        order6 = new Order("Order106", orderDate6, returnDate6, Arrays.asList(orderLine4), OrderStatus.DELIVERED);
        order7 = new Order("Order107", orderDate1, returnDate2, Arrays.asList(orderLine5), OrderStatus.REJECTED);
        order8 = new Order("Order108", orderDate4, returnDate4, Arrays.asList(orderLine1), OrderStatus.DELIVERED);
        order9 = new Order("Order109", orderDate2, returnDate2, Arrays.asList(orderLine3), OrderStatus.DELIVERED);
        order10 = new Order("Order110", orderDate6, returnDate6, Arrays.asList(orderLine1, orderLine2), OrderStatus.CANCELED);

        List<Order> orders1 = Arrays.asList(order1, order2, order3, order3, order5, order6, order7, order8, order9, order10);

        Department d1 = new Department("12132", "Computer Science");


        order20 = new Order("order100", orderDate1, returnDate1, Arrays.asList(orderLine1, orderLine2,orderLine3), OrderStatus.APPROVED);
        order21 = new Order("Order101", orderDate2, returnDate2, Arrays.asList(orderLine2), OrderStatus.APPROVED);
        order22 = new Order("Order102", orderDate2, returnDate2, Arrays.asList(orderLine2), OrderStatus.APPROVED);
        order23 = new Order("Order103", orderDate3, returnDate3, Arrays.asList(orderLine3), OrderStatus.APPROVED);
        order24 = new Order("Order104", orderDate4, returnDate4, Arrays.asList(orderLine1, orderLine3, orderLine2), OrderStatus.DELIVERED);
        order25 = new Order("Order105", orderDate5, returnDate5, Arrays.asList(orderLine2), OrderStatus.REJECTED);
        order26 = new Order("Order106", orderDate6, returnDate6, Arrays.asList(orderLine4), OrderStatus.DELIVERED);
        order27 = new Order("Order107", orderDate1, returnDate2, Arrays.asList(orderLine5, orderLine4), OrderStatus.REJECTED);
        order28 = new Order("Order108", orderDate4, returnDate4, Arrays.asList(orderLine1), OrderStatus.DELIVERED);
        order29 = new Order("Order109", orderDate2, returnDate2, Arrays.asList(orderLine3), OrderStatus.DELIVERED);
        order30 = new Order("Order110", orderDate6, returnDate6, Arrays.asList(orderLine1, orderLine2, orderLine3), OrderStatus.CANCELED);


        p1 = new Person("389742", "Jet", "Lee", d1);
        u1 = new User(p1, Arrays.asList(order1, order2,order3));
        p1.getRoles().add(u1);

        p2 = new Person("12123", "khalid", "med", d1);
        u2 = new User(p2, Arrays.asList(order1, order2));
        p2.getRoles().add(u2);

        p3 = new Person("97887897", "Alehegne", "Engehela", d1);
        u3 = new User(p3, Arrays.asList(order4, order9));
        p3.getRoles().add(u3);



        p5 = new Person("9786434597", "Ali", "Klayn", d1);
        u5 = new User(p5, Arrays.asList(order5, order4));
        p5.getRoles().add(u5);

        p6 = new Person("23423", "Muluadam", "Madaulum", d1);
        u6 = new User(p6, Arrays.asList(order6));
        p6.getRoles().add(u6);

        p7 = new Person("23423", "Halo", "King", d1);
        u7 = new User(p7, Arrays.asList(order6,order2));
        p7.getRoles().add(u7);

        p8 = new Person("23428", "John", "Sim", d1);
        u8 = new User(p8, Arrays.asList(order7, order10, order9));
        p8.getRoles().add(u8);

        p9 = new Person("87844", "Jean", "Friend", d1);
        s1 = new StockKeeper(p9, Arrays.asList(order4, order9, order6));
        p9.getRoles().add(s1);

        p10 = new Person("236745", "Van", "Dam", d1);
        s2 = new StockKeeper(p9, Arrays.asList(order3, order2));
        p10.getRoles().add(s2);

        p4 = new Person("97453897", "Alis", "Engehela", d1);
        m1 = new Manager(p4, Arrays.asList(order10));
        u4 = new User(p4, Arrays.asList(order3, order8));
        p4.getRoles().add(u4);
        p4.getRoles().add(m1);

        List<Person> people1 = Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10);
        d1.setPersonList(people1);


        Department d2 = new Department("17568", "Mathematics");
        List<Order> listOrder1 = Arrays.asList(order20, order21, order24, order23);
        List<Order> listOrder2 = Arrays.asList(order25, order26, order27, order28, order29, order30);

        p11 = new Person("389742", "Jet", "Lee", d2);
        u11 = new User(p11, Arrays.asList(order20, order21));
        p11.getRoles().add(u11);

        p12 = new Person("23423", "Khan", "Sharo", d2);
        u12 = new User(p12, Arrays.asList(order21, order22));
        p12.getRoles().add(u12);
        m11 = new Manager(p12, listOrder1);
        p12.getRoles().add((m11));

        p13 = new Person("87844", "Salah", "Ali", d2);
        u13 = new User(p13, Arrays.asList(order25, order25, order26));
        p13.getRoles().add(u13);

        p14 = new Person("23428", "Jamal", "Kak", d2);
        u14 = new User(p14, Arrays.asList(order24, order23));
        p14.getRoles().add(u14);

        p15 = new Person("23428", "Josie", "Miso", d2);
        u15 = new User(p15, Arrays.asList(order27, order28, order29, order30));
        p15.getRoles().add(u15);

        p16 = new Person("236745", "Anthony", "Sander", d2);
        u16 = new User(p16, Arrays.asList(order27, order28, order29, order30));
        p16.getRoles().add(u16);
        m12 = new Manager(p16, listOrder2);
        p16.getRoles().add(m12);

        p17 = new Person("389742", "Jims", "Bond", d2);
        s11 = new StockKeeper(p17, Arrays.asList(order24, order26, order28, order29));
        p17.getRoles().add(s11);

        List<Person> people2 = Arrays.asList(p11, p12, p13, p14, p15, p16, p17);
        d2.setPersonList(people2);


        Department d3 = new Department("15632", "Physics");

        order11 = new Order("order111", orderDate1, returnDate1, Arrays.asList(orderLine22), OrderStatus.APPROVED);
        order12 = new Order("Order112", orderDate2, returnDate2, Arrays.asList(orderLine12), OrderStatus.DELIVERED);
        order13 = new Order("Order113", orderDate3, returnDate3, Arrays.asList(orderLine23), OrderStatus.DELIVERED);
        order14 = new Order("Order114", orderDate4, returnDate4, Arrays.asList(orderLine11), OrderStatus.DELIVERED);
        order15 = new Order("Order115", orderDate5, returnDate5, Arrays.asList(orderLine9), OrderStatus.REJECTED);
        order16 = new Order("Order116", orderDate6, returnDate6, Arrays.asList(orderLine6), OrderStatus.DELIVERED);
        order17 = new Order("Order117", orderDate1, returnDate2, Arrays.asList(orderLine14), OrderStatus.REJECTED);
        order18 = new Order("Order118", orderDate4, returnDate4, Arrays.asList(orderLine17), OrderStatus.DELIVERED);
        order19 = new Order("Order119", orderDate2, returnDate2, Arrays.asList(orderLine27), OrderStatus.DELIVERED);
        order20 = new Order("Order120", orderDate6, returnDate6, Arrays.asList(orderLine29, orderLine7), OrderStatus.CANCELED);

        List<Order> listOrder3 = Arrays.asList(order11, order12, order13, order14, order15, order16, order17, order18, order19, order20);
        p21 = new Person("90635", "Hosie", "Foo", d3);
        u21 = new User(p21, Arrays.asList(order11, order12));
        p21.getRoles().add(u21);
        p21 = new Person("44444", "Shoma", "Khar", d3);
        u21 = new User(p21, Arrays.asList(order11, order12));
        p21.getRoles().add(u21);


        p22 = new Person("44444", "Shoma", "Khar", d3);
        u22 = new User(p22, Arrays.asList(order13, order14));
        p22.getRoles().add(u22);
        m21 = new Manager(p22, listOrder3);
        p22.getRoles().add((m21));

        p23 = new Person("89783", "Messi", "Argentina", d3);
        u23 = new User(p23, Arrays.asList(order15, order16));
        p23.getRoles().add(u23);

        p24 = new Person("9098977897", "ODEILNA", "KAKA", d3);
        u24 = new User(p24, Arrays.asList(order16, order17));
        p24.getRoles().add(u24);

        p25 = new Person("97897545", "Ronaldo", "Cristiano", d3);
        u25 = new User(p25, Arrays.asList(order18, order19, order20));
        p25.getRoles().add(u25);

        p26 = new Person("23428", "Josie", "Miso", d3);
        s21 = new StockKeeper(p26, Arrays.asList(order12, order13, order14));
        p26.getRoles().add(s21);

        p27 = new Person("23428", "Zidan", "Zine", d3);
        s22 = new StockKeeper(p27, Arrays.asList(order16, order18, order19));
        p27.getRoles().add(s22);

        p28 = new Person("389742", "Sosan", "Rais", d3);
        u26 = new User(p28, Arrays.asList(order20, order12));
        p28.getRoles().add(u26);
        List<Person> people3 = Arrays.asList(
                p21, p22, p23, p24, p25, p26, p27, p28
        );

        d3.setPersonList(people3);


        university = new University("MIU1", "MIU");

        university.setDepartments(Arrays.asList(d1,d2,d3));

        return university;
    }



}
