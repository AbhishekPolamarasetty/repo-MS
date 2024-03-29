
package com.bt.ms.im.css.createequipmentorder.entity;

import javax.xml.ws.WebFault;


/**
 * N/A
 *
 * This class was generated by Apache CXF 3.4.3
 * 2021-04-20T19:51:25.319+05:30
 * Generated source version: 3.4.3
 */

@WebFault(name = "businessException", targetNamespace = "http://www.ee.co.uk/common/message/BusinessException/v1.0")
public class BusinessFault extends Exception {

    private com.bt.ms.im.css.createequipmentorder.entity.BusinessException faultInfo;

    public BusinessFault() {
        super();
    }

    public BusinessFault(String message) {
        super(message);
    }

    public BusinessFault(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public BusinessFault(String message, com.bt.ms.im.css.createequipmentorder.entity.BusinessException businessException) {
        super(message);
        this.faultInfo = businessException;
    }

    public BusinessFault(String message, com.bt.ms.im.css.createequipmentorder.entity.BusinessException businessException, java.lang.Throwable cause) {
        super(message, cause);
        this.faultInfo = businessException;
    }

    public com.bt.ms.im.css.createequipmentorder.entity.BusinessException getFaultInfo() {
        return this.faultInfo;
    }
}
