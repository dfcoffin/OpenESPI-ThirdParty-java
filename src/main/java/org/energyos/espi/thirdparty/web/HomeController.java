/*
 * Copyright 2013 EnergyOS.org
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package org.energyos.espi.thirdparty.web;

import org.energyos.espi.thirdparty.domain.RetailCustomer;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.security.Principal;

@Controller
@RequestMapping("/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String index(Principal principal) {
        if (principal == null) {
            return "home";
        } else {
            return "redirect:/RetailCustomer/" + currentCustomer(principal).getId() + "/home";
        }
    }

    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String home(Principal principal) {
        return index(principal);
    }

    private RetailCustomer currentCustomer(Principal principal) {
        return (RetailCustomer) ((Authentication) principal).getPrincipal();
    }

    @RequestMapping(value = "/TermsOfService", method = RequestMethod.GET)
    public String termsOfService() {
        return "/TermsOfService";
    }

    @RequestMapping(value = "/UsagePolicy", method = RequestMethod.GET)
    public String usagePolicy() {
        return "/UsagePolicy";
    }
}