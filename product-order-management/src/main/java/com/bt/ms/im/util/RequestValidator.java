package com.bt.ms.im.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

import com.bt.ms.im.css.createequipmentorder.entity.Request;
import com.bt.ms.im.entity.ProductOrderCreateRequest;
import com.bt.ms.im.exception.StandardError;
import com.bt.ms.im.exception.handler.standardexception.BadRequestException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class RequestValidator {
	
	private final ObjectMapper objectMapper;
	
    public RequestValidator(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

	public void validateTrackingHeader(String apIGWTrackingHeader) {
		if (apIGWTrackingHeader == null) {
			StandardError errormsg = StandardError.ERR400_25;
			throw new BadRequestException(errormsg);
		}
		String regex = "^[a-z0-9-.:_]{1,256}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(apIGWTrackingHeader);
		boolean dncak = matcher.matches();

		if (!dncak) {
			StandardError errormsg = StandardError.ERR400_26;

			throw new BadRequestException(errormsg);
		}

	}
	public void validateRequestBody(Object requestBody) {
        if (requestBody == null) {
            StandardError errormsg = StandardError.ERR400_21;
            throw new BadRequestException(errormsg);
        }
        try {
            String json = objectMapper.writeValueAsString(requestBody);
            JsonNode jsonNode = objectMapper.readTree(json);
            // If parsing succeeds, the JSON is well-formed
        }catch (Exception e) {
            // If parsing fails, throw a BadRequestException with an appropriate error message
            throw new BadRequestException(StandardError.ERR400_22);
        }
 
    }
	

}
