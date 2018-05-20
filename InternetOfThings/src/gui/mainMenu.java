package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JList;
import javax.swing.border.LineBorder;

import iot.JessManipulator;

import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.ScrollPaneConstants;
import java.awt.Scrollbar;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.awt.ScrollPane;
import javax.swing.JTable;

public class mainMenu {

	private JFrame frame;
	private JTable table_sensores;

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
		JessManipulator jessManipulator = new JessManipulator();
		frame = new JFrame();
		frame.setBounds(100, 100, 476, 479);
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
		
		JScrollPane scrollPane = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scrollPane, 6, SpringLayout.SOUTH, lblSensores);
		springLayout.putConstraint(SpringLayout.WEST, scrollPane, 35, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scrollPane, 152, SpringLayout.SOUTH, lblSensores);
		springLayout.putConstraint(SpringLayout.EAST, scrollPane, 430, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(scrollPane);
		
		// dados para tabela sensores
		
		String[] columnNames = {};
		Object[][] data = {};
		
		// tabela
		table_sensores = new JTable(data, columnNames);
		scrollPane.setViewportView(table_sensores);
		frame.setResizable(false);
	}
	
	public Object[][] getSensoresUnidades(JessManipulator js) {
		Object[][] aux = {};
		
		
		
		return aux;
	}
}
