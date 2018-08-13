<h3>Account Information</h3>

<table>
	<tr>
		<td>Username:</td>
		<td><input type="text" name="username" value="${sessionScope.successAcount.username}"></td>
	</tr>
	<tr>
		<td>First name:</td>
		<td><input type="text" name="firstName" value="${sessionScope.successAcount.firstName}"></td>
	</tr>
	<tr>
		<td>Last name:</td>
		<td><input type="text" name="lastName" size="40" value="${sessionScope.successAcount.lastName}"></td>
	</tr>
	<tr>
		<td>Email:</td>
		<td><input type="text" name="email" value="${sessionScope.successAcount.email}"></td>
	</tr>
	<tr>
		<td>Phone:</td>
		<td><input type="text" name="phone" value="${sessionScope.successAcount.phone}"></td>
	</tr>
	<tr>
		<td>Address 1:</td>
		<td><input type="text" name="address1" size="40" value="${sessionScope.successAcount.address1}"></td>
	</tr>
	<tr>
		<td>Address 2:</td>
		<td><input type="text" name="address2" size="40" value="${sessionScope.successAcount.address2}"></td>
	</tr>
	<tr>
		<td>City:</td>
		<td><input type="text" name="city" value="${sessionScope.successAcount.city}"></td>
	</tr>
	<tr>
		<td>State:</td>
		<td><input type="text" name="state" size="4" value="${sessionScope.successAcount.state}"></td>
	</tr>
	<tr>
		<td>Zip:</td>
		<td><input type="text" name="zip" size="10" value="${sessionScope.successAcount.zip}"></td>
	</tr>
	<tr>
		<td>Country:</td>
		<td><input type="text" name="country" size="15" value="${sessionScope.successAcount.country}"></td>
	</tr>
</table>

<h3>Profile Information</h3>

<table>
	<tr>
		<td>Language Preference:</td>
		<td>
			<select name="languagePreference" id="languagePreference" >
				<option value="english">English</option><option value="japanese">Japanese</option>
			</select>
			<script tpye="text/javascript">
                document.getElementById("languagePreference").value = "${sessionScope.successAcount.languagePreference}";
			</script>
		</td>

		<!--<td><input type="text" name="languagePreference" value="${sessionScope.successAcount.languagePreference}"></td>-->
	</tr>
	<tr>
		<td>Favourite Category:</td>
		<td>
			<select name="favouriteCategoryId" id="favouriteCategoryId" >
				<option value="FISH">FISH</option>
				<option value="DOGS">DOGS</option>
				<option value="REPTILES">REPTILES</option>
				<option value="CATS">CATS</option>
				<option value="BIRDS">BIRDS</option>
			</select>
			<script tpye="text/javascript">
                document.getElementById("favouriteCategoryId").value = "${sessionScope.successAcount.favouriteCategoryId}";
			</script>
		</td>


		<!--<td><input type="text" name="favouriteCategoryId" value="${sessionScope.successAcount.favouriteCategoryId}"></td>-->
	</tr>
	<tr>
		<td>Enable MyList</td>
		<!--<td><input type="checkbox" name="listOption" value="1" checked="${sessionScope.successAcount.listOption == true ? "checked":null}"></td>-->
		<td>
			<c:if test="${sessionScope.successAcount.listOption == true}">
				<input type="checkbox" name="listOption" value="1" checked="checked">
			</c:if>
			<c:if test="${sessionScope.successAcount.listOption == false}">
				<input type="checkbox" name="listOption" value="1">
			</c:if>
		</td>

	</tr>
	<tr>
		<td>Enable MyBanner</td>
		<td>
			<c:if test="${sessionScope.successAcount.bannerOption == true}">
				<input type="checkbox" name="bannerOption" value="1" checked="checked">
			</c:if>
			<c:if test="${sessionScope.successAcount.bannerOption == false}">
				<input type="checkbox" name="bannerOption" value="1">
			</c:if>
		</td>
		<!--<td><input type="checkbox" name="bannerOption" value="1" checked="${sessionScope.successAcount.bannerOption == true ? "checked":null}"></td>-->
	</tr>

</table>

