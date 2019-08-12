<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>old_BO_round_detail</name>
   <tag></tag>
   <elementGuidId>2a4d42e9-ead4-491d-8239-a08755ba6dc9</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent></httpBodyContent>
   <httpBodyType></httpBodyType>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://${url_krug_gw}/m4/bo/spin/${round_id}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>findTestData('INT_data').getValue(10, 1)</defaultValue>
      <description></description>
      <id>9b933718-c9b9-42ec-be98-fd275100be56</id>
      <masked>false</masked>
      <name>url_krug_gw</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.round_id</defaultValue>
      <description></description>
      <id>2b1972ff-1bb3-4dcb-92be-921badb99fed</id>
      <masked>false</masked>
      <name>round_id</name>
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
def M4_old_bo = new groovy.json.JsonSlurper()
def result_M4_old_bo = M4_old_bo.parseText(response.getResponseBodyContent())

def M4_old_bo_currency = result_M4_old_bo.currency
GlobalVariable.M4_old_bo_currency = M4_old_bo_currency

def M4_old_bo_userid = result_M4_old_bo.userid
GlobalVariable.M4_old_bo_userid = M4_old_bo_userid

def M4_old_bo_transaction_id = result_M4_old_bo.spin_transaction
GlobalVariable.M4_old_bo_transaction_id = M4_old_bo_transaction_id

def M4_old_bo_date = result_M4_old_bo.date
GlobalVariable.M4_old_bo_date = M4_old_bo_date

def M4_old_bo_game_id = result_M4_old_bo.game_id
GlobalVariable.M4_old_bo_game_id = M4_old_bo_game_id

def M4_old_bo_tx_id = result_M4_old_bo.game_history.tx_id
GlobalVariable.M4_old_bo_tx_id = M4_old_bo_tx_id

def M4_old_bo_causality = result_M4_old_bo.game_history.causality
GlobalVariable.M4_old_bo_causality = M4_old_bo_causality

def M4_old_bo_round_id = result_M4_old_bo.game_history.round_id
GlobalVariable.M4_old_bo_round_id = M4_old_bo_round_id

def M4_old_bo_total_won = result_M4_old_bo.game_history.total_won
GlobalVariable.M4_old_bo_total_won = M4_old_bo_total_won

def M4_old_bo_total_bet = result_M4_old_bo.game_history.total_bet
GlobalVariable.M4_old_bo_total_bet = M4_old_bo_total_bet

def M4_old_bo_total_bet = result_M4_old_bo.game_history.total_bet
GlobalVariable.M4_old_bo_total_bet = M4_old_bo_total_bet

def M4_old_bo_balance = result_M4_old_bo.balance
GlobalVariable.M4_old_bo_balance = M4_old_bo_balance

//要補充寫 per_line_bets 的內容
def M4_old_bo_per_line_bets = result_M4_old_bo.game_history.per_line_bets
GlobalVariable.M4_old_bo_per_line_bets = M4_old_bo_per_line_bets

//要補充寫 line_wins 的內容
def M4_old_bo_line_wins = result_M4_old_bo.game_history.line_wins
GlobalVariable.M4_old_bo_line_wins = M4_old_bo_line_wins

//要補充寫 scatters 的內容
def M4_old_bo_scatters = result_M4_old_bo.game_history.scatters
GlobalVariable.M4_old_bo_scatters = M4_old_bo_scatters

//要補寫 reels 的內容
def M4_old_bo_reels = result_M4_old_bo.game_history.reels
GlobalVariable.M4_old_bo_reels = M4_old_bo_reels

//要補寫 bonuses 的內容
def M4_old_bo_bonuses = result_M4_old_bo.game_history.bonuses
GlobalVariable.M4_old_bo_bonuses = M4_old_bo_bonuses

def M4_old_bo_raw_result = result_M4_old_bo.game_history.raw_result
GlobalVariable.M4_old_bo_raw_result = M4_old_bo_raw_result

def M4_old_bo_is_final_pick = result_M4_old_bo.game_history.is_final_pick
GlobalVariable.M4_old_bo_is_final_pick = M4_old_bo_is_final_pick

def M4_old_bo_is_separate = result_M4_old_bo.game_history.is_separate
GlobalVariable.M4_old_bo_is_separate = M4_old_bo_is_separate

def M4_old_bo_last_bet_transaction_id = result_M4_old_bo.game_history.last_bet_transaction_id


</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
