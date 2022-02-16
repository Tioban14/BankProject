package Application;

import jmp.cloud.bank.impl.BankImpl;
import jmp.cloud.service.impl.ServiceImpl;
import jmp.cloud.service.impl.NotFoundException;
import jmp.dto.BankCardType;
import jmp.dto.User;
import jmp.service.api.IService;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Serves as the main class having the runnable main method with the menu and statements
 * that call the implementations of the other modules.
 * @author Esteban_Lopez1
 */
public class App {

    public static Scanner scan = new Scanner(System.in);
    public static ServiceImpl cloudService = new ServiceImpl();

    /**
     * Is the input and output program, loops printing statements and reading the input user
     * depending on the selection.
     * @param args unused
     */
    public static void main(String[] args) {
        var statement = "";

        do {
            printStatements();
            statement = scan.next();
            methodSelector(statement);

        } while (!statement.equalsIgnoreCase("EXIT"));
        System.out.println("Program closed successfully");
    }

    /**
     * Selects the method to perform depending on choice, if invalid prints the warning and returns.
     * @param input Is the user input
     */
    private static void methodSelector(String input) {
        switch (input.toUpperCase()) {
            case "SUB":
                appSubscribe();
                break;
            case "SEARCH":
                try{
                    appSearch();
                }catch(NotFoundException f){
                    System.out.println("Not found");
                }
                break;
            case "GETUSER":
                appGetUser();
                break;
            case "AVERAGE":
                appAverage();
                break;
            case "PAYABLE":
                appPayable();
                break;
            case "GETSUB":
                appGetSub();
                break;
            default:
                if (!input.equalsIgnoreCase("exit")) {
                    System.out.println("Unknown command");
                }
                break;
        }
    }

    /**
     * Calls the implementation of Service interface and prints all users after getting the List
     * of subscriptions
     */
    private static void appGetSub() {
        var x = cloudService.getAllSubscriptionsByCondition((s)->s.getBankCard()!=null);
        x.forEach(System.out::println);
    }

    /**
     * Consults the data and checks if the user is payable (user>18 years old)
     */
    private static void appPayable() {
        System.out.println("Enter the name of the user to consult");
        var name = scan.next();
        System.out.println("Enter the surname of the user to consult");
        var surname = scan.next();
        System.out.println("Enter the birthday of the user to consult");
        var birthDay = scan.next();
        if(IService.isPayableUser(new User(name,surname,LocalDate.parse(birthDay)))){
            System.out.println("The user is Payable");
        }else{
            System.out.println("The user is not Payable");
        }
    }

    /**
     * Calls the Service implementation and gets the result of average age
     */
    private static void appAverage() {
        System.out.println(cloudService.getAverageUsersAge());
    }

    /**
     * Gets and prints all users
     */
    private static void appGetUser() {
        var x = cloudService.getAllUsers();
        x.forEach(System.out::println);
    }

    /**
     * Gets the subscription that matches the input number, or throws exception
     * @throws NotFoundException Custom exception
     */
    private static void appSearch() throws NotFoundException {
        System.out.println("Enter the cardnumber to search");
        var number = scan.next();
        var y = cloudService.getSubscriptionByBankCardNumber(number);
        System.out.println(y.orElseThrow((()->new NotFoundException("Element not found"))));

    }

    /**
     * Gets the user input to register a User with his bank information
     */
    private static void appSubscribe() {
        System.out.println("Enter the name to register");
        var name = scan.next();
        System.out.println("Enter the Surname");
        var surname = scan.next();
        System.out.println("Enter the birthday in format yyyy-mm-dd");
        var date = scan.next();
        var user = new User(name, surname, LocalDate.parse(date));
        System.out.println("Enter the bankcard");
        var b = scan.next();
        System.out.println("Enter the bankcard type: Credit/Debit");
        BankCardType cardType;
        var type = scan.next();
        while (!type.equalsIgnoreCase("DEBIT")||
                !type.equalsIgnoreCase("CREDIT")){
            System.out.println("Enter a correct type");
            type = scan.next();
        }
        if(type.equalsIgnoreCase("DEBIT")){
            cardType = BankCardType.DEBIT;
        }else{
            cardType = BankCardType.CREDIT;
        }

        var card = new BankImpl();
        var finalCard = card.createBankCard(b,user,cardType);
        cloudService.subscribe(finalCard,cardType);
        System.out.println("Subscribed successfully");
    }

    /**
     * Prints the different options of the program
     */
    private static void printStatements() {
        System.out.println("\nIf you want to subscribe a user enter SUB");
        System.out.println("If you want to search by cardnumber enter SEARCH");
        System.out.println("If you want to see all users enter GETUSER");
        System.out.println("if you want to get average users age enter AVERAGE");
        System.out.println("If you want to know if a user is payable enter PAYABLE");
        System.out.println("If you want to see all subscriptions enter GETSUB");
        System.out.println("If you want to exit the program enter EXIT");
    }
}
