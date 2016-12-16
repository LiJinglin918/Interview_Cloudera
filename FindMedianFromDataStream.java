/*
Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. 
So the median is the mean of the two middle value.
Examples: 
[2,3,4] , the median is 3
[2,3], the median is (2 + 3) / 2 = 2.5
Design a data structure that supports the following two operations:
void addNum(int num) - Add a integer number from the data stream to the data structure.
double findMedian() - Return the median of all elements so far.
For example:
add(1)
add(2)
findMedian() -> 1.5
add(3) 
findMedian() -> 2
*/

import java.util.*;
public class FindMedianFromDataStream {
	public PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
	public PriorityQueue<Integer> min = new PriorityQueue<>();
	
	public void addNum(int num) {
		if (max.size() == 0 || num <= max.peek()) {
			if (max.size() > min.size()) {
				min.add(max.poll());
			}
			max.add(num);
		}
		
		else if (min.size() == 0 || num > min.peek()) {
			if (min.size() > max.size()) {
				max.add(min.poll());
			}
			min.add(num);
		}
		
		else {
			if (max.size() <= min.size()) 
				max.add(num);
			else
				min.add(num);
		}
	}
	
	public double findMedian() {
		if (max.size() > min.size()) {
			return max.peek();
		}
		else if (max.size() < min.size()) {
			return min.peek();
		}
		else
			return (max.peek() + min.peek()) / 2.0;
	}
}
