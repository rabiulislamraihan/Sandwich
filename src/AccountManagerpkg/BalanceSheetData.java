/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccountManagerpkg;

import java.io.Serializable;

/**
 *
 * @author sumit
 */
public class BalanceSheetData implements Serializable {
    private String month;
    private double cash;
    private double accountsreceivable;
    private double investments;
    private double totalassets;
    private double accountspayable;
    private double loan;
    private double totalliabilities;
    private double ownersequity;

    public BalanceSheetData(String month, double cash, double accountsreceivable, double investments, double totalassets, double accountspayable, double loan, double totalliabilities, double ownersequity) {
        this.month = month;
        this.cash = cash;
        this.accountsreceivable = accountsreceivable;
        this.investments = investments;
        this.accountspayable = accountspayable;
        this.loan = loan;
        this.totalassets = totalassets ;
        this.totalliabilities = totalliabilities;
        this.ownersequity = ownersequity;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double getAccountsreceivable() {
        return accountsreceivable;
    }

    public void setAccountsreceivable(double accountsreceivable) {
        this.accountsreceivable = accountsreceivable;
    }

    public double getInvestments() {
        return investments;
    }

    public void setInvestments(double investments) {
        this.investments = investments;
    }

    public double getTotalassets() {
        return totalassets;
    }

    public void setTotalassets(double totalassets) {
        this.totalassets = totalassets;
    }

    public double getAccountspayable() {
        return accountspayable;
    }

    public void setAccountspayable(double accountspayable) {
        this.accountspayable = accountspayable;
    }

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public double getTotalliabilities() {
        return totalliabilities;
    }

    public void setTotalliabilities(double totalliabilities) {
        this.totalliabilities = totalliabilities;
    }

    public double getOwnersequity() {
        return ownersequity;
    }

    public void setOwnersequity(double ownersequity) {
        this.ownersequity = ownersequity;
    }
    
    
    public static double calculateTotalAssets(double cash, double accountsreceivable, double investments) {
        if (cash < 0 || accountsreceivable < 0 || investments < 0) {
            throw new IllegalArgumentException("Input values must be non-negative");
        }
        return (cash + accountsreceivable + investments);
    }

    public static double calculateTotalLiabilities(double accountspayable, double loan) {
        if (accountspayable < 0 || loan < 0) {
            throw new IllegalArgumentException("Input values must be non-negative");
        }
        return accountspayable + loan;
    }

    public static double calculateOwnersEquity(double totalassets, double totalliabilities) {
        if (totalassets < totalliabilities) {
            throw new IllegalArgumentException("Total assets must be greater than total liabilities");
        }
        return totalassets - totalliabilities;
    }
    
}
        
    
