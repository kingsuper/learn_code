import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class Solution752 {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet();
        for (String s : deadends) {
            dead.add(s);
        }
        if(dead.contains("0000")){
            return -1;
        }
        Set<String> seen = new HashSet<String>();
        Queue<String> queue = new LinkedList<String>();
        queue.offer("0000");
        seen.add("0000");

        int depth = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                String node = queue.poll();
                if (node.equals(target)) {
                    return depth;
                }
                for (String s : getNexts(node)) {
                    if (!dead.contains(s) && !seen.contains(s)) {
                        queue.offer(s);
                        seen.add(s);
                    }
                }
            }
            depth++;
        }
        return -1;
    }

    private List<String> getNexts(String cur) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            StringBuilder curBuilder = new StringBuilder(cur);
            char modeCar = cur.charAt(i);
            curBuilder.setCharAt(i, modeCar == '0' ? '9' : (char) (modeCar - 1));
            list.add(curBuilder.toString());
            curBuilder.setCharAt(i, modeCar == '9' ? '0' : (char) (modeCar + 1));
            list.add(curBuilder.toString());
        }
        return list;
    }

    @Test
    public void testCanPartition() {
        String[] input = new String[]{"0201", "0101", "0102", "1212", "2002"};
        String target = "0231";
        Assert.assertEquals(6, this.openLock(input, target));
    }
}
