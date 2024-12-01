<%@page import="kr.co.sist.user.emp.SearchOneEmpService"%>
<%@page import="kr.co.sist.user.emp.MvcEmpDomain"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info="SearchOneEmpAction의 결과를 보여주는 JSP"
    %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ site_kor }</title>
<link rel="stylesheet" type="text/css" href="${ defaultURL }common/css/main_20240911.css">

<!-- bootstrap CDN -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>

<!-- jQuery CDN 시작 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>


<style type="text/css">
/* CSS영역 => CSS 디자인 코드 작성 */

</style>
<script type="text/javascript">
/* JS 영역 => JS 코드 작성 */
$(function(){
	/* 수정: form action: emp_modify.do, cmd: EU001 */
	$("#btnModify").click(function(){
		//$("#empDetailFrm").attr("action", "emp_modify.do");
		document.empDetailFrm.action="emp_modify.do";
		$("#cmd").val("EU001");
		$("#empDetailFrm").submit();
		//alert($("#empDetailFrm").action());
		//alert($("#cmd").val());
	});//click
	
	/* 삭제: form action: emp_remove.do, cmd: ED001 */
	$("#btnDelete").click(function(){
		//$("#empDetailFrm").attr("action", "emp_remove.do"); // attr보다는 document 사용(attr은 한 번 밖에 안 바뀜?)
		document.empDetailFrm.action="emp_remove.do";
		$("#cmd").val("ED001");
		$("#empDetailFrm").submit();
	});//click
}); // ready

</script>
</head>
<%-- <%
	String eno = request.getParameter("empno");
	int empno = Integer.parseInt(eno);
	SearchOneEmpService soes = SearchOneEmpService.getInstance();
	
	MvcEmpDomain med = soes.searchOneEmp(empno);
		
	pageContext.setAttribute("med", med);
	pageContext.setAttribute("empno", empno);
%> --%>
<!-- empData 활용 => request.setAttribute로 불러오니까! -->
<body>
<div id="wrap">
	<h2>사원 정보 조회</h2>
	<div>
	<form id="empDetailFrm" name="empDetailFrm"  method="post">
	<input type="hidden" name="cmd" id="cmd" />
	<table class="table">
		<tr>
			<td>사원번호</td>
			<td><input type="text" value="${ empData.empno }" name="empno" readonly="readonly" /></td>
		</tr>
		<tr>
			<td>사원명</td>
			<td><input type="text" value="${ empData.ename }" name="ename"/></td>
		</tr>
		<tr>
			<td>직무</td>
			<td><input type="text" value="${ empData.job }" name="job"/></td>
		</tr>
		<tr>
			<td>연봉</td>
			<td><input type="text" value="${ empData.sal }" name="sal"/></td>
		</tr>
		<tr>
			<td>보너스</td>
			<td><input type="text" value="${ empData.comm }" name="comm"/></td>
		</tr>
		<tr>
			<td>부서번호</td>
			<td>
			<select name="deptno">
			<c:forEach var="deptno" items="${deptnoList }" >
			<option value="${ deptno }" <c:if test="${ empData.deptno eq deptno }">selected="selected"</c:if>><c:out value="${ deptno }"/>번</option>
			</c:forEach>
			</select>
			</td>
		</tr>
		<tr>
			<td colspan="2" style="text-align: center;">
			<input type="button" value="수정" class="btn btn-sm btn-success" id="btnModify"/> 
			<input type="button" value="삭제" class="btn btn-sm btn-danger" id="btnDelete"/>
			<a href="${ defaultURL }index.do">메인화면</a> 
			</td>
		</tr>
	</table>
	</form>
	</div>
</div>
</body>
</html>