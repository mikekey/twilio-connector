
package org.mule.module.twilio.processors;

import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.processor.MessageProcessor;
import org.mule.devkit.processor.DevkitBasedMessageProcessor;
import org.mule.module.twilio.TwilioConnector;
import org.mule.module.twilio.adapters.TwilioConnectorHttpCallbackAdapter;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * GetAvailablePhoneNumbersMessageProcessor invokes the {@link org.mule.module.twilio.TwilioConnector#getAvailablePhoneNumbers(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String)} method in {@link TwilioConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-M4", date = "2014-04-11T08:52:14-05:00", comments = "Build M4.1875.17b58a3")
public class GetAvailablePhoneNumbersMessageProcessor
    extends DevkitBasedMessageProcessor
    implements MessageProcessor
{

    protected Object accountSid;
    protected String _accountSidType;
    protected Object isoCountryCode;
    protected String _isoCountryCodeType;
    protected Object areaCode;
    protected String _areaCodeType;
    protected Object contains;
    protected String _containsType;
    protected Object inRegion;
    protected String _inRegionType;
    protected Object inPostalCode;
    protected String _inPostalCodeType;

    public GetAvailablePhoneNumbersMessageProcessor(String operationName) {
        super(operationName);
    }

    /**
     * Obtains the expression manager from the Mule context and initialises the connector. If a target object  has not been set already it will search the Mule registry for a default one.
     * 
     * @throws InitialisationException
     */
    public void initialise()
        throws InitialisationException
    {
    }

    @Override
    public void start()
        throws MuleException
    {
        super.start();
    }

    @Override
    public void stop()
        throws MuleException
    {
        super.stop();
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    /**
     * Sets accountSid
     * 
     * @param value Value to set
     */
    public void setAccountSid(Object value) {
        this.accountSid = value;
    }

    /**
     * Sets areaCode
     * 
     * @param value Value to set
     */
    public void setAreaCode(Object value) {
        this.areaCode = value;
    }

    /**
     * Sets inPostalCode
     * 
     * @param value Value to set
     */
    public void setInPostalCode(Object value) {
        this.inPostalCode = value;
    }

    /**
     * Sets contains
     * 
     * @param value Value to set
     */
    public void setContains(Object value) {
        this.contains = value;
    }

    /**
     * Sets isoCountryCode
     * 
     * @param value Value to set
     */
    public void setIsoCountryCode(Object value) {
        this.isoCountryCode = value;
    }

    /**
     * Sets inRegion
     * 
     * @param value Value to set
     */
    public void setInRegion(Object value) {
        this.inRegion = value;
    }

    /**
     * Invokes the MessageProcessor.
     * 
     * @param event MuleEvent to be processed
     * @throws Exception
     */
    public MuleEvent doProcess(final MuleEvent event)
        throws Exception
    {
        Object moduleObject = null;
        try {
            moduleObject = findOrCreate(TwilioConnectorHttpCallbackAdapter.class, false, event);
            final String _transformedAccountSid = ((String) evaluateAndTransform(getMuleContext(), event, GetAvailablePhoneNumbersMessageProcessor.class.getDeclaredField("_accountSidType").getGenericType(), null, accountSid));
            final String _transformedIsoCountryCode = ((String) evaluateAndTransform(getMuleContext(), event, GetAvailablePhoneNumbersMessageProcessor.class.getDeclaredField("_isoCountryCodeType").getGenericType(), null, isoCountryCode));
            final String _transformedAreaCode = ((String) evaluateAndTransform(getMuleContext(), event, GetAvailablePhoneNumbersMessageProcessor.class.getDeclaredField("_areaCodeType").getGenericType(), null, areaCode));
            final String _transformedContains = ((String) evaluateAndTransform(getMuleContext(), event, GetAvailablePhoneNumbersMessageProcessor.class.getDeclaredField("_containsType").getGenericType(), null, contains));
            final String _transformedInRegion = ((String) evaluateAndTransform(getMuleContext(), event, GetAvailablePhoneNumbersMessageProcessor.class.getDeclaredField("_inRegionType").getGenericType(), null, inRegion));
            final String _transformedInPostalCode = ((String) evaluateAndTransform(getMuleContext(), event, GetAvailablePhoneNumbersMessageProcessor.class.getDeclaredField("_inPostalCodeType").getGenericType(), null, inPostalCode));
            Object resultPayload;
            ProcessTemplate<Object, Object> processTemplate = ((ProcessAdapter<Object> ) moduleObject).getProcessTemplate();
            resultPayload = processTemplate.execute(new ProcessCallback<Object,Object>() {


                public List<Class<? extends Exception>> getManagedExceptions() {
                    return null;
                }

                public boolean isProtected() {
                    return false;
                }

                public Object process(Object object)
                    throws Exception
                {
                    return ((TwilioConnector) object).getAvailablePhoneNumbers(_transformedAccountSid, _transformedIsoCountryCode, _transformedAreaCode, _transformedContains, _transformedInRegion, _transformedInPostalCode);
                }

            }
            , this, event);
            event.getMessage().setPayload(resultPayload);
            return event;
        } catch (Exception e) {
            throw e;
        }
    }

}
