/*
 * Copyright 2017-Present the original author or authors.
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
 package agency;

import org.springframework.stereotype.Component;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@FeignClient(name = "company", fallback = CompanyClient.CompanyFallback.class)
public interface CompanyClient {
  @RequestMapping(method = GET, value="/available")
  String availableGuide();

@Component
  public static class CompanyFallback implements CompanyClient {
    @Override
    public String availableGuide() {
      return "None available!";
    }
  }
}
