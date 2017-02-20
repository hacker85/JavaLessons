package anotation;

import jdk.nashorn.internal.ir.annotations.Ignore;
import jdk.nashorn.internal.ir.annotations.Reference;

import javax.xml.ws.Action;
import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Ignore
public class AnotationLesson {
    @Ignore
    int i;
    @Ignore
    @Action
    @Deprecated
    public static void main(String[] args) {
        @Ignore
        int j;
    }
    //@Test(name = "test", run = false)
    @Test("test")
    //@Test(null)
    //@MyAnnotation
    @BugReport(reportedBy = {"one", "two"}, ref = @Reference())
    //@BugReport(reportedBy = "One")
    public @Ignore static void method(@Test("test") int i) {

    }
}


//class Annotation2 extends AnotationLesson {
//
//}

@Inherited
@Retention(RetentionPolicy.RUNTIME)
//@Target({ElementType.FIELD, ElementType.LOCAL_VARIABLE})
abstract @interface Test { //Annotation
    boolean run() default true;
    String value();
    //String name();
}

//@interface Test2 implements Test {
//
//}

class MyAnnotation implements Annotation {

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return Annotation.class;
    }
}

@interface BugReport {
    enum Status { UNCONFIRMED, CONFIRMED, FIXED, NOTABUG };
    boolean showStopper() default false;
    String assignedTo() default "[none]";
    String assigned2To() default "";
    //String assignedTo() default "[none]" + new String("");
    //String assignedTo() default null;
    int i() default 1 + 1;
    Class<?> testCase() default Void.class;
    Status status() default Status.UNCONFIRMED;
    Reference ref() default @Reference(); // an annotation type
    String[] reportedBy();
    //Object o();
}