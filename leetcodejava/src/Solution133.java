/*
 * Copyright (c) Huawei Technologies Co., Ltd. 2019-2019. All rights reserved.
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Solution20 answer,try to analysis formula is correct
 *
 * @since 2019-12-20
 */
public class Solution133 {
    /**
     * check formula is vailid.
     *
     * @param node input formula string
     * @return is valid result
     */
    public Node cloneGraph(Node node) {
        Map<Node, Node> lookup = new HashMap<>();
        return dfs(node, lookup);
    }

    private Node dfs(Node node, Map<Node, Node> lookup) {
        if (node == null) {
            return null;
        }
        if (lookup.containsKey(node)) {
            return lookup.get(node);
        }
        Node clone = new Node(node.val, new ArrayList<>());
        lookup.put(node, clone);
        for (Node n : node.neighbors) {
            clone.neighbors.add(dfs(n, lookup));
        }
        return clone;
    }

    /**
     * test check formula
     */
    @Test
    public void testCanPartition() {
        String input = "]";
        String input2 = "([)]";
    }
}
