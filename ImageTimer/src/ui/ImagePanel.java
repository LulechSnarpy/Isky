package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import listener.ImageDraggeListener;

public class ImagePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private  ImageIcon icon;
	private  int pointX;
	private  int pointY;
	private ShowImageLabel imageShow;
	private JLabel timeShow;
	
	public ImagePanel() {
		this.setLayout(null);
		this.setBounds(0, 0, ATP.impW, ATP.impH);
		this.setBackground(new Color(0xCCCCCC));
		init();
	}
	
	public void init(){
		imageShow = new ShowImageLabel();
		timeShowInit();
		moveInit();
		this.add(timeShow);
		this.add(imageShow);
	}
	
	public void timeShowInit(){
		timeShow = new JLabel();
		timeShow.setBounds(0, 0, 100, 40);
		timeShow.setText("00:00:00");
		timeShow.setFont(new Font("Dialog",1,25));
		timeShow.setOpaque(true);
		timeShow.setBackground(Color.white);
		timeShow.setVisible(true);
	}
	
	public void moveInit(){
		ATP.changeS = 100;
		int W =  imageShow.getWidth();
		int H =  imageShow.getHeight();
		if(W<ATP.impW)
		{
			pointX = (ATP.impW-W)/2;
		}else{
			pointX = 0;
		}
		if(H<ATP.impH){
			pointY = (ATP.impH-H)/2;
		}else{
			pointY = 0;
		}
		imageShow.setBounds(pointX,pointY,W,H);
	}

	public void move(){
		int W =  imageShow.getWidth();
		int H =  imageShow.getHeight();
		pointX+=ATP.moveX;
		pointY+=ATP.moveY;
		imageShow.setBounds(pointX,pointY,W,H);
	}
	
	public ShowImageLabel getImageShow() {
		return imageShow;
	}

	public void setImageShow(ShowImageLabel imageShow) {
		this.imageShow = imageShow;
	}

	public JLabel getTimeShow() {
		return timeShow;
	}

	public void setTimeShow(JLabel timeShow) {
		this.timeShow = timeShow;
	}
}	
