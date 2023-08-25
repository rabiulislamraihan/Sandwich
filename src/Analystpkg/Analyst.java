
package Analystpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface Analyst {
    
    public static ArrayList <Survey> GetSurveyList() {
        ArrayList <Survey> surveyList = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
            Survey c;
            ois = new ObjectInputStream(new FileInputStream("Survey.bin"));
            while(true){
                c = (Survey) ois.readObject();
                surveyList.add(c);
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
        return surveyList;
    } 
    
    
    public static void AddSurvey(SuveyStore c) {
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f = new File("SuveyStore.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new mainpkg.AppendableObjectOutputStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            oos.writeObject(c);

        } catch (IOException ex) {
            Logger.getLogger(SuveyStore.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(SuveyStore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
