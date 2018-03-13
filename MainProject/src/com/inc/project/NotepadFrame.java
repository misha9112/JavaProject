package com.inc.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import memo_pro.NotepadFrame;

public class NotepadFrame extends JFrame{

	JList<String> list;
	JTextField nameField;
	JTextArea textArea;
	JButton addBtn, delBtn, modBtn;
	JLabel nameLabel, textLabel;
	JPanel westPanel, northPanel, southPanel, eastPanel, btnPanel;
	JScrollPane scroll;
	Vector<String> listStr = new Vector<>();
	HashMap<String, String> memo;
	JMenuBar menubar;
	JMenu fileMenu;
	JMenuItem openItem, saveItem, exitItem;
	
	
	
	
	public NotepadFrame() {
		setTitle("메모장");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(500, 200, 640, 480);
		setResizable(true);

		init();

		setVisible(true);

	}

	public void init() {
		initComponent();
		initPanel();
		initEvent();
	}

	private void initComponent() {
		list = new JList<>(listStr);
		memo = new HashMap<>();
		
		nameField = new JTextField(10);
		textArea = new JTextArea();
		addBtn = new JButton("추가");
		delBtn = new JButton("제거");
		modBtn = new JButton("저장");
		modBtn.setPreferredSize(new Dimension(100, 50));
		nameLabel = new JLabel("메모 제목");
		textLabel = new JLabel("내용");
		
		listStr.add("메모1");
		listStr.add("메모2");
		listStr.add("메모3");
		memo.put("메모1", "메모를 입력하세요.");
		memo.put("메모2", "메모를 입력하세요.");
		memo.put("메모3", "메모를 입력하세요.");
		//나중에 불러오면 이부분에서 인풋해야 리스트에 저장됨
		
		for(int i = 0; i < listStr.size(); i++) {
			//memo.put(listStr.get(i), value); 밸류는 인풋할때
		}
		list.setVisibleRowCount(10);
		scroll = new JScrollPane(list);
		scroll.setPreferredSize(new Dimension(100, getHeight()));
		


		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		
	}
	
	private void initEvent() {
		addBtn.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				add();
			}
		});
		
		delBtn.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				del();
			}
		});
		
		modBtn.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent e) {
				memo.put(list.getSelectedValue(), textArea.getText());
			}
		});
		
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				textArea.setText(memo.get(list.getSelectedValue()));
			}
		});
		
		textArea.addFocusListener(new FocusAdapter() {

			@Override
			public void focusGained(FocusEvent arg0) {
				if(textArea.getText().equals("메모를 입력하세요.")) {
					textArea.setText(null);
					textArea.setForeground(Color.BLACK);
				}
			}

			@Override
			public void focusLost(FocusEvent arg0) {
				if(textArea.getText().equals("")) {
					textArea.setForeground(Color.RED);
					textArea.setText("메모를 입력하세요.");
				}
				
			}
			
		});
		
	}
	
	private void add() {
		String check = nameField.getText();
		if(!nameField.getText().equals("") && check.indexOf(" ") == -1) {
			listStr.add(nameField.getText());
			list.setListData(listStr);
			memo.put(nameField.getText(), null);
			nameField.setText(null);
			nameField.requestFocus();
			scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum());
		}else {
			JOptionPane.showMessageDialog(null, "메모의 제목은 공백이 포함될 수 없습니다.");
		}
	}
	
	private void del() {
		try {
			int index = list.getSelectedIndex();
			memo.remove(listStr.get(index));
			listStr.remove(index);
			list.setListData(listStr);
		}catch(ArrayIndexOutOfBoundsException e1){
			JOptionPane.showMessageDialog(null, "삭제할 메모를 선택하세요");
		}
	}
	
	private void initPanel() {
		westPanel = new JPanel(new BorderLayout());
		westPanel.setPreferredSize(new Dimension(200, 0));
		northPanel = new JPanel(new GridLayout(1, 2));
		southPanel = new JPanel(new BorderLayout());
		eastPanel = new JPanel(new BorderLayout());
		btnPanel = new JPanel(new GridLayout(1, 2));
		northPanel.setPreferredSize(new Dimension(200, 20));
		
		btnPanel.add(addBtn);
		btnPanel.add(delBtn);

		northPanel.add(nameLabel);
		northPanel.add(textLabel);
		
		westPanel.add(scroll);
		westPanel.add(nameField, BorderLayout.NORTH);
		westPanel.add(btnPanel, BorderLayout.SOUTH);
		
		eastPanel.add(textArea);
		eastPanel.add(modBtn, BorderLayout.SOUTH);

		add(northPanel, BorderLayout.NORTH);
		add(westPanel, BorderLayout.WEST);
		add(eastPanel, BorderLayout.CENTER);
		
		
	}

	public static void main(String[] args) {
		new NotepadFrame();
	}
	
}
