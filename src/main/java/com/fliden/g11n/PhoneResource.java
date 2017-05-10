package com.fliden.g11n;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/g11n")
public class PhoneResource {
    @GET
    @Path("/v1/validate-phonenumber/{number}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response validate(
            @PathParam("number") String number) {
        PhoneNumUtil util = new PhoneNumUtil();
        boolean valid = util.isValid(number);
        if (valid) {
            return Response.ok(new ResultResponse("valid")).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity(new ResultResponse("invalid")).build();
        }
    }

    @GET
    @Path("/v1/format-phonenumber/{number}")
    @Produces({ MediaType.APPLICATION_JSON })
    public Response format(
            @PathParam("number") String number,
            @DefaultValue("INTERNATIONAL") @QueryParam("format") String format) {
        PhoneNumUtil util = new PhoneNumUtil();
        String formatted = util.getFormatted(number, format);
        if (formatted != null) {
            return Response.ok(new ResultResponse(formatted)).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity(new ResultResponse("invalid")).build();
        }
    }

    static class ResultResponse {
        private final String result;
        ResultResponse(String result) {
            this.result = result;
        }
        public String getResult() {
            return result;
        }
    }
}
