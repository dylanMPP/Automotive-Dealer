package model;

import java.util.Random;

public class Document implements Decodable{
	
	private String id;
	private double price;
	private int year;
	private String image;
	
	public Document(String id, double price, int year) {
		this.id = id;
		this.price = price;
		this.year = year;
		this.image = decode();
	} // doc constructor
	
	/**
	 * <pre>
	 * <strong> Method Description. </strong> This method decode the code of the property document according to its matrix.
     * 
	 * <strong> Pre </strong> Select create doc
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
				
				if (i+j != 0) {
					if ( (i+j)%2 == 0) {
						msg += imageMatrix[i][j];
					} // if even
				} // if with the propose of not taking the 0,0 value
			} // column for
		} // row for
		
		return msg;
	} // decode

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	@Override
	public String toString() {
		
		return "\n\n| DOCUMENT | \nId:" + id + "\nPrice:" + price + "\nYear:" + year + "\nImage:" + image;
	}
	
	
	
} // document
