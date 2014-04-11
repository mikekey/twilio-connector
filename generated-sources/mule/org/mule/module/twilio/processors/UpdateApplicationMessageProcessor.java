
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
 * UpdateApplicationMessageProcessor invokes the {@link org.mule.module.twilio.TwilioConnector#updateApplication(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, org.mule.module.twilio.HttpMethod, org.mule.api.callback.HttpCallback, org.mule.api.callback.HttpCallback, java.lang.Boolean, java.lang.String, org.mule.module.twilio.HttpMethod, org.mule.api.callback.HttpCallback, org.mule.api.callback.HttpCallback)} method in {@link TwilioConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-M4", date = "2014-04-11T08:52:14-05:00", comments = "Build M4.1875.17b58a3")
public class UpdateApplicationMessageProcessor
    extends DevkitBasedMessageProcessor
    implements MessageProcessor
{

    protected Object accountSid;
    protected String _accountSidType;
    protected Object applicationSid;
    protected String _applicationSidType;
    protected Object friendlyName;
    protected String _friendlyNameType;
    protected Object apiVersion;
    protected String _apiVersionType;
    protected Object voiceUrl;
    protected String _voiceUrlType;
    protected Object voiceMethod;
    protected HttpMethod _voiceMethodType;
    /**
     * The flow to be invoked when the http callback is received
     * 
     */
    private Flow voiceFallbackCallbackFlow;
    /**
     * An HttpCallback instance responsible for linking the APIs http callback with the flow {@link org.mule.module.twilio.processors.UpdateApplicationMessageProcessor#voiceFallbackCallbackFlow
     * 
     */
    private HttpCallback voiceFallback;
    /**
     * The flow to be invoked when the http callback is received
     * 
     */
    private Flow statusCallbackCallbackFlow;
    /**
     * An HttpCallback instance responsible for linking the APIs http callback with the flow {@link org.mule.module.twilio.processors.UpdateApplicationMessageProcessor#statusCallbackCallbackFlow
     * 
     */
    private HttpCallback statusCallback;
    protected Object voiceCallerIdLookup;
    protected Boolean _voiceCallerIdLookupType;
    protected Object smsUrl;
    protected String _smsUrlType;
    protected Object smsMethod;
    protected HttpMethod _smsMethodType;
    /**
     * The flow to be invoked when the http callback is received
     * 
     */
    private Flow smsFallbackCallbackFlow;
    /**
     * An HttpCallback instance responsible for linking the APIs http callback with the flow {@link org.mule.module.twilio.processors.UpdateApplicationMessageProcessor#smsFallbackCallbackFlow
     * 
     */
    private HttpCallback smsFallback;
    /**
     * The flow to be invoked when the http callback is received
     * 
     */
    private Flow smsStatusCallbackCallbackFlow;
    /**
     * An HttpCallback instance responsible for linking the APIs http callback with the flow {@link org.mule.module.twilio.processors.UpdateApplicationMessageProcessor#smsStatusCallbackCallbackFlow
     * 
     */
    private HttpCallback smsStatusCallback;

    public UpdateApplicationMessageProcessor(String operationName) {
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
        if (voiceFallback!= null) {
            voiceFallback.start();
        }
        if (smsStatusCallback!= null) {
            smsStatusCallback.start();
        }
        if (smsFallback!= null) {
            smsFallback.start();
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
        if (voiceFallback!= null) {
            voiceFallback.stop();
        }
        if (smsStatusCallback!= null) {
            smsStatusCallback.stop();
        }
        if (smsFallback!= null) {
            smsFallback.stop();
        }
    }

    @Override
    public void dispose() {
        super.dispose();
    }

    /**
     * Sets apiVersion
     * 
     * @param value Value to set
     */
    public void setApiVersion(Object value) {
        this.apiVersion = value;
    }

    /**
     * Sets voiceCallerIdLookup
     * 
     * @param value Value to set
     */
    public void setVoiceCallerIdLookup(Object value) {
        this.voiceCallerIdLookup = value;
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
     * Sets voiceMethod
     * 
     * @param value Value to set
     */
    public void setVoiceMethod(Object value) {
        this.voiceMethod = value;
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
     * Sets voiceFallbackCallbackFlow
     * 
     * @param value Value to set
     */
    public void setVoiceFallbackCallbackFlow(Flow value) {
        this.voiceFallbackCallbackFlow = value;
    }

    /**
     * Sets smsMethod
     * 
     * @param value Value to set
     */
    public void setSmsMethod(Object value) {
        this.smsMethod = value;
    }

    /**
     * Sets friendlyName
     * 
     * @param value Value to set
     */
    public void setFriendlyName(Object value) {
        this.friendlyName = value;
    }

    /**
     * Sets smsStatusCallbackCallbackFlow
     * 
     * @param value Value to set
     */
    public void setSmsStatusCallbackCallbackFlow(Flow value) {
        this.smsStatusCallbackCallbackFlow = value;
    }

    /**
     * Sets smsUrl
     * 
     * @param value Value to set
     */
    public void setSmsUrl(Object value) {
        this.smsUrl = value;
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
     * Sets voiceUrl
     * 
     * @param value Value to set
     */
    public void setVoiceUrl(Object value) {
        this.voiceUrl = value;
    }

    /**
     * Sets smsFallbackCallbackFlow
     * 
     * @param value Value to set
     */
    public void setSmsFallbackCallbackFlow(Flow value) {
        this.smsFallbackCallbackFlow = value;
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
            if ((voiceFallbackCallbackFlow!= null)&&(voiceFallback == null)) {
                HttpCallbackAdapter castedModuleObject = ((HttpCallbackAdapter) moduleObject);
                voiceFallback = new DefaultHttpCallback(voiceFallbackCallbackFlow, getMuleContext(), castedModuleObject.getDomain(), castedModuleObject.getLocalPort(), castedModuleObject.getRemotePort(), castedModuleObject.getAsync());
                voiceFallback.start();
            }
            if ((smsStatusCallbackCallbackFlow!= null)&&(smsStatusCallback == null)) {
                HttpCallbackAdapter castedModuleObject = ((HttpCallbackAdapter) moduleObject);
                smsStatusCallback = new DefaultHttpCallback(smsStatusCallbackCallbackFlow, getMuleContext(), castedModuleObject.getDomain(), castedModuleObject.getLocalPort(), castedModuleObject.getRemotePort(), castedModuleObject.getAsync());
                smsStatusCallback.start();
            }
            if ((smsFallbackCallbackFlow!= null)&&(smsFallback == null)) {
                HttpCallbackAdapter castedModuleObject = ((HttpCallbackAdapter) moduleObject);
                smsFallback = new DefaultHttpCallback(smsFallbackCallbackFlow, getMuleContext(), castedModuleObject.getDomain(), castedModuleObject.getLocalPort(), castedModuleObject.getRemotePort(), castedModuleObject.getAsync());
                smsFallback.start();
            }
            final String _transformedAccountSid = ((String) evaluateAndTransform(getMuleContext(), event, UpdateApplicationMessageProcessor.class.getDeclaredField("_accountSidType").getGenericType(), null, accountSid));
            final String _transformedApplicationSid = ((String) evaluateAndTransform(getMuleContext(), event, UpdateApplicationMessageProcessor.class.getDeclaredField("_applicationSidType").getGenericType(), null, applicationSid));
            final String _transformedFriendlyName = ((String) evaluateAndTransform(getMuleContext(), event, UpdateApplicationMessageProcessor.class.getDeclaredField("_friendlyNameType").getGenericType(), null, friendlyName));
            final String _transformedApiVersion = ((String) evaluateAndTransform(getMuleContext(), event, UpdateApplicationMessageProcessor.class.getDeclaredField("_apiVersionType").getGenericType(), null, apiVersion));
            final String _transformedVoiceUrl = ((String) evaluateAndTransform(getMuleContext(), event, UpdateApplicationMessageProcessor.class.getDeclaredField("_voiceUrlType").getGenericType(), null, voiceUrl));
            final HttpMethod _transformedVoiceMethod = ((HttpMethod) evaluateAndTransform(getMuleContext(), event, UpdateApplicationMessageProcessor.class.getDeclaredField("_voiceMethodType").getGenericType(), null, voiceMethod));
            final Boolean _transformedVoiceCallerIdLookup = ((Boolean) evaluateAndTransform(getMuleContext(), event, UpdateApplicationMessageProcessor.class.getDeclaredField("_voiceCallerIdLookupType").getGenericType(), null, voiceCallerIdLookup));
            final String _transformedSmsUrl = ((String) evaluateAndTransform(getMuleContext(), event, UpdateApplicationMessageProcessor.class.getDeclaredField("_smsUrlType").getGenericType(), null, smsUrl));
            final HttpMethod _transformedSmsMethod = ((HttpMethod) evaluateAndTransform(getMuleContext(), event, UpdateApplicationMessageProcessor.class.getDeclaredField("_smsMethodType").getGenericType(), null, smsMethod));
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
                    return ((TwilioConnector) object).updateApplication(_transformedAccountSid, _transformedApplicationSid, _transformedFriendlyName, _transformedApiVersion, _transformedVoiceUrl, _transformedVoiceMethod, voiceFallback, statusCallback, _transformedVoiceCallerIdLookup, _transformedSmsUrl, _transformedSmsMethod, smsFallback, smsStatusCallback);
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
