/**
 * Mule Twilio Connector
 *
 * Copyright (c) MuleSoft, Inc.  All rights reserved.  http://www.mulesoft.com
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.module.twilio.config;

import org.mule.api.MuleContext;
import org.mule.api.MuleEvent;
import org.mule.construct.Flow;
import org.mule.tck.FunctionalTestCase;
import org.mule.transport.http.HttpConnector;

import static org.fest.assertions.Assertions.assertThat;

public class TwilioNamespaceHandlerTestCase extends FunctionalTestCase {

    private static final String CALLBACK_URL = "http://localhost";

    @Override
    protected String getConfigResources() {
        return "twilio-namespace-config.xml";
    }

    @Override
    protected MuleContext createMuleContext() throws Exception {
        MuleContext muleContext = super.createMuleContext();
        muleContext.getRegistry().registerObject("connector.http.mule.default", new HttpConnector(muleContext));
        return muleContext;
    }

    public void testGetAccoundDetails() throws Exception {
        Flow flow = lookupFlowConstruct("getAccountDetails");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7";
        String expectedParams = "{}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetAllAccoundDetails() throws Exception {
        Flow flow = lookupFlowConstruct("getAllAccountsDetails");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/";
        String expectedParams = "{Status=SUSPENDED, FriendlyName=coco}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testUpdateAccount() throws Exception {
        Flow flow = lookupFlowConstruct("updateAccount");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "POST";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7";
        String expectedParams = "{Status=CLOSED, FriendlyName=juan}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testCreateSubAccount() throws Exception {
        Flow flow = lookupFlowConstruct("createSubAccount");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "POST";
        String expectedUri = "/2010-04-01/Accounts/";
        String expectedParams = "{FriendlyName=raul}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetSubAccountByAccountSid() throws Exception {
        Flow flow = lookupFlowConstruct("getSubAccountByAccountSid");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7";
        String expectedParams = "{}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetSubAccountByFriendlyName() throws Exception {
        Flow flow = lookupFlowConstruct("getSubAccountByFriendlyName");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/";
        String expectedParams = "{FriendlyName=fede}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testExchangePhoneNumbersBetweenSubaccounts() throws Exception {
        Flow flow = lookupFlowConstruct("exchangePhoneNumbersBetweenSubaccounts");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "POST";
        String expectedUri = "/2010-04-01/Accounts/AC8e51fecefbf0b501caced6266d723b3c/IncomingPhoneNumbers/321";
        String expectedParams = "{AccountSid=AC970e46372f082a4947642b9cf19cafa7}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetAvailablePhoneNumbers() throws Exception {
        Flow flow = lookupFlowConstruct("getAvailablePhoneNumbers");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC8e51fecefbf0b501caced6266d723b3c/AvailablePhoneNumbers/AR/Local";
        String expectedParams = "{AreaCode=some-area-code, InPostalCode=in-some-postal-code, Contains=*, InRegion=in-some-region}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetAvailablePhoneNumbersAdvancedSeach() throws Exception {
        Flow flow = lookupFlowConstruct("getAvailablePhoneNumbersAdvancedSeach");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC8e51fecefbf0b501caced6266d723b3c/AvailablePhoneNumbers/AR/Local";
        String expectedParams = "{NearLatLong=nearSomeLatLong, AreaCode=some-area-code, Distance=someDistance, InPostalCode=inSomePostalCode, Contains=*, InRateCenter=inSomeRateCenter, InRegion=inSomeRegion, InLata=inSomeLata, NearNumber=nearSomePhoneNumber}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetAvailableTollFreeNumbers() throws Exception {
        Flow flow = lookupFlowConstruct("getAvailableTollFreeNumbers");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC8e51fecefbf0b501caced6266d723b3c/AvailablePhoneNumbers/AR/TollFree";
        String expectedParams = "{Contains=*}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetOutgoingCallerIdByOutgoingCallerIdSid() throws Exception {
        Flow flow = lookupFlowConstruct("getOutgoingCallerIdByOutgoingCallerIdSid");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/OutgoingCallerIds/some-outgoing-caller-id-sid";
        String expectedParams = "{}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testUpdateOutgoingCallerIdByOutgoingCallerIdSid() throws Exception {
        Flow flow = lookupFlowConstruct("updateOutgoingCallerIdByOutgoingCallerIdSid");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "POST";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/OutgoingCallerIds/some-outgoing-caller-id-sid";
        String expectedParams = "{FriendlyName=some-friendly-name}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetAllOutgoingCallerIds() throws Exception {
        Flow flow = lookupFlowConstruct("getAllOutgoingCallerIds");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/OutgoingCallerIds/";
        String expectedParams = "{FriendlyName=some-friendly-name, PhoneNumber=some-phone-number}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testAddNewCallerId() throws Exception {
        Flow flow = lookupFlowConstruct("addNewCallerId");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "POST";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/OutgoingCallerIds/";
        String expectedParams = "{CallDelay=1, Extension=some-extension, FriendlyName=some-friendly-name, PhoneNumber=some-phone-number}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testDeleteOutgoingCallerId() throws Exception {
        Flow flow = lookupFlowConstruct("deleteOutgoingCallerId");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "DELETE";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/OutgoingCallerIds/some-outgoing-caller-id-sid";
        String expectedParams = "{}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetIncomingPhoneNumbersByIncomingPhoneNumberSid() throws Exception {
        Flow flow = lookupFlowConstruct("getIncomingPhoneNumbersByIncomingPhoneNumberSid");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/IncomingPhoneNumbers/some-incoming-phone-number-sid";
        String expectedParams = "{}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testUpdateIncomingPhoneNumbers() throws Exception {
        RequestToTwilio requestToTwilio = runFlow("updateIncomingPhoneNumbers");
        assertEquals("POST", requestToTwilio.getHttpMethod());
        assertEquals("/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/IncomingPhoneNumbers/some-incoming-phone-number-sid", requestToTwilio.getUrl());
        assertThat(requestToTwilio.getParameters()).
                contains("VoiceUrl=some-voice-url").
                contains("VoiceMethod=GET").
                contains("SmsUrl=some-sms-url").
                contains("SmsMethod=GET").
                contains("ApiVersion=2010-04-01").
                contains("VoiceFallbackUrl=" + CALLBACK_URL).
                contains("VoiceFallbackMethod=GET").
                contains("StatusCallback=" + CALLBACK_URL).
                contains("StatusCallbackMethod=GET").
                contains("SmsApplicationSid=some-sms-application-sid").
                contains("VoiceCallerIdLookup=true").
                contains("SmsFallbackUrl=" + CALLBACK_URL).
                contains("SmsFallbackMethod=GET");
    }

    public void testDeleteIncomingPhoneNumber() throws Exception {
        Flow flow = lookupFlowConstruct("deleteIncomingPhoneNumber");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "DELETE";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/IncomingPhoneNumbers/some-incoming-phone-number-sid";
        String expectedParams = "{}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetIncomingPhoneNumbers() throws Exception {
        Flow flow = lookupFlowConstruct("getIncomingPhoneNumbers");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/IncomingPhoneNumbers";
        String expectedParams = "{FriendlyName=some-friendly-name, PhoneNumber=some-phone-number}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testAddIncomingPhoneNumberByPhoneNumber() throws Exception {
        RequestToTwilio requestToTwilio = runFlow("addIncomingPhoneNumberByPhoneNumber");
        assertEquals("POST", requestToTwilio.getHttpMethod());
        assertEquals("/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/IncomingPhoneNumbers", requestToTwilio.getUrl());
        assertThat(requestToTwilio.getParameters()).
                contains("VoiceFallbackUrl=" + CALLBACK_URL).
                contains("FriendlyName=some-friendly-name").
                contains("VoiceApplicationSid=some-voice-application-sid").
                contains("VoiceUrl=some-voice-url").
                contains("SmsUrl=some-sms-url").
                contains("VoiceFallbackMethod=GET").
                contains("VoiceMethod=GET").
                contains("PhoneNumber=some-phone-number").
                contains("StatusCallback=" + CALLBACK_URL).
                contains("StatusCallbackMethod=GET").
                contains("SmsApplicationSid=some-sms-application-sid").
                contains("SmsFallbackMethod=GET").
                contains("VoiceCallerIdLookup=false").
                contains("SmsFallbackUrl=" + CALLBACK_URL).
                contains("SmsMethod=GET");
    }

    public void testAddIncomingPhoneNumberByAreaCode() throws Exception {
        RequestToTwilio requestToTwilio = runFlow("addIncomingPhoneNumberByAreaCode");
        assertEquals("POST", requestToTwilio.getHttpMethod());
        assertEquals("/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/IncomingPhoneNumbers", requestToTwilio.getUrl());
        assertThat(requestToTwilio.getParameters()).
                contains("VoiceFallbackUrl=" + CALLBACK_URL).
                contains("FriendlyName=some-friendly-name").
                contains("VoiceApplicationSid=some-voice-application-sid").
                contains("VoiceUrl=some-voice-url").
                contains("SmsUrl=some-sms-url").
                contains("VoiceFallbackMethod=GET").
                contains("VoiceMethod=GET").
                contains("AreaCode=some-area-code").
                contains("StatusCallback=" + CALLBACK_URL).
                contains("StatusCallbackMethod=GET").
                contains("SmsApplicationSid=some-sms-application-sid").
                contains("SmsFallbackMethod=GET").
                contains("VoiceCallerIdLookup=false").
                contains("SmsFallbackUrl=" + CALLBACK_URL).
                contains("SmsMethod=GET");
    }

    public void testGetApplication() throws Exception {
        Flow flow = lookupFlowConstruct("getApplication");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Applications/some-application-sid";
        String expectedParams = "{}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testUpdateApplication() throws Exception {
        RequestToTwilio requestToTwilio = runFlow("updateApplication");
        assertEquals("POST", requestToTwilio.getHttpMethod());
        assertEquals("/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Applications/some-application-sid", requestToTwilio.getUrl());
        assertThat(requestToTwilio.getParameters()).
                contains("VoiceFallbackUrl=" + CALLBACK_URL).
                contains("FriendlyName=some-friendly-name").
                contains("VoiceUrl=some-voice-url").
                contains("SmsUrl=some-sms-url").
                contains("ApiVersion=2010-04-01").
                contains("VoiceFallbackMethod=GET").
                contains("VoiceMethod=GET").
                contains("StatusCallback=" + CALLBACK_URL).
                contains("SmsFallbackMethod=GET").
                contains("SmsStatusCallback=" + CALLBACK_URL).
                contains("VoiceCallerIdLookup=false").
                contains("StatusCallbackMethod=GET").
                contains("SmsFallbackUrl=" + CALLBACK_URL).
                contains("SmsMethod=GET");
    }

    public void testDeleteApplication() throws Exception {
        Flow flow = lookupFlowConstruct("deleteApplication");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "DELETE";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Applications/some-application-sid";
        String expectedParams = "{}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetAllApplications() throws Exception {
        Flow flow = lookupFlowConstruct("getAllApplications");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Applications";
        String expectedParams = "{FriendlyName=some-friendly-name}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testCreateApplication() throws Exception {
        RequestToTwilio requestToTwilio = runFlow("createApplication");
        assertEquals("POST", requestToTwilio.getHttpMethod());
        assertEquals("/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Applications/", requestToTwilio.getUrl());
        assertThat(requestToTwilio.getParameters()).
                contains("VoiceFallbackUrl=" + CALLBACK_URL).
                contains("FriendlyName=some-friendly-name").
                contains("VoiceUrl=some-voice-url").
                contains("SmsUrl=some-sms-url").
                contains("ApiVersion=2010-04-01").
                contains("VoiceFallbackMethod=GET").
                contains("VoiceMethod=GET").
                contains("StatusCallback=" + CALLBACK_URL).
                contains("SmsFallbackMethod=GET").
                contains("SmsStatusCallback=" + CALLBACK_URL).
                contains("VoiceCallerIdLookup=false").
                contains("StatusCallbackMethod=GET").
                contains("SmsFallbackUrl=" + CALLBACK_URL).
                contains("SmsMethod=GET");
    }

    public void testGetCall() throws Exception {
        Flow flow = lookupFlowConstruct("getCall");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Calls/some-call-sid";
        String expectedParams = "{}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetCalls() throws Exception {
        Flow flow = lookupFlowConstruct("getCalls");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Calls/";
        String expectedParams = "{Status=some-status, To=some-to, StartTime=start-time, From=some-from}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testMakeCall() throws Exception {
        RequestToTwilio requestToTwilio = runFlow("makeCall");
        assertEquals("POST", requestToTwilio.getHttpMethod());
        assertEquals("/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Calls/", requestToTwilio.getUrl());
        assertThat(requestToTwilio.getParameters()).
                contains("SendDigits=some-digits").
                contains("ApplicationSid=some-application-sid").
                contains("FallbackMethod=GET").
                contains("Timeout=123").
                contains("IfMachine=continue").
                contains("StatusCallback=" + CALLBACK_URL).
                contains("Method=GET").
                contains("To=some-to").
                contains("StatusCallbackMethod=GET").
                contains("FallbackUrl=" + CALLBACK_URL).
                contains("From=some-from");
    }

    public void testChangeCallState() throws Exception {
        Flow flow = lookupFlowConstruct("changeCallState");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "POST";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Calls/some-call-sid";
        String expectedParams = "{Status=some-status, Url=some-url, Method=GET}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetConference() throws Exception {
        Flow flow = lookupFlowConstruct("getConference");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Conferences/some-conference-sid";
        String expectedParams = "{}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetConferences() throws Exception {
        Flow flow = lookupFlowConstruct("getConferences");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Conferences/";
        String expectedParams = "{Status=some-status, FriendlyName=some-friendly-name, DateCreated=some-date-created, DateUpdated=some-date-updated}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetParticipant() throws Exception {
        Flow flow = lookupFlowConstruct("getParticipant");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Conferences/some-conference-sid/Participants/some-call-sid";
        String expectedParams = "{}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testUpdateParticipantStatus() throws Exception {
        Flow flow = lookupFlowConstruct("updateParticipantStatus");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "POST";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Conferences/some-conference-sid/Participants/some-call-sid";
        String expectedParams = "{Muted=false}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testDeleteParticipant() throws Exception {
        Flow flow = lookupFlowConstruct("deleteParticipant");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "DELETE";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Conferences/some-conference-sid/Participants/some-call-sid";
        String expectedParams = "{}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetParticipants() throws Exception {
        Flow flow = lookupFlowConstruct("getParticipants");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Conferences/some-conference-sid/Participants/";
        String expectedParams = "{Muted=false}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetSmsMessage() throws Exception {
        Flow flow = lookupFlowConstruct("getSmsMessage");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/SMS/Messages/some-sms-message-id";
        String expectedParams = "{}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetAllSmsMessages() throws Exception {
        Flow flow = lookupFlowConstruct("getAllSmsMessages");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/SMS/Messages/";
        String expectedParams = "{DateSent=some-date-sent, To=some-to, From=some-from}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testSendSmsMessage() throws Exception {
        RequestToTwilio requestToTwilio = runFlow("sendSmsMessage");
        assertEquals("POST", requestToTwilio.getHttpMethod());
        assertEquals("/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/SMS/Messages/", requestToTwilio.getUrl());
        assertThat(requestToTwilio.getParameters()).
                contains("ApplicationSid=some-application-sid").
                contains("Body=some-body").
                contains("StatusCallback=" + CALLBACK_URL).
                contains("To=some-to").
                contains("From=some-from");
    }

    public void testGetRecording() throws Exception {
        Flow flow = lookupFlowConstruct("getRecording");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Recordings/some-recording-sid.mp3";
        String expectedParams = "{}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testDeleteRecording() throws Exception {
        Flow flow = lookupFlowConstruct("deleteRecording");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "DELETE";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Recordings/some-recording-sid";
        String expectedParams = "{}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetRecordings() throws Exception {
        Flow flow = lookupFlowConstruct("getRecordings");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Recordings/";
        String expectedParams = "{DateCreated=some-date-created, CallSid=some-call-sid}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetTranscriptionByTranscriptionSid() throws Exception {
        Flow flow = lookupFlowConstruct("getTranscriptionByTranscriptionSid");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Transcriptions/some-transcription-sid.txt";
        String expectedParams = "{}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetTranscriptions() throws Exception {
        Flow flow = lookupFlowConstruct("getTranscriptions");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Recordings/some-recording-sid.xml";
        String expectedParams = "{}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetNotification() throws Exception {
        Flow flow = lookupFlowConstruct("getNotification");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Notifications/some-notification-sid";
        String expectedParams = "{}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testDeleteNotification() throws Exception {
        Flow flow = lookupFlowConstruct("deleteNotification");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "DELETE";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Notifications/some-notification-sid";
        String expectedParams = "{}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetAllNotifications() throws Exception {
        Flow flow = lookupFlowConstruct("getAllNotifications");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Notifications/";
        String expectedParams = "{Log=1, MessageDate=some-message-date}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetNotificationsByCallSid() throws Exception {
        Flow flow = lookupFlowConstruct("getNotificationsByCallSid");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Calls/some-call-sid/Notifications/";
        String expectedParams = "{Log=1, MessageDate=some-message-date}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testGetSandbox() throws Exception {
        Flow flow = lookupFlowConstruct("getSandbox");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "GET";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Sandbox";
        String expectedParams = "{}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    public void testUpdateSandbox() throws Exception {
        Flow flow = lookupFlowConstruct("updateSandbox");
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String expectedMethod = "POST";
        String expectedUri = "/2010-04-01/Accounts/AC970e46372f082a4947642b9cf19cafa7/Sandbox";
        String expectedParams = "{VoiceMethod=GET, VoiceUrl=some-voice-url, SmsUrl=some-sms-url, SmsMethod=GET}";
        assertEquals(expectedMethod + " " + expectedUri + " " + expectedParams, responseEvent.getMessage().getPayloadAsString());
    }

    private Flow lookupFlowConstruct(String name) {
        return (Flow) muleContext.getRegistry().lookupFlowConstruct(name);
    }

    private RequestToTwilio runFlow(String flowName) throws Exception {
        Flow flow = lookupFlowConstruct(flowName);
        MuleEvent responseEvent = flow.process(getTestEvent("<anyPayload/>"));
        String request = responseEvent.getMessage().getPayloadAsString();
        String httpMethod = request.substring(0, request.indexOf(" "));
        String uri = request.substring(request.indexOf("/"), request.indexOf("{")).trim();
        String parameters = request.substring(request.indexOf("{"));
        return new RequestToTwilio(httpMethod, uri, parameters);
    }

    private final class RequestToTwilio {

        private String httpMethod;
        private String url;
        private String parameters;

        private RequestToTwilio(String httpMethod, String url, String parameters) {
            this.httpMethod = httpMethod;
            this.url = url;
            this.parameters = parameters;
        }

        public String getHttpMethod() {
            return httpMethod;
        }

        public String getUrl() {
            return url;
        }

        public String getParameters() {
            return parameters;
        }
    }
}