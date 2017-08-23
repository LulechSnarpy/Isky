package ui;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CheckLabel extends JPanel{
	private static final long serialVersionUID = 1L;
	private static JCheckBox checkBox;
	private static JLabel fileName;
	
	public CheckLabel() {
		init();
		this.setBounds(0, 0, 200, 20);
		this.setBackground(Color.cyan);
		this.setVisible(true);
	}
	
	public void init(){
		checkBox = new JCheckBox();
		checkBox.setBackground(Color.cyan);
		this.add(checkBox);
		fileName = new JLabel("dayday");
		this.add(fileName);
	}
	
	
}
