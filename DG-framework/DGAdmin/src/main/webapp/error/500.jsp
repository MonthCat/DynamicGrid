<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    response.setStatus(200); // 200 = HttpServletResponse.SC_OK
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>500</title>
</head>
<body>
<% Exception ex = (Exception) request.getAttribute("Exception");%>
<H2>Exception:<%=ex.getMessage()%>
</H2>
</body>
</html>