package iot;

public class Alarm extends SimpleDevice {
	
	public Alarm(String name, String jessVariableName) {
		super(name, jessVariableName, "Off", new String[] {"Off", "Firing"});
	}
	
}
