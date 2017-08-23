package lulech.picture.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

public class PictureMainFrame extends JFrame {

	private String[] items = { "�β��", "�𼬲�" };
	private JRadioButton addNumInfo;
	private JRadioButton clearNumInfo;
	private PictureCanvas canvas;
	private PicturePreView preview;
	private JComboBox<String> box;
	private JTextField name;
	public static JTextField step;
	private JButton start;

	// �ղ������췽��
	public PictureMainFrame() {
		super();
		init();// ����ĳ�ʼ������
		addCompo1nent();// ������

		addPreViewImage(); // ���Ԥ��ͼƬ��ƴͼͼƬ
		
		addActionListener(); //Ϊ�������¼�����
	}

	//Ϊ�������¼�����
	private void addActionListener() {
		//������ʾ
		addNumInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.reLoadPictureAddNumber();
			}
		});
		
		//�����ʾ
		clearNumInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.reLoadPictureClearNumber();
			}
		});
		
		//������
		box.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				//��ȡѡ��ͼƬ�����
				int num = box.getSelectedIndex();
				//����Ԥ����
				PictureCanvas.pictureID = num+1;
				preview.repaint();
				//����ƴͼ��
				canvas.reLoadPictureClearNumber();
				//������Ϸ״̬��
				name.setText("ͼƬ���ƣ�"+box.getSelectedItem());
				PictureCanvas.stepNum = 0;
				step.setText("������ "+PictureCanvas.stepNum);
				//��ť��
				//��ť���ó� �����ʾ��ťѡ��״̬
				
			}
		});
		
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//���ƶ��Ĳ�������
				PictureCanvas.stepNum = 0;
				//��Ϸ״̬�����в�����ʾ����
				step.setText("������ "+PictureCanvas.stepNum);
				canvas.start();
			}
		});
	}

	private void addPreViewImage() {
		// ����һ����壬����ƴͼ�� �� Ԥ����
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		canvas = new PictureCanvas();
		canvas.setBorder(new TitledBorder("ƴͼ��")); //��ӱ߿�
		preview = new PicturePreView();
		preview.setBorder(new TitledBorder("Ԥ����")); //��ӱ߿�
		// ��ƴͼ�� �� ͼƬԤ���� ��ӵ��м�������
		panel.add(canvas, BorderLayout.WEST); // ���
		panel.add(preview, BorderLayout.EAST); // �ұ�

		// �������ʾ����������
		this.add(panel, BorderLayout.CENTER);
	}

	private void addCompo1nent() {
		// �����������������Ϸ���ʾ����壬�������Ҫ������ť�� �� ��Ϸ״̬��
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);// �������ı���ɫ
		panel.setLayout(new GridLayout(1, 2));

		// ������߰�ť�����
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new TitledBorder("��ť��"));// ��ӱ߿�
		leftPanel.setBackground(Color.PINK);// ���ñ���ɫ

		addNumInfo = new JRadioButton("������ʾ", false);
		clearNumInfo = new JRadioButton("�����ʾ0", true);
		// ��Ӱ�ť��
		ButtonGroup buttonGroup = new ButtonGroup();

		box = new JComboBox<>(items);

		// ��ӿ�ʼ��ť
		
		start = new JButton("Start");

		// ��ӵ�ѡ��ť����ť����
		buttonGroup.add(addNumInfo);
		buttonGroup.add(clearNumInfo);

		// ���ñ���ɫ
		addNumInfo.setBackground(Color.PINK);
		clearNumInfo.setBackground(Color.PINK);
		start.setBackground(Color.PINK);

		// �������������
		leftPanel.add(addNumInfo);
		leftPanel.add(clearNumInfo);
		leftPanel.add(new JLabel("                   ѡ��ͼƬ��"));
		leftPanel.add(box);
		leftPanel.add(start);
 		panel.add(leftPanel, BorderLayout.WEST); // ���
 		
		// ����panel ����������Ϸ���ʾ
		this.add(panel, BorderLayout.NORTH);
		JPanel rightPanael = new JPanel();
		rightPanael.setBorder(new TitledBorder("��Ϸ״̬"));// ��ӱ߿�
		rightPanael.setBackground(Color.PINK);// ���ñ���ɫ
		rightPanael.setLayout(new GridLayout(1, 2)); // ���ò���Ϊ��񲼾�

		name = new JTextField("ͼƬ���ƣ� СŮ����");

		step = new JTextField("������0");

		// �������ӵ���Ϸ״̬�����
		rightPanael.add(name, BorderLayout.WEST); // ���
		rightPanael.add(step, BorderLayout.EAST); // �ұ�

		// �����ı����ܱ༭
		name.setEditable(false);
		step.setEditable(false);

		panel.add(rightPanael, BorderLayout.EAST); // �ұ�

	}

	private void init() {
		// ���ô��ڵı���
		this.setTitle("ƴͼ��Ϸ");
		// ���ô��ڵĴ�С
		this.setSize(1000, 720);
		// ���ô��ڵ���ʾλ��
		this.setLocation(150, 10);
		// ���ô��ڵĴ�СΪ�̶���С
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
