package iot;

import nrc.fuzzy.FuzzyValue;
import nrc.fuzzy.FuzzyVariable;
import nrc.fuzzy.InvalidDefuzzifyException;
import nrc.fuzzy.InvalidLinguisticExpressionException;
import nrc.fuzzy.XValuesOutOfOrderException;

public class AirConditioner extends Device {

//	private FuzzyValue fuzzyValueTemperature;
//	private double realTemperature;
	
	private double fanSpeed;
	FuzzyVariable fuzzyVariableFanSpeed;
	
	public AirConditioner(String name, FuzzyVariable fuzzyVariableFanSpeed) {
		super(name);
		this.fanSpeed = 0;
		this.fuzzyVariableFanSpeed = fuzzyVariableFanSpeed;
	}


	public void setFanSpeed(String linguisticExpression) throws InvalidDefuzzifyException, XValuesOutOfOrderException, InvalidLinguisticExpressionException {
		

		this.fanSpeed = new FuzzyValue(fuzzyVariableFanSpeed, linguisticExpression).centerOfAreaDefuzzify();
		
	}


	public double getFanSpeed() {
		return fanSpeed;
	}
	
	

}
