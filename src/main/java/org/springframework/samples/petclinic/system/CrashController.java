/*
 * Copyright 2012-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.samples.petclinic.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * コントローラーは例外がスローされたときに何が起こるかを示すために使用されます。
 *
 * @author Michael Isvy
 *         <p/>
 *         また、"error" に解決されるビューが追加された方法も参照してください
 *         ("error.html")。
 */
@Controller
class CrashController {

	@GetMapping("/oups")
	public String triggerException() {
		// 例外をスローして、例外がスローされたときに何が起こるかを示します。
		throw new ShowcaseException(
				"Expected: controller used to showcase what " + "happens when an exception is thrown");
	}

}
