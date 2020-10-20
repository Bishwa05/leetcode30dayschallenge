package oct.week3;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph
{
    public Node cloneGraph(Node node){
        if(node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        map.put(node, new Node(node.val, new ArrayList<>()));

        while(!queue.isEmpty()){
            Node h = queue.poll();

            for(Node neighbour : h.neighbors){
                if(!map.containsKey(neighbour)){
                    map.put(neighbour, new Node(neighbour.val, new ArrayList<>()));
                    queue.offer(neighbour);
                }
                map.get(h).neighbors.add(map.get(neighbour));

            }
        }
        return map.get(node);
    }


    HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph2(Node node) {
        map.put(node, new Node(node.val, new ArrayList<>()));

        for(Node neighbor: node.neighbors){
            if(map.containsKey(neighbor)){
                map.get(node).neighbors.add(map.get(neighbor));
            }else{
                map.get(node).neighbors.add(cloneGraph(neighbor));
            }
        }

        return map.get(node);
    }
}
