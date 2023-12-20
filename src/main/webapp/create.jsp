<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Create pet</title>
</head>
<body>
<h3>New pet</h3>
<form method="post">
    <label>Kid</label><br>
    <input name="petKid"/><br><br>
    <label>Name</label><br>
    <input name="petName"/><br><br>
    <label>Age</label><br>
    <input name="petAge" type="number" min="0" max="20" /><br><br>
    <label>Color</label><br>
    <input name="petColor"/><br><br>
    <label>Owner</label><br>
    <input name="petOwner"/><br><br>
    <input type="submit" value="Save" />
</form>
</body>
</html>