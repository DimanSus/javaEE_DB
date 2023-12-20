<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Pets</title>
</head>
<body>
<h2>Pets List</h2>
<p><a href='<c:url value="/create" />'>Create new</a></p>
<table>
    <tr><th>Kid</th><th>Name</th><th>Age</th><th>Color</th><th>Owner</th><th></th></tr>
    <c:forEach var="pet" items="${pets}">
        <tr>
            <td>${pet.petKid}</td>
            <td>${pet.petName}</td>
            <td>${pet.petAge}</td>
            <td>${pet.petColor}</td>
            <td>${pet.petOwner}</td>
            <td>
                <a href='<c:url value="/edit?id=${pet.id}" />'>Edit</a> |
                <form method="post" action='<c:url value="/delete" />' style="display:inline;">
                    <input type="hidden" name="id" value="${pet.id}">
                    <input type="submit" value="Delete">
                </form>
            </td></tr>
    </c:forEach>
</table>
</body>
</html>