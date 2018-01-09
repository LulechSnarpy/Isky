package ui;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Cell extends JButton{
	
	//����ͼƬ��С����
	public Cell(Icon icon) {
		super(icon);
		//����С�����С
		this.setSize(150, 150);
	}
	
	//����ͼƬ���Ҵ������ֵ�С����
	public Cell(String text, Icon icon) {
		super(text, icon);
		this.setSize(150, 150);
		this.setHorizontalTextPosition(CENTER);//�ı�ˮƽ������ʾ
		this.setVerticalTextPosition(CENTER); //���ִ�ֱ������ʾ
 	}

	public void move(String direction) {//�ϣ��£�����
		switch(direction){
			case "UP": this.setLocation(this.getBounds().x, this.getBounds().y-150); break;
			case "DOWN": this.setLocation(this.getBounds().x, this.getBounds().y+150); break;
			case "LEFT": this.setLocation(this.getBounds().x-150, this.getBounds().y); break;
			case "RIGHT": this.setLocation(this.getBounds().x+150, this.getBounds().y); break;
		}
	}

}
