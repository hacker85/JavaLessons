package interview;

public class CreateGenericClassLesson <T> {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException {
        Object object = getT(Object.class);
    }
    static <T> T getT(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        return clazz.newInstance();
    }

}
