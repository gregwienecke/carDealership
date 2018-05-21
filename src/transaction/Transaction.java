package transaction;

import java.util.Date;

import car.Car;

public class Transaction {

	private String firstName;
	private String lastName;
	private Date saleDate;
	private Car carSold;
	
	public Transaction() {}
	public Transaction(String firstName, String lastName, Date saleDate, Car carSold) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.saleDate = saleDate;
		this.carSold = carSold;
	}
	
	public String toString() {
		return this.firstName + " " + this.lastName + ", " + this.carSold.getMake() + " " + this.carSold.getModel();
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public Car getCarSold() {
		return carSold;
	}
	public void setCarSold(Car carSold) {
		this.carSold = carSold;
	}
	
}
