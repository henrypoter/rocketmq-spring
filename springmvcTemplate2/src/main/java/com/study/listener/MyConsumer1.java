package com.study.listener;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.common.UtilAll;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQPushConsumerLifecycleListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * @author henrypoter
 * @create 2019-11-15 16:52
 */
@Service
@RocketMQMessageListener(topic = "test-topic", consumerGroup = "my-consumer_test-topic-1")
public class MyConsumer1 implements RocketMQListener<String>, RocketMQPushConsumerLifecycleListener {
    private static final Logger LOG = LoggerFactory.getLogger(MyConsumer1.class);
    @Override
    public void onMessage(String message) {
        LOG.info("received message: {}", message);
        System.out.printf("MyConsumer1 onMessage %s \n",message);
    }

    @Override
    public void prepareStart(final DefaultMQPushConsumer consumer) {
        // set consumer consume message from now
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_TIMESTAMP);
        consumer.setConsumeTimestamp(UtilAll.timeMillisToHumanString3(System.currentTimeMillis()));
    }
}