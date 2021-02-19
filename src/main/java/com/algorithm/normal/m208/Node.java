package com.algorithm.normal.m208;

import java.util.HashMap;
import java.util.Map;

/**
 * Node:
 *
 * @author sunchen
 * @date 2021/2/19 10:44 下午
 */
public class Node {
    /**
     * @var bool
     */
    public boolean isString;

    /**
     * @var Node[]
     */
    public Map<String, Node> next = new HashMap<>();
}
