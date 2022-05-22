package model;

public class Gasoline extends Car implements Consumable {
	
	private double tankCapacity;
	private double consumptionPerKm;
	private GasolineType gasolineType;
	
	public Gasoline(double basePrice, String brand, String model, int carType, int cylinderCapacity, double mileage,
			String idPlate, int doorsAmount, char areWindowsTinted, int type, int gasolineType, double tankCapacity, double discount) {
		
		super(basePrice, brand, model, carType, cylinderCapacity, mileage, idPlate, doorsAmount, areWindowsTinted, type, discount);
		
		switch(gasolineType) {
		
		case 1:
			this.gasolineType = GasolineType.REGULAR;
			break;
			
		case 2:
			this.gasolineType = GasolineType.EXTRA;
			break;
			
		case 3:
			this.gasolineType = GasolineType.DIESEL;
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

	public GasolineType getGasolineType() {
		return gasolineType;
	}

	public void setGasolineType(GasolineType gasolineType) {
		this.gasolineType = gasolineType;
	}
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method calculates the total price of a car
     * 
	 * <strong> Pre </strong> Select create an gasoline car
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
			sellPrice += getBasePrice();
		} else {
			sellPrice -= sellPrice * usedCarDiscount;
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
	 * <strong> Method Description. </strong> This method calculates the gasoline consume of a car
     * 
	 * <strong> Pre </strong> Select create an hybrid or gasoline car
	 * <strong> Pos </strong> The consume of the gasoline calculated
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Returns a double
	 * </pre>
	 */
	@Override
	public double calculateGasolineConsume() {
		return tankCapacity * (getCylinderCapacity()/gasolineCarValue);
	} // calculate gasoline consume

	@Override
	public String toString() {
		return "\n| GASOLINE CAR | \nTank Capacity: " + tankCapacity + "\nConsumption Per Km: " + consumptionPerKm + "\nGasoline Type: "
				+ gasolineType + "\n Sell Price: "+calculateTotalPrice();
	}
	
} // Gasoline
