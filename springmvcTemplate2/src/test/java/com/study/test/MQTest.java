package com.study.test;

import com.alibaba.fastjson.JSON;
import com.study.listener.TestCustomNameServerListener;
import com.study.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:springmvc.xml")
@WebAppConfiguration
public class MQTest
{

	private static final Logger logger = LogManager.getLogger(MQTest.class.getName());

    private static final String TEST_TOPIC = "test-topic";
    private static final String STRING_TOPIC = "string-topic";
    private static final String ORDERLY_TOPIC = "orderly-topic";


    @Resource
    RocketMQTemplate rocketMQTemplate;

	@Test
	public void TestG43395414etUser() throws Exception
	{
        for(int i=1;i<2;i++){
            SendResult ret = rocketMQTemplate.syncSend("string-topic:haha", "hello god string-topic " +i);
            System.out.printf("ret:%s \n",ret);
        }

        System.in.read();

    }


    @Test
    public void trans()throws Exception{
        // Build a SpringMessage for sending in transaction
        Message msg = MessageBuilder.withPayload("hello msg 3").build();
        // In sendMessageInTransaction(), the first parameter transaction name ("test")
        // must be same with the @RocketMQTransactionListener's member field 'txProducerGroup'
        TransactionSendResult r = rocketMQTemplate.sendMessageInTransaction("test", "test-topic", msg, null);
        System.out.printf("-----------------------r:%s",r);
    }

    @Test
    public void safsdf()throws Exception
    {


        System.out.printf("done");
        System.in.read();

    }




}