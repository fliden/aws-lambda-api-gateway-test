package com.fliden.g11n;

import com.jrestless.aws.gateway.GatewayFeature;
import com.jrestless.aws.gateway.handler.GatewayRequestObjectHandler;
import org.glassfish.jersey.server.ResourceConfig;

public class RequestHandler extends GatewayRequestObjectHandler {
    public RequestHandler() {
        // initialize the container with your resource configuration
        ResourceConfig config = new ResourceConfig()
                .register(GatewayFeature.class)
                .packages("com.fliden.g11n");
        init(config);
        // start the container
        start();
    }
}