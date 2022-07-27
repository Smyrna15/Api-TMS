package Requests;

import io.restassured.response.Response;
import models.FeesBody;
import enums.SERVICE;


public class FeesRequest extends PostRequest{
    public FeesRequest(String serviceId, String token) {
        super("http://164.160.104.66:8080", "/api/services/"+serviceId+"/fees");
        addToken(token);
    }
    public Response send(FeesBody body) {
        return super.send(body);
    }
}
