package com.inc.project;

import java.awt.FlowLayout;

import javax.swing.JFrame;

public class MainFrame extends JFrame {
	public MainFrame() {
		setTitle("Main Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 300, 500, 500);
		setResizable(false);
		setLayout(new FlowLayout());

		setVisible(true);
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
