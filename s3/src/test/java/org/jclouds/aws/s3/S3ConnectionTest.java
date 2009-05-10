/**
 *
 * Copyright (C) 2009 Adrian Cole <adrian@jclouds.org>
 *
 * ====================================================================
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * ====================================================================
 */
package org.jclouds.aws.s3;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.jclouds.aws.s3.domain.S3Bucket;
import org.testng.annotations.Test;

/**
 * Tests connection by listing all the buckets and their size
 * 
 * @author Adrian Cole
 * 
 */
@Test(groups = "unit", testName = "s3.S3ConnectionTest")
public class S3ConnectionTest extends S3IntegrationTest {

    @Test
    void testListBuckets() throws Exception {
	List<S3Bucket.Metadata> myBuckets = client.getOwnedBuckets().get(10,
		TimeUnit.SECONDS);
	for (S3Bucket.Metadata bucket : myBuckets) {
	    context.createInputStreamMap(bucket.getName()).size();
	}
    }

}