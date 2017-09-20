package bestpractice;

//Throwable, Error, Exception, RuntimeException, IOException
//it’s best not to implement any new Error subclasses
//don't use Throwable, use Exception or RuntimeException
//use checked exceptions for conditions from which the caller can reasonably be expected to recover
//checked - when can restore //unchecked - when execution cad make more harm
//Use runtime exceptions to indicate programming errors //precondition violations

//A well-designed API must not force its clients to use exceptions for ordinary control flow //instead of error codes
//Cloneable //CloneNotSupportedException
//ask yourself how the programmer will handle the exception
public class CheckedVsUncheckedExceptions {
    public static void main(String[] args) throws Exception {
        CheckedVsUncheckedExceptions checkedVsUncheckedExceptions = new CheckedVsUncheckedExceptions();
        long time = System.currentTimeMillis();
        checkedVsUncheckedExceptions.doJob(10_000);
        System.out.println(System.currentTimeMillis() - time);
    }
    public void doJob(long l) throws Exception {
        if (l > 0) {
            l--;
            doJob(l);
        }
    }
}
