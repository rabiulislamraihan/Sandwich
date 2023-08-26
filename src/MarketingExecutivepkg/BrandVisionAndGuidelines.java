/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MarketingExecutivepkg;

import java.io.Serializable;

/**
 *
 * @author sumit
 */
public class BrandVisionAndGuidelines implements Serializable{
    private String vision;
    private String guidelines;

    public BrandVisionAndGuidelines(String vision, String guidelines) {
        this.vision = vision;
        this.guidelines = guidelines;
    }

    public String getVision() {
        return vision;
    }

    public void setVision(String vision) {
        this.vision = vision;
    }

    public String getGuidelines() {
        return guidelines;
    }

    public void setGuidelines(String guidelines) {
        this.guidelines = guidelines;
    }

    @Override
    public String toString() {
        return "BrandVisionAndGuidelines{" + "vision=" + vision + ", guidelines=" + guidelines + '}';
    }
            
    
    
    
}
