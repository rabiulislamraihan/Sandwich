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
public class FinancialMatrices implements Serializable{
    private String month;
    private double budget;
    private double expenses;
    private double investments;
    private double projectedRevenue;
    private double actualRevenue;
    private double debt;
    private double savings;

    public FinancialMatrices(String month, double budget, double expenses, double investments, double projectedRevenue, double actualRevenue, double debt, double savings) {
        this.month = month;
        this.budget = budget;
        this.expenses = expenses;
        this.investments = investments;
        this.projectedRevenue = projectedRevenue;
        this.actualRevenue = actualRevenue;
        this.debt = debt;
        this.savings = savings;
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

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getInvestments() {
        return investments;
    }

    public void setInvestments(double investments) {
        this.investments = investments;
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

    public double getDebt() {
        return debt;
    }

    public void setDebt(double debt) {
        this.debt = debt;
    }

    public double getSavings() {
        return savings;
    }

    public void setSavings(double savings) {
        this.savings = savings;
    }
    
    
}
