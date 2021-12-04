package com.sezertanriverdi.dailycodingproblems.problem3;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Problem3 {
    /**
     *Good morning! Here's your coding interview problem for today.
     *
     * This problem was asked by Google.
     *
     * Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, and deserialize(s), which deserializes the string back into the tree.
     *
     * For example, given the following Node class
     *
     * class Node:
     *     def __init__(self, val, left=None, right=None):
     *         self.val = val
     *         self.left = left
     *         self.right = right
     * The following test should pass:
     *
     * node = Node('root', Node('left', Node('left.left')), Node('right'))
     * assert deserialize(serialize(node)).left.left.val == 'left.left'
     *
     */

    public static void main(String[] args) {
        final Node root = new Node("root", new Node("left", new Node("left.left")), new Node("right"));

        final String serializedRootString = serialize(root);
        // root#left#left.left#NONE#NONE#NONE#right#NONE#NONE#
        System.out.println(serializedRootString);

        final Node deserializedNode = deserialize(serializedRootString);
        assert deserializedNode.left.left.val.equals(root.left.left.val);
    }

    public static class Node {
        public String val;
        public Node left;
        public Node right;

        public Node(String val) {
            this.val = val;
        }

        public Node(String val, Node left) {
            this.val = val;
            this.left = left;
        }

        public Node(String val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static String serialize(Node node) {
        if (node == null) {
            return "NONE#";
        }

        final StringBuilder serializedString = new StringBuilder(node.val).append("#");
        serializedString.append(serialize(node.left));
        serializedString.append(serialize(node.right));
        return serializedString.toString();
    }

    // root # left # left.left # NONE # NONE # NONE # right # NONE # NONE #

    public static Node deserialize(String serializedString) {
        final String[] elementsOfTree = serializedString.split("#");
        final Queue<String> elementsQueue = new LinkedList<>(
            Arrays.asList(elementsOfTree)
        );

        final String first = elementsQueue.poll();
        final Node node = new Node(first);
        node.left = deserialize(elementsQueue);
        node.right = deserialize(elementsQueue);

        return node;
    }

    // left.left # NONE # NONE # NONE # right # NONE # NONE #

    public static Node deserialize(Queue<String> elementsOfTree) {
        if (elementsOfTree.peek() == null) {
            return null;
        }

        final String element = elementsOfTree.poll();
        if ("NONE".equals(element)) {
            return null;
        }

        final Node node = new Node(element);
        node.left = deserialize(elementsOfTree);
        node.right = deserialize(elementsOfTree);
        return node;
    }
}
