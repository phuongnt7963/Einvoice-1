package com.seatech.ibs.admin.delegate.jms;

import com.geong.ibs.bttmessage.Head;
import com.seatech.ibs.jms.BTTMessageFormatService;
import com.seatech.ibs.jms.BTTMessageLogs;
import com.seatech.ibs.jms.JMSSendService;
import com.ibm.btt.base.DataElement;
import com.ibm.btt.sm.HttpSessionInfoHolder;
import com.seatech.ibs.common.dto.InterfaceMessage;
import com.seatech.ibs.service.exception.MQConnectionException;
import com.seatech.ibs.service.exception.MQTimeOutExcepiton;

import java.util.List;
import java.util.Map;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class MessageSendDelegate
{

    public MessageSendDelegate()
    {
    }

    protected Object getBean(String beanId)
    {
        return WebApplicationContextUtils.getWebApplicationContext(HttpSessionInfoHolder.getHttpSession().getServletContext()).getBean(beanId);
    }

    public void setContextName(String contextName)
    {
        this.contextName = contextName;
    }

    @SuppressWarnings("rawtypes")
	public void fillSendMsg(Map requestDate, Map summary, List records, DataElement reqMsgData, Head headData)
    {
        bttMessageFormatService = (BTTMessageFormatService)getBean("bttMessageFormatService");
        bttMessageFormatService.fillSendMessage(requestDate, summary, records, reqMsgData, headData);
    }

    public String sendSynchronizationMsg(String message, String messageSn)
        throws MQTimeOutExcepiton, MQConnectionException
    {
        sendService = (JMSSendService)getBean("jmsSendService");
        sendService.setContextName(contextName);
        return sendService.sendSynchronizationMessage(message, messageSn);
    }

    public void addBttMessageLog(InterfaceMessage interfaceMessage)
        throws Exception
    {
        bttMessageLogs = (BTTMessageLogs)getBean("bttMessageLogs");
        bttMessageLogs.addBttMessageLog(interfaceMessage);
    }

    private JMSSendService sendService;
    private BTTMessageFormatService bttMessageFormatService;
    private String contextName;
    private BTTMessageLogs bttMessageLogs;
}