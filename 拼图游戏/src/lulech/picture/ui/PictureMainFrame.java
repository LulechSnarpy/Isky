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

	private String[] items = { "鸢尾花", "金棘草" };
	private JRadioButton addNumInfo;
	private JRadioButton clearNumInfo;
	private PictureCanvas canvas;
	private PicturePreView preview;
	private JComboBox<String> box;
	private JTextField name;
	public static JTextField step;
	private JButton start;

	// 空参数构造方法
	public PictureMainFrame() {
		super();
		init();// 界面的初始化操作
		addCompo1nent();// 添加组件

		addPreViewImage(); // 添加预览图片与拼图图片
		
		addActionListener(); //为组件添加事件监听
	}

	//为组件添加事件监听
	private void addActionListener() {
		//数字提示
		addNumInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.reLoadPictureAddNumber();
			}
		});
		
		//清除提示
		clearNumInfo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				canvas.reLoadPictureClearNumber();
			}
		});
		
		//下拉框
		box.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				//获取选择图片的序号
				int num = box.getSelectedIndex();
				//更新预览区
				PictureCanvas.pictureID = num+1;
				preview.repaint();
				//更新拼图区
				canvas.reLoadPictureClearNumber();
				//更新游戏状态区
				name.setText("图片名称："+box.getSelectedItem());
				PictureCanvas.stepNum = 0;
				step.setText("步数： "+PictureCanvas.stepNum);
				//按钮区
				//按钮设置成 清除提示按钮选中状态
				
			}
		});
		
		start.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//已移动的步数清零
				PictureCanvas.stepNum = 0;
				//游戏状态区进行步数显示更新
				step.setText("步数： "+PictureCanvas.stepNum);
				canvas.start();
			}
		});
	}

	private void addPreViewImage() {
		// 创建一个面板，包含拼图区 与 预览区
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		canvas = new PictureCanvas();
		canvas.setBorder(new TitledBorder("拼图区")); //添加边框
		preview = new PicturePreView();
		preview.setBorder(new TitledBorder("预览区")); //添加边框
		// 把拼图区 与 图片预览区 添加到中间的面板中
		panel.add(canvas, BorderLayout.WEST); // 左边
		panel.add(preview, BorderLayout.EAST); // 右边

		// 把面板显示在主界面中
		this.add(panel, BorderLayout.CENTER);
	}

	private void addCompo1nent() {
		// 创建用来在主界面上方显示的面板，在面板中要包含按钮区 与 游戏状态区
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);// 设置面板的背景色
		panel.setLayout(new GridLayout(1, 2));

		// 创建左边按钮区面板
		JPanel leftPanel = new JPanel();
		leftPanel.setBorder(new TitledBorder("按钮区"));// 添加边框
		leftPanel.setBackground(Color.PINK);// 设置背景色

		addNumInfo = new JRadioButton("数字提示", false);
		clearNumInfo = new JRadioButton("清除提示0", true);
		// 添加按钮组
		ButtonGroup buttonGroup = new ButtonGroup();

		box = new JComboBox<>(items);

		// 添加开始按钮
		
		start = new JButton("Start");

		// 添加单选按钮到按钮组中
		buttonGroup.add(addNumInfo);
		buttonGroup.add(clearNumInfo);

		// 设置背景色
		addNumInfo.setBackground(Color.PINK);
		clearNumInfo.setBackground(Color.PINK);
		start.setBackground(Color.PINK);

		// 添加组件到面板中
		leftPanel.add(addNumInfo);
		leftPanel.add(clearNumInfo);
		leftPanel.add(new JLabel("                   选择图片："));
		leftPanel.add(box);
		leftPanel.add(start);
 		panel.add(leftPanel, BorderLayout.WEST); // 左边
 		
		// 设置panel 在主界面的上方显示
		this.add(panel, BorderLayout.NORTH);
		JPanel rightPanael = new JPanel();
		rightPanael.setBorder(new TitledBorder("游戏状态"));// 添加边框
		rightPanael.setBackground(Color.PINK);// 设置背景色
		rightPanael.setLayout(new GridLayout(1, 2)); // 设置布局为表格布局

		name = new JTextField("图片名称： 小女孩儿");

		step = new JTextField("步数：0");

		// 把组件添加到游戏状态面板中
		rightPanael.add(name, BorderLayout.WEST); // 左边
		rightPanael.add(step, BorderLayout.EAST); // 右边

		// 设置文本框不能编辑
		name.setEditable(false);
		step.setEditable(false);

		panel.add(rightPanael, BorderLayout.EAST); // 右边

	}

	private void init() {
		// 设置窗口的标题
		this.setTitle("拼图游戏");
		// 设置窗口的大小
		this.setSize(1000, 720);
		// 设置窗口的显示位置
		this.setLocation(150, 10);
		// 设置窗口的大小为固定大小
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
