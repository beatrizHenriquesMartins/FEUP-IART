package iot;

import nrc.fuzzy.FuzzyVariable;

public class Blind extends FuzzyDevice {

	private double percentageClosed;
	
	public Blind(String name, FuzzyVariable fuzzyVariable, String jessVariableName) {
		super(name, "percentageClosed", fuzzyVariable, jessVariableName);
	}

	public double getPercentageClosed() {
		return percentageClosed;
	}

	public void setPercentageClosed(double percentageClosed) {
		this.percentageClosed = percentageClosed;
	}
	
	@Override
	public String toString() {
		return "Blind [name= " + name + ", percentageClosed=" + percentageClosed + "]";
	}

}
