package iot;

import java.util.ArrayList;
import java.util.Enumeration;

import nrc.fuzzy.FuzzyValue;
import nrc.fuzzy.FuzzyVariable;
import nrc.fuzzy.TriangleFuzzySet;
import nrc.fuzzy.XValueOutsideUODException;
import nrc.fuzzy.XValuesOutOfOrderException;

public abstract class Sensor {
		
	String name;
	FuzzyValue fuzzyValue;
	String type;
	String jessVariableName;
	private double realValue;
	private FuzzyVariable fuzzyVariable;
	
	public Sensor(String name, double realValue, FuzzyVariable fuzzyVariable, String type, String jessVariableName) throws XValueOutsideUODException, XValuesOutOfOrderException {
		this.name = name;
		this.type = type;
		this.fuzzyVariable = fuzzyVariable;
		this.jessVariableName = jessVariableName;
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
		return "Sensor [name=" + name + ", realValue: " + realValue + "]";
	}
	
	public String getCode() {
		String code = "";
		for (int i = 0; i < name.length(); i++) {
			code += name.charAt(i) == ' ' ? '_' : name.charAt(i);
		}
		return code;
	}

	public ArrayList<String> getFuzzySetNames() {
		
		ArrayList<String> result = new ArrayList<>();
		
		@SuppressWarnings("unchecked")
		Enumeration<String> it = fuzzyVariable.findTermNames();
		while(it.hasMoreElements()){
			result.add(it.nextElement());
		}
		
		return result;
	}
}
