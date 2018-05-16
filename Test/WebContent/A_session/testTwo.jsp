<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<strong>
		request:<%= request.getAttribute("reqName") %>
		session:<%= session.getAttribute("sessionName") %>
		<!--结果是： request:null session:session -->
	</strong>