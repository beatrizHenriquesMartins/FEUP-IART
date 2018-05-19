package iot;

import nrc.fuzzy.FuzzyVariable;
import nrc.fuzzy.XValueOutsideUODException;
import nrc.fuzzy.XValuesOutOfOrderException;

public class TemperatureSensor extends Sensor {

	public TemperatureSensor(String name, double realValue, FuzzyVariable fuzzyVariable)
			throws XValueOutsideUODException, XValuesOutOfOrderException {
		super(name, realValue, fuzzyVariable);
		
	}

}
