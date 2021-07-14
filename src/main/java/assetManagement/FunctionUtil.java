package assetManagement;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class FunctionUtil {

    /**  every query implementation will goes here*/

    /**
     * This Function is a helper function to find the list of Roles from the University
     **/
    static Function<University, List<Role>> getRoles = university -> Stream.of(university)
            .flatMap(uni -> uni.getDepartments().stream())
            .flatMap(department -> department.getPersonList().stream())
            .flatMap(person -> person.getRoles().stream())
            .collect(Collectors.toList());

    /**
     * This Function is a helper function to find the list of Users from the University using getRoles helper Function
     **/
    static Function<University, List<User>> getUsers = university -> getRoles.apply(university).stream()
            .filter(role -> role instanceof User)
            .map(role -> (User) role)
            .collect(Collectors.toList());

    /**
     * This Function is a helper function to find the list of Managers from the University using getRoles helper Function
     **/
    static Function<University, List<Manager>> getManagers = university -> getRoles.apply(university).stream()
            .filter(role -> role instanceof Manager)
            .map(role -> (Manager) role)
            .collect(Collectors.toList());

    /**
     * This Function is a helper function to find the list of stockKeepers from the University using getRoles helper Function
     **/
    static Function<University, List<StockKeeper>> getStockKeepers = university -> getRoles.apply(university).stream()
            .filter(role -> role instanceof StockKeeper)
            .map(role -> (StockKeeper) role)
            .collect(Collectors.toList());

    /**
     * A Function to find list of top K Users who order product many times form the university in a specific year
     */
    static TriFunction<University, Integer, Long, List<User>> customerWithApprovedOrdersInYear = (university, year, k) ->
            getUsers.apply(university).stream()
                    .flatMap(user -> user.getOrders().stream())
                    .filter(order -> order.getOrderStatus() == OrderStatus.DELIVERED)
                    .filter(order -> order.getOrderDate().getYear() == year)
                    .map(order -> order.getUser())
                    .sorted((user1, user2) -> (int)
                            (user2.getOrders().stream().count() - user1.getOrders().stream().count()))
                    .limit(k).collect(Collectors.toList());

    /**
     * Helper Function to find the number of orders a sock keeper delivered to a customer in a year
     */
    static BiFunction<StockKeeper, Integer, Long> numberOfOrdersStockKeeperDeliver = (stockKeeper, year) ->
            stockKeeper.getOrders().stream()
                    .filter(order -> order.getOrderStatus() == OrderStatus.DELIVERED)
                    .filter(order -> order.getOrderDate().getYear() == year)
                    .collect(Collectors.counting());

    /**
     * This Function finds the the stock keeper who deliver a lot of products in a specific year
     * and prints their last name in Uppercase  */

    static BiFunction<University, Integer, String> bestStockKeeper = (university, year) ->
            getStockKeepers.apply(university).stream()
                    .sorted((s1, s2) -> (int) (numberOfOrdersStockKeeperDeliver.apply(s2, year)
                            - numberOfOrdersStockKeeperDeliver.apply(s1, year)))
                    .map(stockKeeper -> stockKeeper.getPerson().getLastName().toUpperCase())
                    .findFirst().get();

    /** List of orders by a user*/
    static Function<User,List<Order>> listOfOrdersByAUser = user -> user.getOrders()
            .stream().collect(Collectors.toList());

    /** list of products which ordered by specific by users*/
    static BiFunction<University,String,List<String>> productWithHighDemand = (university, userId) ->
            getUsers.apply(university).stream()
                    .filter(user -> user.getPerson().getId().equals(userId))
            .flatMap(user -> user.getOrders().stream())
            .map(order -> order.getProduct().getProductName())
            .collect(Collectors.toList());

}


