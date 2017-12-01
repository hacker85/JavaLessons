package com.max.web.webconfig;

//@Configuration
//@EnableWebMvc
//@ComponentScan("com.max.web")
//@Import(SecurityConfig.class)
public class WebFlowConfig {//} extends AbstractFlowConfiguration {

//    @Autowired
//    private MyWebConfig myWebConfig;
//
//    @Bean
//    public FlowDefinitionRegistry flowRegistry() {
//        return getFlowDefinitionRegistryBuilder(flowBuilderServices())
//                .addFlowLocation("/WEB-INF/flows/hello-flow.xml", "helloFlow")
//                .addFlowLocation("/WEB-INF/flows/first-flow.xml", "firstFlow")
//                .build();
//    }
//
//    @Bean
//    public FlowExecutor flowExecutor() {
//        return getFlowExecutorBuilder(flowRegistry()).build();
//    }
//
//    @Bean
//    public FlowBuilderServices flowBuilderServices() {
//        return getFlowBuilderServicesBuilder().setViewFactoryCreator(mvcViewFactoryCreator()).setDevelopmentMode(true).build();
//    }
//
//    @Bean
//    public MvcViewFactoryCreator mvcViewFactoryCreator() {
//        MvcViewFactoryCreator factoryCreator = new MvcViewFactoryCreator();
//        factoryCreator.setViewResolvers(Collections.singletonList(myWebConfig.getViewResolver()));
//        factoryCreator.setUseSpringBeanBinding(true);
//        return factoryCreator;
//    }
//
//    @Bean
//    public FlowHandlerMapping flowHandlerMapping() {
//        FlowHandlerMapping handlerMapping = new FlowHandlerMapping();
//        handlerMapping.setOrder(-1);
//        handlerMapping.setFlowRegistry(flowRegistry());
//        return handlerMapping;
//    }
//
//    @Bean
//    public FlowHandlerAdapter flowHandlerAdapter() {
//        FlowHandlerAdapter handlerAdapter = new FlowHandlerAdapter();
//        handlerAdapter.setFlowExecutor(flowExecutor());
//        handlerAdapter.setSaveOutputToFlashScopeOnRedirect(true);
//        return handlerAdapter;
//    }
}