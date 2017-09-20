package bestpractice;

//use serialization carefully
//it's difficult to change after release
//serialization don't run constructor
//if class design for inheritance it should't implement serializable
//don't use it on inner classes, anonymous, local, but static is ok
//use UID
//don't use Serialization on singletons
public class UseSerializableJudiciously {
    private static final long serialVersionUID = 1;
    UseSerializableJudiciously INSTANCE;
    private Object readResolve() {
        return INSTANCE;
    }
}