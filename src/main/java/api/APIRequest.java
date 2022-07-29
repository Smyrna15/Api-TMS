package api;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class APIRequest {
    protected String endPoint;
    protected Response response;
    protected Class ResponseClass;
    protected RequestSpecification request;

    public APIRequest(URI uri,String endPoint, Class responseClass) {
        RestAssured.baseURI = uri.get();
        this.endPoint = endPoint;
        ResponseClass = responseClass;
        request = RestAssured.given();
        request.contentType("application/json");
    }
    public void addHeader(String Header, String value) {
        request.header(Header, value);
    }

    public <ResponseClass> ResponseClass deserialize()
    {
        Gson gson = new Gson();
        String jsonString = this.response.getBody().asString();
        return (ResponseClass) gson.fromJson(jsonString, ResponseClass);
    }
    public int getStatusCode() {
        return response.getStatusCode();
    }
    public String getStatusCodeAsString() {
        return String.valueOf( getStatusCode());
    }
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
    public <ResponseClass> void shouldMatch(ResponseClass respBody)
    {
//        ReflectionAssert.assertReflectionEquals(respBody,deserialize());
    }
}
