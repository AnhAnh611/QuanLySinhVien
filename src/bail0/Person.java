package bail0;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Person {
	private int id=0;
	private String name;
	private LocalDate dob;
	private String address;
	private double height;
	private double weight;
	
	
	
	public Person(int id, String name, LocalDate dob, String address, double height, double weight) {
		super();
		this.name = name;
		this.dob = dob;
		this.address = address;
		this.height = height;
		this.weight = weight;
	}
	
	public Person() {
		this.id = id;
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


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public double getHeight() {
		return height;
	}


	public void setHeight(double height) {
		this.height = height;
	}


	public double getWeight() {
		return weight;
	}


	public void setWeight(double weight) {
		this.weight = weight;
	}


	@Override
	public String toString() {
		return "Person [name=" + name + ", dob=" + DateTimeFormatter.ofPattern("dd-MM-yyyy").format(dob) + ", address=" + address + ", height=" + height + ", weight="
				+ weight + "]";
	}
	
}
