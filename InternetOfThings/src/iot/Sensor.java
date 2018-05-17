package iot;

public class Sensor<T> {
		
	String name;
	T value;
	
	public Sensor(String name, T value) {
		this.name = name;
		this.value = value;
	}
	public String getName() { return name; }
	public void setName(String s) { name = s; }
	
	public void setValue(T newValue) {
		value = newValue;
	}
	public T getValue() {
		return value;
	}
	
	
	

}
