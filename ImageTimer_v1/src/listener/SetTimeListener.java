package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ui.ATP;

public class SetTimeListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String inputValue = JOptionPane.showInputDialog(ATP.mf,"�������趨��ʱʱ�䣨�֣���"); 
		if(inputValue!=null&&!inputValue.equals("")){
			double t = Double.valueOf(inputValue);
			ATP.changeTime = (int) (t*60*1000);
		}
	}
}
