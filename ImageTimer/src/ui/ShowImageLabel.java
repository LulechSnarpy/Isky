package ui;

import java.awt.Image;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;

import listener.ImageDraggeListener;

public class ShowImageLabel extends ImageLabel {
	private ImageIcon srcIcon;
	public ShowImageLabel() {
		super();
		paintIcon();
		MouseAdapter listener = new ImageDraggeListener();
		this.addMouseMotionListener(listener);
		this.addMouseListener(listener);
		this.addMouseWheelListener(listener);
	}
	
	@Override
	public void paintIcon() {
		icon = new ImageIcon(this.getClass().getResource(this.imagePath));
		srcIcon = new ImageIcon(this.getClass().getResource(this.imagePath));
		moveImage();
	}
	
	@Override
	public void paintIcon(String path){
		icon = new ImageIcon(path);
		srcIcon = new ImageIcon(path);
		moveImage();
	}
	
	public void moveImage(){
		int iconW = icon.getIconWidth();
		int iconH = icon.getIconHeight();
		this.setSize(iconW, iconH);
		this.setIcon(icon);
	}
	
	public void changeSize(){
		Image srcImg = srcIcon.getImage();
		int width =	srcImg.getWidth(null)*ATP.changeS/100;
		int height = srcImg.getHeight(null)*ATP.changeS/100;
		Image smallImg = srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		icon = new ImageIcon(smallImg);
		moveImage();
	}
}
