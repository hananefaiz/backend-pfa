package com.arrgano.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class GroupRequest {
    @NotBlank(message = "Le nom du groupe est obligatoire")
    private String groupName;

    @NotBlank(message = "Le nom de la cheffe est obligatoire")
    private String leaderName;

    @NotNull(message = "La liste des membres est obligatoire")
    private List<String> members;

    @NotBlank(message = "La localisation est obligatoire")
    private String location;

    private double initialFruitQuantity;
    private double initialAlmondQuantity;

    // Getters et Setters
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
}
