package metridoc.card

import org.apache.poi.ss.usermodel.*
import org.apache.poi.ss.util.CellReference
import org.codehaus.groovy.grails.web.servlet.FlashScope
import org.springframework.web.multipart.MultipartFile

import java.text.SimpleDateFormat

class ImportCardDataService {
	def convertToWorkbook(MultipartFile uploadedFile){
		Workbook wb = WorkbookFactory.create(uploadedFile.inputStream)
		return wb
	}

	def validateFormat(Workbook wb){
		return true
	}

	def getDataFromFile(Workbook wb, FlashScope flash){
		Sheet sheet
		int colNum = 1
		ArrayList<ArrayList<String>> allInstances = new ArrayList<ArrayList<String>>()
		return allInstances
	}
}