package jmp.dto;

import java.time.LocalDate;

/**
 * @author Esteban_Lopez1
 */
public class Subscription {
    private String cardNumber;
    private LocalDate startDate;

    /**
     * Constructor
     * @param cardNumber
     * @param startDate
     */
    public Subscription(String cardNumber, LocalDate startDate){
        this.cardNumber = cardNumber;
        this.startDate = startDate;
    }

    public String getBankCard() {
        return cardNumber;
    }

    @Override
    public String toString() {
        return "Subscription => " + "bankCard: \t" + cardNumber +
                "\t\tstartDate:" + startDate;
    }
}
