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

package org.jclouds.http;

import java.net.URI;

import org.testng.annotations.Test;

/**
 * Tests parsing of a request
 * 
 * @author Adrian Cole
 */
@Test(testName = "http.HttpRequestTest")
public class HttpRequestTest {
   @Test(expectedExceptions = IllegalArgumentException.class)
   public void testConstructorHostNull() throws Exception {
      URI uri = URI.create("http://adriancole.compute1138eu.s3-external-3.amazonaws.com:-1");
      assert uri.getHost() == null : "test requires something to produce a uri with a null hostname";

      new HttpRequest("GET", uri);
   }
}
