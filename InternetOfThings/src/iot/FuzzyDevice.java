package iot;

import java.util.ArrayList;
import java.util.Enumeration;

import nrc.fuzzy.FuzzyVariable;

public abstract class FuzzyDevice extends Device {
	FuzzyVariable fuzzyVariable;
	String fuzzyVariableName;


	public FuzzyDevice(String name, String fuzzyVariableName, FuzzyVariable fuzzyVariableFanSpeed, String jessVariableName) {
		super(name, jessVariableName);
		this.fuzzyVariableName = fuzzyVariableName;
		this.fuzzyVariable = fuzzyVariableFanSpeed;
	}


	public FuzzyVariable getFuzzyVariable() {
		return fuzzyVariable;
	}


	public String getFuzzyVariableName() {
		return fuzzyVariableName;
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
