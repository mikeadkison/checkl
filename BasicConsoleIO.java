import java.awt.Point;
import java.io.InputStream;
import java.io.IOException;
public class BasicConsoleIO {
	Point cursorPos = new Point(0,0);
	public int getNumCols() throws IOException {
		Process p = Runtime.getRuntime().exec(new String[] {"bash", "-c", "tput cols 2> /dev/tty" });
    	 InputStream input = p.getInputStream();
         byte[] numCols = new byte[5];
         input.read(numCols);
         return byteArrToInt(numCols);
	}
	public int getNumRows() throws IOException {
		Process p = Runtime.getRuntime().exec(new String[] {"bash", "-c", "tput lines 2> /dev/tty" });
    	 InputStream input = p.getInputStream();
         byte[] numRows = new byte[5];
         input.read(numRows);
         return byteArrToInt(numRows);
	}
	private int byteArrToInt(byte[] bytes) {
		int index = 0;
		while (bytes[index] >= 48 && bytes[index] <= 57 && index < bytes.length) {
			index++;
		}
		int lastIndex = index == bytes.length ? index : index - 1;
		int multiplier = 1;
		int toReturn = 0;
		for (int i = lastIndex; i >= 0; i--) {
			int digit = bytes[i] - 48;
			toReturn += multiplier * digit;
			multiplier *= 10;
		}
		return toReturn;
	}
	public void setCursorPos(Point point) {

	}
	public void write(String string, int row, int col, int fgColor, int bgColor) {

	}
	public Point getCursorPos() {
		return null;
	}
}