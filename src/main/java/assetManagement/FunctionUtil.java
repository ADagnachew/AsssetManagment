package assetManagement;

import org.hamcrest.core.IsInstanceOf;

import java.awt.desktop.SystemSleepEvent;
import java.sql.SQLOutput;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class FunctionUtil {

    /**  every query implementation will goes here*/

    /**
     * This Function is a helper function to find the list of Roles from the University
     **/

    //start of med khalid's work
    public static Function<University, List<Person>> getPersons = uni ->
            Stream.of(uni).flatMap(u -> u.getDepartments().stream())
                    .flatMap(dep -> dep.getPersonList().stream()).collect(Collectors.toList());

    private static Function<University, Stream<Role>> getRoles = uni ->
            getPersons.apply(uni).stream()
                    .flatMap(p -> p.getRoles().stream());

    public static Function<University, List<User>> getUsers = uni ->
            getRoles.apply(uni)
                    .filter(r -> r instanceof User)
                    .map(user -> (User) user).collect(Collectors.toList());

    public static Function<University, List<Manager>> getManagers = uni ->
            getRoles.apply(uni)
                    .filter(r -> r instanceof Manager)
                    .map(manager -> (Manager) manager).collect(Collectors.toList());

    public static Function<University, List<StockKeeper>> getStockKeepers = uni ->
            getRoles.apply(uni)
                    .filter(r -> r instanceof StockKeeper)
                    .map(s -> (StockKeeper) s).collect(Collectors.toList());


    public static BiFunction<University, String, Department> getDepartByName = (uni, depName) ->
            Stream.of(uni).flatMap(u -> u.getDepartments().stream())
                    .filter(dep -> dep.getName().equals(depName))
                    .findFirst().get();


    public static BiFunction<University, String, List<Person>> getPersonsByDepartement = (uni, depName) ->
            Stream.of(getDepartByName.apply(uni, depName))
                    .flatMap(dep -> dep.getPersonList().stream())
                    .collect(Collectors.toList());

    // helper function
    public static Function<Order, Integer> getQuatityOfProductsInOrder = order ->
            Stream.of(order).flatMap(o -> o.getOrderLines().stream()).mapToInt(oLine -> oLine.getQuantity()).sum();

    // helper functiom
    public static TriFunction<List<Order>, Integer, Long, List<Order>> getOrdersWithNProductInYear = (orders, n, year) ->
            orders.stream()
                    .filter(order -> getQuatityOfProductsInOrder.apply(order) == n && order.getOrderDate().getYear() == year)
                    .collect(Collectors.toList());
    //get K users sorted by number of orders that have N quantity of products in a spesific year
    public static QuadFunction<University, Long, Integer, Long, List<User>> getKUserSortedByNumberOfOrdersThatHaveNQuantityOfProductAtYear =
            (uni, k, n, year) ->
                    getUsers.apply(uni).stream()
                            .map(user -> new Tuple(user, getOrdersWithNProductInYear.apply(user.getOrders(), n, year).stream().count()))
                            .filter(t -> (long) t.getValue() != 0)
                            .sorted((t1, t2) -> Long.compare((long) t2.getValue(), (long) t1.getValue()))
                            .limit(k)
                            .map(t -> (User) t.getKey()).collect(Collectors.toList());

    // helper function
    public static BiFunction<User, Long, List<Order>> getAllOrdersDelivredInYear = (user, year) ->
            Stream.of(user)
                    .flatMap(u -> u.getOrders().stream())
                    .filter(order -> order.getOrderStatus() == OrderStatus.DELIVERED && order.getOrderDate().getYear() == year)
                    .collect(Collectors.toList());

    public static TriFunction<University, Long, Long, List<Product>> getTheBestKProductInYearSortedByQntity = (uni, k, year) ->
            getUsers.apply(uni).stream()
                    .filter(user -> getAllOrdersDelivredInYear.apply(user, year).size() != 0)
                    .flatMap(user -> getAllOrdersDelivredInYear.apply(user, year).stream())
                    .flatMap(order -> order.getOrderLines().stream())
                    .map(orderLine -> new Tuple<Product, Integer>(orderLine.getProduct(), orderLine.getQuantity()))
                    .collect(Collectors.groupingBy(t -> t.getKey(), Collectors.summingInt(t -> t.getValue())))
                    .entrySet().stream()
                    .limit(k)
                    .sorted((t1, t2) -> Integer.compare(t2.getValue(), t1.getValue()))
                    .map(t -> t.getKey()).collect(Collectors.toList());
// HELPER FUNCTION
    public static Function<Department, Long> getNumberUsersByDepartement = department ->
            Stream.of(department)
                    .flatMap(dep -> dep.getPersonList().stream())
                    .flatMap(p -> p.getRoles().stream())
                    .filter(r -> r instanceof User)
                    .map(u -> (User) u)
                    .count();
    // HELPER FUNCTION
    public static Function<List<Order>, Long> numberOfOrdersApproved = orders ->
            orders.stream().filter(order -> order.getOrderStatus() != OrderStatus.REJECTED)
                    .collect(Collectors.toList()).stream().count();
    public static Function<Manager, Long> numberOfOrdersApprovedByAManager = manager ->
            Stream.of(manager)
                    .mapToLong(m -> numberOfOrdersApproved.apply(m.getOrders())).sum();

    // FUNCTION WHICH RETURN K BEST MANAGERS
    public static BiFunction<University, Long, List<Manager>> getKGoodManagers = (uni, k) ->
            getManagers.apply(uni).stream()
                    .map(manager -> new Tuple(manager, numberOfOrdersApprovedByAManager.apply(manager)))
                    .collect(Collectors.toMap(t -> t.getKey(), t -> t.getValue()))
                    .entrySet().stream()
                    .limit(k)
                    .sorted((t1, t2) -> {
                        long v2 = (long) t2.getValue(), v1 = (long) t1.getValue();
                        return Long.compare(v2, v1);
                    })
                    //.peek(t-> System.out.println(t.getValue()))
                    .map(t -> (Manager) t.getKey()).collect(Collectors.toList());
    //end of med khalid's work


//Start Alehegn's work

    /**
     * Helper Function to find the number of orders a sock keeper delivered to a customer in a year
     */
    public static BiFunction<StockKeeper, Integer, Long> numberOfOrdersStockKeeperDeliver = (stockKeeper, year) ->
            stockKeeper.getOrders().stream()
                    .filter(order -> order.getOrderStatus() == OrderStatus.DELIVERED)
                    .filter(order -> order.getOrderDate().getYear() == year)
                    .collect(Collectors.counting());

    /**
     * This Function finds the the stock keeper who deliver a lot of products in a specific year
     * and prints their last name in Uppercase, I used the helper #numberOfOrdersStockKeeperDeliver
     */

    public static BiFunction<University, Integer, String> bestStockKeeper = (university, year) ->
            getStockKeepers.apply(university).stream()
                    .sorted((s1, s2) -> (int) (numberOfOrdersStockKeeperDeliver.apply(s2, year)
                            - numberOfOrdersStockKeeperDeliver.apply(s1, year)))
                    .map(stockKeeper -> stockKeeper.getPerson().getLastName().toUpperCase())
                    .findFirst().get();

    /**
     * list of product Name which by specific by specific user taken in the given year
     */
    public static TriFunction<University, String, Long, List<String>> listOfProductsBySpecificUserInAYear = (university, userId, year) ->
            getUsers.apply(university).stream()
                    .filter(user -> user.getPerson().getId().equals(userId))
                    .flatMap(user -> user.getOrders().stream())
                    .filter(order -> order.getOrderDate().getYear() == year &&
                            order.getOrderStatus().equals(OrderStatus.DELIVERED))
                    .flatMap(order -> order.getOrderLines().stream())

                    .map(orderLine -> orderLine.getProduct().getProductName())
                    .distinct()
                    .collect(Collectors.toList());

    public static BiFunction<User, Integer, Long> numberOfOrdersByCustomer = (user, year) ->
            Stream.of(user)
                    .flatMap(u -> u.getOrders().stream())
                    .filter(order -> order.getOrderDate().getYear() == year)
                    .filter(order -> order.getOrderStatus().equals(OrderStatus.DELIVERED))
                    .count();

    /**
     * A Function to find top K list First Names of Customer who make high order in a specific year
     */
    public static TriFunction<University, Integer, Long, List<String>> customersWhoGotManyOrdersInYear = (university, year, k) ->
            getUsers.apply(university).stream()

                    .sorted((user1, user2) -> (int)
                            (numberOfOrdersByCustomer.apply(user2, year) - numberOfOrdersByCustomer.apply(user1, year)))
                    .map(user -> user.getPerson().getFirstName()).distinct()
                    .limit(k).collect(Collectors.toList());


    //End Alehegn's work


//start Muluadam work here


    public static Function<User, Boolean> hasUserOverDue = (user) ->
            Stream.of(user)
                    .flatMap(u -> u.getOrders().stream())
                    .filter(order -> order.getOrderStatus().equals(OrderStatus.DELIVERED))
                    .filter(order -> order.getOrderStatus().equals(OrderStatus.DELIVERED))
                    .filter(order -> order.getReturnDate().isBefore(LocalDateTime.now()))
                    .count() > 0;


    /**
     *
     */
    public static Function<University, List<String>> getUsersWhoShouldReturn = (uni) ->
            getUsers.apply(uni).stream()
                    .filter(user -> hasUserOverDue.apply(user))
                    .map(order -> order.getPerson().getFirstName())//+" ->  "+ (diff.apply(order.getReturnDate(),LocalDateTime.now()) ))
                    .collect(Collectors.toList());

    public static BiFunction<University, String, Long> getApprovedProducts = (uni, prodctName) ->
            getUsers.apply(uni).stream()
                    .flatMap(u -> u.getOrders().stream())

                    .filter(order -> order.getOrderStatus() == OrderStatus.DELIVERED)

                    .flatMap(ol -> ol.getOrderLines().stream())
                    .filter(ol -> ol.getProduct().getProductName() == prodctName)
                    .collect(Collectors.counting());

    public static BiFunction<University, String, Long> getNotApprovedProducts = (uni, prodctName) ->
            getUsers.apply(uni).stream()
                    .flatMap(u -> u.getOrders().stream())
                    .filter(order -> order.getOrderStatus() != OrderStatus.DELIVERED || order.getOrderStatus() != OrderStatus.CANCELED)
                    .flatMap(ol -> ol.getOrderLines().stream())
                    .filter(ol -> ol.getProduct().getProductName() == prodctName)
                    .collect(Collectors.counting());

    public static BiFunction<University, String, String> probability = (uni, prodctName)
            -> (100 * (getApprovedProducts.apply(uni, prodctName)
            / (getNotApprovedProducts.apply(uni, prodctName) * 1.0 + 1.0 * getApprovedProducts.apply(uni, prodctName)))) + " %";

    /**
     * TODO: list of users with the Items that are not returned
     */

    public static BiFunction<University, Integer, Map<String, Long>> getUsersOverDueWithProduct = (uni, k) ->
            getUsers.apply(uni).stream()
                    .flatMap(order -> order.getOrders().stream())
                    .filter(order -> order.getOrderStatus().equals(OrderStatus.DELIVERED))

                    .filter(order -> order.getReturnDate().isBefore(LocalDateTime.now()))
                    .collect(Collectors.groupingBy(order -> order.getOrderId(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted((o1, o2) -> (int) (o1.getValue() - o2.getValue()))
                    .limit(k)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


    public static BiFunction<University, Integer, Map<String, Long>> getAmountOfProductsWaitingForDelivery = (uni, k) ->
            getUsers.apply(uni).stream()
                    .flatMap(order -> order.getOrders().stream())
                    .filter(order -> order.getOrderStatus().equals(OrderStatus.APPROVED))
                    .flatMap(order -> order.getOrderLines().stream())

                    .collect(Collectors.groupingBy(orderLine -> orderLine.getProduct().getProductName(), Collectors.counting()))
                    .entrySet()
                    .stream()
                    .sorted((o1, o2) -> (int) (o2.getValue() - o1.getValue()))
                    .limit(k)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));


    /**
     * TODO: Total Asset of the university deliverd to customers
     *
     * @Param University
     * @Param year
     * @return Total price value of product delivered in a year
     */

    public static BiFunction<University, Integer, Double> getTotalAssetHoldByUsersInaYear = (university, year) ->
            getManagers.apply(university).stream()
                    .flatMap(manager -> manager.getOrders().stream())
                    .filter(order -> order.getOrderStatus().equals(OrderStatus.DELIVERED))
                    .filter(order -> order.getOrderDate().getYear() == year)
                    .flatMap(or -> or.getOrderLines().stream())
                    .mapToDouble(orderLine -> orderLine.getProduct().getPrice()).sum();


    /**
     * TODO: Total Asset value of the university deliverd to customers
     * TODO:Teested--
     *
     * @Param University
     * @return Total value of the prices hold by users
     */
    public static Function<University, Double> getTotalAssetHoldByUsers = (university) ->
            getManagers.apply(university).stream()
                    .flatMap(manager -> manager.getOrders().stream())
                    .filter(order -> order.getOrderStatus().equals(OrderStatus.DELIVERED))
                    .flatMap(order -> order.getOrderLines().stream())
                    .mapToDouble(ol -> ol.getProduct().getPrice()).sum();


    public static Function<University, Double> getTotalAssetHoldByUsersAverege = (university) ->
            getManagers.apply(university).stream()
                    .flatMap(manager -> manager.getOrders().stream())
                    .filter(order -> order.getOrderStatus().equals(OrderStatus.DELIVERED))
                    .flatMap(order -> order.getOrderLines().stream())
                    .mapToDouble(ol -> ol.getProduct().getPrice()).average().orElse(0.0);


    //End Muluadam Work


}


