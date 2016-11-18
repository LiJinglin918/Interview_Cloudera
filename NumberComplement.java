/*
Number Complement。给一个数，输出它的有效数位inverse之后的数（输入输出均为十进制）。
比如5（101）的inverse是2（010）。因为牵扯到位运算，花了点时间。建议先复习一下位运算（与、或、非、异或）
*/

// 101 -> 010
public class NumberComplement {
	public int inverse2(int a) {
		
		if (a == 0) {
	        return 1;
	    }
	    if (a == 1) {
	        return 0;
	    }
	    
		int i = 0;
		for (i = 0; i <= 31; i++) {
			if ((a >> i) == 1)
				break;
		}
		return clearBitsMSBthroughI(~a, i);
	}
	public int clearBitsMSBthroughI(int nums, int i) {
		int mask = (1 << i) - 1;
		return nums & mask;
	}
	public static void main(String[] args) {
		System.out.println(new NumberComplement().inverse2(1));
	}

/*================================================================================*/
	
	public int inverse(int a) {
		if (a == 0) {
	        return 1;
	    }
	    if (a == 1) {
	        return 0;
	    }
	    System.out.println("test," + (a & (~0 << 1)));
		int ones = (Integer.highestOneBit(a) << 1) - 1;
		return a ^ ones;
	} 
}

