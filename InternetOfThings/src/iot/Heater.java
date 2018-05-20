package iot;

import nrc.fuzzy.FuzzyVariable;

public class Heater extends FuzzyDevice {

	private double heaterTemperature;
	
	
	public Heater(String name, FuzzyVariable fuzzyVariableFanSpeed, String jessVariableName) {
		super(name, "heaterTemperature", fuzzyVariableFanSpeed, jessVariableName);
		this.heaterTemperature = 0;
	}

	
	public double getHeaterTemperature() {
		return heaterTemperature;
	}


	public void setHeaterTemperature(double heaterTemperature) {
		this.heaterTemperature = heaterTemperature;
	}


	@Override
	public String toString() {
		return "Heater [name= " + name + ", temperature=" + heaterTemperature + "]";
	}
	
}
