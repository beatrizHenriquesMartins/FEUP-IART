package gui;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import iot.Device;
import iot.JessManipulator;
import iot.JessManipulator.Pair;
import iot.Sensor;
import iot.SimpleDevice;
import jess.JessException;

import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.naming.NameNotFoundException;
import javax.swing.AbstractListModel;
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
	private JComboBox<String> comboBoxValueDevice;
	private JScrollPane scrollPaneDevices;
	private JButton btnOk;
	
	private JessManipulator jessManipulator;
	private MainMenu parent;
	private JButton btnAddSensor;
	private JButton btnAddDevice;
	
	private ArrayList<Pair<Sensor,Object>> selectedSensors = new ArrayList<>();
	private JList<String> sensorsList = new JList<>();
	private ArrayList<Pair<Device,Object>> selectedDevices = new ArrayList<>();
	private JList<String> devicesList = new JList<>();
	private JLabel lblRuleName;
	private JTextField textFieldRuleName;

	
	public NewRule(JessManipulator jessManipulator, MainMenu parent) {
		
		this.jessManipulator = jessManipulator;
		this.parent = parent;
		
		this.setBounds(10,0,600,550);
		getContentPane().setLayout(null);
		
		
		
		JLabel lblSensors = new JLabel("Sensor");
		lblSensors.setBounds(36, 60, 61, 16);
		getContentPane().add(lblSensors);
		
		comboBoxFuzzyValueSensor = new JComboBox<>();
		comboBoxFuzzyValueSensor.setBounds(221, 78, 111, 27);
		getContentPane().add(comboBoxFuzzyValueSensor);
		
		realValueSensor = new JTextField();
		realValueSensor.setBounds(344, 77, 80, 26);
		getContentPane().add(realValueSensor);
		realValueSensor.setColumns(10);
		
		
		
		scrollPaneSensors = new JScrollPane();
		scrollPaneSensors.setBounds(36, 117, 544, 120);
		getContentPane().add(scrollPaneSensors);
		
		JLabel lblFuzzyValue = new JLabel("Value");
		lblFuzzyValue.setBounds(221, 60, 90, 16);
		getContentPane().add(lblFuzzyValue);
		
		JLabel lblRealValue = new JLabel("Real Value");
		lblRealValue.setBounds(344, 60, 80, 16);
		getContentPane().add(lblRealValue);
		
		JLabel lblNewLabel = new JLabel("Op");
		lblNewLabel.setBounds(441, 60, 47, 16);
		getContentPane().add(lblNewLabel);
		
		JLabel lblDevice = new JLabel("Device");
		lblDevice.setBounds(36, 259, 61, 16);
		getContentPane().add(lblDevice);
	
		
		comboBoxValueDevice = new JComboBox<>();
		comboBoxValueDevice.setBounds(235, 277, 111, 27);
		getContentPane().add(comboBoxValueDevice);
		
		JLabel label = new JLabel("Fuzzy Value");
		label.setBounds(241, 259, 90, 16);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Real Value");
		label_1.setBounds(358, 259, 80, 16);
		getContentPane().add(label_1);
		
		realValueDevice = new JTextField();
		realValueDevice.setColumns(10);
		realValueDevice.setBounds(358, 276, 130, 26);
		getContentPane().add(realValueDevice);
		
		scrollPaneDevices = new JScrollPane();
		scrollPaneDevices.setBounds(36, 316, 544, 120);
		getContentPane().add(scrollPaneDevices);
		
		btnOk = new JButton("Ok");
		btnOk.setBounds(463, 469, 117, 29);
		getContentPane().add(btnOk);
		
		btnAddSensor = new JButton("Add");
		btnAddSensor.setBounds(500, 77, 80, 29);
		getContentPane().add(btnAddSensor);
		
		btnAddDevice = new JButton("Add");
		btnAddDevice.setBounds(500, 276, 80, 29);
		getContentPane().add(btnAddDevice);
		
		initializeComboBoxSensors(jessManipulator.getSensors());
		initializeComboBoxFuzzySetNamesSensors(jessManipulator.getSensorByName((String)comboBoxSensors.getSelectedItem()).getFuzzySetNames()) ;
		initializeComboBoxOperators();
		
		btnAddSensor.addActionListener(new ButtonAddSensorListener());

		initializeComboBoxDevices(jessManipulator.getDevices());
		initializeComboBoxSetNamesDevices(jessManipulator.getDeviceByName((String)comboBoxDevices.getSelectedItem()).getSetNames()) ;
		
		btnAddDevice.addActionListener(new ButtonAddDeviceListener());
		sensorsList.setModel(new SensorListModel());
		devicesList.setModel(new DeviceListModel());
		scrollPaneSensors.setViewportView(sensorsList);
		scrollPaneDevices.setViewportView(devicesList);
		
		lblRuleName = new JLabel("Rule Name");
		lblRuleName.setBounds(36, 23, 95, 16);
		getContentPane().add(lblRuleName);
		
		textFieldRuleName = new JTextField();
		textFieldRuleName.setBounds(114, 18, 466, 26);
		getContentPane().add(textFieldRuleName);
		textFieldRuleName.setColumns(10);
		
		btnOk.addActionListener(new OkButtonListener());

	}
	
	public void initializeComboBoxSensors(ArrayList<Sensor> sensors) {
		
		comboBoxSensors = new JComboBox<>();
		comboBoxSensors.setBounds(36, 78, 173, 27);
				
		for(Sensor sensor: sensors) {
			
			comboBoxSensors.addItem(sensor.getName());
			
		}
		
		comboBoxSensors.addItemListener(new ComboBoxSensorActionListener());
		getContentPane().add(comboBoxSensors);
		
	}
	
	public void initializeComboBoxDevices(ArrayList<Device> devices) {
		
		comboBoxDevices = new JComboBox<>();
		comboBoxDevices.setBounds(36, 277, 187, 27);
		getContentPane().add(comboBoxDevices);
		
		for(Device device: devices) {
			
			comboBoxDevices.addItem(device.getName());
			
		}
		
		comboBoxDevices.addItemListener(new ComboBoxDeviceActionListener());
		
	}
	
	class ComboBoxSensorActionListener implements ItemListener {

		
		@Override
		public void itemStateChanged(ItemEvent e) {
			
			Sensor sensor = jessManipulator.getSensorByName((String)e.getItem());
			ArrayList<String> fuzzySets = sensor.getFuzzySetNames();
			initializeComboBoxFuzzySetNamesSensors(fuzzySets);
		}
		
	}
	
	class ComboBoxDeviceActionListener implements ItemListener {
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			
			Device device = jessManipulator.getDeviceByName((String)e.getItem());
			ArrayList<String> sets = device.getSetNames();
			initializeComboBoxSetNamesDevices(sets);
		}
		
	}
	
	private void initializeComboBoxFuzzySetNamesSensors(ArrayList<String> fuzzySets) {
		
		comboBoxFuzzyValueSensor.removeAllItems();
		
		for(String set: fuzzySets) {
			
			comboBoxFuzzyValueSensor.addItem(set);
			
		}
		
	}
	
	private void initializeComboBoxSetNamesDevices(ArrayList<String> sets) {
			
		comboBoxValueDevice.removeAllItems();
		
		for(String set: sets) {
			
			comboBoxValueDevice.addItem(set);
			
		}
	}
	
	private void initializeComboBoxOperators() {
		
		String[] ops = new String[] {">",">=","<","<=","==","!="};
		comboBoxOperator = new JComboBox<>();
		comboBoxOperator.setBounds(436, 78, 61, 27);
		
		for(String op: ops) {
			
			comboBoxOperator.addItem(op);
			
		}
		getContentPane().add(comboBoxOperator);
		
	}
	
	class ButtonAddSensorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String selectedSensorName = (String) comboBoxSensors.getSelectedItem();
			Sensor selectedSensor = jessManipulator.getSensorByName(selectedSensorName);
			String selectedFuzzySet = (String) comboBoxFuzzyValueSensor.getSelectedItem();
			
			String realValueString = realValueSensor.getText();
			String operator = (String) comboBoxOperator.getSelectedItem();
						
			if(realValueString.equals("")) {
				
				selectedSensors.add(new Pair<Sensor, Object>(selectedSensor,selectedFuzzySet));
				
			}
			
			else {
				
				Double realValue = Double.parseDouble(realValueString);
				Pair<Double,String> pairValueOp = new Pair<>(realValue,operator);
				selectedSensors.add(new Pair<Sensor, Object>(selectedSensor, pairValueOp));
				
			}
			
			sensorsList.setModel(new SensorListModel());
			realValueSensor.setText("");
						
		}
		
	}
	
	class ButtonAddDeviceListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			String selectedDeviceName = (String) comboBoxDevices.getSelectedItem();
			Device selectedDevice = jessManipulator.getDeviceByName(selectedDeviceName);
			String selectedSet = (String) comboBoxValueDevice.getSelectedItem();
			
			String realValueString = realValueDevice.getText();
						
			if(realValueString.equals("") || selectedDevice instanceof SimpleDevice) {
				
				selectedDevices.add(new Pair<Device, Object>(selectedDevice,selectedSet));
				
			}
			
			else {
				
				Double realValue = Double.parseDouble(realValueString);
				selectedDevices.add(new Pair<Device, Object>(selectedDevice, realValue));
				
			}
			
			devicesList.setModel(new DeviceListModel());
			
		}
		
	}
	
	class OkButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			try {
				jessManipulator.createNewVersatileRule(ruleNameUtil(), selectedSensors, selectedDevices);
				parent.updateRulesList();
				NewRule.this.setVisible(false);
				
				
			} catch (FileNotFoundException | NameNotFoundException | JessException e1) {
				e1.printStackTrace();
			}
			
			
		}
		
		
		
	}
	
	class SensorListModel extends AbstractListModel<String> {


		private static final long serialVersionUID = 1L;

		@Override
		public int getSize() {
			
			return selectedSensors.size();
		}

		@Override
		public String getElementAt(int index) {
			
			Pair<Sensor,Object> element = selectedSensors.get(index);
			
			String sensorName = element.left.getName();
			
			String rest = " ";

			if(element.right instanceof String)
				rest += " = " + element.right;
			else {
				
				@SuppressWarnings("unchecked")
				Pair<Double,String> pairStringOp = (Pair<Double, String>) element.right;
				rest += pairStringOp.right + " " + pairStringOp.left;
				
			}
				
			
			
			return sensorName + rest;
		}
		
	}
	
	class DeviceListModel extends AbstractListModel<String> {


		private static final long serialVersionUID = 1L;

		@Override
		public int getSize() {
			
			return selectedDevices.size();
		}

		@Override
		public String getElementAt(int index) {

			return selectedDevices.get(index).left.getName() + " = " + selectedDevices.get(index).right;
		}
		
	}
	
	private String ruleNameUtil() {
		
		String result = "";
		for (int i = 0; i < textFieldRuleName.getText().length(); i++) {
			result += textFieldRuleName.getText().charAt(i) == ' ' ? '_' : textFieldRuleName.getText().charAt(i);
		}
		return result;
		
	}
	

}
