/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccountManagerpkg;

import java.io.Serializable;


public class BudgetAndPerformance implements Serializable {
    private String month;
    private double budget;
    private double projectedRevenue;
    private double actualRevenue;
    private double projectedExpenses;
    private double actualExpenses;
    private double revenueVariance;
    private double expensesVariance;

    public BudgetAndPerformance(String month, double budget, double projectedRevenue, double projectedExpenses) {
        this.month = month;
        this.budget = budget;
        this.projectedRevenue = projectedRevenue;
        this.actualRevenue = 0;
        this.projectedExpenses = projectedExpenses;
        this.actualExpenses = 0;
        this.revenueVariance = 0;
        this.expensesVariance = 0;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public double getProjectedRevenue() {
        return projectedRevenue;
    }

    public void setProjectedRevenue(double projectedRevenue) {
        this.projectedRevenue = projectedRevenue;
    }

    public double getActualRevenue() {
        return actualRevenue;
    }

    public void setActualRevenue(double actualRevenue) {
        this.actualRevenue = actualRevenue;
    }

    public double getProjectedExpenses() {
        return projectedExpenses;
    }

    public void setProjectedExpenses(double projectedExpenses) {
        this.projectedExpenses = projectedExpenses;
    }

    public double getActualExpenses() {
        return actualExpenses;
    }

    public void setActualExpenses(double actualExpenses) {
        this.actualExpenses = actualExpenses;
    }

    public double getRevenueVariance() {
        return revenueVariance;
    }

    public void setRevenueVariance(double revenueVariance) {
        this.revenueVariance = revenueVariance;
    }

    public double getExpensesVariance() {
        return expensesVariance;
    }

    public void setExpensesVariance(double expensesVariance) {
        this.expensesVariance = expensesVariance;
    }
    
    public static double calculateRevenueVariance(double projectedRevenue, double actualRevenue) {
        double variance = actualRevenue - projectedRevenue;
        if (variance < 0) {
            return -variance;
        } else {
            return variance;
        }
    }

    public static double calculateExpensesVariance(double projectedExpenses, double actualExpenses) {
        double variance = actualExpenses - projectedExpenses;
        if (variance < 0) {
            return -variance;
        } else {
            return variance;
        }
    }

}