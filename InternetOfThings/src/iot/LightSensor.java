package iot;

import nrc.fuzzy.FuzzyVariable;
import nrc.fuzzy.XValueOutsideUODException;
import nrc.fuzzy.XValuesOutOfOrderException;

public class LightSensor extends Sensor {

	public LightSensor(String name, double realValue, FuzzyVariable fuzzyVariable, String jessVariableName)
			throws XValueOutsideUODException, XValuesOutOfOrderException {
		super(name, realValue, fuzzyVariable, "LightSensor", jessVariableName);
	}

}
