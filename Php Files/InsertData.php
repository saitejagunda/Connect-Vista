<?php
	define("hostname","localhost");
	define("username","id912463_coalstorage");
	define("password","CoalStorage");
	$con = mysqli_connect(hostname,username,password) or die("Connection not successfull");
	if(mysqli_connect_errno()){
		printf("Connect failed: %s\n",mysqli_connect_error());
		exit();
	}
	mysqli_select_db($con,username);
	if(isset($_POST['Username']) && isset($_POST['Password'])){
		$user = $_POST['Username'];
		$pass = $_POST['Password'];
		
		if( $user == '' || $pass == ''){
			echo "Filling all the fields is mandatory";
		}
		else{
			$qry = "INSERT INTO Registration(Username,Password) VALUES('$user','$pass')";
			$res = mysqli_query($con,$qry);
			
			if($result){
				echo "Could not execute query";
				exit;
			}
			else{
				echo "Data Successfully saved";
			}
		}
	}
?>