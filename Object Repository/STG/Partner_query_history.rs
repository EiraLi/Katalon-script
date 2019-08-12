<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Partner_query_history</name>
   <tag></tag>
   <elementGuidId>962b5767-3d32-4054-80a4-2a1657f19145</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>X-Genesis-PartnerToken</name>
      <type>Main</type>
      <value>${partner}</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://${url_history}/api/v3/m4/spindata/query/partner?startDate=${start_date}&amp;endDate=${end_date}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>findTestData(null).getValue(1, 1)</defaultValue>
      <description></description>
      <id>844d0631-cfa7-4884-a319-df13344a54f6</id>
      <masked>false</masked>
      <name>url_history</name>
   </variables>
   <variables>
      <defaultValue>findTestData(null).getValue(1, 1)</defaultValue>
      <description></description>
      <id>95a8779c-b859-4e6d-aa64-ecad58ea23ee</id>
      <masked>false</masked>
      <name>start_date</name>
   </variables>
   <variables>
      <defaultValue>findTestData(null).getValue(1, 1)</defaultValue>
      <description></description>
      <id>95c5dcdb-503a-413c-b05a-f03c9e35d102</id>
      <masked>false</masked>
      <name>end_date</name>
   </variables>
   <variables>
      <defaultValue>findTestData(null).getValue(1, 1)</defaultValue>
      <description></description>
      <id>c191d7fb-af68-41f3-b467-2d0a547476f9</id>
      <masked>false</masked>
      <name>partner</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.logging.KeywordLogger


RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

WS.verifyResponseStatusCode(response, 200)

assertThat(response.getStatusCode()).isEqualTo(200)

KeywordLogger log = new KeywordLogger()

def aaa = new groovy.json.JsonSlurper()
def result_partner_query_history = aaa.parseText(response.getResponseText())
log.logInfo(&quot;aaa&quot;)
log.logInfo(result_partner_query_history.data[0].game_id)
log.logInfo(result_partner_query_history.data[0].user_id)

def partner_query_user_id = result_partner_query_history.data[0].user_id
println (&quot;user id is: &quot;+partner_query_user_id)
GlobalVariable.partner_query_user_id = partner_query_user_id
println(&quot;GlobalVariable partner query user id is: &quot;+GlobalVariable.partner_query_user_id)

def partner_query_game_id = result_partner_query_history.data[0].game_id
println(&quot;game id is: &quot;+partner_query_game_id)
GlobalVariable.partner_query_game_id = partner_query_game_id
println(&quot;GlobalVariable partner query game id is: &quot;+GlobalVariable.partner_query_game_id)

def partner_query_balance = result_partner_query_history.data[0].balance
println(&quot;balance is: &quot;+partner_query_balance)
GlobalVariable.partner_query_balance = partner_query_balance
println(&quot;GlobalVariable partner query balance is: &quot;+GlobalVariable.partner_query_balance)

def partner_query_round_id = result_partner_query_history.data[0].round_id
println(&quot;round id is: &quot;+partner_query_round_id)
GlobalVariable.partner_query_round_id = partner_query_round_id

</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
