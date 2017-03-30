package ee;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class ResourcesServlet {
    @Resource(name="sdf")
    DataSource dataSource;
}
