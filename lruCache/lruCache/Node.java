package lruCache.lruCache;

public class Node<K, V> {
    private K key;
    private V value;
    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    Node<K, V> next;
    Node<K,V> prev;

    public Node(K key, V value){
        this.key = key;
        this.value = value;
    }
}
