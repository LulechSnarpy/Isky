package ui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import listener.OpenFileListener;
import listener.SetTimeListener;

public class TopMenu extends JMenuBar {
	private static final long serialVersionUID = 1L;
	public static JMenuItem timeShower;
	public TopMenu() {
		initMenus();
	}
	public void initMenus(){
		JMenu fileMenu = new JMenu("文件");
		JMenuItem openFileItem = new JMenuItem("打开文件");
		openFileItem.addActionListener(new OpenFileListener());
		fileMenu.add(openFileItem);
		this.add(fileMenu);
		JMenu setterMenu = new JMenu("设置");
		JMenuItem setterTimeItem = new JMenuItem("设置时间");
		setterTimeItem.addActionListener(new SetTimeListener());
		setterMenu.add(setterTimeItem);
		this.add(setterMenu);
		timeShower = new JMenuItem("00:00:00");
		this.add(timeShower);
	}
}
