package com.study.listener;

import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.springframework.messaging.Message;

/**
 * @author henrypoter
 * @create 2019-11-15 16:17
 */
// Define transaction listener with the annotation @RocketMQTransactionListener
@RocketMQTransactionListener(txProducerGroup="test")
class TransactionListenerImpl implements RocketMQLocalTransactionListener {
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message msg, Object arg) {
        // ... local transaction process, return bollback, commit or unknown
        return RocketMQLocalTransactionState.UNKNOWN;
    }

    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message msg) {
        // ... check transaction status and return bollback, commit or unknown
        try {

            Thread.sleep(10000L);
        }catch (Exception e){

        }
        return RocketMQLocalTransactionState.ROLLBACK;
    }
}