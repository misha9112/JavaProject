package com.inc.project;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ParkFrame extends JFrame {
	ParkFrame parkFrame = this;
	JPanel mainPanel;

	// 주차 공간
	JPanel parkPanel;
	JPanel pPanel;

	JButton park1Btn;
	JButton park2Btn;
	JButton park3Btn;
	JButton park4Btn;
	JButton park5Btn;
	JButton park6Btn;
	JButton park7Btn;
	JButton park8Btn;
	
	int[] parkArray= {1,2,3,4,5,6,7,8};

	// 입, 출, 요금
	JPanel textPanel;
	JTextArea entArea;

	String seatNum;
	String carNum;
	List<String> seatNums = new ArrayList<>();
	
	// 입출차시간
	Date inDate=new Date();
	Date outDate=new Date();

	public ParkFrame() {
		setTitle("주차 입출 관리");
		setBounds(500, 200, 500, 500);
		setResizable(false);
		System.out.println(inDate);

		init();

		setVisible(true);
	}

	private void init() {
		initComponent();
		initEvent();
	}

	private void initEvent() {
		MouseAdapter ma = new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (((JButton) e.getComponent()).getText().length() == 1) {
					new InputCarFrame(parkFrame).seatArea.setText(((JButton) e.getComponent()).getText());
					seatNums.add(((JButton) e.getComponent()).getText());
					seatNum = ((JButton) e.getComponent()).getText();
				} else {
					carNum = ((JButton) e.getComponent()).getText();
					new OutputCarFrame(parkFrame,inDate);
				}
			}
		};

		park1Btn.addMouseListener(ma);
		park2Btn.addMouseListener(ma);
		park3Btn.addMouseListener(ma);
		park4Btn.addMouseListener(ma);
		park5Btn.addMouseListener(ma);
		park6Btn.addMouseListener(ma);
		park7Btn.addMouseListener(ma);
		park8Btn.addMouseListener(ma);

	}

	public void initComponent() {
		ptPanel();
	}

	public void ptPanel() {
		mainPanel = new JPanel();

		// parkPanel
		parkPanel = new JPanel(new GridLayout(1, 7));

		pPanel = new JPanel(new GridLayout(2, 4, 5, 5));

		park1Btn = new JButton("1");
		park2Btn = new JButton("2");
		park3Btn = new JButton("3");
		park4Btn = new JButton("4");
		park5Btn = new JButton("5");
		park6Btn = new JButton("6");
		park7Btn = new JButton("7");
		park8Btn = new JButton("8");

		pPanel.add(park1Btn);
		pPanel.add(park2Btn);
		pPanel.add(park3Btn);
		pPanel.add(park4Btn);
		pPanel.add(park5Btn);
		pPanel.add(park6Btn);
		pPanel.add(park7Btn);
		pPanel.add(park8Btn);

		parkPanel.add(pPanel);

		mainPanel.add(parkPanel);

		// textPanel
		textPanel = new JPanel();
		entArea = new JTextArea(10, 40);
		entArea.setLineWrap(true);
		textPanel.add(new JScrollPane(entArea));

		mainPanel.add(textPanel);

		add(mainPanel);

	}

	public static void main(String[] args) {
		new ParkFrame();
	}

}
