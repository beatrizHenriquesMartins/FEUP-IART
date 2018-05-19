package iot;

public class Window extends SimpleDevice {
	public Window(String name, String jessVariableName) {
		super(name, jessVariableName, "Closed", new String[] {"Open", "Closed"});
	}
}
