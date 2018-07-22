<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Simple Twitter</title>
	</head>
	<body>
		<div align="center" style="padding-top: 8%;">
			<font color="red">
				<b>${errorMessage}</b>
			</font>
		</div>
		
	    <form name="twitterForm" action="/twitterForm/index" method="post">
	    	<div align="center" style="padding-top: 2%;">
	    		<div>
		        	Account Name 1 : <input type="text" name="accountName1" required="required" />
		        	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		        	Account Name 2 : <input type="text" name="accountName2" required="required" />
		        </div>
		        <div style="padding-top: 2%">
		        	<input type="submit" name="Submit" />&nbsp;&nbsp;&nbsp;
		        	<input type="reset" name="Reset" />
		        </div>
		    </div>
	    </form>
	    <div align="center">
	    	<h3>Mutual Friends List</h3>
	    	<font color="green">
	    		<b>${friendList}</b>
	    	</font>
	    </div>
	</body>
</html>