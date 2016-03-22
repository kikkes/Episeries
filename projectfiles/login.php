<?php
	$conn=mysqli_connect("localhost","root","","episeries");
	
	$email = $_POST['email'];
	$password = $_POST['password'];
	
	$query = mysqli_prepare($conn, "SELECT * FROM users WHERE email = ? AND password = ?");	
	mysqli_stmt_bind_param($query,"ss", $email, $password);
	mysqli_stmt_execute($query);
	mysqli_stmt_store_result($query);
	mysqli_stmt_bind_result($query,$email,$password);
	
	$user = array();
	while(mysqli_stmt_fetch($query)) {
		$user[email] = $email;
		$user[password] = $password;
	}
	
	echo json_encode($user);
	
	mysqli_stmt_close($query);
	
	mysqli_close($conn);
	
	?>