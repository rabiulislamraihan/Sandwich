/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ContentManagerpkg;

import java.io.Serializable;

/**
 *
 * @author anika
 */
public class Contract implements Serializable{
    public String title;
    public String contract;
    
    public void Contract(String title, String contract){
        this.title = title;
        this.contract = contract;
    }

    public Contract(String title, String contract) {
        this.title = title;
        this.contract = contract;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }
    
}
