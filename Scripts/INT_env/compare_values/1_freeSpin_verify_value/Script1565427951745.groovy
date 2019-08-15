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


String excelTestFile02 = '/Users/eiralee/Katalon_Script/SuperWild/Reports/TestFile02.xls'

ExcelKeywords.createExcelFile(excelTestFile02)

File testfile = new File(excelTestFile02)
assert testfile.exists() == true

workbook01 = ExcelKeywords.getWorkbook(excelTestFile02)
ExcelKeywords.createExcelSheets(workbook01, ['NuRGS', 'M4_historyOrOthersAPI'])
ExcelKeywords.saveWorkbook(excelTestFile02, workbook01)

String[] SheetCreated01 = ['Sheet0','NuRGS', 'M4_historyOrOthersAPI']
workbook01 = ExcelKeywords.getWorkbook(excelTestFile02)
assert SheetCreated01 == ExcelKeywords.getSheetNames(workbook01)

NuRGS = ExcelKeywords.getExcelSheet(workbook01, 'NuRGS')
Map content = new HashMap<>()
content.putAt('A2', 'currency')
content.putAt('A3', 'round_id')
content.putAt('A4', 'balance')
content.putAt('A5', 'bet_value')
content.putAt('A6', "total_bet")
content.putAt('A7', "total_win")
content.putAt('A8', "transaction_id")
content.putAt('A9', "transaction_type")
//base spin spin result reel
content.putAt('A10', "reels0_01_symbols")
content.putAt('A11', "reels0_02_symbols")
content.putAt('A12', "reels0_03_symbols")
content.putAt('A13', "reels1_01_symbols")
content.putAt('A14', "reels1_02_symbols")
content.putAt('A15', "reels1_03_symbols")
content.putAt('A16', "reels2_01_symbols")
content.putAt('A17', "reels2_02_symbols")
content.putAt('A18', "reels2_03_symbols")
content.putAt('A19', "reels3_01_symbols")
content.putAt('A20', "reels3_02_symbols")
content.putAt('A21', "reels3_03_symbols")
content.putAt('A22', "reels4_01_symbols")
content.putAt('A23', "reels4_02_symbols")
content.putAt('A24', "reels4_03_symbols")

//free spin 1st time reel
content.putAt('A25', "F_reels0_01_symbols")
content.putAt('A26', "F_reels0_02_symbols")
content.putAt('A27', "F_reels0_03_symbols")
content.putAt('A28', "F_reels1_01_symbols")
content.putAt('A29', "F_reels1_02_symbols")
content.putAt('A30', "F_reels1_03_symbols")
content.putAt('A31', "F_reels2_01_symbols")
content.putAt('A32', "F_reels2_02_symbols")
content.putAt('A33', "F_reels2_03_symbols")
content.putAt('A34', "F_reels3_01_symbols")
content.putAt('A35', "F_reels3_02_symbols")
content.putAt('A36', "F_reels3_03_symbols")
content.putAt('A37', "F_reels4_01_symbols")
content.putAt('A38', "F_reels4_02_symbols")
content.putAt('A39', "F_reels4_03_symbols")




ExcelKeywords.setValueToCellByAddresses(NuRGS, content)
ExcelKeywords.saveWorkbook(excelTestFile02, workbook01)


M4_historyOrOthersAPI = ExcelKeywords.getExcelSheet(workbook01, 'M4_historyOrOthersAPI')
Map content1 = new HashMap<>()
content1.putAt('A2', 'currency')
content1.putAt('A3', 'round_id')
content1.putAt('A4', 'balance')
content1.putAt('A5', 'bet_value')
content1.putAt('A6', "total_bet")
content1.putAt('A7', "total_win")
content1.putAt('A8', "transaction_id")
content1.putAt('A9', "transaction_type")

//base spin spin result reel
content1.putAt('A10', "reels0_01_symbols")
content1.putAt('A11', "reels0_02_symbols")
content1.putAt('A12', "reels0_03_symbols")
content1.putAt('A13', "reels1_01_symbols")
content1.putAt('A14', "reels1_02_symbols")
content1.putAt('A15', "reels1_03_symbols")
content1.putAt('A16', "reels2_01_symbols")
content1.putAt('A17', "reels2_02_symbols")
content1.putAt('A18', "reels2_03_symbols")
content1.putAt('A19', "reels3_01_symbols")
content1.putAt('A20', "reels3_02_symbols")
content1.putAt('A21', "reels3_03_symbols")
content1.putAt('A22', "reels4_01_symbols")
content1.putAt('A23', "reels4_02_symbols")
content1.putAt('A24', "reels4_03_symbols")

//free spin 1st time reel
content1.putAt('A25', "F_reels0_01_symbols")
content1.putAt('A26', "F_reels0_02_symbols")
content1.putAt('A27', "F_reels0_03_symbols")
content1.putAt('A28', "F_reels1_01_symbols")
content1.putAt('A29', "F_reels1_02_symbols")
content1.putAt('A30', "F_reels1_03_symbols")
content1.putAt('A31', "F_reels2_01_symbols")
content1.putAt('A32', "F_reels2_02_symbols")
content1.putAt('A33', "F_reels2_03_symbols")
content1.putAt('A34', "F_reels3_01_symbols")
content1.putAt('A35', "F_reels3_02_symbols")
content1.putAt('A36', "F_reels3_03_symbols")
content1.putAt('A37', "F_reels4_01_symbols")
content1.putAt('A38', "F_reels4_02_symbols")
content1.putAt('A39', "F_reels4_03_symbols")


ExcelKeywords.setValueToCellByAddresses(M4_historyOrOthersAPI, content1)
ExcelKeywords.saveWorkbook(excelTestFile02, workbook01)


WS.sendRequestAndVerify(findTestObject('INT/Wallet/Get_Session_Token', [('url_krug_gw') : url_krug_gw, ('partner') : Partner
            , ('secret_key') : secret_key, ('userid') : Userid]))

M4_login = WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/M4_Login', [('partner') : Partner, ('game_code') : Game_code
            , ('session_token') : GlobalVariable.session_token]))

def M4_login_user_id = GlobalVariable.M4_login_user_id

M4_init = WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/M4_init', [('partner') : Partner, ('M4_recorder') : M4_recorder
            , ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))

def rgs_session_token = GlobalVariable.rgs_session_token

def M4_spin_reels_symbols = GlobalVariable.M4_spin_reels_symbols


WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/1_Round_detail', [('partner') : Partner, ('M4_spin_round_id') : GlobalVariable.M4_spin_round_id]))


def M4_balance = GlobalVariable.M4_round_balance
Long M4_round_balance = Long.valueOf(M4_balance)

def M4_round_spin_result = GlobalVariable.M4_round_object.spin_results
def M4_round_free_spin_totalWin_result = ''
def M4_total_win = 0
for (i = 0; i < M4_round_spin_result.size(); i++) {
	def last_spin_result = M4_round_spin_result[i].balance
	def M4_round_free_spin_totalWin = M4_round_spin_result[i].total_win
	println(last_spin_result)
	println(M4_round_free_spin_totalWin)
	
	M4_total_win = M4_round_free_spin_totalWin + M4_total_win
	println("M4_round_free_spin_totalWin_result is: "+M4_round_free_spin_totalWin_result)
	if (last_spin_result >= M4_round_balance) {
		

		M4_round_balance = last_spin_result
	}
}


WS.sendRequestAndVerify(findTestObject('INT/RGS(M4)/in_game_history_detail', [('partner') : Partner, ('M4_spin_transaction_id') : GlobalVariable.M4_spin_transaction_id, ('M4_login_user_id') : GlobalVariable.M4_login_user_id]))


//Round detail, base spin reel
def reels01 = GlobalVariable.M4_round_reels1.symbols[0].symbol
//reels01Values = reels01.values()
println(reels01.getClass().getName())
println(reels01)
def reels02 = GlobalVariable.M4_round_reels1.symbols[1].symbol
def reels03 = GlobalVariable.M4_round_reels1.symbols[2].symbol

def reels11 = GlobalVariable.M4_round_reels2.symbols[0].symbol
def reels12 = GlobalVariable.M4_round_reels2.symbols[1].symbol
def reels13 = GlobalVariable.M4_round_reels2.symbols[2].symbol

def reels21 = GlobalVariable.M4_round_reels3.symbols[0].symbol
def reels22 = GlobalVariable.M4_round_reels3.symbols[1].symbol
def reels23 = GlobalVariable.M4_round_reels3.symbols[2].symbol

def reels31 = GlobalVariable.M4_round_reels4.symbols[0].symbol
def reels32 = GlobalVariable.M4_round_reels4.symbols[1].symbol
def reels33 = GlobalVariable.M4_round_reels4.symbols[2].symbol

def reels41 = GlobalVariable.M4_round_reels5.symbols[0].symbol
def reels42 = GlobalVariable.M4_round_reels5.symbols[1].symbol
def reels43 = GlobalVariable.M4_round_reels5.symbols[2].symbol
// Round_detail free spin 1st time spin result reel
def F_reels01 = GlobalVariable.M4_round_F_reels1.symbols[0].symbol
def F_reels02 = GlobalVariable.M4_round_F_reels1.symbols[1].symbol
def F_reels03 = GlobalVariable.M4_round_F_reels1.symbols[2].symbol

def F_reels11 = GlobalVariable.M4_round_F_reels2.symbols[0].symbol
def F_reels12 = GlobalVariable.M4_round_F_reels2.symbols[1].symbol
def F_reels13 = GlobalVariable.M4_round_F_reels2.symbols[2].symbol

def F_reels21 = GlobalVariable.M4_round_F_reels3.symbols[0].symbol
def F_reels22 = GlobalVariable.M4_round_F_reels3.symbols[1].symbol
def F_reels23 = GlobalVariable.M4_round_F_reels3.symbols[2].symbol

def F_reels31 = GlobalVariable.M4_round_F_reels4.symbols[0].symbol
def F_reels32 = GlobalVariable.M4_round_F_reels4.symbols[1].symbol
def F_reels33 = GlobalVariable.M4_round_F_reels4.symbols[2].symbol

def F_reels41 = GlobalVariable.M4_round_F_reels5.symbols[0].symbol
def F_reels42 = GlobalVariable.M4_round_F_reels5.symbols[1].symbol
def F_reels43 = GlobalVariable.M4_round_F_reels5.symbols[2].symbol

def wildList = GlobalVariable.wildList

def free_spin_reels = GlobalVariable.M4_round_spin_result1.reels
for (int i = 0; i< free_spin_reels.size(); i++) {
	def symbols = free_spin_reels[i].symbols
	if (i == 2 || i == 3 || i == 4) {
		for (int j=0; j < symbols.size(); j++) {
			def symbol = symbols[j].symbol
			println(symbol)
			println(i)
			if (i == 2) {
				if (j == 0 && wildList.indexOf(symbol) != -1) F_reels21 = "WILD"
				if (j == 1 && wildList.indexOf(symbol) != -1) F_reels22 = "WILD"
				if (j == 2 && wildList.indexOf(symbol) != -1) F_reels23 = "WILD"
			}
			if (i == 3) {
				if (j == 0 && wildList.indexOf(symbol) != -1) F_reels31 = "WILD"
				if (j == 1 && wildList.indexOf(symbol) != -1) F_reels32 = "WILD"
				if (j == 2 && wildList.indexOf(symbol) != -1) F_reels33 = "WILD"
			}
			
			if (i == 4 && wildList.indexOf(symbol) != -1) {
				if (j == 0 && wildList.indexOf(symbol) != -1) F_reels41 = "WILD"
				if (j == 1 && wildList.indexOf(symbol) != -1) F_reels42 = "WILD"
				if (j == 2 && wildList.indexOf(symbol) != -1) F_reels43 = "WILD"
			}
		}
	}
}
	
//M4 history, base spin reel
def M4_history_reels = GlobalVariable.M4_history_reels
def M4reels01 = GlobalVariable.M4_history_reels[0].symbols[0].symbol
println(M4reels01)
def M4reels02 = GlobalVariable.M4_history_reels[0].symbols[1].symbol
def M4reels03 = GlobalVariable.M4_history_reels[0].symbols[2].symbol

def M4reels11 = GlobalVariable.M4_history_reels[1].symbols[0].symbol
def M4reels12 = GlobalVariable.M4_history_reels[1].symbols[1].symbol
def M4reels13 = GlobalVariable.M4_history_reels[1].symbols[2].symbol

def M4reels21 = GlobalVariable.M4_history_reels[2].symbols[0].symbol
def M4reels22 = GlobalVariable.M4_history_reels[2].symbols[1].symbol
def M4reels23 = GlobalVariable.M4_history_reels[2].symbols[2].symbol

def M4reels31 = GlobalVariable.M4_history_reels[3].symbols[0].symbol
def M4reels32 = GlobalVariable.M4_history_reels[3].symbols[1].symbol
def M4reels33 = GlobalVariable.M4_history_reels[3].symbols[2].symbol

def M4reels41 = GlobalVariable.M4_history_reels[4].symbols[0].symbol
def M4reels42 = GlobalVariable.M4_history_reels[4].symbols[1].symbol
def M4reels43 = GlobalVariable.M4_history_reels[4].symbols[2].symbol



// M4_history, free spin 1st time spin result reel
def F_M4reels01 = GlobalVariable.M4_history_F_reels[0].symbols[0].symbol
println(F_M4reels01)
def F_M4reels02 = GlobalVariable.M4_history_F_reels[0].symbols[1].symbol
def F_M4reels03 = GlobalVariable.M4_history_F_reels[0].symbols[2].symbol

def F_M4reels11 = GlobalVariable.M4_history_F_reels[1].symbols[0].symbol
def F_M4reels12 = GlobalVariable.M4_history_F_reels[1].symbols[1].symbol
def F_M4reels13 = GlobalVariable.M4_history_F_reels[1].symbols[2].symbol

def F_M4reels21 = GlobalVariable.M4_history_F_reels[2].symbols[0].symbol
def F_M4reels22 = GlobalVariable.M4_history_F_reels[2].symbols[1].symbol
def F_M4reels23 = GlobalVariable.M4_history_F_reels[2].symbols[2].symbol

def F_M4reels31 = GlobalVariable.M4_history_F_reels[3].symbols[0].symbol
def F_M4reels32 = GlobalVariable.M4_history_F_reels[3].symbols[1].symbol
def F_M4reels33 = GlobalVariable.M4_history_F_reels[3].symbols[2].symbol

def F_M4reels41 = GlobalVariable.M4_history_F_reels[4].symbols[0].symbol
def F_M4reels42 = GlobalVariable.M4_history_F_reels[4].symbols[1].symbol
def F_M4reels43 = GlobalVariable.M4_history_F_reels[4].symbols[2].symbol


def M4_history_balance = GlobalVariable.M4_history_balance
long M4_history_balance_result = new Long(M4_history_balance)

ExcelKeywords.setValueToCellByIndex(NuRGS, 1, 1, GlobalVariable.M4_round_currency)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 1, 1, GlobalVariable.M4_history_currency)
ExcelKeywords.setValueToCellByIndex(NuRGS, 2, 1, GlobalVariable.M4_round_id)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 2, 1, GlobalVariable.M4_history_round_id)

ExcelKeywords.setValueToCellByIndex(NuRGS, 3, 1, M4_round_balance)


ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 3, 1, M4_history_balance_result)
ExcelKeywords.setValueToCellByIndex(NuRGS, 4, 1, GlobalVariable.M4_round_bet_value)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 4, 1, GlobalVariable.M4_history_total_bet)
ExcelKeywords.setValueToCellByIndex(NuRGS, 5, 1, GlobalVariable.M4_round_total_bet)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 5, 1, GlobalVariable.M4_history_total_bet)
ExcelKeywords.setValueToCellByIndex(NuRGS, 6, 1, M4_total_win)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 6, 1, GlobalVariable.M4_history_total_won)
ExcelKeywords.setValueToCellByIndex(NuRGS, 7, 1, GlobalVariable.M4_round_transaction_id)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 7, 1, GlobalVariable.M4_history_spin_transaction)

ExcelKeywords.setValueToCellByIndex(NuRGS, 8, 1, GlobalVariable.M4_round_transaction_type)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 8, 1, "BASE")
//Round detail base spin
ExcelKeywords.setValueToCellByIndex(NuRGS, 9, 1, reels01)
ExcelKeywords.setValueToCellByIndex(NuRGS, 10, 1, reels02)
ExcelKeywords.setValueToCellByIndex(NuRGS, 11, 1, reels03)
ExcelKeywords.setValueToCellByIndex(NuRGS, 12, 1, reels11)
ExcelKeywords.setValueToCellByIndex(NuRGS, 13, 1, reels12)
ExcelKeywords.setValueToCellByIndex(NuRGS, 14, 1, reels13)
ExcelKeywords.setValueToCellByIndex(NuRGS, 15, 1, reels21)
ExcelKeywords.setValueToCellByIndex(NuRGS, 16, 1, reels22)
ExcelKeywords.setValueToCellByIndex(NuRGS, 17, 1, reels23)
ExcelKeywords.setValueToCellByIndex(NuRGS, 18, 1, reels31)
ExcelKeywords.setValueToCellByIndex(NuRGS, 19, 1, reels32)
ExcelKeywords.setValueToCellByIndex(NuRGS, 20, 1, reels33)
ExcelKeywords.setValueToCellByIndex(NuRGS, 21, 1, reels41)
ExcelKeywords.setValueToCellByIndex(NuRGS, 22, 1, reels42)
ExcelKeywords.setValueToCellByIndex(NuRGS, 23, 1, reels43)
//free spin 1 round
ExcelKeywords.setValueToCellByIndex(NuRGS, 24, 1, F_reels01)
ExcelKeywords.setValueToCellByIndex(NuRGS, 25, 1, F_reels02)
ExcelKeywords.setValueToCellByIndex(NuRGS, 26, 1, F_reels03)
ExcelKeywords.setValueToCellByIndex(NuRGS, 27, 1, F_reels11)
ExcelKeywords.setValueToCellByIndex(NuRGS, 28, 1, F_reels12)
ExcelKeywords.setValueToCellByIndex(NuRGS, 29, 1, F_reels13)
ExcelKeywords.setValueToCellByIndex(NuRGS, 30, 1, F_reels21)
ExcelKeywords.setValueToCellByIndex(NuRGS, 31, 1, F_reels22)
ExcelKeywords.setValueToCellByIndex(NuRGS, 32, 1, F_reels23)
ExcelKeywords.setValueToCellByIndex(NuRGS, 33, 1, F_reels31)
ExcelKeywords.setValueToCellByIndex(NuRGS, 34, 1, F_reels32)
ExcelKeywords.setValueToCellByIndex(NuRGS, 35, 1, F_reels33)
ExcelKeywords.setValueToCellByIndex(NuRGS, 36, 1, F_reels41)
ExcelKeywords.setValueToCellByIndex(NuRGS, 37, 1, F_reels42)
ExcelKeywords.setValueToCellByIndex(NuRGS, 38, 1, F_reels43)

//M4_history base spin
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 9, 1, M4reels01)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 10, 1, M4reels02)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 11, 1, M4reels03)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 12, 1, M4reels11)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 13, 1, M4reels12)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 14, 1, M4reels13)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 15, 1, M4reels21)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 16, 1, M4reels22)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 17, 1, M4reels23)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 18, 1, M4reels31)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 19, 1, M4reels32)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 20, 1, M4reels33)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 21, 1, M4reels41)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 22, 1, M4reels42)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 23, 1, M4reels43)

//M4_history free spin 1st round
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 24, 1, F_M4reels01)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 25, 1, F_M4reels02)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 26, 1, F_M4reels03)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 27, 1, F_M4reels11)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 28, 1, F_M4reels12)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 29, 1, F_M4reels13)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 30, 1, F_M4reels21)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 31, 1, F_M4reels22)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 32, 1, F_M4reels23)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 33, 1, F_M4reels31)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 34, 1, F_M4reels32)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 35, 1, F_M4reels33)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 36, 1, F_M4reels41)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 37, 1, F_M4reels42)
ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 38, 1, F_M4reels43)


ExcelKeywords.setValueToCellByAddresses(M4_historyOrOthersAPI, content1)
ExcelKeywords.setValueToCellByAddresses(NuRGS, content)
ExcelKeywords.saveWorkbook(excelTestFile02, workbook01)

CompareSheet_result = ExcelKeywords.compareTwoSheets(NuRGS, M4_historyOrOthersAPI)
println("Result of compare sheet01 of File01Sheet01 and File02Sheet01 is: " + CompareSheet_result)

//assert GlobalVariable.M4_round_booster_type == null
//ExcelKeywords.setValueToCellByIndex(NuRGS, 0, 1, GlobalVariable.M4_round_currency)
//ExcelKeywords.setValueToCellByIndex(M4_historyOrOthersAPI, 0, 1, GlobalVariable.M4_history_currency)

println("reels01 is: "+reels01)
println("M4reels01 is: "+M4reels01)
println("F_reels01 is: "+F_reels01)
println("F_M4reels01 is: "+F_M4reels01)

def feature_trigger_complete = GlobalVariable.M4_round_spin_result_list.features_triggered[0].complete
println("feature_trigger_complete" +feature_trigger_complete)

assert reels01 == M4reels01
assert F_reels01 == F_M4reels01
assert feature_trigger_complete != true