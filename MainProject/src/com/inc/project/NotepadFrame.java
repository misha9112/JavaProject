package com.inc.project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FileDialog;
import java.awt.GridLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
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

public class NotepadFrame extends JFrame implements Serializable{

	JList<String> list;
	JTextField nameField;
	JTextArea textArea;
	JButton addBtn, delBtn, modBtn;
	JPanel westPanel, southPanel, eastPanel, btnPanel;
	JScrollPane scroll;
	Vector<String> listStr = new Vector<>();
	HashMap<String, String> memo;
	JMenuBar menubar;
	JMenu fileMenu;
	JMenuItem openItem, saveItem, exitItem;
	ObjectInputStream ois;
	ObjectOutputStream oos;
	MemoList memoList = new MemoList();
	
	
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
		nameField.setText("메모 이름을 입력하세요.");
		textArea = new JTextArea();
		addBtn = new JButton("추가");
		delBtn = new JButton("제거");
		modBtn = new JButton("저장");
		modBtn.setPreferredSize(new Dimension(100, 50));
		
		listStr.add("메모1");
		listStr.add("메모2");
		listStr.add("메모3");
		memo.put("메모1", "메모를 입력하세요.");
		memo.put("메모2", "메모를 입력하세요.");
		memo.put("메모3", "메모를 입력하세요.");
		//최초에 킬때 이전에 작업한 부분을 불러오고 싶다면
		//나중에 불러오면 이부분에서 인풋해야 리스트에 저장됨
		
		for(int i = 0; i < listStr.size(); i++) {
			//memo.put(listStr.get(i), value); 밸류는 인풋할때
		}
		list.setVisibleRowCount(10);
		scroll = new JScrollPane(list);
		scroll.setPreferredSize(new Dimension(100, getHeight()));
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		menubar = new JMenuBar();
		fileMenu = new JMenu("파일");
		openItem = new JMenuItem("열기");
		saveItem = new JMenuItem("저장");
		exitItem = new JMenuItem("나가기");
		
		
		
	}
	
	private void fileOpen() {
		FileDialog dialog = new FileDialog(this, "열기", FileDialog.LOAD);
		dialog.setVisible(true);
		//dialog.setDirectory(".");
		if(dialog.getFile() == null) {
			return;
		}
		
		String opendir = dialog.getDirectory() + dialog.getFile();
		
		try {
			ois = new ObjectInputStream(new FileInputStream(opendir));
			
			memoList = (MemoList)ois.readObject();
			listStr = memoList.getListStr();
			memo = memoList.getMemo();
			
			list.setListData(listStr);
			scroll.getVerticalScrollBar().setValue(scroll.getVerticalScrollBar().getMaximum());
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			try {
				ois.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void fileSave() {
		
		FileDialog dialog = new FileDialog(this, "저장", FileDialog.SAVE);
		dialog.setVisible(true);
		//dialog.setDirectory(".");
		if(dialog.getFile() == null) {
			return;
		}
		
		String savedir = dialog.getDirectory() + dialog.getFile();
		try {
			oos = new ObjectOutputStream(new FileOutputStream(savedir+".kar"));
			memoList.setMemo(this.memo);
			memoList.setListStr(this.listStr);
			oos.writeObject(memoList);
			
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "파일을 찾을 수 없습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				oos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
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
			public void focusGained(FocusEvent arg0) {
				if(textArea.getText().equals("메모를 입력하세요.")) {
					textArea.setText(null);
					textArea.setForeground(Color.BLACK);
				}
			}
			public void focusLost(FocusEvent arg0) {
				if(textArea.getText().equals("")) {
					textArea.setForeground(Color.RED);
					textArea.setText("메모를 입력하세요.");
				}
			}
		});
		
		nameField.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				if(nameField.getText().equals("메모 이름을 입력하세요.")) {
					nameField.setText(null);
					nameField.setForeground(Color.BLACK);
				}
			}
			public void focusLost(FocusEvent arg0) {
				if(nameField.getText().equals("")) {
					nameField.setForeground(Color.BLUE);
					nameField.setText("메모 이름을 입력하세요.");
				}
			}
		});
		
		openItem.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				fileOpen();
			}
		});
		
		saveItem.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				fileSave();
			}
		});
		
		exitItem.addMouseListener(new MouseAdapter() {
			public void mouseReleased(MouseEvent arg0) {
				System.exit(DISPOSE_ON_CLOSE);
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
		southPanel = new JPanel(new BorderLayout());
		eastPanel = new JPanel(new BorderLayout());
		btnPanel = new JPanel(new GridLayout(1, 2));
		
		btnPanel.add(addBtn);
		btnPanel.add(delBtn);

		westPanel.add(scroll);
		westPanel.add(nameField, BorderLayout.NORTH);
		westPanel.add(btnPanel, BorderLayout.SOUTH);
		
		eastPanel.add(textArea);
		eastPanel.add(modBtn, BorderLayout.SOUTH);
		
		fileMenu.add(openItem);
		fileMenu.add(saveItem);
		fileMenu.addSeparator();
		fileMenu.add(exitItem);
		menubar.add(fileMenu);
		
		
		add(menubar, BorderLayout.NORTH);
		add(westPanel, BorderLayout.WEST);
		add(eastPanel, BorderLayout.CENTER);
		
		
	}

	public static void main(String[] args) {
		new NotepadFrame();
	}
	
}
