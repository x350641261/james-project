/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/

package org.apache.james.transport.mailets.remoteDelivery;

import java.util.Collection;

import javax.mail.internet.InternetAddress;

import org.apache.mailet.MailAddress;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.FluentIterable;

public class InternetAddressConverter {

    public static InternetAddress[] convert(Collection<MailAddress> recipients) {
        Preconditions.checkNotNull(recipients);
        return FluentIterable.from(recipients).transform(new Function<MailAddress, InternetAddress>() {
            @Override
            public InternetAddress apply(MailAddress input) {
                return input.toInternetAddress();
            }
        }).toArray(InternetAddress.class);
    }

}
