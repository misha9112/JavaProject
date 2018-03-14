package com.inc.project;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class OutputCarFrame extends JFrame {
	JPanel outputPanel;

	JLabel numLabel;
	JLabel seatLabel;
	JLabel inLabel;
	JLabel outLabel;
	JLabel fareLabel;

	JTextArea numArea;
	JTextArea seatArea; 
	JTextArea inArea;
	JTextArea outArea;
	JTextArea fareArea;

	JButton outBtn;
	JButton cancelBtn;

	public OutputCarFrame() {
		setTitle("출차");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(550, 300, 300, 300);
		setResizable(false);

		init();

		setVisible(true);
	}

	public void init() {
		initComponent();
		initEvent();
	}

	public void initEvent() {
		outBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});

		cancelBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				dispose();
			}
		});

	}

	public void initComponent() {
		outputPanel = new JPanel(new GridLayout(6, 2, 10, 10));

		numLabel = new JLabel("차량 번호");
		seatLabel = new JLabel("차고 번호");
		inLabel = new JLabel("입차 시간");
		outLabel = new JLabel("출차 시간");
		fareLabel = new JLabel("요금");

		numArea = new JTextArea();
		seatArea = new JTextArea();
		inArea = new JTextArea();
		outArea = new JTextArea();
		fareArea = new JTextArea();

		outBtn = new JButton("출차");
		cancelBtn = new JButton("취소");

		outputPanel.add(numLabel);
		outputPanel.add(numArea);

		outputPanel.add(seatLabel);
		outputPanel.add(seatArea);

		outputPanel.add(inLabel);
		outputPanel.add(inArea);

		outputPanel.add(outLabel);
		outputPanel.add(outArea);

		outputPanel.add(fareLabel);
		outputPanel.add(fareArea);

		outputPanel.add(outBtn);
		outputPanel.add(cancelBtn);

		add(outputPanel);
	}

	public static void main(String[] args) {
		new OutputCarFrame();
	}

}
