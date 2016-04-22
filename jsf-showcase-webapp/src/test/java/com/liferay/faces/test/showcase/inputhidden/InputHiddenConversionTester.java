/**
 * Copyright (c) 2000-2016 Liferay, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.liferay.faces.test.showcase.inputhidden;

import org.junit.Test;

import com.liferay.faces.test.showcase.Browser;


/**
 * @author  Kyle Stiemann
 * @author  Philip White
 */
public class InputHiddenConversionTester extends InputHiddenTester {

	@Test
	public void runInputHiddenConversionTest() throws Exception {

		Browser browser = Browser.getInstance();
		browser.navigateToURL(inputHiddenURL + "conversion");

		// Wait to begin the test until the submit button is rendered.
		browser.waitForElementVisible(submitButtonXpath);

		// Test that a hidden valid value submits successfully.
		String text = "Apr 5, 0033";
		browser.click(copyValidValueButtonXpath);
		browser.clickAndWaitForAjaxRerender(submitButtonXpath);
		browser.assertElementTextVisible(modelValueXpath, text);

		// Test that the hidden value clears successfully.
		browser.click(clearButtonXpath);
		browser.clickAndWaitForAjaxRerender(submitButtonXpath);
		browser.assertElementPresent(modelValueEmptyXpath);

		// Test that a hidden valid value submits successfully.
		text = "04/05/0033";
		browser.click(copyValidValueButtonXpathRight);
		browser.clickAndWaitForAjaxRerender(submitButtonXpathRight);
		browser.assertElementTextVisible(modelValueXpathRight, text);

		// Test that the hidden value clears successfully.
		browser.click(clearButtonXpathRight);
		browser.clickAndWaitForAjaxRerender(submitButtonXpathRight);
		browser.assertElementPresent(modelValueEmptyXpathRight);
	}
}