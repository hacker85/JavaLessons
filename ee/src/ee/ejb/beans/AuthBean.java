package ee.ejb.beans;

import javax.annotation.Resource;
import javax.annotation.security.DenyAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
//@DeclareRoles({"HR", "salesDpt"})
//@RolesAllowed({"root", "admin"})
//@RunAs("inventoryDpt")
public class AuthBean {
    @Resource
    private SessionContext context;
    @RolesAllowed("admin")
    public String sayHello() {
//        if(context.isCallerInRole("admin")) {
//            return "role";
//        }
//        if(context.getCallerPrincipal().getName().equals("admin")) {
//            return "princ";
//        }
        return "hello";
    }
//    @PermitAll
    @DenyAll
    public void permit() {
        System.out.println("permit");
    }
}
