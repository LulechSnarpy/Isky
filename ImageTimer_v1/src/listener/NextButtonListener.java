package listener;

import java.awt.event.MouseEvent;

import ui.ATP;
import ui.ImageButton;

public class NextButtonListener extends ImageButtonListener{

	public NextButtonListener(ImageButton btn) {
		super(btn);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ATP.transfomController.nextToNextImage();
	}
	
}