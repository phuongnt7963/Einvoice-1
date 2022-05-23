/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package democonnection;

import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author TanDN
 */
public class DEMOConnection {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // TODO code application logic here
        MQClient mqclient = new MQClient();
        mqclient.setMqHostName("10.64.112.154");

        mqclient.setMqPort("1717");
        mqclient.setMqQmanagerName("ESB.EXT.QMGR");
        mqclient.setMqChanel("NTDT_MB.SVRCONN");
        mqclient.setMqName("NTDT_MB.OUTBOX.QUEUE");
        //testPutMessage(mqclient);
        testGetMessage(mqclient);
    }

	private static void testGetMessage(MQClient mqclient) {
		try {
            Collection msgFromQueue = mqclient.getMsgFromQueue();
            if(msgFromQueue!=null&&!msgFromQueue.isEmpty()){
            	Iterator iterator = msgFromQueue.iterator();
            	while(iterator.hasNext()){
            		Object next = iterator.next();
            	}
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

	private static void testPutMessage(MQClient mqclient) {
		try {
            mqclient.setContent_mes_esb("DU LIEU DAU VAO MESSAGE".getBytes("UTF-8"));
            mqclient.putMsgToQueue();
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
