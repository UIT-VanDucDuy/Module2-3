<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Simple Calculator</title>
</head>
<body>
<h1>Simple Calculator</h1>
<form action="calculate" method="post">
    <fieldset>
        <legend>Calculator</legend>
        First operand: <input type="number" step="any" name="firstOperand" required><br><br>
        Operator:
        <select name="operator">
            <option value="+">Addition</option>
            <option value="-">Subtraction</option>
            <option value="*">Multiplication</option>
            <option value="/">Division</option>
        </select><br><br>
        Second operand: <input type="number" step="any" name="secondOperand" required><br><br>
        <input type="submit" value="Calculate">
    </fieldset>
</form>
</body>
</html>
