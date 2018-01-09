package ui;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PicturePreView extends JPanel {
	//重写绘制组件的方法，实现图片的显示
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		//指定图片的路径
		String filename = "/picture/00"+PictureCanvas.pictureID+".jpg";
		//通过图片的路径，获取到对于图片中的图像
		ImageIcon icon = new ImageIcon(Class.class.getResource(filename));
		Image image = icon.getImage();
		//把图像 绘制在 预览区的面板中
		g.drawImage(image, 20, 20, 450, 600, this);
	}	
}
