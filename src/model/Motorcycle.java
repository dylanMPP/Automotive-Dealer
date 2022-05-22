package model;

public class Motorcycle extends Vehicle implements Consumable{
	
	private double tankCapacity;
	private double consumptionPerKm;
	private MotorcycleType motorcycleType;
	
	public Motorcycle(double basePrice, String brand, String model, int type, int cylinderCapacity, double mileage, String idPlate, int motorcycleType, double tankCapacity, double discount) {
		
		super(basePrice, brand, model, cylinderCapacity, type, mileage, idPlate, discount);
		
		switch(motorcycleType) {
		
		case 1:
			this.motorcycleType = MotorcycleType.STANDARD;
			break;
			
		case 2:
			this.motorcycleType = MotorcycleType.SPORTY;
			break;
			
		case 3:
			this.motorcycleType = MotorcycleType.SCOOTER;
			break;
			
		case 4:
			this.motorcycleType = MotorcycleType.CROSS;
			break;
		} // gasoline switch
		
		this.tankCapacity = tankCapacity;
		this.consumptionPerKm = calculateGasolineConsume();
	} // constructor gasoline

	public double getTankCapacity() {
		return tankCapacity;
	}

	public void setTankCapacity(double tankCapacity) {
		this.tankCapacity = tankCapacity;
	}

	public double getConsumptionPerKm() {
		return consumptionPerKm;
	}

	public void setConsumptionPerKm(double consumptionPerKm) {
		this.consumptionPerKm = consumptionPerKm;
	}
	
	public MotorcycleType getMotorcycleType() {
		return motorcycleType;
	}

	public void setMotorcycleType(MotorcycleType motorcycleType) {
		this.motorcycleType = motorcycleType;
	}
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method calculates the total price of a motorcycle
     * 
	 * <strong> Pre </strong> Select create a motorcycle
	 * <strong> Pos </strong> The sell price calculated
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Returns a double (SellPrice)
	 * </pre>
	 */
	@Override
	public double calculateTotalPrice() {
		double sellPrice = getBasePrice();
		boolean runFlag = true;
		
		if (getType()==VehicleType.NEW) {
			sellPrice += (getBasePrice()*motorcycleAddition);
		} else {
			sellPrice += (getBasePrice()*motorcycleAddition);
			sellPrice -= sellPrice * usedMotorcycleDiscount;
		} //
		
		if (getDocuments().isEmpty()) {
			sellPrice += 500000;
		} else {
			
			for (int i = 0; i < getDocuments().size() && !runFlag; i++) {
				if (getDocuments().get(i).getYear() < 2022) {
					sellPrice += 500000;
					runFlag = false;
				} // if
			} // for
		} // if
		
		sellPrice -= sellPrice*getDiscount();
		
		return sellPrice;
	} // calculate total price
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method calculates the gasoline consume of a motorcycle
     * 
	 * <strong> Pre </strong> Select create a motorcycle
	 * <strong> Pos </strong> The consume of the gasoline calculated
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Returns a double
	 * </pre>
	 */
	@Override
	public double calculateGasolineConsume() {
		return tankCapacity * (getCylinderCapacity()/motorcycleValue);
	} // calculate gasoline consume
	
	
	
	@Override
	public String toString() {
		return "| MOTORCYCLE |\nTank Capacity: " + tankCapacity + "\nConsumption Per Km: " + consumptionPerKm
				+ "\nMotorcycle Type: " + motorcycleType + "\nSell Price: "+calculateTotalPrice();
	}
} // motorcycle
