
package org.mule.module.twilio.processors;

import java.util.List;
import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleException;
import org.mule.api.callback.HttpCallback;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.lifecycle.InitialisationException;
import org.mule.api.processor.MessageProcessor;
import org.mule.construct.Flow;
import org.mule.devkit.processor.DevkitBasedMessageProcessor;
import org.mule.module.twilio.HttpMethod;
import org.mule.module.twilio.TwilioConnector;
import org.mule.module.twilio.adapters.TwilioConnectorHttpCallbackAdapter;
import org.mule.security.oauth.DefaultHttpCallback;
import org.mule.security.oauth.callback.HttpCallbackAdapter;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * MakeCallMessageProcessor invokes the {@link org.mule.module.twilio.TwilioConnector#makeCall(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.mule.module.twilio.HttpMethod, org.mule.api.callback.HttpCallback, org.mule.api.callback.HttpCallback, java.lang.String, java.lang.String, java.lang.String)} method in {@link TwilioConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-M4", date = "2014-04-11T08:52:14-05:00", comments = "Build M4.1875.17b58a3")
public class MakeCallMessageProcessor
    extends DevkitBasedMessageProcessor
    implements MessageProcessor
{

    protected Object accountSid;
    protected String _accountSidType;
    protected Object from;
    protected String _fromType;
    protected Object to;
    protected String _toType;
    protected Object url;
    protected String _urlType;
    protected Object applicationSid;
    protected String _applicationSidType;
    protected Object method;
    protected HttpMethod _methodType;
    /**
     * The flow to be invoked when the http callback is received
     * 
     */
    private Flow fallbackCallbackFlow;
    /**
     * An HttpCallback instance responsible for linking the APIs http callback with the flow {@link org.mule.module.twilio.processors.MakeCallMessageProcessor#fallbackCallbackFlow
     * 
     */
    private HttpCallback fallback;
    /**
     * The flow to be invoked when the http callback is received
     * 
     */
    private Flow statusCallbackCallbackFlow;
    /**
     * An HttpCallback instance responsible for linking the APIs http callback with the flow {@link org.mule.module.twilio.processors.MakeCallMessageProcessor#statusCallbackCallbackFlow
     * 
     */
    private HttpCallback statusCallback;
    protected Object sendDigits;
    protected String _sendDigitsType;
    protected Object ifMachine;
    protected String _ifMachineType;
    protected Object timeout;
    protected String _timeoutType;

    public MakeCallMessageProcessor(String operationName) {
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
        if (statusCallback!= null) {
            statusCallback.start();
        }
        if (fallback!= null) {
            fallback.start();
        }
    }

    @Override
    public void stop()
        throws MuleException
    {
        super.stop();
        if (statusCallback!= null) {
            statusCallback.stop();
        }
        if (fallback!= null) {
            fallback.stop();
        }
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    /**
     * Sets to
     * 
     * @param value Value to set
     */
    public void setTo(Object value) {
        this.to = value;
    }

    /**
     * Sets statusCallbackCallbackFlow
     * 
     * @param value Value to set
     */
    public void setStatusCallbackCallbackFlow(Flow value) {
        this.statusCallbackCallbackFlow = value;
    }

    /**
     * Sets fallbackCallbackFlow
     * 
     * @param value Value to set
     */
    public void setFallbackCallbackFlow(Flow value) {
        this.fallbackCallbackFlow = value;
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
     * Sets ifMachine
     * 
     * @param value Value to set
     */
    public void setIfMachine(Object value) {
        this.ifMachine = value;
    }

    /**
     * Sets applicationSid
     * 
     * @param value Value to set
     */
    public void setApplicationSid(Object value) {
        this.applicationSid = value;
    }

    /**
     * Sets method
     * 
     * @param value Value to set
     */
    public void setMethod(Object value) {
        this.method = value;
    }

    /**
     * Sets sendDigits
     * 
     * @param value Value to set
     */
    public void setSendDigits(Object value) {
        this.sendDigits = value;
    }

    /**
     * Sets from
     * 
     * @param value Value to set
     */
    public void setFrom(Object value) {
        this.from = value;
    }

    /**
     * Sets timeout
     * 
     * @param value Value to set
     */
    public void setTimeout(Object value) {
        this.timeout = value;
    }

    /**
     * Sets url
     * 
     * @param value Value to set
     */
    public void setUrl(Object value) {
        this.url = value;
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
            if ((statusCallbackCallbackFlow!= null)&&(statusCallback == null)) {
                HttpCallbackAdapter castedModuleObject = ((HttpCallbackAdapter) moduleObject);
                statusCallback = new DefaultHttpCallback(statusCallbackCallbackFlow, getMuleContext(), castedModuleObject.getDomain(), castedModuleObject.getLocalPort(), castedModuleObject.getRemotePort(), castedModuleObject.getAsync());
                statusCallback.start();
            }
            if ((fallbackCallbackFlow!= null)&&(fallback == null)) {
                HttpCallbackAdapter castedModuleObject = ((HttpCallbackAdapter) moduleObject);
                fallback = new DefaultHttpCallback(fallbackCallbackFlow, getMuleContext(), castedModuleObject.getDomain(), castedModuleObject.getLocalPort(), castedModuleObject.getRemotePort(), castedModuleObject.getAsync());
                fallback.start();
            }
            final String _transformedAccountSid = ((String) evaluateAndTransform(getMuleContext(), event, MakeCallMessageProcessor.class.getDeclaredField("_accountSidType").getGenericType(), null, accountSid));
            final String _transformedFrom = ((String) evaluateAndTransform(getMuleContext(), event, MakeCallMessageProcessor.class.getDeclaredField("_fromType").getGenericType(), null, from));
            final String _transformedTo = ((String) evaluateAndTransform(getMuleContext(), event, MakeCallMessageProcessor.class.getDeclaredField("_toType").getGenericType(), null, to));
            final String _transformedUrl = ((String) evaluateAndTransform(getMuleContext(), event, MakeCallMessageProcessor.class.getDeclaredField("_urlType").getGenericType(), null, url));
            final String _transformedApplicationSid = ((String) evaluateAndTransform(getMuleContext(), event, MakeCallMessageProcessor.class.getDeclaredField("_applicationSidType").getGenericType(), null, applicationSid));
            final HttpMethod _transformedMethod = ((HttpMethod) evaluateAndTransform(getMuleContext(), event, MakeCallMessageProcessor.class.getDeclaredField("_methodType").getGenericType(), null, method));
            final String _transformedSendDigits = ((String) evaluateAndTransform(getMuleContext(), event, MakeCallMessageProcessor.class.getDeclaredField("_sendDigitsType").getGenericType(), null, sendDigits));
            final String _transformedIfMachine = ((String) evaluateAndTransform(getMuleContext(), event, MakeCallMessageProcessor.class.getDeclaredField("_ifMachineType").getGenericType(), null, ifMachine));
            final String _transformedTimeout = ((String) evaluateAndTransform(getMuleContext(), event, MakeCallMessageProcessor.class.getDeclaredField("_timeoutType").getGenericType(), null, timeout));
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
                    return ((TwilioConnector) object).makeCall(_transformedAccountSid, _transformedFrom, _transformedTo, _transformedUrl, _transformedApplicationSid, _transformedMethod, fallback, statusCallback, _transformedSendDigits, _transformedIfMachine, _transformedTimeout);
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
