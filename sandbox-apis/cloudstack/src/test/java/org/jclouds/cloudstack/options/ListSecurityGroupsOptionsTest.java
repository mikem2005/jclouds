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

package org.jclouds.cloudstack.options;

import static org.jclouds.cloudstack.options.ListSecurityGroupsOptions.Builder.account;
import static org.jclouds.cloudstack.options.ListSecurityGroupsOptions.Builder.domainId;
import static org.jclouds.cloudstack.options.ListSecurityGroupsOptions.Builder.id;
import static org.jclouds.cloudstack.options.ListSecurityGroupsOptions.Builder.securityGroupName;
import static org.jclouds.cloudstack.options.ListSecurityGroupsOptions.Builder.virtualMachineId;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.google.common.collect.ImmutableList;

/**
 * Tests behavior of {@code ListSecurityGroupsOptions}
 * 
 * @author Adrian Cole
 */
@Test(groups = "unit")
public class ListSecurityGroupsOptionsTest {

   public void testId() {
      ListSecurityGroupsOptions options = new ListSecurityGroupsOptions().id(6);
      assertEquals(ImmutableList.of("6"), options.buildQueryParameters().get("id"));
   }

   public void testIdStatic() {
      ListSecurityGroupsOptions options = id(6);
      assertEquals(ImmutableList.of("6"), options.buildQueryParameters().get("id"));
   }

   public void testAccount() {
      ListSecurityGroupsOptions options = new ListSecurityGroupsOptions().account("account");
      assertEquals(ImmutableList.of("account"), options.buildQueryParameters().get("account"));
   }

   public void testAccountStatic() {
      ListSecurityGroupsOptions options = account("account");
      assertEquals(ImmutableList.of("account"), options.buildQueryParameters().get("account"));
   }

   public void testName() {
      ListSecurityGroupsOptions options = new ListSecurityGroupsOptions().securityGroupName("securityGroupName");
      assertEquals(ImmutableList.of("securityGroupName"), options.buildQueryParameters().get("securitygroupname"));
   }

   public void testNameStatic() {
      ListSecurityGroupsOptions options = securityGroupName("securityGroupName");
      assertEquals(ImmutableList.of("securityGroupName"), options.buildQueryParameters().get("securitygroupname"));
   }

   public void testDomainId() {
      ListSecurityGroupsOptions options = new ListSecurityGroupsOptions().domainId(6);
      assertEquals(ImmutableList.of("6"), options.buildQueryParameters().get("domainid"));
   }

   public void testDomainIdStatic() {
      ListSecurityGroupsOptions options = domainId(6);
      assertEquals(ImmutableList.of("6"), options.buildQueryParameters().get("domainid"));
   }

   public void testVirtualMachineId() {
      ListSecurityGroupsOptions options = new ListSecurityGroupsOptions().virtualMachineId(6);
      assertEquals(ImmutableList.of("6"), options.buildQueryParameters().get("virtualmachineid"));
   }

   public void testVirtualMachineIdStatic() {
      ListSecurityGroupsOptions options = virtualMachineId(6);
      assertEquals(ImmutableList.of("6"), options.buildQueryParameters().get("virtualmachineid"));
   }
}
