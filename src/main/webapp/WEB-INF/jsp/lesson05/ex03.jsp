<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL fmt 라이브러리</title>
</head>
<body>
	<c:set var="number" value="12345678" />
	<h1>숫자 출력</h1>
	<%--1.number --%>
	<fmt:formatNumber value="${number}" />
	<h1>숫자 type</h1>
	숫자: <fmt:formatNumber value="${number}" type="number"/><%-- 기본적인 속성 --%>
	<br>
	숫자 3자리 마다 쉽표 제거: <fmt:formatNumber value="${number}" type="number" groupingUsed="false"/>
	<br>
	<%--2.percent(퍼센트) --%>
	100%:<fmt:formatNumber type="percent" value="1"/>
	<br>
	40% : <fmt:formatNumber type="percent" value="0.4"/>
	<br>
	<%--3.currency(통화) --%>
	통화(원): <fmt:formatNumber type="currency" value="${number}"/>
	<br>
	<%--currency symbol이라는 속성 -> 원화를 달러 표시로 바꿔진다 --%>
	통화(달러): <fmt:formatNumber type="currency" value="${number}" currencySymbol="$"/>
	<br>
	<h1>Pattern</h1>
	3.14: <fmt:formatNumber value="3.14"/>
	<br>
	3.14(0.0000):<fmt:formatNumber pattern="0.0000" value="3.14"/>
	<br>
	3.14(#.####):<fmt:formatNumber pattern="#.####" value="3.14"/>
	<br>
	<%--소숫점을 내가 원하는 자리 까지 잘라 내주는 기능 --%>
	3.141592(#.####):<fmt:formatNumber pattern="#.####" value="3.141592"/>
	
	
	<hr>
	<h1>Date객체를 String으로 출력(fmt:formatDate)</h1>
	Date:${today}<br>
	<fmt:formatDate value="${today}" pattern="yyyy년 M월 d일 HH시 mm분 ss 초" var="pattern1"/>
	pattern1: ${pattern1}<br>
	
	<fmt:formatDate value="${today}" pattern="yyyy/MM/dd/HH:mm:ss" var="pattern2" />
	pattern2:${pattern2}<br>
	<h1>String을 Date객체로 변환(fmt:parseDate)</h1>
	<fmt:parseDate value="${pattern2}" pattern="yyyy/MM/dd/HH:mm:ss"/>
</body>
</html>