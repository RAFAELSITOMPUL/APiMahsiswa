<?php
// Konfigurasi database
define('DB_HOST', 'localhost');
define('DB_USER', 'root');
define('DB_PASS', '');
define('DB_NAME', 'dbmobile2_rafaelsitompul');

// Membuat koneksi
$conn = mysqli_connect(DB_HOST, DB_USER, DB_PASS, DB_NAME);

// Periksa koneksi
if (!$conn) {
    die("koneksi ke database gagal: " . mysqli_connect_error());
}
?>