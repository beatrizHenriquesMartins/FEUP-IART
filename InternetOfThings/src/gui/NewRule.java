package gui;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

import iot.Device;
import iot.JessManipulator;
import iot.JessManipulator.Pair;
import iot.Sensor;

import javax.swing.JScrollPane;

import java.util.ArrayList;

import javax.swing.JButton;

public class NewRule extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JTextField realValueSensor;
	private JTextField realValueDevice;
	private JComboBox<String> comboBoxDevices;
	private JComboBox<String> comboBoxFuzzyValueSensor;
	private JComboBox<String> comboBoxOperator;
	private JScrollPane scrollPaneSensors;
	private JComboBox<String> comboBoxSensors;
	private JComboBox<String> comboBoxFuzzyDevices;
	private JScrollPane scrollPaneDevices;
	private JButton btnOk;
	
	private JessManipulator jessManipulator;
	private MainMenu parent;
	private JButton btnNewButton;
	private JButton button;
	
	private ArrayList<Pair<Sensor,Object>> selectedSensors = new ArrayList<>();
	private ArrayList<Pair<Device,Object>> selectedDevices = new ArrayList<>();
	
	
	public NewRule(JessManipulator jessManipulator, MainMenu parent) {
		
		this.jessManipulator = jessManipulator;
		this.parent = parent;
		
		this.setBounds(20,20,600,500);
		getContentPane().setLayout(null);
		
		
		
		JLabel lblSensors = new JLabel("Sensor");
		lblSensors.setBounds(35, 34, 61, 16);
		getContentPane().add(lblSensors);
		
		comboBoxFuzzyValueSensor = new JComboBox<>();
		comboBoxFuzzyValueSensor.setBounds(220, 52, 111, 27);
		getContentPane().add(comboBoxFuzzyValueSensor);
		
		realValueSensor = new JTextField();
		realValueSensor.setBounds(343, 51, 46, 26);
		getContentPane().add(realValueSensor);
		realValueSensor.setColumns(10);
		
		comboBoxOperator = new JComboBox<>();
		comboBoxOperator.setBounds(435, 52, 52, 27);
		getContentPane().add(comboBoxOperator);
		
		scrollPaneSensors = new JScrollPane();
		scrollPaneSensors.setBounds(35, 91, 544, 120);
		getContentPane().add(scrollPaneSensors);
		
		JLabel lblFuzzyValue = new JLabel("Fuzzy Value");
		lblFuzzyValue.setBounds(220, 34, 90, 16);
		getContentPane().add(lblFuzzyValue);
		
		JLabel lblRealValue = new JLabel("Real Value");
		lblRealValue.setBounds(343, 34, 80, 16);
		getContentPane().add(lblRealValue);
		
		JLabel lblNewLabel = new JLabel("Op");
		lblNewLabel.setBounds(440, 34, 47, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblDevice = new JLabel("Device");
		lblDevice.setBounds(35, 233, 61, 16);
		getContentPane().add(lblDevice);
		
		comboBoxSensors = new JComboBox<>();
		comboBoxSensors.setBounds(35, 251, 187, 27);
		getContentPane().add(comboBoxSensors);
		
		comboBoxFuzzyDevices = new JComboBox<>();
		comboBoxFuzzyDevices.setBounds(234, 251, 111, 27);
		getContentPane().add(comboBoxFuzzyDevices);
		
		JLabel label = new JLabel("Fuzzy Value");
		label.setBounds(240, 233, 90, 16);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Real Value");
		label_1.setBounds(357, 233, 80, 16);
		getContentPane().add(label_1);
		
		realValueDevice = new JTextField();
		realValueDevice.setColumns(10);
		realValueDevice.setBounds(357, 250, 130, 26);
		getContentPane().add(realValueDevice);
		
		scrollPaneDevices = new JScrollPane();
		scrollPaneDevices.setBounds(35, 290, 544, 120);
		getContentPane().add(scrollPaneDevices);
		
		btnOk = new JButton("Ok");
		btnOk.setBounds(462, 443, 117, 29);
		getContentPane().add(btnOk);
		
		initializeComboBoxSensors();
		
		
	}

	public void initializeComboBoxSensors() {
		
		comboBoxSensors = new JComboBox<>();
		comboBoxSensors.setBounds(35, 52, 173, 27);
		getContentPane().add(comboBoxSensors);
		
		btnNewButton = new JButton("Add");
		btnNewButton.setBounds(499, 51, 80, 29);
		getContentPane().add(btnNewButton);
		
		button = new JButton("Add");
		button.setBounds(499, 250, 80, 29);
		getContentPane().add(button);
		
		for(Sensor sensor: jessManipulator.getSensors()) {
			
			comboBoxSensors.addItem(sensor.getName());
			
		}
		
	}


}
