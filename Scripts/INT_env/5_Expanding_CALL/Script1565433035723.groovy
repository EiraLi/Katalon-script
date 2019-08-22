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

def Expanding = new ArrayList()

Expanding.add('original_reels')

Expanding.add('swapped_symbols')

WS.sendRequestAndVerify(findTestObject('INT/Wallet/Get_Session_Token', [('url_krug_gw') : url_krug_gw, ('partner') : Partner
            , ('secret_key') : secret_key, ('userid') : Userid]))

M4_login = WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/M4_Login', [('partner') : Partner, ('game_code') : Game_code
            , ('session_token') : GlobalVariable.session_token]))

def M4_login_user_id = GlobalVariable.M4_login_user_id

M4_init = WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/M4_init', [('partner') : Partner, ('M4_recorder') : M4_recorder
            , ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))

def rgs_session_token = GlobalVariable.rgs_session_token

for (int i = 0; i <= 500; i++) {
    def free_spin_reel_counter = GlobalVariable.free_spin_reel_counter

    def M4_spin_reels_symbols = GlobalVariable.M4_spin_reels_symbols

    def M4_total_bonus_spins = GlobalVariable.M4_total_bonus_spins

    spin_result = WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/1_M4_spin', [('M4_login_user_id') : GlobalVariable.M4_login_user_id
                , ('rgs_session_token') : GlobalVariable.rgs_session_token, ('partner') : Partner]))

    if ((GlobalVariable.M4_total_bonus_spins_int != 0) && GlobalVariable.M4_spin_reels_symbols[2].contains('WILD_Expanding')) {
        break
    }
}

WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/1_Round_detail', [('partner') : Partner, ('M4_spin_round_id') : GlobalVariable.M4_spin_round_id]))

def M4_round_features_triggered = GlobalVariable.M4_round_features_triggered

def wildExpandingIndex = -1

def wildExpandingFeatureStateKeys = null

for (int i = 0; i < M4_round_features_triggered.size(); i++) {
    if (M4_round_features_triggered[i].type.equals('EXPANDING_WILD')) {
        wildExpandingIndex = i

        wildExpandingFeatureStateKeys = M4_round_features_triggered[i].feature_state.keySet()
    }
}

println(wildExpandingIndex)

println(wildExpandingFeatureStateKeys)

ArrayList Expanding_keys = new ArrayList(wildExpandingFeatureStateKeys)

Collections.sort(Expanding)

Collections.sort(Expanding_keys)

println('Expanding is:' + Expanding)

println('Expanding_keys is:' + Expanding_keys)

assert Expanding.equals(Expanding_keys)

WS.callTestCase(findTestCase('INT_env/compare_values/5_Expanding_verify_value_and_summary'), 
    [('Partner') : Partner, ('Userid') : Userid, ('Game_code') : Game_code
        , ('url_krug_gw') : url_krug_gw, ('secret_key') : secret_key
        , ('M4_recorder') : M4_recorder])

