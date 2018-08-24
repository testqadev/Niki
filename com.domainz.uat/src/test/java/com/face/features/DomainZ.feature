Feature: DomainZ 
@FunctionalAutomation
Scenario Outline: A customer recharge prepaid account from both console and DomainZ using existing credit card 	

	Given Enter User name <userName>
	Then Enter Password <Password>
	Then Click on Login button
	Then Enter Greencode in Account reference field <AccountReference>
	Then Click on Submit button
	Then Click on View invoice and prepaid detail
	Then Click on prepaid account details
	Then Select existing credit card
	Then Enter amount in purchase credit field <prepaidamount>
	Then Click on purchase credit button 
	Then Verify success message <prepaidsuccess> 
	
	
Examples:
	| userName   | Password | AccountReference | prepaidamount | prepaidsuccess                |  
	| fnurani    | comein22 | PAY-308          | 15            | Credit purchased successfully | 
	
@FunctionalAutomation1
Scenario Outline: A customer recharge prepaid account from console using new credit card 	

	Given Enter User name <userName>
	Then Enter Password <Password>
	Then Click on Login button
	Then Enter Greencode in Account reference field <AccountReference>
	Then Click on Submit button
	Then Click on View invoice and prepaid detail
	Then Click on prepaid account details
	Then Enter visa card owner name <CardOwnerName>
	Then Switch admin to iframe card number
	Then Enter credit card number <CardNumber>
	Then Switch admin iframe to emp months
	Then Enter expiry month <CardExpiryMonth>
	Then Switch admin to iframe card expiry year
	Then Enter expiry year <CardExpiryYear>
	Then Switch admin to iframe card cvv
	Then Enter CVV <CardCVV>
	Then Enter amount in purchase credit field <prepaidamount>
	Then Click on purchase credit button 
	Then Verify success message <prepaidsuccess> 
	
Examples:
	| userName   | Password | AccountReference | CardOwnerName    | CardNumber       | CardExpiryMonth | CardExpiryYear | CardCVV | prepaidamount | prepaidsuccess                |  
	| fnurani    | comein22 | PAY-308          | Test User - VISA | 4111111111111111 | 01              | 2019           | 456     | 10            | Credit purchased successfully | 


@FunctionalAutomation
Scenario Outline: A customer recharge prepaid account from both console and DomainZ using new credit card 	

	Given Enter User name <userName>
	Then Enter Password <Password>
	Then Click on Login button
	Then Enter Greencode in Account reference field <AccountReference>
	Then Click on Submit button
	Then Click on Login As Client
	Then Click on Account tab
	Then Click on Edit for prepaid account
	Then Click on rechrge using credit card
	Then Check using new credit card
	Then Enter Card owner name <cardOwner>
	Then Enter domainZ Card number <cardNumber>
	Then Select expiry month <expiryMonth>
	Then Select expiry year <expiryYear>
	Then Enter domainZ CVV number  <CVVnumber>
	Then Enter prepaid amount <prepaidamount>
	Then Click on submit button 
	

Examples:
	| userName   | Password | AccountReference | cardOwner        | cardNumber       | expiryMonth | expiryYear | CVVnumber | prepaidamount | prepaidsuccess                |  
	| fnurani    | comein22 | PAY-308          | Test User - VISA | 4111111111111111 | 08          | 2025       | 456       | 15            | Credit purchased successfully |
	
	

@FunctionalAutomation
Scenario Outline: Verification of field validation of card owner field, card number and CVV code 
	
	Given Enter domain name <domainname>
	Then Select domain service 
	Then Uncheck au domain service
	Then Click on search button
	Then Click on cotinue to checkout button
	Then Click on No thanks pop up
	Then Click on continue to account
	Then Enter organisation name <Organisationname>
	Then Enter first name <FirstName>
	Then Enter last name <LastName>
	Then Enter address <Address>
	Then Enter city name <CityName>
	Then Select state <State>
	Then Enter post code <PostCode> 
	Then Enter phone number <PhoneNumber>
	Then Enter email <Email>
	Then Enter confirmation mail <ConfirmationEmail>
	Then Click on continue to payment page
	Then Click on continue to registrant page
	Then Enter card owner name <CardOwner>
	Then Switch to iframe card number
	Then Enter card number <CardNumber>
	Then Switch to iframe card expiry month
	Then Select card expiry month <dropdownmonth>
	Then Switch to iframe card expiry year
	Then Select card expiry year <dropdownyear>
	Then Switch to iframe card cvv
	Then Enter card CVV number <CVV>
	Then Select I agree checkbox
	Then Click on continue button
	
Examples:
	| domainname      | Organisationname     | FirstName | LastName | Address               | CityName | State        | PostCode | PhoneNumber  | Email                      | ConfirmationEmail          | CardOwner              | CardNumber       | dropdownmonth | dropdownyear | CVV | 
	| testpgcard221   | Payment Gateway Test | QA        | Team     | 2/469 La Trobe Street | Auckland | North Island | 0626     | 064411111111 | testing@melbourneit.com.au | testing@melbourneit.com.au | AlphaNumeric0123456789 | 4111111111111111 | 12            | 2019         | 456 |
	| testpgcard221   | Payment Gateway Test | QA        | Team     | 2/469 La Trobe Street | Auckland | North Island | 0626     | 064411111111 | testing@melbourneit.com.au | testing@melbourneit.com.au | Test!"*#%&()^:;<>=?[/]_ | 4111111111111111 | 12            | 2019         | 456 |
	| testpgcard221   | Payment Gateway Test | QA        | Team     | 2/469 La Trobe Street | Auckland | North Island | 0626     | 064411111111 | testing@melbourneit.com.au | testing@melbourneit.com.au | Mr. John Doe | 4111111111111111 | 12            | 2019         | 456 |
	| testpgcard221   | Payment Gateway Test | QA        | Team     | 2/469 La Trobe Street | Auckland | North Island | 0626     | 064411111111 | testing@melbourneit.com.au | testing@melbourneit.com.au | Mr. Payment Gateway Test01 | 4111111111111111 | 12            | 2019         | 456 |

@FunctionalAutomation
Scenario Outline: A customer inputs invalid data in card number field.
	
	Given Enter domain name <domainname>
	Then Select domain service 
	Then Uncheck au domain service
	Then Click on search button
	Then Click on cotinue to checkout button
	Then Click on No thanks pop up
	Then Click on continue to account
	Then Enter organisation name <Organisationname>
	Then Enter first name <FirstName>
	Then Enter last name <LastName>
	Then Enter address <Address>
	Then Enter city name <CityName>
	Then Select state <State>
	Then Enter post code <PostCode> 
	Then Enter phone number <PhoneNumber>
	Then Enter email <Email>
	Then Enter confirmation mail <ConfirmationEmail>
	Then Click on continue to payment page
	Then Click on continue to registrant page
	Then Enter card owner name <CardOwner>
	Then Switch to iframe card number
	Then Enter card number <CardNumber>
	Then Switch to iframe card expiry month
	Then Select card expiry month <dropdownmonth>
	Then Switch to iframe card expiry year
	Then Select card expiry year <dropdownyear>
	Then Switch to iframe card cvv
	Then Enter card CVV number <CVV>
	Then Select I agree checkbox
	Then Verify alert message invalid card number <invalidCardNum>

Examples:
	| domainname      | Organisationname     | FirstName | LastName | Address               | CityName | State        | PostCode | PhoneNumber  | Email                      | ConfirmationEmail          | CardOwner              | CardNumber       | dropdownmonth | dropdownyear | CVV | invalidCardNum         |
	| testpgcard221   | Payment Gateway Test | QA        | Team     | 2/469 La Trobe Street | Auckland | North Island | 0626     | 064411111111 | testing@melbourneit.com.au | testing@melbourneit.com.au | Test Card Number Count | 555555555555444  | 12            | 2019         | 888 | Card Number is invalid |

@FunctionalAutomation
Scenario Outline: A customer inputs invalid data in CVV number field
	
	Given Enter domain name <domainname>
	Then Select domain service 
	Then Uncheck au domain service
	Then Click on search button
	Then Click on cotinue to checkout button
	Then Click on No thanks pop up
	Then Click on continue to account
	Then Enter organisation name <Organisationname>
	Then Enter first name <FirstName>
	Then Enter last name <LastName>
	Then Enter address <Address>
	Then Enter city name <CityName>
	Then Select state <State>
	Then Enter post code <PostCode> 
	Then Enter phone number <PhoneNumber>
	Then Enter email <Email>
	Then Enter confirmation mail <ConfirmationEmail>
	Then Click on continue to payment page
	Then Click on continue to registrant page
	Then Enter card owner name <CardOwner>
	Then Switch to iframe card number
	Then Enter card number <CardNumber>
	Then Switch to iframe card expiry month
	Then Select card expiry month <dropdownmonth>
	Then Switch to iframe card expiry year
	Then Select card expiry year <dropdownyear>
	Then Switch to iframe card cvv
	Then Enter card CVV number <CVV>
	Then Select I agree checkbox
	Then Verify alert message invalid cvv number <invalidCvvNum>

Examples:
| domainname      | Organisationname     | FirstName | LastName | Address               | CityName | State        | PostCode | PhoneNumber  | Email                      | ConfirmationEmail          | CardOwner              | CardNumber       | dropdownmonth | dropdownyear | CVV | invalidCvvNum                 |
| testpgcard221   | Payment Gateway Test | QA        | Team     | 2/469 La Trobe Street | Auckland | North Island | 0626     | 064411111111 | testing@melbourneit.com.au | testing@melbourneit.com.au | Test Card Number Count | 4111111111111111 | 12            | 2019         | 12  | Card Security Code is invalid |

@FunctionalAutomation
Scenario Outline: Verification of invalid card types ie Amex, Diner and JCB
	
	Given Enter domain name <domainname>
	Then Select domain service 
	Then Uncheck au domain service
	Then Click on search button
	Then Click on cotinue to checkout button
	Then Click on No thanks pop up
	Then Click on continue to account
	Then Enter organisation name <Organisationname>
	Then Enter first name <FirstName>
	Then Enter last name <LastName>
	Then Enter address <Address>
	Then Enter city name <CityName>
	Then Select state <State>
	Then Enter post code <PostCode> 
	Then Enter phone number <PhoneNumber>
	Then Enter email <Email>
	Then Enter confirmation mail <ConfirmationEmail>
	Then Click on continue to payment page
	Then Click on continue to registrant page
	Then Enter card owner name <CardOwner>
	Then Switch to iframe card number
	Then Enter card number <CardNumber>
	Then Switch to iframe card expiry month
	Then Select card expiry month <dropdownmonth>
	Then Switch to iframe card expiry year
	Then Select card expiry year <dropdownyear>
	Then Switch to iframe card cvv
	Then Enter card CVV number <CVV>
	Then Select I agree checkbox
	Then Verify alert message for Amex card <invalidCardNumAmex>

Examples:
| domainname        | Organisationname     | FirstName | LastName | Address               | CityName | State        | PostCode | PhoneNumber  | Email                      | ConfirmationEmail            | CardOwner           | CardNumber        | dropdownmonth | dropdownyear | CVV    | invalidCardNumAmex              |
| testdomain1246    | Payment Gateway Test | QA        | Team     | 2/469 La Trobe Street | Auckland | North Island | 0626     | 064411111111 | testing@melbourneit.com.au | testing@melbourneit.com.au | Test Card - Amex    | 3782 822463 10005 | 12              | 2019         | 8888 | Card type is not supported  |	
| testdomain1246    | Payment Gateway Test | QA        | Team     | 2/469 La Trobe Street | Auckland | North Island | 0626     | 064411111111 | testing@melbourneit.com.au | testing@melbourneit.com.au | Test Card - Diner   | 30569309025904    | 12          | 2019       | 888          | Card type is not supported  |
| testdomain1246    | Payment Gateway Test | QA        | Team     | 2/469 La Trobe Street | Auckland | North Island | 0626     | 064411111111 | testing@melbourneit.com.au | testing@melbourneit.com.au | Test Card - JCB      | 3530111333300000     | 12            | 2019         | 888  |  Card type is not supported |


@Test1
Scenario Outline: Retry payment for existing workflow with different card.
	
	Given Enter User name <userName>
	Then Enter Password <Password>
	Then Click on Login button
	Then search the workflow
	Then Get preauth number
	Then Open Braintree portal
	Then Navigate to transactions
	Then Search for the preauth number
	Then Open the transaction
	Then Void the transaction
	Given Enter User name <userName>
	Then Enter Password <Password>
	Then Click on Login button
	Then search the workflow
	Then Execute the workflow
	Then Navigate to this workflow
	Then Edit the billing details
	Then Add new billing details
	Then Execute the workflow Again
	Then Get preauth number after reexecuting workflow
	Then Open Braintree portal
	Then Navigate to transactions
	Then Search for the new preauth number
	
	Examples:
	| userName   | Password | AccountReference | cardOwner        | cardNumber       | expiryMonth | expiryYear | CVVnumber | prepaidamount | prepaidsuccess                |  
	| fnurani    | comein22 | PAY-324          | Test User - VISA | 4111111111111111 | 08          | 2025       | 456       | 15            | Credit purchased successfully |
	