package com.inc.project;

import javax.swing.JFrame;

public class ParkFrame extends JFrame {
	
	JPanel parkPanel;
	JTextArea parkArea;

	public ParkFrame() {
		setTitle("Main Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 200, 500, 500);
		setResizable(false);
		setLayout(new FlowLayout());

		init();

		setVisible(true);
	}

	public void init() {
		initComponent();
	}

	public void initComponent() {

	}

	public static void main(String[] args) {
		new ParkFrame();
	}

}
