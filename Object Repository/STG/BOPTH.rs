<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>BOPTH</name>
   <tag></tag>
   <elementGuidId>81ca01ea-d035-4b0a-845d-f02efc857a50</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://${url_krug}/history/transactions/all/players/${userid}?startDate=${start_date}&amp;endDate=${end_date}&amp;partnerToken=${partner}&amp;timeZoneId=GMT%2B8&amp;pageNumber=1&amp;pageSize=100</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(11, 1)</defaultValue>
      <description></description>
      <id>a6f36fbc-af2f-4a6a-a1fd-c8e188a7c10f</id>
      <masked>false</masked>
      <name>url_krug</name>
   </variables>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(4, 1)</defaultValue>
      <description></description>
      <id>dfb11d3f-efda-4842-9a62-2e346eab072e</id>
      <masked>false</masked>
      <name>userid</name>
   </variables>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(2, 1)</defaultValue>
      <description></description>
      <id>fb86805d-c50b-4913-84c9-8f9f41024e04</id>
      <masked>false</masked>
      <name>partner</name>
   </variables>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(7, 1)</defaultValue>
      <description></description>
      <id>09f5d1e2-530b-4c30-9cb1-eb0d010a7c37</id>
      <masked>false</masked>
      <name>start_date</name>
   </variables>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(8, 1)</defaultValue>
      <description></description>
      <id>55260995-39c9-4d0d-80da-f7d6fc6fd9a6</id>
      <masked>false</masked>
      <name>end_date</name>
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

def boquery = new groovy.json.JsonSlurper()
def result_boquery = boquery.parseText(response.getResponseBodyContent())

def bo_balance = result_boquery.documents.payload[0].balance
double number = Double.parseDouble(bo_balance)*100
//String latest_bo_balance = String.format(&quot;%.0f&quot;, number)
println(&quot;latest balance is: &quot; +latest_bo_balance)
GlobalVariable.latest_bo_balance = latest_bo_balance


def bo_round_id = result_boquery.documents.payload[0].roundId
println(&quot;latest bo roundId is: &quot; +bo_round_id)
GlobalVariable.bo_round_id = bo_round_id

def game_code = result_boquery.documents.payload[0].gameId
println(&quot;game code is: &quot; +game_code)
GlobalVariable.game_code = game_code

def bo_transaction_id = result_boquery.documents.payload[0].txId
println(&quot;transaction id is: &quot; +bo_transaction_id)
GlobalVariable.bo_transaction_id = bo_transaction_id

def bo_txType = result_boquery.documents.payload[0].txType
println(&quot;txType is: &quot; +bo_txType)
GlobalVariable.bo_txType = bo_txType

def bo_winLoss = result_boquery.documents.payload[0].winLoss
println(&quot;winLoss is: &quot; +bo_winLoss)
GlobalVariable.bo_winLoss = bo_winLoss

def bo_betValue = result_boquery.documents.payload[0].betValue
println(&quot;bo_betValue is: &quot; +bo_betValue)
GlobalVariable.bo_betValue = bo_betValue

</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
