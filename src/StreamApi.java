import java.awt.*;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamApi {
    public static void main(String[] args) {
        int [] arr = IntStream.iterate(1, n -> n+1)
                .map(n->n*n)
                .limit(20)
                .toArray();

        System.out.println(Arrays.toString(arr));


        Stream.generate(() -> Math.random())
                .limit(10 )
                .forEach(System.out::println);



      //  Stream.generate(->(int)Math.random())
        //         .limit(10)
          //      .forEach(System.out::println);

    }
}
