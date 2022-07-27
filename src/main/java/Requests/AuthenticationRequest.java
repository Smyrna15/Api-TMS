package Requests;

import io.restassured.response.Response;
import models.Customer;

public class AuthenticationRequest extends PostRequest{
    public AuthenticationRequest() {
        super("http://164.160.104.66:8080", "/api/accounts/6/authenticate");
    }
    public Response send(Customer body) {
        return super.send(body);
    }
}
