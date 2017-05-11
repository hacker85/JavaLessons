package ee.batch;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("MyProcessor")
public class MyProcessor implements javax.batch.api.chunk.ItemProcessor {
    public MyProcessor() {}
    @Override
    public Object processItem(Object obj) throws Exception {
        System.out.println("processor process item");
        String line = (String) obj;
        return line.toUpperCase();
    }
}
