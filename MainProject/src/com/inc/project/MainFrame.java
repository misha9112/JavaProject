package com.inc.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.rmi.MarshalledObject;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.activation.ActivationDesc;
import java.rmi.activation.ActivationException;
import java.rmi.activation.ActivationID;
import java.rmi.activation.ActivationInstantiator;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class MainFrame extends JFrame {
	JMenuBar menuBar;

	JMenu fileMenu;
	JMenu editMenu;
	JMenu helpMenu;
	

	JMenuItem parkItem;
	JMenuItem noteItem;
	JMenuItem calcItem;
	JMenuItem exitItem;

	JMenuItem fontItem;
	JMenuItem colorItem;

	JMenuItem webItem;
	JMenuItem callItem;

	public MainFrame() {
		setTitle("Main Frame");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(300, 300, 500, 500);
		setResizable(false);
		// setLayout(new FlowLayout());
		

		init();

		setVisible(true);
	}

	public void init() {
		initComponent();
		initEvent();
	}

	public void initEvent() {
		parkItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new ParkFrame();
			}
		});
		noteItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new NotepadFrame();
			}
		});
		calcItem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				new CalcFrame();
			}
		});
	}

	public void initComponent() {
		menuBar = new JMenuBar();

		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		helpMenu = new JMenu("Help");

		parkItem = new JMenuItem("주차관리");
		noteItem = new JMenuItem("NotePad");
		calcItem = new JMenuItem("계산기");
		exitItem = new JMenuItem("Exit");
		fontItem = new JMenuItem("Font");
		colorItem = new JMenuItem("Color");

		webItem = new JMenuItem("Web");
		callItem = new JMenuItem("Call");

		fileMenu.add(parkItem);
		fileMenu.add(noteItem);
		fileMenu.add(calcItem);
		
		fileMenu.addSeparator();
		fileMenu.add(exitItem);

		editMenu.add(fontItem);
		editMenu.add(colorItem);

		helpMenu.add(webItem);
		helpMenu.add(callItem);

		// 메뉴에 메뉴집어넣기
		editMenu.add(helpMenu);

		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		// menuBar.add(helpMenu);

		add(menuBar, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
