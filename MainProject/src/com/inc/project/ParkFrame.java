package com.inc.project;

import javax.swing.JFrame;

public class ParkFrame extends JFrame {
	public ParkFrame() {
		setTitle("Main Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 300, 500, 500);
		setResizable(false);
		// setLayout(new FlowLayout());
		
		init();
		
		setVisible(true);
	}

	private void init() {
		initComponent();
	}

	private void initComponent() {
		
	}

	public static void main(String[] args) {
		new ParkFrame();
	}
}
