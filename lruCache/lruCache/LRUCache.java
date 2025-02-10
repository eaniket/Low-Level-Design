package lruCache.lruCache;

import java.util.concurrent.ConcurrentHashMap;

public class LRUCache<K, V> {
    private final int capacity;
    private final ConcurrentHashMap<K, Node<K, V>> cacheMap;
    private final Node<K, V> head;
    private final Node<K, V> tail;

    public LRUCache(int capacity){
        this.capacity = capacity;
        this.cacheMap = new ConcurrentHashMap<>(capacity);
        head = new Node<>(null, null);
        tail = new Node<>(null, null);

        head.next = tail;
        tail.prev = head;
    }

    public synchronized V get(K key){
        Node<K, V> node = cacheMap.get(key);
        if(node == null){
            return null;
        }
        moveToHead(node);
        return node.getValue();
    }

    public synchronized void put(K key, V value){
        Node<K, V> node = cacheMap.get(key);
        if(node != null){
            node.setValue(value);
            moveToHead(node);
        }else{
            node = new Node<>(key, value);
            cacheMap.put(key, node);
            addToHead(node);
            if(cacheMap.size() > capacity){
                Node<K, V> lastNode = tail.prev;
                removeNode(lastNode);
                cacheMap.remove(lastNode.getKey());
            }
        }
    }

    private void moveToHead(Node<K, V> node){
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Node<K, V> node){
        Node<K, V> nextToHead = head.next;
        head.next = node;
        node.next = nextToHead;
        nextToHead.prev = node;
        node.prev = head;
    }

    private void removeNode(Node<K, V> node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
