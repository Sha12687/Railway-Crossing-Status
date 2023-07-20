package com.railway.entity;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "favorite_stations")
public class FavoriteStation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String crossingStatus;
    private String personInCharge;
    private String trainSchedule;
    private String landmark;
    private String address;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	// Constructors, getters, and setters
    public FavoriteStation() {
    }

    public FavoriteStation(String name, String crossingStatus, String personInCharge, String trainSchedule, String landmark, String address) {
        this.name = name;
        this.crossingStatus = crossingStatus;
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
        return crossingStatus;
    }
    public void setCrossingStatus(String crossingStatus) {
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

	@Override
	public String toString() {
		return "FavoriteStation [id=" + id + ", name=" + name + ", crossingStatus=" + crossingStatus
				+ ", personInCharge=" + personInCharge + ", trainSchedule=" + trainSchedule + ", landmark=" + landmark
				+ ", address=" + address + ", user=" + user + "]";
	}
}
