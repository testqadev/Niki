$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("DomainZ.feature");
formatter.feature({
  "line": 1,
  "name": "DomainZ",
  "description": "",
  "id": "domainz",
  "keyword": "Feature"
});
formatter.before({
  "duration": 11363391865,
  "status": "passed"
});
formatter.scenario({
  "line": 47,
  "name": "A customer recharge prepaid account from console using new credit card",
  "description": "",
  "id": "domainz;a-customer-recharge-prepaid-account-from-console-using-new-credit-card;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 22,
      "name": "@FunctionalAutomation1"
    }
  ]
});
formatter.step({
  "line": 25,
  "name": "Enter User name fnurani",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 26,
  "name": "Enter Password comein22",
  "matchedColumns": [
    1
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "Click on Login button",
  "keyword": "Then "
});
formatter.step({
  "line": 28,
  "name": "Enter Greencode in Account reference field PAY-308",
  "matchedColumns": [
    2
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 29,
  "name": "Click on Submit button",
  "keyword": "Then "
});
formatter.step({
  "line": 30,
  "name": "Click on View invoice and prepaid detail",
  "keyword": "Then "
});
formatter.step({
  "line": 31,
  "name": "Click on prepaid account details",
  "keyword": "Then "
});
formatter.step({
  "line": 32,
  "name": "Enter visa card owner name Test User - VISA",
  "matchedColumns": [
    3
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 33,
  "name": "Switch admin to iframe card number",
  "keyword": "Then "
});
formatter.step({
  "line": 34,
  "name": "Enter credit card number 4111111111111111",
  "matchedColumns": [
    4
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 35,
  "name": "Switch admin iframe to emp months",
  "keyword": "Then "
});
formatter.step({
  "line": 36,
  "name": "Enter expiry month 01",
  "matchedColumns": [
    5
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 37,
  "name": "Switch admin to iframe card expiry year",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "Enter expiry year 2019",
  "matchedColumns": [
    6
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 39,
  "name": "Switch admin to iframe card cvv",
  "keyword": "Then "
});
formatter.step({
  "line": 40,
  "name": "Enter CVV 456",
  "matchedColumns": [
    7
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 41,
  "name": "Enter amount in purchase credit field 10",
  "matchedColumns": [
    8
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 42,
  "name": "Click on purchase credit button",
  "keyword": "Then "
});
formatter.step({
  "line": 43,
  "name": "Verify success message Credit purchased successfully",
  "matchedColumns": [
    9
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "fnurani",
      "offset": 16
    }
  ],
  "location": "DomainZ.Enter_user_name(String)"
});
formatter.result({
  "duration": 6824401811,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "comein22",
      "offset": 15
    }
  ],
  "location": "DomainZ.Enter_password(String)"
});
formatter.result({
  "duration": 159220163,
  "status": "passed"
});
formatter.match({
  "location": "DomainZ.Click_on_login_button()"
});
formatter.result({
  "duration": 2735561047,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "PAY-308",
      "offset": 43
    }
  ],
  "location": "DomainZ.Enter_greencode(String)"
});
formatter.result({
  "duration": 155010539,
  "status": "passed"
});
formatter.match({
  "location": "DomainZ.Click_on_submit_button()"
});
formatter.result({
  "duration": 11975691933,
  "status": "passed"
});
formatter.match({
  "location": "DomainZ.Click_on_viewe_invoice()"
});
formatter.result({
  "duration": 2017872403,
  "status": "passed"
});
formatter.match({
  "location": "DomainZ.Click_on_prepaid_account()"
});
formatter.result({
  "duration": 1351940922,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Test User - VISA",
      "offset": 27
    }
  ],
  "location": "DomainZ.Enter_card_owner_name_purchase_credit(String)"
});
formatter.result({
  "duration": 291027232,
  "status": "passed"
});
formatter.match({
  "location": "DomainZ.switch_ato_iframe()"
});
formatter.result({
  "duration": 2680827351,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "4111111111111111",
      "offset": 25
    }
  ],
  "location": "DomainZ.Enter_credit_card_number_purchase_credit(String)"
});
formatter.result({
  "duration": 1215264907,
  "status": "passed"
});
formatter.match({
  "location": "DomainZ.Switch_admin_iframe_to_emp_months()"
});
formatter.result({
  "duration": 72683064,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "01",
      "offset": 19
    }
  ],
  "location": "DomainZ.Enter_credit_card_expiry_month(String)"
});
formatter.result({
  "duration": 116973299,
  "status": "passed"
});
formatter.match({
  "location": "DomainZ.switch_ato_iframe_expity_year()"
});
formatter.result({
  "duration": 61185215,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "2019",
      "offset": 18
    }
  ],
  "location": "DomainZ.Enter_credit_card_expiry_year(String)"
});
formatter.result({
  "duration": 116412082,
  "status": "passed"
});
formatter.match({
  "location": "DomainZ.switch_ato_iframe_CVV()"
});
formatter.result({
  "duration": 60104071,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "456",
      "offset": 10
    }
  ],
  "location": "DomainZ.Enter_credit_card_CVV_number(String)"
});
formatter.result({
  "duration": 158354058,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10",
      "offset": 38
    }
  ],
  "location": "DomainZ.Enter_amount_purchase_credit(String)"
});
formatter.result({
  "duration": 165664084,
  "status": "passed"
});
formatter.match({
  "location": "DomainZ.Click_on_purchase_credit()"
});
formatter.result({
  "duration": 11065449672,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Credit purchased successfully",
      "offset": 23
    }
  ],
  "location": "DomainZ.Verify_success_message(String)"
});
formatter.result({
  "duration": 1815467592,
  "status": "passed"
});
formatter.after({
  "duration": 1166593280,
  "status": "passed"
});
});