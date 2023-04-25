package com.smart.Entity;




import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="farmers")
public class Farmers {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name")
	private String name;
	
	@Column(name="mobileno")
	private String mobileno;
	
	@Column(name="village")
	private String village;
	
	//JPa mapping for many farmers and one crop
	
	 @ManyToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name="crop_id")
	 private Crops crops;
	
	//Default constructor
	public Farmers() {}


	//parameterized constructor
	public Farmers(String name, String mobileno, String village) {
		
		this.name = name;
		this.mobileno = mobileno;
		this.village = village;
	}


	//Getters and setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getMobileno() {
		return mobileno;
	}


	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}


	public String getVillage() {
		return village;
	}


	public void setVillage(String village) {
		this.village = village;
	}


	public Crops getCrops() {
		return crops;
	}


	public void setCrops(Crops crops) {
		this.crops = crops;
	}


	@Override
	public String toString() {
		return "Farmers [id=" + id + ", name=" + name + ", mobileno=" + mobileno + ", village=" + village + ", crops="
				+ crops + "]";
	}

	
}