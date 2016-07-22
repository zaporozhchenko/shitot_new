<%@ page import="org.springframework.util.StringUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2>Doctors</h2>
<a class="btn btn-default" href="doctors/create">New doctor</a>
<hr>
<table border="1" cellpadding="8" cellspacing="0">
    <thead>
    <tr>
        <th>Name</th>
        <th>Specialties</th>
        <th>Tel number</th>
        <th></th>
        <th></th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${doctorList}" var="doctor">
        <jsp:useBean id="doctor" class="com.shitot.model.Doctor"/>
        <tr>
            <td>${doctor.name}</td>
            <td><%=StringUtils.collectionToCommaDelimitedString(doctor.getSpecialties())%></td>
            <td>${doctor.telNumber}</td>
            <td><a class="btn btn-success btn-xs" href="doctors/update?id=${doctor.id}">Update</a></td>
            <td><a class="btn btn-danger btn-xs" href="doctors/delete?id=${doctor.id}">Delete</a></td>
            <td><a href="viewDoctorSchedule?doctorId=${doctor.id}">View Schedule</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
