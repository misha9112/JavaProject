package com.inc.project;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;

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
	ParkFrame pf;
	InputCarFrame icF;

	String str;
	String str2;
	Date outDate;
	Date inDate;

	public OutputCarFrame(ParkFrame parkFrame, Date inDate) {
		this.pf = parkFrame;
		this.inDate = inDate;
		setTitle("출차");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
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
			public void mousePressed(MouseEvent e) {
				if (seatArea.getText().equals("1")) {
					str = "1";
					str2= numArea.getText();
					pf.entArea.append(str2+" 차량 출고 되었습니다"+outDate);
					System.out.println(str);
					pf.park1Btn.setText(str);
					dispose();
				}
				if (seatArea.getText().equals("2")) {
					str = seatArea.getText();
					str2= numArea.getText();
					pf.entArea.append(str2+" 차량 출고 되었습니다");
					System.out.println(str);
					pf.park2Btn.setText(str);
					dispose();
				}
				if (seatArea.getText().equals("3")) {
					str = seatArea.getText();
					str2= numArea.getText();
					pf.entArea.append(str2+" 차량 출고 되었습니다");
					System.out.println(str);
					pf.park3Btn.setText(str);
					dispose();
				}
				if (seatArea.getText().equals("4")) {
					str = seatArea.getText();
					str2= numArea.getText();
					pf.entArea.append(str2+" 차량 출고 되었습니다");
					System.out.println(str);
					pf.park4Btn.setText(str);
					dispose();
				}
				if (seatArea.getText().equals("5")) {
					str = seatArea.getText();
					str2= numArea.getText();
					pf.entArea.append(str2+" 차량 출고 되었습니다");
					System.out.println(str);
					pf.park5Btn.setText(str);
					dispose();
				}
				if (seatArea.getText().equals("6")) {
					str = seatArea.getText();
					str2= numArea.getText();
					pf.entArea.append(str2+" 차량 출고 되었습니다");
					System.out.println(str);
					pf.park6Btn.setText(str);
					dispose();
				}
				if (seatArea.getText().equals("7")) {
					str = seatArea.getText();
					str2= numArea.getText();
					pf.entArea.append(str2+" 차량 출고 되었습니다\n");
					System.out.println(str);
					pf.park7Btn.setText(str);
					dispose();
				}
				if (seatArea.getText().equals("8")) {
					str = seatArea.getText();
					str2= numArea.getText();
					pf.entArea.append(str2+" 차량 출고 되었습니다");
					System.out.println(str);
					pf.park8Btn.setText(str);
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
		outputPanel = new JPanel(new GridLayout(6, 2, 10, 10));

		numLabel = new JLabel("차량 번호");
		seatLabel = new JLabel("차고 번호");
		inLabel = new JLabel("입차 시간");
		outLabel = new JLabel("출차 시간");
		fareLabel = new JLabel("요금");
		
		outDate = new Date();

		numArea = new JTextArea();
		seatArea = new JTextArea();
		inArea = new JTextArea();
		outArea = new JTextArea();
		fareArea = new JTextArea();

		numArea.setText(pf.carNum);
		seatArea.setText(pf.seatNum);
		inArea.setText(inDate.toString());
		outArea.setText(outDate.toString());

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

}
