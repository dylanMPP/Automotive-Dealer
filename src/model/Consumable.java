package model;

public interface Consumable {
	
	final double gasolineCarValue = 150;
	final double hybridCarValue = 180;
	final double motorcycleValue = 75;
	
	public abstract double calculateGasolineConsume();
} // consumable
