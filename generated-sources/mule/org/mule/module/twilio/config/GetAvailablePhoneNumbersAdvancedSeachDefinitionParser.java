
package org.mule.module.twilio.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.mule.module.twilio.processors.GetAvailablePhoneNumbersAdvancedSeachMessageProcessor;
import org.mule.security.oauth.config.AbstractDevkitBasedDefinitionParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.parsing.BeanDefinitionParsingException;
import org.springframework.beans.factory.parsing.Location;
import org.springframework.beans.factory.parsing.Problem;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

@Generated(value = "Mule DevKit Version 3.5.0-M4", date = "2014-04-11T08:52:14-05:00", comments = "Build M4.1875.17b58a3")
public class GetAvailablePhoneNumbersAdvancedSeachDefinitionParser
    extends AbstractDevkitBasedDefinitionParser
{

    private static Logger logger = LoggerFactory.getLogger(GetAvailablePhoneNumbersAdvancedSeachDefinitionParser.class);

    private BeanDefinitionBuilder getBeanDefinitionBuilder(ParserContext parserContext) {
        try {
            return BeanDefinitionBuilder.rootBeanDefinition(GetAvailablePhoneNumbersAdvancedSeachMessageProcessor.class.getName());
        } catch (NoClassDefFoundError noClassDefFoundError) {
            String muleVersion = "";
            try {
                muleVersion = MuleManifest.getProductVersion();
            } catch (Exception _x) {
                logger.error("Problem while reading mule version");
            }
            logger.error(("Cannot launch the mule app, the @Processor [get-available-phone-numbers-advanced-seach] within the connector [twilio] is not supported in mule "+ muleVersion));
            throw new BeanDefinitionParsingException(new Problem(("Cannot launch the mule app, the @Processor [get-available-phone-numbers-advanced-seach] within the connector [twilio] is not supported in mule "+ muleVersion), new Location(parserContext.getReaderContext().getResource()), null, noClassDefFoundError));
        }
    }

    public BeanDefinition parse(Element element, ParserContext parserContext) {
        BeanDefinitionBuilder builder = getBeanDefinitionBuilder(parserContext);
        builder.addConstructorArgValue("getAvailablePhoneNumbersAdvancedSeach");
        builder.setScope(BeanDefinition.SCOPE_PROTOTYPE);
        parseConfigRef(element, builder);
        parseProperty(builder, element, "accountSid", "accountSid");
        parseProperty(builder, element, "isoCountryCode", "isoCountryCode");
        parseProperty(builder, element, "areaCode", "areaCode");
        parseProperty(builder, element, "contains", "contains");
        parseProperty(builder, element, "inRegion", "inRegion");
        parseProperty(builder, element, "inPostalCode", "inPostalCode");
        parseProperty(builder, element, "nearLatLong", "nearLatLong");
        parseProperty(builder, element, "nearPhoneNumber", "nearPhoneNumber");
        parseProperty(builder, element, "inLata", "inLata");
        parseProperty(builder, element, "inRateCenter", "inRateCenter");
        parseProperty(builder, element, "distance", "distance");
        BeanDefinition definition = builder.getBeanDefinition();
        setNoRecurseOnDefinition(definition);
        attachProcessorDefinition(parserContext, definition);
        return definition;
    }

}
