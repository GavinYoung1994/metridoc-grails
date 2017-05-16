package metridoc.grails.card

import grails.converters.JSON
import org.apache.poi.openxml4j.exceptions.InvalidFormatException
import org.apache.poi.ss.usermodel.Workbook
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.web.multipart.MultipartFile
import java.util.regex.Matcher
import java.util.regex.Pattern

import java.text.SimpleDateFormat

class SpreadsheetController {

	def importCardDataService
	def exportCardDataService

	def index = {
		println "hello"
        session.setAttribute("prev", new String("index"))

    }

    def test() { 
        println "For Testing purposes only"
    }

    def upload = {
    	println "hello2"
        withForm {
            MultipartFile uploadedFile = request.getFile("spreadsheetUpload")
            Workbook wb
            if (uploadedFile == null || uploadedFile.empty) {
                flash.alerts << "No file was provided"
                redirect(action: "index")
                return
            }

            if (!importCardDataService.checkFileType(uploadedFile.getContentType())) {
                flash.alerts << "Invalid File Type. Only Excel Files are accepted!"
                redirect(action: "index")
                return
            }

            // def valNameResponse = spreadsheetService.validateFilename(uploadedFile.originalFilename)
            // if (valNameResponse != "good"){
            //     flash.alerts << valNameResponse
            //     redirect(action: "index")
            //     return
            // }


            try{
                wb = importCardDataService.convertToWorkbook(uploadedFile)
            }catch(InvalidFormatException e){
                flash.message = message(code:"spreadsheet.illegal.argument")
                return
            }

            if (!importCardDataService.validateFormat(wb)) {
            	println("failed")
                flash.alerts << "Invalid Spreadsheet Format. Cannot Parse it."
                redirect(action: "index")
                return
            }

            TreeMap<String,ArrayList<ArrayList<String>>> allInstances = importCardDataService.getDataFromFile(wb, flash)
            if (!allInstances?.size()) {
                redirect(action: "index")
                return
            }
            def numCons = allInstances?.get("cons")?.size() ?: 0
            def numIns = allInstances?.get("ins")?.size() ?: 0
            log.warn "***********************"
            log.warn "${allInstances}"
            log.warn "${numCons}"
            log.warn "${numIns}"
            log.warn "***********************"

            // if (spreadsheetService.saveToDatabase(allInstances, uploadedFile.originalFilename, flash)) {
            //     flash.infos << "Spreadsheet successfully uploaded. " +
            //         String.valueOf(numCons) + " consultation instances and "+ String.valueOf(numIns)+" instructional instances uploaded."
            //     redirect(action: "index")
            // } else {
            //     redirect(action: "index")
            //     return
            // }
        }.invalidToken {
            flash.alerts << "Don't click the uploading button more than one time to make duplicated submission!"
            redirect(action: "index")
        }
    }
}
