
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
 * GetAllSmsMessagesMessageProcessor invokes the {@link org.mule.module.twilio.TwilioConnector#getAllSmsMessages(java.lang.String, java.lang.String, java.lang.String, java.lang.String)} method in {@link TwilioConnector }. For each argument there is a field in this processor to match it.  Before invoking the actual method the processor will evaluate and transform where possible to the expected argument type.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-M4", date = "2014-04-11T08:52:14-05:00", comments = "Build M4.1875.17b58a3")
public class GetAllSmsMessagesMessageProcessor
    extends DevkitBasedMessageProcessor
    implements MessageProcessor
{

    protected Object accountSid;
    protected String _accountSidType;
    protected Object to;
    protected String _toType;
    protected Object from;
    protected String _fromType;
    protected Object dateSent;
    protected String _dateSentType;

    public GetAllSmsMessagesMessageProcessor(String operationName) {
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
     * Sets to
     * 
     * @param value Value to set
     */
    public void setTo(Object value) {
        this.to = value;
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
     * Sets dateSent
     * 
     * @param value Value to set
     */
    public void setDateSent(Object value) {
        this.dateSent = value;
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
            final String _transformedAccountSid = ((String) evaluateAndTransform(getMuleContext(), event, GetAllSmsMessagesMessageProcessor.class.getDeclaredField("_accountSidType").getGenericType(), null, accountSid));
            final String _transformedTo = ((String) evaluateAndTransform(getMuleContext(), event, GetAllSmsMessagesMessageProcessor.class.getDeclaredField("_toType").getGenericType(), null, to));
            final String _transformedFrom = ((String) evaluateAndTransform(getMuleContext(), event, GetAllSmsMessagesMessageProcessor.class.getDeclaredField("_fromType").getGenericType(), null, from));
            final String _transformedDateSent = ((String) evaluateAndTransform(getMuleContext(), event, GetAllSmsMessagesMessageProcessor.class.getDeclaredField("_dateSentType").getGenericType(), null, dateSent));
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
                    return ((TwilioConnector) object).getAllSmsMessages(_transformedAccountSid, _transformedTo, _transformedFrom, _transformedDateSent);
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
