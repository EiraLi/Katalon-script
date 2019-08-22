import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
//below for exporting to excel
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.io.File as File
import com.kms.katalon.keyword.excel.ExcelKeywords as ExcelKeywords
import java.util.Collections as Collections


WS.sendRequestAndVerify(findTestObject('INT/Wallet/Get_Session_Token', [('url_krug_gw') : url_krug_gw, ('partner') : Partner
            , ('secret_key') : secret_key, ('userid') : Userid]))

M4_login = WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/M4_Login', [('partner') : Partner, ('game_code') : Game_code
            , ('session_token') : GlobalVariable.session_token]))
def M4_login_user_id = GlobalVariable.M4_login_user_id

M4_init = WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/M4_init', [('partner') : Partner, ('M4_recorder') : M4_recorder
            , ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))

def rgs_session_token = GlobalVariable.rgs_session_token
	
WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/1_Round_detail', [('partner') : Partner, ('M4_spin_round_id') : GlobalVariable.M4_spin_round_id]))

def M4_round_features_triggered = GlobalVariable.M4_round_features_triggered
def wildNormalIndexl = -1

def extraFreeSpinTypeAndComplete = false
def feature_state = ''
for (int i=0; i < M4_round_features_triggered.size(); i++) {
	def trigger = M4_round_features_triggered[i]
	if (trigger.type.equals("NORMAL_FREE_SPIN") && trigger.complete == true) {

		extraFreeSpinTypeAndComplete = true
		wildNormalIndexl = i
		feature_state = trigger.feature_state
		
	
	}

	
}
println(wildNormalIndexl)


println("feature state is:"+feature_state)

def feature_state_key = feature_state.keySet()
ArrayList<String> feature_state_list = new ArrayList<String>(feature_state_key)


def subfeatures = new ArrayList()
subfeatures.add("FREE_SPIN")

def M4_round_spin_result_list = GlobalVariable.M4_round_spin_result_list
def feature_trigger = M4_round_spin_result_list.features_triggered
def total_free_spin_count = ''
def free_spins_left =  ''
def total_free_spin_win_amount = ''
for (int i = 0; i < feature_trigger.size(); i++){
	def feature_type = feature_trigger[i].type
	
	
	
	if (feature_type == "FREE_SPIN"){
		def subfeatures_list = feature_trigger[i].subfeatures
		for (int j = 0; j < subfeatures_list.size(); j++){
			subfeatures.add(subfeatures_list[j])
			
			
		}
	}
}

WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/Summary_history', [('game_code') : "SW_M4_V1_RECORDER", ('partner') : Partner]))

Collections.sort(subfeatures)
Collections.sort(GlobalVariable.summary_feature_track_1)
println("GlobalVariable.summary_feature_track_1 is: "+GlobalVariable.summary_feature_track_1)
println("subfeatures is: "+subfeatures)
println("feature_state_list is:"+feature_state_list)
println("GlobalVariable.summary_with_free_spin_1 is: "+GlobalVariable.summary_with_free_spin_1)

assert feature_state_list.size() == 0
assert subfeatures.equals(GlobalVariable.summary_feature_track_1)
assert GlobalVariable.summary_with_free_spin_1 == true


