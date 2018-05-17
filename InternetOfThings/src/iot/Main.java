package iot;

import java.util.Iterator;

import javax.xml.crypto.dsig.spec.ExcC14NParameterSpec;

import jess.*;

public class Main {

	public static void main(String[] args) {

		try {
			
			Rete r = new Rete();
			
			r.eval("(batch res/rules.clp)");
			System.out.println(r.eval("(facts)"));
			r.eval("(modify ?temperatureSensor1 (value 23))");
			r.run();
			
			System.out.println(r.eval("(facts)"));
			
			
			
		} catch (JessException ex) {
			System.err.println(ex);
		}

	}
}
