package lombok;

public class ConstructorsLesson {
    public static void main(String[] args) {
        LombokStudent lombokStudent = new LombokStudent();
        LombokStudent lombokStudent3 = new LombokStudent("Max");
        LombokStudent lombokStudent4 = new LombokStudent(22, "Max");
    }
    @NoArgsConstructor
    @RequiredArgsConstructor
    @AllArgsConstructor
    static class LombokStudent {
        int age;
        @NonNull
        String name;
    }
}
