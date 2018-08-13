<%@ include file="../common/IncludeTop.jsp"%>

<div id="Catalog">

	<h3>User Information</h3>

	<form action="editAccount" method="post">
		<table>
			<tr>
				<td>User ID:</td>
				<td>${sessionScope.successAcount.username}</td>
			</tr>
			<tr>
				<td>New password:</td>
				<td><input type="text"  name="password" ></td>
			</tr>
			<tr>
				<td>Repeat password:</td>
				<td><input type="text" name="repeatedPassword" ></td>
			</tr>
		</table>
		<%@ include file="IncludeAccountFields.jsp"%>
		<input type="submit" name="save" value="Svae Account Information">
	</form>
	<a href="#">My Orders</a>
</div>

<%@ include file="../common/IncludeBottom.jsp"%>
