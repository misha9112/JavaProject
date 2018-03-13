package com.inc.project;

import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ParkFrame extends JFrame {
	JPanel mainPanel;

	// 주차 공간
	JPanel parkPanel;
	JPanel p1Panel;
	JPanel p2Panel;
	JTextArea park1Area;
	JTextArea park2Area;
	JTextArea park3Area;
	JTextArea park4Area;
	JTextArea park5Area;
	JTextArea park6Area;
	JTextArea park7Area;
	JTextArea park8Area;
	JRadioButton park1Btn;
	JRadioButton park2Btn;
	JRadioButton park3Btn;
	JRadioButton park4Btn;
	JRadioButton park5Btn;
	JRadioButton park6Btn;
	JRadioButton park7Btn;
	JRadioButton park8Btn;

	// 입, 출, 요금
	JPanel textPanel;
	JTextArea entArea;

	// 차량번호, 입출 단추
	JPanel ioPanel;
	JTextField numField;
	JButton inBtn;
	JButton outBtn;

	JTextArea parkArea;

	public ParkFrame() {
		setTitle("주차 입출 관리");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(500, 10, 500, 850);
		setResizable(false);

		init();

		setVisible(true);
	}

	private void init() {
		initComponent();
	}

	public void initComponent() {
		ptiPanel();
	}

	public void ptiPanel() {
		mainPanel = new JPanel();

		// parkPanel
		parkPanel = new JPanel(new GridLayout(2, 2));
		p1Panel = new JPanel(new GridLayout(2, 4, 5, 5));
		p2Panel = new JPanel(new GridLayout(2, 4, 5, 5));

		park1Area = new JTextArea(5, 8);
		park2Area = new JTextArea(5, 8);
		park3Area = new JTextArea(5, 8);
		park4Area = new JTextArea(5, 8);
		park5Area = new JTextArea(5, 8);
		park6Area = new JTextArea(5, 8);
		park7Area = new JTextArea(5, 8);
		park8Area = new JTextArea(5, 8);

		park1Btn = new JRadioButton();
		park2Btn = new JRadioButton();
		park3Btn = new JRadioButton();
		park4Btn = new JRadioButton();
		park5Btn = new JRadioButton();
		park6Btn = new JRadioButton();
		park7Btn = new JRadioButton();
		park8Btn = new JRadioButton();
		park1Btn.setMargin(new Insets(0, 35, 0, 0));
		park2Btn.setMargin(new Insets(0, 35, 0, 0));
		park3Btn.setMargin(new Insets(0, 35, 0, 0));
		park4Btn.setMargin(new Insets(0, 35, 0, 0));
		park5Btn.setMargin(new Insets(0, 35, 0, 0));
		park6Btn.setMargin(new Insets(0, 35, 0, 0));
		park7Btn.setMargin(new Insets(0, 35, 0, 0));
		park8Btn.setMargin(new Insets(0, 35, 0, 0));

		ButtonGroup bGroup = new ButtonGroup();
		bGroup.add(park1Btn);
		bGroup.add(park2Btn);
		bGroup.add(park3Btn);
		bGroup.add(park4Btn);
		bGroup.add(park5Btn);
		bGroup.add(park6Btn);
		bGroup.add(park7Btn);
		bGroup.add(park8Btn);

		p1Panel.add(park1Area);
		p1Panel.add(park2Area);
		p1Panel.add(park3Area);
		p1Panel.add(park4Area);
		p1Panel.add(park1Btn);
		p1Panel.add(park2Btn);
		p1Panel.add(park3Btn);
		p1Panel.add(park4Btn);

		p2Panel.add(park5Area);
		p2Panel.add(park6Area);
		p2Panel.add(park7Area);
		p2Panel.add(park8Area);
		p2Panel.add(park5Btn);
		p2Panel.add(park6Btn);
		p2Panel.add(park7Btn);
		p2Panel.add(park8Btn);

		parkPanel.add(p1Panel);
		parkPanel.add(p2Panel);

		mainPanel.add(parkPanel);

		// textPanel
		textPanel = new JPanel();
		entArea = new JTextArea(10, 40);
		entArea.setLineWrap(true);
		textPanel.add(new JScrollPane(entArea));
		mainPanel.add(textPanel);

		// ioPanel
		ioPanel = new JPanel();
		numField = new JTextField(10);
		inBtn = new JButton("入");
		outBtn = new JButton("出");

		ioPanel.add(numField);
		ioPanel.add(inBtn);
		ioPanel.add(outBtn);

		mainPanel.add(ioPanel);

		add(mainPanel);

	}

	public static void main(String[] args) {
		new ParkFrame();
	}

}
