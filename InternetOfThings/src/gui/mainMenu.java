package gui;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.table.AbstractTableModel;

import iot.AirConditioner;
import iot.Alarm;
import iot.Blind;
import iot.Device;
import iot.Door;
import iot.Heater;
import iot.IrrigationSystem;
import iot.JessManipulator;
import iot.Light;
import iot.SecurityAlarm;
import iot.Sensor;
import iot.SimpleDevice;
import iot.WaterHeater;
import iot.Window;
import jess.JessException;
import nrc.fuzzy.XValueOutsideUODException;
import nrc.fuzzy.XValuesOutOfOrderException;

import javax.swing.JScrollPane;

import javax.swing.JTable;

public class mainMenu {

	private JFrame frame;
	private JTable table_sensores;
	
	private JScrollPane scrollPaneSensors;
	private JTable tableDevices = new JTable();
	private JessManipulator jessManipulator;
	private JScrollPane scrollPaneDevices;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainMenu window = new mainMenu();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainMenu() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		jessManipulator = new JessManipulator();
		frame = new JFrame();
		frame.setBounds(10, 10, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		
		/* Sensores */
		
		// label
		JLabel lblSensores = new JLabel("Sensores");
		springLayout.putConstraint(SpringLayout.NORTH, lblSensores, 23, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblSensores, 25, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblSensores);
		
		// scroll
		
		scrollPaneSensors = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPaneSensors, 6, SpringLayout.SOUTH, lblSensores);
		springLayout.putConstraint(SpringLayout.WEST, scrollPaneSensors, 35, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPaneSensors, 318, SpringLayout.SOUTH, lblSensores);
		springLayout.putConstraint(SpringLayout.EAST, scrollPaneSensors, 430, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(scrollPaneSensors);
		
				
		// tabela
		table_sensores = new JTable();
		scrollPaneSensors.setViewportView(table_sensores);
		
		scrollPaneDevices = new JScrollPane();
		springLayout.putConstraint(SpringLayout.WEST, scrollPaneDevices, 52, SpringLayout.EAST, scrollPaneSensors);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPaneDevices, -321, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollPaneDevices, -10, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(scrollPaneDevices);
		
		JLabel lblDevices = new JLabel("Devices");
		springLayout.putConstraint(SpringLayout.NORTH, scrollPaneDevices, 6, SpringLayout.SOUTH, lblDevices);
		springLayout.putConstraint(SpringLayout.NORTH, lblDevices, 0, SpringLayout.NORTH, lblSensores);
		springLayout.putConstraint(SpringLayout.WEST, lblDevices, 401, SpringLayout.EAST, lblSensores);
		frame.getContentPane().add(lblDevices);
		frame.setResizable(false);
		
		
		buildSensorsTable();
		buildDevicesTable();
		
	}
	
	private void buildSensorsTable() {
		
		table_sensores.setModel(new SensorModel());
		scrollPaneSensors.setViewportView(table_sensores);
		
	}
	
	
	private void buildDevicesTable() {
		
		tableDevices.setModel(new DeviceModel());
		scrollPaneDevices.setViewportView(tableDevices);
				
	}
	
	class DeviceModel extends AbstractTableModel {
		
		private static final long serialVersionUID = 1L;
		public final String[] colNames = {"Device", "Type", "State"};
				
		@Override
		public String getColumnName(int column) {
			
			return colNames[column];
		}
		
		@Override
		public int getRowCount() {
			
			return jessManipulator.getDevices().size();
		}

		@Override
		public int getColumnCount() {
	
			return colNames.length;
		}
		

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			
			Device device = jessManipulator.getDevices().get(rowIndex);
			
			switch(columnIndex) {
			case 0:
				return device.getName();
				
			case 1:
				
				if(device instanceof Door)
					
					return "Door";
				
				else if(device instanceof Window) 
					
					return "Window";
				
				else if(device instanceof Light) 
					
					return "Light";
					
				else if(device instanceof WaterHeater) 
					
					return "Water Heater";
				
				else if(device instanceof Blind) 
					
					return "Blind";
				
				else if(device instanceof Heater) 
					
					return "Heater";
				
				else if(device instanceof IrrigationSystem) 
					
					return "Irrigation System";
				
				else if(device instanceof SecurityAlarm) 
					
					return "Security Alarm";
				
				else if(device instanceof Alarm) 
	
					return "Alarm";
				
				else if(device instanceof AirConditioner) 
					
					return "Air Conditioned";
				
			default:
				
				if(device instanceof SimpleDevice)
				
					return ((SimpleDevice) device).getState();
				
				else if(device instanceof AirConditioner) 
					
					return ((AirConditioner) device).getFanSpeed();
					
				else if(device instanceof WaterHeater) 
					
					return ((WaterHeater) device).getWaterTemperature();
				
				else if(device instanceof Blind) 
					
					return ((Blind) device).getPercentageClosed();
				
				else if(device instanceof Heater) 
					
					return ((Heater) device).getHeaterTemperature();
				
				else if(device instanceof IrrigationSystem) 
					
					return ((IrrigationSystem) device).getIrrigationSystemPower();
			
			}
			
			return null;
		}
		
	}
	
	
	class SensorModel extends AbstractTableModel {

		
		private static final long serialVersionUID = 1L;
		public final String[] colNames = {"Sensor", "Type", "Value"};
		
		@Override
		public String getColumnName(int column) {
			
			return colNames[column];
		}
		
		@Override
		public int getRowCount() {
			return jessManipulator.getSensors().size();
		}

		@Override
		public int getColumnCount() {
			return colNames.length;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {

			Sensor sensor = jessManipulator.getSensors().get(rowIndex);
			
			switch(columnIndex) {
			case 0:
				return sensor.getName();
				
			case 1:
				
				return sensor.getType();
				
			default:
				
				return sensor.getRealValue();
			}
			
		}
		
		
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			
			if(columnIndex == 2)
				return true;
			return false;
		}
		
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			
			if(columnIndex != 2)
				return;
			
			Sensor sensor = jessManipulator.getSensorByName((String)table_sensores.getValueAt(rowIndex, 0));
			Double newValue = Double.parseDouble((String) aValue);
			
			
			
			try {
				jessManipulator.updateSensor(sensor, newValue);
				tableDevices.setModel(new DeviceModel());
			} catch (XValueOutsideUODException | XValuesOutOfOrderException | JessException e) {
				e.printStackTrace();
			}
			
		}
		

			
	}
		

}
