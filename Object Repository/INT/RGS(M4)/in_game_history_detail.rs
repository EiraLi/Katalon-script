<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>in_game_history_detail</name>
   <tag></tag>
   <elementGuidId>20606235-438d-4f0f-a257-211b36d69846</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n\&quot;spin_id\&quot;: \&quot;${M4_spin_transaction_id}\&quot;\n}\n&quot;,
  &quot;contentType&quot;: &quot;application/json&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
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
      <name>X-Genesis-UserId</name>
      <type>Main</type>
      <value>${M4_login_user_id}</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://${partner}.3655oule.com/m4/history/details/</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>findTestData('INT_data').getValue(2, 1)</defaultValue>
      <description></description>
      <id>24a52e8c-e0d3-4489-afec-d8df382e8bd7</id>
      <masked>false</masked>
      <name>partner</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.M4_spin_transaction_id</defaultValue>
      <description></description>
      <id>12cad0a9-bb85-4ad1-b01a-59c63eefc788</id>
      <masked>false</masked>
      <name>M4_spin_transaction_id</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.M4_login_user_id</defaultValue>
      <description></description>
      <id>c9e85999-e691-4135-90ff-e230516e5b61</id>
      <masked>false</masked>
      <name>M4_login_user_id</name>
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
def M4_game_history = new groovy.json.JsonSlurper()
def M4_history = M4_game_history.parseText(response.getResponseBodyContent())

def M4_history_currency = M4_history.currency
GlobalVariable.M4_history_currency = M4_history_currency

def M4_history_spin_transaction = M4_history.spin_transaction
GlobalVariable.M4_history_spin_transaction = M4_history_spin_transaction

def M4_history_date = M4_history.date
//GlobalVariable.M4_history_date = M4_history_date

def M4_history_game_id = M4_history.game_id
//GlobalVariable.M4_history_game_id = M4_history_game_id

def M4_history_tx_id = M4_history.game_history.tx_id
//GlobalVariable.M4_history_tx_id = M4_history_tx_id

def M4_history_causality = M4_history.game_history.causality
GlobalVariable.M4_history_causality = M4_history_causality

def M4_history_round_id = M4_history.game_history.round_id
GlobalVariable.M4_history_round_id = M4_history_round_id

def M4_history_game_total_won = M4_history.game_history.total_won
GlobalVariable.M4_history_game_total_won = M4_history_game_total_won

def M4_history_game_total_bet = M4_history.game_history.total_bet
GlobalVariable.M4_history_total_bet = M4_history_game_total_bet

def M4_history_lines = M4_history.game_history.lines
//GlobalVariable.M4_history_lines = M4_history_lines

def M4_history_total_won = M4_history.total_won
GlobalVariable.M4_history_total_won = M4_history_total_won



def M4_history_bonus_name = M4_history.game_history.bonuses[0].bonus_name
//GlobalVariable.M4_history_bonus_name = M4_history_bonus_name

def M4_history_bonus_retrigger = M4_history.game_history.bonuses[0].bonus_retrigger
//GlobalVariable.M4_history_bonus_retrigger = M4_history_bonus_retrigger

def M4_history_key = M4_history.game_history.bonuses[0].bonus_data[0].key
//GlobalVariable.M4_history_key = M4_history_key

def M4_history_data = M4_history.game_history.bonuses[0].bonus_data[0].data
//GlobalVariable.M4_history_data = M4_history_data



def M4_history_total_bet = M4_history.total_bet
GlobalVariable.M4_history_total_bet = M4_history_total_bet

def M4_history_balance = M4_history.balance
GlobalVariable.M4_history_balance = M4_history_balance

def M4_history_type = M4_history.type
//GlobalVariable.M4_history_type = M4_history_type

def M4_history_reel_symbol = M4_history.game_history.reels.symbols
GlobalVariable.M4_history_reel_symbol = M4_history_reel_symbol

def M4_history_reels = M4_history.game_history.reels
GlobalVariable.M4_history_reels = M4_history_reels

def M4_history_F_reels1 = M4_history.game_history.bonuses[1].extra_spins_data[0].reels
GlobalVariable.M4_history_F_reels = M4_history_F_reels1

def M4_history_multiplier = M4_history.game_history.bonuses[1].extra_spins_data[0].multiplier
GlobalVariable.M4_history_multiplier = M4_history_multiplier

def M4_history_bonuses1 = M4_history.game_history.bonuses[1]
GlobalVariable.M4_history_bonuses1 = M4_history_bonuses1</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
