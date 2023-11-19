package com.asdeire.oop.practice4.entities;

import com.asdeire.oop.practice4.entities.Account.BankCard;
import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private Account account;
    private List<BankCard> bankCards;

    public Person(String name) {
        this.name = name;
        this.bankCards = new ArrayList<>();
    }

    public void authorize() {
        System.out.println(name + " is authorized.");
    }

    public void setBankAccount(Account account) {
        this.account = account;
    }

    public void addBankCard(Account.BankCard bankCard) {
        bankCards.add(bankCard);
    }

    public Account getBankAccount() {
        return account;
    }

    public String getName() {
        return name;
    }

    public void showInformation(String selectedCurrency) {
        System.out.println("Person: " + name);
        if (account != null) {
            System.out.println("Bank Account: " + account.getAccountNumber());
            System.out.println("Balance: " + account.getBalance() + " " + selectedCurrency);
            System.out.println("Bank Cards:");
            for (Account.BankCard card : bankCards) {
                System.out.println("- " + card.getCardNumber());
            }
        } else {
            System.out.println("No bank account associated.");
        }
    }

    public Account.BankCard getBankCard(String cardNumber) {
        for (Account.BankCard card : bankCards) {
            if (card.getCardNumber().equals(cardNumber)) {
                return card;
            }
        }
        return null;
    }
}
