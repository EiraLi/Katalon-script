<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>BOpth_summary - Copy</name>
   <tag></tag>
   <elementGuidId>9be24080-a663-4d15-ada5-efe2d0d7afae</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://${url_krug}/history/transactions/all/players/${userid}?startDate=${start_date}&amp;endDate=${end_date}&amp;partnerToken=${partner}&amp;timeZoneId=GMT%2B8&amp;pageNumber=1&amp;pageSize=200&amp;action=ROLLBACK%2CAdjustment_Add%2CAdjustment_Remove%2CDeposit%2CWithdraw</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>findTestData('INT_data').getValue(11, 1)</defaultValue>
      <description></description>
      <id>28838aff-1749-4e1e-934f-ea77e363b283</id>
      <masked>false</masked>
      <name>url_krug</name>
   </variables>
   <variables>
      <defaultValue>'2019-08-22T00:00:00Z'</defaultValue>
      <description></description>
      <id>e581aa7a-e91d-4970-b37c-f154fea327bb</id>
      <masked>false</masked>
      <name>start_date</name>
   </variables>
   <variables>
      <defaultValue>findTestData('INT_data').getValue(4, 1)</defaultValue>
      <description></description>
      <id>876c25cd-af98-4acf-8756-ea086a34893a</id>
      <masked>false</masked>
      <name>userid</name>
   </variables>
   <variables>
      <defaultValue>'2019-08-22T23:59:00Z'</defaultValue>
      <description></description>
      <id>6aaf0144-6916-4f85-96fe-053b08bcd286</id>
      <masked>false</masked>
      <name>end_date</name>
   </variables>
   <variables>
      <defaultValue>findTestData('INT_data').getValue(2, 1)</defaultValue>
      <description></description>
      <id>cdd41448-a3b8-465e-a56a-e6c51053ec3b</id>
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

RequestObject request = WSResponseManager.getInstance().getCurrentRequest()

ResponseObject response = WSResponseManager.getInstance().getCurrentResponse()

WS.verifyResponseStatusCode(response, 200)
assertThat(response.getStatusCode()).isEqualTo(200)

def boquery = new groovy.json.JsonSlurper()
def result_boquery = boquery.parseText(response.getResponseBodyContent())

def bo_top_level = result_boquery
GlobalVariable.bo_top_level = bo_top_level

def bo_payload = result_boquery.documents.payload
GlobalVariable.bo_payload = bo_payload

def bo_balance = result_boquery.documents.payload[0].balance
double latest_bo_balance = Double.parseDouble(bo_balance)*100
GlobalVariable.latest_bo_balance = latest_bo_balance

def bo_round_id = result_boquery.documents.payload[0].roundId
GlobalVariable.bo_round_id = bo_round_id

def bo_timeStamp = result_boquery.documents.payload[0].timeStamp
GlobalVariable.bo_timeStamp = bo_timeStamp


</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
