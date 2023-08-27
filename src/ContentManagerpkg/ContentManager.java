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
    public static void CreateSchedule(String name, String details, String gen){   
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

            Schedule newSchedule = new Schedule(name, details, gen);    
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
    public static String SearchSchedule(String name) throws IOException{

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

    public static void feedback(String name, String feedback) {
        File s = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            s = new File("Feedback.bin");
            if(s.exists()){
                fos = new FileOutputStream(s,true);
                oos = new AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(s);
                oos = new ObjectOutputStream(fos);               
            }

            Feedback newFeedback = new Feedback(name, feedback);    
//            listOfReport.add(newReport);
           oos.writeObject(newFeedback);
//           oos.close();
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setTitle("Information Alert");
            a.setHeaderText("Alert");
            a.setContentText("Feedback Given");
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

    static String LoadFeedback(String findName) {
        ObjectInputStream ois = null;

        try{
            Feedback f;
            ois = new ObjectInputStream(new FileInputStream("Feedback.bin"));
            
            while(true){
                f = (Feedback) ois.readObject();
                if(f.name.equals(findName)){
                    return f.feedback;
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
    public static boolean isAlpha(String s)
    {
        if (s == null) {
            return false;
        }
 
        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (!(c >= 'A' && c <= 'Z') && !(c >= 'a' && c <= 'z')) {
                return false;
            }
        }
        return true;
    }
    }


