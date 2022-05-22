package model;

import java.util.ArrayList;

public abstract class Vehicle implements Payable{

	private double basePrice;
	private double sellPrice;
	private String brand;
	private String model;
	private VehicleType type;
	private int cylinderCapacity;
	private double mileage;
	private String idPlate;
	private ArrayList <Document> documents;
	private double discount;
	
	public Vehicle(double basePrice, String brand, String model, int type, int cylinderCapacity, double mileage, String idPlate, double discount) {
		
		this.basePrice = basePrice;
		this.sellPrice = 0;
		this.brand = brand;
		this.model = model;
		this.discount = discount;
		
		switch (type) {
		case 1:
			this.type = VehicleType.NEW;
			break;
		
		case 2:
			this.type = VehicleType.USED;
			break;
		} // switch
		
		this.cylinderCapacity = cylinderCapacity;
		this.mileage = mileage;
			
		if (idPlate.equals("0")) {
			this.idPlate = null;
		} else {
			this.idPlate = idPlate;
		} // if id plate
		
		this.documents = new ArrayList <Document> ();
	} // vehicle constructor
	
	
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method shows the status of the documents of a vehicle
     * 
	 * <strong> Pre </strong> Select see doc status option
	 * <strong> Pos </strong> The status of the documents gets in a msg
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Returns a String msg
	 * </pre>
	 */
	public String docStatus() {
		
		String msg = "";
		
		for (int i = 0; i < documents.size(); i++) {
			
			
			if (documents.get(i) instanceof Soat) {
				
				if(documents.get(i).getYear() < 2022) {
					msg += "\nThe soat has timed out.";
				} else {
					msg += "\nThe soat is correct. Its year is "+documents.get(i).getYear();
				} // timed out soat
				
			} else if(documents.get(i) instanceof Technomechanic) {
				
				if(documents.get(i).getYear() < 2022) {
						msg += "\nThe technomechanic has timed out.";
					} else {
						msg += "\nThe technomechanic is correct. Its year is "+documents.get(i).getYear();
					} // timed out soat
				
				} else if (documents.get(i).getYear() < 2022) {
						msg += "\nThe property has timed out.";
					} else {
						msg += "\nThe property is correct. Its year is "+documents.get(i).getYear();
					}	 // timed out property)
			} // for
		
		if (!msg.contains("soat")) {
			msg += "\nThe vehicle doesn't have soat.";
		}
		
		if (!msg.contains("technomechanic")) {
			msg += "\nThe vehicle doesn't have technomechanic.";
		}
		
		if (!msg.contains("property")) {
			msg += "\nThe vehicle doesn't have property.";
		}
		
		return msg;
	} // doc status
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method shows the list of the documents of a vehicle
     * 
	 * <strong> Pre </strong> Select see doc. list option
	 * <strong> Pos </strong> The list and info. of the documents gets in a msg
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Returns a String msg
	 * </pre>
	 */
	public String documentList() {
		
		String msg = "";
		
		for (int i = 0; i < documents.size(); i++) {
			
			msg += "\n"+(i+1)+") "+documents.get(i).toString();
		} // for
		
		return msg;
	} // doc list
	
	
	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public VehicleType getType() {
		return type;
	}

	public void setType(VehicleType type) {
		this.type = type;
	}

	public int getCylinderCapacity() {
		return cylinderCapacity;
	}

	public void setCylinderCapacity(int cylinderCapacity) {
		this.cylinderCapacity = cylinderCapacity;
	}

	public double getMileage() {
		return mileage;
	}

	public void setMileage(double mileage) {
		this.mileage = mileage;
	}

	public String getIdPlate() {
		return idPlate;
	}

	public void setIdPlate(String idPlate) {
		this.idPlate = idPlate;
	}

	public ArrayList<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(ArrayList<Document> documents) {
		this.documents = documents;
	}

	public GasolineType getGasolineType() {
		return getGasolineType();
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
	
	
} // vehicle
