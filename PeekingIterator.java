/*
Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().
Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].
Call next() gets you 1, the first element in the list.
Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.
You call next() the final time and it returns 3, the last element. Calling hasNext() after that should return false.
Hint:
Think of "looking ahead". You want to cache the next element.
Is one variable sufficient? Why or why not?
Test your design with call order of peek() before next() vs next() before peek().
For a clean implementation, check out Google's guava library source code.
*/

// 想象把第一个元素放进缓存（cache）里，peek（）则存在，isPeek为真；next（）则不存在（相当于已删除），isPeek为假。

import java.util.*;
public class PeekingIterator {
	public Iterator<Integer> it;
	public int cache;
	public boolean isPeek;
	
	public PeekingIterator(Iterator<Integer> iterator) {
		it = iterator;
		isPeek = false;
	}
	public Integer peek() {
		if (isPeek)
			return cache;
		cache = it.next();
		isPeek = true;
		return cache;
	}
	public Integer next() {
		if (isPeek) {
			isPeek = false;
			return cache;
		}
		return it.next();
	}
	public boolean hasNext() {
		if (isPeek) {
			return true;
		}
		return it.hasNext();
	}
}
