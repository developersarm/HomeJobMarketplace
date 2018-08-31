<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Home Job Marketplace</title>
    <link type="text/css" rel="stylesheet" href="css/bootstrap.css">
    <script src="js/bootstrap.js"></script>
</head>
<body>
    <div class="container mt-5 w-50">
        <div id="wrapper">
        		<div id="header">
        			<h2 class="text-center mb-5">Home Job Marketplace</h2>
        		</div>
        	</div>

       	<form action="/HomeJobMarketplace/visitor/welcome" method="get">
       	    <div class="row">
       	        <div class="col align-self-center">
                    <input type="submit" class="btn btn-default" name="type" value="sitter"/>
       	        </div>
       	        <div class="col align-self-center">
                    <input type="submit" class="btn btn-default" name="type" value="seeker"/>
                </div>
       	    </div>
        </form>
    </div>
</body>
</html>