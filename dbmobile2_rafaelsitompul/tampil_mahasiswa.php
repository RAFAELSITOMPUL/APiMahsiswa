<?php
// Memuat file konfigurasi
require_once 'config.php';

// Tentukan header untuk JSON
header('Content-Type: application/json');

// Query untuk mengambil data
$sql = "SELECT * FROM tb_mahasiswa";
$result = mysqli_query($conn, $sql);

$response = array();

if ($result) {
   // Memeriksa apakah ada data
   if (mysqli_num_rows($result) > 0) {
       while ($row = mysqli_fetch_assoc($result)) {
           $response[] = $row;
       }
       // Mengembalikan data dalam format JSON
       echo json_encode(array(
           "status"    => "success",
           "mahasiswa" => $response
       ));
   } else {
       echo json_encode(array(
           "status"    => "success",
           "mahasiswa" => [],
           "message"   => "Tidak ada data yang ditemukan."
       ));
   }
} else {
   // Jika query gagal
   echo json_encode(array(
       "status"  => "error",
       "message" => "Query gagal dijalankan: " . mysqli_error($conn)
   ));
}

// Menutup koneksi
mysqli_close($conn);
?>