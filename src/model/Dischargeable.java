package model;

public interface Dischargeable {
	
	final int normalElectricCharger = 18;
	final int fastElectricCharger = 13;
	final int normalHybridCharger = 7;
	final int fastHybridCharger = 0;
	final int electricDivision = 100;
	final int hybridDivision = 200;
	
	public abstract double discharge();
} // dischargeable
