package com.arrgano.model;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;

@Document(collection = "women_groups")
public class WomenGroup {
    @Id
    private String id;
    private String groupName;
    private String leaderName;
    private List<String> members;
    private String location;
    private Date creationDate;
    private double initialFruitQuantity;
    private double initialAlmondQuantity;
    private String productionLotId;

    // Constructeurs
    public WomenGroup() {}

    public WomenGroup(String groupName, String leaderName, List<String> members,
                      String location, double initialFruitQuantity,
                      double initialAlmondQuantity) {
        this.groupName = groupName;
        this.leaderName = leaderName;
        this.members = members;
        this.location = location;
        this.creationDate = new Date();
        this.initialFruitQuantity = initialFruitQuantity;
        this.initialAlmondQuantity = initialAlmondQuantity;
    }

    // Getters et Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public double getInitialFruitQuantity() {
        return initialFruitQuantity;
    }

    public void setInitialFruitQuantity(double initialFruitQuantity) {
        this.initialFruitQuantity = initialFruitQuantity;
    }

    public double getInitialAlmondQuantity() {
        return initialAlmondQuantity;
    }

    public void setInitialAlmondQuantity(double initialAlmondQuantity) {
        this.initialAlmondQuantity = initialAlmondQuantity;
    }

    public String getProductionLotId() {
        return productionLotId;
    }

    public void setProductionLotId(String productionLotId) {
        this.productionLotId = productionLotId;
    }
}
