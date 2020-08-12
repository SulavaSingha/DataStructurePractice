import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class LoadBalancer {

    public static final int MAX_REQUESTS = 10;
    public static final int DELAY = 10;
    Map<Integer, Queue<LocalDateTime>> requestsPerCustomerId;


    public LoadBalancer(){
        requestsPerCustomerId = new HashMap<>();
    }

    // cust id 1 : 10 requests in 5 sec -> true
    // 10 requests in 11 sec -> true
    // 11 requests in 5 secs -> false


    public boolean validCustomerRequest(Request request){
        LocalDateTime currentRequestTimestamp = LocalDateTime.now();
        //customer id validation
        if(requestsPerCustomerId.containsKey(request.customerid)){
            Queue<LocalDateTime> requestTimeStamps = requestsPerCustomerId.get(request.customerid);
            LocalDateTime oldestTimestamp = requestTimeStamps.peek();

            if(MAX_REQUESTS < requestTimeStamps.size() + 1){
                Duration between = Duration.between(oldestTimestamp, currentRequestTimestamp);
                if(between.getSeconds() > DELAY) {
                    requestTimeStamps.remove();
                    requestTimeStamps.add(currentRequestTimestamp);
                    requestsPerCustomerId.put(request.customerid, requestTimeStamps);
                    return true;
                } else {
                    return false;
                }
            } else {
                requestTimeStamps.add(currentRequestTimestamp);
                requestsPerCustomerId.put(request.customerid, requestTimeStamps);
                return true;
            }
        } else {
            Queue<LocalDateTime> timestamps = new LinkedList<>();
            timestamps.add(currentRequestTimestamp);
            requestsPerCustomerId.put(request.customerid,timestamps);
            return true;
        }
    }

    public static void main(String[] args){

        Request request = new Request(1);
        LoadBalancer loadBalancer = new LoadBalancer();
        loadBalancer.validCustomerRequest(request);

        //Request
        //function
        //extract user from request
        //max requests per customer = 10;
        //hashmap<customer id, connectionReq>
    }
}
