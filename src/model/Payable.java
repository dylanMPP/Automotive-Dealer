package model;

public interface Payable {
	
	final double electricCarAddition = 0.2;
	final double hybridCarAddition = 0.15;
	final double motorcycleAddition = 0.04;
	final double docAddition = 500000;
	final double usedCarDiscount = 0.1;
	final double usedMotorcycleDiscount = 0.02;
	
	public abstract double calculateTotalPrice();
} // payable
