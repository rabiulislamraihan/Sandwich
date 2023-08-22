/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SalesRepresentativepkg;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.io.Serializable;
import java.time.LocalDate;

public class TableData implements Serializable {
    private  String leaderName;
    private  String projectName;
    private LocalDate startDate;
    private String duration;


    public TableData(String leaderName, String projectName, LocalDate startDate, String duration) {
        this.leaderName = leaderName;
        this.projectName = projectName;
        this.startDate = startDate;
        this.duration = duration;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public String getProjectName() {
        return projectName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public String getDuration() {
        return duration;
    }

}
