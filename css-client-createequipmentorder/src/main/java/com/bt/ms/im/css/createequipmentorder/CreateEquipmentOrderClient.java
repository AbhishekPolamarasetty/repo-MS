package com.bt.ms.im.css.createequipmentorder;

import java.io.IOException;
import java.util.Arrays;

import javax.xml.bind.JAXBElement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.oxm.XmlMappingException;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.SoapFaultClientException;
import org.springframework.ws.soap.client.core.SoapActionCallback;

//import com.bt.ms.im.css.createequipmentorder.entity.CssException;
import com.bt.ms.im.css.createequipmentorder.entity.Fault;
import com.bt.ms.im.css.createequipmentorder.entity.ObjectFactory;
import com.bt.ms.im.css.createequipmentorder.entity.CreateEquipmentOrderRequest;
import com.bt.ms.im.css.createequipmentorder.entity.CreateEquipmentOrderResponse;

@Component
@EnableConfigurationProperties(CreateEquipmentOrderProperties.class)
public class CreateEquipmentOrderClient extends WebServiceGatewaySupport {
	
	Logger log = LoggerFactory.getLogger(CreateEquipmentOrderClient.class);
	private CreateEquipmentOrderProperties properties;

	public CreateEquipmentOrderClient(CreateEquipmentOrderProperties createEquipmentOrderProperties) throws Exception {
		super();
		this.properties = createEquipmentOrderProperties;
		 Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan("com.bt.ms.im.css.createequipmentorder.entity");
        marshaller.afterPropertiesSet(); // Ensure marshaller is properly initialized

	        this.setMarshaller(marshaller);
	        this.setUnmarshaller(marshaller);
	}

	public CreateEquipmentOrderResponse createEquipmentOrder(
			CreateEquipmentOrderRequest message) {
		System.out.println("client hii");
		CreateEquipmentOrderRequest request = new CreateEquipmentOrderRequest();
		request.setMessage(message.getMessage());

		try {
			System.out.println("client hiiiii");
		@SuppressWarnings("unchecked")
		JAXBElement<CreateEquipmentOrderResponse> response = (JAXBElement<CreateEquipmentOrderResponse>) getWebServiceTemplate()
				.marshalSendAndReceive(this.properties.getService().getPath(),
						new ObjectFactory().createCreateEquipmentOrder(request),
						new SoapActionCallback(this.properties.getService().getCreateEquipmentOrderSoapAction()));
		System.out.println("client hiiiii before");
		return response.getValue();
		} catch (SoapFaultClientException soapFaultException) {
			System.out.println("client hii error");
			Fault fault = processFault(soapFaultException);

			/* throw new CssException(soapFaultException, fault); */
			throw new IllegalArgumentException();
		}
	}
	
	/**
	 * @param soapFaultException
	 * @return
	 */
	private Fault processFault(SoapFaultClientException soapFaultException) {

		Fault faultDetail = null;
		try {
			faultDetail = (Fault) getWebServiceTemplate().getUnmarshaller().unmarshal(
					soapFaultException.getSoapFault().getFaultDetail().getDetailEntries().next().getSource());
		
		} catch (XmlMappingException | IOException e) {
			StackTraceElement[] st = e.getStackTrace();
			log.error("Exception cathced at CreateEquipmentOrderClient :: occured on:: {}", Arrays.toString(st));
		}
		return faultDetail;
	}
}
