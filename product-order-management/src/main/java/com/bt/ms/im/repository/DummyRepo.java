package com.bt.ms.im.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.bt.ms.im.config.AppConstants;
import com.bt.ms.im.css.createequipmentorder.entity.CreateEquipmentOrderRequest;
import com.bt.ms.im.entity.ProductOrderCreateRequest;
import com.bt.ms.im.entity.ResponseBean;
import com.bt.ms.im.entity.productorder.ProductOrder;
import com.bt.ms.im.mapper.RequestMapper;

@Repository
public class DummyRepo {
	@Autowired
	AppConstants app;

	@Autowired
	RequestMapper mapper;

	@Autowired
	RestTemplate restTemplate;

	public ResponseBean<CreateEquipmentOrderRequest> createEquipmentOrder(CreateEquipmentOrderRequest request) {

		// Make HTTP call to localhost:11478/api/v1/airports/id
		String url = "http://localhost:9800/cherry/cherry";
		CreateEquipmentOrderRequest response = restTemplate.postForObject(url, request,
				CreateEquipmentOrderRequest.class);

		return ResponseBean.of(response);
	}
}
