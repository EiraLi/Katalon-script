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
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.time.LocalDateTime
import java.time.Instant
import java.time.ZoneId
// transaction time as string
//txtime='2017-11-20T21:27:03Z'
//round_detail time
txtime='2019-08-19 08:32:06'
// parse and get epoch
DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
Date time = formatter.parse(txtime);
// get epoch milis
epoch_milis = time.getTime()
println(epoch_milis)


// create UTC local time
//local_dt = LocalDateTime.ofInstant(Instant.ofEpochMilli(epoch_milis), ZoneId.of('UTC'));
//// created zoned time out of UTC time
//zoned_dt = local_dt.atZone(ZoneId.of('America/Los_Angeles'))
//// get offset in milis
//offset_ms = zoned_dt.getOffset().getTotalSeconds() * 1000
//// add to UTC epoc
//local_timestamp = epoch_milis + offset_ms
//println "Time is ${local_timestamp}"




