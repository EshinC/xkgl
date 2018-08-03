<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/14
  Time: 15:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>教师管理</h1>
<c:url var="addTeacherUrl" value="/pages/sysadmin/teacher/excelInputTeacher.jsp"/>
<a href="${addTeacherUrl}">Excel导入教师名单</a>
<c:url var="addTeacherUrl" value="/teacherAddController"/>
<a href="${addTeacherUrl}">新建</a>
<br>


<c:url var="find" value="teacherController" />
<form action="${find}" method="post">
     <input type="text" name="string" placeholder="输入工号/学号/姓名查询 "/>
    <input type="submit" value="查询">
</form>
<table border="1">
    <thead>
    <td>序号</td>
    <td>工号</td>
    <td>姓名</td>
    <td colspan="3">操作</td>
    </thead>
    <c:forEach var="teacher" items="${teachers}"
               varStatus="status">
        <tr>
            <td>${status.index+1}</td>
            <td> ${teacher.no}</td>
            <td>${teacher.name}</td>
            <td>
                <c:url var="updateUrl"
                       value="/teacherUpdateController?id=${teacher.id}"/>
                <a href="${updateUrl}">修改</a>
            </td>
            <td>
                <c:url var="deleteUrl"
                       value="/teacherController?action=delete&id=${teacher.id}"/>
                <a href="${deleteUrl}">删除</a>
            </td>
            <td>
                <c:url var="restUrl"
                       value="/teacherUpdateController?action=reset&id=${teacher.id}"/>
                <a href="${restUrl}">重置密码</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
