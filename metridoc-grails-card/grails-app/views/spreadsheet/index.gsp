<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
        <title>Metridoc</title>
    </head>
    <body>
      <div class="md-application-content">
          <div id="spreadsheetUpload-cardSwipeEvent" class="content scaffold-search" role="main">
            <h1><g:message code="Upload Spreadsheet"/></h1>

            <g:form  enctype="multipart/form-data" useToken="true">
                <div class="control-group">
                    <div class="controls" id="spreadsheetUploadControls">
                        <input id="spreadsheetUpload" name="spreadsheetUpload" type="file" class="hidden-div" />
                        <button class="btn" type="submit" id="submit-spreadsheet" name="upload" action="upload">
                            <i class="icon-upload-alt"></i> Upload
                        </button>
                    </div>
                </div>
            </g:form>
          </div>

      </div>
    </body>
</html>
