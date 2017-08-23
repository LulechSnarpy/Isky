package listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ui.ImageButton;


public class ImageButtonListener extends MouseAdapter{
	private ImageButton btn;
	public ImageButtonListener(ImageButton btn) {
		this.btn = btn;
	}
	@Override
	public void mouseExited(MouseEvent e) {
		this.btn.setFormerIcon();
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		this.btn.setEnteredIcon();
	}
	public ImageButton getBtn() {
		return btn;
	}
	public void setBtn(ImageButton btn) {
		this.btn = btn;
	}
}



