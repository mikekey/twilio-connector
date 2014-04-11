
package org.mule.module.twilio.config;

import javax.annotation.Generated;
import org.mule.config.MuleManifest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.factory.xml.NamespaceHandlerSupport;


/**
 * Registers bean definitions parsers for handling elements in <code>http://www.mulesoft.org/schema/mule/twilio</code>.
 * 
 */
@Generated(value = "Mule DevKit Version 3.5.0-M4", date = "2014-04-11T08:52:14-05:00", comments = "Build M4.1875.17b58a3")
public class TwilioNamespaceHandler
    extends NamespaceHandlerSupport
{

    private static Logger logger = LoggerFactory.getLogger(TwilioNamespaceHandler.class);

    private void handleException(String beanName, String beanScope, NoClassDefFoundError noClassDefFoundError) {
        String muleVersion = "";
        try {
            muleVersion = MuleManifest.getProductVersion();
        } catch (Exception _x) {
            logger.error("Problem while reading mule version");
        }
        logger.error(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [twilio] is not supported in mule ")+ muleVersion));
        throw new FatalBeanException(((((("Cannot launch the mule app, the  "+ beanScope)+" [")+ beanName)+"] within the connector [twilio] is not supported in mule ")+ muleVersion), noClassDefFoundError);
    }

    /**
     * Invoked by the {@link DefaultBeanDefinitionDocumentReader} after construction but before any custom elements are parsed. 
     * @see NamespaceHandlerSupport#registerBeanDefinitionParser(String, BeanDefinitionParser)
     * 
     */
    public void init() {
        try {
            this.registerBeanDefinitionParser("config", new TwilioConnectorConfigDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("config", "@Config", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-account-details", new GetAccountDetailsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-account-details", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-all-accounts-details", new GetAllAccountsDetailsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-all-accounts-details", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-account", new UpdateAccountDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-account", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-sub-account", new CreateSubAccountDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-sub-account", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-sub-account-by-account-sid", new GetSubAccountByAccountSidDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-sub-account-by-account-sid", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-sub-account-by-friendly-name", new GetSubAccountByFriendlyNameDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-sub-account-by-friendly-name", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("exchange-phone-numbers-between-subaccounts", new ExchangePhoneNumbersBetweenSubaccountsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("exchange-phone-numbers-between-subaccounts", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-available-phone-numbers", new GetAvailablePhoneNumbersDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-available-phone-numbers", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-available-phone-numbers-advanced-seach", new GetAvailablePhoneNumbersAdvancedSeachDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-available-phone-numbers-advanced-seach", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-available-toll-free-numbers", new GetAvailableTollFreeNumbersDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-available-toll-free-numbers", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-outgoing-caller-id-by-outgoing-caller-id-sid", new GetOutgoingCallerIdByOutgoingCallerIdSidDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-outgoing-caller-id-by-outgoing-caller-id-sid", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-outgoing-caller-id-by-outgoing-caller-id-sid", new UpdateOutgoingCallerIdByOutgoingCallerIdSidDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-outgoing-caller-id-by-outgoing-caller-id-sid", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-all-outgoing-caller-ids", new GetAllOutgoingCallerIdsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-all-outgoing-caller-ids", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("add-new-caller-id", new AddNewCallerIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("add-new-caller-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-outgoing-caller-id", new DeleteOutgoingCallerIdDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-outgoing-caller-id", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-incoming-phone-numbers-by-incoming-phone-number-sid", new GetIncomingPhoneNumbersByIncomingPhoneNumberSidDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-incoming-phone-numbers-by-incoming-phone-number-sid", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-incoming-phone-numbers", new UpdateIncomingPhoneNumbersDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-incoming-phone-numbers", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-incoming-phone-number", new DeleteIncomingPhoneNumberDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-incoming-phone-number", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-incoming-phone-numbers", new GetIncomingPhoneNumbersDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-incoming-phone-numbers", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("add-incoming-phone-number-by-phone-number", new AddIncomingPhoneNumberByPhoneNumberDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("add-incoming-phone-number-by-phone-number", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("add-incoming-phone-number-by-area-code", new AddIncomingPhoneNumberByAreaCodeDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("add-incoming-phone-number-by-area-code", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-application", new GetApplicationDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-application", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-application", new UpdateApplicationDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-application", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-application", new DeleteApplicationDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-application", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-all-applications", new GetAllApplicationsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-all-applications", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("create-application", new CreateApplicationDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("create-application", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-call", new GetCallDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-call", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-calls", new GetCallsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-calls", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("make-call", new MakeCallDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("make-call", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("change-call-state", new ChangeCallStateDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("change-call-state", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-conference", new GetConferenceDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-conference", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-conferences", new GetConferencesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-conferences", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-participant", new GetParticipantDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-participant", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-participant-status", new UpdateParticipantStatusDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-participant-status", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-participant", new DeleteParticipantDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-participant", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-participants", new GetParticipantsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-participants", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-sms-message", new GetSmsMessageDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-sms-message", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-all-sms-messages", new GetAllSmsMessagesDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-all-sms-messages", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("send-sms-message", new SendSmsMessageDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("send-sms-message", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-recording", new GetRecordingDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-recording", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-recording", new DeleteRecordingDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-recording", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-recordings", new GetRecordingsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-recordings", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-transcription-by-transcription-sid", new GetTranscriptionByTranscriptionSidDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-transcription-by-transcription-sid", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-transcriptions", new GetTranscriptionsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-transcriptions", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-notification", new GetNotificationDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-notification", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("delete-notification", new DeleteNotificationDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("delete-notification", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-all-notifications", new GetAllNotificationsDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-all-notifications", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-notifications-by-call-sid", new GetNotificationsByCallSidDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-notifications-by-call-sid", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("get-sandbox", new GetSandboxDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("get-sandbox", "@Processor", ex);
        }
        try {
            this.registerBeanDefinitionParser("update-sandbox", new UpdateSandboxDefinitionParser());
        } catch (NoClassDefFoundError ex) {
            handleException("update-sandbox", "@Processor", ex);
        }
    }

}
