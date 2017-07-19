package listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ui.ATP;

public class ClickLastListener extends MouseAdapter{
	  @Override
	public void mouseClicked(MouseEvent e) {
		super.mouseClicked(e);
		ATP.transfomController.lastToLastImage();
	}
}
