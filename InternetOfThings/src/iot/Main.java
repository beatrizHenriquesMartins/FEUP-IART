package iot;

import jess.*;

public class Main {

	public static void main(String[] args) {

		try {
			
			Rete r = new Rete();
			
			r.eval("(batch res/rules.clp)");
			System.out.println(r.eval("(facts)"));
			r.eval("(modify ?temperatureSensorLivingRoom (value 23))");
			r.eval("(modify ?clock (hour 15))");
			r.run();
			
			System.out.println(r.eval("(facts)"));
			
			
			
		} catch (JessException ex) {
			System.err.println(ex);
		}

	}
}
