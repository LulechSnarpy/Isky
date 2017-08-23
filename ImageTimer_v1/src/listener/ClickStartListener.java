package listener;

import java.awt.event.MouseEvent;

import ui.ATP;
import ui.ImageButton;

public class ClickStartListener extends ImageButtonListener{

	public ClickStartListener(ImageButton btn) {
		super(btn);
	}
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		if(ATP.Images!=null&&ATP.Images.size()!=0){
			ATP.transfomController.startTimer();
			ATP.isStart = true;
		}
	}
}
