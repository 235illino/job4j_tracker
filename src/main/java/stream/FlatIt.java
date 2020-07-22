package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class FlatIt {
    public static List<Integer> flatten(Iterator<Iterator<Integer>> it) {

        Spliterator<Iterator<Integer>> spliterator = Spliterators.spliteratorUnknownSize(it, Spliterator.SIZED);
        return StreamSupport.stream(spliterator, false)
                .flatMap(iterator -> StreamSupport.stream(Spliterators.spliteratorUnknownSize(iterator, Spliterator.SIZED), false))
                .collect(Collectors.toList());
    }
}
