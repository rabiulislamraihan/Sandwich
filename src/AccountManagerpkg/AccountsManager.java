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
    public static void CreateFinancialData(String month, double expenses, double revenue, double profit, double loss, double customerAcquisition, double customerChurn){
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {
            f = new File("FinancialData.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
          
          FinancialData temp = new FinancialData(month, expenses, revenue, profit, loss, customerAcquisition, customerChurn);
          
          oos.writeObject(temp);

        } catch (IOException ex) {
//            Logger.getLogger(Scene1Controller.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
//                Logger.getLogger(Scene1Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                   
    }   
}
