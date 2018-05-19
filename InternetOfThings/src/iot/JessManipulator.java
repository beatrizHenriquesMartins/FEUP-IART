package iot;

import java.util.ArrayList;
import java.util.Iterator;

import jess.*;
import nrc.fuzzy.jess.FuzzyRete;

public class JessManipulator {

	FuzzyRete rete;
	

	public static void main(String[] args) {

		JessManipulator jess = new JessManipulator();
		
//		System.out.println(jess.getSensorFacts());
		
		@SuppressWarnings("unchecked")
		Iterator<Object> it = jess.rete.listDefinstances();
		while(it.hasNext()) {
			Object obj = it.next();
			if(obj instanceof Sensor) {		
				System.out.println("SENSORRRRRR: " + (Sensor) obj);
			}
			else if(obj instanceof Device) {	
				System.out.println("DEVIIIIIICE: " + (Device) obj);
			}
			else
				System.out.println("NAO");

					
					
		}
	}
	
	public JessManipulator() {
		this.rete = new FuzzyRete();
		initialize();
	}

	private void initialize() {
						
		try {
			rete.eval("(batch res/sensor_temperature.clp)");
			rete.eval("(batch res/device_window.clp)");
			rete.eval("(batch res/device_ac.clp)");	
			rete.eval("(batch res/rules.clp)");
			rete.run();
		} catch (JessException e) {
			System.err.println("Cannot batch jess files.");
			System.exit(1);
		}
	}
	
	public ArrayList<Fact> getSensorFacts() {
		ArrayList<Fact> sensorFacts = new ArrayList<>();
		@SuppressWarnings("unchecked")
		Iterator<Fact> it = rete.listFacts();
		while(it.hasNext()) {
			Fact fact = it.next();
			
			if(fact.getName().contains(("Sensor"))) {
				sensorFacts.add(fact);
			}
		}
		return sensorFacts;
	}
	
}
