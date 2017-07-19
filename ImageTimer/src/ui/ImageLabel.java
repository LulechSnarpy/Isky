package ui;

import java.awt.Image;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ImageLabel extends JLabel {
	private static final long serialVersionUID = 1L;
	public String imagePath = null;
	public ImageIcon icon;
	private int LW;
	private MouseAdapter listener;
	
	public ImageLabel() {
		this.imagePath = "/background/001.jpg";
	}

	public void paintIcon() {
		Image srcImg = new ImageIcon(this.getClass().getResource(imagePath)).getImage();
		setSmallImage(srcImg);
	}
	
	public void paintIcon(String path){
		Image srcImg = new ImageIcon(path).getImage();
		setSmallImage(srcImg);
	}

	public void setSmallImage(Image srcImg) {//Warning
		LW = this.getWidth();
		int width = LW;
		int height = srcImg.getHeight(null) * width / srcImg.getWidth(null);
		Image smallImg = srcImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);
		icon = new ImageIcon(smallImg);
		this.setIcon(icon);
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public MouseAdapter getListener() {
		return listener;
	}

	public void setListener(MouseAdapter listener) {
		this.listener = listener;
		this.addMouseListener(listener);
	}
}
