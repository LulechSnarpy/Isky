package lulech.picture.ui;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/*
 * 拼图类
 * */
public class PictureCanvas extends JPanel implements MouseListener{
	public static int pictureID = 1; //图片ID
	public static int stepNum = 0;//步数
	private Cell[] cell;
	private boolean hasAddActionListener = false;
	private Rectangle nullCell;
	// 构造方法
	public PictureCanvas() {
		// 设置拼图区的布局
		this.setLayout(null);// 帧布局
		// 创建12个图片小方格，添加到拼图区
		cell = new Cell[12];
		for (int i = 0; i < 4; i++) {// 代表的是行数
			for (int j = 0; j < 3; j++) {// 代表的是列数
				// 加载图片
				//ImageIcon icon = new ImageIcon("picture/00"+PictureCanvas.pictureID+"_" + (i * 3 + j + 1) + ".gif");
				ImageIcon icon=null;
				try {
					icon = getIcon(i, j);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// 创建图片小方格
				cell[i * 3 + j] = new Cell(icon);
				// 指定图片小方格显示的位置
				cell[i * 3 + j].setLocation(j * 150 + 20, i * 150 + 20);
				// 把图片小方格添加到拼图区显示
				this.add(cell[i * 3 + j]);
			}
		}

		// 删除第12个图片小方格
		this.remove(cell[11]);

		// 指定一个空的小方格
		
		nullCell = new Rectangle(300 + 20, 450 + 20, 150, 150);
	}

	private ImageIcon getIcon(int i, int j) throws IOException {
		File file = new File("picture/00"+PictureCanvas.pictureID + ".jpg");
		BufferedImage image=image = ImageIO.read(file);
		Image im = image.getSubimage(j*150, i*150, 150, 150);
		ImageIcon icon = new ImageIcon(im);
		return icon;
	}

	// 重新加载图片，并添加数字提示
	public void reLoadPictureAddNumber() {
		// 获取到每一个图片的小方格
		for (int i = 0; i < 4; i++) {// 行数
			for (int j = 0; j < 3; j++) {// 列数
				ImageIcon icon = null;
				try {
					icon = getIcon(i, j);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cell[i * 3 + j].setIcon(icon);
				cell[i * 3 + j].setText("" + (i * 3 + j + 1));
				cell[i * 3 + j].setVerticalTextPosition(this.getY() / 2);
				cell[i * 3 + j].setHorizontalTextPosition(this.getX() / 2);
			}
		}

	}

	// 重新加载图片，并去除数字提示
	public void reLoadPictureClearNumber() {
		// 获取到每一个图片的小方格
		for (int i = 0; i < 4; i++) {// 行数
			for (int j = 0; j < 3; j++) {// 列数
				ImageIcon icon = null;
				try {
					icon = getIcon(i, j);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				cell[i * 3 + j].setIcon(icon);
				cell[i * 3 + j].setText("");
			}
		}
	}
	
	//对小方格进行重新位置排序，打乱顺序
	public void start(){
		//如果是没有给小方格添加鼠标点击监听的话，添加监听
		if(!hasAddActionListener){
			//添加监听
			for(int i=0; i<12; i++){
				cell[i].addMouseListener(this);
			}
			//更新鼠标点击监听状态
			hasAddActionListener = true;
		}
		
		//判断当前第一个小方格距离左上角的较近时，进行方格与空方格互换
		//如果第一个小方格在左上角的四个方格位置内，就不断的循环，进行方法与空方格位置的互换
		while(cell[0].getBounds().x<=170 && cell[0].getBounds().y<=170){
			//获取空方格的位置
			int nullX = nullCell.getBounds().x;
			int nullY = nullCell.getBounds().y;
					
			//随机产生一个方向，进行空方格与小方格的互换
			int driection = (int) (Math.random()*4);
			switch(driection){
				case 0: nullX-=150; cellMove(nullX,nullY,"RIGHT"); break;
				case 1: nullX+=150; cellMove(nullX,nullY,"LEFT"); break;
				case 2: nullY-=150; cellMove(nullX,nullY,"DOWN"); break;
				case 3: nullY+=150; cellMove(nullX,nullY,"UP"); break;
			}
		}
	}
	
	private void cellMove(int nullX,int nullY,String direction){
		for(int i=0; i<11; i++){
			//获取到空方格位置相同的小方格
			if(cell[i].getBounds().x == nullX && cell[i].getBounds().y == nullY){
				//当前的方格移动
				cell[i].move(direction);
				//空方格的移动
				nullCell.setLocation(nullX, nullY);
				//交换位置后，结束循环
				break;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//获取到当前点击的小方格
		Cell button = (Cell) e.getSource();
		//获取点击方格的x,y坐标
		int clickX = button.getBounds().x; 
		int clickY = button.getBounds().y;
		
		//获取当前空格的x,y的坐标
		int nullX = nullCell.getBounds().x;
		int nullY = nullCell.getBounds().y;
		
		//进行比较曼度条件进行位置的交换
		if(clickX==nullX && clickY - nullY ==150){
			button.move("UP");
		}else if(clickX==nullX && clickY - nullY ==-150){
			button.move("DOWN");
		}else if(clickX-nullX==150 && clickY==nullY){
			button.move("LEFT");
		}else if(clickX-nullX==-150 && clickY==nullY){
			button.move("RIGHT");
		}else{
			return; //不满足移动条件，就不进行任何的处理
			
		}
		//更新空方格的位置
		nullCell.setLocation(clickX,clickY);
		//拼图区界面重新绘制
		this.repaint();
		//更新步数，将游戏状态区的步数更新
		stepNum++;
		PictureMainFrame.step.setText("步数："+stepNum);
		
		//判断当前游戏是否完成，若完成，给玩家一个友好提示
		if(this.isFinish()){
			//弹出窗口提示
			JOptionPane.showMessageDialog(this, "恭喜你完成拼图，加油！\n 所用步数："+stepNum);
			//撤销每个小方格上的鼠标点击监听，让鼠标点击小方格不再起作用了
			for(int i=0; i<11; i++){
				cell[i].removeMouseListener(this);
			}
			//更新方格的动作监听器的状态
			hasAddActionListener = false;
		}
	}

	//判断当前游戏是否完成，根据坐标判断对否拼图成功
	private boolean isFinish() {
		for(int i=0; i<11; i++){
			//获取每一个方格的位置
			int x = cell[i].getBounds().x;
			int y = cell[i].getBounds().y;
			if((y-20)/150*3+(x-20)/150 != i){
				return false;
			}
		}
		return true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
