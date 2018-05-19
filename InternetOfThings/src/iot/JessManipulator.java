package iot;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import jess.*;
import nrc.fuzzy.XValueOutsideUODException;
import nrc.fuzzy.XValuesOutOfOrderException;
import nrc.fuzzy.jess.FuzzyRete;

public class JessManipulator {

	FuzzyRete rete;
	String rulesFileName = "res/rules.clp";
	

	public static void main(String[] args) throws JessException, XValueOutsideUODException, XValuesOutOfOrderException {

		JessManipulator jess = new JessManipulator();
		
//		System.out.println(jess.getSensors());
//		System.out.println(jess.getFuzzyDevices());
		
//		ArrayList<Pair<Sensor,String>> sensors = new ArrayList<>();
//		ArrayList<Pair<FuzzyDevice,String>> devices = new ArrayList<>();
//		sensors.add(new Pair<>(jess.getSensorByName("Room 1 Temperature Sensor"), "hot"));
//		sensors.add(new Pair<>(jess.getSensorByName("Inside Humidity Sensor"), "humid"));
//		devices.add(new Pair<>(jess.getFuzzyDeviceByName("Room 1 Air Conditioned"), "high"));
//		jess.createNewFuzzyRule("testFuzzyRule", sensors, devices);
		
		System.out.println(jess.getDeviceByName("Living Room Window 1"));
		ArrayList<Pair<Sensor,String>> sensors2 = new ArrayList<>();
		ArrayList<Pair<Device,String>> devices2 = new ArrayList<>();
		sensors2.add(new Pair<>(jess.getSensorByName("Room 1 Temperature Sensor"), "hot"));
		sensors2.add(new Pair<>(jess.getSensorByName("Inside Humidity Sensor"), "humid"));
		devices2.add(new Pair<>(jess.getDeviceByName("Living Room Window 1"), "Open"));
		jess.createNewRule("testSimpleRule", sensors2, devices2);
		System.out.println(jess.getDeviceByName("Living Room Window 1"));

		jess.updateSensor(jess.getSensorByName("Inside Humidity Sensor"), 100);
		jess.updateSensor(jess.getSensorByName("Room 1 Temperature Sensor"), 24.9);
//		jess.updateSensor(jess.getSensorByName("Room 1 Temperature Sensor"), 14.9);
		jess.updateSensor(jess.getSensorByName("Room 1 Temperature Sensor"), 27.9);
		System.out.println(jess.getDeviceByName("Living Room Window 1"));

//		System.out.println(jess.getSensors().get(0).getFuzzySetNames());
//		System.out.println(jess.getFuzzyDevices().get(0).getFuzzySetNames());
			
	}
	
	public JessManipulator() {
		this.rete = new FuzzyRete();
		init();
	}

	private void init() {
						
		try {			
			rete.eval("(import iot.*)");
			rete.eval("(load-package nrc.fuzzy.jess.FuzzyFunctions)");
			rete.eval("(import nrc.fuzzy.*)");

			rete.eval("(batch res/sensor_temperature.clp)");
			rete.eval("(batch res/sensor_humidity.clp)");
			rete.eval("(batch res/device_window.clp)");
			rete.eval("(batch res/device_ac.clp)");	
//			rete.eval("(batch " + rulesFileName + ")");			
			rete.run();
		} catch (JessException e) {
//			System.err.println("Cannot batch jess files.");
//			System.exit(1);
			e.printStackTrace();
		}
	}
	
	public ArrayList<Sensor> getSensors() {
		ArrayList<Sensor> sensors = new ArrayList<>();
		
		@SuppressWarnings("unchecked")
		Iterator<Object> it = rete.listDefinstances();
		while(it.hasNext()) {
			
			Object obj = it.next();
			if(obj instanceof Sensor) {		
				sensors.add((Sensor) obj);
			}		
			
		}
		return sensors;
	}
	
	public Sensor getSensorByName(String name) {
		ArrayList<Sensor> sensors = getSensors();
		for (int i = 0; i < sensors.size(); i++) {
			if(sensors.get(i).getName().equals(name)){
				return sensors.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<Device> getDevices() {
		ArrayList<Device> devices = new ArrayList<>();
		
		@SuppressWarnings("unchecked")
		Iterator<Object> it = rete.listDefinstances();
		while(it.hasNext()) {
			
			Object obj = it.next();
			if(obj instanceof Device) {		
				devices.add((Device) obj);
			}		
			
		}
		return devices;
	}
	
	public FuzzyDevice getFuzzyDeviceByName(String name) {
		ArrayList<FuzzyDevice> devices = getFuzzyDevices();
		for (int i = 0; i < devices.size(); i++) {
			if(devices.get(i).getName().equals(name)){
				return devices.get(i);
			}
		}
		return null;
	}
	
	public Device getDeviceByName(String name) {
		ArrayList<Device> devices = getDevices();
		for (int i = 0; i < devices.size(); i++) {
			if(devices.get(i).getName().equals(name)){
				return devices.get(i);
			}
		}
		return null;
	}
	
	public ArrayList<FuzzyDevice> getFuzzyDevices() {
		ArrayList<FuzzyDevice> devices = new ArrayList<>();
		
		@SuppressWarnings("unchecked")
		Iterator<Object> it = rete.listDefinstances();
		while(it.hasNext()) {
			
			Object obj = it.next();
			if(obj instanceof FuzzyDevice) {		
				devices.add((FuzzyDevice) obj);
			}		
			
		}
		return devices;
	}
	
	public void createNewRule(String ruleName, ArrayList<Pair<Sensor,String>> sensors, ArrayList<Pair<Device,String>> devices) throws JessException {
		
		ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();
		PrintWriter out = new PrintWriter(outBuffer);
		
		out.println("(defrule " + ruleName);
		
		for (int i = 0; i < sensors.size(); i++) {
			Sensor sensor = sensors.get(i).left;
			String value = sensors.get(i).right;
			
			out.print("\t(" + sensor.type + " ");
			out.print("(name \"" + sensor.getName() + "\") ");
			out.println("(fuzzyValue ?v" + i + "&:(fuzzy-match ?v" + i + " \"" + value + "\")))");
		}
		
		out.println("\n\t=>\n");
		
		
		for (int i = 0; i < devices.size(); i++) {
			Device device = devices.get(i).left;
			String value = devices.get(i).right;		
			
			out.println("(?" + device.jessVariableName + " setState \"" + value + "\"))");
		}
		out.close();
//		System.out.println(outBuffer.toString());
		rete.eval(outBuffer.toString());
		rete.run();
	}
		
	public void createNewFuzzyRule(String ruleName, ArrayList<Pair<Sensor,String>> sensors, ArrayList<Pair<FuzzyDevice,String>> devices) throws JessException {
		
		ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();
		PrintWriter out = new PrintWriter(outBuffer);
		
		out.println("(defrule " + ruleName);
		
		for (int i = 0; i < sensors.size(); i++) {
			Sensor sensor = sensors.get(i).left;
			String value = sensors.get(i).right;
			
			out.print("\t(" + sensor.type + " ");
			out.print("(name \"" + sensor.getName() + "\") ");
			out.println("(fuzzyValue ?v" + i + "&:(fuzzy-match ?v" + i + " \"" + value + "\")))");
		}
		
		out.println("\n\t=>\n");
		
		for (int i = 0; i < devices.size(); i++) {
			FuzzyDevice device = devices.get(i).left;
			String value = devices.get(i).right;
			
			out.println("\t(assert (" + device.getCode() + " (new FuzzyValue ?*" + device.fuzzyVariableName + "* \"" + value + "\"))))");
		}
		out.close();
//		System.out.println(outBuffer.toString());
		rete.eval(outBuffer.toString());
		rete.run();
	}
	
	
	void updateSensor(Sensor sensor, double newValue) throws XValueOutsideUODException, XValuesOutOfOrderException, JessException {
		
		sensor.setRealValue(newValue);
		rete.updateObject(sensor);
		rete.run();
		
	}
	
	
	static class Pair<T, V> {
		public T left;
		public V right;
		public Pair(T left, V right) {
			this.left = left;
			this.right = right;
		}
		@Override
		public String toString() {
			return "(" + left + ", " + right + ")";
		}
		
		
	}
}

