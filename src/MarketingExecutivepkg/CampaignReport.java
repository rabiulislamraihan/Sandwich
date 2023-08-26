/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MarketingExecutivepkg;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author sumit
 */
public class CampaignReport implements Serializable{
    private DesignCampaign campaign;
    private int totalImpressions;
    private int totalEngagements;
    private int totalClicks;
    private int totalActions;
    private double engagementRate;
    private double clickThroughRate;
    private double conversionRate;

    public CampaignReport(DesignCampaign campaign, int totalImpressions, int totalEngagements, int totalClicks, int totalActions, double engagementRate, double clickThroughRate, double conversionRate) {
        this.campaign = campaign;
        this.totalImpressions = totalImpressions;
        this.totalEngagements = totalEngagements;
        this.totalClicks = totalClicks;
        this.totalActions = totalActions;
        this.engagementRate = engagementRate;
        this.clickThroughRate = clickThroughRate;
        this.conversionRate = conversionRate;
    }

    public DesignCampaign getCampaign() {
        return campaign;
    }

    public void setCampaign(DesignCampaign campaign) {
        this.campaign = campaign;
    }

    public int getTotalImpressions() {
        return totalImpressions;
    }

    public void setTotalImpressions(int totalImpressions) {
        this.totalImpressions = totalImpressions;
    }

    public int getTotalEngagements() {
        return totalEngagements;
    }

    public void setTotalEngagements(int totalEngagements) {
        this.totalEngagements = totalEngagements;
    }

    public int getTotalClicks() {
        return totalClicks;
    }

    public void setTotalClicks(int totalClicks) {
        this.totalClicks = totalClicks;
    }

    public int getTotalActions() {
        return totalActions;
    }

    public void setTotalActions(int totalActions) {
        this.totalActions = totalActions;
    }

    public double getEngagementRate() {
        return engagementRate;
    }

    public void setEngagementRate(double engagementRate) {
        this.engagementRate = engagementRate;
    }

    public double getClickThroughRate() {
        return clickThroughRate;
    }

    public void setClickThroughRate(double clickThroughRate) {
        this.clickThroughRate = clickThroughRate;
    }

    public double getConversionRate() {
        return conversionRate;
    }

    public void setConversionRate(double conversionRate) {
        this.conversionRate = conversionRate;
    }
    
    
    
}