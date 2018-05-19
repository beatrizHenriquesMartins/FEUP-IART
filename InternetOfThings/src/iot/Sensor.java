package iot;

import nrc.fuzzy.FuzzyValue;
import nrc.fuzzy.FuzzyVariable;
import nrc.fuzzy.TriangleFuzzySet;
import nrc.fuzzy.XValueOutsideUODException;
import nrc.fuzzy.XValuesOutOfOrderException;

public class Sensor {
		
	String name;
	FuzzyValue fuzzyValue;
	private double realValue;
	private FuzzyVariable fuzzyVariable;
	
	public Sensor(String name, double realValue, FuzzyVariable fuzzyVariable) throws XValueOutsideUODException, XValuesOutOfOrderException {
		this.name = name;
		
		this.fuzzyVariable = fuzzyVariable;
		setRealValue(realValue);
	}
	public String getName() { return name; }
	public void setName(String s) { name = s; }
	
	public void setRealValue(double newRealValue) throws XValueOutsideUODException, XValuesOutOfOrderException {
		this.realValue = newRealValue;
		this.fuzzyValue = new FuzzyValue(fuzzyVariable, new TriangleFuzzySet(realValue,realValue,realValue));
		
	}
	public double getRealValue() {
		return realValue;
	}
	public FuzzyVariable getFuzzyVariable() {
		return fuzzyVariable;
	}
	public FuzzyValue getFuzzyValue() {
		return fuzzyValue;
	}
	
	@Override
	public String toString() {
		return "Sensor [name=" + name + "]";
	}
	

}
