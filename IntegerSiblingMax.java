import java.util.Arrays;

public class IntegerSiblingMax {
	public int Solution(int n) {
		long res = 0;	// 先用long, 以防止溢出。
		String s = String.valueOf(n);
		char[] c = s.toCharArray();
		Arrays.sort(c);
		for (int i = c.length - 1; i >= 0; i--) {
			res = res * 10 + (int)(c[i] - '0');
		}
		if (res > Integer.MAX_VALUE)
			return Integer.MAX_VALUE;
		return (int) res;
	}
}
