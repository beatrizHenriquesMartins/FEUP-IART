package iot;

public class SecurityAlarm extends SimpleDevice {
	
	public SecurityAlarm(String name, String jessVariableName) {
		super(name, jessVariableName, "Off", new String[] {"Off", "On"});
	}

}
