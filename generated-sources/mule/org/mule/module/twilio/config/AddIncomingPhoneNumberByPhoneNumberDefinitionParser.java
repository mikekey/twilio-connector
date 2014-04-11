
package org.mule.module.twilio.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.module.twilio.processors.AddIncomingPhoneNumberByPhoneNumberMessageProcessor;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.parsing.BeanDefinitionParsingException;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.5.0-M4", date = "2014-04-11T08:52:14-05:00", comments = "Build M4.1875.17b58a3")
public class AddIncomingPhoneNumberByPhoneNumberDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(AddIncomingPhoneNumberByPhoneNumberDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(AddIncomingPhoneNumberByPhoneNumberMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [add-incoming-phone-number-by-phone-number] within the connector [twilio] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [add-incoming-phone-number-by-phone-number] within the connector [twilio] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("addIncomingPhoneNumberByPhoneNumber");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "accountSid", "accountSid");
        parseProperty(builder, element, "phoneNumber", "phoneNumber");
        parseProperty(builder, element, "friendlyName", "friendlyName");
        parseProperty(builder, element, "voiceUrl", "voiceUrl");
        parseProperty(builder, element, "voiceMethod", "voiceMethod");
        String voiceFallbackCallbackFlowName = getAttributeValue(element, "voice-fallback-flow-ref");
        if (voiceFallbackCallbackFlowName!= null) {
            builder.addPropertyValue("voiceFallbackCallbackFlow", new RuntimeBeanReference(voiceFallbackCallbackFlowName));
        }
        String statusCallbackCallbackFlowName = getAttributeValue(element, "status-callback-flow-ref");
        if (statusCallbackCallbackFlowName!= null) {
            builder.addPropertyValue("statusCallbackCallbackFlow", new RuntimeBeanReference(statusCallbackCallbackFlowName));
        }
        parseProperty(builder, element, "voiceCallerIdLookup", "voiceCallerIdLookup");
        parseProperty(builder, element, "voiceApplicationSid", "voiceApplicationSid");
        parseProperty(builder, element, "smsUrl", "smsUrl");
        parseProperty(builder, element, "smsMethod", "smsMethod");
        String smsFallbackCallbackFlowName = getAttributeValue(element, "sms-fallback-flow-ref");
        if (smsFallbackCallbackFlowName!= null) {
            builder.addPropertyValue("smsFallbackCallbackFlow", new RuntimeBeanReference(smsFallbackCallbackFlowName));
        }
        parseProperty(builder, element, "smsApplicationSid", "smsApplicationSid");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
