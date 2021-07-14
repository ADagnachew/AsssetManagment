import assetManagement.*;
import org.junit.Before;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

public class FunctionUtilTest {

    University university;
    List<Product> products;
    List<Person> users;
    List<Person> managers;
    List<StockKeeper> stockKeepers;
    List<Order> orders;


    Product laptop, printer,chair,bike,car,TV,dish,fork,mobilePhone,book,bottle,cooler,whiteBoard,refrigrator;
    Order order1, order2, order3, order4,order5,order6, order7,order8,order9,order10;
    OrderLine orderLine1,orderLine2,orderLine3,orderLine4,orderLine5;

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


        orderLine1 = new OrderLine(laptop,2);
        orderLine2 = new OrderLine(chair,1);
        orderLine3 = new OrderLine(whiteBoard,3);
        orderLine4 = new OrderLine(printer,2);
        orderLine5 = new OrderLine(bottle, 1);

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

        order1 = new Order("order101", 1,orderDate1,returnDate1);
        order2 = new Order("Order102",2,orderDate2,returnDate2);
        order3 = new Order("Order103",3,orderDate3,returnDate3);
        order4 = new Order("Order104",1,orderDate4,returnDate4);
        order5 = new Order("Order105",1,orderDate5,returnDate5);
        order6 = new Order("Order106",1,orderDate6,returnDate6);
        order7 = new Order("Order107",1,orderDate1,returnDate2);
        order8 = new Order("Order108",1,orderDate4,returnDate4);
        order9 = new Order("Order109",2,orderDate2,returnDate2);
        order10 = new Order("Order104",1,orderDate6,returnDate6);
    }

}
