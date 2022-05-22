package model;

public abstract class Car extends Vehicle {

	private int doorsAmount;
	private char areWindowsTinted;
	private CarType carType;
	
	public Car(double basePrice, String brand, String model, int carType, int cylinderCapacity, double mileage, String idPlate, int doorsAmount, char areWindowsTinted, int type, double discount) {
		
		super(basePrice, brand, model, type, cylinderCapacity, mileage, idPlate, discount);
		this.doorsAmount = doorsAmount;
		this.areWindowsTinted = areWindowsTinted;
		
		switch(carType) {
		
		case 1:
			this.carType = CarType.SEDAN;
			break;
		case 2:
			this.carType = CarType.PICK_UP_TRUCK;
			break;
		} // switch type
		
	} // car constructor

	public CarType getCarType() {
		return carType;
	}

	public void setCarType(CarType carType) {
		this.carType = carType;
	}

	public int getDoorsAmount() {
		return doorsAmount;
	}

	public void setDoorsAmount(int doorsAmount) {
		this.doorsAmount = doorsAmount;
	}

	public char getAreWindowsTinted() {
		return areWindowsTinted;
	}

	public void setAreWindowsTinted(char areWindowsTinted) {
		this.areWindowsTinted = areWindowsTinted;
	}
	
} // car class
