package models;

import Requests.AuthenticationRequest;
import Requests.FeesRequest;
import Requests.InquiryRequest;
import Requests.PaymentRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shaft.api.RestActions;
import io.restassured.response.Response;
import enums.SERVICE;


public class Customer {
	  @JsonProperty("UserName") 
	    public String userName;
	    @JsonProperty("Password") 
	    public String password;
	    @JsonProperty("AccountID") 
	    public String accountID;
	    @JsonProperty("ChannelCategory") 
	    public String channelCategory;
	    @JsonProperty("ChannelType") 
	    public String channelType;
	    @JsonProperty("ChannelId") 
	    public String channelId;
	    @JsonProperty("LocalDate") 
	    public String localDate;
	    @JsonProperty("Version") 
	    public String version;
	    @JsonProperty("ServiceVersion") 
	    public String serviceVersion;
	    @JsonProperty("Longitude") 
	    public String longitude;
	    @JsonProperty("Latitude") 
	    public String latitude;

	public Customer(String userName, String password, String accountID, String channelCategory, String channelType, String channelId, String localDate, String version, String serviceVersion, String longitude, String latitude) {
		this.userName = userName;
		this.password = password;
		this.accountID = accountID;
		this.channelCategory = channelCategory;
		this.channelType = channelType;
		this.channelId = channelId;
		this.localDate =localDate;
		this.version = version;
		this.serviceVersion = serviceVersion;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	public String login()
	{
		AuthenticationRequest authenticationRequest = new AuthenticationRequest();
		Response resp= authenticationRequest.send(this);
		String token = RestActions.getResponseJSONValue(resp, "Token");
		return token;
	}
	public Response inquiry(String serviceId, InquiryBody inquiryBody) {
		InquiryRequest inquiryRequest= new InquiryRequest(serviceId,login());
		return inquiryRequest.send(inquiryBody);
	}
	public Integer getBrn(String serviceId, InquiryBody inquiryBody) {
		return Integer.valueOf(RestActions.getResponseJSONValue(inquiry(serviceId,inquiryBody), "Brn"));
	}
	public Response getFees(String serviceId,FeesBody feesBody) {
		FeesRequest feesRequest= new FeesRequest(serviceId,login());
		return feesRequest.send(feesBody);
	}
	public Response pay(String serviceId,PaymentBody paymentBody) {
		PaymentRequest paymentRequest= new PaymentRequest(serviceId,login());
		return paymentRequest.send(paymentBody);
	}
}
