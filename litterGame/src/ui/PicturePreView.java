package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PicturePreView extends JPanel {
	//��д��������ķ�����ʵ��ͼƬ����ʾ
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		//ָ��ͼƬ��·��
		String filename = "/picture/00"+PictureCanvas.pictureID+".jpg";
		//ͨ��ͼƬ��·������ȡ������ͼƬ�е�ͼ��
		ImageIcon icon = new ImageIcon(Class.class.getResource(filename));
		Image image = icon.getImage();
		//��ͼ�� ������ Ԥ�����������
		g.drawImage(image, 20, 20, 450, 600, this);
	}	
}
