package com.yigit;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name){
        this.name = name;
        this.branches=new ArrayList<Branch>();
    }
    public boolean addBranch(String branchName){
        if (findBranch(branchName) ==null){
            this.branches.add(new Branch(branchName));
            return true;
        }
        return false;
    }
    public boolean addCustomer(String branchName, String customerName, double initialAmount){
        Branch branch = findBranch(branchName);
        if (branch != null){
            return branch.newCustomer(customerName, initialAmount);
        }
        return false;
    }

    public boolean addCustomerTransaction(String branchName, String customerName, double amount){
        Branch branch = findBranch(branchName);
        if (branch != null){
            return branch.addCustomerTransaction(customerName,amount);
        }
        return false;
    }
    public boolean transferBetweenCustomers(String branchName, String customerName1,String customerName2, double amount){
        Branch branch = findBranch(branchName);
        if (branch != null){
            return branch.transferBetweenCustomers(customerName1,customerName2,amount);
        }
        return false;
    }

    private Branch findBranch(String branchName){
        for (int i=0; i<this.branches.size();i++){
            Branch checkedBranch = this.branches.get(i);
            if (checkedBranch.getName().equals(branchName)){
                return checkedBranch;
            }
        }
        return null;
    }

    public boolean listCustomers(String branchName, boolean showTransactions){
        Branch branch = findBranch(branchName);
        if (branch != null){
            System.out.println("Customer details for branch " + branch.getName());

            ArrayList<Customer> branchCustomers = branch.getCustomers();
            for (int i=0; i<branchCustomers.size();i++){
                Customer branchCustomer = branchCustomers.get(i);
                System.out.println("Customer: " + branchCustomer.getName() + "[" + (i+1) + "]");
                if (showTransactions){
                    System.out.println("Transactions");
                    ArrayList<Double> transaction = branchCustomer.getTransaction();
                    double sum = 0;
                    for (int j=0;j<transaction.size();j++){
                        sum += transaction.get(j);
                        System.out.println("["+(j+1)+"] Amount " + transaction.get(j) + "\n Total Balance: " + sum);
                    }
                }
            }
            return true;
        }else {
            return false;
        }
    }







}