
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
 * GetNotificationMessageProcessor invokes the {@link org.mule.module.twilio.TwilioConnector#getNotification(java.lang.String, java.lang.String)} method in {@link TwilioConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-M4", date = "2014-04-11T08:52:14-05:00", comments = "Build M4.1875.17b58a3")
public class GetNotificationMessageProcessor
    extends DevkitBasedMessageProcessor
    implements MessageProcessor
{

    protected Object accountSid;
    protected String _accountSidType;
    protected Object notificationSid;
    protected String _notificationSidType;

    public GetNotificationMessageProcessor(String operationName) {
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
     * Sets notificationSid
     * 
     * @param value Value to set
     */
    public void setNotificationSid(Object value) {
        this.notificationSid = value;
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
            final String _transformedAccountSid = ((String) evaluateAndTransform(getMuleContext(), event, GetNotificationMessageProcessor.class.getDeclaredField("_accountSidType").getGenericType(), null, accountSid));
            final String _transformedNotificationSid = ((String) evaluateAndTransform(getMuleContext(), event, GetNotificationMessageProcessor.class.getDeclaredField("_notificationSidType").getGenericType(), null, notificationSid));
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
                    return ((TwilioConnector) object).getNotification(_transformedAccountSid, _transformedNotificationSid);
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
