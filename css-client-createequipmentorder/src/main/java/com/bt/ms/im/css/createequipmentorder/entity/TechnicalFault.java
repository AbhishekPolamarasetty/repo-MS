
package com.bt.ms.im.css.createequipmentorder.entity;

import javax.xml.ws.WebFault;


/**
 * List of Technical Fault codes applicable for EquipmentOrder.
 *                                         COMPOSITE_SERVICE_LOAD_ERROR - Unable to load composite service,
 *                                         FILE_NOT_FOUND_ERROR - File {0} not found in the classpath,
 *                                         INVALID_CONFIGURATION - {0} configuration is not provided or is invalid,
 *                                         OPERATION_NOT_FOUND     - If operation is not defined in configuration xml,
 *                                         STREAM_READ_ERROR - Unable to read from stream,
 *                                         STREAM_WRITE_ERROR - Unable to write to stream,
 *                                         XML_PARSE_ERROR - XML parse error,
 *                                         XML_PARSER_CONFIG_ERROR - XML parser configuration error,
 *                                         XML_TRANSFORM_CONFIG_ERROR - XML transformation configuration error,
 *                                         XML_TRANSFORM_ERROR     - XML transformation failed,
 *                                         XPATH_COMPILE_ERROR     - XPATH compilation failed for XPATH - {0},
 *                                         XPATH_EVALUATION_ERROR - XPATH evaluation failed for XPATH - {0},
 *                                         INVALID_URL     - Invalid URL - {0},
 *                                         CONNECTION_ERROR - Connection failed to URL - {0},
 *                                         UNMARSHAL_ERROR - Unable to map XML to a Java object,
 *                                         MARSHAL_ERROR - Unable to map Java object to an XML,
 *                                         SERVICE_INVOCATION_FAILED - Service invocation failed on URL - {0},				
 * 										SERVICE_EXECUTION_ERROR - Service Execution Error(Thrown from composite for any uncategorised error)
 *                                                                 - {%s}(Rethrown from downstream)
 * 										BACKEND_CONNECTION_FAILED - Adapter connectivity Failed
 *                                 
 *
 * This class was generated by Apache CXF 3.4.3
 * 2021-04-20T19:51:25.308+05:30
 * Generated source version: 3.4.3
 */

@WebFault(name = "technicalException", targetNamespace = "http://www.ee.co.uk/common/message/TechnicalException/v1.0")
public class TechnicalFault extends Exception {

    private com.bt.ms.im.css.createequipmentorder.entity.TechnicalException faultInfo;

    public TechnicalFault() {
        super();
    }

    public TechnicalFault(String message) {
        super(message);
    }

    public TechnicalFault(String message, java.lang.Throwable cause) {
        super(message, cause);
    }

    public TechnicalFault(String message, com.bt.ms.im.css.createequipmentorder.entity.TechnicalException technicalException) {
        super(message);
        this.faultInfo = technicalException;
    }

    public TechnicalFault(String message, com.bt.ms.im.css.createequipmentorder.entity.TechnicalException technicalException, java.lang.Throwable cause) {
        super(message, cause);
        this.faultInfo = technicalException;
    }

    public com.bt.ms.im.css.createequipmentorder.entity.TechnicalException getFaultInfo() {
        return this.faultInfo;
    }
}
