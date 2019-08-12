<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Get_Session_Token</name>
   <tag></tag>
   <elementGuidId>e8173dd6-183c-453e-93a6-81958845e3b2</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>X-Genesis-PartnerToken</name>
      <type>Main</type>
      <value>${partner}</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>X-Genesis-Secret</name>
      <type>Main</type>
      <value>${secret_key}</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://${url_krug_gw}/m4/wallet/balance/${userid}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>findTestData('INT_data').getValue(10, 1)</defaultValue>
      <description></description>
      <id>554f690c-0692-4fbb-b227-1308f2704a34</id>
      <masked>false</masked>
      <name>url_krug_gw</name>
   </variables>
   <variables>
      <defaultValue>findTestData('INT_data').getValue(2, 1)</defaultValue>
      <description></description>
      <id>a27a4b76-8f6d-499b-99bb-2225e73648ef</id>
      <masked>false</masked>
      <name>partner</name>
   </variables>
   <variables>
      <defaultValue>findTestData('INT_data').getValue(3, 1)</defaultValue>
      <description></description>
      <id>bc1aa9f1-3227-4e06-8086-ddc3ac08076b</id>
      <masked>false</masked>
      <name>secret_key</name>
   </variables>
   <variables>
      <defaultValue>findTestData('INT_data').getValue(4, 1)</defaultValue>
      <description></description>
      <id>109b3b45-4200-4d2e-8f75-13d024bc39e1</id>
      <masked>false</masked>
      <name>userid</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager


RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable


WS.verifyResponseStatusCode(response, 200)

assertThat(response.getStatusCode()).isEqualTo(200)
assertThat(response.getResponseText()).contains('session_token')

def getsession = new groovy.json.JsonSlurper()
def result_getsession = getsession.parseText(response.getResponseBodyContent())

def session_token = result_getsession.session_token
println (&quot;...value extracted is :&quot;+session_token)

GlobalVariable.session_token = session_token
println (&quot;GlobalVariable is :&quot;+GlobalVariable.session_token)

def internal_balance = result_getsession.internal_balance
GlobalVariable.internal_balance = internal_balance</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
