<md:report>
    <div class="md-application-content">
        <div id="result-gateRecord" class="content scaffold-search" role="main" style="overflow-x:auto;">
        	<a name="top"></a>
        	<fieldset class="buttons">
                <g:link action="back"> 
				   <input type="button" class="btn btn-danger" value="Back" class="button"/> 
				</g:link>
				<a href="#AffiliationSummary">Affiliation Summary</a>
				<a href="#CenterSummary">Center Summary</a>
				<a href="#USCSummary">USC Summary</a>
            </fieldset>

        	<!-- Affiliation Table -->
        	<a name="AffiliationSummary"></a>
        	<h3>Affiliation Summary From ${startDatetime} to ${endDatetime}</h3>
        	<table style="width: 100%" class="list summary" cellspacing="0">
        		<thead>
				    <tr>
				      <th colspan="1" rowspan="1">Affiliation</th>
				      <g:each in="${allDoorNames}" var="door">
				      	<th colspan="1" rowspan="1">${door.name[-11..-1]}</th>
				      </g:each>
				      <th colspan="1" rowspan="1">Total</th>
				    </tr>
			    </thead>
			    <tbody>
			    	<g:each in="${allAffiliationData}" var="row">
			    		<g:if test="${row.key != 'Total'}">
				    		<tr>
				    			<td>${row.key}</td>
				    			<g:each in="${row.value}" var="cell">
				    			<td>${cell}</td>
				    			</g:each> 
				    		</tr>
			    		</g:if>
			    	</g:each>
			    		<tr>
			    			<td>Total</td>
			    			<g:each in="${allAffiliationData['Total'].value}" var="cell">
			    				<td>${cell}</td>
			    			</g:each> 
			    		</tr>
			    </tbody>
        	</table>


        	<!-- Center Table -->
        	<a name="CenterSummary"></a>
    		<h3>Center Summary From ${startDatetime} to ${endDatetime}</h3>
        	<table class="list summary" cellspacing="0">
        		<thead>
				    <tr>
				      <th colspan="1" rowspan="1">Center</th>
				      <g:each in="${allDoorNames}" var="door">
				      	<th colspan="1" rowspan="1">${door.name[-11..-1]}</th>
				      </g:each>
				      <th colspan="1" rowspan="1">Total</th>
				    </tr>
			    </thead>
			    <tbody>
			    	<g:each in="${allCenterData}" var="row">
			    		<g:if test="${row.key != 'Total'}">
				    		<tr>
				    			<td>${row.key}</td>
				    			<g:each in="${row.value}" var="cell">
				    			<td>${cell}</td>
				    			</g:each> 
				    		</tr>
			    		</g:if>
			    	</g:each>
			    		<tr>
			    			<td>Total</td>
			    			<g:each in="${allCenterData['Total'].value}" var="cell">
			    				<td>${cell}</td>
			    			</g:each> 
			    		</tr>
			    </tbody>
        	</table>


        	<!-- USC Table -->
        	<a name="USCSummary"></a>
        	<h3>USC Summary From ${startDatetime} to ${endDatetime}</h3>
        	<table class="list summary" cellspacing="0">
        		<thead>
				    <tr>
				      <th colspan="1" rowspan="1">USC</th>
				      <g:each in="${allDoorNames}" var="door">
				      	<th colspan="1" rowspan="1">${door.name[-11..-1]}</th>
				      </g:each>
				      <th colspan="1" rowspan="1">Total</th>
				    </tr>
			    </thead>
			    <tbody>
			    	<g:each in="${allUSCData}" var="row">
			    		<g:if test="${row.key != 'Total'}">
				    		<tr>
				    			<td>${row.key}</td>
				    			<g:each in="${row.value}" var="cell">
				    			<td>${cell}</td>
				    			</g:each> 
				    		</tr>
			    		</g:if>
			    	</g:each>
			    		<tr>
			    			<td>Total</td>
			    			<g:each in="${allUSCData['Total'].value}" var="cell">
			    				<td>${cell}</td>
			    			</g:each> 
			    		</tr>
			    </tbody>
        	</table>
        	<a href="#Top">Back to Top</a>
        </div>
    </div>
</md:report>