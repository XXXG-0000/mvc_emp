<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" info=""%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ site_kor }</title>
<link rel="stylesheet" type="text/css"
	href="${ defaultURL }common/css/main_20240911.css">

<!-- bootstrap CDN -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>

<!-- jQuery CDN 시작 -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js"></script>


<style type="text/css">
/* CSS영역 => CSS 디자인 코드 작성 */
#wrap {
	text-align: center;
}

#step1 {
	text-align: center;
	display: flex;
	justify-content: center;
}

.section {
	height: 600px;
	background-color: #F2F0E5;
	border: 1px solid #D3D2C8;
}

.head {
	background-color: #333;
	color: #F2F0E5;
	text-align: center;
	padding: 5px;
}

.section-body {
	height: 565px;
}

.section-movie {
	width: 284px;
}

.section-date {
	width: 91px;
}

.section-time {
	width: 346px;
}

.movielist {
	overflow: auto;
}

.section-body {
	overflow: auto;
}

ul li:before {
	vertical-align: middle;
}

ul, li {
	margin: 0;
	padding: 0;
}

li {
	list-style-type: none;
}

.day {
	list-style-type: none;
	height: 35px;
}

li:hover {
	cursor: pointer;
}

.movie {
	font-weight: bold;
	text-align: left;
	height: 35px;
	padding: 5px;
}

.year {
	font-size: 10px;
	font-weight: bold;
	display: block;
	margin-top: 15px;
}

.month {
	font-size: 30px;
	font-weight: bold;
	display: block;
	vertical-align: top;
}

.dayweek {
	font-weight: bold;
}

.day {
	font-weight: bold;
}

.day-sat {
	color: #0050B8;
}

.day-sun {
	color: #AD2727;
}

.selected {
	background-color: #333;
	color: #F2F0E5;
}
.theater {
	text-align: left;
	margin-top: 5px;
	margin-left: 5px;
}
.name {
	color: #FF9E37;
	font-weight: bold;
}
.floor {
	font-weight: bold;
}
.seatcount{
	font-weight: bold;
}
.endtime{
    position:absolute; 
    left:0px; 
    top:52px; 
    background: #646FD4; 
    padding: 10px; 
    border-radius:5px; 
    color: #fff; 
    text-align: center; 
    display: none;
}
.endtime:after{
    display: block; 
    content: ''; 
    position: absolute; 
    top: -7px; 
    left:15px; 
    width: 0px; 
    height: 0px; 
    border-top: 8px solid none; 
    border-left: 8psolid transparent; 
    border-right: 8px solid transparent; 
    border-bottom: 8px solid #646FD4;
}
.time:hover + .endtime{display: block;}
</style>
<script type="text/javascript">
	/* JS 영역 => JS 코드 작성 */
	$(function() {
		$(".movie").click(function() {
			$(".movie").attr('class', 'movie');
			$(this).addClass("selected");
		})//click

		$(".day").click(function() {
			$(".day").removeClass("selected");
			$(this).addClass("selected");
		})//click
	}); // ready
</script>
</head>
<body>
	<div id="wrap">
		<form action="" method="post" id="step1">
			<div class="section section-movie">
				<div class="head">영화</div>
				<div class="section-body" style="margin-top: 5px;">
					<div class="movielist">
						<ul>
							<li class="movie">모아나2</li>
							<li class="movie">위키드</li>
							<li class="movie">히든페이스</li>
							<li class="movie">소방관</li>
							<li class="movie">청설</li>
							<li class="movie">1승</li>
						</ul>
					</div>
				</div>
			</div>
			<div class="section section-date">
				<div class="head">날짜</div>
				<div class="section-body">
					<div class="datelist">
						<ul>
							<li class="month">
								<div class="date">
									<span class="year">2024</span> <span class="month">11</span>
								</div>
							</li>
							<li class="day"><span class="dayweek">목</span> <span
								class="day">28</span></li>
							<li class="day"><span class="dayweek">금</span> <span
								class="day">29</span></li>
							<li class="day day-sat"><span class="dayweek">토</span> <span
								class="day">30</span></li>
							<li class="month">
								<div class="date">
									<span class="year">2024</span> <span class="month">12</span>
								</div>
							</li>
							<li class="day day-sun"><span class="dayweek">일</span> <span
								class="day">1</span></li>
							<li class="day"><span class="dayweek">월</span> <span
								class="day">2</span></li>
							<li class="day"><span class="dayweek">화</span> <span
								class="day">3</span></li>
							<li class="day"><span class="dayweek">수</span> <span
								class="day">4</span></li>
							<li class="day"><span class="dayweek">목</span> <span
								class="day">5</span></li>
							<li class="day"><span class="dayweek">금</span> <span
								class="day">6</span></li>
							<li class="day day-sat"><span class="dayweek">토</span> <span
								class="day">7</span></li>
							<li class="day day-sun"><span class="dayweek">일</span> <span
								class="day">8</span></li>
							<li class="day"><span class="dayweek">월</span> <span
								class="day">9</span></li>
							<li class="day"><span class="dayweek">화</span> <span
								class="day">10</span></li>
							<li class="day"><span class="dayweek">수</span> <span
								class="day">11</span></li>
							<li class="day"><span class="dayweek">목</span> <span
								class="day">12</span></li>
							<li class="day"><span class="dayweek">금</span> <span
								class="day">13</span></li>
							<li class="day day-sat"><span class="dayweek">토</span> <span
								class="day">14</span></li>

						</ul>
					</div>
				</div>
			</div>
			<div class="section section-time">
				<div class="head">시간</div>
				<div class="section-body">
					<div class="timelist">
					<div class="theater">
						<span class="title">
							<span class="name">2D(자막)</span>
							<span class="floor">3관 8층</span>
							<span class="seatcount">(총172석)</span>
						</span>
						<ul>
						<li>
						<span class="time">
							<span>09:20</span>
						</span>
						<span class="count"></span>
						<div class="endtime">종료시간 11:10</div>
						</li>
						<li></li>
						</ul>
					</div>
					</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>