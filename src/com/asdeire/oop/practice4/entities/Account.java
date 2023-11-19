package com.asdeire.oop.practice4.entity;

import java.util.Arrays;

public class Account {

    private String accountNumber;
    private double balance;
    private String[] currency;
    private Person owner;

    public Account(String accountNumber,double balance, String[] currency, Person owner){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.currency = currency;
        this.owner = owner;
    }

    public static class CurrencyType {
        public static final String USD = "USD";
        public static final String EUR = "EUR";
        public static final String UAH = "UAH";
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public String[] getCurrencies() {
        return currency;
    }

    public Person getOwner(){
        return owner;
    }

    public class BankCard{
        private String cardNumber;
        private Account account;

        public BankCard(String cardNumber){
            this.cardNumber = cardNumber;
        }

        private boolean isValidCurrency(String currency) {
            return Arrays.asList(currency).contains(currency);
        }

        public void withdraw(double amount, String currency) {
            if (isValidCurrency(currency) && amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawal successful. Remaining balance: " + balance + " " + currency);
            } else {
                System.out.println("Withdrawal failed. Insufficient funds.");
            }
        }

        public void deposit(double amount, String currency) {
            if (isValidCurrency(currency) && amount > 0) {
                balance += amount;
                System.out.println("Deposit successful. New balance: " + balance + " " + currency);
            } else {
                System.out.println("Deposit failed. Invalid amount.");
            }
        }
        public void setBankAccount(Account account) {
            this.account = account;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public Account getBankAccount() {
            return account;
        }
    }

    public void addCard(BankCard card){
        card.setBankAccount(this);
    }
}
