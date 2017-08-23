package lulech.fileio;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileIO {
	private static FileWriter fileWriter = null;
	private static FileReader fileReader = null;

	public static boolean DoWriteFile(String path, char c[]) {
		boolean isWrited = false;
		try {
			WriteFile(path, c);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeFileWriter();
		}
		return isWrited;
	}

	public static boolean DoWriteFile(String path, char c[], boolean append) {
		boolean isWrited = false;
		try {
			WriteFile(path, c, append);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeFileWriter();
		}
		return isWrited;
	}

	public static boolean DoWriteFile(File file, char c[]) {
		boolean isWrited = false;
		try {
			WriteFile(file, c);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeFileWriter();
		}
		return isWrited;
	}

	public static boolean DoWriteFile(File file, char c[], boolean append) {
		boolean isWrited = false;
		try {
			WriteFile(file, c, append);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeFileWriter();
		}
		return isWrited;
	}

	public static char[] DoReadFile(String path) {
		char r[] = null;
		try {
			r = ReadFile(path);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeFileReader();
		}
		return r;
	}

	public static char[] DoReadFile(File file) {
		char r[] = null;
		try {
			r = ReadFile(file);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeFileReader();
		}
		return r;
	}

	private static void WriteFile(String path, char c[]) throws IOException {
		fileWriter = new FileWriter(path);
		fileWriter.write(c);
		fileWriter.flush();
	}

	private static void WriteFile(String path, char c[], boolean append) throws IOException {
		fileWriter = new FileWriter(path, append);
		fileWriter.write(c);
		fileWriter.flush();
	}

	private static void WriteFile(File file, char c[]) throws IOException {
		fileWriter = new FileWriter(file);
		fileWriter.write(c);
		fileWriter.flush();
	}

	private static void WriteFile(File file, char c[], boolean append) throws IOException {
		fileWriter = new FileWriter(file, append);
		fileWriter.write(c);
		fileWriter.flush();
	}

	private static void closeFileWriter() {
		try {
			if (null != fileWriter) {
				fileWriter.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static char[] ReadFile(String path) throws IOException {
		int len = 0;
		char c[] = new char[1024];
		StringBuffer buffer = new StringBuffer();
		fileReader = new FileReader(path);
		for (;;) {
			len = fileReader.read(c);
			if (len == -1)
				break;
			buffer.append(c, 0, len);
		}
		return buffer.toString().toCharArray();
	}

	private static char[] ReadFile(File file) throws IOException {
		int len = 0;
		char c[] = new char[1024];
		StringBuffer buffer = new StringBuffer();
		fileReader = new FileReader(file);
		for (;;) {
			len = fileReader.read(c);
			if (len == -1)
				break;
			buffer.append(c, 0, len);
		}
		return buffer.toString().toCharArray();
	}

	private static void closeFileReader() {
		try {
			if (fileReader != null) {
				fileReader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
