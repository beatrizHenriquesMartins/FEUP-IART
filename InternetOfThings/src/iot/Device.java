package iot;

import java.util.ArrayList;
import java.util.Enumeration;

public abstract class Device {
	String name;
	String jessVariableName;
	
	public Device(String name, String jessVariableName) {
		this.name = name;
		this.jessVariableName = jessVariableName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	
	public String getCode() {
		String code = "";
		for (int i = 0; i < name.length(); i++) {
			code += name.charAt(i) == ' ' ? '_' : name.charAt(i);
		}
		return code;
	}

	public ArrayList<String> getSetNames() {
		ArrayList<String> result = new ArrayList<>();

		if(this instanceof FuzzyDevice) {
			result = ((FuzzyDevice) this).getFuzzySetNames();
		}
		else { // SimpleDevice
			String[] sets = ((SimpleDevice) this).getSimpleSetNames();
			for (int i = 0; i < sets.length; i++) {
				result.add(sets[i]);
			}
		}
		return result;
	}
	
}
