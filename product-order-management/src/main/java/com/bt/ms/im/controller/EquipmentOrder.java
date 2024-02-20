package com.bt.ms.im.controller;

import org.springframework.beans.factory.annotation.Autowired;
//import org.apache.http.HttpStatus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bt.ms.im.css.createequipmentorder.entity.CreateEquipmentOrderRequest;
import com.bt.ms.im.entity.ProductOrderCreateRequest;
import com.bt.ms.im.entity.ResponseBean;
import com.bt.ms.im.service.EqipmentOrderService;
import com.bt.ms.im.util.RequestValidator;

@RestController
@RequestMapping("enterprise/v1/digitalMobileOrder")
public class EquipmentOrder {
	
	@Autowired
	private EqipmentOrderService equipmentorderservice;
	
	@Autowired
	private RequestValidator reqValidator;
	
	@PostMapping("/ProductOrder")
	public ResponseEntity<?> createAirportDetails(
			@RequestHeader(value= "APIGW-Tracking-Header", required=true) String apIGWTrackingHeader,
//			@RequestHeader(value = "accept", required = true) String acceptHeader,
			@RequestBody (required=false) ProductOrderCreateRequest productordercreaterequest) {
		reqValidator.validateTrackingHeader(apIGWTrackingHeader);
		reqValidator.validateRequestBody(productordercreaterequest);
		ResponseBean<CreateEquipmentOrderRequest> response = equipmentorderservice.updateequipmentorder(productordercreaterequest);
//		
//		if (response.isSuccess()) {
//			return ResponseEntity.status(HttpStatus.OK).body(response);
//		}else {
//			return null;
//		}
			//	    log.info("creating all airport details.");
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

//	private ResponseEntity<?> errorstoUpstream(ResponseBean<ProductOrder> response){
//		BaseResponse res = new BaseResponse();
//		
//		res.setCode(response.getCode());
//		res.setMessage(response.getMessage());
//	}
}
