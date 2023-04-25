package com.smart.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="recommendation")
public class Recommendation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="dose")
	private String dose;
	
	@Column(name="spare")
	private String spare;
	
	@Column(name="drip")
	private String drip;
	
	@Column(name="spare_water")
	private String spare_water;
	
	//Jpa mapping unidirectional for cropss
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="crops_id")
	private Crops crops;
	
	//Jpa mapping unidirectional for farmer
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="farmers_id")
	private Farmers farmers;
	
	
	public Recommendation() {}


	public Recommendation(String dose, String spare, String drip, String spare_water) {
		
		this.dose = dose;
		this.spare = spare;
		this.drip = drip;
		this.spare_water = spare_water;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDose() {
		return dose;
	}


	public void setDose(String dose) {
		this.dose = dose;
	}


	public String getSpare() {
		return spare;
	}


	public void setSpare(String spare) {
		this.spare = spare;
	}


	public String getDrip() {
		return drip;
	}


	public void setDrip(String drip) {
		this.drip = drip;
	}


	public String getSpare_water() {
		return spare_water;
	}


	public void setSpare_water(String spare_water) {
		this.spare_water = spare_water;
	}


	public Crops getCrops() {
		return crops;
	}


	public void setCrops(Crops crops) {
		this.crops = crops;
	}


	public Farmers getFarmers() {
		return farmers;
	}


	public void setFarmers(Farmers farmers) {
		this.farmers = farmers;
	}


	@Override
	public String toString() {
		return "Recommendation [id=" + id + ", dose=" + dose + ", spare=" + spare + ", drip=" + drip + ", spare_water="
				+ spare_water + ", crops=" + crops + ", farmers=" + farmers + "]";
	}
	
	
}
