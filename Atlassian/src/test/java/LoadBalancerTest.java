public class LoadBalancerTest {

    private LoadBalancer loadBalancer;

    public LoadBalancerTest(){
        loadBalancer = new LoadBalancer();
    }

    public boolean testAllRequestsWithinDelaySeconds(){
        //Input
        Request request = new Request(1);
        for(int i = 0; i < 10; i++){
            boolean result = loadBalancer.validCustomerRequest(request);
            if(!result){
                return false;
            }
        }
        return true;
    }

    public boolean test11thRequestWithinDelaySeconds(){
        //Input
        Request request = new Request(1);
        for(int i = 0; i < 11; i++){
            boolean result = loadBalancer.validCustomerRequest(request);
            if(!result){
                return true;
            }
        }
        return false;
    }

    public boolean test11thRequestOutsideDelaySeconds() throws InterruptedException {
        Request request = new Request(1);
        for(int i = 0; i < 10; i++){
            boolean result = loadBalancer.validCustomerRequest(request);
            if(!result){
                return false;
            }
        }
        //return true;
        Thread.sleep(12000);
        boolean finalResult = loadBalancer.validCustomerRequest(request);
        return finalResult;
    }



    public static void main(String[] args) throws InterruptedException {
        LoadBalancerTest loadBalancerTest = new LoadBalancerTest();
//        System.out.println(loadBalancerTest.testAllRequestsWithinDelaySeconds());
        System.out.println(loadBalancerTest.test11thRequestWithinDelaySeconds());
//        System.out.println(loadBalancerTest.test11thRequestOutsideDelaySeconds());
    }
}
