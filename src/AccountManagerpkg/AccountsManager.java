/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AccountManagerpkg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
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
}


