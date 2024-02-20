//package com.bt.ms.im.repository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Repository;
//
//import com.bt.ms.im.annotation.ClientInfo;
//import com.bt.ms.im.config.AppConstants;
//import com.bt.ms.im.css.createequipmentorder.CreateEquipmentOrderClient;
//import com.bt.ms.im.css.createequipmentorder.entity.CreateEquipmentOrderRequest;
//import com.bt.ms.im.css.createequipmentorder.entity.CreateEquipmentOrderResponse;
//import com.bt.ms.im.entity.ResponseBean;
//
//
//
//@Repository
//public class BTSELRepositoryImpl implements BTSELRepository {
//
//	@Autowired
//	CreateEquipmentOrderClient equipmentClient;
////	
////	@Autowired
////	AppConstants appConstants;
////	
////	@Value("${excalibur.customer-v7.encoded.securityToken}")
////	String securityToken;
//	
//	@Override
//	@ClientInfo(clientSystem = "BTSEL", compTxnName = "CreateEquipmentOrder")
//	public ResponseBean<CreateEquipmentOrderResponse> createEquipmentOrder(CreateEquipmentOrderRequest request) {
//		System.out.println("HII");
//		CreateEquipmentOrderResponse productOrder = equipmentClient.createEquipmentOrder(request);
//		
//		return ResponseBean.of(productOrder);		
//		
//		}
//	}
//
//
