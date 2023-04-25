package com.smart.Entity;


import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "crops")
public class Crops {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;
	
	//Jpa mapping Collection is compulsory
	@OneToMany(mappedBy = "crops")
	private List<Farmers> farmers;

	
	// Default constructor
	public Crops() {}

	// parameterized constructor
	public Crops(String name) {
		
		this.name = name;
	}

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

	public List<Farmers> getFarmers() {
		return farmers;
	}

	public void setFarmers(List<Farmers> farmers) {
		this.farmers = farmers;
	}

	@Override
	public String toString() {
		return "Crops [id=" + id + ", name=" + name + ", farmers=" + farmers + "]";
	}

	

}
