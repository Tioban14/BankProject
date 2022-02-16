import jmp.bank.api.IBank;
import jmp.cloud.bank.impl.BankImpl;

module jmp.cloud.bank.impl {
    requires  transitive jmp.bank.api;
    requires jmp.dto;
    exports jmp.cloud.bank.impl;
    provides IBank with BankImpl;
}