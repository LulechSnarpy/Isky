package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import listener.BoundChangeListenser;

public class MainFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;

	public MainFrame() {
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
		this.addComponentListener(new BoundChangeListenser());
		this.setLayout(null);
		this.setAlwaysOnTop(true);
		init();
		this.setVisible(true);
	}
	
	public void init(){
		MiddleBottomPanel mbp = new MiddleBottomPanel();
		this.add(mbp);
		TopMenu tm = new TopMenu();
		this.setJMenuBar(tm);
		ATP.transfomController.setMbp(mbp);
	    ImagePanel impPre = new ImagePanel();
		impPre.setVisible(true);
		this.add(impPre);
		ATP.transfomController.setImpPre(impPre);

	}
	
	public static void main(String[] args) {
		 ATP.mf = new MainFrame();
		 ATP.transfomController.setMainFrame(ATP.mf);
	}
}
