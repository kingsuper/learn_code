import java.util.HashMap;

public class Solution160 {
    public Solution160() {
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap mapList;
        for(mapList = new HashMap(); headA != null; headA = headA.next) {
            mapList.put(headA.val, headA);
        }

        while(headB != null) {
            if (mapList.get(headB.val) == headB) {
                return headB;
            }

            headB = headB.next;
        }

        return null;
    }
}