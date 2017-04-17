<?php

class DBOperations{

	 private $host = '127.0.0.1';
	 private $user = 'vrn001';
	 private $db = 'myDb';
	 private $pass = '';
	 private $conn;

public function __construct() {

	$this -> conn = new PDO("mysql:host=".$this -> host.";dbname=".$this -> db, $this -> user, $this -> pass);

}


 public function insertData($name,$email,$password){

 	
   $encrypted_password = password_hash($password, PASSWORD_DEFAULT);

 	$sql = 'INSERT INTO users SET name =:name,
    email =:email,encrypted_password =:encrypted_password,created_at = NOW()';

 	$query = $this ->conn ->prepare($sql);
 	$query->execute(array(':name' => $name, ':email' => $email,
     ':encrypted_password' => $encrypted_password));

    if ($query) {
        
        return true;

    } else {

        return false;

    }
 }


 public function checkLogin($email, $password) {

    $sql = 'SELECT * FROM users WHERE email = :email';
    $query = $this -> conn -> prepare($sql);
    $query -> execute(array(':email' => $email));
    $data = $query -> fetchObject();
    $db_encrypted_password = $data -> encrypted_password;

    if ($this -> verifyHash($password,$db_encrypted_password) ) {


        $user["name"] = $data -> name;
        $user["email"] = $data -> email;
        $user["id"] = $data -> id;
        return $user;

    } else {

        return false;
    }

 }


 public function changePassword($email, $password){


   
    $encrypted_password = password_hash($password, PASSWORD_DEFAULT);
   
    $sql = 'UPDATE users SET encrypted_password = :encrypted_password WHERE email = :email';
    $query = $this -> conn -> prepare($sql);
    $query -> execute(array(':email' => $email, ':encrypted_password' => $encrypted_password));

    if ($query) {
        
        return true;

    } else {

        return false;

    }

 }

 public function checkUserExist($email){

    $sql = 'SELECT COUNT(*) from users WHERE email =:email';
    $query = $this -> conn -> prepare($sql);
    $query -> execute(array('email' => $email));

    if($query){

        $row_count = $query -> fetchColumn();

        if ($row_count == 0){

            return false;

        } else {

            return true;

        }
    } else {

        return false;
    }
 }

 public function getHash($password) {

     $salt = sha1(rand());
     $salt = substr($salt, 0, 10);
     $encrypted = password_hash($password.$salt, PASSWORD_DEFAULT);
     $hash = array("salt" => $salt, "encrypted" => $encrypted);

     return $hash;

}



public function verifyHash($password, $hash) {

    return password_verify ($password, $hash);
}
}