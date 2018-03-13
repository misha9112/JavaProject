package com.inc.project;

import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class ParkFrame extends JFrame {
	JPanel parkPanel;
	JTextArea parkArea;
	
	public ParkFrame() {
		setTitle("Main Frame");
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 200, 500, 500);
		setResizable(false);
		// setLayout(new FlowLayout());
		
		setLayout(new FlowLayout());

		init();

		setVisible(true);
	}

	private void init() {
		initComponent();
	}

		

	public void initComponent() {

	}

	public static void main(String[] args) {
		new ParkFrame();
	}

}
