package iot;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import javax.naming.NameNotFoundException;

import jess.*;
import nrc.fuzzy.XValueOutsideUODException;
import nrc.fuzzy.XValuesOutOfOrderException;
import nrc.fuzzy.jess.FuzzyRete;

public class JessManipulator {

	FuzzyRete rete;
	String rulesFileName = "res/rules.clp";
	

	public static void main(String[] args) throws JessException, XValueOutsideUODException, XValuesOutOfOrderException, FileNotFoundException, NameNotFoundException {

		JessManipulator jess = new JessManipulator();
//		
//		System.out.println(jess.getSensors());
//		System.out.println(jess.getFuzzyDevices());
//
//		//inicio teste F -> F
//		ArrayList<Pair<Sensor,Object>> sensors = new ArrayList<>();
//		ArrayList<Pair<Device,Object>> devices = new ArrayList<>();
//		sensors.add(new Pair<>(jess.getSensorByName("Room 1 Temperature Sensor"), "hot"));
//		sensors.add(new Pair<>(jess.getSensorByName("Inside Humidity Sensor"), "humid"));
//		devices.add(new Pair<>(jess.getFuzzyDeviceByName("Room 1 Air Conditioned"), "high"));
//		jess.createNewVersatileRule("testFuzzyRule", sensors, devices);
//		
//		jess.updateSensor(jess.getSensorByName("Inside Humidity Sensor"), 80);
//		jess.updateSensor(jess.getSensorByName("Room 1 Temperature Sensor"), 28.9);
//
//		System.out.println(jess.getDeviceByName("Room 1 Air Conditioned"));
//		
//		//fim teste F -> F
//		
//		
//		//Inicio teste N -> F
//		ArrayList<Pair<Sensor,Object>> sensors2 = new ArrayList<>();
//		ArrayList<Pair<Device,Object>> devices2 = new ArrayList<>();
//		sensors2.add(new Pair<>(jess.getSensorByName("Room 1 Temperature Sensor"), new Pair<>(15.0,"<")));
//		sensors2.add(new Pair<>(jess.getSensorByName("Inside Humidity Sensor"), new Pair<>(50.0,">=")));
//		devices2.add(new Pair<>(jess.getFuzzyDeviceByName("Room 1 Air Conditioned"), "low"));
//		devices2.add(new Pair<>(jess.getFuzzyDeviceByName("Room 2 Air Conditioned"), "low"));
//		jess.createNewVersatileRule("testSimpleRule", sensors2, devices2);
//		
//		jess.updateSensor(jess.getSensorByName("Room 1 Temperature Sensor"), 1.9);
//		jess.updateSensor(jess.getSensorByName("Inside Humidity Sensor"), 80);
//		
//		System.out.println(jess.getDeviceByName("Room 1 Air Conditioned"));
//		System.out.println(jess.getDeviceByName("Room 2 Air Conditioned"));
//		//Fim teste N -> F
//
//
//
//		//inicio teste NF -> F
//		ArrayList<Pair<Sensor,Object>> sensors3 = new ArrayList<>();
//		ArrayList<Pair<Device,Object>> devices3 = new ArrayList<>();
//		sensors3.add(new Pair<>(jess.getSensorByName("Room 1 Temperature Sensor"), new Pair<>(32.0,">=")));
//		sensors3.add(new Pair<>(jess.getSensorByName("Inside Humidity Sensor"), "humid"));
//		devices3.add(new Pair<>(jess.getFuzzyDeviceByName("Room 1 Air Conditioned"), "low"));
//		devices3.add(new Pair<>(jess.getFuzzyDeviceByName("Room 2 Air Conditioned"), "high"));
//		jess.createNewVersatileRule("testSimpleRuleNFNF", sensors3, devices3);
//		
//		jess.updateSensor(jess.getSensorByName("Room 1 Temperature Sensor"),35.0);
//		jess.updateSensor(jess.getSensorByName("Inside Humidity Sensor"),81.0);
//		
//		System.out.println(jess.getDeviceByName("Room 1 Air Conditioned"));
//		System.out.println(jess.getDeviceByName("Room 2 Air Conditioned"));
//		//fim teste NF -> F
//		
//		
//		
//		
//		//inicio teste F -> N	
//		ArrayList<Pair<Sensor,Object>> sensors4 = new ArrayList<>();
//		ArrayList<Pair<Device,Object>> devices4 = new ArrayList<>();
//		sensors4.add(new Pair<>(jess.getSensorByName("Room 1 Temperature Sensor"), "cold"));
//		sensors4.add(new Pair<>(jess.getSensorByName("Inside Humidity Sensor"), "humid"));
//		devices4.add(new Pair<>(jess.getDeviceByName("Room 1 Air Conditioned"), 995.0));
//		devices4.add(new Pair<>(jess.getDeviceByName("Living Room Window 2"), "Open"));
//		jess.createNewVersatileRule("testSimpleRuleF-N", sensors4, devices4);
//		
//		jess.updateSensor(jess.getSensorByName("Room 1 Temperature Sensor"), 15.0);
//		jess.updateSensor(jess.getSensorByName("Inside Humidity Sensor"), 70.1);
//		
//		System.out.println(jess.getDeviceByName("Room 1 Air Conditioned"));
//		System.out.println(jess.getDeviceByName("Living Room Window 2"));
//		//fim teste F -> N
//		
//		
//		
//		
//		//inicio teste N -> N		
//		ArrayList<Pair<Sensor,Object>> sensors5 = new ArrayList<>();
//		ArrayList<Pair<Device,Object>> devices5 = new ArrayList<>();
//		sensors5.add(new Pair<>(jess.getSensorByName("Garden PH Sensor"), new Pair<>(3.0,"<")));
//		sensors5.add(new Pair<>(jess.getSensorByName("Outside Humidity Sensor"), new Pair<>(85.0,">=")));
//		sensors5.add(new Pair<>(jess.getSensorByName("Garden Temperature Sensor"), new Pair<>(30.0,">")));
//		devices5.add(new Pair<>(jess.getFuzzyDeviceByName("Garden Irrigation System"), 90.0));
//		jess.createNewVersatileRule("testFuzzyRulePh", sensors5, devices5);
//		
//		jess.updateSensor(jess.getSensorByName("Garden PH Sensor"),2.3);
//		jess.updateSensor(jess.getSensorByName("Outside Humidity Sensor"),85.1);
//		jess.updateSensor(jess.getSensorByName("Garden Temperature Sensor"),30.1);
//
//		System.out.println(jess.getDeviceByName("Garden Irrigation System"));
//		//fim teste N -> N
//		
//
//		//inicio teste NF -> N
//		ArrayList<Pair<Sensor,Object>> sensors6 = new ArrayList<>();
//		ArrayList<Pair<Device,Object>> devices6 = new ArrayList<>();
//		sensors6.add(new Pair<>(jess.getSensorByName("Garden PH Sensor"), "very_acid"));
//		sensors6.add(new Pair<>(jess.getSensorByName("Outside Humidity Sensor"), "humid"));
//		sensors6.add(new Pair<>(jess.getSensorByName("Garden Temperature Sensor"), new Pair<>(30.0,">")));
//		devices6.add(new Pair<>(jess.getFuzzyDeviceByName("Garden Irrigation System"), "slightly high"));
//		devices6.add(new Pair<>(jess.getFuzzyDeviceByName("Living Room Air Conditioned"), "very high"));
//
//		jess.createNewVersatileRule("testFuzzyRulePh", sensors6, devices6);
//		
//		jess.updateSensor(jess.getSensorByName("Garden PH Sensor"),3.1);
//		jess.updateSensor(jess.getSensorByName("Outside Humidity Sensor"),100.0);
//		jess.updateSensor(jess.getSensorByName("Garden Temperature Sensor"),30.1);
//
//		System.out.println(jess.getDeviceByName("Garden Irrigation System"));
//		System.out.println(jess.getDeviceByName("Living Room Air Conditioned"));
//		//fim teste NF -> N
//		
//		
//		//inicio teste F -> NF	
//		ArrayList<Pair<Sensor,Object>> sensors7 = new ArrayList<>();
//		ArrayList<Pair<Device,Object>> devices7 = new ArrayList<>();
//		sensors7.add(new Pair<>(jess.getSensorByName("Room 1 Temperature Sensor"), "hot"));
//		sensors7.add(new Pair<>(jess.getSensorByName("Inside Humidity Sensor"), "humid"));
//		devices7.add(new Pair<>(jess.getDeviceByName("Room 1 Air Conditioned"), "low"));
//		devices7.add(new Pair<>(jess.getDeviceByName("Living Room Window 2"), "Open"));
//		jess.createNewVersatileRule("testSimpleRuleF-N", sensors7, devices7);
//		
//		jess.updateSensor(jess.getSensorByName("Room 1 Temperature Sensor"), 25.0);
//		jess.updateSensor(jess.getSensorByName("Inside Humidity Sensor"), 70.1);
//		
//		System.out.println(jess.getDeviceByName("Room 1 Air Conditioned"));
//		System.out.println(jess.getDeviceByName("Living Room Window 2"));
//		//fim teste F -> NF
//		
//		
//		//inicio teste N -> NF
//		ArrayList<Pair<Sensor,Object>> sensors7 = new ArrayList<>();
//		ArrayList<Pair<Device,Object>> devices7 = new ArrayList<>();
//		sensors7.add(new Pair<>(jess.getSensorByName("Garden PH Sensor"), new Pair<>(3.0,"<")));
//		sensors7.add(new Pair<>(jess.getSensorByName("Outside Humidity Sensor"), new Pair<>(85.0,">=")));
//		sensors7.add(new Pair<>(jess.getSensorByName("Garden Temperature Sensor"), new Pair<>(30.0,">")));
//		devices7.add(new Pair<>(jess.getDeviceByName("Room 1 Air Conditioned"), 850.0));
//		devices7.add(new Pair<>(jess.getDeviceByName("Garden Irrigation System"), "high"));
//		jess.createNewVersatileRule("testSimpleRuleF-N", sensors7, devices7);
//		
//		jess.updateSensor(jess.getSensorByName("Garden PH Sensor"), 2.0);
//		jess.updateSensor(jess.getSensorByName("Outside Humidity Sensor"), 90.1);
//		jess.updateSensor(jess.getSensorByName("Garden Temperature Sensor"), 36.1);
//		
//		System.out.println(jess.getDeviceByName("Room 1 Air Conditioned"));
//		System.out.println(jess.getDeviceByName("Garden Irrigation System"));	
//		//fim teste N -> NF
//		
//		
//		
//		
//		//inicio teste NF -> NF
//		ArrayList<Pair<Sensor,Object>> sensors7 = new ArrayList<>();
//		ArrayList<Pair<Device,Object>> devices7 = new ArrayList<>();
//		sensors7.add(new Pair<>(jess.getSensorByName("Garden PH Sensor"), new Pair<>(3.0,"<")));
//		sensors7.add(new Pair<>(jess.getSensorByName("Outside Humidity Sensor"), new Pair<>(85.0,">=")));
//		sensors7.add(new Pair<>(jess.getSensorByName("Garden Temperature Sensor"), "hot"));
//		devices7.add(new Pair<>(jess.getDeviceByName("Room 1 Air Conditioned"), 850.0));
//		devices7.add(new Pair<>(jess.getDeviceByName("Garden Irrigation System"), "high"));
//		jess.createNewVersatileRule("testSimpleRuleF-N", sensors7, devices7);
//		
//		jess.updateSensor(jess.getSensorByName("Garden PH Sensor"), 2.9);
//		jess.updateSensor(jess.getSensorByName("Outside Humidity Sensor"), 90.1);
//		jess.updateSensor(jess.getSensorByName("Garden Temperature Sensor"), 20.1);
//		
//		System.out.println(jess.getDeviceByName("Room 1 Air Conditioned"));
//		System.out.println(jess.getDeviceByName("Garden Irrigation System"));	
//		//fim teste NF -> NF	
		
//		ArrayList<Pair<Sensor,Object>> sensors8 = new ArrayList<>();
//		ArrayList<Pair<Device,Object>> devices8 = new ArrayList<>();
//		sensors8.add(new Pair<>(jess.getSensorByName("Room 1 Light Sensor"), "high"));
////		sensors8.add(new Pair<>(jess.getSensorByName("Garden Movement Sensor"), new Pair<Double,String>(1.0,"==")));
//		devices8.add(new Pair<>(jess.getDeviceByName("Living Room Window 1 Blind"), "high"));
//		jess.createNewVersatileRule("testSimpleRuleF-N", sensors8, devices8);
//		
//		jess.updateSensor(jess.getSensorByName("Room 1 Light Sensor"), 6201.0);
//		
//		System.out.println(jess.getDeviceByName("Living Room Window 1 Blind"));	
//		System.out.println(jess.getSensorByName("Room 1 Light Sensor"));	
		
		ArrayList<Pair<Sensor,Object>> sensors9 = new ArrayList<>();
		ArrayList<Pair<Device,Object>> devices9 = new ArrayList<>();
		sensors9.add(new Pair<>(jess.getSensorByName("Living Room Temperature Sensor"), "cold"));
		sensors9.add(new Pair<>(jess.getSensorByName("Garden Movement Sensor"), new Pair<Double,String>(1.0,"==")));
		devices9.add(new Pair<>(jess.getDeviceByName("Living Room Heater 1"), "high"));
		jess.createNewVersatileRule("testSimpleRuleF-N", sensors9, devices9);
		
		jess.updateSensor(jess.getSensorByName("Living Room Temperature Sensor"), 15.0);
		
		System.out.println(jess.getDeviceByName("Living Room Heater 1"));	
		System.out.println(jess.getSensorByName("Living Room Temperature Sensor"));	
		
//		jess.getRules();
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
			
			File dir = new File("res/sensores_devices");
			File[] sensorsAndDevicesDefinitions = dir.listFiles();
			
			if(sensorsAndDevicesDefinitions != null) {
				
				for(File file : sensorsAndDevicesDefinitions) {
					
					String path = file.getPath();
					rete.eval("(batch "+ path +")");
				}
				
			}

			rete.eval("(batch " + rulesFileName + ")");			
			rete.run();
		
		} catch (JessException e) {
			e.printStackTrace();
			System.exit(1);
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
		
		Collections.sort(sensors, new SensorComparator());
		
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
		Collections.sort(devices, new DeviceComparator());
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
	
	public void getRules() {
		@SuppressWarnings("unchecked")
		Iterator<Object> it = rete.listDefrules();
		while(it.hasNext()) {
			
			Defrule rule = (Defrule) it.next();
			if(rule.getName().indexOf("MAIN::defuzzify") != 0) {
				
				System.out.println(rule);
				System.out.println(rule.getConditionalElements().getConditionalElement(0).isGroup());
				System.out.println(rule.getAction(0));
				System.out.println(rule.getDocstring());
			}
		}
	}
	
	public void createNewVersatileRule(String ruleName, ArrayList<Pair<Sensor,Object>> sensors, ArrayList<Pair<Device,Object>> devices) throws JessException, FileNotFoundException, NameNotFoundException {
		
		ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();
		PrintWriter out = new PrintWriter(outBuffer);
		
		out.println("(defrule " + ruleName + "\n");
		
		
		out.println("\t\"" + addRuleDescription(ruleName, sensors, devices) + "\"\n");
		for (int i = 0; i < sensors.size(); i++) {
			
			Sensor sensor = sensors.get(i).left;
			
			out.print("\t(" + sensor.type + " ");
			
			if(sensors.get(i).right instanceof String) {
				
				String value = (String) sensors.get(i).right;
				
				out.print("(name \"" + sensor.getName() + "\") ");
				out.println("(fuzzyValue ?v" + i + "&:(fuzzy-match ?v" + i + " \"" + value + "\")))");
				
			}
			
			else {
				
				@SuppressWarnings("unchecked")
				Pair<Double,String> pair = (Pair<Double,String>) sensors.get(i).right;
				Double value = pair.left;
				Operator operator = Operator.type(pair.right);
				out.println("{name == \"" + sensor.getName() + "\" && realValue  " + operator.token + " " + value + "})");
				
			}
				
		}
		
		out.println("\n\t=>\n");
		
		for (int i = 0; i < devices.size(); i++) {
			Device device = devices.get(i).left;
			Object value = devices.get(i).right;
			
			//simple device only state needed
			if(device instanceof SimpleDevice)
				out.println("\t(?" + device.jessVariableName + " setState \"" + value + "\")");
			
			//complex device, fuzzy set or real value
			else {
				
				FuzzyDevice fuzzyDevice = (FuzzyDevice) device;
				
				//crisp value
				if(value instanceof Double) {
					
					String deviceVariableMethod = "set" + fuzzyDevice.fuzzyVariableName.substring(0,1).toUpperCase() + fuzzyDevice.fuzzyVariableName.substring(1);
					out.println("\t(?" + device.jessVariableName + " " + deviceVariableMethod + " " + value + ")");
					
				}
				
				//fuzzy value
				else 
					out.println("\t(assert (" + device.getCode() + " (new FuzzyValue ?*" + fuzzyDevice.fuzzyVariableName + "* \"" + value + "\")))");
					
			}
				
		}
		
		out.println(")");	
		
		out.close();
		String newRule = outBuffer.toString();
		rete.eval(newRule);
		rete.run();
		
		saveRuleToFile(newRule);
		
	}
	
	private String addRuleDescription(String ruleName, ArrayList<Pair<Sensor, Object>> sensors,
			ArrayList<Pair<Device, Object>> devices) throws NameNotFoundException {
		
		ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();
		PrintWriter out = new PrintWriter(outBuffer);
		
		out.print(ruleName + ": If ");
		
		for (int i = 0; i < sensors.size(); i++) {
			Sensor sensor = sensors.get(i).left;
			Object condition = sensors.get(i).right;
			
			out.print(sensor.getName() + " ");
			
			if(condition instanceof Pair) {
				@SuppressWarnings("unchecked")
				Pair<Double,String> pair = (Pair<Double,String>) sensors.get(i).right;
				Double value = pair.left;
				Operator operator = Operator.type(pair.right);
				
				out.print("is " + operator.text + value + " ");
				
			}else 
			if(condition instanceof String) {
				out.print("is " + condition + " ");
			}
			
			if(i != sensors.size() -1) {
				out.print("and ");
			}	
		}
		
		out.print("then ");
		for (int i = 0; i < devices.size(); i++) {
			Device device = devices.get(i).left;
			
			out.print(device.getName() + " is set to ");
			out.print(devices.get(i).right);
			
			if(i != devices.size() -1) {
				out.print(" and");
			}
		}
		
		out.close();
		return outBuffer.toString();
	}

	public void createNewRuleFF(String ruleName, ArrayList<Pair<Sensor,String>> sensors, ArrayList<Pair<FuzzyDevice,String>> devices) throws JessException, FileNotFoundException {
		
		ByteArrayOutputStream outBuffer = new ByteArrayOutputStream();
		PrintWriter out = new PrintWriter(outBuffer);
		
		out.println("(defrule " + ruleName + "\n");
		
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
			
			out.println("\t(assert (" + device.getCode() + " (new FuzzyValue ?*" + device.fuzzyVariableName + "* \"" + value + "\")))");
		}
		
		out.println(")");
		
		out.close();
		String newRule = outBuffer.toString();
		
		rete.eval(newRule);
		rete.run();
		
		saveRuleToFile(newRule);
		
		
	}
	
	public void updateSensor(Sensor sensor, double newValue) throws XValueOutsideUODException, XValuesOutOfOrderException, JessException {
		
		sensor.setRealValue(newValue);
		rete.updateObject(sensor);
		rete.run();
		
	}
	
	private static class Pair<T, V> {
		
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
	
	private void saveRuleToFile(String rule) throws FileNotFoundException {
		
		PrintWriter pw = new PrintWriter(new FileOutputStream(new File(rulesFileName), true));
		pw.println(rule);
		pw.close();
		
	}

	private static enum Operator {
		
		GREATER(">", "greater than "),
		GREATER_EQUAL(">=", "greater than or equal to"),
		LESS("<", "less than "),
		LESS_EQUAL( "<=", "less than or equal to"),
		EQUALS("==", "equal to "),
		DIFFERENT("!=", "different of ");
		
		static final ArrayList<String> types = new ArrayList<String>(Arrays.asList(">",">=","<","<=","==","!="));
		
		public String token;
		public String text;
		
		Operator(String token, String text) {
			this.token = token;
			this.text = text;
		}
		
		static Operator type(String text) throws NameNotFoundException {
			
			switch(types.indexOf(text)) {
			
				case 0:
					return Operator.GREATER;
				case 1:
					return Operator.GREATER_EQUAL;
				case 2:
					return Operator.LESS;
				case 3:
					return Operator.LESS_EQUAL;
				case 4:
					return Operator.EQUALS;
				case 5:
					return Operator.DIFFERENT;
				default:
					throw new NameNotFoundException("Invalid Operator Name");
			
			}
					
		}
				
	}
	
	public class DeviceComparator implements Comparator<Device> {

		@Override
		public int compare(Device o1, Device o2) {
						
			return o1.getName().compareTo(o2.getName());
		}
		
	}
	
	public class SensorComparator implements Comparator<Sensor> {

		@Override
		public int compare(Sensor o1, Sensor o2) {
						
			return o1.getName().compareTo(o2.getName());
		}
		
	}
	
	
	
}

