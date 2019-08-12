<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>DEBUG_Round_detail</name>
   <tag></tag>
   <elementGuidId>daffb23c-9990-4f43-9915-d6bfc7d5b9dd</elementGuidId>
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
      <defaultValue>findTestData('INT_data').getValue(2, 1)</defaultValue>
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

def M4_round_object = M4_round_detail
GlobalVariable.M4_round_object = M4_round_object

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


def M4_round_transaction_id = M4_round_detail.spin_results[0].transaction_id
GlobalVariable.M4_round_transaction_id = M4_round_transaction_id

def M4_round_transaction_time = M4_round_detail.spin_results[0].transaction_time
GlobalVariable.M4_round_transaction_time = M4_round_transaction_time

def M4_round_total_win = M4_round_detail.spin_results[0].total_win
GlobalVariable.M4_round_total_win = M4_round_total_win

def M4_round_balance_long = M4_round_detail.spin_results[0].balance
String M4_round_balance = Long.toString(M4_round_balance_long)
GlobalVariable.M4_round_balance = M4_round_balance


//def M4_round_reel_wins_of_kind = M4_round_detail.spin_results[0].reel_wins[0].of_kind
//GlobalVariable.M4_round_reel_wins_of_kind = M4_round_reel_wins_of_kind
//def M4_round_reel_wins_wild_win= M4_round_detail.spin_results[0].reel_wins[0].wild_win
//GlobalVariable.M4_round_reel_wins_wild_win = M4_round_reel_wins_wild_win
//
//def M4_round_reel_wins_line_number = M4_round_detail.spin_results[0].reel_wins[0].line_number
//GlobalVariable.M4_round_reel_wins_line_number = M4_round_reel_wins_line_number
//
//def M4_round_reel_wins_line_config = M4_round_detail.spin_results[0].reel_wins[0].line_config
//GlobalVariable.M4_round_reel_wins_line_config = M4_round_reel_wins_line_config


//def M4_round_reel_wins_prize = M4_round_detail.spin_results[0].reel_wins[0].prize
//GlobalVariable.M4_round_reel_wins_prize = M4_round_reel_wins_prize
//
//def M4_round_reel_wins_right_to_left = M4_round_detail.spin_results[0].reel_wins[0].right_to_left
//GlobalVariable.M4_round_reel_wins_right_to_left = M4_round_reel_wins_right_to_left




def M4_round_total_bet = M4_round_detail.spin_results[0].total_bet
GlobalVariable.M4_round_total_bet = M4_round_total_bet

def M4_round_bet_value = M4_round_detail.spin_results[0].bet_value
GlobalVariable.M4_round_bet_value = M4_round_bet_value

def M4_round_line = M4_round_detail.spin_results[0].line
GlobalVariable.M4_round_line = M4_round_line

def M4_round_reels1 = M4_round_detail.spin_results[0].reels[0]
GlobalVariable.M4_round_reels1 = M4_round_reels1

def M4_round_reels2 = M4_round_detail.spin_results[0].reels[1]
GlobalVariable.M4_round_reels2 = M4_round_reels2

def M4_round_reels3 = M4_round_detail.spin_results[0].reels[2]
GlobalVariable.M4_round_reels3 = M4_round_reels3

def M4_round_reels4 = M4_round_detail.spin_results[0].reels[3]
GlobalVariable.M4_round_reels4 = M4_round_reels4

def M4_round_reels5 = M4_round_detail.spin_results[0].reels[4]
GlobalVariable.M4_round_reels5 = M4_round_reels5



def M4_round_reels0_symbols1 = M4_round_detail.spin_results[0].reels[0].symbols[0]
GlobalVariable.M4_round_reels0_symbols1 = M4_round_reels0_symbols1
def M4_round_reels0_symbols2 = M4_round_detail.spin_results[0].reels[0].symbols[1]
GlobalVariable.M4_round_reels0_symbols2 = M4_round_reels0_symbols2
def M4_round_reels0_symbols3 = M4_round_detail.spin_results[0].reels[0].symbols[2]
GlobalVariable.M4_round_reels0_symbols3 = M4_round_reels0_symbols3


def M4_round_reels1_symbols1 = M4_round_detail.spin_results[0].reels[1].symbols[0]
GlobalVariable.M4_round_reels1_symbols1 = M4_round_reels1_symbols1
def M4_round_reels1_symbols2 = M4_round_detail.spin_results[0].reels[1].symbols[1]
GlobalVariable.M4_round_reels1_symbols2 = M4_round_reels1_symbols2
def M4_round_reels1_symbols3 = M4_round_detail.spin_results[0].reels[1].symbols[2]
GlobalVariable.M4_round_reels1_symbols3 = M4_round_reels1_symbols3
def M4_round_reels1_symbols4 = M4_round_detail.spin_results[0].reels[1].symbols[3]


def M4_round_reels_symbols_all = M4_round_detail.spin_results[0].reels.symbols.symbol
GlobalVariable.M4_round_reels_symbols_all = M4_round_reels_symbols_all







def M4_round_spin_result_list =  M4_round_detail.spin_results[0]
GlobalVariable.M4_round_spin_result_list = M4_round_spin_result_list

</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
