package model;

public class ParkingLot {
	
	private String [][] garage;
	
	public ParkingLot() {
		garage = new String [10][5];
		this.garage = generateGarage();
	} // parking lot constructor

	public String[][] getGarage() {
		return garage;
	}

	public void setGarage(String[][] garage) {
		this.garage = garage;
	}
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method generates the garage filled "empty".
     * 
	 * <strong> Pre </strong> Select any option of see parking lot
	 * <strong> Pos </strong>
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Returns a String matrix (garage)
	 * </pre>
	 */
	public String[][] generateGarage(){
		
		for (int i = 0; i < garage.length ; i++) {
			for (int j= 0; j < garage[0].length; j++) {
				garage[i][j] = "[  .  .  .  .  .  .  .  ]";
			} // column for
		} // row for
		return garage;
	} // generate garage
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method adds each vehicle to the parking lot
     * 
	 * <strong> Pre </strong> Select the show parking lot map option
	 * <strong> Pos </strong> The parking gets filled (completely or not) by the vehicles
	 * <strong> Inputs </strong>  Input Vehicle vehicles
	 * <strong> Outputs:</strong> None
	 * </pre>
	 */
	public void addVehicle(Vehicle vehicles) {
		
		int model = Integer.parseInt(vehicles.getModel());
		
		boolean runFlag = true;
		
		if(model < 2011){
			for (int i= 0; i < garage.length; i++) {
				if (runFlag == true) {
					if (garage[i][4].equals("[  .  .  .  .  .  .  .  ]")){
						
						garage[i][4] = "[ "+vehicles.getModel() + " - "+vehicles.getBrand()+" - "+vehicles.getIdPlate()+" ]";
						runFlag = false;
					} // if garage is empty
				} // if runflag
			} // for
		} // if 2011 vehicles
		
		if(model == 2011){
			for (int i= 0; i < garage.length; i++) {
				if (runFlag == true) {
					if (garage[i][3].equals("[  .  .  .  .  .  .  .  ]")) {
						
						garage[i][3] = "[ "+vehicles.getModel() + " - "+vehicles.getBrand()+" - "+vehicles.getIdPlate()+" ]";
						runFlag = false;
					} // if garage is empty
				} // if runflag
			} // for
		} // if 2011 vehicles
		
		
		if(model == 2012){
			for (int i= 0; i < garage.length; i++) {
				if (runFlag == true) {
					if (garage[i][2].equals("[  .  .  .  .  .  .  .  ]")) {
						
						garage[i][2] = "[ "+vehicles.getModel() + " - "+vehicles.getBrand()+" - "+vehicles.getIdPlate()+" ]";
						runFlag = false;
					} // if garage is empty
				} // if runflag
			} // for
		} // if 2012 vehicles
		
		
		if(model == 2013){
			for (int i= 0; i < garage.length; i++) {
				if (runFlag == true) {
					if (garage[i][1].equals("[  .  .  .  .  .  .  .  ]")) {
						
						garage[i][1] = "[ "+vehicles.getModel() + " - "+vehicles.getBrand()+" - "+vehicles.getIdPlate()+" ]";
						runFlag = false;
					} // if garage is empty
				} // if runflag
			} // for
		} // if 2013 vehicles
		
		
		if(model == 2014){
			for (int i= 0; i < garage.length; i++) {
				if (runFlag == true) {
					if (garage[i][0].equals("[  .  .  .  .  .  .  .  ]")) {
						
						garage[i][0] = "[ "+vehicles.getModel() + " - "+vehicles.getBrand()+" - "+vehicles.getIdPlate()+" ]";
						runFlag = false;
					} // if garage is empty
				} // if runflag
			} // for
		} // if 2014 vehicles
		
		if(model >= 2015){
			for (int i= 0; i < garage.length; i++) {
				if (runFlag == true) {
					if (garage[i][4].equals("[  .  .  .  .  .  .  .  ]")) {
						
						garage[i][4] = "[ "+vehicles.getModel() + " - "+vehicles.getBrand()+" - "+vehicles.getIdPlate()+" ]";
						runFlag = false;
					} // if garage is empty
				} // if runflag
			} // for
		} // if 2014 vehicles
	}
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method calculates the occupancy percentage of the parking.
     * 
	 * <strong> Pre </strong> Select the show occupancy percentage option
	 * <strong> Pos </strong> Perecentage calculated
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Returns a double percentage
	 * </pre>
	 */
	public double occupancyPercentage() {
		
		int occuped = 0;
		double percentage = 0;
		
		
		for(int i = 0; i < garage.length; i++) {
			for (int j = 0; j < garage[0].length; j++) {
				
				if (!(garage[i][j].equals("[  .  .  .  .  .  .  .  ]"))) {
					occuped += 1;
				}
			} // column for garage
		} // row for garage
		
		percentage = (occuped *100 ) ;
		percentage = percentage / 50;
		
		return percentage;
	} // percentage of occupancy
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method inser the garage in a msg
     * 
	 * <strong> Pre </strong> Select the show parking map option
	 * <strong> Pos </strong> The parking map gets ina  msg
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Returns a String msg
	 * </pre>
	 */
	public String showParkingMap() {
		
		String msg = "";
		
		for(int i = 0; i < garage.length; i++) {
			for (int j = 0; j < garage[0].length; j++) {
				
				msg += garage[i][j];
			} // column for garage
			msg += "\n";
		} // row for garage
		
		return msg;
	} // show parking map
	
} // parking lot 
