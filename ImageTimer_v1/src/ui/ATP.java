package ui;

import java.util.ArrayList;

public class ATP {
	public static int mframeX = 0;
	public static int mframeY = 0;
	public static int frameW = 1000;
	public static int frameH = 800;
	public static int leftW = 8;
	public static int rightW = 8;
	public static int topH = 57;
	public static int bottomH = 6;
	public static int impH = 537;
	public static int impW = 984;
	public static int mbpW = impW;
	public static int mbpH = 200;
	public static int midLabelW = 360;
	public static int midLabelH = 180;
	public static int sideLabelW = (int)(midLabelW*2/3);
	public static int sideLabelH = (int)(midLabelH*2/3);
	public static ArrayList<String> Images;
	public static TransfomController transfomController = new TransfomController();
	public static final int MAXW = 984;
	public static int moveX = 0;
	public static int moveY = 0;
	public static int changeS = 100;
	public static int changeTime=3000;
	public static boolean isStart = false;
	public static MainFrame mf;
}
