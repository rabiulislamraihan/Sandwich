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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import mainpkg.AppendableObjectOutputStream;

/**
 *
 * @author anika
 */
class Schedule implements Serializable{
    String name;
    String details;
    
    public Schedule(String name, String details){
        this.name = name;
        this.details = details;
    }

    @Override
    public String toString() {
        return "Schedule{" + "name=" + name + ", details=" + details + '}';
    }
    
    
    static void deleteContent(String s) {
        ArrayList <Schedule> contentList = new ArrayList<>();
        ObjectInputStream ois = null;
        try {
             Schedule c;
             ois = new ObjectInputStream(new FileInputStream("Schedule.bin"));
             
            while(true){
                c = (Schedule) ois.readObject();
                if(!c.name.equals(s)) contentList.add(c);
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
        File file = new File("Schedule.bin");
        file.delete();
        
        for (int i = 0; i < contentList.size(); i ++) {
            File f = null;
            FileOutputStream fos = null;      
            ObjectOutputStream oos = null;

            try {
                f = new File("Schedule.bin");
                if(f.exists()){
                    fos = new FileOutputStream(f,true);
                    oos = new AppendableObjectOutputStream(fos);                
                }
                else{
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);               
                }
                oos.writeObject(contentList.get(i));

            } catch (IOException ex) {
                Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if(oos != null) oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(Schedule.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
