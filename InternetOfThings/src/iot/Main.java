package iot;

import jess.*;
import nrc.fuzzy.jess.FuzzyRete;

public class Main {


	public static void main(String[] args) {

		try {
			
			FuzzyRete r = new FuzzyRete();
			
			r.eval("(batch res/rules.clp)");			
			r.run();
			
		} catch (JessException ex) {
			System.err.println(ex);
		}

	}
}
