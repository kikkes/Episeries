<?php
	$conn=mysqli_connect("localhost","root","","episeries");
	
	$email = $_POST['email'];
	$password = $_POST['password'];
	
	$query = mysqli_prepare($conn, "INSERT INTO users(email, password) VALUES(?,?)");
	mysqli_stmt_bind_param($query,"ss", $email,$password);
	
	
	mysqli_close($conn);
	
	?>
	