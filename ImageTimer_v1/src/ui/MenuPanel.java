package ui;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuPanel extends JPanel {
	private JLabel toShowFiles;
	private JLabel toShowChoosed;
	private JLabel toNextImage;
	private JLabel toLastImage;
	private JLabel toTimerRun;
	private JTextField doTimeSet;
	private JLabel saveTimeSet;

	public MenuPanel() {
		init();
		this.setSize(1000, 50);
		this.setLocation(0, 600);
		this.setVisible(true);
		this.setBackground(Color.CYAN);
	}

	public void init() {
		toShowFiles = new JLabel("@");
		toShowChoosed = new JLabel("#");
		toNextImage = new JLabel("$");
		toLastImage = new JLabel("%");
		toTimerRun = new JLabel("||");
		doTimeSet = new JTextField();
		saveTimeSet = new JLabel("Save");

		GridBagLayout layout = new GridBagLayout();
		this.setLayout(layout);

		this.add(toShowFiles);
		this.add(toLastImage);
		this.add(toTimerRun);
		this.add(doTimeSet);
		this.add(saveTimeSet);
		this.add(toNextImage);
		this.add(toShowChoosed);
		
		GridBagConstraints s = new GridBagConstraints();
		//s.fill = GridBagConstraints.BOTH;
		//s.fill = GridBagConstraints.WEST;
		s.fill = GridBagConstraints.EAST;
		s.gridwidth = 1;
		s.weightx = 1;
		s.weighty = 0;
		layout.setConstraints(toShowFiles, s);

		s.fill = GridBagConstraints.EAST;
		s.gridwidth = 1;
		s.weightx = 1;
		s.weighty = 0;
		layout.setConstraints(toLastImage, s);
		
		
		s.gridwidth = 1;
		s.weightx = 1;
		s.weighty = 0;
		layout.setConstraints(toTimerRun, s);

		s.gridwidth = 1;
		s.weightx = 1;
		s.weighty = 0;
		layout.setConstraints(doTimeSet, s);

		s.gridwidth = 1;
		s.weightx = 1;
		s.weighty = 0;
		layout.setConstraints(saveTimeSet, s);

		s.gridwidth = 1;
		s.weightx = 1;
		s.weighty = 0;
		s.fill = GridBagConstraints.WEST;
		layout.setConstraints(toNextImage, s);

		s.gridwidth = 0;
		s.weightx = 1;
		s.weighty = 0;
		s.fill = GridBagConstraints.WEST;
		layout.setConstraints(toShowChoosed, s);
	}
}
