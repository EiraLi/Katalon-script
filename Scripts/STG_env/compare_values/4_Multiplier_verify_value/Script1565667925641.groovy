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

//compare wild_multiplier
//compare wild_config
WS.sendRequestAndVerify(findTestObject('STG/Wallet/Get_Session_Token', [('url_krug_gw') : url_krug_gw, ('partner') : Partner
            , ('secret_key') : secret_key, ('userid') : Userid]))

M4_login = WS.sendRequestAndVerify(findTestObject('STG/RGS(M4)/M4_Login', [('partner') : Partner, ('game_code') : Game_code
            , ('session_token') : GlobalVariable.session_token]))
def M4_login_user_id = GlobalVariable.M4_login_user_id

M4_init = WS.sendRequestAndVerify(findTestObject('STG/RGS(M4)/M4_init', [('partner') : Partner, ('M4_recorder') : M4_recorder
            , ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))

def rgs_session_token = GlobalVariable.rgs_session_token


WS.sendRequestAndVerify(findTestObject('STG/RGS(M4)/1_Round_detail', [('partner') : Partner, ('M4_spin_round_id') : GlobalVariable.M4_spin_round_id]))

WS.sendRequestAndVerify(findTestObject('STG/RGS(M4)/in_game_history_detail', [('partner') : Partner, ('M4_spin_transaction_id') : GlobalVariable.M4_spin_transaction_id, ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))
def M4_round_features_triggered = GlobalVariable.M4_round_features_triggered
def M4_round_reels3 = GlobalVariable.M4_round_reels3
def M4_round_reels5 = GlobalVariable.M4_round_reels5

def wildMultiplierIndex = -1

def extraFreeSpinTypeAndComplete = false


for (int i = 0; i < M4_round_features_triggered.size(); i++) {
	def trigger = M4_round_features_triggered[i]

	if (trigger.type.equals('WILD_MULTIPLIER') && (trigger.complete == true)) {
		extraFreeSpinTypeAndComplete = true

		wildMultiplierIndex = i

		wild_multiplier = trigger.feature_state.wild_multiplier
		
	}
}


def M4_round_spin_result_list = GlobalVariable.M4_round_spin_result_list
def multi = 1
def multi1 = 1

for (int i=0; i < M4_round_features_triggered.size(); i++) {
	def trigger = M4_round_features_triggered[i]
	// only if type is WILD_MULTIPLIER and complete is true will enter
	if (trigger.type.equals("WILD_MULTIPLIER") && trigger.complete == true) {
		def feature_state = trigger.feature_state
		
		def wildConfig2 = feature_state.wild_config[2]
		def wildConfig4 = feature_state.wild_config[4]
		def configValue2 = wildConfig2[0].get('value')
		def configValue4 = wildConfig4[0].get('value')
		if (configValue2 != null && configValue2 != 0) {
			multi = multi * configValue2
			}
		if (configValue4 != null && configValue4 != 0) {
			multi1 = multi1 * configValue4

}
	}
}

			
def config_value = multi * multi1


def M4_round_wild_config = GlobalVariable.M4_round_wild_config
def wildConfig = M4_round_wild_config.value

	
def M4_round_object = GlobalVariable.M4_round_object

def symbolsReels3 = M4_round_reels3.symbols
def Reels3list = new ArrayList()
for (int i=0; i < symbolsReels3.size(); i++) {
	Reels3list.add(symbolsReels3[i].symbol)
}
def symbolsReels5 = M4_round_reels5.symbols
def Reels5list = new ArrayList()
for (int i=0; i < symbolsReels5.size(); i++) {
	Reels5list.add(symbolsReels5[i].symbol)
}

def symbol_value = ''
if (Reels3list.contains("WILD_Double") && Reels3list.contains("WILD_Triple")){
	symbol_value = 6
}
	else if (Reels5list.contains("WILD_Double") && Reels5list.contains("WILD_Triple")){
		symbol_value = 6
	}
	else if (Reels3list.contains("WILD_Double") && Reels5list.contains("WILD_Double")){
		symbol_value = 4
	}
	else if (Reels3list.contains("WILD_Triple") && Reels5list.contains("WILD_Double")){
		symbol_value = 6
	}
	else if (Reels3list.contains("WILD_Double") && Reels5list.contains("WILD_Triple")){
		symbol_value = 6
	}
	else if (Reels3list.contains("WILD_Triple") && Reels5list.contains("WILD_Triple")){
		symbol_value = 9
	}
	else if (Reels3list.contains("WILD_Double")){
		symbol_value = 2
	}
	else if (Reels5list.contains("WILD_Double")){
		symbol_value = 2
	}
	else if (Reels3list.contains("WILD_Triple")){
		symbol_value = 3
	}
	else if (Reels5list.contains("WILD_Triple")){
		symbol_value = 3
	}



println('GlobalVariable.M4_history_multiplier is: ' + GlobalVariable.M4_history_multiplier)

println('symbol_value is: ' + symbol_value)

println('Config_Value is:' + config_value)



//wild_multiplier compare
assert GlobalVariable.M4_history_multiplier == symbol_value
//wild_config compare
assert config_value == GlobalVariable.M4_history_multiplier

