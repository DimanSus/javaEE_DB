
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Edit pet</title>
</head>
<body>
<h3>Edit pet</h3>
<form method="post">
    <input type="hidden" value="${pet.id}" name="id" />
    <label>Kid</label><br>
    <input name="petKid" value="${pet.petKid}"/><br><br>
    <label>Name</label><br>
    <input name="petName" value="${pet.petName}"/><br><br>
    <label>Age</label><br>
    <input name="petAge" value="${pet.petAge}" type="number" min="0" max="20" /><br><br>
    <label>Color</label><br>
    <input name="petColor" value="${pet.petColor}"/><br><br>
    <label>Owner</label><br>
    <input name="petOwner" value="${pet.petOwner}"/><br><br>
    <input type="submit" value="Send" />
</form>
</body>
</html>
