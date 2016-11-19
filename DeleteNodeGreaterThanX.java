// delete node whose value is greater than x

public class DeleteNodeGreaterThanX {
	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	public ListNode deleteNodeGreater(ListNode head, int x) {
		ListNode dummyHead = new ListNode(0);
		dummyHead.next = head;
		ListNode p = dummyHead;
		while (p.next != null) {
			if (p.next.val > x) {
				p.next = p.next.next;
			}
			else {
				p = p.next;
			}
		}
		return dummyHead.next;
	}
}
