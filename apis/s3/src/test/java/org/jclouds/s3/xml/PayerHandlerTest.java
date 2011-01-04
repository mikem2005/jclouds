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

package org.jclouds.s3.xml;

import static org.testng.Assert.assertEquals;

import org.jclouds.s3.domain.Payer;
import org.jclouds.http.HttpException;
import org.jclouds.http.functions.BaseHandlerTest;
import org.jclouds.http.functions.ParseSax;
import org.jclouds.util.Strings2;
import org.testng.annotations.Test;

/**
 * Tests behavior of {@code PayerHandler}
 * 
 * @author Adrian Cole
 */
// NOTE:without testName, this will not call @Before* and fail w/NPE during surefire
@Test(groups = "unit", testName = "PayerHandlerTest")
public class PayerHandlerTest extends BaseHandlerTest {

   ParseSax<Payer> createParser() {
      ParseSax<Payer> parser = (ParseSax<Payer>) factory.create(injector
               .getInstance(PayerHandler.class));
      return parser;
   }

   @Test
   public void testPayerRequester() throws HttpException {
      Payer payer = createParser()
               .parse(
                        Strings2
                                 .toInputStream("<RequestPaymentConfiguration xmlns=\"http://s3.amazonaws.com/doc/2006-03-01/\"><Payer>Requester</Payer></RequestPaymentConfiguration>"));
      assertEquals(payer, Payer.REQUESTER);

   }

   @Test
   public void testPayerBucketOwner() throws HttpException {
      Payer payer = createParser()
               .parse(
                        Strings2
                                 .toInputStream("<RequestPaymentConfiguration xmlns=\"http://s3.amazonaws.com/doc/2006-03-01/\"><Payer>BucketOwner</Payer></RequestPaymentConfiguration>"));
      assertEquals(payer, Payer.BUCKET_OWNER);

   }

}