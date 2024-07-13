public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode currNode = new ListNode();
        ListNode nextNode = new ListNode();
        currNode = head;

        ListNode start = new ListNode();
        ListNode end = new ListNode();
        ListNode prev = new ListNode();
        ListNode next = new ListNode();

        currNode = head;
        if (head == null) return head;
        if (head.next == null) return head;
        nextNode = currNode.next;
        int value = nextNode.val;
        nextNode.val = currNode.val;
        currNode.val = value;
        end = nextNode;
        prev = currNode;//

        if (nextNode.next==null) {
            end.next = null;
            return currNode;
        }
        next = nextNode.next;
//        start.next = prev;

        while (true){
            if (next != null){
                currNode = next;
                nextNode = currNode.next;

                if (nextNode != null){
                    value = nextNode.val;
                    nextNode.val = currNode.val;
                    currNode.val = value;
                    start = nextNode;

                    next = nextNode.next;
                    start.next = prev;
                    prev = currNode;
                    start = prev;
                }
                else {
                    currNode.next = prev;
                    break;
                }
            }
            else break;
        }
        end.next = null;
        return currNode;
    }
}
