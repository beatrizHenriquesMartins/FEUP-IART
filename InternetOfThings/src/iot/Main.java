package iot;

import jess.*;

public class Main {

	public static void main(String[] args) {

		try {
			Rete r = new Rete();
			r.eval(" (deffunction square (?n) " + " (return (* ?n ?n)) ) ");
			Value v = r.eval("(square 3)");
			System.out.println(v);
		} catch (JessException ex) {
			System.err.println(ex);
		}

	}

}
