package com.asdeire.oop.practice4.entities;

public class Account {

    private String accountNumber;
    private double balance;
    private Person owner;


    public Account(String accountNumber,double balance, Person owner){
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public class BankCard{
        private String cardNumber;
        private Account account;

        public BankCard(String cardNumber){
            this.cardNumber = cardNumber;
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
            } else {
                System.out.println("Withdrawal failed. Insufficient funds.");
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
