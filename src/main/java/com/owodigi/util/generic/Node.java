package com.owodigi.util.generic;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public class Node<T> {
    public T val;
    public Node<T> next;

    public Node(T val) {
        this(val, null);
    }

    public Node(T val, Node<T> next) {
        this.val = val;
        this.next = next;
    }

    public static <T> Node<T> buildList(Iterator<String> iter, Function<String, T> f) {
        if (!iter.hasNext()) return null;
        String val = iter.next();
        Node<T> next = buildList(iter, f);
        return new Node<T>(f.apply(val), next);
    }

    public static List<String> splitWords(String s) {
        return s.isEmpty() ? List.of() : Arrays.asList(s.split(" "));
    }

    public static Node toLinkedList(final String value) {
        return buildList(splitWords(value).iterator(), Integer::parseInt);
    }
}
