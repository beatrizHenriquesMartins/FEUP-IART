package iot;

public abstract class SimpleDevice extends Device {
	
	String state;
	String[] possibleStates;

	public SimpleDevice(String name, String jessVariableName, String state, String[] possibleStates) {
		super(name, jessVariableName);
		this.state = state;
		this.possibleStates = possibleStates;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		//TODO: states possibles
		this.state = state;
	}

	@Override
	public String toString() {
		return "SimpleDevice [name=" + name + "state=" + state + "]";
	}

	

}
