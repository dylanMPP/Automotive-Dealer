package model;

import java.util.Random;

public class Soat extends Document{
	
	private double coverageAmount;
	
	public Soat(String id, double price, int year, double coverageAmount) {
		super(id, price, year);
		setImage(decode());
		this.coverageAmount = coverageAmount;
	} // doc constructor
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method decode the code of the soat document according to its matrix.
     * 
	 * <strong> Pre </strong> Select create soat doc
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
				
				if(j==0) {
					msg += imageMatrix[i][j];
				} // if the column is the first
				
				if (j!=0) {
					if(i==imageMatrix.length-1) {
						msg += imageMatrix[i][j];
					} // if the row is the last
				} // if the column isn't the first, because i already added it in the j==0 if
		
			} // column for
		} // row for
		
		return msg;
	} // decode

	public double getCoverageAmount() {
		return coverageAmount;
	}

	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}
	
} // soat
