package anotation;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by max on 2/18/17.
 */
public class ScriptingLesson {
    public static void main(String[] args) throws ScriptException, NoSuchMethodException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        engine.put("k", 4);
        String scriptString = "var n = 1;" +
                "function f(a) {return a + 4;};" +
                "print('hello');" +
                "var q = 5;" +
                "1 + 2 + k;";
        Object result = engine.eval(scriptString);
        System.out.println(engine.get("q"));
        System.out.println(result);

        Object funcResult = ((Invocable)engine).invokeFunction("f", 1);
        System.out.println(funcResult);
    }
}
