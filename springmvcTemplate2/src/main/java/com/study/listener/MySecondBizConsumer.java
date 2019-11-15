/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.study.listener;

import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.support.RocketMQUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
@RocketMQMessageListener(/*nameServer = "192.168.11.188:9876",*/ consumerGroup = "string-topic-consumer", topic = "string-topic")
public class MySecondBizConsumer implements RocketMQListener<MessageExt> {

    private static final Logger LOG = LoggerFactory.getLogger(MySecondBizConsumer.class);
//C0A80BB423435B2133B14B89A4240010
    //C0A80BB423435B2133B14B85862D000E
    @Override
    public void onMessage(MessageExt msg) {
        LOG.error("MySecondBizConsumer onMessage:{}",msg);
        System.out.printf("second-consumer msg comming \n");
        System.out.printf("------- msg received: %s \n", msg);
        RocketMQUtil.appendLineToFile("F:/logs/2.txt", String.format(" on msg ..second-consumer msgid: %s  msg:%s", msg.getMsgId(), msg.toString()));
        //throw new RuntimeException("exception..");
    }


}
