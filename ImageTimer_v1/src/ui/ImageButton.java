package ui;


import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import listener.ImageButtonListener;

public class ImageButton extends JLabel{
	private static final long serialVersionUID = 1L;
	private ImageIcon formerIcon;
	private ImageIcon enteredIcon;
	private String formerPath;
	private String enteredPath;
	private ImageButtonListener listener;
	public ImageButton() {
		init();
	}
	
	public void init(){
		this.formerPath = "/background/001.png";
		this.enteredPath = "/background/002.png";
		this.formerIcon = new ImageIcon(this.getClass().getResource(formerPath));
		this.enteredIcon = new ImageIcon(this.getClass().getResource(enteredPath));
		this.setFormerIcon();
	}
	
	
	
	public void setFormerIcon(){
		this.setIcon(formerIcon);
	}
	
	public void setEnteredIcon(){
		this.setIcon(enteredIcon);
	}

	public ImageButtonListener getListener() {
		return listener;
	}

	public void setListener(ImageButtonListener listener) {
		this.listener = listener;
		this.addMouseListener(listener);
	}	
}


