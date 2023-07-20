package com.railway.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CrossingStation")
public class CrossingStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "crossing_status")
    private Boolean crossingStatus;

    @Column(name = "person_in_charge")
    private String personInCharge;

    @Column(name = "train_schedule")
    private String trainSchedule;

    @Column(name = "landmark")
    private String landmark;

    @Column(name = "address")
    private String address;

    public CrossingStation() {}

    public CrossingStation(String name, Boolean crossingStatus, String personInCharge, String trainSchedule, String landmark, String address) {
        this.name = name;
        this.crossingStatus =crossingStatus ;
        this.personInCharge = personInCharge;
        this.trainSchedule = trainSchedule;
        this.landmark = landmark;
        this.address = address;
    }

    // Getters and setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCrossingStatus() {
    	if(crossingStatus)
        return "open";
    	return "Close";
    }

    public void setCrossingStatus(Boolean crossingStatus) {
        this.crossingStatus = crossingStatus;
    }

    public String getPersonInCharge() {
        return personInCharge;
    }

    public void setPersonInCharge(String personInCharge) {
        this.personInCharge = personInCharge;
    }

    public String getTrainSchedule() {
        return trainSchedule;
    }

    public void setTrainSchedule(String trainSchedule) {
        this.trainSchedule = trainSchedule;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
