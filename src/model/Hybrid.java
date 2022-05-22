package model;

public class Hybrid extends Car implements Consumable, Dischargeable{
	
	private double batteryDurationInKm;
	private double batteryConsumptionPerKm;
	private double tankCapacity;
	private double consumptionPerKm;
	private GasolineType gasolineType;
	private ChargerType chargerType;
	
	public Hybrid(double basePrice, String brand, String model, int carType, int cylinderCapacity, double mileage,
			String idPlate, int doorsAmount, char areWindowsTinted, int type, int gasolineType, double tankCapacity, int chargerType, double batteryDurationInKm, double discount) {
		
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
		
		switch(chargerType) {
		
		case 1:
			this.chargerType = ChargerType.NORMAL;
			break;
			
		case 2:
			this.chargerType = ChargerType.FAST;
			break;
		} // chargertypeswitch
		
		this.tankCapacity = tankCapacity;
		this.batteryDurationInKm = batteryDurationInKm;
		this.batteryConsumptionPerKm = discharge();
		this.consumptionPerKm = calculateGasolineConsume();
	} // constructor electric
	
	
	
	public double getBatteryDurationInKm() {
		return batteryDurationInKm;
	}



	public void setBatteryDurationInKm(double batteryDurationInKm) {
		this.batteryDurationInKm = batteryDurationInKm;
	}



	public double getBatteryConsumptionPerKm() {
		return batteryConsumptionPerKm;
	}



	public void setBatteryConsumptionPerKm(double batteryConsumptionPerKm) {
		this.batteryConsumptionPerKm = batteryConsumptionPerKm;
	}



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



	public ChargerType getChargerType() {
		return chargerType;
	}



	public void setChargerType(ChargerType chargerType) {
		this.chargerType = chargerType;
	}
	
	

	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method calculates the total price of a car
     * 
	 * <strong> Pre </strong> Select create an hybrid car
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
			sellPrice += (getBasePrice()*hybridCarAddition);
		} else {
			sellPrice += (getBasePrice()*hybridCarAddition);
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
		return tankCapacity * (getCylinderCapacity()/hybridCarValue);
	} // calculate gasoline consume
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method calculates the battery consumption per km of a car
     * 
	 * <strong> Pre </strong> Select create an hybrid or electric car
	 * <strong> Pos </strong> The consumption of te battery calculated
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Returns a double (batteryConsumptionPerKm)
	 * </pre>
	 */
	@Override
	public double discharge() {
		
		double batteryConsumptionPerKm;
		
		if (chargerType==ChargerType.NORMAL) {
			batteryConsumptionPerKm = (batteryDurationInKm + normalHybridCharger) * (getCylinderCapacity()/hybridDivision);
		} else {
			batteryConsumptionPerKm = (batteryDurationInKm + fastHybridCharger) * (getCylinderCapacity()/hybridDivision);
		} // charger if
		
		return batteryConsumptionPerKm;
	} // calculate gasoline consume



	@Override
	public String toString() {
		return "\n| HYBRID CAR | \nBattery Duration In Km: " + batteryDurationInKm + "\nBattery Consumption Per Km: "
				+ batteryConsumptionPerKm + "\nTank Capacity: " + tankCapacity + "\nConsumption Per Km: " + consumptionPerKm
				+ "\nGasoline Type: " + gasolineType + "\nCharger Type: " + chargerType + "\nSell Price: "+calculateTotalPrice();
	}
	
	
} // hybrid
