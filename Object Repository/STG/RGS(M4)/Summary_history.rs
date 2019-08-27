<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>Summary_history</name>
   <tag></tag>
   <elementGuidId>815938d8-d674-4042-8348-173ddc3b6f13</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://${partner}-rgs-history.star9ad.com/api/slot/partnercode/${partner_code}/playerid/${userid}?game_code=${game_code}&amp;page_number=1&amp;page_size=200&amp;period_type=DAY</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(2, 1)</defaultValue>
      <description></description>
      <id>905f6cc9-3706-4447-9594-4be9fe80a14b</id>
      <masked>false</masked>
      <name>partner</name>
   </variables>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(4, 1)</defaultValue>
      <description></description>
      <id>4a3cb8b8-6ffc-45a1-b433-f5f1ee74cc1f</id>
      <masked>false</masked>
      <name>userid</name>
   </variables>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(1, 1)</defaultValue>
      <description></description>
      <id>6400a279-7d48-47a9-b540-09c86b2753b4</id>
      <masked>false</masked>
      <name>partner_code</name>
   </variables>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(5, 1)</defaultValue>
      <description></description>
      <id>e7ea62fa-bc10-478c-84af-36306f3f816c</id>
      <masked>false</masked>
      <name>game_code</name>
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


def summary_detail = new groovy.json.JsonSlurper()
def summary_history = summary_detail.parseText(response.getResponseBodyContent())

def summary_top_level = summary_history
GlobalVariable.summary_top_level= summary_top_level



def summary_data = summary_history.data
GlobalVariable.summary_data= summary_data

def summary_query = summary_history.data.query
GlobalVariable.summary_query= summary_query

def summary_payload = summary_history.data.payload
GlobalVariable.summary_payload = summary_payload

def summary_round_id_1 = summary_history.data.payload[0].round_id
GlobalVariable.summary_round_id_1 = summary_round_id_1

def summary_total_bet_1 = summary_history.data.payload[0].total_bet
GlobalVariable.summary_total_bet_1 = summary_total_bet_1

def summary_bet_value_1 = summary_history.data.payload[0].bet_value
GlobalVariable.summary_bet_value_1 = summary_bet_value_1

def summary_total_win_1 = summary_history.data.payload[0].total_win
GlobalVariable.summary_total_win_1 = summary_total_win_1

def summary_balance_1 = summary_history.data.payload[0].balance
GlobalVariable.summary_balance_1 = summary_balance_1

def summary_date_1 = summary_history.data.payload[0].date
GlobalVariable.summary_date_1 = summary_date_1

def summary_round_type_1 = summary_history.data.payload[0].round_type
GlobalVariable.summary_round_type_1 = summary_round_type_1

def summary_bonus_provider_1 = summary_history.data.payload[0].bonus_provider
GlobalVariable.summary_bonus_provider_1 = summary_bonus_provider_1

def summary_booster_type_1 = summary_history.data.payload[0].booster_type
GlobalVariable.summary_booster_type_1 = summary_booster_type_1

def summary_with_free_spin_1 = summary_history.data.payload[0].with_free_spin
GlobalVariable.summary_with_free_spin_1 = summary_with_free_spin_1

def summary_feature_track_1 = summary_history.data.payload[0].feature_track
GlobalVariable.summary_feature_track_1 = summary_feature_track_1

def summary_totalCount = summary_history.data.query.totalCount
GlobalVariable.summary_totalCount = summary_totalCount


</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
