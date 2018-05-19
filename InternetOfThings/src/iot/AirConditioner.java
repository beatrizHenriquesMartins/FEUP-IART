package iot;

import nrc.fuzzy.FuzzyVariable;

public class AirConditioner extends FuzzyDevice {

//	private FuzzyValue fuzzyValueTemperature;
//	private double realTemperature;
	
	private double fanSpeed;
	
	
	public AirConditioner(String name, FuzzyVariable fuzzyVariableFanSpeed, String jessVariableName) {
		super(name, "fanSpeed", fuzzyVariableFanSpeed, jessVariableName);
		this.fanSpeed = 0;
	}


	public void setFanSpeed(double newSpeed) {
		this.fanSpeed = newSpeed;
	}


	public double getFanSpeed() {
		return fanSpeed;
	}
	

}
