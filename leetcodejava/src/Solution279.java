import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Solution279 {

    class Node{
        int val = 0 ;
        int depth = 0 ;
        Node(int val,int depth){
            this.val = val;
            this.depth = depth;
        }
    }
    public int numSquares(int n) {

        Queue<Node> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        Node firstNode = new Node(n,1);
        queue.offer(firstNode);
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int i =1;;i++){
                if (node.val-i*i <0){
                    break;
                }
                int next = node.val-i*i;
                if (next == 0){
                    return node.depth;
                }
                if(!visited.contains(next)){
                    queue.offer(new Node(next,node.depth+1));
                    visited.add(next);
                }
            }
        }
        return -1;
    }

    @Test
    public void test() {
        int input = 2;
        Assert.assertEquals(2, this.numSquares(input));
    }
}
