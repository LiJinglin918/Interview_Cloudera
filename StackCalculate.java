// 数字进stack, 符号pop俩之后再push. 返回stack最上面那个。 注意应该考虑4096

import java.util.*;
public class StackCalculate {
	public static void main(String[] args) {
		System.out.println(new StackCalculate().calculate("16+5*23*+"));
	}
	public int calculate(String s) {
		Stack<Integer> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				stack.push(s.charAt(i) - '0');
			}
			else if (s.charAt(i) == '+'){
				if (!stack.isEmpty()) {
					int a = stack.pop();
					int b = stack.pop();
					stack.push(a + b);
				}
			}
			else {
				if (!stack.isEmpty()) {
					int a = stack.pop();
					int b = stack.pop();
					stack.push(a * b);
				}
			}
		}
		if (!stack.isEmpty()) {
			return stack.peek();
		}
		return -1;
	}
}
