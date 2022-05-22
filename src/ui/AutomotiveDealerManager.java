package ui;

import model.AutomotiveDealerController;
import model.Init;

import java.util.Scanner;

public class AutomotiveDealerManager {
	
	
	private static Scanner reader;
	private static AutomotiveDealerController controller;
	private static Init init;
	
	public static void main(String[] args) {
		init();
		showMainMenu();
	} // main
	
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method initialize the reader and the controller.
     * 
	 * <strong> Pre </strong> None
	 * <strong> Pos </strong> The reader and controller initialized
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> None
	 * </pre>
	 */
	public static void init() {
		
		reader = new Scanner(System.in);
		controller = new AutomotiveDealerController();
		init = new Init(controller);
	} // init
	
	// --------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method shows the main menu.
     * 
	 * <strong> Pre </strong> None
	 * <strong> Pos </strong> The main menu showed to the user.
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> None
	 * </pre>
	 */
	public static void showMainMenu() {
		
		System.out.println("\n\n WELCOME TO THE AUTOMOTIVE DEALER PROGRAM !\n\n");
		
		boolean runFlag = true;

		while (runFlag) {

			System.out.println("\n"+"\n——————————————————————————————\n                MENU\n\nWhat do you want to do? \n\n1) Administrate the automotive dealer. \n2) See the vehicles information. \n3) See the status of the old vehicles parking. \n0) Exit.\n\n——————————————————————————————");
			int decision = reader.nextInt(); // I ask the user what he/she wants to do.

			switch (decision){

				case 1:
					showAdministrateDealer();
				break;

				case 2:
					showSeeVehiclesInformation();
				break;
				
				case 3:
					showSeeVehiclesParkingInformation();
				break;

				case 0:
					System.out.println("Thank you for using our system! Have a good one.");
					runFlag = false;
				break;

				default:
					System.out.println("\nPlease, type a valid option.\n");
				break;
			} // switch
		} // while
	} // show main menu
	
	// --------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method shows the administrate dealer menu.
     * 
	 * <strong> Pre </strong> None
	 * <strong> Pos </strong> The administrate dealer menu showed.
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> None
	 * </pre>
	 */
	public static void showAdministrateDealer(){

		boolean runFlag = true;

		while(runFlag) {
		
			System.out.println("\n\n-----------------------------\n      ADMINISTRATE AUTOMOTIVE DEALER\n\nI'm going to...\n\n1) Register a vehicle. \n2) Delete a vehicle. \n0) Get back. \n-----------------------------");
			int decision2 = reader.nextInt();

			switch (decision2){

			case 1:
				registerVehicle();
			break;

			case 2:
				deleteVehicle();
			break;
			
			case 0:
				runFlag = false;
			break;

			default:
				System.out.println("\nPlease, type a valid option.\n");
			break;
			} // switch
		} // while

	} // administrate dealer menu

	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method shows the see vehicles information menu.
     * 
	 * <strong> Pre </strong> None
	 * <strong> Pos </strong> The see vehicles information menu showed.
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> None
	 * </pre>
	 */
	public static void showSeeVehiclesInformation(){

		boolean runFlag = true;

		while(runFlag) {
		
			System.out.println("\n\n-----------------------------\n      VEHICLES INFORMATION\n\nI'm going to...\n\n1) Register document. \n2) See all vehicles info by type. \n3) See all vehicles info by gasoline type. \n4) See all vehicles info by used or new. \n5) See a total vehicle price. \n6) See the document status of a vehicle. \n7) See vehicles according to a year. "
					+ "\n8) See the vehicles that are in a range of years."+"\n9) See the oldest and newest vehicle"+"\n10) Show the doc. list of a vehicle."+"\n0) Get back. \n-----------------------------");
			int decision2 = reader.nextInt();

			switch (decision2){

			case 1:
				registerDocument();
			break;

			case 2:
				vehicleInformationByType();
			break;
			
			case 3:
				vehicleInformationByGasolineType();
			break;
			
			case 4:
				vehicleInformationByNewUsed();
			break;
			
			case 5:
				totalVehiclePrice();
			break;
			
			case 6:
				docStatusOfAVehicle();
			break;
			
			case 7:
				vehiclesAccordingToYear();
			break;
			
			case 8:
				vehiclesInAYears();
				break;
				
			case 9:
				oldestAndNewestVehicle();
				break;
				
			case 10:
				showTheDocListOfVehicle();
				break;
			case 0:
				runFlag = false;
			break;

			default:
				System.out.println("\nPlease, type a valid option.\n");
			break;
			} // switch
		} // while
		
	} // see vehicles information menu

	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method shows the see vehicles parking information menu.
     * 
	 * <strong> Pre </strong> None
	 * <strong> Pos </strong> The see vehicles parking information menu showed.
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> None
	 * </pre>
	 */
	public static void showSeeVehiclesParkingInformation(){
		
		boolean runFlag = true;

		while(runFlag) {
		
			System.out.println("\n\n-----------------------------\n      OLD VEHICLES PARKING INFORMATION\n\nI'm going to...\n\n1) See the parking lot map. \n2) See the parking occupancy. \n0) Get back. \n-----------------------------");
			int decision2 = reader.nextInt();

			switch (decision2){

			case 1:
				parkingMap();
			break;

			case 2:
				parkingOccupancy();
			break;
			
			case 0:
				runFlag = false;
			break;

			default:
				System.out.println("\nPlease, type a valid option.\n");
			break;
			} // switch
		} // while
	} // see old vehicles parking status


	// --------------------------------------------------------------------------------------------------------------------------------------

	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method asks info and calls methods of the controller to register a vehicle
     * 
	 * <strong> Pre </strong> None
	 * <strong> Pos </strong> The vehicle registered
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Succesfully msg
	 * </pre>
	 */
	private static void registerVehicle() {
		System.out.println("Wich vehicle do you want to register? \n1) A car. \n2) A motorcycle.");
		int option = reader.nextInt();
		
		String idPlate = "0";
		int gasolineType = -1;
		double tankCapacity = -1;
		double batteryDurationInKm = -1;
		int chargerType = -1;
		
		switch(option) {
	
		case 1:
			
			System.out.println("Wich type of car do you are you going to register? \n1) A gasoline car. \n2) An electric car. \n3) An hybrid car.");
			int typeOfCar = reader.nextInt();
			
			System.out.println("The car is... \n1) Sedan. \n2) Pick-up truck.");
			int carType = reader.nextInt();
			
			System.out.println("Type its base price.");
			double basePrice = reader.nextDouble();
			
			System.out.println("Type the brand of the car.");
			String brand = reader.next();
			
			System.out.println("Wich model is the car?");
			String model = reader.next();
			
			System.out.println("Type its cylinder capacity");
			int cylinderCapacity = reader.nextInt();
			
			System.out.println("How many KM has the car roaded? (mileage)");
			double mileage = reader.nextDouble();
			
			System.out.println("The car is... \n1) New. \n2) Used.");
			int type = reader.nextInt();
			
			if (type==1) {
				idPlate = "0";
			} else {
				System.out.println("Type the car's ID plate.");
				idPlate = reader.next();
			} // if new (idplate)
			
			System.out.println("How many doors the car has?");
			int doorsAmount = reader.nextInt();
			
			System.out.println("Are the windows tinted? Y: Yes.    N: No.");
			String areWindows = reader.next();
			char areWindowsTinted = areWindows.charAt(0);
			
			
			if (typeOfCar==1 || typeOfCar ==3) {
				
				System.out.println("Which is the type of the gasoline. \n1) Regular. \n2) Extra. \n3) Diesel.");
				gasolineType = reader.nextInt();
				
				System.out.println("Which is the tank's capacity? In gallons");
				tankCapacity = reader.nextDouble();
			} 
			
			if (typeOfCar == 2 || typeOfCar == 3) {
			
				System.out.println("Type the battery duration of the car. (in KM)");
				batteryDurationInKm = reader.nextDouble();
				
				System.out.println("Which is the type of the car's charger? \n1) Normal. \n2) Fast.");
				chargerType = reader.nextInt();
			} // if type of car
			
			System.out.println("If the car has discount, type it (in %). If not, type 0.");
			double discount = reader.nextDouble()/100;
			
			if(controller.registerCar(typeOfCar, basePrice, brand, model, carType, cylinderCapacity, mileage, idPlate, doorsAmount, areWindowsTinted, type, gasolineType, tankCapacity, batteryDurationInKm, chargerType, discount)){
				System.out.println("The car has been registered succesfully");
			} else {
				System.out.println("The car has failed to get registered.");
			} // if register car
			
			break;
		// -------- //
		case 2:
			System.out.println("");
			
			System.out.println("Type its base price.");
			basePrice = reader.nextDouble();
			
			System.out.println("Type the brand of the motorcycle.");
			brand = reader.next();
			
			System.out.println("Wich model is the motorcycle?");
			model = reader.next();
			
			System.out.println("Type its cylinder capacity");
			cylinderCapacity = reader.nextInt();
			
			System.out.println("How many KM has the motorcycle roaded? (mileage)");
			mileage = reader.nextDouble();
			
			System.out.println("The motorcycle is... \n1) New. \n2) Used.");
			type = reader.nextInt();
			
			if (type==1) {
				idPlate = "0";
			} else {
				System.out.println("Type the motorcycle's ID plate.");
				idPlate = reader.next();
			} // if new (idplate)
			
			System.out.println("Which is the tank's capacity? In gallons");
			tankCapacity = reader.nextDouble();
			
			System.out.println("Wich type of motorcycle do you are you going to register? \n1) Standard. \n2) Sporty. \n3) Scooter. \n4) Cross");
			int motorcycleType = reader.nextInt();
			
			System.out.println("If the car has discount, type it (in %). If not, type 0.");
			discount = reader.nextDouble()/100;
			
			if(controller.registerMotorcycle(basePrice, brand, model, type, cylinderCapacity, mileage, idPlate, motorcycleType, tankCapacity, discount)){
				System.out.println("The motorcycle has been registered succesfully");
			} else {
				System.out.println("The motorcycle has failed to get registered.");
			} // if register car
			
			break;
		} // switch
	} // register vehicle
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method asks info and calls methods of the controller to delete a vehicle
     * 
	 * <strong> Pre </strong> None
	 * <strong> Pos </strong> The vehicle deleted
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Succesfully msg
	 * </pre>
	 */
	private static void deleteVehicle() {
		System.out.println("Wich vehicle do you want to delete?");
		
		if (controller.showVehiclesList()!=""){
			System.out.println(controller.showVehiclesList());
			int wichVehicle = reader.nextInt();
			
			if (controller.deleteVehicle(wichVehicle)) {
				System.out.println("The vehicle has been deleted succesfully");
			} else {
				System.out.println("The vehicle has failed to get deleted.");
			}
		} else {
			System.out.println("There are no vehicles registered yet.");
		}
		
	} // delete vehicle
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method asks info and calls methods of the controller to register a document
     * 
	 * <strong> Pre </strong> None
	 * <strong> Pos </strong> The document registered
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Succesfully msg
	 * </pre>
	 */
	private static void registerDocument() {
		
		double gasLvl = -1;
		double coverage = 0;
		
		System.out.println("In wich vehicle do you want to add a document?");
		if (controller.showVehiclesList()!=""){
			System.out.println(controller.showVehiclesList());
			int wichVehicle = reader.nextInt();
			
			System.out.println("The document is a... \n1) Property one. \n2) SOAT one. \n3) Technomechanic one.");
			int documentType = reader.nextInt();
			
			System.out.println("Type the document's id.");
			String id = reader.next();
			
			System.out.println("Type the price of de document.");
			double price = reader.nextDouble();
			
			System.out.println("Of wich year is the document?");
			int year = reader.nextInt();
			
			if (documentType == 2) {
				System.out.println("Wich is the coverage amount of the SOAT");
				coverage = reader.nextDouble();
			} 
			
			if (documentType == 3) {
				System.out.println("Wich gas level is reported on the technomechanic?");
				gasLvl = reader.nextDouble();
			} // if document type
		
			if (controller.registerDocument(wichVehicle, documentType, id, price, year, coverage, gasLvl)) {
				System.out.println("The document has been registered succesfully");
			} else {
				System.out.println("The document has failed to get registered.");
			}
		} else {
			System.out.println("There are no vehicles registered yet.");
		}
		
	} // register document
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method asks info and calls methods of the controller to calculates the total price of a vehicle
     * 
	 * <strong> Pre </strong> None
	 * <strong> Pos </strong> The sell price vehicle showed
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> The sell price vehicle showed
	 * </pre>
	 */
	public static void totalVehiclePrice() {
		System.out.println("The price of wich vehicle do you want to know?");
		
		if (controller.showVehiclesList()!=""){
			System.out.println(controller.showVehiclesList());
			int wichVehicle = reader.nextInt();
			
			if(controller.totalVehiclePrice(wichVehicle) >=0) {
				
				System.out.println("The price of the vehicle is: "+controller.totalVehiclePrice(wichVehicle));
			} else {
				
				System.out.println("The price of the vehicle can't be shown. The vehicle doesn't exist.");
			} // if total vehicle price
		} else {
			System.out.println("There are no vehicles registered yet.");
		}
		
	} // total vehicle price of one vehicle
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method asks info and calls methods of the controller to show the information of a vehicle by type
     * 
	 * <strong> Pre </strong> None
	 * <strong> Pos </strong> The information of vehicles by type cateogry
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> The information of vehicles by type cateogry
	 * </pre>
	 */
	public static void vehicleInformationByType() {
		
		if(controller.vehicleInformationByType().equals("")){
			System.out.println("The information of the vehicles by type can't be shown.");
		} else {
			System.out.println("| VEHICLES BY TYPE INFO | \n"+controller.vehicleInformationByType());
		} // if total vehicle price
	} // all vehicle info
	
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method asks info and calls methods of the controller to show the information of a vehicle by gasoline type
     * 
	 * <strong> Pre </strong> None
	 * <strong> Pos </strong> The information of vehicles by gasoline type category
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> The information of vehicles by gasoline type category
	 * </pre>
	 */
	public static void vehicleInformationByGasolineType() {
		
		if(controller.vehicleInformationByGasolineType().equals("")){
			System.out.println("The information of the vehicles by gasoline type can't be shown.");
		} else {
			System.out.println("| VEHICLES BY GASOLINE TYPE INFO | \n"+controller.vehicleInformationByGasolineType());
		} // if total vehicle price
	} // all vehicle info
	
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method asks info and calls methods of the controller to show the information of a vehicle by new-used type
     * 
	 * <strong> Pre </strong> None
	 * <strong> Pos </strong> The information of vehicles by new-used category
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> The information of vehicles by new-used category
	 * </pre>
	 */
	public static void vehicleInformationByNewUsed() {
		
		if(controller.vehicleInformationByNewUsed().equals("")){
			System.out.println("The information of the vehicles by new or used can't be shown.");
		} else {
			System.out.println("| VEHICLES BY NEW OR USED INFO | \n"+controller.vehicleInformationByNewUsed());
		} // if total vehicle price
	} // all vehicle info
	
	// --------------------------------------------------------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method asks info and calls methods of the controller to show the status of the documents of a vehicle
     * 
	 * <strong> Pre </strong> None
	 * <strong> Pos </strong> The document status of a vehicle
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> The document status of a vehicle
	 * </pre>
	 */
	public static void docStatusOfAVehicle() {
		System.out.println("The document status of wich vehicle do you want to know?");
		
		if (controller.showVehiclesList()!=""){
			System.out.println(controller.showVehiclesList());
			int wichVehicle = reader.nextInt();
			
			if(controller.docStatusOfAVehicle(wichVehicle).equals("")) {
				
				System.out.println("The information of the documentation of the vehicle can't be shown.");
			} else {
				System.out.println("| DOC STATUS OF THE VEHICLE | \n"+controller.docStatusOfAVehicle(wichVehicle));
			} // if total vehicle price
		} else {
			System.out.println("There are no vehicles registered yet.");
		}
		
	} // doc status
	
	// ----------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method asks info and calls methods of the controller to show the vehicles according to an specific year
     * 
	 * <strong> Pre </strong> None
	 * <strong> Pos </strong> The vehicles that are in a year showed
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Show vehicles in an specific year
	 * </pre>
	 */
	public static void vehiclesAccordingToYear() {
		System.out.println("In wich year do you want to know wich vehicles are?");
		String wichYear = reader.next();
		
		if (controller.vehiclesAccordingToYear(wichYear) != "") {
			System.out.println("\nThese are the cars that has the model "+wichYear+"\n");
			System.out.println(controller.vehiclesAccordingToYear(wichYear));
		} else {
			System.out.println("There are no vehicles with that model");
		}
		
	}
	
	// ----------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method asks info and calls methods of the controller to show the parking map
     * 
	 * <strong> Pre </strong> None
	 * <strong> Pos </strong> The parking map created and initialized and filled
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Parking map showed
	 * </pre>
	 */
	public static void parkingMap() {
		controller.addVehicleToParking();
		System.out.println(controller.parkingMap());
	}
	
	// ----------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method asks info and calls methods of the controller to show the percentage occupancy of the parking lot
     * 
	 * <strong> Pre </strong> None
	 * <strong> Pos </strong> The percentage of the parking occupancy calculated
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Show the percentage of occupancy of the parking
	 * </pre>
	 */
	public static void parkingOccupancy() {
		System.out.println("The occupancy of the PARKING IS: "+controller.parkingOccupancy()+"%");
	}

	// ----------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method asks info and calls methods of the controller to show the vehicles according to a range of years.
     * 
	 * <strong> Pre </strong> None
	 * <strong> Pos </strong> The vehicles that are in the range of years are showed
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Show vehicles that are contained in a range of years.
	 * </pre>
	 */
	private static void vehiclesInAYears() {
		System.out.println("Type the oldest year.");
		int oldYear = reader.nextInt();
		
		System.out.println("Type the newest year.");
		int newYear = reader.nextInt();
		
		if (controller.vehiclesInYears(oldYear, newYear)!="") {
			System.out.println("These are the vehicles that are in the years: "+oldYear+" - "+newYear+controller.vehiclesInYears(oldYear, newYear));
			
		} else {
			System.out.println("There are no vehicles in that range of years.");
		}
	}
	
	// ----------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method asks info and calls methods of the controller to show the oldest and newest vehicles (accordint to their model)
     * 
	 * <strong> Pre </strong> None
	 * <strong> Pos </strong> The oldest and newest vehicles get identified
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Show the oldest and newewst vehicles
	 * </pre>
	 */
	private static void oldestAndNewestVehicle() {
		System.out.println(controller.oldestNewestVehicle());
	}
	
	// ----------------------------------------------------------------------------------------
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method asks info and calls methods of the controller to show the list of documents of a vehicle
     * 
	 * <strong> Pre </strong> None
	 * <strong> Pos </strong> The list of documents of a vehicle
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Show list of the documents of a vehicle
	 * </pre>
	 */
	private static void showTheDocListOfVehicle() {
		System.out.println("The document list of wich vehicle do you want to know?");
		
		if (controller.showVehiclesList()!=""){
			System.out.println(controller.showVehiclesList());
			int wichVehicle = reader.nextInt();
			
			if(controller.documentListOfVehicle(wichVehicle).equals("")) {
				
				System.out.println("The information of the documentation of the vehicle can't be shown.");
			} else {
				System.out.println("| DOC LIST | \n"+controller.documentListOfVehicle(wichVehicle));
			} // if total vehicle price
		} else {
			System.out.println("There are no vehicles registered yet.");
		}
	}
	
} // automotive dealer manager
