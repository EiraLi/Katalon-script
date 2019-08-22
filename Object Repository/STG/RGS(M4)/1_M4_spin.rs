<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>1_M4_spin</name>
   <tag></tag>
   <elementGuidId>ec44bf2f-4c0d-4410-96fd-a0420fe90fa5</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;{\n    \&quot;channel\&quot;: \&quot;desktop\&quot;,\n    \&quot;bet\&quot;: 2000,\n    \&quot;lines\&quot;: 25,\n    \&quot;multiplier\&quot;: 1,\n    \&quot;currency\&quot;: \&quot;CNY\&quot;,\n    \&quot;points\&quot;: null,\n    \&quot;key\&quot;: null\n}&quot;,
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
      <name>X-Genesis-UserId</name>
      <type>Main</type>
      <value>${M4_login_user_id}</value>
   </httpHeaderProperties>
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>X-Genesis-PartnerToken</name>
      <type>Main</type>
      <value>${partner}</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://${partner}.star9ad.com/m4/gameservice/play/spin/${rgs_session_token}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>GlobalVariable.M4_login_user_id</defaultValue>
      <description></description>
      <id>ce8bc744-ce25-4570-881c-fdf065533011</id>
      <masked>false</masked>
      <name>M4_login_user_id</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.rgs_session_token</defaultValue>
      <description></description>
      <id>5c516312-7e8f-4189-a06f-1ede83cff877</id>
      <masked>false</masked>
      <name>rgs_session_token</name>
   </variables>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(2, 5)</defaultValue>
      <description></description>
      <id>bee7d5ce-292b-4b20-9b23-fae9e2212e1d</id>
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

String newline = System.getProperty(&quot;line.separator&quot;)
def M4_spin = new groovy.json.JsonSlurper()
def result_M4_spin = M4_spin.parseText(response.getResponseBodyContent())

def M4_spin_current_balance = result_M4_spin.current_balance
GlobalVariable.M4_spin_current_balance = M4_spin_current_balance

def M4_spin_transaction_id = result_M4_spin.spin_result.causality
GlobalVariable.M4_spin_transaction_id = M4_spin_transaction_id

def M4_spin_round_id = result_M4_spin.spin_result.round_id
GlobalVariable.M4_spin_round_id = M4_spin_round_id

def M4_spin_line_wins = result_M4_spin.spin_result.bonus.bonus_data[0].get('properties').spin_result[0].line_wins
GlobalVariable.M4_spin_line_wins = M4_spin_line_wins


def M4_total_bonus_spins_int = result_M4_spin.spin_result.bonus.bonus_data[0].get('properties').total_bonus_spins
println(&quot;******M4_total_bonus_spins type is:*******&quot;+ newline+ M4_total_bonus_spins_int.getClass().getName())
GlobalVariable.M4_total_bonus_spins_int = M4_total_bonus_spins_int
String M4_total_bonus_spins = Integer.toString(M4_total_bonus_spins_int)
GlobalVariable.M4_total_bonus_spins = M4_total_bonus_spins
println(&quot;M4_total_bonus_spins is:&quot;+GlobalVariable.M4_total_bonus_spins)

def M4_spin_bonus_data = result_M4_spin.spin_result.bonus.bonus_data
def M4_spin_features_triggered = result_M4_spin

def wild = new String[5]
wild[0] = &quot;WILD_Expanding&quot;
wild[1] = &quot;WILD_Normal&quot;
wild[2] = &quot;WILD_Double&quot;
wild[3] = &quot;WILD_ExtraFG&quot;
wild[4] = &quot;WILD_Triple&quot;
// java index 
def wildList = Arrays.asList(wild)
GlobalVariable.wildList = wildList

def free_spin_reel_counter = new int[3]
free_spin_reel_counter[0] = 0 //reel 3 wild found
free_spin_reel_counter[1] = 0
free_spin_reel_counter[2] = 0


def M4_spin_reels = result_M4_spin.spin_result.reels
for (int i=0; i &lt; M4_spin_reels.size(); i++) {
	def symbols = M4_spin_reels[i].symbols
	for (int j=0; j &lt; symbols.size(); j++) {
		def symbol = symbols[j].symbol
		println(symbol)
		if(i == 2 &amp;&amp; wildList.indexOf(symbol) != -1) {
			println(&quot;wild found on reel 3, adding counter by 1&quot;)
			free_spin_reel_counter[0] = free_spin_reel_counter[0] + 1
		}
		if(i == 3 &amp;&amp; wildList.indexOf(symbol) != -1) {
			println(&quot;wild found on reel 4, adding counter by 1&quot;)
			free_spin_reel_counter[1] = free_spin_reel_counter[1] + 1
		}
		if(i == 4 &amp;&amp; wildList.indexOf(symbol) != -1) {
			println(&quot;wild found on reel 5, adding counter by 1&quot;)
			free_spin_reel_counter[2] = free_spin_reel_counter[2] + 1
		}
	}
}

GlobalVariable.free_spin_reel_counter = free_spin_reel_counter
println(&quot;reel 3 wild found: &quot; + free_spin_reel_counter[0])
println(&quot;reel 4 wild found: &quot; + free_spin_reel_counter[1])
println(&quot;reel 5 wild found: &quot; + free_spin_reel_counter[2])

//def M4_spin_reels = result_M4_spin.spin_result.reels
GlobalVariable.M4_spin_reels = M4_spin_reels

def M4_spin_reels_symbols = result_M4_spin.spin_result.reels.symbols.symbol
GlobalVariable.M4_spin_reels_symbols = M4_spin_reels_symbols

def M4_spin_reel_wins = result_M4_spin.spin_result.reel_wins
GlobalVariable.M4_spin_reel_wins = M4_spin_reel_wins
println(&quot;GlobalVariable.M4_spin_reel_wins is: &quot;+GlobalVariable.M4_spin_reel_wins)


def M4_spin_total_bonus_win_this_round = result_M4_spin.spin_result.bonus.total_bonus_win_this_round
GlobalVariable.M4_spin_total_bonus_win_this_round = M4_spin_total_bonus_win_this_round
println(&quot;GlobalVariable.M4_spin_total_bonus_win_this_round is: &quot;+GlobalVariable.M4_spin_total_bonus_win_this_round)




</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
