<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <link href="${contextPath}/resources/css/base.css" rel="stylesheet"/>
</head>
<body>
<h4 id="grid1Label">
  Event List
</h4>
<div id="ex1">
<table role="grid" aria-labelledby="grid1Label"   class="data">
  <tbody>
    <tr>
   	<th>Event Name</th>
		<th>Event Date</th>
		<th>No. of Tickets Per Person</th>
		<th>Price Per Ticket</th>
		<th>No. of Ticket sold</th>
		 <th>No. of Users</th>
		 <th>Event Status</th>
    </tr>
    <tr>
        <td tabindex="-1">
            Diwali 2019
        </td>
      <td tabindex="-1">
        01-01-2016
      </td>
      <td tabindex="-1">
        10
      </td>
      <td>
        <a tabindex="-1" href="#">
         20
        </a>
      </td>
      <td tabindex="-1">
        216
      </td>
      <td tabindex="-1">
        66
      </td>
        <td tabindex="-1">
            in Future
        </td>
    </tr>
      </tbody>
</table>
</div>    
</body>


</html>
