//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode currNode = new ListNode();
        currNode = head;
        for(int i = 1; i<1; i++){
            ListNode nextNode = new ListNode(i+1);
            currNode.next = nextNode;
            currNode = nextNode;
        }
        currNode.next = null;

        currNode = head;
        while (currNode.next != null){
            System.out.println(currNode.val);
            currNode = currNode.next;
        }
        Solution s = new Solution();
        s.reverseList(head);
    }
}