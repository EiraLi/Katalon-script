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

WS.sendRequestAndVerify(findTestObject('STG/Wallet/Get_Session_Token', [('url_krug_gw') : url_krug_gw, ('partner') : Partner
            , ('secret_key') : secret_key, ('userid') : Userid]))

M4_login = WS.sendRequestAndVerify(findTestObject('STG/RGS(M4)/M4_Login', [('partner') : Partner, ('game_code') : Game_code
            , ('session_token') : GlobalVariable.session_token]))

def M4_login_user_id = GlobalVariable.M4_login_user_id

M4_init = WS.sendRequestAndVerify(findTestObject('STG/RGS(M4)/M4_init', [('partner') : Partner, ('gameId') : gameId
            , ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))

def rgs_session_token = GlobalVariable.rgs_session_token

def M4_spin_reels_symbols = GlobalVariable.M4_spin_reels_symbols

spin_result = WS.sendRequestAndVerify(findTestObject('STG/RGS(M4)/1_M4_spin', [('M4_login_user_id') : GlobalVariable.M4_login_user_id
            , ('rgs_session_token') : GlobalVariable.rgs_session_token, ('partner') : Partner]))

WS.sendRequestAndVerify(findTestObject('STG/RGS(M4)/in_game_history_BaseSpin', [('partner') : Partner, ('M4_spin_transaction_id') : GlobalVariable.M4_spin_transaction_id
            , ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))

def M4_history_round_id = GlobalVariable.M4_history_round_id

def M4_history_date = GlobalVariable.M4_history_date

WS.sendRequestAndVerify(findTestObject('STG/RGS(M4)/Summary_history', [('partner_code') : partner_code, ('game_code') : Game_code, ('partner') : Partner, ('userid') : Userid]))

WS.sendRequestAndVerify(findTestObject('STG/RGS(M4)/BOpth_summary', [('url_krug') : url_krug, ('userid') : Userid, ('start_date') :start_date, ('end_date') : end_date, ('partner') : Partner]))


//def bo_timeStamp = GlobalVariable.bo_timeStamp

def summary_top_level = GlobalVariable.summary_top_level

def summary_message = GlobalVariable.summary_top_level.message

def summary_provider = GlobalVariable.summary_bonus_provider_1.provider

def summary_type = GlobalVariable.summary_bonus_provider_1.type

def summary_bonus_data = GlobalVariable.summary_bonus_provider_1.bonus_data

def summary_date = GlobalVariable.summary_date_1 + 'Z'


println('GlobalVariable.summary_round_id_1: ' + GlobalVariable.summary_round_id_1)

println('M4_history_round_id: ' + M4_history_round_id)

println('GlobalVariable.summary_total_bet_1: ' + GlobalVariable.summary_total_bet_1)

println('GlobalVariable.M4_history_total_bet: ' + GlobalVariable.M4_history_total_bet)

println('GlobalVariable.summary_bet_value_1: ' + GlobalVariable.summary_bet_value_1)
println('GlobalVariable.summary_total_win_1: ' + GlobalVariable.summary_total_win_1)

println('GlobalVariable.M4_history_total_won: ' + GlobalVariable.M4_history_total_won)

println('GlobalVariable.summary_balance_1: ' + GlobalVariable.summary_balance_1)



println('summary_date: ' + summary_date)
println('GlobalVariable.M4_history_date: ' + M4_history_date)

println('GlobalVariable.summary_round_type_1: ' + GlobalVariable.summary_round_type_1)

println('GlobalVariable.M4_history_type: ' + GlobalVariable.M4_history_type)

println("GlobalVariable.summary_totalCount is: "+GlobalVariable.summary_totalCount)

println("GlobalVariable.bo_totalCount  is: "+GlobalVariable.bo_totalCount )

//check top level 
assert summary_message == null

assert GlobalVariable.summary_round_id_1 == M4_history_round_id

assert GlobalVariable.summary_total_bet_1 == GlobalVariable.M4_history_total_bet

assert GlobalVariable.summary_bet_value_1 == GlobalVariable.M4_history_total_bet

assert GlobalVariable.summary_total_win_1 == GlobalVariable.M4_history_total_won

String M4_history_balance_str = Long.toString(GlobalVariable.M4_history_balance)
println('M4_history_balance_str: ' + M4_history_balance_str)
assert GlobalVariable.summary_balance_1 == M4_history_balance_str

assert summary_date == M4_history_date

assert GlobalVariable.summary_round_type_1 == GlobalVariable.M4_history_type

assert summary_provider == null

assert summary_type == null

assert summary_bonus_data == null

assert GlobalVariable.summary_booster_type_1 == null

assert GlobalVariable.summary_with_free_spin_1 == false

assert GlobalVariable.summary_feature_track_1.size() == 0

assert GlobalVariable.summary_totalCount  == GlobalVariable.bo_totalCount 






