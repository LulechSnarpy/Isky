package lulech.fileio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class StreamTextFileIO {
	private static FileInputStream fileInputStream = null;
	private static FileOutputStream fileOutputStream = null;
	private static InputStreamReader inputStreamReader = null;
	private static OutputStreamWriter outputStreamWriter = null;

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

	public static boolean DoWriteFile(String path, char c[], String charsetName) {
		boolean isWrited = false;
		try {
			WriteFile(path, c, charsetName);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeFileWriter();
		}
		return isWrited;
	}

	public static boolean DoWriteFile(String path, char c[], String charsetName, boolean append) {
		boolean isWrited = false;
		try {
			WriteFile(path, c, charsetName, append);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeFileWriter();
		}
		return isWrited;
	}

	public static boolean DoWriteFile(File file, char c[], String charsetName) {
		boolean isWrited = false;
		try {
			WriteFile(file, c, charsetName);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeFileWriter();
		}
		return isWrited;
	}

	public static boolean DoWriteFile(File file, char c[], String charsetName, boolean append) {
		boolean isWrited = false;
		try {
			WriteFile(file, c, charsetName, append);
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

	public static char[] DoReadFile(String path, String charsetName) {
		char r[] = null;
		try {
			r = ReadFile(path, charsetName);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeFileReader();
		}
		return r;
	}

	public static char[] DoReadFile(File file, String charsetName) {
		char r[] = null;
		try {
			r = ReadFile(file, charsetName);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			closeFileReader();
		}
		return r;
	}

	private static void WriteFile(String path, char c[]) throws IOException {
		fileOutputStream = new FileOutputStream(path);
		outputStreamWriter = new OutputStreamWriter(fileOutputStream);
		outputStreamWriter.write(c);
		outputStreamWriter.flush();
	}

	private static void WriteFile(String path, char c[], boolean append) throws IOException {
		fileOutputStream = new FileOutputStream(path, append);
		outputStreamWriter = new OutputStreamWriter(fileOutputStream);
		outputStreamWriter.write(c);
		outputStreamWriter.flush();
	}

	private static void WriteFile(File file, char c[]) throws IOException {
		fileOutputStream = new FileOutputStream(file);
		outputStreamWriter = new OutputStreamWriter(fileOutputStream);
		outputStreamWriter.write(c);
		outputStreamWriter.flush();
	}

	private static void WriteFile(File file, char c[], boolean append) throws IOException {
		fileOutputStream = new FileOutputStream(file, append);
		outputStreamWriter = new OutputStreamWriter(fileOutputStream);
		outputStreamWriter.write(c);
		outputStreamWriter.flush();
	}

	private static void WriteFile(String path, char c[], String charsetName) throws IOException {
		fileOutputStream = new FileOutputStream(path);
		outputStreamWriter = new OutputStreamWriter(fileOutputStream, charsetName);
		outputStreamWriter.write(c);
		outputStreamWriter.flush();
	}

	private static void WriteFile(String path, char c[], String charsetName, boolean append) throws IOException {
		fileOutputStream = new FileOutputStream(path, append);
		outputStreamWriter = new OutputStreamWriter(fileOutputStream, charsetName);
		outputStreamWriter.write(c);
		outputStreamWriter.flush();
	}

	private static void WriteFile(File file, char c[], String charsetName) throws IOException {
		fileOutputStream = new FileOutputStream(file);
		outputStreamWriter = new OutputStreamWriter(fileOutputStream, charsetName);
		outputStreamWriter.write(c);
		outputStreamWriter.flush();
	}

	private static void WriteFile(File file, char c[], String charsetName, boolean append) throws IOException {
		fileOutputStream = new FileOutputStream(file, append);
		outputStreamWriter = new OutputStreamWriter(fileOutputStream, charsetName);
		outputStreamWriter.write(c);
		outputStreamWriter.flush();
	}

	private static void closeFileWriter() {
		try {
			if (null != fileOutputStream) {
				fileOutputStream.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static char[] ReadFile(String path) throws IOException {
		int len = 0;
		char c[] = new char[1024];
		StringBuffer buffer = new StringBuffer();
		fileInputStream = new FileInputStream(path);
		inputStreamReader = new InputStreamReader(fileInputStream);
		for (;;) {
			len = inputStreamReader.read(c);
			if (len == -1)
				break;
			buffer.append(c, 0, len);
		}
		return buffer.toString().toCharArray();
	}

	private static char[] ReadFile(String path, String charsetName) throws IOException {
		int len = 0;
		char c[] = new char[1024];
		StringBuffer buffer = new StringBuffer();
		fileInputStream = new FileInputStream(path);
		inputStreamReader = new InputStreamReader(fileInputStream, charsetName);
		for (;;) {
			len = inputStreamReader.read(c);
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
		fileInputStream = new FileInputStream(file);
		inputStreamReader = new InputStreamReader(fileInputStream);
		for (;;) {
			len = inputStreamReader.read(c);
			if (len == -1)
				break;
			buffer.append(c, 0, len);
		}
		return buffer.toString().toCharArray();
	}

	private static char[] ReadFile(File file, String charsetName) throws IOException {
		int len = 0;
		char c[] = new char[1024];
		StringBuffer buffer = new StringBuffer();
		fileInputStream = new FileInputStream(file);
		inputStreamReader = new InputStreamReader(fileInputStream, charsetName);
		for (;;) {
			len = inputStreamReader.read(c);
			if (len == -1)
				break;
			buffer.append(c, 0, len);
		}
		return buffer.toString().toCharArray();
	}

	private static void closeFileReader() {
		try {
			if (inputStreamReader != null) {
				inputStreamReader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
