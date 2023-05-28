import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LFU {

    class Node {
        int key, value, freq;
        Node(int k, int v) {
            key = k;
            value = v;
            freq = 1;
        }
    }
    int capicity, size, min;
    Map<Integer, Node> nodeMap;
    Map<Integer, LinkedList<Node>> freqMap;

    public LFU(int capicity) {
        this.capicity = capicity;
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
    }

    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) {
            return -1;
        }
        update(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (capicity == 0) {
            return;
        }
        Node node;
        if (nodeMap.containsKey(key)) {
            node = nodeMap.get(key);
            node.value = value;
            update(node);
        } else {
            if (size == capicity) {
                LinkedList<Node> list = freqMap.get(min);
                nodeMap.remove(list.peekLast().key);
                list.pollLast();
                if (list.size() == 0) {
                    freqMap.remove(min);
                }
                size--;
            }
            Node newNode = new Node(key, value);
            nodeMap.put(key, newNode);
            freqMap.computeIfAbsent(1, x -> new LinkedList<>()).offerFirst(newNode);
            min = 1;
            size++;
        }
    }

    public void update(Node node) {
        LinkedList<Node> list = freqMap.get(node.freq);
        list.remove(node);
        if (list.size() == 0) {
            freqMap.remove(node.freq);
            if (node.freq == min) {
                min++;
            }
        }
        node.freq++;
        freqMap.computeIfAbsent(node.freq, x -> new LinkedList<>()).offerFirst(node);
    }

}
