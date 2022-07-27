package Requests;

import io.restassured.response.Response;
import models.InquiryBody;
import enums.SERVICE;

public class InquiryRequest extends PostRequest{
    public InquiryRequest(String serviceId, String token) {
        super("http://164.160.104.66:8080", "/api/services/"+serviceId+"/inquiry");
        addToken(token);
    }
    public Response send(InquiryBody body) {
        return super.send(body);
    }
}
