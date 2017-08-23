package listener;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import ui.ATP;

public class BoundChangeListenser extends ComponentAdapter {
	@Override
	public void componentMoved(ComponentEvent e) {
		if(e.getComponent().isShowing()){
			Point point = e.getComponent().getLocationOnScreen();
		}
	}
	@Override
	public void componentResized(ComponentEvent e) {
		Dimension dimension = e.getComponent().getSize();
		dimension.getHeight();
		dimension.getWidth();
	}
}
