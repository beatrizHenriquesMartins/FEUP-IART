package gui;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;

import iot.Device;
import iot.FuzzyDevice;
import iot.JessManipulator;
import iot.JessManipulator.Pair;
import iot.Sensor;
import iot.SimpleDevice;

import javax.swing.JScrollPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

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
		
		
		
		scrollPaneSensors = new JScrollPane();
		scrollPaneSensors.setBounds(35, 91, 544, 120);
		getContentPane().add(scrollPaneSensors);
		
		JLabel lblFuzzyValue = new JLabel("Value");
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
	
		
		comboBoxValueDevice = new JComboBox<>();
		comboBoxValueDevice.setBounds(234, 251, 111, 27);
		getContentPane().add(comboBoxValueDevice);
		
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
		
		btnAddSensor = new JButton("Add");
		btnAddSensor.setBounds(499, 51, 80, 29);
		getContentPane().add(btnAddSensor);
		
		btnAddDevice = new JButton("Add");
		btnAddDevice.setBounds(499, 250, 80, 29);
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
		
	}


	public void initializeComboBoxSensors(ArrayList<Sensor> sensors) {
		
		comboBoxSensors = new JComboBox<>();
		comboBoxSensors.setBounds(35, 52, 173, 27);
		getContentPane().add(comboBoxSensors);
				
		for(Sensor sensor: sensors) {
			
			comboBoxSensors.addItem(sensor.getName());
			
		}
		
		comboBoxSensors.addItemListener(new ComboBoxSensorActionListener());
		
	}
	
	public void initializeComboBoxDevices(ArrayList<Device> devices) {
		
		comboBoxDevices = new JComboBox<>();
		comboBoxDevices.setBounds(35, 251, 187, 27);
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
		comboBoxOperator.setBounds(435, 52, 61, 27);
		
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
			String selectedFuzzySet = (String) comboBoxSensors.getSelectedItem();
			
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
	
	class SensorListModel extends AbstractListModel<String> {


		private static final long serialVersionUID = 1L;

		@Override
		public int getSize() {
			
			return selectedSensors.size();
		}

		@Override
		public String getElementAt(int index) {
			
			return selectedSensors.get(index).left.getName();
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
	

}
