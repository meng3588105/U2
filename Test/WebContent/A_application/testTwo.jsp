<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<strong>
		session:<%=session.getAttribute("sesName")%><br/>
		application:<%= application.getAttribute("appName") %>
	</strong>