package security;

import java.security.Permission;

/**
 * Created by max on 2/16/17.
 */
public class MyPermission extends Permission {

    private String action;

    public MyPermission(String action) {
        super(action);
        this.action = action;
    }

    @Override
    public boolean implies(Permission permission) {
        return false;
//        if(!(permission instanceof MyPermission)) {
//            return false;
//        }
//        if(!getName().equals("php")) {
//            return true;
//        } else if(action.equals("use")) {
//            MyPermission myPermission = (MyPermission) permission;
//            if(myPermission.action.equals("use")) {
//                return true;
//            }
//        }
//        return false;
    }

    @Override
    public String getActions() {
        return this.action;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyPermission that = (MyPermission) o;

        return action != null ? action.equals(that.action) : that.action == null;
    }

    @Override
    public int hashCode() {
        return action != null ? action.hashCode() : 0;
    }
}
