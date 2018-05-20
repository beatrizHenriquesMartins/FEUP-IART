package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
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
import javax.swing.AbstractListModel;
import javax.swing.JButton;

public class MainMenu {

	private JFrame frame;
	private JTable table_sensores;
	
	private JScrollPane scrollPaneSensors;
	private JTable tableDevices = new JTable();
	private JessManipulator jessManipulator;
	private JScrollPane scrollPaneDevices;
	private JScrollPane scrollPaneRules;
	private JList<String> rulesList = new JList<>();
	
	private JButton btnNewRule;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
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
	public MainMenu() {
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
		frame.getContentPane().add(lblSensores);
		
		// scroll
		
		scrollPaneSensors = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPaneSensors, 6, SpringLayout.SOUTH, lblSensores);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPaneSensors, -321, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblSensores, 0, SpringLayout.WEST, scrollPaneSensors);
		springLayout.putConstraint(SpringLayout.WEST, scrollPaneSensors, 35, SpringLayout.WEST, frame.getContentPane());
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
		springLayout.putConstraint(SpringLayout.NORTH, lblDevices, 23, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblDevices, 391, SpringLayout.EAST, lblSensores);
		springLayout.putConstraint(SpringLayout.NORTH, lblSensores, 0, SpringLayout.NORTH, lblDevices);
		springLayout.putConstraint(SpringLayout.NORTH, scrollPaneDevices, 6, SpringLayout.SOUTH, lblDevices);
		frame.getContentPane().add(lblDevices);
		
		scrollPaneRules = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPaneRules, 374, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollPaneRules, 0, SpringLayout.WEST, scrollPaneSensors);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPaneRules, 258, SpringLayout.SOUTH, scrollPaneSensors);
		springLayout.putConstraint(SpringLayout.EAST, scrollPaneRules, -17, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(scrollPaneRules);
		
		btnNewRule = new JButton("New Rule");
		springLayout.putConstraint(SpringLayout.NORTH, btnNewRule, 6, SpringLayout.SOUTH, scrollPaneRules);
		springLayout.putConstraint(SpringLayout.EAST, btnNewRule, 0, SpringLayout.EAST, scrollPaneRules);
		frame.getContentPane().add(btnNewRule);
		frame.setResizable(false);
		
	
		buildSensorsTable();
		buildDevicesTable();
		buildRulesList();
		
		btnNewRule.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				NewRule newRuleFrame = new NewRule(jessManipulator,MainMenu.this);
				newRuleFrame.setTitle("New Rule");
				newRuleFrame.setVisible(true);

				
			}
		});
		
		
	}
	
	private void buildRulesList() {
		
		rulesList.setModel(new RulesModel());
		scrollPaneRules.setViewportView(rulesList);
	
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
	
	class RulesModel extends AbstractListModel<String> {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		public int getSize() {
			
			return 10;
		}

		@Override
		public String getElementAt(int index) {
			
			return "Regra " + index;
		}
		
	}
	
	
	
	
}
