/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalesRepresentativepkg;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author anika
 */
class Lead implements Serializable{
    private String leadName;
    private String projectName;
    private LocalDate startDate;
    private String duration;
    
    public Lead( String leadName, String projectName, LocalDate startDate, String duration){
      this.leadName = leadName;
      this.projectName = projectName;
      this.startDate = startDate;
      this.duration = duration;
    } 
    
}
