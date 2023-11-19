package com.asdeire.oop.practice4.tools;

import com.asdeire.oop.practice4.entities.Account;
import com.asdeire.oop.practice4.entities.Person;
import com.asdeire.oop.practice4.entities.Product;
import java.util.ArrayList;
import java.util.List;

public class DataGenerator {

    public List<Person> generatePeople() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("John"));
        people.add(new Person("Ann"));
        return people;
    }

    public List<Account> generateBankAccounts(List<Person> people, double multiplier) {
        List<Account> accounts = new ArrayList<>();
        String[] currencies = new String[]{"USD", "UAH", "EUR"};
        for (int i = 0; i < people.size(); i++) {
            accounts.add(new Account("ACC" + (i + 1),
                1000*multiplier, people.get(i)));
        }
        return accounts;
    }

    public List<Product> generateProducts(double multiplier) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Smartwatch", 250*multiplier));
        products.add(new Product("Wireless Earbuds", 120*multiplier));
        products.add(new Product("Gaming Laptop", 1800*multiplier));
        products.add(new Product("VR Headset", 500*multiplier));
        products.add(new Product("Fitness Tracker", 80*multiplier));
        products.add(new Product("Coffee Maker", 60*multiplier));
        products.add(new Product("Bluetooth Speaker", 100*multiplier));
        products.add(new Product("External Hard Drive", 70*multiplier));
        products.add(new Product("Smart Thermostat", 120*multiplier));
        products.add(new Product("Robot Vacuum", 300*multiplier));
        return products;
    }
}
