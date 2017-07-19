package ui;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import listener.ClickLastListener;
import listener.ClickNextListener;
import listener.ClickStartListener;
import listener.LastButtonListener;
import listener.NextButtonListener;

public class MiddleBottomPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private ImageButton lastBtn;
	private ImageButton nextBtn;
	private ImageLabel imlPre;
	private ImageLabel imlLast;
	private ImageLabel imlNext;
	public MiddleBottomPanel() {
		init();
	}
	
	public void init(){
		this.setLayout(null);
		this.setBounds(0, ATP.impH, ATP.mbpW, ATP.mbpH);
		initButtons();
		initLabels();
		initadd();
		this.setVisible(true);
	}
	
	public void initButtons(){
		lastBtn = new ImageButton();
		nextBtn = new ImageButton();
		ClickStartListener clickStartListener1 = new ClickStartListener(lastBtn);
		ClickStartListener clickStartListener2 = new ClickStartListener(nextBtn);
		//NextButtonListener nextButtonListener = new NextButtonListener(nextBtn);
		lastBtn.setListener(clickStartListener1);
		nextBtn.setListener(clickStartListener2);
		lastBtn.setBounds(0, 30, 90, 90);
		nextBtn.setBounds(960, 30, 90, 90);
	}
	
	public void initLabels(){
		imlPre = new ImageLabel();
		imlPre.setBounds((ATP.mbpW-ATP.midLabelW)/2,(ATP.mbpH-ATP.midLabelH)/2 ,ATP.midLabelW,ATP.midLabelH);
		imlPre.paintIcon();
		imlLast = new ImageLabel();
		imlLast.setBounds((ATP.mbpW/2-ATP.midLabelW/2-ATP.sideLabelW-10), (ATP.mbpH-ATP.sideLabelH)/2, ATP.sideLabelW, ATP.sideLabelH);
		imlLast.paintIcon();
		imlLast.setListener(new ClickLastListener());
		imlNext = new ImageLabel();
		imlNext.setBounds((ATP.mbpW/2+ATP.midLabelW/2+10), (ATP.mbpH-ATP.sideLabelH)/2, ATP.sideLabelW, ATP.sideLabelH);
		imlNext.paintIcon();
		imlNext.setListener(new ClickNextListener());
	}	
	
	public void initadd(){
		this.add(lastBtn);
		this.add(nextBtn);
		this.add(imlPre);
		this.add(imlLast);
		this.add(imlNext);
	}

	

	public void setLastBtn(ImageButton lastBtn) {
		this.lastBtn = lastBtn;
	}

	public ImageButton getNextBtn() {
		return nextBtn;
	}

	public void setNextBtn(ImageButton nextBtn) {
		this.nextBtn = nextBtn;
	}

	public ImageLabel getImlPre() {
		return imlPre;
	}

	public void setImlPre(ImageLabel imlPre) {
		this.imlPre = imlPre;
	}

	public ImageLabel getImlLast() {
		return imlLast;
	}

	public void setImlLast(ImageLabel imlLast) {
		this.imlLast = imlLast;
	}

	public ImageLabel getImlNext() {
		return imlNext;
	}

	public void setImlNext(ImageLabel imlNext) {
		this.imlNext = imlNext;
	}

	public ImageButton getLastBtn() {
		return lastBtn;
	}
	
	
}
