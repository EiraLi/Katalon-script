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






WS.sendRequestAndVerify(findTestObject('Wallet/Get_Session_Token', [('url_krug_gw') : url_krug_gw, ('partner') : Partner
            , ('secret_key') : secret_key, ('userid') : Userid]))

M4_login = WS.sendRequestAndVerify(findTestObject('RGS(M4)/M4_Login', [('partner') : Partner, ('game_code') : Game_code, ('session_token') : GlobalVariable.session_token]))

def M4_login_user_id = GlobalVariable.M4_login_user_id

M4_init = WS.sendRequestAndVerify(findTestObject('RGS(M4)/M4_init', [('partner') : Partner, ('M4_recorder') : M4_recorder
            , ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))

def rgs_session_token = GlobalVariable.rgs_session_token
	
WS.sendRequestAndVerify(findTestObject('RGS(M4)/1_Round_detail', [('partner') : Partner, ('M4_spin_round_id') : GlobalVariable.M4_spin_round_id]))
//def M4_spin_reels = GlobalVariable.M4_spin_reels 
//println("GlobalVariable.M4_round_features_triggered[1]: "+GlobalVariable.M4_round_features_triggered)
//println("GlobalVariable.M4_round_features_triggered[1].feature_state.free_spin_left: "+GlobalVariable.M4_round_features_triggered[1].feature_state.free_spins_left)
//println("GlobalVariable.M4_round_features_triggered[1].feature_state[0]: "+GlobalVariable.M4_round_features_triggered[1].feature_state[0])

def M4_round_features_triggered = GlobalVariable.M4_round_features_triggered
def wildNormalIndexl = -1
//def wildExpandingFeatureStateKeys = null
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


println(feature_state.getClass().getName())
println("feature state is:"+feature_state)

def feature_state_key = feature_state.keySet()
ArrayList<String> feature_state_list = new ArrayList<String>(feature_state_key)

println("feature_state_list is:"+feature_state_list)
assert feature_state_list.size() == 0

