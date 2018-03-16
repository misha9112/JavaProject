package com.inc.project.v2;

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
	// To. 현민씨에게

	// 버그의 원인은 일단 문자열을 비교하는데 seatNum이라는 변수가 계속 변경되니까 그 변수로 차고번호를 지정해버려서
	// 차고번호가 제일 마지막에 설정한 변수로 고정돼버리는겁니다.

	// 버그픽스의 원리는 그거임 배열로써서 차고에 1번부터 8번이있으면 0번부터 7번 인덱스가 있을거아니겠습니까
	// 그럼 차고에 해당하는 숫자 -1이 인덱스니까 거따가 차번호집어넣고 나중에 indexOf로 해당 인덱스 찾아와서
	// input에서 아마 버그나는 차고번호를 집어넣게 했을거임 그럼 버그안날거라 생각했고 실제로 고쳐졌구요
	// Output에서는 배열을 삭제하면 어레이아웃오브인덱스 예외가뜰거고 왜냐? 지금 배열의크기는 차고에 맞게 이닛
	// 컴포넌트에서 설정해놨음 따라서 마지막에 출차하고
	// add가 아닌 set 인덱스번호로 들어가서 값을 ""을 주면댑니다 (널은 절대 안됨) 이건 이미 했구요

	// 남은게 추측해보자면

	// 1. 1번을 제외한 차고에 시간을 표시하게 하기
	// 2. Input과 Output의 조건을 배열의 인덱스 조건비교로 설정해서 이벤트리스너 하드코딩을 압축하세요
	// 아마 이건 진혁씨가 보면 딱 할줄아실겁니다

	// 전 휴가니까 도망갑니다 ^^ 이정도했으면 제할일은 했다고봅니다

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

	// 입, 출, 요금
	JPanel textPanel;
	JTextArea entArea;

	String seatNum;
	String carNum;
	ArrayList<String> seatNums = new ArrayList<>();

	// 입출차시간
	Date inDate = new Date();
	Date outDate = new Date();

	public ParkFrame() {
		setTitle("주차 입출 관리");
		setBounds(500, 200, 500, 280);
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
					System.out.println(Integer.parseInt((((JButton) e.getComponent()).getText())) - 1);
					seatNum = seatNums.get(Integer.parseInt((((JButton) e.getComponent()).getText())) - 1);
					new InputCarFrame(parkFrame).seatArea.setText(((JButton) e.getComponent()).getText());

				} else {
					carNum = ((JButton) e.getComponent()).getText();
					System.out.println(carNum);
					seatNums.set(seatNums.indexOf(carNum) + 1, carNum);
					new OutputCarFrame(parkFrame, inDate).seatArea.setText(seatNums.indexOf(carNum) + 1 + "");

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
		// seatnums 배열 초기화 // 차고 추가시 i 늘리기바람
		for (int i = 0; i < 8; i++) {
			seatNums.add(i, "");
		}

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
