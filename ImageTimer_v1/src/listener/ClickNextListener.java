package listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import ui.ATP;

public class ClickNextListener extends MouseAdapter{
	  @Override
		public void mouseClicked(MouseEvent e) {
			super.mouseClicked(e);
			ATP.transfomController.nextToNextImage();
		}
}
