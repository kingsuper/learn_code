import java.util.ArrayList;
import java.util.List;

class MinStack {

    /**
     * initialize your data structure here.
     */
    List<Integer> data;

    public MinStack() {
        data = new ArrayList<>();
    }

    public void push(int x) {
        data.add(x);
    }

    public void pop() {
        data.remove(data.size()-1);
    }

    public int top() {
        return data.get(data.size()-1);

    }

    public int getMin() {
        int min = data.get(0);
        for (int i = 1; i < data.size(); i++) {
            if (min > data.get(i)) {
                min = data.get(i);
            }
        }
        return min;

    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(5);
        obj.push(4);
        obj.push(1);
        obj.push(10);
        obj.pop();
        System.out.println(obj.top());
        System.out.println(obj.getMin());

    }
}
