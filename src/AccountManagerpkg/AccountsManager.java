/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccountManagerpkg;

import customerpkg.Customer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import mainpkg.AppendableObjectOutputStream;

public class AccountsManager implements Serializable {
    public static void addIncomeData(String month, double salaryAndWages, double rentAndUtilities, double expenses, double revenue, double contentAcquisition, double marketingCost, double netProfit, double netLoss) {
    File f = null;
    FileOutputStream fos = null;
    ObjectOutputStream oos = null;
    
    try {
        f = new File("IncomeData.bin"); // Adjust the file name as needed
        if (f.exists()) {
            fos = new FileOutputStream(f, true);
            oos = new AppendableObjectOutputStream(fos);
        } else {
            fos = new FileOutputStream(f);
            oos = new ObjectOutputStream(fos);
        }
      
        IncomeStatement temp = new IncomeStatement(month, salaryAndWages, rentAndUtilities, expenses, revenue, contentAcquisition, marketingCost, netProfit, netLoss);
        
        oos.writeObject(temp);

    } catch (IOException ex) {
        // Handle exceptions
    } finally {
        try {
            if (oos != null) oos.close();
        } catch (IOException ex) {
            // Handle exceptions
        }
    }
    } 
    

    public static void CreateBalanceSheetData(String month, double cash, double accountsReceivable, double investments, double totalAssets, double accountsPayable, double loan, double totalLiabilities, double ownersEquity) {
        File f = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            f = new File("BalanceSheetData.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }

            BalanceSheetData temp = new BalanceSheetData(month, cash, accountsReceivable, investments, totalAssets, accountsPayable, loan, totalLiabilities, ownersEquity);

            oos.writeObject(temp);

        } catch (IOException ex) {
            // Handle the exception
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException ex) {
                // Handle the exception
            }
        }
    }
    
    public static void addProjectedData(String month, double budget, double projectedRevenue, double projectedExpenses) {
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("ProjectedData.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                oos = new AppendableObjectOutputStream(fos);
            } else {
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            BudgetAndPerformance temp = new BudgetAndPerformance( month, budget, projectedRevenue,  projectedExpenses);
            oos.writeObject(temp);
        } catch (IOException ex) {
            // Handle exceptions
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException ex) {
                // Handle exceptions
            }
        }
        } 
    
    public static ArrayList<BudgetAndPerformance> getEnteredMonths(){
        ArrayList<BudgetAndPerformance> list = new ArrayList<>();
        ObjectInputStream ois = null;
        boolean result = false;
        try {
             BudgetAndPerformance c;
             ois = new ObjectInputStream(new FileInputStream("ProjectedData.bin"));
            while(true){
                c = (BudgetAndPerformance) ois.readObject();
                    list.add(c);
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        return list;
    }
    
    public static void update(String month, Double actualRevenue, Double actualExpenses, Double revenueVariance, Double expensesVariance){
        ArrayList <BudgetAndPerformance> list = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
             BudgetAndPerformance c;
             ois = new ObjectInputStream(new FileInputStream("ProjectedData.bin"));
            while(true){
                c = (BudgetAndPerformance) ois.readObject();
                if(c.getMonth().equals(month)) {
                    c.setActualRevenue(actualRevenue);
                    c.setActualExpenses(actualExpenses);
                    c.setRevenueVariance(revenueVariance);
                    c.setExpensesVariance(expensesVariance);
                }
                list.add(c);
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex) {
            try {
                if(ois!=null)
                    ois.close();
            } catch (IOException ex1) {  }           
        }
        
        File file = new File("ProjectedData.bin");
        file.delete();
        
        for (int i = 0; i <list.size(); i ++) {
            File f = null;
            FileOutputStream fos = null;      
            ObjectOutputStream oos = null;

            try {
                f = new File("ProjectedData.bin");
                if (f.exists()) {
                    fos = new FileOutputStream(f, true);
                    oos = new AppendableObjectOutputStream(fos);
                } else {
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);
                }
                oos.writeObject(list.get(i));
            } catch (IOException ex) {
                // Handle exceptions
            } finally {
                try {
                    if (oos != null) oos.close();
                } catch (IOException ex) {
                    // Handle exceptions
                }
            }
        }
    }
//    public static void addPerformanceData(month)
//    AccountsManager.addPerformanceData(month,revenueVarianceLabel ,expensesVarianceLabel);
}


