package jmp.service.api;

import jmp.dto.BankCard;
import jmp.dto.BankCardType;
import jmp.dto.Subscription;
import jmp.dto.User;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author Esteban_Lopez1
 */
public interface IService {

    void subscribe(BankCard bankCard, BankCardType t);

    Optional<Subscription> getSubscriptionByBankCardNumber(String input);

    List<User> getAllUsers();

    List<Subscription> getAllSubscriptionsByCondition(Predicate<Subscription> input);

    /**
     * Default method that gets the user list and for every birthday checks the years counting from today, finally
     * returns the average.
     * @return double value of the average ages of the users registered
     */
    default double getAverageUsersAge() {
        var userList = getAllUsers();
        var birthDates = userList.stream().map(user -> user.getBirthDay()).collect(Collectors.toList());
        var aux = new ArrayList<Double>();

        aux = new ArrayList<>(birthDates.stream()
                .map((s) -> Double.valueOf(ChronoUnit.YEARS.between(s,LocalDate.now())).doubleValue()).collect(Collectors.toList()));

        System.out.println(aux);

        return aux.stream().mapToDouble(d -> d).average().orElse(0);
        //Period period = Period.between(dateOfBirth, LocalDate.now());
    }

    /**
     * For a user checks if its 18 years old or more
     * @param u User Object
     * @return boolean state, true if payable.
     */
    static boolean isPayableUser(User u){
        var age = Period.between(u.getBirthDay(),LocalDate.now()).getYears();
        boolean selection = (age >= 18 ?  true:  false);
        return selection;
    }

}
