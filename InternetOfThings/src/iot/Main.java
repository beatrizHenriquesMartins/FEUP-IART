package iot;

import jess.*;

public class Main {

	public static void main(String[] args) {

		try {
			
			Rete r = new Rete();
			r.eval("(batch res/rules.clp)");
			
			r.eval("(assert (chuva))");
			r.eval("(run)");
			
			System.out.println(r.eval("(facts)"));
			
			r.eval("(assert (sol))"); 
			r.eval("(run)");
			
			System.out.println(r.eval("(facts)"));
			
			
			
		} catch (JessException ex) {
			System.err.println(ex);
		}

	}

}
