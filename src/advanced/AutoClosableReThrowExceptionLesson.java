package advanced;

public class AutoClosableReThrowExceptionLesson {
    public static void main(String[] args) {
        try ( RiverRaft raft = new RiverRaft(); ) {
            raft.crossRapid();
        }
        catch (Exception e) {
            System.out.println("Exception caught:" + e);
            Throwable[] exs = e.getSuppressed();
            for(Throwable ex : exs) {
                System.out.println(ex);
            }
        } finally {
            //raft
        }
    }
}

class RiverRaft implements AutoCloseable {
    public RiverRaft() throws Exception {
        System.out.println("Start raft");
//        throw new Exception("Cross Rapid constructor exception");
    }
    public void crossRapid() throws Exception {
        System.out.println("Cross rapid");
        throw new Exception("Cross Rapid exception");
    }
    public void close() throws Exception {
        System.out.println("Reach river bank");
        throw new Exception("Cross Rapid close exception");
    }
}