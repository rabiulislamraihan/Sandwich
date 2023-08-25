/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ContentManagerpkg;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import mainpkg.AppendableObjectOutputStream;

/**
 *
 * @author anika
 */
public class ContentManager implements Serializable{
    public static void CreateSchedule(String name, String details){
            
            
        File s = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

       
        
        try {
            s = new File("Schedule.bin");
            if(s.exists()){
                fos = new FileOutputStream(s,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(s);
                oos = new ObjectOutputStream(fos);               
            }
            
            
            Schedule newSchedule = new Schedule(name, details);    
//            listOfReport.add(newReport);
           oos.writeObject(newSchedule);
//           oos.close();
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Schedule has been Created");
            a.showAndWait();
           
            

        } catch (IOException ex) {
            Logger.getLogger(ContentManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(ContentManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
        }
    public static String SearchReport(String name) throws IOException{

        ObjectInputStream ois = null;

        try{
            Schedule s;
            ois = new ObjectInputStream(new FileInputStream("Schedule.bin"));
            
            while(true){
                s = (Schedule) ois.readObject();
                if(s.name.equals(name)){
                    return s.details;
                }
                
            }
        }
        catch(RuntimeException e){
            e.printStackTrace();
        }
        catch (Exception ex){
            try {
                if(ois!=null){
                    ois.close();
                }
            }
            catch (IOException ex1){ }
        }
        return null;
        
    
        }
    public static void CreatePlan(String name, String days){
            
            
        File s = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

       
        
        try {
            s = new File("Plan.bin");
            if(s.exists()){
                fos = new FileOutputStream(s,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(s);
                oos = new ObjectOutputStream(fos);               
            }
            
            Plan newPlan = new Plan(name, days);    
//            listOfReport.add(newReport);
           oos.writeObject(newPlan);
//           oos.close();
           Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Plan Has Been Added");
            a.showAndWait();
            

        } catch (IOException ex) {
            Logger.getLogger(ContentManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(ContentManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }                
        }

}
