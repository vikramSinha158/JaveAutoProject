$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/features/R1Contact/HomeAndReminder.feature");
formatter.feature({
  "name": "Home and Reminder Verfication",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "user navigates to account home page",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "user is on R1Contact home page",
  "keyword": "Given "
});
formatter.match({
  "location": "ReminderHeaderStepDef.user_is_on_R_Contact_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Reminder_Verify the \u0027Create Reminder\u0027 on the date where a reminder is already exist",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@408188"
    },
    {
      "name": "@homeReminder"
    }
  ]
});
formatter.step({
  "name": "user is on R1Contact home page",
  "keyword": "Given "
});
formatter.match({
  "location": "ReminderHeaderStepDef.user_is_on_R_Contact_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user should be able to see Agent Information",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeReminderStepDef.user_should_be_able_to_see_Agent_Information()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Reminders list(If any reminder set by the agent)",
  "keyword": "And "
});
formatter.match({
  "location": "HomeReminderStepDef.reminders_list_If_any_reminder_set_by_the_agent()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Home, My Tabs and other Tabs",
  "keyword": "And "
});
formatter.match({
  "location": "HomeReminderStepDef.home_My_Tabs_and_other_Tabs()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user Click on \u0027Search\u0027 account link",
  "keyword": "When "
});
formatter.match({
  "location": "HomeReminderStepDef.user_Click_on_Search_account_link()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Search account page should be displayed with searching criterias like..Account Number, First Name, Last Name etc",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeReminderStepDef.search_account_page_should_be_displayed_with_searching_criterias_like_Account_Number_First_Name_Last_Name_etc()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Enter last name as \"K\" and press ENTER and List of Accounts should be displayed",
  "keyword": "When "
});
formatter.match({
  "location": "HomeReminderStepDef.enter_last_name_as_and_press_ENTER_and_List_of_Accounts_should_be_displayed(String)"
});
formatter.result({
  "error_message": "java.lang.AssertionError: Number of row not match for search element K expected:\u003c49\u003e but was:\u003c48\u003e\r\n\tat org.junit.Assert.fail(Assert.java:88)\r\n\tat org.junit.Assert.failNotEquals(Assert.java:834)\r\n\tat org.junit.Assert.assertEquals(Assert.java:645)\r\n\tat r1.pages.ReminderPage.verifyFirstCharForLastName(ReminderPage.java:217)\r\n\tat r1.steps.definitions.HomeReminderStepDef.enter_last_name_as_and_press_ENTER_and_List_of_Accounts_should_be_displayed(HomeReminderStepDef.java:55)\r\n\tat ✽.Enter last name as \"K\" and press ENTER and List of Accounts should be displayed(src/test/resources/features/R1Contact/HomeAndReminder.feature:40)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "Pick one account from the list by click on Arrow",
  "keyword": "When "
});
formatter.match({
  "location": "HomeReminderStepDef.pick_one_account_from_the_list_by_click_on_Arrow()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Verify the \u0027Set a reminder\u0027 icon",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeReminderStepDef.verify_the_Set_a_reminder_icon()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Click on the \u0027Set a reminder\u0027 icon",
  "keyword": "When "
});
formatter.match({
  "location": "HomeReminderStepDef.click_on_the_Set_a_reminder_icon()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "A pop up window should be displayed and user would be able to submit Reminder by filling required details",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeReminderStepDef.a_pop_up_window_should_be_displayed_and_user_would_be_able_to_submit_Reminder_by_filling_required_details()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Save reminder by hitting \u0027Save reminder\u0027 button",
  "keyword": "And "
});
formatter.match({
  "location": "HomeReminderStepDef.save_reminder_by_hitting_Save_reminder_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "An alert should be displayed with the below alert message.Reminder on account already exists",
  "keyword": "Then "
});
formatter.match({
  "location": "HomeReminderStepDef.an_alert_should_be_displayed_with_the_below_alert_message_Reminder_on_account_already_exists()"
});
formatter.result({
  "status": "skipped"
});
});