package com.algorithm.normal.m208;

/**
 * Trie: 实现 Trie (前缀树)
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 *
 * @author sunchen
 * @date 2021/2/19 10:12 下午
 */
public class Trie {

    Node root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        this.root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node node = this.root;
        for (int i = 0; i < word.length(); i++) {
            String sub = word.substring(i, i + 1);
            if (node.next.get(sub) == null) {
                node.next.put(sub, new Node());
            }
            node = node.next.get(sub);
        }
        node.isString = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        Node node = searchPrefix(word);
        return node != null && node.isString;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    /**
     * 查找前缀节点
     *
     * @param prefix
     * @return Node|false
     */
    private Node searchPrefix(String prefix) {
        Node node = this.root;
        for (int i = 0; i < prefix.length(); i++) {
            String sub = prefix.substring(i, i + 1);
            if (node.next.get(sub) == null) {
                return null;
            }
            node = node.next.get(sub);
        }
        return node;
    }
}
