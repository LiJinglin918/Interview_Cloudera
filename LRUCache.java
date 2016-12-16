/*
Design and implement a data structure for Least Recently Used (LRU) cache. 
It should support the following operations: get and set.
get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
set(key, value) - Set or insert the value if the key is not already present. 
When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
*/
// 利用hashmapd存储key和value。用doulblyLinkedList数据结构

import java.util.*;
class DoublyNode {
	int key;
	int value;
	DoublyNode prev;
	DoublyNode next;
	DoublyNode(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
public class LRUCache {
	
	public int capacity;
	public HashMap<Integer, DoublyNode> hm = new HashMap<>();
	public DoublyNode head = new DoublyNode(-1, -1);
	public DoublyNode tail = new DoublyNode(-1, -1);
	
	public LRUCache(int capacity) {
		this.capacity = capacity;
		tail.prev = head;
		head.next = tail;
	}
	
	public int get(int key) {
		if (!hm.containsKey(key)) {
			return -1;
		}
		
		DoublyNode current = hm.get(key);
		current.prev.next = current.next;
		current.next.prev = current.prev;
		
		moveToTail(current);
		return hm.get(key).value;
	}
	
	public void set(int key, int value) {
		if (get(key) != -1) {
			hm.get(key).value = value;
			return;
		}
		if (hm.size() == capacity) {
			hm.remove(head.next.key);
			head.next = head.next.next;
			head.next.prev = head;
		}
		DoublyNode insert = new DoublyNode(key, value);
		hm.put(key, insert);
		moveToTail(insert);
	}
	
	public void moveToTail(DoublyNode current) {
		current.prev = tail.prev;
		tail.prev = current;
		current.prev.next = current;
		current.next = tail;
	}
}
