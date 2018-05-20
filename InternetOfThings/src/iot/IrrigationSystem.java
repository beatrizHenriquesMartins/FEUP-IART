package iot;

import nrc.fuzzy.FuzzyVariable;

public class IrrigationSystem extends FuzzyDevice {
	
	private double irrigationSystemPower;

	public IrrigationSystem(String name, FuzzyVariable fuzzyVariableFanSpeed,
			String jessVariableName) {
		super(name, "irrigationSystemPower", fuzzyVariableFanSpeed, jessVariableName);
		
	}


	
	public double getIrrigationSystemPower() {
		return irrigationSystemPower;
	}



	public void setIrrigationSystemPower(double irrigationSystemPower) {
		this.irrigationSystemPower = irrigationSystemPower;
	}



	@Override
	public String toString() {
		return "IrrigationSystem [name= " + name + ", power=" + irrigationSystemPower + "]";
	}

}
