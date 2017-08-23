package ee.websockets;

public class CustomServerAppConfigProvider {//} implements ServerApplicationConfig {
//    @Override
//    public Set<ServerEndpointConfig> getEndpointConfigs(Set<Class<? extends Endpoint>> endpointClasses) {
//        Set<ServerEndpointConfig> result = new HashSet<>();
//        for (Class epClass : endpointClasses) {
//            //need to ignore Client endpoint class
//            if (epClass.equals(ProgrammaticEndpointLesson.class)) {
//                ServerEndpointConfig sec = ServerEndpointConfig.Builder.create(epClass, "/echo").build();
//                result.add(sec);
//            }
//        }
//        return result;
//    }
//    @Override
//    public Set<Class<?>> getAnnotatedEndpointClasses(Set<Class<?>> scanned) {
//        return Collections.emptySet();
//    }
}
