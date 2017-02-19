package anotation;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.FileNotFoundException;

/**
 * Created by max on 2/19/17.
 */
public class ComileJavaLesson {
    public static void main(String[] args) throws FileNotFoundException {
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, "/home/max/Test.java");
        System.out.println(result);
    }
}
