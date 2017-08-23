package listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import ui.ATP;

public class ImageDraggeListener extends MouseAdapter{
	private int fx;
	private int fy;
	@Override
	public void mouseDragged(MouseEvent e) {
		super.mouseDragged(e);
		int tx = e.getX();
		int ty = e.getY();
		ATP.moveX = tx-fx;
		ATP.moveY = ty-fy;
		ATP.transfomController.moveImage();
	}
	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);
		fx=e.getX();
		fy=e.getY();
		ATP.transfomController.toHandMouse();
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		super.mouseReleased(e);
		int tx = e.getX();
		int ty = e.getY();
		ATP.moveX = tx-fx;
		ATP.moveY = ty-fy;
		ATP.transfomController.moveImage();
		ATP.transfomController.initMouse();
	}
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		super.mouseWheelMoved(e);
		if(e.getWheelRotation()==-1){
			if(ATP.changeS<220)
			{
				ATP.changeS+=10;
				ATP.transfomController.changeSize();
			}
		}else{
			if(ATP.changeS>10){
				ATP.changeS-=10;
				ATP.transfomController.changeSize();
			}
		}
	}
}
