package com.networknt.petstore.handler;

import com.networknt.httpstring.AttachmentConstants;
import com.networknt.utility.Constants;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;

import java.util.Map;

/**
 * This is generated by the light-codegen
 */
public class OpenApiPathHandler implements HttpHandler {
    PetsGetHandler petsGetHandler = new PetsGetHandler();
    PetsPetIdGetHandler petsPetIdGetHandler = new PetsPetIdGetHandler();
    PetsPetIdDeleteHandler petsPetIdDeleteHandler = new PetsPetIdDeleteHandler();
    PetsPostHandler petsPostHandler = new PetsPostHandler();

    @Override
    public void handleRequest(HttpServerExchange exchange) throws Exception {
        Map<String, Object> auditInfo = exchange.getAttachment(AttachmentConstants.AUDIT_INFO);
        String endpoint = (String)auditInfo.get(Constants.ENDPOINT_STRING);
        switch(endpoint) {
            case "/pets@get":
                petsGetHandler.handleRequest(exchange);
                break;
            case "/pets/{petId}@get":
                petsPetIdGetHandler.handleRequest(exchange);
                break;
            case "/pets@post":
                petsPostHandler.handleRequest(exchange);
                break;
            case "/pets/{petId}@delete":
                petsPetIdDeleteHandler.handleRequest(exchange);
                break;
            default:
                throw new Exception(String.format("Unsupported endpoint %s", endpoint));
        }
    }
}
