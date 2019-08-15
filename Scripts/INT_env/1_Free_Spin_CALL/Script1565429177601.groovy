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

def NG_top_level = new ArrayList()

NG_top_level.add('booster_type')

NG_top_level.add('currency')

NG_top_level.add('player_id')

NG_top_level.add('round_id')

NG_top_level.add('spin_results')

def NG_spin_result = new ArrayList()

NG_spin_result.add('balance')

NG_spin_result.add('bet_value')

NG_spin_result.add('features_triggered')

NG_spin_result.add('line')

NG_spin_result.add('reel_wins')

NG_spin_result.add('reels')

NG_spin_result.add('scatter_win')

NG_spin_result.add('total_bet')

NG_spin_result.add('total_win')

NG_spin_result.add('transaction_id')

NG_spin_result.add('transaction_time')

NG_spin_result.add('transaction_type')

def NG_feature_trigger = new ArrayList()

NG_feature_trigger.add('complete')

NG_feature_trigger.add('feature_state')

NG_feature_trigger.add('subfeatures')

NG_feature_trigger.add('type')

def NG_feature_state = new ArrayList()

NG_feature_state.add('free_spins_left')

NG_feature_state.add('total_free_spin_count')

NG_feature_state.add('total_free_spin_win_amount')

//spin_results[0].reels
def NG_reel = new ArrayList()

NG_reel.add('symbols')

def NG_reel_symbol1 = new ArrayList()

NG_reel_symbol1.add('symbol')

def NG_reel_symbol2 = new ArrayList()

NG_reel_symbol2.add('symbol')

def NG_reel_symbol3 = new ArrayList()

NG_reel_symbol3.add('symbol')

WS.sendRequestAndVerify(findTestObject('INT/Wallet/Get_Session_Token', [('url_krug_gw') : url_krug_gw, ('partner') : Partner
            , ('secret_key') : secret_key, ('userid') : Userid]))

M4_login = WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/M4_Login', [('partner') : Partner, ('game_code') : Game_code
            , ('session_token') : GlobalVariable.session_token]))

def M4_login_user_id = GlobalVariable.M4_login_user_id

M4_init = WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/M4_init', [('partner') : Partner, ('M4_recorder') : M4_recorder
            , ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))

def rgs_session_token = GlobalVariable.rgs_session_token

def M4_spin_reels_symbols = GlobalVariable.M4_spin_reels_symbols

for (int i = 0; i <= 300; i++) {
    spin_result = WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/1_M4_spin', [('M4_login_user_id') : GlobalVariable.M4_login_user_id
                , ('rgs_session_token') : GlobalVariable.rgs_session_token, ('partner') : Partner]))

    if ((((GlobalVariable.free_spin_reel_counter[0]) >= 1) && ((GlobalVariable.free_spin_reel_counter[1]) >= 1)) && ((GlobalVariable.free_spin_reel_counter[
    2]) >= 1)) {
        break
    }
}

WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/1_Round_detail', [('partner') : Partner, ('M4_spin_round_id') : GlobalVariable.M4_spin_round_id]))

def M4_round_object_key = GlobalVariable.M4_round_object.keySet()

def M4_round_spin_result_key = GlobalVariable.M4_round_spin_result_list.keySet()

def M4_round_feature_triggered_key = GlobalVariable.M4_round_features_triggered[0].keySet()

def M4_round_reel_key = GlobalVariable.M4_round_reels1.keySet()

def M4_round_feature_state_key = GlobalVariable.M4_round_feature_state.keySet()

def M4_round_reels_symbols_key_1 = GlobalVariable.M4_round_reels0_symbols1.keySet()

def M4_round_reels_symbols_key_2 = GlobalVariable.M4_round_reels0_symbols2.keySet()

def M4_round_reels_symbols_key_3 = GlobalVariable.M4_round_reels0_symbols3.keySet()

ArrayList M4_round_object_key_list = new ArrayList(M4_round_object_key)

ArrayList M4_round_spin_result_key_list = new ArrayList(M4_round_spin_result_key)

ArrayList M4_round_feature_triggered_key_list = new ArrayList(M4_round_feature_triggered_key)

ArrayList M4_round_reel_key_list = new ArrayList(M4_round_reel_key)

ArrayList M4_round_feature_state_key_list = new ArrayList(M4_round_feature_state_key)

ArrayList M4_round_reels_symbols_key1 = new ArrayList(M4_round_reels_symbols_key_1)

ArrayList M4_round_reels_symbols_key2 = new ArrayList(M4_round_reels_symbols_key_2)

ArrayList M4_round_reels_symbols_key3 = new ArrayList(M4_round_reels_symbols_key_3)

println('M4_round_object_key_list is:' + M4_round_object_key_list)

println('M4_round_spin_result_key_list is: ' + M4_round_spin_result_key_list)

println('M4_round_feature_triggered_key_list is: ' + M4_round_feature_triggered_key_list)

println('M4_round_reel_key_list is: ' + M4_round_reel_key_list)

println('M4_round_feature_state_key_list is: ' + M4_round_feature_state_key_list)

println('M4_round_reels_symbols_key_1 is: ' + M4_round_reels_symbols_key_1)

println('M4_round_reels_symbols_key_2 is: ' + M4_round_reels_symbols_key_2)

println('M4_round_reels_symbols_key_3 is: ' + M4_round_reels_symbols_key_3)

println('NG_top_level is: ' + NG_top_level)

println('NG_spin_result is:' + NG_spin_result)

println('NG_feature_trigger is:' + NG_feature_trigger)

println('NG_reel is: ' + NG_reel)

println('NG_feature_state is: ' + NG_feature_state)

println('NG_reel_symbol1 is: ' + NG_reel_symbol1)

println('NG_reel_symbol2 is: ' + NG_reel_symbol2)

println('NG_reel_symbol3 is: ' + NG_reel_symbol3)

assert NG_top_level.equals(M4_round_object_key_list)

assert NG_spin_result.equals(M4_round_spin_result_key_list)

assert NG_feature_trigger.equals(M4_round_feature_triggered_key_list)

assert NG_reel.equals(M4_round_reel_key_list)

assert NG_feature_state.equals(M4_round_feature_state_key_list)

assert NG_reel_symbol1.equals(M4_round_reels_symbols_key1)

assert NG_reel_symbol2.equals(M4_round_reels_symbols_key2)

assert NG_reel_symbol3.equals(M4_round_reels_symbols_key3)

WS.callTestCase(findTestCase('INT_env/compare_values/1_freeSpin_verify_value'), [('Partner') : Partner
        , ('Userid') : Userid, ('Game_code') : Game_code, ('url_krug_gw') : url_krug_gw, ('secret_key') : secret_key, ('M4_recorder') : M4_recorder])

