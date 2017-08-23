package listener;

import java.awt.event.MouseEvent;

import ui.ATP;
import ui.ImageButton;

public class LastButtonListener extends ImageButtonListener{

	public LastButtonListener(ImageButton btn) {
		super(btn);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ATP.transfomController.lastToLastImage();
	}
	
}