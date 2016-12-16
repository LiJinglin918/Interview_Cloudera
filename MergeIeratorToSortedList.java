// 64. Given k sorted lists of O(n) integers each, 
// implement an iterator that will yield all elements in sorted order。

import java.util.*;
public class MergeIteratorToSortedList {
	public class MergeToIterator implements Iterator<Integer> {
		PriorityQueue<Number> minNumber;
		List<List<Integer>> lists;
		public MergeToIterator(List<List<Integer>> input) {
			this.minNumber = new PriorityQueue<>(new Comparator<Number>() {
				public int compare (Number num1, Number num2) {
					return num1.value - num2.value;
				}
			});
			this.lists = input;
			for (int i = 0; i < input.size(); i++) {
				if (input.get(i).size() == 0)
					continue;
				minNumber.add(new Number(input.get(i).get(0), 0, i));
			}
		}
		public boolean hasNext() {
			return !minNumber.isEmpty();
		}
		public Integer next() {
			Number min = minNumber.poll();
			if (lists.get(min.listIndex).size() - 1 > min.index) {
				minNumber.add(new Number(lists.get(min.listIndex).get(min.index + 1), min.index + 1, min.listIndex));
			}
			return min.value;
		}
	}
	class Number {
		int value;
		int index;
		int listIndex;
		public Number(int value, int index, int listIndex) {
			this.value = value;
			this.index = index;
			this.listIndex = listIndex;
		}
	}
}
