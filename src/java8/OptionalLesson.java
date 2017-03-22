package java8;

import java.util.Optional;

public class OptionalLesson {
    public static void main(String[] args) {
        Optional<String> optional = getO();
        if(optional.isPresent()) {
            System.out.println(optional.get());
        }
    }
    static Optional<String> getO() {
        if(false){
            return Optional.of("Hello");
        }
        return Optional.empty();
    }
}
