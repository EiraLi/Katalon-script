import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

WS.sendRequestAndVerify(findTestObject('INT/Wallet/Get_Session_Token', [('url_krug_gw') : url_krug_gw, ('partner') : Partner
            , ('secret_key') : secret_key, ('userid') : Userid]))

M4_login = WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/M4_Login', [('partner') : Partner, ('game_code') : Game_code
            , ('session_token') : GlobalVariable.session_token]))

def M4_login_user_id = GlobalVariable.M4_login_user_id

M4_init = WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/M4_init', [('partner') : Partner, ('M4_recorder') : M4_recorder
            , ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))


def rgs_session_token = GlobalVariable.rgs_session_token


WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/1_Round_detail', [('partner') : Partner, ('M4_spin_round_id') : GlobalVariable.M4_spin_round_id]))
WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/in_game_history_detail', [('partner') : Partner, ('M4_spin_transaction_id') : GlobalVariable.M4_spin_transaction_id, ('M4_login_user_id'): GlobalVariable.M4_login_user_id]))

def M4_history_bonuses1 = GlobalVariable.M4_history_bonuses1
def spin_data = M4_history_bonuses1.extra_spins_data
def M4_spin_number = ''


for (int i = 0; i < spin_data.size(); i++) {
	println(spin_data.size())
	def spin_number_value = spin_data[i].spin_number
	if (i == spin_data.size()-1) {
		M4_spin_number = spin_number_value
		
	}
	println(M4_spin_number)
	println(M4_spin_number.getClass().getName())
}



def M4_round_features_triggered = GlobalVariable.M4_round_features_triggered
def extraFreeSpinIndex = -1
def extraFreeSpinFeatureStateKeys = null
def extraFreeSpinTypeAndComplete = false

def extraFreeSpinLeft = ''
def extraFreeSpinAdded = ''
for (int i=0; i < M4_round_features_triggered.size(); i++) {
def trigger = M4_round_features_triggered[i]
if (trigger.type.equals("EXTRA_FREE_SPIN") && trigger.complete == true) {

extraFreeSpinTypeAndComplete = true
extraFreeSpinIndex = i
//		extraFreeSpinFeatureStateKeys = M4_round_features_triggered[i].feature_state.keySet()
extraFreeSpinLeft = trigger.feature_state.free_spins_left
extraFreeSpinAdded = trigger.feature_state.free_spins_added

}


}
println(extraFreeSpinIndex)


def freeSpinLeft = GlobalVariable.M4_round_features_triggered[0].feature_state.free_spins_left

println("extraFreeSpinTypeAndComplete is:"+extraFreeSpinTypeAndComplete)
println("extraFreeSpinLeft is: "+extraFreeSpinLeft)
println("extraFreeSpinAdded is: "+extraFreeSpinAdded)
assert extraFreeSpinTypeAndComplete == true
assert extraFreeSpinLeft == M4_spin_number
assert extraFreeSpinAdded == extraFreeSpinLeft - freeSpinLeft
