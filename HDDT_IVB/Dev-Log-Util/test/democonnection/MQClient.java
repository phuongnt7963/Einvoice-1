/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democonnection;

/**
 *
 * @author TanDN
 */
import com.ibm.mq.MQC;
import com.ibm.mq.MQEnvironment;
import com.ibm.mq.MQException;
import com.ibm.mq.MQGetMessageOptions;
import com.ibm.mq.MQMessage;
import com.ibm.mq.MQPutMessageOptions;
import com.ibm.mq.MQQueue;
import com.ibm.mq.MQQueueManager;

import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;

public class MQClient {
    //Thông số trục trong

    public MQClient() {
        super();
    }
    private static MQQueueManager qMgr;

    private String mqHostName = "";
    private String mqChanel = "";
    private String mqPort = "0";
    private String mqQmanagerName = "";
    private String mqName = "";
    private byte[] content_mes_esb;

    public void putMsgToQueue() throws Exception {
        try {
            MQEnvironment.hostname = mqHostName;
            MQEnvironment.channel = mqChanel; //Kenh ket noi MQ
            MQEnvironment.port = Integer.parseInt(mqPort); // 1515;
            qMgr = new MQQueueManager(mqQmanagerName); //Ten Queue manager
            int openInputOptions = MQC.MQOO_OUTPUT + MQC.MQOO_FAIL_IF_QUIESCING;
            MQQueue queueIn = qMgr.accessQueue(mqName, openInputOptions, null, null, null);
            MQPutMessageOptions putOptions = new MQPutMessageOptions();
            putOptions.options = MQC.MQPMO_NEW_MSG_ID | MQC.MQPMO_NEW_CORREL_ID;
            MQMessage mqMessage = new MQMessage();
            mqMessage.format = MQC.MQFMT_STRING;
            mqMessage.characterSet = 1208;
           
            
            mqMessage.write(content_mes_esb);
            queueIn.put(mqMessage, putOptions);
        } catch (Exception e) {
            throw e;
        } finally {
            disconnectMQ();
        }
    }

    public Collection getMsgFromQueue() throws Exception {
        Collection listMess = new ArrayList();
        String mes_content = "";
        int max_depth = 5;
        try {
            MQEnvironment.hostname = mqHostName;
            MQEnvironment.channel = mqChanel; //Kenh ket noi MQ
            MQEnvironment.port = Integer.parseInt(mqPort); // 1515;
            qMgr = new MQQueueManager(mqQmanagerName); //Ten Queue manager
            int openInputOptions = MQC.MQOO_INPUT_AS_Q_DEF | MQC.MQOO_INQUIRE;
            MQQueue queue = qMgr.accessQueue(mqName, openInputOptions, null, null, null);
            int depth = queue.getCurrentDepth();
            int t_depth = depth;
            if (t_depth > 5) {
                t_depth = max_depth;
            }
            MQGetMessageOptions getMessageOptions = null;
            //            getMessageOptions.options = MQC.MQOO_INPUT_AS_Q_DEF;
            //            getMessageOptions.waitInterval = MQC.MQWI_UNLIMITED;
            MQMessage mqMessage = null;
            while (t_depth > 0) {
                try {
                    mqMessage = new MQMessage();
                    getMessageOptions = new MQGetMessageOptions();
                    mqMessage.format = MQC.MQFMT_STRING;
                    mqMessage.characterSet = 1208;
                    queue.get(mqMessage, getMessageOptions);
                    byte[] b = new byte[mqMessage.getMessageLength()];
                    mqMessage.readFully(b);
                    mes_content = new String(b, "UTF-8");
                    listMess.add(mes_content);
                    mqMessage.clearMessage();
                    t_depth--;
                } catch (IOException e) {
                    // System.out.println("IOException: " + e.getMessage());
                    break;
                } catch (MQException e) {
                    if (e.completionCode == 2 && e.reasonCode == MQException.MQRC_NO_MSG_AVAILABLE) {
                        System.out.println("All messages read.");
                    } else {
                        break;
                    }
                }
            }

        } catch (Exception e) {
            throw e;
        } finally {
            disconnectMQ();
        }
        return listMess;
    }

    public void disconnectMQ() throws Exception {
        try {
            if (qMgr != null) {
                if (qMgr.isConnected()) {
                    qMgr.disconnect();
                }
            }
        } catch (MQException e) {
            throw e;
        }
    }

    public static void setQMgr(MQQueueManager qMgr) {
        MQClient.qMgr = qMgr;
    }

    public static MQQueueManager getQMgr() {
        return qMgr;
    }

    public void setMqHostName(String mqHostName) {
        this.mqHostName = mqHostName;
    }

    public String getMqHostName() {
        return mqHostName;
    }

    public void setMqChanel(String mqChanel) {
        this.mqChanel = mqChanel;
    }

    public String getMqChanel() {
        return mqChanel;
    }

    public void setMqPort(String mqPort) {
        this.mqPort = mqPort;
    }

    public String getMqPort() {
        return mqPort;
    }

    public void setMqQmanagerName(String mqQmanagerName) {
        this.mqQmanagerName = mqQmanagerName;
    }

    public String getMqQmanagerName() {
        return mqQmanagerName;
    }

    public void setMqName(String mqName) {
        this.mqName = mqName;
    }

    public String getMqName() {
        return mqName;
    }

    public void setContent_mes_esb(byte[] content_mes_esb) {
        this.content_mes_esb = content_mes_esb;
    }

    public byte[] getContent_mes_esb() {
        return content_mes_esb;
    }
}
