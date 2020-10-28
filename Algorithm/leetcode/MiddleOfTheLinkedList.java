import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class MiddleOfTheLinkedList {

	public static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public static ListNode middleNode(ListNode head) {
		ListNode point1 = head;
		ListNode point2 = head.next;

		while (point2 != null) {
			point1 = point1.next;
			if(point2.next == null) {
				break;
			}
			point2 = point2.next.next;
		}

		return point1;
	}

	public static void main(String[] args) {
		LinkedList<ListNode> nodes = new LinkedList<>();

		//ListNode six = new ListNode(6, null);
		ListNode five = new ListNode(5, null);
		ListNode four = new ListNode(4, five);
		ListNode three = new ListNode(3, four);
		ListNode two = new ListNode(2, three);
		ListNode one = new ListNode(1, two);

		nodes.add(one);
		nodes.add(two);
		nodes.add(three);
		nodes.add(four);
		nodes.add(five);
		//nodes.add(six);

		ListNode mid = middleNode(one);
		System.out.println(mid.val);

	}
}
