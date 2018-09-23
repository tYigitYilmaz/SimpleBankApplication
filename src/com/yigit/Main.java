package com.yigit;

public class Main {

    public static void main(String[] args) {


    Bank bank = new Bank("Siberian Bank");

    bank.addBranch("Moscow");

    bank.addCustomer("Moscow","Tatyana",500000.75);
    bank.addCustomer("Moscow","Aleksey",630000.23);
    bank.addCustomer("Moscow","Yigit",340000.66);

    bank.addBranch("Tyumen");

    bank.addCustomer("Tyumen","Ted",260000.57);

    bank.addCustomerTransaction("Moscow","Yigit",15000);

    bank.transferBetweenCustomers("Moscow","Tatyana","Yigit",35000);


    bank.listCustomers("Moscow",true);
    }
}
