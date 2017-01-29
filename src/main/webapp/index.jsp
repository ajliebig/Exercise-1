

<%@include file="head.jsp"%>
<html>
<body>
<h2>User Display Exercise - Week 1</h2>
<a href = "searchUser">Go to the All User Search</a>

<table>
    <form action="/searchUser" method="GET">
        <tr>
            <td> <label for="search"> Last Name   </label></td>
            <td> <input type="text" id="search" name="search" maxlength="30"  /></td>
        </tr>
        <tr>
            <td> <label for="lastName">Select Employee Last Name</label></td>
            <td> <input type="radio" Id="lastName" name="searchType" value="lastName"/></td>
        </tr>
         <tr>
            <td> <label for="lastName">Off Employee Last Name</label></td>
            <td> <input type="radio" Id="off" name="searchType" value="off" checked="checked"/></td>

        </tr>

        <tr colspan="2">
            <td><input type="submit" name="" value="Enter" /></td>
        </tr>
    </form>
</table>

</body>
</html>