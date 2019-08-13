<?xml version="1.0" encoding="UTF-8"?>
<WebServiceRequestEntity>
   <description></description>
   <name>M4_init</name>
   <tag></tag>
   <elementGuidId>d71c1391-bf7c-4cb1-966d-acd3b94e9390</elementGuidId>
   <selectorMethod>BASIC</selectorMethod>
   <useRalativeImagePath>false</useRalativeImagePath>
   <followRedirects>false</followRedirects>
   <httpBody></httpBody>
   <httpBodyContent>{
  &quot;text&quot;: &quot;&quot;,
  &quot;contentType&quot;: &quot;text/plain&quot;,
  &quot;charset&quot;: &quot;UTF-8&quot;
}</httpBodyContent>
   <httpBodyType>text</httpBodyType>
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
   <httpHeaderProperties>
      <isSelected>true</isSelected>
      <matchCondition>equals</matchCondition>
      <name>Content-Type</name>
      <type>Main</type>
      <value>application/json</value>
   </httpHeaderProperties>
   <migratedVersion>5.4.1</migratedVersion>
   <restRequestMethod>POST</restRequestMethod>
   <restUrl>https://${partner}.star9ad.com/m4/gameservice/init/${M4_recorder}</restUrl>
   <serviceType>RESTful</serviceType>
   <soapBody></soapBody>
   <soapHeader></soapHeader>
   <soapRequestMethod></soapRequestMethod>
   <soapServiceFunction></soapServiceFunction>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(2, 1)</defaultValue>
      <description></description>
      <id>82a2ea64-9e1b-4917-970f-e84924c316c6</id>
      <masked>false</masked>
      <name>partner</name>
   </variables>
   <variables>
      <defaultValue>findTestData('STG_data').getValue(14, 1)</defaultValue>
      <description></description>
      <id>d9fa1f69-174d-478f-9a86-7b2b02da7974</id>
      <masked>false</masked>
      <name>M4_recorder</name>
   </variables>
   <variables>
      <defaultValue>GlobalVariable.M4_login_user_id</defaultValue>
      <description></description>
      <id>97415d04-1fd3-4110-b06a-96f5784e8d30</id>
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
def M4_init = new groovy.json.JsonSlurper()
def result_M4_init = M4_init.parseText(response.getResponseBodyContent())

def rgs_session_token = result_M4_init.session_token
GlobalVariable.rgs_session_token = rgs_session_token

def M4_init_balance = result_M4_init.balance
GlobalVariable.M4_init_balance = M4_init_balance

def game_code = result_M4_init.game.genesis_id
GlobalVariable.game_code = game_code

def M4_free_round = result_M4_init.free_round
GlobalVariable.M4_free_round = M4_free_round



//if (M4_features != 0){   //有無 trigger feature
//	def features_type = result_login.state.features[0].type
//	GlobalVariable.features_type = features_type
//	println (&amp;quot;feature type is:&amp;quot; +GlobalVariable.features_type)
//
//	if (features_type == &amp;quot;PICK&amp;quot;){    //pick 了沒
//		def free_spin_pick = result_login.state.features[0].complete
//		GlobalVariable.free_spin_pick = free_spin_pick
//		println (&amp;quot;free spin pick complete is &amp;quot;+GlobalVariable.free_spin_pick)
//
//		if (free_spin_pick == true){ //free spin complete 了沒
//			def free_spin_complete = result_login.state.features[1].complete
//			GlobalVariable.free_spin_complete = free_spin_complete
//			println(&amp;quot;free spin complete is; &amp;quot;+GlobalVariable.free_spin_complete)
//
//			def free_spin_left = result_login.state.features[1].feature_state.free_spins_left
//			GlobalVariable.free_spin_left = free_spin_left
//			println (&amp;quot;free_spin_left is: &amp;quot;+free_spin_left)
//		}
//	
//	else if (features_type == 'FREE_SPIN'){
//		def free_spin_left = result_login.state.features[0].feature_state.free_spins_left
//		GlobalVariable.free_spin_left = free_spin_left
//		println(&amp;quot;free_spin_left is: &amp;quot;+ free_spin_left)
//
//		def free_spin_complete = result_login.state.features[0].complete
//	}
//}
//
//
</verificationScript>
   <wsdlAddress></wsdlAddress>
</WebServiceRequestEntity>
