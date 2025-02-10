package lruCache.lruCache;

public class LRUCacheDemo {
    public static void run(){
        LRUCache<Integer, String> lruCache = new LRUCache<>(3);

        System.out.println("Value of key_1: " + lruCache.get(1));
        
        lruCache.put(1, "Value 1");
        lruCache.put(2, "Value 2");
        lruCache.put(3, "Value 3");

        System.out.println("Value of key_1: " + lruCache.get(1));
        
        lruCache.put(4, "Value 4");
        System.out.println("Value of key_4: " + lruCache.get(4));

        lruCache.put(3, "Updated Value 3");
        System.out.println("Value of key_3: " + lruCache.get(3));
        System.out.println("Value of key_2: " + lruCache.get(2));

    }
    public static void main(String[] args) {
        run();
    }
}
