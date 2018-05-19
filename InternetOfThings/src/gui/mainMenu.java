package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SpringLayout;
import javax.swing.JList;
import javax.swing.border.LineBorder;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.ScrollPaneConstants;
import java.awt.Scrollbar;
import java.awt.ScrollPane;

public class mainMenu {

	private JFrame frame;
	private JList list_sensores;
	private JList list_dispositivos;
	private JList list_regras;
	private JLabel lblSensores;
	private JLabel lblDispositivos;
	private JLabel lblRegras;
	private Scrollbar scrollbar_sensores;
	private Scrollbar scrollbar_dispositivos;
	private Scrollbar scrollbar_regras;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 476, 479);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SpringLayout springLayout = new SpringLayout();
		frame.getContentPane().setLayout(springLayout);
		frame.setResizable(false);
		
		/* **********
		 * Sensores *
		 * **********/
		
		//Label Sensores
		lblSensores = new JLabel("Sensores");
		springLayout.putConstraint(SpringLayout.WEST, lblSensores, 42, SpringLayout.WEST, frame.getContentPane());
		frame.getContentPane().add(lblSensores);
		
		// lista de Sensores
		list_sensores = new JList();
		list_sensores.setModel(new AbstractListModel() {
			String[] values = new String[] {"bla", "bla", "bla", "bla", "bla", "bla", "bla", "bla", "bla", "bla", "bla", "bla", "bla", "bla", "bla"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		springLayout.putConstraint(SpringLayout.SOUTH, lblSensores, -5, SpringLayout.NORTH, list_sensores);
		springLayout.putConstraint(SpringLayout.NORTH, list_sensores, 42, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, list_sensores, -207, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, list_sensores, 42, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, list_sensores, -259, SpringLayout.EAST, frame.getContentPane());
		list_sensores.setValueIsAdjusting(true);
		list_sensores.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		frame.getContentPane().add(list_sensores);
		
		scrollbar_sensores = new Scrollbar();
		springLayout.putConstraint(SpringLayout.NORTH, scrollbar_sensores, 0, SpringLayout.NORTH, list_sensores);
		springLayout.putConstraint(SpringLayout.WEST, scrollbar_sensores, 6, SpringLayout.EAST, list_sensores);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollbar_sensores, 0, SpringLayout.SOUTH, list_sensores);
		springLayout.putConstraint(SpringLayout.EAST, scrollbar_sensores, 21, SpringLayout.EAST, list_sensores);
		scrollbar_sensores.setValueIsAdjusting(true);
		frame.getContentPane().add(scrollbar_sensores);
		
		/* **************
		 * Dispositivos *
		 * **************/
		
		//Label Dispositivos
		lblDispositivos = new JLabel("Dispositivos");
		springLayout.putConstraint(SpringLayout.NORTH, lblDispositivos, 0, SpringLayout.NORTH, lblSensores);
		springLayout.putConstraint(SpringLayout.WEST, lblDispositivos, 161, SpringLayout.EAST, lblSensores);
		frame.getContentPane().add(lblDispositivos);
		
		// lista dispositivos
		list_dispositivos = new JList();
		springLayout.putConstraint(SpringLayout.NORTH, list_dispositivos, 5, SpringLayout.SOUTH, lblDispositivos);
		springLayout.putConstraint(SpringLayout.WEST, list_dispositivos, 42, SpringLayout.EAST, list_sensores);
		springLayout.putConstraint(SpringLayout.SOUTH, list_dispositivos, -207, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, list_dispositivos, -42, SpringLayout.EAST, frame.getContentPane());
		frame.getContentPane().add(list_dispositivos);
		
		scrollbar_dispositivos = new Scrollbar();
		springLayout.putConstraint(SpringLayout.NORTH, scrollbar_dispositivos, 42, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, scrollbar_dispositivos, 6, SpringLayout.EAST, list_dispositivos);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollbar_dispositivos, 250, SpringLayout.NORTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, scrollbar_dispositivos, 21, SpringLayout.EAST, list_dispositivos);
		frame.getContentPane().add(scrollbar_dispositivos);
		
		/* ********
		 * Regras *
		 * ********/
		
		//label regras
		lblRegras = new JLabel("Regras");
		springLayout.putConstraint(SpringLayout.NORTH, lblRegras, 15, SpringLayout.SOUTH, list_sensores);
		springLayout.putConstraint(SpringLayout.WEST, lblRegras, 0, SpringLayout.WEST, lblSensores);
		frame.getContentPane().add(lblRegras);
		
		//lista de regras
		list_regras = new JList();
		springLayout.putConstraint(SpringLayout.NORTH, list_regras, 6, SpringLayout.SOUTH, lblRegras);
		springLayout.putConstraint(SpringLayout.WEST, list_regras, 42, SpringLayout.WEST, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, list_regras, -62, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, list_regras, -42, SpringLayout.EAST, frame.getContentPane());
		list_regras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list_regras.setBorder(new LineBorder(Color.WHITE));
		frame.getContentPane().add(list_regras);
		
		scrollbar_regras = new Scrollbar();
		springLayout.putConstraint(SpringLayout.NORTH, scrollbar_regras, 37, SpringLayout.SOUTH, scrollbar_dispositivos);
		springLayout.putConstraint(SpringLayout.WEST, scrollbar_regras, 6, SpringLayout.EAST, list_regras);
		springLayout.putConstraint(SpringLayout.SOUTH, scrollbar_regras, 145, SpringLayout.SOUTH, scrollbar_dispositivos);
		springLayout.putConstraint(SpringLayout.EAST, scrollbar_regras, 21, SpringLayout.EAST, list_regras);
		frame.getContentPane().add(scrollbar_regras);
		
		/* ************
		 * Nova regra *
		 * ************/
		
		//Botão nova regra
		JButton btnNovaRegra = new JButton("Nova Regra");
		btnNovaRegra.setForeground(Color.BLACK);
		btnNovaRegra.setBackground(Color.GRAY);
		springLayout.putConstraint(SpringLayout.SOUTH, btnNovaRegra, -10, SpringLayout.SOUTH, frame.getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, btnNovaRegra, 0, SpringLayout.EAST, list_dispositivos);
		frame.getContentPane().add(btnNovaRegra);
	}
}
