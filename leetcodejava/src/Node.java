import java.util.List;

/**
 * 功能描述
 *
 * @author w00468379
 * @since 2019-12-29
 */
class Node {
    public int val;

    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
