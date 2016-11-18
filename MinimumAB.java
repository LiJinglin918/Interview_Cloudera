// Non-empty array A and Non-empty array B, return minimum value that can be found both in A and B. Return -1 if not found

import java.util.*;

public class Solution {
	public static void main(String[] args) {
		int[] a = {-1, 0, 3, 33, 22,4};
		int[] b = {-3, 3, 44, 42,2};
		System.out.println(new Solution().min(a, b));
	}
	public int min(int[] a, int[] b) {
		int res = Integer.MAX_VALUE;
		boolean flag = false;
		Set<Integer> set = new HashSet<>();
		for (int i : a) {
			if (!set.contains(i)) {
				set.add(i);
			}
		}
		for (int i : b) {
			if (i == Integer.MAX_VALUE) {
				flag = true;
			}
			if (set.contains(i) && i < res) {
				res = i;
			}
		}
		if (res == Integer.MAX_VALUE && flag) {
			return Integer.MAX_VALUE;
		}
		else if (res == Integer.MAX_VALUE && !flag)
			return -1;
		
		return res;
			
	}
}
