package jmp.bank.api;

import jmp.dto.BankCard;
import jmp.dto.BankCardType;
import jmp.dto.User;

public interface IBank {
    /**
     * With the user information creates a BankCard object
     * @param cardNumber
     * @param userIn
     * @param type
     * @return
     */
    BankCard createBankCard(String cardNumber, User userIn, BankCardType type);
}
