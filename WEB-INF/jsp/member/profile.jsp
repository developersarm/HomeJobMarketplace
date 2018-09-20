<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.care.model.Member" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Profile</title>
    <link type="text/css" rel="stylesheet" href="/HomeJobMarketplace/css/bootstrap.css">
    <script src="/HomeJobMarketplace/js/bootstrap.js"></script>
</head>
<body>
    <div class="container mt-5 w-25 mb-5 center-block">
        <div id="wrapper">
            <div id="header">
                <h3 class="text-center mb-3">Profile</h3>
            </div>
        </div>

        <html:form action="member/edit-profile" method="post" readonly="true">

            <c:if test="${not empty requestScope.error}">
                <div class="alert alert-danger">
                  ${requestScope.error}
                </div>
            </c:if>

            <c:if test="${not empty requestScope.msg}">
                <div class="alert alert-success">
                  ${requestScope.msg}
                </div>
            </c:if>

            <div class="form-group">
                <label for="fname">First Name:</label>
                <html:text property="firstName" styleClass="form-control" styleId="fname"/>
                <html:errors property="firstName"/>
            </div>

            <div class="form-group">
                <label for="lname">Last Name:</label>
                <html:text property="lastName" styleClass="form-control" styleId="lname"/>
                <html:errors property="lastName"/>
            </div>

            <div class="form-group">
                <label for="phone">Phone No:</label>
                <input type="number" class="form-control" id="phone" name="phoneNo"
                       value="${profileForm.phoneNo}" readonly="true">
                <html:errors property="phoneNo"/>
            </div>

            <div class="form-group">
                <label for="email">Email Id:</label>
                <html:text property="emailId" styleClass="form-control" styleId="email"/>
                <html:errors property="emailId"/>
            </div>

            <div class="form-group">
                <label for="address">Address:</label>
                <html:text property="address" styleClass="form-control" styleId="address"/>
                <html:errors property="address"/>
            </div>

            <div class="form-group">
                <label for="pincode">Pincode:</label>
                <input type="number" class="form-control" id="pincode" name="pincode"
                       value="${profileForm.pincode}" readonly="true">
                <html:errors property="pincode"/>
            </div>

            <html:hidden property="type"/>
            <html:errors property="type"/>

            <c:choose>

                <c:when test="${profileForm.type == 'SITTER'}">
                    <div class="form-group">
                        <label for="exp">Experience:</label>
                        <input type="number" class="form-control" id="exp" name="experience"
                               value="${profileForm.experience}" readonly="true">
                        <html:errors property="experience"/>
                    </div>
                </c:when>

                <c:when test="${profileForm.type == 'SEEKER'}">

                    <div class="form-group">
                        <label for="totalchildren">Total Children:</label>
                        <input type="number" class="form-control" id="totalchildren" name="totalChildren"
                               value="${profileForm.totalChildren}" readonly="true">
                        <html:errors property="totalChildren"/>
                    </div>

                    <div class="form-group">
                        <label for="sname">Spouse Name:</label>
                        <html:text property="spouseName" styleClass="form-control" styleId="sname"/>
                        <html:errors property="spouseName"/>
                    </div>
                </c:when>

                <c:otherwise>
                    Shouldnt have happened!...(Please dont come up at the time of presentation)
                </c:otherwise>

            </c:choose>

            <div style="text-align:center">
                <html:submit value="Edit Profile" styleClass="btn btn-default"/>
                <html:link action="member/delete-profile.do" styleClass="btn btn-danger" onclick="if(!(confirm('Sure you want to delete this profile?'))) return false">Delete Profile</html:link>
            </div>

        </html:form>

        </br></br>

        <div style="text-align:center">
            <a href="/HomeJobMarketplace/" class="btn btn-primary" role="button" >Home</a>
        </div>

    </div>
</body>
</html>