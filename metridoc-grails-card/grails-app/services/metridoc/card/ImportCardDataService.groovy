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
		Sheet sheet = wb.getSheetAt(0)

		def rowNum = 0
		Row row = sheet.getRow(rowNum)

		while(!row){
			println(row)
			rowNum++
			row = sheet.getRow(rowNum)
		}

		return true
	}

	def checkFileType(String fileType) {
        List<String> supportedTypes = Arrays.asList(
                'application/vnd.ms-excel [official]', 'application/msexcel',
                'application/x-msexcel', 'application/x-ms-excel', 'application/vnd.ms-excel',
                'application/x-excel', 'application/x-dos_ms_excel', 'application/xls',
                'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet'
        )
        return supportedTypes.contains(fileType)
    }

	def getDataFromFile(Workbook wb, FlashScope flash){
		Sheet sheet
		int colNum = 1
		ArrayList<ArrayList<String>> allInstances = new ArrayList<ArrayList<String>>()
		return allInstances
	}
}