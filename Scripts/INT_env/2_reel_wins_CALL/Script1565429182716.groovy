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

//NG game Keys need to be compared with round  detail api
def reel_wins = new ArrayList()

(reel_wins[0]) = 'line_config'

(reel_wins[1]) = 'line_number'

(reel_wins[2]) = 'of_kind'

(reel_wins[3]) = 'prize'

(reel_wins[4]) = 'right_to_left'

(reel_wins[5]) = 'symbol'

(reel_wins[6]) = 'wild_win'

WS.sendRequestAndVerify(findTestObject('INT/Wallet/Get_Session_Token', [('url_krug_gw') : url_krug_gw, ('partner') : Partner
            , ('secret_key') : secret_key, ('userid') : Userid]))

M4_login = WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/M4_Login', [('partner') : Partner, ('game_code') : Game_code
            , ('session_token') : GlobalVariable.session_token]))

def M4_login_user_id = GlobalVariable.M4_login_user_id

M4_init = WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/M4_init', [('partner') : Partner, ('M4_recorder') : M4_recorder
            , ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))

def rgs_session_token = GlobalVariable.rgs_session_token

for (int i = 0; i <= 500; i++) {
    def M4_spin_line_wins = GlobalVariable.M4_spin_line_wins

    def M4_spin_total_bonus_win_this_round = GlobalVariable.M4_spin_total_bonus_win_this_round

    spin_result = WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/1_M4_spin', [('M4_login_user_id') : GlobalVariable.M4_login_user_id
                , ('rgs_session_token') : GlobalVariable.rgs_session_token, ('partner') : Partner]))

    if ((GlobalVariable.M4_total_bonus_spins != 0) && (GlobalVariable.M4_spin_line_wins.size() != 0)) {
        break
    }
}

WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/2_Round_detail', [('partner') : Partner, ('M4_spin_round_id') : GlobalVariable.M4_spin_round_id]))

def M4_round_All_keys = GlobalVariable.M4_round_reel_wins.keySet()

ArrayList listofKeys = new ArrayList(M4_round_All_keys)

println('listofKeys is: ' + listofKeys)

println('reel_wins_list' + reel_wins)

assert reel_wins.equals(listofKeys)

WS.callTestCase(findTestCase('INT_env/compare_values/2_reel_wins_verify_value'), [('Partner') : Partner
        , ('Userid') : Userid, ('Game_code') : Game_code, ('url_krug_gw') : url_krug_gw
        , ('secret_key') : secret_key, ('M4_recorder') : M4_recorder])

