/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.integration.scala.dsl
import org.junit._

import java.util.concurrent._
/**
 * @author Oleg Zhurakousky
 *
 */
class DslComponentsTests{
  
  @Test
  def testChannel() {
    val anonymousDirectChannel = channel()
    assert(anonymousDirectChannel  != null)
    
    val directNamedChannel = channel.withName("someName")
    assert(directNamedChannel  != null)
    
    val anonymousQueueChannelNoCapacity = channel.withQueue()
    assert(anonymousQueueChannelNoCapacity  != null)
    
    val anonymousQueueChannelWithCapacity = channel.withQueue(5)
    assert(anonymousQueueChannelWithCapacity  != null)
    
    val namedQueueChannelA = channel.withName("foo").andQueue
    assert(namedQueueChannelA  != null)
    
    val namedQueueChannelB = channel.withQueue.andName("hjk")
    assert(namedQueueChannelB  != null)
    
    val anonymousAsyncChannelWithDefaultExecutor = channel.withExecutor
    assert(anonymousAsyncChannelWithDefaultExecutor  != null)
    
    val namedAsyncChannelWithDefaultExecutor = channel.withExecutor.andName("hjk")
    assert(namedAsyncChannelWithDefaultExecutor  != null)
    
    val namedAsyncChannelWithProvidedExecutor = channel.withName("hjk").andExecutor(Executors.newCachedThreadPool)
    assert(namedAsyncChannelWithProvidedExecutor  != null)
    
  }

}