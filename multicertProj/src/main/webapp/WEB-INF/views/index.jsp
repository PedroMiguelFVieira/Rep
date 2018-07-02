<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Homepage</title>

		<script type="text/javascript" src="resources/js/genericCode.js"></script>
		<script type="text/javascript" src="resources/jquery/jquery-2.1.3.min.js"></script>
		<script type="text/javascript" src="resources/jquery/jquery-ui.min.js"></script>
		<script type="text/javascript" src="resources/jquery/jquery.blockUI.js"></script>
		<script type="text/javascript" src="resources/js/multicert.js"></script>
		<link rel="stylesheet" type="text/css" href="resources/css/a.css">
		<link rel="stylesheet" type="text/css" href="resources/css/bootstrap.min.css">
	</head>
	<body>
		<div class="form">
			<form id="infoForm">
				<label for="orig">Origem</label>
				<input type="text" name="originAddress" class="input" id="orig">
				</br>
				<div> </div>
				</br>
				<label for="dest">Destino</label>
				<input type="text" name="destinationAddress" class="input" id="dest">
				
				<!--input type="text" name="vehicle" class="input"-->
			
				
				<button id="search" class="btn" type="button">Search</button>
			</form>
		</div>
		<div class="content">
		
		</div>
	</body>
</html>