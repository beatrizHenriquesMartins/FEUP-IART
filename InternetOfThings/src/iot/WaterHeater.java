package iot;

import nrc.fuzzy.FuzzyVariable;

public class WaterHeater extends FuzzyDevice {

	private double waterTemperature;
	
	public WaterHeater(String name, FuzzyVariable fuzzyVariableFanSpeed, String jessVariableName) {
		super(name, "waterTemperature", fuzzyVariableFanSpeed, jessVariableName);
		this.waterTemperature = 0;
	}



	public double getWaterTemperature() {
		return waterTemperature;
	}



	public void setWaterTemperature(double waterTemperature) {
		this.waterTemperature = waterTemperature;
	}



	@Override
	public String toString() {
		return "WaterHeater [name= " + name + ", waterTemperature=" + waterTemperature + "]";
	}
	
}
