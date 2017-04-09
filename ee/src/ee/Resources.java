package ee;

import javax.annotation.Resource;
import javax.sql.DataSource;

public class Resources {
    @Resource(name="test")
    DataSource dataSource;
}
