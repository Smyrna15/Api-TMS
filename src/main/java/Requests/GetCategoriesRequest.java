package Requests;

import api.GetRequest;
import api.URI;
import models.GetCategoriesResponse;

public class GetCategoriesRequest extends GetRequest {
    public GetCategoriesRequest() {
        super(new URI("https://momkn-test.mkn.com/gateway/"), "api/v2/categories/0", GetCategoriesResponse.class);
    }
    public static void main (String [] args )
    {
        GetCategoriesRequest getCategoriesRequest= new GetCategoriesRequest();
        getCategoriesRequest.addHeader("Authorization","Bearer eyJhbGciOiJSUzI1NiIsImtpZCI6IjJDRTM4MTg4RjYyMEU0NjVFQUUwMjVDMjYxNzM3MzIxIiwidHlwIjoiYXQrand0In0.eyJuYmYiOjE2NTkxMDAyNzIsImV4cCI6MTY1OTE4NjY3MiwiaXNzIjoiaHR0cDovLzEwLjkwLjMuMjAxOjgwMjAiLCJhdWQiOiJ0bXNBcGkiLCJjbGllbnRfaWQiOiJ0bXNfMTIzIiwic3ViIjoidG1zX3N1YiIsImF1dGhfdGltZSI6MTY1OTEwMDI3MiwiaWRwIjoibG9jYWwiLCJodHRwOi8vc2NoZW1hcy54bWxzb2FwLm9yZy93cy8yMDA1LzA1L2lkZW50aXR5L2NsYWltcy9uYW1lIjoiMjIzMDciLCJhY2NvdW50X3Byb2ZpbGVfaWQiOiIxMCIsImFjY291bnRfaWQiOiI2IiwianRpIjoiMjRBNkQ3QzU0N0EwOTk4RThBMkY4QkNFQTkxMzRFMDgiLCJpYXQiOjE2NTkxMDAyNzIsInNjb3BlIjpbInRtc0FwaS5yZWFkIl0sImFtciI6WyJ0bXNfcG9zIl19.WSXCYJecivdvcN_cA2LNgFCrWU3di6uIKDegJGDSeQp8kLGR2kgEk1JDkDcffT1YiTf477Z2Gm8lKg5utFkGNG80-kKCfLexj5J8QHkB1yXP8Mk4qPaFw3MejIKBh-rt6RnIdjPuHPxjnNpmYXXdb_QewO6CNAbaB5h9ZbKuQCtGeRzijKdRMs1XwsyTHWLs7e7V9lRz-f-kMgXQlm_FTeDMUKuZLdonT6J8ZwCzZ4u-M0ESsiVptIsaWE6H3mP701zmngJwbJmRO2476tvcZIOtew5O2eU4onmMw0ZtEVQr0IKmVi2DmhwHmUJwuR5_fpNJyp7hjLybGoFgjEH9hw");
        getCategoriesRequest.send().prettyPrint();
    }
}
