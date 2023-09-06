package com.abdm.discovery.clients;

import com.abdm.discovery.clients.model.Error;
import com.abdm.discovery.clients.model.ErrorCode;
import com.abdm.discovery.clients.model.ErrorRepresentation;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static com.abdm.discovery.clients.model.ErrorCode.INVALID_BRIDGE_SERVICE_REQUEST;
import static com.abdm.discovery.clients.model.ErrorCode.INVALID_CM_SERVICE_REQUEST;
import static com.abdm.discovery.clients.model.ErrorCode.TOO_MANY_REQUESTS_FOUND;
import static com.abdm.discovery.clients.model.ErrorCode.UNKNOWN_ERROR_OCCURRED;
import static java.lang.String.format;
import static org.springframework.http.HttpStatus;

@Getter
public class CustomClientException extends Throwable {
    private static final String CANNOT_PROCESS_REQUEST_TRY_LATER = "Cannot process the request at the moment, " +
            "please try later.";
    private final HttpStatus httpStatus;
    private final ErrorRepresentation error;

    public CustomClientException(HttpStatus httpStatus, ErrorRepresentation errorRepresentation) {
        this.httpStatus = httpStatus;
        this.error = errorRepresentation;
    }

    public static CustomClientException unableToConnect() {
        return internalServerError(CANNOT_PROCESS_REQUEST_TRY_LATER);
    }

    public static CustomClientException mappingNotFoundForId(String id) {
        return internalServerError(format("No mapping found for %s", id));
    }

    public static CustomClientException invalidRequest(String message) {
        return new CustomClientException(BAD_REQUEST, errorOf(message, UNKNOWN_ERROR_OCCURRED));
    }

    public static CustomClientException tooManyRequests() {
        return new CustomClientException(TOO_MANY_REQUESTS, errorOf("Too many requests found", TOO_MANY_REQUESTS_FOUND));
    }

    public static CustomClientException unauthorizedException(String message) {
        return new CustomClientException(UNAUTHORIZED, errorOf(message, UNKNOWN_ERROR_OCCURRED));
    }

    public static CustomClientException clientAlreadyExists(String message) {
        return new CustomClientException(CONFLICT, errorOf(message, UNKNOWN_ERROR_OCCURRED));
    }

    public static CustomClientException notFound(String message) {
        return new CustomClientException(NOT_FOUND, errorOf(message, UNKNOWN_ERROR_OCCURRED));
    }

    public static CustomClientException invalidBridgeRegistryRequest(String message) {
        return badBridgeRequest(message);
    }

    public static CustomClientException invalidConsentManagerRegistryRequest() {
        return badCMRequest("consent_manager suffix and url can't be empty");
    }

    public static ClientError invalidConsentManagerEntry() {
        return badCMRequest("can't register an inactive consent_manager");
    }

    public static ClientError invalidBridgeServiceRequest() {
        return badBridgeRequest("Can't be serviced by multiple bridges");
    }

    public static CustomClientException unknownErrorOccurred() {
        return internalServerError("Unknown error occurred");
    }

    public static CustomClientException serviceTypeNoAssignedToService() {
        return internalServerError("No service type found for the service");
    }

    private static CustomClientException internalServerException(String message) {
        return new CustomClientException(INTERNAL_SERVER_ERROR, errorOf(message, UNKNOWN_ERROR_OCCURRED));
    }

    private static CustomClientException badBridgeRequest(String message) {
        return new CustomClientException(BAD_REQUEST, errorOf(message, INVALID_BRIDGE_SERVICE_REQUEST));
    }

    private static CustomClientException badConsentManagerRequest(String message) {
        return new CustomClientException(BAD_REQUEST, errorOf(message, INVALID_CM_SERVICE_REQUEST));
    }

    private static ErrorRepresentation exceptionOf(String message, ErrorCode errorCode) {
        return new ErrorRepresentation(new Error(errorCode, message));
    }
}