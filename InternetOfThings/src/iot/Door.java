package iot;

public class Door extends SimpleDevice {

	public Door(String name, String jessVariableName) {
		super(name, jessVariableName, "Closed", new String[] {"Open", "Closed"});
	}

	
}
