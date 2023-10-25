<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL fn라이브러리</title>
</head>
<body>
	<c:set var="str1" value="No Pain. No Gain."/>
	
	<h3>1.길이구하기</h3>
	${fn:length(str1)}
	<h3>2.특정문자열이 있는지 확인</h3>
	No가 존재하는지 ${fn:contains(str1, 'No')}<br>
	no가 존재하는지 ${fn:contains(str1, 'no')}<br>
	<c:if test="${fn:containsIgnoreCase(str1, 'no')}">
		no라는 문자열 존재한다.(대소문자 구별않함)
	</c:if>
	
	<h3>3.특정문자열로 시작하는지 확인하는법</h3>
	No로 시작하는가? ${fn:startsWith(str1, "No")}
	<h3>4.특정문자열로 끝나는지 확인하는법</h3>
	n로 시작하는가? ${fn:endsWith(str1, "n")}<br>
	.로 시작하는가? ${fn:endsWith(str1, ".")}<br>
	Gain.로 시작하는가? ${fn:endsWith(str1, "Gain.")}<br>
	<h3>5.문자열 치환</h3>
	<c:set var="str2" value="나는 치킨을 좋아한다."/>
	${str2}<br>
	<%--매우 많이 사용하니까 중요하므로 암기 --%>
	${fn:replace(str2, "치킨", "라면")}
	<h3>6.구분자로 짤라서 배열만들기</h3>
	${fn:split(str1, '.')[0]}<br>
	${fn:split(str1, '.')[1]}<br>
	<h3>7.문자열추출(시작인덱스에서 종료 인덱스까지 추출)</h3>
	<%--str1에서 pain만 추출(3 ~ 6) --%>
	${fn:substring(str1, 3, 7)}
	<h3>8.모두 소문자로 변경</h3>
	${fn:toLowerCase(str1)}
	<h3>9.모두 대문자로 변경</h3>
	${fn:toUpperCase(str1)}
	<h3>10.앞뒤공백제거</h3>
	<c:set var="str3" value="   h    e  ll    o   "/>
	<pre>${str3}</pre>
	<pre>${fn:trim(str3)}</pre>
</body>
</html>