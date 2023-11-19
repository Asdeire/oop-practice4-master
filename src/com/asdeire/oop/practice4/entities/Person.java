package com.asdeire.oop.practice4.entity;

import com.asdeire.oop.practice4.entity.Account.BankCard;
import java.util.ArrayList;
import java.util.List;

public class Person {

    private String name;
    private Account account;
    private List<BankCard> bankCards;

    public Person(String name, Account account) {
        this.name = name;
        this.account = account;
        this.bankCards = new ArrayList<>();
    }
}
