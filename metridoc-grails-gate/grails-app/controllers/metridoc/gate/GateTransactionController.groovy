package metridoc.gate

import grails.converters.JSON
import org.apache.poi.openxml4j.exceptions.InvalidFormatException
import org.apache.poi.ss.usermodel.Workbook
import org.apache.shiro.SecurityUtils
import org.springframework.dao.DataIntegrityViolationException
import org.springframework.web.multipart.MultipartFile
import org.springframework.web.multipart.commons.CommonsMultipartFile
import java.util.regex.Matcher
import java.util.regex.Pattern

import java.text.SimpleDateFormat

class GateTransactionController {
	static homePage = [title: "Library Gate Traffic Information",
                       description: "Look up data of number and time of people entering libraries"]

    static boolean isProtected = true;

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"];

    def gateService;

    def index() {
    	def allDoorNames = createNameArray(gateService.getAllDoors());
    	def allAffiliationNames = createNameArray(gateService.getAllAffiliations());
    	def allCenterNames = createNameArray(gateService.getAllCenters());
    	def allDepartmentNames = createNameArray(gateService.getAllDepartments());
    	def allUSCNames = createNameArray(gateService.getAllUSCs());
    	render(view: "index", 
    		   model: [
    		     allDoorNames: allDoorNames, 
    		     allAffiliationNames: allAffiliationNames,
    		     allCenterNames: allCenterNames,
    		     allDepartmentNames: allDepartmentNames,
    		     allUSCNames: allUSCNames]);
	    session.setAttribute("prev", new String("index"));
	}

	def back() {
		redirect(action: 'index');
	}

	def query() {
		def result = gateService.query(params);
		def allDoorNames = gateService.getAllDoors();

		render(view: "searchResult",
			   model: [
			   	 allDoorNames : allDoorNames,
			     startDatetime: result.startDatetime,
			   	 endDatetime: result.endDatetime,
			     allAffiliationData: processTableData(result.countByAffiliation, allDoorNames, 'affiliation_name'),
			     allCenterData: processTableData(result.countByCenter, allDoorNames, 'center_name'),
			     allUSCData: processTableData(result.countByUSC, allDoorNames, 'usc_name')]);
	}

	def createNameArray(objArray){
		def nameArray = [];
		objArray.each{obj->
			nameArray.push(obj.name);
		}
		return nameArray.sort();
	}



	def processTableData(rawData, allDoorNames, key) {
		Map returnMap = [:];
    	if(rawData.size() == 0){
			returnMap.put("Total", [0] * (allDoorNames.size()+1));
		}else{
	    	rawData.each{ it->
				if(!returnMap.containsKey(it[key])){
					returnMap.put(it[key], [0] * (allDoorNames.size()+1));
				}
				
				allDoorNames.each{ door ->
					if(door.name == it.door_name){
						def pos = door.id;
						(returnMap.get(it[key]))[pos] = it.count;
					}
				}
			}
			returnMap.each{ k, v -> 
	    		v[allDoorNames.size()] = v.sum();
	    	};
		}

		return returnMap;
	}
}