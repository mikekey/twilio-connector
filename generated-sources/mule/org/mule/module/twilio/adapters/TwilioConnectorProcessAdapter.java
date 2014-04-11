
package org.mule.module.twilio.adapters;

import javax.annotation.Generated;
import org.mule.api.MuleEvent;
import org.mule.api.MuleMessage;
import org.mule.api.devkit.ProcessAdapter;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.devkit.ProcessTemplate;
import org.mule.api.processor.MessageProcessor;
import org.mule.api.routing.filter.Filter;
import org.mule.module.twilio.TwilioConnector;
import org.mule.security.oauth.callback.ProcessCallback;


/**
 * A <code>TwilioConnectorProcessAdapter</code> is a wrapper around {@link TwilioConnector } that enables custom processing strategies.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-M4", date = "2014-04-11T08:52:14-05:00", comments = "Build M4.1875.17b58a3")
public class TwilioConnectorProcessAdapter
    extends TwilioConnectorLifecycleAdapter
    implements ProcessAdapter<TwilioConnectorCapabilitiesAdapter>
{


    public<P >ProcessTemplate<P, TwilioConnectorCapabilitiesAdapter> getProcessTemplate() {
        final TwilioConnectorCapabilitiesAdapter object = this;
        return new ProcessTemplate<P,TwilioConnectorCapabilitiesAdapter>() {


            @Override
            public P execute(ProcessCallback<P, TwilioConnectorCapabilitiesAdapter> processCallback, MessageProcessor messageProcessor, MuleEvent event)
                throws Exception
            {
                return processCallback.process(object);
            }

            @Override
            public P execute(ProcessCallback<P, TwilioConnectorCapabilitiesAdapter> processCallback, Filter filter, MuleMessage message)
                throws Exception
            {
                return processCallback.process(object);
            }

        }
        ;
    }

}
