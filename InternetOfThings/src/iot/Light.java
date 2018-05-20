package iot;

public class Light extends SimpleDevice {

	public Light(String name, String jessVariableName) {
		super(name, jessVariableName, "Off", new String[] {"Off", "On"});
	}

}
