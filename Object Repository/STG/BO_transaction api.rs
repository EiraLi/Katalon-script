<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>BO_transaction api</name>
   <tag></tag>
   <elementGuidId>47562816-9354-4a51-9bd9-70f66908b732</elementGuidId>
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
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://${url_krug}/m4/bo/transaction/${transaction_id}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(11, 1)</defaultValue>
      <description></description>
      <id>933987fd-108f-4010-9e1e-37ca6e6bd101</id>
      <masked>false</masked>
      <name>url_krug</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.transaction_id</defaultValue>
      <description></description>
      <id>30a9f3fc-c0ec-4858-acab-87689aef2f73</id>
      <masked>false</masked>
      <name>transaction_id</name>
   </variables>
   <verificationScript>import static org.assertj.core.api.Assertions.*

import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webservice.verification.WSResponseManager

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()



WS.verifyResponseStatusCode(response, 200)

assertThat(response.getStatusCode()).isEqualTo(200)

String newline = System.getProperty(&quot;line.separator&quot;)
def BO_transaction = new groovy.json.JsonSlurper()
def result_BO_transaction = BO_transaction.parseText(response.getResponseBodyContent())


def BO_txd_balance = result_BO_transaction.balance
println(&quot;result_BO_transaction balance is: &quot; +BO_txd_balance)
GlobalVariable.BO_txd_balance = Long.toString(BO_txd_balance)

def BO_txd_round_id = result_BO_transaction.roundid
println(&quot;BO_transaction_round_id is: &quot; +BO_txd_round_id)
GlobalVariable.BO_txd_round_id = BO_txd_round_id

def BO_player_id = result_BO_transaction.user_id
println(&quot;BO_player_id is: &quot; +BO_player_id)
GlobalVariable.BO_player_id = BO_player_id

</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
