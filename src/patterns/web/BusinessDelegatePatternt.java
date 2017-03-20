package patterns.web;

public class BusinessDelegatePatternt {
    public static void main(String[] args) {
        //Collections.unmodifiableList(new ArrayList<>());
        BusinessDelegate businessDelegate = new BusinessDelegate();
        businessDelegate.doTask("EJB");
        businessDelegate.doTask("JMS");
    }
}

interface BusinessService {
    void doJob();
}
class EJBBusinessService implements BusinessService {
    @Override
    public void doJob() {
        System.out.println("do ejb job");
    }
}
class JMSBusinessService implements BusinessService {
    @Override
    public void doJob() {
        System.out.println("do jms job");
    }
}
class BusinessLookup {
    BusinessService getBusinessService(String serviceType) {
        if(serviceType.equals("ejb")) {
            return new EJBBusinessService();
        } else {
            return new JMSBusinessService();
        }
    }
}
class BusinessDelegate {
    BusinessLookup businessLookup = new BusinessLookup();
    BusinessService businessService;
    void doTask(String serviceType) {
        businessService = businessLookup.getBusinessService(serviceType);
        businessService.doJob();
    }
}
