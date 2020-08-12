import java.time.LocalDateTime;

public class Request {
    Integer customerid;

    public Request(Integer customerid){
        this.customerid = customerid;
    }

    @Override
    public String toString() {
        return "CustomerId: " + this.customerid;
    }
}
