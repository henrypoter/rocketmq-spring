package com.study.listener;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.SelectorType;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.support.RocketMQUtil;
import org.springframework.stereotype.Service;

/**
 * @author henrypoter
 * @create 2019-11-14 19:54
 */
@Service
@RocketMQMessageListener(nameServer = "192.168.11.180:9876",consumerGroup = "abc2222", topic = "topic-on-broker-a",selectorType = SelectorType.TAG,selectorExpression = "*")
public class TestCustomNameServerListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String message) {
        System.out.printf("==================msg: %s %n",message.toString());

    }
}