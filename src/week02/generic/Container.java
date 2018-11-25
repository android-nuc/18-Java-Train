package week02.generic;


/**
 * 定义一个泛型类,K和V在类中的任何地方都能使用
 *
 * @param <K>
 * @param <V>
 */
public class Container<K, V> {
    private K key;
    private V value;


    public Container(K k, V v) {
        this.key = k;
        this.value = v;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public static void main(String[] args) {
        Container<String, String> c1 = new Container<String, String>("bao", "20");
        Container<String, Integer> c2 = new Container<>("wang", 20);
        System.out.println(c1.getKey() + ":" + c1.getValue());
        System.out.println(c2.getKey() + ":" + c2.getValue());

    }
}
