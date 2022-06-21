<%--
  Created by IntelliJ IDEA.
  User: stones
  Date: 2022-06-19
  Time: 오전 9:15
  To change this template use File | Settings | File Templates.
--%>

<%--<jsp:useBean id="registerRequest" scope="request" type="javax.xml.stream.util.StreamReaderDelegate"/>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>회원가입</title>
</head>
<body>
<p><strong>${formData.name}님</strong>
    회원 가입을 완료했습니다.</p>
    <p><a href="<c:url value="/hello" />">[첫 화면 이동]</a> </p>
</body>
</html>
