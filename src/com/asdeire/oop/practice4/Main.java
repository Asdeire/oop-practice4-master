package com.asdeire.oop.practice4;

import com.asdeire.oop.practice4.entities.Account;
import com.asdeire.oop.practice4.entities.Person;
import com.asdeire.oop.practice4.entities.Product;
import com.asdeire.oop.practice4.tools.DataGenerator;
import java.util.*;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        double multiplier = 1;

        // Вибір валюти
        System.out.println("Select currency:");
        System.out.println("1. USD");
        System.out.println("2. UAH");
        System.out.println("3. EUR");
        System.out.print("Enter the number: ");
        int currencyChoice = scanner.nextInt();

        // Визначення валюти
        String[] currency;
        switch (currencyChoice) {
            case 1:
                currency = new String[]{"USD"};
                multiplier = 1;
                break;
            case 2:
                currency = new String[]{"UAH"};
                multiplier = 35;
                break;
            case 3:
                currency = new String[]{"EUR"};
                multiplier = 0.92;
                break;
            default:
                System.out.println("Invalid currency choice. Defaulting to USD.");
                currency = new String[]{"USD"};
                break;
        }

        String selectedCurrency = currency[0];

        DataGenerator dataGenerator = new DataGenerator();

        List<Person> people = dataGenerator.generatePeople();
        List<Account> accounts = dataGenerator.generateBankAccounts(people, multiplier);
        List<Product> products = dataGenerator.generateProducts(multiplier);

        Person person = null;

        for (int i = 0; i < people.size(); i++) {
            Person currentPerson = people.get(i);
            Account account = accounts.get(i);

            Account.BankCard card = account.new BankCard("Card" + account.getAccountNumber().substring(3));
            account.addCard(card);

            currentPerson.setBankAccount(account);
            currentPerson.addBankCard(card);

            if (i == 0) {
                person = currentPerson;
            }
        }
        person.authorize();
        person.showInformation(selectedCurrency);


        System.out.println("Available Products:");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(
                (i + 1) + ". " + products.get(i).getName() + " - "
                    + products.get(i).getPrice()  + " " + selectedCurrency);
        }

        System.out.print("Enter the number of the product you want to buy: ");
        int productNumber = scanner.nextInt();
        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();



        if (productNumber > 0 && productNumber <= products.size()) {
            Product selectedProduct = products.get(productNumber - 1);
            Account.BankCard personCard = person.getBankCard(
                "Card" + person.getBankAccount().getAccountNumber().substring(3));
            performTransaction(person, personCard, selectedProduct, quantity, selectedCurrency);
        } else {
            System.out.println("Invalid product number.");
        }
    }

    private static void performTransaction(Person person, Account.BankCard card, Product product,
        int quantity, String selectedCurrency) {
        double totalAmount = product.getPrice() * quantity;
        double balance = card.getBankAccount().getBalance();
        if(totalAmount <= balance) {
            card.withdraw(totalAmount);
            double remainingBalance = balance - totalAmount;
            System.out.println(person.getName() + " [" + card.getCardNumber() + "] bought " +
                quantity + " " + product.getName() + " for " +
                totalAmount + " " + selectedCurrency +
                " on " + new Date() + ". Remaining balance: " + remainingBalance + " "
                + selectedCurrency);
        }else {
            System.out.println("Transaction failed. Insufficient funds.");
        }
    }
}
