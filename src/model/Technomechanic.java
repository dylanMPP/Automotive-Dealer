package model;

import java.util.Random;

public class Technomechanic extends Document{
	
	private double gasLvl;
	
	public Technomechanic(String id, double price, int year, double gasLvl) {
		super(id, price, year);
		this.gasLvl = gasLvl;
		setImage(decode());
	} // technomecanic constructor
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method decode the code of the technomechanic document according to its matrix.
     * 
	 * <strong> Pre </strong> Select create technomechanic doc
	 * <strong> Pos </strong> The code of the doc
	 * <strong> Inputs </strong>  None
	 * <strong> Outputs:</strong> Returns a String (code msg)
	 * </pre>
	 */
	@Override
	public String decode() { // decode of the property card
		
		int [][] imageMatrix = new int [4][4];
		String msg = "";
		
		Random rand = new Random();
		
		// creating the random matrix
		for (int i = 0; i < imageMatrix.length; i++) {
			for (int j = 0; j < imageMatrix[0].length; j++) {
				
				imageMatrix[i][j] = rand.nextInt(36);
			} // column for
		} // row for
		
		for (int i = 0; i < imageMatrix.length; i++) {
			for (int j = 0; j < imageMatrix[0].length; j++) {
				
				if (i==0) {
					msg += imageMatrix[i][j];
				} // if row == 0
				
				if (i+j==3 && i!=0 && i!=imageMatrix.length-1) {
					msg += imageMatrix[i][j];
				} // if diagonal (i+j equals to 0)
				
				if (i==imageMatrix.length-1){
					msg += imageMatrix[i][j];
				} // if last row
		
			} // column for
		} // row for
		
		return msg;
	} // decode

	public double getGasLvl() {
		return gasLvl;
	}

	public void setGasLvl(double gasLvl) {
		this.gasLvl = gasLvl;
	}
} // techno
