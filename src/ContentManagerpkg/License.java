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
public class License implements Serializable{
    private String LicenseTitle;
    private String ContractorName;
    private String ActiveStatus;
    private String description;
    
    public License(String LicenseTitle, String ContractorName, String ActiveStatus, String description){
        this.LicenseTitle = LicenseTitle;
        this.ContractorName = ContractorName;
        this.ActiveStatus = ActiveStatus;
        this.description = description;
    }

    public String getLicenseTitle() {
        return LicenseTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLicenseTitle(String LicenseTitle) {
        this.LicenseTitle = LicenseTitle;
    }

    public String getContractorName() {
        return ContractorName;
    }

    public void setContractorName(String ContractorName) {
        this.ContractorName = ContractorName;
    }

    public String getActiveStatus() {
        return ActiveStatus;
    }

    public void setActiveStatus(String ActiveStatus) {
        this.ActiveStatus = ActiveStatus;
    }
    
}
