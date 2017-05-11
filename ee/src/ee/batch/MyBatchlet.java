package ee.batch;

import javax.enterprise.context.Dependent;
import javax.inject.Named;

@Dependent
@Named("MyBatchlet")
public class MyBatchlet implements javax.batch.api.Batchlet {
//    @Inject
//    private JobContext jobCtx;
    @Override
    public String process() throws Exception {
        System.out.println("batchlet process");
//        String fileName = jobCtx.getProperties()
//                .getProperty("output_file");
//        System.out.println(""+(new File(fileName)).length());
        return "COMPLETED";
    }

    @Override
    public void stop() throws Exception {
        System.out.println("batchlet stop");
    }
}