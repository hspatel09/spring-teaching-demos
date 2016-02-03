/*
 * Copyright 2002-2012 the original author or authors.
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

package com.demo.ex;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.ex.service.SimpleGateway;

/**
 * When processing synchronously, we expect a downstream
 * error to come back to the caller.
 * 
 * @author kenk
 * @since 1.0
 * 
 */
public class SyncErrorHandlingTest {



	@Test
	public void testConvertStringToUpperCase() {
		ApplicationContext context
			= new ClassPathXmlApplicationContext("/si-sync.xml",
												SyncErrorHandlingTest.class);

		SimpleGateway service = context.getBean(SimpleGateway.class);

		try{
			service.divideByZero(100);
			fail("Exception expected");
		} catch (Exception e){
			System.out.println(e);
		}
	}

}
