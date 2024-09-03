package pc;

public class Repeat {

	public static String repeat(char c, int n) {
		String s = "";
		for (int i = 0; i < n; i++) {
			s += c;
		}
		return s;
	}
	
}
