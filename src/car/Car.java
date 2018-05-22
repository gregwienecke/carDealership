package car;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class Car {
	
	// Properties
	private String year;
	private String make;
	private String model;
	private double price;
	private String photo;
	private boolean isNew;
	private int carId;
	private long mileage;
	private int mpg;
	private String engine;
	private String transmission;
//	private String dealerPurchaseDateStringTest;
//	private String dealerPurchaseDateString;
	private Date dealerPurchaseDate;
	
	// Constructors
	public Car() {}
	public Car(String year, String make, String model, double price, long mileage, int mpg, String engine, String transmission, boolean isNew) {
		this.year = year;
		this.make = make;
		this.model = model;
		this.price = price;
		this.mileage = mileage;
		this.mpg = mpg;
		this.engine = engine;
		this.transmission = transmission;
		this.isNew = isNew;
	}
	
	// Methods
	public String toString() {
		return this.year + " " + this.make + " " + this.model + " " + this.photo;
	}
	
	public boolean isOlderThan120() {
		// Get the date from four months ago
		LocalDateTime fourMonthsAgo = LocalDateTime.now().minusDays(120);
		
		// Convert the car purchase date to a localDateTime so both data type are the same
		LocalDateTime PurchaseDateToLDT = LocalDateTime.ofInstant(dealerPurchaseDate.toInstant(), ZoneId.systemDefault());

		// Check if car is has been on the lot longer than four months
		// Returns true if older, false if newer
		return PurchaseDateToLDT.isBefore(fourMonthsAgo);
	}
	
	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public boolean getIsNew() {
		return isNew;
	}
	public void setIsNew(boolean isNew) {
		this.isNew = isNew;
	}
	public int getCarId() {
		return carId;
	}
	public void setCarId(int carId) {
		this.carId = carId;
	}
	public long getMileage() {
		return mileage;
	}
	public void setMileage(long mileage) {
		this.mileage = mileage;
	}
	public int getMpg() {
		return mpg;
	}
	public void setMpg(int mpg) {
		this.mpg = mpg;
	}
	public String getEngine() {
		return engine;
	}
	public void setEngine(String engine) {
		this.engine = engine;
	}
	public String getTransmission() {
		return transmission;
	}
	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
//	public String getDealerPurchaseDateStringTest() {
//		return dealerPurchaseDateStringTest;
//	}
//	public void setDealerPurchaseDateStringTest(String dealerPurchaseDateStringTest) {
//		this.dealerPurchaseDateStringTest = dealerPurchaseDateStringTest;
//	}
//	public String getDealerPurchaseDateString() {
//		return dealerPurchaseDateString;
//	}
//	public void setDealerPurchaseDateString(String dealerPurchaseDateString) {
//		this.dealerPurchaseDateString = dealerPurchaseDateString;
//	}
	public Date getDealerPurchaseDate() {
		return dealerPurchaseDate;
	}
	public void setDealerPurchaseDate(Date dealerPurchaseDate) {
		this.dealerPurchaseDate = dealerPurchaseDate;
	}

}
