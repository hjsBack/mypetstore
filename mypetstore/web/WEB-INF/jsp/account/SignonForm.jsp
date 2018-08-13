<%@ include file="../common/IncludeTop.jsp"%>

<div id="Content">

	<script>
        function reloadImage() {
            //document.getElementById("btn").disabled=true;
            document.getElementById("imgservlet").src = 'validation';
        }
	</script>


	<div id="Catalog">
		<form action="login" method="post">
			<p>Please enter your username and password.</p>
			</p>
			<table>
				<tr>
					<td>Username:</td>
					<td><input type="text" name="username" /></td>
				</tr>
				<tr>
					<td>Password:</td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td>
						<div align="center">
							<font color="red"> ${sessionScope.LoginMsg} </font>
						</div>
					</td>
				</tr>
			</table>
				<!--  Validation Code:<input type="text" name="validationCode"/>
        <img src="validation" id="imgservlet" onclick="reloadImage()"/>
        -->
				<!--  <input type="button" value="changeImage" onclick="reloadImage()" id="btn">-->
			<input type="submit" name="signon" value="Login" />
		</form>

		Need a user name and password?
		<a href="viewNewAccount">RegisterNow!</a>

	</div>

</div>

<%@ include file="../common/IncludeBottom.jsp"%>

