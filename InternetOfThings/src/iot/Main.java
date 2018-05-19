package iot;

import jess.*;
import nrc.fuzzy.jess.FuzzyRete;

public class Main {


	public static void main(String[] args) {

		try {
			
			FuzzyRete r = new FuzzyRete();
			r.eval("(import iot.*)");
			r.eval("(batch res/sensor_temperature.clp)");
			r.eval("(batch res/sensor_humidity.clp)");
			r.eval("(batch res/device_window.clp)");
			r.eval("(batch res/device_ac.clp)");	
			r.eval("(batch res/rules.clp)");			
			r.run();
			
						
		} catch (JessException ex) {
			System.err.println(ex);
		}

	}
}
