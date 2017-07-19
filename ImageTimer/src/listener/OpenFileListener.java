package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;

import fileio.PathGeter;
import ui.ATP;

public class OpenFileListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int isChoosed = chooser.showOpenDialog(ATP.mf);
		if(isChoosed == JFileChooser.APPROVE_OPTION){
			PathGeter pathGeter = new PathGeter();
			pathGeter.init();
			ATP.Images = pathGeter.getImageFiles(chooser.getSelectedFile().getPath());
			ATP.transfomController.initImage();
		}
	}

}
