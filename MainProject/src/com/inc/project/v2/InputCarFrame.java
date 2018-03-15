package com.inc.project.v2;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class InputCarFrame extends JFrame {
	JPanel inputPanel;

	JLabel numLabel;
	JLabel seatLabel;

	JTextField numField;
	JTextArea seatArea;

	JButton inBtn;
	JButton cancelBtn;
	ParkFrame pf;
	String str2;
	Date inDate;

	public InputCarFrame(ParkFrame parkFrame) {
		this.pf = parkFrame; 

		setTitle("입차");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(550, 300, 300, 150);
		setResizable(false);
		setLayout(new FlowLayout());

		init();

		setVisible(true);
	}

	public void init() {
		initComponent();
		initEvent();
	}

	public void initEvent() {
		inBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				if (seatArea.getText().equals("1")) {
					str2= numField.getText();
					pf.entArea.append(str2+" 차량 입고 되었습니다\n");
					pf.park1Btn.setText(numField.getText());
					pf.seatNums.set(0, numField.getText());
					inDate = new Date();
					System.out.println(inDate);
					dispose();
				}

				if (seatArea.getText().equals("2")) {
					str2= numField.getText();
					pf.entArea.append(str2+" 차량 입고 되었습니다\n");
					pf.park2Btn.setText(numField.getText());
					pf.seatNums.set(1, numField.getText());
					dispose();
				}

				if (seatArea.getText().equals("3")) {
					str2= numField.getText();
					pf.entArea.append(str2+" 차량 입고 되었습니다\n");
					pf.park3Btn.setText(numField.getText());
					pf.seatNums.set(2, numField.getText());
					dispose();
				}

				if (seatArea.getText().equals("4")) {
					str2= numField.getText();
					pf.entArea.append(str2+" 차량 입고 되었습니다\n");
					pf.park4Btn.setText(numField.getText());
					pf.seatNums.set(3, numField.getText());
					dispose();
				}

				if (seatArea.getText().equals("5")) {
					str2= numField.getText();
					pf.entArea.append(str2+" 차량 입고 되었습니다\n");
					pf.park5Btn.setText(numField.getText());
					pf.seatNums.set(4, numField.getText());
					dispose();
				}

				if (seatArea.getText().equals("6")) {
					str2= numField.getText();
					pf.entArea.append(str2+" 차량 입고 되었습니다\n");
					pf.park6Btn.setText(numField.getText());
					pf.seatNums.set(5, numField.getText());
					dispose();
				}

				if (seatArea.getText().equals("7")) {
					str2= numField.getText();
					pf.entArea.append(str2+" 차량 입고 되었습니다\n");
					pf.park7Btn.setText(numField.getText());
					pf.seatNums.set(6, numField.getText());
					dispose();
				}

				if (seatArea.getText().equals("8")) {
					str2= numField.getText();
					pf.entArea.append(str2+" 차량 입고 되었습니다\n");
					pf.park8Btn.setText(numField.getText());
					pf.seatNums.set(7, numField.getText());
					dispose();
				}

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
		inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));

		numLabel = new JLabel("차량 번호");
		seatLabel = new JLabel("차고 번호");

		numField = new JTextField(10);
		seatArea = new JTextArea();
		seatArea.setEnabled(false);

		inBtn = new JButton("주차");
		cancelBtn = new JButton("취소");

		inputPanel.add(numLabel);
		inputPanel.add(numField);

		inputPanel.add(seatLabel);
		inputPanel.add(seatArea);

		inputPanel.add(inBtn);
		inputPanel.add(cancelBtn);

		add(inputPanel);
	}

}
