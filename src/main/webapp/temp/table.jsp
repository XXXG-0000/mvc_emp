<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    info=""
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
table { width: 900px; margin: 0 auto; borde: 1px solid #333;}
th, td { border: 1px solid #ddd;
			padding: 12px;
			text-align: left; }
th { background-color: #333; color: #FFF; }
</style>
<script type="text/javascript">
/* JS 영역 => JS 코드 작성 */
$(function(){
	
}); // ready

</script>
</head>
<body>
<div id="wrap">
	<form style="text-align: center;">
	<table>
	<thead>
	<tr>
		<th style="width: 20%;">영화번호</th>
		<th style="width: 80%;">영화명</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<td>00001</td>
		<td>모아나2</td>
	</tr>
	<tr>
		<td>00002</td>
		<td>위키드</td>
	</tr>
	<tr>
		<td>00003</td>
		<td>히든페이스</td>
	</tr>
	<tr>
		<td>00004</td>
		<td>글래디에이터2</td>
	</tr>
	<tr>
		<td>00005</td>
		<td>소방관</td>
	</tr>
	</tbody>
	</table>
	</form>
</div>
</body>
</html>