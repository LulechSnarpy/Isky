package lulech.test;

import lulech.fileio.TextFileIO;

public class TextFileIODemo {
	public static void main(String[] args) {
		String s = new String(TextFileIO.DoReadFile("C:/Users/Admin/Desktop/≈‹Õ≈º«¬º-07-06.txt"));
		// System.out.println(s);
		TextFileIO.DoWriteFile("C:/Users/Admin/Desktop/sss.txt", s.toCharArray());
	}
}
