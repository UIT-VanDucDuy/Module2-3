<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Result</title>
</head>
<body>
<h2>Result:</h2>

<c:if test="${not empty error}">
  <p style="color:red;">${error}</p>
</c:if>

<c:if test="${empty error}">
  <p>${firstOperand} ${operator} ${secondOperand} = ${result}</p>
</c:if>

<a href="index.jsp">Quay lại</a>
</body>
</html>
