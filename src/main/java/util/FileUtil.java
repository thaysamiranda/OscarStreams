package util;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileUtil<T> {

    private final Stream<String> streamString;

    public FileUtil (Stream<String> streamString) {
        this.streamString = streamString;
    }

    public List<T> readStream(Function<String, T> mapper) {
        return streamString.skip(1)
                .map(mapper)
                .collect(Collectors.toList());
    }
}
