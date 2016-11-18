/*
Number Complement。给一个数，输出它的有效数位inverse之后的数（输入输出均为十进制）。
比如5（101）的inverse是2（010）。因为牵扯到位运算，花了点时间。建议先复习一下位运算（与、或、非、异或）
*/


public class NumberComplement {
	public static void main(String[] args) {
		System.out.println(new NumberComplement().inverse(0));
	}
	public int inverse(int a) {
		if (a == 0) {
	        	return 1;
	    	}
	    	if (a == 1) {
	        	return 0;
	    	}
		int ones = (Integer.highestOneBit(a) << 1) - 1;		// highestOneBit返回最左边的1和后边都是0
		return a ^ ones;
	} 
}

