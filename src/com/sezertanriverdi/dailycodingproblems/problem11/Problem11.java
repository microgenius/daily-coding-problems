package com.sezertanriverdi.dailycodingproblems.problem11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Problem11 {
    /**
     * Good morning! Here's your coding interview problem for today.
     *
     * This problem was asked by Twitter.
     *
     * Implement an autocomplete system. That is, given a query string s and a set of all possible query strings,
     * return all strings in the set that have s as a prefix.
     *
     * For example, given the query string de and the set of strings [dog, deer, deal], return [deer, deal].
     *
     * Hint: Try preprocessing the dictionary into a more efficient data structure to speed up queries.
     *
     * https://youtu.be/wjWSfRfiiIs
     * Trie Search
     */

    public static void main(String[] args) {
        String query = "de";
        String[] words = {"dog", "deer", "deal", "deny"};

        final List<String> autoCompleteSuggestions = Arrays.stream(words)
            .filter(word -> word.startsWith(query))
            .collect(Collectors.toList());

        System.out.println(String.join(",", autoCompleteSuggestions));

        final TrieSearch trieSearch = new TrieSearch();
        trieSearch.insert("dog");
        trieSearch.insert("deer");
        trieSearch.insert("deal");
        trieSearch.insert("deny");

        final List<String> autoCompleteSuggestions2 = trieSearch.autocomplete("dee");
        System.out.println(String.join(",", autoCompleteSuggestions2));
    }

    public static class TrieSearch {
        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode currentNode = root;
            for (final char c : word.toCharArray()) {
                final TrieNode trieNode = currentNode.children.stream()
                    .filter(node -> node.value == c)
                    .findFirst().orElse(null);

                if (trieNode == null) {
                    final TrieNode newNode = new TrieNode();
                    newNode.value = c;
                    currentNode.children.add(newNode);

                    currentNode = newNode;
                } else {
                    currentNode = trieNode;
                }
            }

            currentNode.isEnd = true;
        }

        // de - d - da
        public List<String> autocomplete(String query) {
            TrieNode currentNode = root;
            for (final char c : query.toCharArray()) {
                final TrieNode trieNode = currentNode.children.stream()
                    .filter(node -> node.value == c)
                    .findFirst().orElse(null);
                if (trieNode == null) {
                    return Collections.emptyList();
                }

                currentNode = trieNode;
            }

            List<String> result = new ArrayList<>();
            populateResultList(result, currentNode, query);

            return result;
        }

        private void populateResultList(final List<String> result, final TrieNode currentNode, final String query) {
            if (currentNode == null) {
                return;
            }

            if (currentNode.isEnd) {
                result.add(query);
            }

            for (final TrieNode child : currentNode.children) {
                populateResultList(result, child, query + child.value);
            }
        }
    }

    public static class TrieNode {
        public char value;
        public List<TrieNode> children = new ArrayList<>();
        public boolean isEnd;
    }
}
