/**
 *
 * Copyright (C) 2010 Cloud Conscious, LLC. <info@cloudconscious.com>
 *
 * ====================================================================
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * ====================================================================
 */

package org.jclouds.cloudstack.features;

import java.io.IOException;
import java.lang.reflect.Method;

import org.jclouds.cloudstack.options.DeployVirtualMachineOptions;
import org.jclouds.cloudstack.options.ListVirtualMachinesOptions;
import org.jclouds.http.HttpRequest;
import org.jclouds.http.functions.UnwrapOnlyJsonValue;
import org.jclouds.http.functions.UnwrapOnlyNestedJsonValue;
import org.jclouds.http.functions.UnwrapOnlyNestedJsonValueInSet;
import org.jclouds.rest.functions.MapHttp4xxCodesToExceptions;
import org.jclouds.rest.functions.ReturnEmptySetOnNotFoundOr404;
import org.jclouds.rest.functions.ReturnNullOnNotFoundOr404;
import org.jclouds.rest.internal.RestAnnotationProcessor;
import org.testng.annotations.Test;

import com.google.inject.TypeLiteral;

/**
 * Tests behavior of {@code VirtualMachineAsyncClient}
 * 
 * @author Adrian Cole
 */
// NOTE:without testName, this will not call @Before* and fail w/NPE during surefire
@Test(groups = "unit", testName = "VirtualMachineAsyncClientTest")
public class VirtualMachineAsyncClientTest extends BaseCloudStackAsyncClientTest<VirtualMachineAsyncClient> {
   public void testListVirtualMachines() throws SecurityException, NoSuchMethodException, IOException {
      Method method = VirtualMachineAsyncClient.class.getMethod("listVirtualMachines",
            ListVirtualMachinesOptions[].class);
      HttpRequest httpRequest = processor.createRequest(method);

      assertRequestLineEquals(httpRequest,
            "GET http://localhost:8080/client/api?response=json&command=listVirtualMachines HTTP/1.1");
      assertNonPayloadHeadersEqual(httpRequest, "Accept: application/json\n");
      assertPayloadEquals(httpRequest, null, null, false);

      assertResponseParserClassEquals(method, httpRequest, UnwrapOnlyNestedJsonValue.class);
      assertSaxResponseParserClassEquals(method, null);
      assertExceptionParserClassEquals(method, ReturnEmptySetOnNotFoundOr404.class);

      checkFilters(httpRequest);

   }

   public void testListVirtualMachinesOptions() throws SecurityException, NoSuchMethodException, IOException {
      Method method = VirtualMachineAsyncClient.class.getMethod("listVirtualMachines",
            ListVirtualMachinesOptions[].class);
      HttpRequest httpRequest = processor.createRequest(method,
            ListVirtualMachinesOptions.Builder.accountInDomain("adrian", 6).usesVirtualNetwork(true));

      assertRequestLineEquals(
            httpRequest,
            "GET http://localhost:8080/client/api?response=json&command=listVirtualMachines&account=adrian&domainid=6&forvirtualnetwork=true HTTP/1.1");
      assertNonPayloadHeadersEqual(httpRequest, "Accept: application/json\n");
      assertPayloadEquals(httpRequest, null, null, false);

      assertResponseParserClassEquals(method, httpRequest, UnwrapOnlyNestedJsonValue.class);
      assertSaxResponseParserClassEquals(method, null);
      assertExceptionParserClassEquals(method, ReturnEmptySetOnNotFoundOr404.class);

      checkFilters(httpRequest);

   }

   public void testGetVirtualMachine() throws SecurityException, NoSuchMethodException, IOException {
      Method method = VirtualMachineAsyncClient.class.getMethod("getVirtualMachine", long.class);
      HttpRequest httpRequest = processor.createRequest(method, 5);

      assertRequestLineEquals(httpRequest,
            "GET http://localhost:8080/client/api?response=json&command=listVirtualMachines&id=5 HTTP/1.1");
      assertNonPayloadHeadersEqual(httpRequest, "Accept: application/json\n");
      assertPayloadEquals(httpRequest, null, null, false);

      assertResponseParserClassEquals(method, httpRequest, UnwrapOnlyNestedJsonValueInSet.class);
      assertSaxResponseParserClassEquals(method, null);
      assertExceptionParserClassEquals(method, ReturnNullOnNotFoundOr404.class);

      checkFilters(httpRequest);

   }

   public void testDeployVirtualMachine() throws SecurityException, NoSuchMethodException, IOException {
      Method method = VirtualMachineAsyncClient.class.getMethod("deployVirtualMachine", long.class, long.class,
            long.class, DeployVirtualMachineOptions[].class);
      HttpRequest httpRequest = processor.createRequest(method, 4, 5, 6);

      assertRequestLineEquals(
            httpRequest,
            "GET http://localhost:8080/client/api?response=json&command=deployVirtualMachine&serviceofferingid=4&zoneid=6&templateid=5 HTTP/1.1");
      assertNonPayloadHeadersEqual(httpRequest, "Accept: application/json\n");
      assertPayloadEquals(httpRequest, null, null, false);

      assertResponseParserClassEquals(method, httpRequest, UnwrapOnlyJsonValue.class);
      assertSaxResponseParserClassEquals(method, null);
      assertExceptionParserClassEquals(method, MapHttp4xxCodesToExceptions.class);

      checkFilters(httpRequest);

   }

   public void testDestroyVirtualMachine() throws SecurityException, NoSuchMethodException, IOException {
      Method method = VirtualMachineAsyncClient.class.getMethod("destroyVirtualMachine", long.class);
      HttpRequest httpRequest = processor.createRequest(method, 5);

      assertRequestLineEquals(httpRequest,
            "GET http://localhost:8080/client/api?response=json&command=destroyVirtualMachine&id=5 HTTP/1.1");
      assertNonPayloadHeadersEqual(httpRequest, "Accept: application/json\n");
      assertPayloadEquals(httpRequest, null, null, false);

      assertResponseParserClassEquals(method, httpRequest, UnwrapOnlyNestedJsonValue.class);
      assertSaxResponseParserClassEquals(method, null);
      assertExceptionParserClassEquals(method, ReturnNullOnNotFoundOr404.class);

      checkFilters(httpRequest);

   }

   @Override
   protected TypeLiteral<RestAnnotationProcessor<VirtualMachineAsyncClient>> createTypeLiteral() {
      return new TypeLiteral<RestAnnotationProcessor<VirtualMachineAsyncClient>>() {
      };
   }
}
