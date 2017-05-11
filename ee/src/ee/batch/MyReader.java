package ee.batch;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.io.BufferedReader;
import java.io.Serializable;

@Dependent
@Named("MyReader")
public class MyReader implements javax.batch.api.chunk.ItemReader {
    private MyCheckpoint checkpoint;
    private BufferedReader breader;
//    @Inject
//    JobContext jobCtx;
    public MyReader() {}
    @Override
    public void open(Serializable ckpt) throws Exception {
        System.out.println("open read");
        if (ckpt == null)
            checkpoint = new MyCheckpoint();
        else
            checkpoint = (MyCheckpoint) ckpt;
//        String fileName = jobCtx.getProperties()
//                .getProperty("input_file");
//        breader = new BufferedReader(new FileReader(fileName));
//        for (long i = 0; i < checkpoint.getLineNum(); i++)
//            breader.readLine();
    }
    @Override
    public void close() throws Exception {
        System.out.println("open close");
        breader.close();
    }
    @Override
    public Object readItem() throws Exception {
        System.out.println("open read item");
        String line = breader.readLine();
        return line;
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        System.out.println("open checpoint info");
        return null;
    }
}
