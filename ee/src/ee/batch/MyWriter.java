package ee.batch;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import java.io.BufferedWriter;
import java.io.Serializable;
import java.util.List;

@Dependent
@Named("MyWriter")
public class MyWriter implements javax.batch.api.chunk.ItemWriter {
    private BufferedWriter bwriter;
//    @Inject
//    private JobContext jobCtx;

    @Override
    public void open(Serializable ckpt) throws Exception {
//        String fileName = jobCtx.getProperties()
//                .getProperty("output_file");
//        bwriter = new BufferedWriter(new FileWriter(fileName,
//                (ckpt != null)));
    }

    @Override
    public void close() throws Exception {
        bwriter.close();
    }

    @Override
    public void writeItems(List<Object> items) throws Exception {
        for (int i = 0; i < items.size(); i++) {
            String line = (String) items.get(i);
            bwriter.write(line);
            bwriter.newLine();
        }
    }

    @Override
    public Serializable checkpointInfo() throws Exception {
        return new MyCheckpoint();
    }
}

