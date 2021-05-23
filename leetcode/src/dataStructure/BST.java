package dataStructure;

import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BST<E extends Comparable<E>> {
    public class Node {
        public E e;
        public Node left, right;
        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }
    }
    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public int size() {
        return size;
    }
    //向二分搜索树添加元素
    public void add(E e) {
//        if(root == null) {
//            root = new Node(e);
//            size++;
//        } else {
//            add(root, e);
//        }
        root = add(root, e);
    }
    //向以node为根的二分搜索树添加元素e
    private Node add(Node node, E e) {
//        if(e.equals(node.e)) {
//            return;
//        }
//         else if(e.compareTo(node.e) < 0 && node.left == null) {
//             node.left = new Node(e);
//             size++;
//        } else if(e.compareTo(node.e) > 0 && node.right == null) {
//             node.right = new Node(e);
//             size++;
//        }
//         if(e.compareTo(node.e) < 0) {
//             add(node.left, e);
//         } else if(e.compareTo(node.e) > 0) {
//             add(node.right, e);
//         }

        if(node == null) {
            size++;
            return new Node(e);
        } else if(e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if(e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    //看二分搜索树中是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if(node == null) return false;
        if(e.compareTo(node.e) == 0) {
            return true;
        } else if(e.compareTo(node.e) < 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    //二分搜索树的最小元素
    public E minimum() {
        if(size == 0) {
            throw new IllegalArgumentException("bst is empty");
        }
        return minimum(root).e;
    }
    //返回以node为根的二分搜索的最小的节点
    public Node minimum(Node node) {
        if(node.left == null) {
            return node;
        }
        return minimum(node.left);
    }

    //二分搜索树的最大元素
    public E maxmum() {
        if(size == 0) {
            throw new IllegalArgumentException("bst is empty");
        }
        return maxmum(root).e;
    }

    //返回以node为根的二分搜索树最小的节点
    public Node maxmum(Node node) {
        if(node.right == null) {
            return node;
        }
        return maxmum(node.right);
    }
    //二叉树的中序遍历
    public List<E> inorder() {
        List<E> res = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        while(root != null || !stack.empty()) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.e);
            root = root.right;
        }
        return res;
    }

    //二分搜索树的层序遍历
    public List<List<E>> levelOrder() {
        List<List<E>> res = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            List<E> level = new ArrayList();
            int qLen = queue.size();
            for(int i = 0; i < qLen; i++) {
                Node cur = queue.remove();
                level.add(cur.e);
                if(cur.left != null) queue.add(cur.left);
                if(cur.right != null) queue.add(cur.right);
            }
            res.add(new ArrayList<>(level));
        }
        return res;

    }
    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        for(int i = 0; i < 5; i++) {
            bst.add(i * 2);
        }
        System.out.println(bst.inorder());
        System.out.println(bst.minimum());
    }
}
