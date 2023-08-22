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
public class FinancialData implements Serializable{
    private String month;
    private double expenses;
    private double revenue;
    private double profit;
    private double loss;
    private double customerAcquisition;
    private double customerChurn;

    public FinancialData(String month, double expenses, double revenue, double profit, double loss, double customerAcquisition, double customerChurn) {
        this.month = month;
        this.expenses = expenses;
        this.revenue = revenue;
        this.profit = profit;
        this.loss = loss;
        this.customerAcquisition = customerAcquisition;
        this.customerChurn = customerChurn;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getProfit() {
        return profit;
    }

    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getLoss() {
        return loss;
    }

    public void setLoss(double loss) {
        this.loss = loss;
    }

    public double getCustomerAcquisition() {
        return customerAcquisition;
    }

    public void setCustomerAcquisition(double customerAcquisition) {
        this.customerAcquisition = customerAcquisition;
    }

    public double getCustomerChurn() {
        return customerChurn;
    }

    public void setCustomerChurn(double customerChurn) {
        this.customerChurn = customerChurn;
    }
    
    
    public static double calculateProfit(double revenue, double expenses){
        double profit = revenue - expenses;
        if (profit < 0) {
            return 0; 
        }
        return profit;
    }
    
    public static double calculateLoss(double revenue, double expenses){
        double loss = expenses - revenue;
        if (loss < 0) {
            return 0;
        }
        return loss;
    }
    
}
