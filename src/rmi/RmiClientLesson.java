package rmi;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NameClassPair;
import javax.naming.NamingException;
import java.rmi.RemoteException;
import java.util.Enumeration;

/**
 * Created by max on 2/20/17.
 */
public class RmiClientLesson {
    public static void main(String[] args) throws NamingException, RemoteException {
        Context context = new InitialContext();

        Enumeration<NameClassPair> e = context.list("rmi://localhost/");
        while (e.hasMoreElements())
            System.out.println(e.nextElement().getName());

        String url = "rmi://localhost/imath";
        IMath iMath = (IMath)context.lookup(url);
        int resutl = iMath.add(1, 2);
        System.out.println(resutl);
        System.out.println(iMath.getPerson().name);
    }
}
