package test;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

import ui.ATP;
import ui.CheckLabel;
import ui.MenuPanel;

public class TestMenuPanel extends JFrame{

	public TestMenuPanel() throws HeadlessException {
		Dimension screensize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenWidth = (int) screensize.getWidth();
		int screenHight = (int) screensize.getHeight();
		this.setBounds(ATP.mframeX=(screenWidth-ATP.frameW)/2,
				ATP.mframeY=(screenHight-ATP.frameH)/2, ATP.frameW, ATP.frameH);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
				}
			});
		this.setLayout(null);
		init();
		this.setVisible(true);
	}
	
	public void init(){
		this.add(new MenuPanel());
	}
	
	public static void main(String[] args) {
		TestMenuPanel main = new TestMenuPanel();
	}
}
