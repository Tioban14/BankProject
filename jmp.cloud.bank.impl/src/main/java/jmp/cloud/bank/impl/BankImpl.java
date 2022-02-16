package jmp.cloud.bank.impl;

import jmp.bank.api.IBank;
import jmp.dto.*;

/**
 * Is the implementation of the Bank interface
 */
public class BankImpl implements IBank {
    private BankCardType cardType;

    /**
     * Creates a BankCard object depending on the parameter.
     * @param cardNumber  Only the number
     * @param userIn The user owner of the card
     * @param type Selects the type of object to create.
     * @return
     */
    @Override
    public BankCard createBankCard(String cardNumber, User userIn, BankCardType type) {
        this.cardType = type;
        if (type == BankCardType.CREDIT) {
            ICreditFunctional credit = CreditBankCard::new;
            return credit.function(cardNumber, userIn);
            //return new CreditBankCard(cardNumber, userIn);
        } else {
            IDebitFunctional debit = DebitBankCard::new;
            return debit.function(cardNumber, userIn);
            //return new DebitBankCard(cardNumber, userIn);
        }
    }
}

/**
 * For the implementation with method references
 */
interface ICreditFunctional {
    CreditBankCard function(String cardNumber, User user);
}

/**
 * For the implementation with method references
 */
interface IDebitFunctional {
    DebitBankCard function(String cardNumber, User user);
}