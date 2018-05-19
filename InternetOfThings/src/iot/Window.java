package iot;

public class Window extends Device {
	
	boolean open = false;
		
	public Window(String name, String jessVariableName) {
		super(name, jessVariableName);
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}
	
	

}
