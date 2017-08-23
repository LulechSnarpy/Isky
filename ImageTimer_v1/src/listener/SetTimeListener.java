package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ui.ATP;

public class SetTimeListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String inputValue = JOptionPane.showInputDialog(ATP.mf,"请输入设定定时时间（分）："); 
		if(inputValue!=null&&!inputValue.equals("")){
			double t = Double.valueOf(inputValue);
			ATP.changeTime = (int) (t*60*1000);
		}
	}
}
