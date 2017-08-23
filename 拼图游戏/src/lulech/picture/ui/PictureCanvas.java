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
 * ƴͼ��
 * */
public class PictureCanvas extends JPanel implements MouseListener{
	public static int pictureID = 1; //ͼƬID
	public static int stepNum = 0;//����
	private Cell[] cell;
	private boolean hasAddActionListener = false;
	private Rectangle nullCell;
	// ���췽��
	public PictureCanvas() {
		// ����ƴͼ���Ĳ���
		this.setLayout(null);// ֡����
		// ����12��ͼƬС������ӵ�ƴͼ��
		cell = new Cell[12];
		for (int i = 0; i < 4; i++) {// �����������
			for (int j = 0; j < 3; j++) {// �����������
				// ����ͼƬ
				//ImageIcon icon = new ImageIcon("picture/00"+PictureCanvas.pictureID+"_" + (i * 3 + j + 1) + ".gif");
				ImageIcon icon=null;
				try {
					icon = getIcon(i, j);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				// ����ͼƬС����
				cell[i * 3 + j] = new Cell(icon);
				// ָ��ͼƬС������ʾ��λ��
				cell[i * 3 + j].setLocation(j * 150 + 20, i * 150 + 20);
				// ��ͼƬС������ӵ�ƴͼ����ʾ
				this.add(cell[i * 3 + j]);
			}
		}

		// ɾ����12��ͼƬС����
		this.remove(cell[11]);

		// ָ��һ���յ�С����
		
		nullCell = new Rectangle(300 + 20, 450 + 20, 150, 150);
	}

	private ImageIcon getIcon(int i, int j) throws IOException {
		File file = new File("picture/00"+PictureCanvas.pictureID + ".jpg");
		BufferedImage image=image = ImageIO.read(file);
		Image im = image.getSubimage(j*150, i*150, 150, 150);
		ImageIcon icon = new ImageIcon(im);
		return icon;
	}

	// ���¼���ͼƬ�������������ʾ
	public void reLoadPictureAddNumber() {
		// ��ȡ��ÿһ��ͼƬ��С����
		for (int i = 0; i < 4; i++) {// ����
			for (int j = 0; j < 3; j++) {// ����
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

	// ���¼���ͼƬ����ȥ��������ʾ
	public void reLoadPictureClearNumber() {
		// ��ȡ��ÿһ��ͼƬ��С����
		for (int i = 0; i < 4; i++) {// ����
			for (int j = 0; j < 3; j++) {// ����
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
	
	//��С�����������λ�����򣬴���˳��
	public void start(){
		//�����û�и�С�����������������Ļ�����Ӽ���
		if(!hasAddActionListener){
			//��Ӽ���
			for(int i=0; i<12; i++){
				cell[i].addMouseListener(this);
			}
			//�������������״̬
			hasAddActionListener = true;
		}
		
		//�жϵ�ǰ��һ��С����������ϽǵĽϽ�ʱ�����з�����շ��񻥻�
		//�����һ��С���������Ͻǵ��ĸ�����λ���ڣ��Ͳ��ϵ�ѭ�������з�����շ���λ�õĻ���
		while(cell[0].getBounds().x<=170 && cell[0].getBounds().y<=170){
			//��ȡ�շ����λ��
			int nullX = nullCell.getBounds().x;
			int nullY = nullCell.getBounds().y;
					
			//�������һ�����򣬽��пշ�����С����Ļ���
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
			//��ȡ���շ���λ����ͬ��С����
			if(cell[i].getBounds().x == nullX && cell[i].getBounds().y == nullY){
				//��ǰ�ķ����ƶ�
				cell[i].move(direction);
				//�շ�����ƶ�
				nullCell.setLocation(nullX, nullY);
				//����λ�ú󣬽���ѭ��
				break;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		//��ȡ����ǰ�����С����
		Cell button = (Cell) e.getSource();
		//��ȡ��������x,y����
		int clickX = button.getBounds().x; 
		int clickY = button.getBounds().y;
		
		//��ȡ��ǰ�ո��x,y������
		int nullX = nullCell.getBounds().x;
		int nullY = nullCell.getBounds().y;
		
		//���бȽ�������������λ�õĽ���
		if(clickX==nullX && clickY - nullY ==150){
			button.move("UP");
		}else if(clickX==nullX && clickY - nullY ==-150){
			button.move("DOWN");
		}else if(clickX-nullX==150 && clickY==nullY){
			button.move("LEFT");
		}else if(clickX-nullX==-150 && clickY==nullY){
			button.move("RIGHT");
		}else{
			return; //�������ƶ��������Ͳ������κεĴ���
			
		}
		//���¿շ����λ��
		nullCell.setLocation(clickX,clickY);
		//ƴͼ���������»���
		this.repaint();
		//���²���������Ϸ״̬���Ĳ�������
		stepNum++;
		PictureMainFrame.step.setText("������"+stepNum);
		
		//�жϵ�ǰ��Ϸ�Ƿ���ɣ�����ɣ������һ���Ѻ���ʾ
		if(this.isFinish()){
			//����������ʾ
			JOptionPane.showMessageDialog(this, "��ϲ�����ƴͼ�����ͣ�\n ���ò�����"+stepNum);
			//����ÿ��С�����ϵ�������������������С��������������
			for(int i=0; i<11; i++){
				cell[i].removeMouseListener(this);
			}
			//���·���Ķ�����������״̬
			hasAddActionListener = false;
		}
	}

	//�жϵ�ǰ��Ϸ�Ƿ���ɣ����������ж϶Է�ƴͼ�ɹ�
	private boolean isFinish() {
		for(int i=0; i<11; i++){
			//��ȡÿһ�������λ��
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
