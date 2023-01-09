import java.util.Objects;
import java.util.function.BiConsumer;

public class HomeWork {
    public static void main(String[] args) {
        Pair<Integer,String> pair = Pair.of(100, "World");
        Pair<Integer,String> pair2 = Pair.of(100, "World");

        Integer i = pair.getFirst();
        String s = pair.getSecond();
        System.out.println(pair.getFirst()+" "+pair.getSecond());
        System.out.println(pair2.getFirst()+" "+ pair2.getSecond());
        System.out.println();

        boolean b1 = pair.equals(pair2);
        boolean b2 = pair.hashCode()== pair2.hashCode();

        System.out.println(b1+" "+ b2);

        pair.ifPresent((first, second) -> {
            System.out.println(first);
            System.out.println(second);
        });

    }
}
class Pair <K,V> {


    private final K first;
    private final V second;

    private static final Pair<?,?> EMPTY = new Pair<>(null, null);

    private Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }



    public static <K,V> Pair of(K first, V second){
        return new Pair(first, second);


    }
    public static<K,V> Pair<K,V> empty() {

        Pair<K,V> pair = (Pair<K,V>) EMPTY;
        return pair;
    }

    public K getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) &&
                Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    public void ifPresent(BiConsumer<? super K, ? super V> action) {
        if (first!= null && second!=null) {
            action.accept(first, second);
        }
    }
}
