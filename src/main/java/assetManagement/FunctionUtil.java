package assetManagement;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class FunctionUtil {

    /**every query implementation will goes here*/

    /**  This Function is a helper function to find the list of Roles from the University**/
    static Function<University, List<Role>> getRoles = university -> Stream.of(university)
            .flatMap(uni -> uni.getDepartments().stream())
            .flatMap(department -> department.getPersonList().stream())
            .flatMap(person -> person.getRoles().stream())
            .collect(Collectors.toList());

    /**  This Function is a helper function to find the list of Users from the University using getRoles helper Function**/
    static Function<University,List<User>> getUsers = university -> getRoles.apply(university).stream()
            .filter(role -> role instanceof User)
            .map(role -> (User)role)
            .collect(Collectors.toList());

    /**  This Function is a helper function to find the list of Managers from the University using getRoles helper Function**/
    static Function<University,List<Manager>> getManagers = university -> getRoles.apply(university).stream()
            .filter(role -> role instanceof Manager)
            .map(role -> (Manager)role)
            .collect(Collectors.toList());

    /**  This Function is a helper function to find the list of stockKeepers from the University using getRoles helper Function**/
    static Function<University,List<StockKeeper>> getStockKeepers = university -> getRoles.apply(university).stream()
            .filter(role -> role instanceof StockKeeper)
            .map(role -> (StockKeeper) role)
            .collect(Collectors.toList());

    /**  This Query return the list of top K users who order many times*/
    static BiFunction<University,Long,List<User>> topKUsersWhoOrderManyProduct = (university, k) ->
            getUsers.apply(university).stream()
            .sorted((u1,u2) -> (int)(u2.getOrders().stream().count() - u1.getOrders().stream().count()))
            .limit(k)
            .collect(Collectors.toList());

    /**  Top K products in the university by the price*/


}
