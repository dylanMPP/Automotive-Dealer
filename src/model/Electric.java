package model;

public class Electric extends Car implements Dischargeable {

	private double batteryDurationInKm;
	private double batteryConsumptionPerKm;
	private ChargerType chargerType;
	
	public Electric(double basePrice, String brand, String model, int carType, int cylinderCapacity, double mileage,
			String idPlate, int doorsAmount, char areWindowsTinted, int type, int chargerType, double batteryDurationInKm, double discount) {
		
		super(basePrice, brand, model, carType, cylinderCapacity, mileage, idPlate, doorsAmount, areWindowsTinted, type, discount);
		
		switch(chargerType) {
		
		case 1:
			this.chargerType = ChargerType.NORMAL;
			break;
			
		case 2:
			this.chargerType = ChargerType.FAST;
			break;
		} // chargertypeswitch
		
		this.batteryDurationInKm = batteryDurationInKm;
		this.batteryConsumptionPerKm = discharge();
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
	 * <strong> Pre </strong> Select create an electric car
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
			sellPrice += (getBasePrice()*electricCarAddition);
		} else {
			sellPrice += (getBasePrice()*electricCarAddition);
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
			batteryConsumptionPerKm = (batteryDurationInKm + normalElectricCharger) * (getCylinderCapacity()/electricDivision);
		} else {
			batteryConsumptionPerKm = (batteryDurationInKm + fastElectricCharger) * (getCylinderCapacity()/electricDivision);
		} // charger if
		
		return batteryConsumptionPerKm;
	} // calculate gasoline consume


	
	@Override
	public String toString() {
		return "\n| ELECTRIC CAR | \nBattery Duration In Km: " + batteryDurationInKm + "\nBattery Consumption Per Km: "
				+ batteryConsumptionPerKm + "\nCharger Type: " + chargerType + "\nSell Price: "+calculateTotalPrice();
	}
	
	
} // electric
