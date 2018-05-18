package iot;

import jess.*;
import nrc.fuzzy.jess.FuzzyRete;

public class Main {

	public static FuzzyRete r;

	public static void main(String[] args) {

		try {
			
			r = new FuzzyRete();
			
			r.eval("(batch res/rules.clp)");
			//System.out.println(r.eval("(facts)"));
			r.eval("(modify ?temperatureSensorLivingRoom (value 23))");
			r.eval("(modify ?clock (hour 15))");
			r.run();
						
			//System.out.println(r.eval("(facts)"));
			
			
			
		} catch (JessException ex) {
			System.err.println(ex);
		}

	}
}
