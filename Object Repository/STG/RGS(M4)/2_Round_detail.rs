<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>2_Round_detail</name>
   <tag></tag>
   <elementGuidId>7b8528ec-a5a0-4be3-bef0-4fbd1f89f6af</elementGuidId>
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
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>GET</restRequestMethod>
   <restUrl>https://${partner}-rgs-history.3655oule.com/api/slot/roundid/${M4_spin_round_id}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(2, 1)</defaultValue>
      <description></description>
      <id>955576e0-e07d-4331-b2e6-ad20d50fa36d</id>
      <masked>false</masked>
      <name>partner</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.M4_spin_round_id</defaultValue>
      <description></description>
      <id>8fc735fa-9445-4182-a8bb-6ea80670ff0d</id>
      <masked>false</masked>
      <name>M4_spin_round_id</name>
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
def M4_round = new groovy.json.JsonSlurper()
def M4_round_detail = M4_round.parseText(response.getResponseBodyContent())

//def M4_round_All_keys = M4_round_detail.sping_result[0].containsKey('key')
//GlobalVariable.M4_round_All_keys = M4_round_All_keys


def M4_round_transaction_type = M4_round_detail.spin_results[0].transaction_type
GlobalVariable.M4_round_transaction_type = M4_round_transaction_type

def M4_round_player_id = M4_round_detail.player_id
GlobalVariable.M4_round_player_id = M4_round_player_id

def M4_round_booster_type = M4_round_detail.booster_type
GlobalVariable.M4_round_booster_type = M4_round_booster_type

def M4_round_currency = M4_round_detail.currency
GlobalVariable.M4_round_currency = M4_round_currency

def M4_round_id = M4_round_detail.round_id
GlobalVariable.M4_round_id = M4_round_id


//************以下 spin_result  [] &amp;&amp;底下的 [] 都要設成變數
def M4_round_transaction_id = M4_round_detail.spin_results[0].transaction_id
GlobalVariable.M4_round_transaction_id = M4_round_transaction_id

def M4_round_transaction_time = M4_round_detail.spin_results[0].transaction_time
GlobalVariable.M4_round_transaction_time = M4_round_transaction_time

def M4_round_total_win = M4_round_detail.spin_results[0].total_win
GlobalVariable.M4_round_total_win = M4_round_total_win

def M4_round_balance = M4_round_detail.spin_results[0].balance
GlobalVariable.M4_round_balance = M4_round_balance

def M4_round_total_bet = M4_round_detail.spin_results[0].total_bet
GlobalVariable.M4_round_total_bet = M4_round_total_bet

def M4_round_bet_value = M4_round_detail.spin_results[0].bet_value
GlobalVariable.M4_round_bet_value = M4_round_bet_value

def M4_round_line = M4_round_detail.spin_results[0].line
GlobalVariable.M4_round_line = M4_round_line

def M4_round_reels = M4_round_detail.spin_results[0].reels
GlobalVariable.M4_round_reels = M4_round_reels

def M4_round_reels_symbols = M4_round_detail.spin_results[0].reels[0].symbols
GlobalVariable.M4_round_reels_symbols = M4_round_reels_symbols

def M4_round_features_triggered =  M4_round_detail.spin_results[0].features_triggered
GlobalVariable.M4_round_features_triggered = M4_round_features_triggered

def M4_round_reel_wins_symbol = M4_round_detail.spin_results[0].reel_wins[0].symbol
GlobalVariable.M4_round_reel_wins_symbol = M4_round_reel_wins_symbol

def M4_round_reel_wins = M4_round_detail.spin_results[0].reel_wins[0]
GlobalVariable.M4_round_reel_wins = M4_round_reel_wins
println(&quot;******GlobalVariable.M4_round_reel_wins is:****** &quot;+newline+GlobalVariable.M4_round_reel_wins)




def M4_round_reel_wins_of_kind = M4_round_detail.spin_results[0].reel_wins[0].of_kind
GlobalVariable.M4_round_reel_wins_of_kind = M4_round_reel_wins_of_kind
def M4_round_reel_wins_wild_win= M4_round_detail.spin_results[0].reel_wins[0].wild_win
GlobalVariable.M4_round_reel_wins_wild_win = M4_round_reel_wins_wild_win

def M4_round_reel_wins_line_number = M4_round_detail.spin_results[0].reel_wins[0].line_number
GlobalVariable.M4_round_reel_wins_line_number = M4_round_reel_wins_line_number

def M4_round_reel_wins_line_config = M4_round_detail.spin_results[0].reel_wins[0].line_config
GlobalVariable.M4_round_reel_wins_line_config = M4_round_reel_wins_line_config

def M4_round_reel_wins_prize = M4_round_detail.spin_results[0].reel_wins[0].prize
GlobalVariable.M4_round_reel_wins_prize = M4_round_reel_wins_prize

//def M4_round_reel_wins_position = M4_round_detail.spin_results[0].reel_wins[0].position
//GlobalVariable.M4_round_reel_wins_position = M4_round_reel_wins_position


def M4_round_reel_wins_right_to_left = M4_round_detail.spin_results[0].reel_wins[0].right_to_left

def M4_round_feature_state_all =  M4_round_detail.spin_results[0].feature_state
GlobalVariable.M4_round_feature_state_all = M4_round_feature_state_all

def M4_round_features_type =  M4_round_detail.spin_results[0].features_triggered.type
GlobalVariable.M4_round_features_type = M4_round_features_type

def M4_round_features_complete =  M4_round_detail.spin_results[0].features_triggered.complete
GlobalVariable.M4_round_features_complete = M4_round_features_complete

def M4_round_free_spins_left =  M4_round_detail.spin_results[0].features_triggered.feature_state.free_spins_left
GlobalVariable.M4_round_free_spins_left = M4_round_free_spins_left

def M4_round_total_free_spin_count =  M4_round_detail.spin_results[0].features_triggered.feature_state.total_free_spin_count
GlobalVariable.M4_round_total_free_spin_count = M4_round_total_free_spin_count

def M4_round_total_free_spin_win_amount =  M4_round_detail.spin_results[0].features_triggered.feature_state.total_free_spin_win_amount
GlobalVariable.M4_round_total_free_spin_win_amount = M4_round_total_free_spin_win_amount

def M4_round_subfeatures = M4_round_detail.spin_results[0].features_triggered.subfeatures
GlobalVariable.M4_round_subfeatures = M4_round_subfeatures


def M4_round_object =  M4_round_detail.object
GlobalVariable.M4_round_object = M4_round_object

def M4_round_spin_result_list =  M4_round_detail.spin_results
GlobalVariable.M4_round_spin_result_list = M4_round_spin_result_list

def M4_round_spin_ =  M4_round_detail.spin_results
GlobalVariable.M4_round_spin_result_list = M4_round_spin_result_list

</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
