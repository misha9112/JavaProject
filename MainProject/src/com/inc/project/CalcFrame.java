package com.inc.project;

import javax.swing.JFrame;

public class CalcFrame extends JFrame {
	public CalcFrame() {
		setTitle("Main Frame");
//		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 300, 500, 500);
		setResizable(false);
		// setLayout(new FlowLayout());

		setVisible(true);
	}

	public static void main(String[] args) {
		new CalcFrame();
	}
}
