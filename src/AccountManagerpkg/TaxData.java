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
public class TaxData implements Serializable{
    private String month;
    private double income;  
    private double deductions;
    private double taxableIncome;
    private double taxPercentage;
    private double totalTax;

    public TaxData(String month, double income, double deductions, double taxableIncome, double taxPercentage, double totalTax) {
        this.month = month;
        this.income = income;
        this.deductions = deductions;
        this.taxableIncome = taxableIncome;
        this.taxPercentage = taxPercentage;
        this.totalTax = totalTax;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
    
    
    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getDeductions() {
        return deductions;
    }

    public void setDeductions(double deductions) {
        this.deductions = deductions;
    }

    public double getTaxableIncome() {
        return taxableIncome;
    }

    public void setTaxableIncome(double taxableIncome) {
        this.taxableIncome = taxableIncome;
    }

    public double getTaxPercentage() {
        return taxPercentage;
    }

    public void setTaxPercentage(double taxPercentage) {
        this.taxPercentage = taxPercentage;
    }

    public double getTotalTax() {
        return totalTax;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }
    
    public static double calculateTaxableIncome(double income, double deduction) {
    return income - deduction;
    }

    public static double calculateTax(double taxableIncome, double taxPercentage) {
        return taxableIncome * (taxPercentage / 100);
    }

    @Override
    public String toString() {
        return "\nMonth =" + month + ", \nIncome =" + income + ", \nDeductions =" + deductions + ", \nTaxable Income=" + taxableIncome + ", \nTax Percentage =" + taxPercentage + ", \nTotal Tax=" + totalTax + '}';
    }
    
    

}