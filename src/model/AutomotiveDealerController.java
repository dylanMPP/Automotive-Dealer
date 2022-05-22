package model;

import java.util.ArrayList;

public class AutomotiveDealerController {
	
	public ArrayList <Vehicle> vehicles;
	public ParkingLot garage;
	
	public AutomotiveDealerController() {
		vehicles = new ArrayList <Vehicle> ();
		garage = new ParkingLot();
	} // taxController
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method register a car
     * 
	 * <strong> Pre </strong> Select the register vehicle, car options
	 * <strong> Pos </strong> Car registered
	 * <strong> Inputs </strong>  Input basePrice, brand, model, carType, cylinderCapacity, mileage,
					idPlate, doorsAmount, areWindowsTinted, type, gasolineType, tankCapacity, chargerType, batteryDurationInKm
	 * <strong> Outputs:</strong> Returns a boolean (register)
	 * </pre>
	 */
	public boolean registerCar(int typeOfCar, double basePrice, String brand, String model, int carType, int cylinderCapacity, double mileage, String idPlate, int doorsAmount, char areWindowsTinted, 
			int type, int gasolineType, double tankCapacity, double batteryDurationInKm, int chargerType, double discount) {
		
		boolean register = false;
		
		switch(typeOfCar) {
			
		case 1:
			vehicles.add(new Gasoline(basePrice, brand, model, carType, cylinderCapacity, mileage,
					idPlate, doorsAmount, areWindowsTinted, type, gasolineType, tankCapacity, discount));
			register = true;
			break;
			
		case 2:
			vehicles.add(new Electric(basePrice, brand, model, carType, cylinderCapacity, mileage,
					idPlate, doorsAmount, areWindowsTinted, type, chargerType, batteryDurationInKm, discount));
			register = true;
			break;
			
		case 3:
			vehicles.add(new Hybrid(basePrice, brand, model, carType, cylinderCapacity, mileage,
					idPlate, doorsAmount, areWindowsTinted, type, gasolineType, tankCapacity, chargerType, batteryDurationInKm, discount));
			register = true;
			break;
		}
		
		return register;
	} // register car
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method register a motorcycle
     * 
	 * <strong> Pre </strong> Select the register vehicle, motorcycle options
	 * <strong> Pos </strong> Motorcycle registered
	 * <strong> Inputs </strong>  Input basePrice, brand, model, type, cylinderCapacity, mileage, idPlate, motorcycleType, tankCapacity
	 * <strong> Outputs:</strong> Returns a boolean (true)
	 * </pre>
	 */
	public boolean registerMotorcycle(double basePrice, String brand, String model, int type, int cylinderCapacity, double mileage, String idPlate, int motorcycleType, double tankCapacity, double discount) {
		
		vehicles.add(new Motorcycle(basePrice, brand, model, type, cylinderCapacity, mileage, idPlate, motorcycleType, tankCapacity, discount));
		return true;
	} // register motorcycle
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method affords to delete a vehicle from the list of vehicles.
     * 
	 * <strong> Pre </strong> 
	 * <strong> Pos </strong>
	 * <strong> Inputs </strong>  Input wichVehicle
	 * <strong> Outputs:</strong> Returns a boolean (true)
	 * </pre>
	 */
	public boolean deleteVehicle(int wichVehicle) {
		vehicles.remove(wichVehicle-1);
		return true;
	} // delete vehicle
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method register a document
     * 
	 * <strong> Pre </strong> Select the register document option
	 * <strong> Pos </strong> Document registered
	 * <strong> Inputs </strong>  Input wichVehicle, documentType, id, price, year, coverageAmount, gasLvl
	 * <strong> Outputs:</strong> Returns a boolean (register)
	 * </pre>
	 */
	public boolean registerDocument(int wichVehicle, int documentType, String id, double price, int year, double coverageAmount, double gasLvl) {
		
		
		switch(documentType) {
		
		case 1:
			return vehicles.get(wichVehicle-1).getDocuments().add(new Document(id, price, year));
			
		case 2:
			return vehicles.get(wichVehicle-1).getDocuments().add(new Soat(id, price, year, coverageAmount));
			
		case 3:
			return vehicles.get(wichVehicle-1).getDocuments().add(new Technomechanic(id, price, year, gasLvl));
		} // switch doc type
		
		return false;
		
	} // register document
	
	// ---------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method shows the vehicles list according car or motorcycle and their respective information
     * 
	 * <strong> Pre </strong> Select the info option
	 * <strong> Pos </strong> List of all the vehicles with info
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Returns a String
	 * </pre>
	 */
	public String showVehiclesList() {
		
		String msg = "";
		
		
		if (vehicles.isEmpty()){
			return "";
		} else {
			for (int i = 0; i < vehicles.size(); i++) {
					msg += "\n"+(i+1)+") "+vehicles.get(i).getBrand()+" - "+vehicles.get(i).getModel();
			} // for
			
			return msg;
		}
	} // show vehicles list 
	
	// ---------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method gets the total sell price of a vehcile
     * 
	 * <strong> Pre </strong> Select any option of info or price option vehicle
	 * <strong> Pos </strong> The sell price
	 * <strong> Inputs </strong>  Input wichVehicle
	 * <strong> Outputs:</strong> Returns a double
	 * </pre>
	 */
	public double totalVehiclePrice(int wichVehicle) {

		return vehicles.get(wichVehicle-1).calculateTotalPrice();
	} // show vehicles list 
	
	// ---------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method show the information of the type(car-motorcycle) vehicles
     * 
	 * <strong> Pre </strong> Select the type info option
	 * <strong> Pos </strong> The info by car-motorcycle category
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Returns a String
	 * </pre>
	 */
	public String vehicleInformationByType() {
		
		String msg = "";
		
		for (int i = 0; i<vehicles.size(); i++) {
			
			if (vehicles.get(i) instanceof Car) {
				msg+= "\n | CAR | \n"+vehicles.get(i).toString();
			} // if
			
			if (vehicles.get(i) instanceof Motorcycle) {
				msg+= "\n | MOTORCYCLE | \n"+vehicles.get(i).toString();
			} // if
		} // for
		
		return msg;
	} // all type vehicle info
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method show the information of the gasoline vehicles
     * 
	 * <strong> Pre </strong> Select the gasoline type info option
	 * <strong> Pos </strong> The info by gasoline category
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Returns a String
	 * </pre>
	 */
	public String vehicleInformationByGasolineType() {
		
		String msg = "";
		
		for (int i = 0; i<vehicles.size(); i++) {
			if (vehicles.get(i) instanceof Gasoline) {
				
				if (vehicles.get(i).getGasolineType() == GasolineType.REGULAR) {
					msg+= "\n\n | REGULAR GASOLINE | \n"+vehicles.get(i).toString();
				} // if
				
				if (vehicles.get(i).getGasolineType() == GasolineType.EXTRA) {
					msg+= "\n\n | EXTRA GASOLINE | \n"+vehicles.get(i).toString();
				} // if
				
				if (vehicles.get(i).getGasolineType() == GasolineType.DIESEL) {
					msg+= "\n\n | DIESEL GASOLINE | \n"+vehicles.get(i).toString();
				} // if
			} // if
			
			if (vehicles.get(i) instanceof Hybrid) {
				if (vehicles.get(i).getGasolineType() == GasolineType.REGULAR) {
					msg+= "\n\\n | REGULAR GASOLINE | \n"+vehicles.get(i).toString();
				} // if
				
				if (vehicles.get(i).getGasolineType() == GasolineType.EXTRA) {
					msg+= "\n\\n | EXTRA GASOLINE | \n"+vehicles.get(i).toString();
				} // if
				
				if (vehicles.get(i).getGasolineType() == GasolineType.DIESEL) {
					msg+= "\n\n | DIESEL GASOLINE | \n"+vehicles.get(i).toString();
				} // if
			}
		} // for
		
		return msg;
	} // all gasoline type vehicle info
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method show the information of the new-used vehicles
     * 
	 * <strong> Pre </strong> Select the new used info option
	 * <strong> Pos </strong> The info by new-used category
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Returns a String
	 * </pre>
	 */
	public String vehicleInformationByNewUsed() {
		
		String msg = "";
		
		for (int i = 0; i<vehicles.size(); i++) {
			if (vehicles.get(i).getType() == VehicleType.NEW) {
				msg+= "\n | NEW | \n"+vehicles.get(i).toString();
			} // if
			
			if (vehicles.get(i).getType() == VehicleType.USED) {
				msg+= "\n | USED | \n"+vehicles.get(i).toString();
			} // if
		} // for
		
		return msg;
	} // all type vehicle info
	// ---------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method shows the status of the docs of a vehicle
     * 
	 * <strong> Pre </strong> Select the doc status of a vehicle option
	 * <strong> Pos </strong> The doc status of a vehicle
	 * <strong> Inputs </strong>  Input wichVehicle
	 * <strong> Outputs:</strong> Returns a String
	 * </pre>
	 */
	public String docStatusOfAVehicle(int wichVehicle) {
		
		return vehicles.get(wichVehicle-1).docStatus();
	} // doc status of a vehicle
	
	// ---------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method show the parking lot map
     * 
	 * <strong> Pre </strong> Select see the parking map option
	 * <strong> Pos </strong> The parking map in a string
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Returns a String (parkingmap)
	 * </pre>
	 */
	public String parkingMap() {
		return garage.showParkingMap();
	} // parking map
	
	// ---------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method shows the occupancy percentage of the parking lot
     * 
	 * <strong> Pre </strong> Select one of the parking options
	 * <strong> Pos </strong> The occupancy percentage calculated
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Returns a double (percentage)
	 * </pre>
	 */
	public double parkingOccupancy() {
		addVehicleToParking();
		return garage.occupancyPercentage();
	} // occupancy percentage
	
	// ---------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method affords to add all the according vehicles to the parking
     * 
	 * <strong> Pre </strong> Select any option of the parking lot
	 * <strong> Pos </strong> The parking lot filled (completely or not) by vehicles
	 * <strong> Inputs </strong> None
	 * <strong> Outputs:</strong> Returns a boolean (true)
	 * </pre>
	 */
	public boolean addVehicleToParking() {
		
		garage.generateGarage();
		for (int i = 0; i<vehicles.size(); i++) {
			garage.addVehicle(vehicles.get(i));
		} // for
		
		return true;
	} // add vehicle to parking

	// ---------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method shows wich vehicles are in an specific year
     * 
	 * <strong> Pre </strong> Select the vehicles according to a year option
	 * <strong> Pos </strong> The vehicles that are in a year in a msg
	 * <strong> Inputs </strong>  Input wichYear
	 * <strong> Outputs:</strong> Returns a String (msg)
	 * </pre>
	 */
	public String vehiclesAccordingToYear(String wichYear) {
		
		String msg = "";
		
		for(int i = 0; i < vehicles.size(); i++) {
			if(vehicles.get(i).getModel().equals(wichYear)) {
				msg += "\n"+(i+1)+") "+vehicles.get(i).toString();
			}
		} // for
		
		return msg;
	} // vehicles according to a year
	
	// ---------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method shows wich vehicles are ina range of years
     * 
	 * <strong> Pre </strong> Select the which vehicles in years option
	 * <strong> Pos </strong> The vehicles that are in a years in a msg
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Returns a String (msg)
	 * </pre>
	 */
	public String vehiclesInYears(int oldYear, int newYear) {
		
		String msg = "";
		
		for (int i = 0; i < vehicles.size(); i++) {
			
			int model = Integer.parseInt(vehicles.get(i).getModel());
			if (model >= oldYear && model <= newYear) {
				msg += "\n"+(i+1)+") "+vehicles.get(i).toString();
			} // if
		} // for
		
		return msg;
	} // vehicles in years
	
	// ---------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method shows wich is the oldest and newest vehicle
     * 
	 * <strong> Pre </strong> Select the oldest and newest vehicle option
	 * <strong> Pos </strong> The oldest and newest vehicle info in a msg
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Returns a String (msg)
	 * </pre>
	 */
	public String oldestNewestVehicle() {
		
		Vehicle oldest = null;
		Vehicle newest = null;
		int old = 99999;
		int new0 = 1;
		
		for (int i = 0; i<vehicles.size(); i++) {
			
			int model = Integer.parseInt(vehicles.get(i).getModel());
			if (model<old) {
				oldest = vehicles.get(i);
				old = model;
			}
			
			if (model>new0) {
				newest = vehicles.get(i);
				new0 = model;
			}
		} // for
		
		return "\n\n | The OLDEST VEHICLE is :"+oldest.toString()+" |"+"\n\n | The NEWEST VEHICLE is :"+newest.toString()+" |";
	} // oldestNewest
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method shows the documents list of a vehicle
     * 
	 * <strong> Pre </strong> Select see doc list option
	 * <strong> Pos </strong> The list of the docs gets in a msg
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Returns a String msg
	 * </pre>
	 */
	public String documentListOfVehicle(int wichVehicle) {
		
		return vehicles.get(wichVehicle-1).documentList();
		
	} // documentlistofbvehicle
} // controller
