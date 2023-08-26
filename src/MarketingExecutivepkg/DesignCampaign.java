/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MarketingExecutivepkg;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author sumit
 */
public class DesignCampaign implements Serializable{
    private String campaignName;
    private LocalDate startDate;
    private LocalDate endDate;
    private String content;
    private String targetAudience;
    private String marketingMedia;
    private long duration;

    public DesignCampaign(String campaignName, LocalDate startDate, LocalDate endDate, String content, String targetAudience, String marketingMedia) {
        this.campaignName = campaignName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.content = content;
        this.targetAudience = targetAudience;
        this.marketingMedia = marketingMedia;
        this.duration = ChronoUnit.DAYS.between(startDate, endDate);
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }
    
    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getMarketingMedia() {
        return marketingMedia;
    }

    public void setMarketingMedia(String marketingMedia) {
        this.marketingMedia = marketingMedia;
    }

    @Override
    public String toString() {
        return "DesignCampaign{" + "campaignName=" + campaignName + ", startDate=" + startDate + ", endDate=" + endDate + ", content=" + content + ", targetAudience=" + targetAudience + ", marketingMedia=" + marketingMedia + '}';
    }
    
    

    
}
