package iot;

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

	@Override
	public String toString() {
		return "Device [name=" + name + "]";
	}
	
	public String getCode() {
		String code = "";
		for (int i = 0; i < name.length(); i++) {
			code += name.charAt(i) == ' ' ? '_' : name.charAt(i);
		}
		return code;
	}
	
}
