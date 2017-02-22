package rmi;

import javax.naming.*;
import java.io.File;
import java.util.Properties;

public class JndiLesson {
    public static void main(String[] args) throws NamingException {
        String name = "/home/max/questions.txt";
        //String name = "/home/max/";

        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.fscontext.RefFSContextFactory");
        props.put(Context.PROVIDER_URL, "file:///");

        Context initialContext = new InitialContext(props);

        File obj = (File)initialContext.lookup(name);
        System.out.println(obj.getName());
        if (name.equals(""))
            System.out.println("Looked up the initial context");
        else
            System.out.println(name + " is bound to: " + obj);

        NamingEnumeration bindings = initialContext.listBindings("/home/");

        while (bindings.hasMore()) {
            Binding bd = (Binding)bindings.next();
            System.out.println(bd.getName() + ": " + bd.getObject());
        }
    }
}