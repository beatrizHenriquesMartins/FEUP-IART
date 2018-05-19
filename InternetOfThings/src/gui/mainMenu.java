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

public class mainMenu {

	private JFrame frame;
	private JList list_sensores;

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
		frame.setResizable(false);
		
		/* **********
		 * Sensores *
		 ********** */
		//scroll
		JScrollPane scroll_sensores = new JScrollPane();
		springLayout.putConstraint(SpringLayout.WEST, scroll_sensores, 42, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scroll_sensores, -207, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scroll_sensores, -259, SpringLayout.EAST, frame.getContentPane());
		
		//nomes dos sensores
		ArrayList<String> nomesSensores = new ArrayList<String>();
		nomesSensores = getNameSensors(jessManipulator);
		
		// lista de Sensores
		list_sensores = new JList(nomesSensores.toArray());
		//list_sensores = new JList();
		list_sensores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scroll_sensores.setViewportView(list_sensores);
		frame.getContentPane().add(scroll_sensores);
		
		//label 
		JLabel lblSensores = new JLabel("Sensores");
		springLayout.putConstraint(SpringLayout.WEST, lblSensores, 42, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, lblSensores, -421, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.NORTH, scroll_sensores, 6, SpringLayout.SOUTH, lblSensores);
		frame.getContentPane().add(lblSensores);
		
		/* ************
		 * Nova regra *
		 * ************/
		
		//Botão nova regra
		JButton btnNovaRegra = new JButton("Nova Regra");
		springLayout.putConstraint(SpringLayout.EAST, btnNovaRegra, -42, SpringLayout.EAST, frame.getContentPane());
		btnNovaRegra.setForeground(Color.BLACK);
		btnNovaRegra.setBackground(Color.GRAY);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNovaRegra, -10, SpringLayout.SOUTH, frame.getContentPane());
		frame.getContentPane().add(btnNovaRegra);
		
		/* **************
		 * Dispositivos *
		 ************** */

		// scroll dispositivos
		JScrollPane scroll_dispositivos = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scroll_dispositivos, 42, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scroll_dispositivos, 42, SpringLayout.EAST, scroll_sensores);
		springLayout.putConstraint(SpringLayout.SOUTH, scroll_dispositivos, 250, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scroll_dispositivos, -42, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(scroll_dispositivos);
		
		// lista de dispositivos
		JList list_dispositivos = new JList();
		list_dispositivos.setModel(new AbstractListModel() {
			String[] values = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scroll_dispositivos.setViewportView(list_dispositivos);
		
		// label de dispositivos
		JLabel lblDispositivos = new JLabel("Dispositivos");
		springLayout.putConstraint(SpringLayout.NORTH, lblDispositivos, 0, SpringLayout.NORTH, lblSensores);
		springLayout.putConstraint(SpringLayout.WEST, lblDispositivos, 0, SpringLayout.WEST, scroll_dispositivos);
		frame.getContentPane().add(lblDispositivos);
		
		JScrollPane scroll_regras = new JScrollPane();
		springLayout.putConstraint(SpringLayout.NORTH, scroll_regras, 48, SpringLayout.SOUTH, scroll_sensores);
		springLayout.putConstraint(SpringLayout.WEST, scroll_regras, 42, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, scroll_regras, -6, SpringLayout.NORTH, btnNovaRegra);
		springLayout.putConstraint(SpringLayout.EAST, scroll_regras, 0, SpringLayout.EAST, btnNovaRegra);
		frame.getContentPane().add(scroll_regras);
		
		JList regras = new JList();
		regras.setModel(new AbstractListModel() {
			String[] values = new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scroll_regras.setViewportView(regras);
		
		JLabel lblRegras = new JLabel("Regras");
		springLayout.putConstraint(SpringLayout.NORTH, lblRegras, 16, SpringLayout.SOUTH, scroll_sensores);
		springLayout.putConstraint(SpringLayout.WEST, lblRegras, 0, SpringLayout.WEST, scroll_sensores);
		frame.getContentPane().add(lblRegras);
	}
	
	public ArrayList<String> getNameSensors(JessManipulator js) {
		ArrayList<String> aux = new ArrayList<String>();
		
		System.out.println("Sensores: ");
		
		for (int i = 0; i < js.getSensors().size(); i++) {
			String nomeS = js.getSensors().get(i).getName();
			
			System.out.println(nomeS);
			
			aux.add(nomeS);
		}
		
		System.out.println("Num Sensores: " + js.getSensors().size());
		
		return aux;
	}
}
