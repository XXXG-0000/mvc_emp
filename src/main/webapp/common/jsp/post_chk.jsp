<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	request.setCharacterEncoding("UTF-8");
	String method = request.getMethod().toUpperCase();
	pageContext.setAttribute("method", method);
%>
<c:if test="${ method eq 'GET' }">
<c:redirect url="http://192.168.10.212/jsp_prj/member/index.jsp"/><!-- 나중에 index.jsp로 변경 -->
</c:if>