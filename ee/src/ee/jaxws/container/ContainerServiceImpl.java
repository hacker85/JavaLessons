package ee.jaxws.container;

import javax.jws.WebService;

@WebService(endpointInterface = "ee.jaxws.container.ContainerService")
public class ContainerServiceImpl implements ContainerService {
    public String sayHello() {
        return "hello";
    }
}