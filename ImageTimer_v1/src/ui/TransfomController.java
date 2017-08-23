package ui;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TransfomController {
	private MiddleBottomPanel mbp;
	private JFrame mainFrame;
	private ImagePanel impPre;
	private ImageLabel imlPre;
	private ImageLabel imlLast;
	private ImageLabel imlNext;
	private ImageButton lastBtn;
	private ImageButton nextBtn;
	private ShowImageLabel imageShow;
	private JLabel timeShow;
	private int imagePoint;
	private ArrayList<String> images;
	private int imagesL;
	private Timer timeTimer;
	private long timeS;
	public void initImage(){
		ATP.isStart = false;
		this.imagePoint = 0;
		this.images = ATP.Images;
		if(null!=images){
			imagesL = images.size();
			if(imagesL!=0)
			changeImages();
		}
	}
	
	public void nextToNextImage(){
		if(null!=images&&imagesL!=0){		
			this.imagePoint = (this.imagePoint+1)%imagesL;
			changeImages();
		}
	}
	public void lastToLastImage(){
		if(null!=images&&imagesL!=0){
			this.imagePoint = (this.imagePoint+imagesL-1)%imagesL;
			changeImages();
		}
	}
	
	public void changeImages(){
		if(ATP.isStart){
			startTimer();
		}
		this.imageShow.paintIcon(images.get(this.imagePoint));
		this.impPre.moveInit();
		this.imlPre.paintIcon(images.get(this.imagePoint));        
		this.imlLast.paintIcon(images.get((this.imagePoint+imagesL-1)%imagesL));
		this.imlNext.paintIcon(images.get((this.imagePoint+1)%imagesL));
	}
	
	public void moveImage(){
		this.impPre.move();
	}
	
	public void changeSize(){
		this.imageShow.changeSize();
	}

	public void startTimer(){
		startTimeTimer();
	}
	
	public void startTimeTimer(){
		timeS = ATP.changeTime;
		initTimeShow();
		if(null!=timeTimer){
			timeTimer.cancel();
		}
		timeTimer=new Timer();
		timeTimer.schedule(new TimerTask(){
			@Override
			public void run() {
				decreaseTime();
			}
		},1000,1000);
	}
	
	public void decreaseTime(){
		timeS-=1000;
		initTimeShow();
		if(timeS==0) nextToNextImage();
	}
	
	public String fomateTime(){
		String r="";
		long timeT = timeS/1000;
		int ss = (int) (timeT%60);
		timeT/=60;
		int mm = (int) (timeT%60);
		timeT/=60;
		int hh = (int) timeT;
		r = String.format("%02d:%02d:%02d",hh,mm,ss);
		return r;
	}
	
	public void initTimeShow(){
		this.timeShow.setText(fomateTime());
		TopMenu.timeShower.setText(fomateTime());
	}
	
	public void toHandMouse(){
		mainFrame.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	public void toRotateMouse(){
		ImageIcon icon = new ImageIcon(this.getClass().getResource("/image/Rotate.png"));
		Image image = icon.getImage();
		Cursor cursor = Toolkit.getDefaultToolkit().createCustomCursor(image,new Point(10,10),"rotate");
		mainFrame.setCursor(cursor);
	}
	
	public void initMouse(){
		mainFrame.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}
	

	
	public void setMbp(MiddleBottomPanel mbp) {
		this.mbp = mbp;
		this.imlPre = mbp.getImlPre();
		this.imlLast = mbp.getImlLast();
		this.imlNext = mbp.getImlNext();
		this.lastBtn = mbp.getLastBtn();
		this.nextBtn = mbp.getNextBtn();
	}

	public ImagePanel getImpPre() {
		return impPre;
	}

	public void setImpPre(ImagePanel impPre) {
		this.impPre = impPre;
		this.imageShow = impPre.getImageShow();
		this.timeShow = impPre.getTimeShow();
	}

	public JFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}	
	
}
