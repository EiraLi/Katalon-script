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

def top_level = new ArrayList()

top_level.add('message')

top_level.add('data')

def data_level = new ArrayList()

data_level.add('summary')

data_level.add('payload')

data_level.add('query')

def payload_detail = new ArrayList()

payload_detail.add('round_id')

payload_detail.add('total_bet')

payload_detail.add('bet_value')

payload_detail.add('total_win')

payload_detail.add('balance')

payload_detail.add('date')

payload_detail.add('round_type')

payload_detail.add('bonus_provider')

payload_detail.add('booster_type')

payload_detail.add('with_free_spin')

payload_detail.add('feature_track')

def bonus_provider = new ArrayList()

bonus_provider.add('provider')

bonus_provider.add('type')

bonus_provider.add('bonus_data')

def query_detail = new ArrayList()

query_detail.add('pageNumber')

query_detail.add('pageSize')

query_detail.add('totalCount')

query_detail.add('serverTime')

WS.sendRequestAndVerify(findTestObject('INT/Wallet/Get_Session_Token', [('url_krug_gw') : url_krug_gw, ('partner') : Partner
            , ('secret_key') : secret_key, ('userid') : Userid]))

M4_login = WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/M4_Login', [('partner') : Partner, ('game_code') : Game_code
            , ('session_token') : GlobalVariable.session_token]))

def M4_login_user_id = GlobalVariable.M4_login_user_id

M4_init = WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/M4_init', [('partner') : Partner, ('gameId') : gameId, ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))

def rgs_session_token = GlobalVariable.rgs_session_token

def M4_spin_reels_symbols = GlobalVariable.M4_spin_reels_symbols

spin_result = WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/1_M4_spin', [('M4_login_user_id') : GlobalVariable.M4_login_user_id
            , ('rgs_session_token') : GlobalVariable.rgs_session_token, ('partner') : Partner]))

WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/Summary_history', [('partner_code') : partner_code, ('game_code') : Game_code
            , ('partner') : Partner, ('userid') : Userid]))

def summary_top_level = GlobalVariable.summary_top_level

def summary_payload = summary_top_level.data.payload[0].keySet()

def summary_bonus_provider = summary_top_level.data.payload[0].bonus_provider.keySet()

def summary_feature_track = summary_top_level.data.payload[0].feature_track

def summary_top_level_key = GlobalVariable.summary_top_level.keySet()

def summary_data_key = GlobalVariable.summary_data.keySet()

def summary_query_key = GlobalVariable.summary_data.query.keySet()

ArrayList summary_top_level_keylist = new ArrayList(summary_top_level_key)

Collections.sort(top_level)

Collections.sort(summary_top_level_keylist)

ArrayList summary_data_key_list = new ArrayList(summary_data_key)

Collections.sort(data_level)

Collections.sort(summary_data_key_list)

ArrayList summary_payload_list = new ArrayList(summary_payload)

Collections.sort(payload_detail)

Collections.sort(summary_payload_list)

ArrayList summary_bonus_provider_list = new ArrayList(summary_bonus_provider)

Collections.sort(bonus_provider)

Collections.sort(summary_bonus_provider_list)

ArrayList summary_query_key_list = new ArrayList(summary_query_key)

Collections.sort(query_detail)

Collections.sort(summary_query_key_list)

println('top_level' + top_level)

println('summary_top_level_key' + summary_top_level_key)

println('data_level' + data_level)

println('summary_data_key' + summary_data_key)

println('payload_detail' + payload_detail)

println('summary_payload' + summary_payload)

println('bonus_provider' + bonus_provider)

println('summary_bonus_provider' + summary_bonus_provider)

println('summary_feature_track' + summary_feature_track)

println('query_detail' + query_detail)

println('summary_query_key' + summary_query_key)

assert top_level == summary_top_level_keylist

assert data_level == summary_data_key_list

assert payload_detail == summary_payload_list

assert bonus_provider == summary_bonus_provider_list

assert summary_feature_track.size() == 0

assert query_detail == summary_query_key_list

WS.callTestCase(findTestCase('INT_env/compare_values/7_summary_page_baseSpin_verify_value'), [('Partner') : Partner
        , ('Userid') : Userid, ('Game_code') : Game_code, ('url_krug_gw') : url_krug_gw
        , ('secret_key') : secret_key, ('gameId') : gameId
        , ('start_date') : start_date, ('end_date') : end_date
        , ('url_krug') : url_krug, ('partner_code') : partner_code])

