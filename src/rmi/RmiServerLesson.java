package rmi;

import javax.naming.NamingException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by max on 2/20/17.
 */
public class RmiServerLesson {
    public static void main(String[] args) throws RemoteException, NamingException, InterruptedException, MalformedURLException, AlreadyBoundException {
        IMath iMath = new IMathImp();
        Naming.bind("imath", iMath);
//        Context context = new InitialContext();
//        context.bind("rmi:imath", iMath);
        //context.bind("rmi://localhost:1099/imath", iMath);
    }
}

interface IMath extends Remote {
    int add(int a, int b) throws RemoteException;
    Person getPerson() throws RemoteException;
}

class IMathImp extends UnicastRemoteObject implements IMath {

    public IMathImp() throws RemoteException {

    }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }

    @Override
    public Person getPerson() throws RemoteException {
        return new Person("Max");
    }
}

class Person implements Serializable {
    String name;
    Person(String name) {
        this.name = name;
    }
}