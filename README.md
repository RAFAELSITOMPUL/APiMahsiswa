# Aplikasi Data Mahasiswa Android 📚🎓

Aplikasi **Data Mahasiswa** adalah aplikasi Android sederhana yang memungkinkan pengguna untuk melihat, mencari, dan menambah data mahasiswa menggunakan antarmuka berbasis RecyclerView dan Material Design. Dibuat menggunakan Java dan XML dengan pendekatan `ConstraintLayout`, aplikasi ini cocok untuk latihan pengembangan aplikasi Android dengan fitur UI modern.

---

## ✨ Fitur Utama

- 🎨 Tampilan modern dengan Material Design
- 🔍 Fitur pencarian berdasarkan nama atau NIM mahasiswa
- 📋 Menampilkan daftar mahasiswa dengan `RecyclerView`
- ➕ Tambah data mahasiswa menggunakan FloatingActionButton
- 📱 Navigasi mudah dengan `BottomNavigationView`

---

## 🧱 Struktur Layout XML

File layout utama menggunakan `ConstraintLayout` dan terdiri dari:

1. **Header View**  
   Tampilan atas dengan judul "Data Mahasiswa".

2. **Search Bar**  
   Menggunakan `CardView` dan `EditText` untuk pencarian mahasiswa.

3. **RecyclerView**  
   Menampilkan daftar mahasiswa.

4. **Floating Action Button**  
   Tombol untuk menambahkan data mahasiswa.

5. **Bottom Navigation View**  
   Navigasi bawah untuk pindah halaman atau fitur tambahan (menu didefinisikan di `/res/menu/bottom_nav_menu.xml`).

---

## 🧰 Teknologi dan Library

- Android SDK
- Java
- ConstraintLayout
- RecyclerView
- CardView
- Material Design Components

---

## 📂 Struktur Proyek (Ringkasan)

├── app/
│ ├── src/
│ │ ├── main/
│ │ │ ├── java/com/example/namapaket/
│ │ │ │ ├── MainActivity.java
│ │ │ │ └── ... (class lainnya)
│ │ │ ├── res/
│ │ │ │ ├── layout/activity_main.xml
│ │ │ │ ├── drawable/ic_add.xml
│ │ │ │ ├── menu/bottom_nav_menu.xml
│ │ │ │ └── values/colors.xml

yaml
Copy
Edit

---

## 🚀 Cara Menjalankan

1. Clone repository ini:
   ```bash
   git clone https://github.com/RAFAELSITOMPUL/APiMahsiswa.git
Buka dengan Android Studio

Jalankan menggunakan emulator atau perangkat fisik

🔧 Perluasan Fitur (Opsional)
Tambahkan database lokal (Room atau SQLite)

Fitur edit dan hapus mahasiswa

Autentikasi login

Sinkronisasi data dengan Firebase

🧑‍💻 Kontributor
Nama Anda – Pengembang utama

📃 Lisensi
Proyek ini berlisensi di bawah MIT License.

📸 Cuplikan Layar
Tambahkan tangkapan layar antarmuka aplikasi jika tersedia untuk memperjelas tampilan pengguna.

Terima kasih telah menggunakan aplikasi ini! 🌟



---

Jika kamu ingin, saya juga bisa bantu membuat file `LICENSE`, struktur "bottom_nav_menu.xml", atau bagian Java seperti "MainActivity

![Screenshot (29)](https://github.com/user-attachments/assets/bbedef53-6acf-49dd-99b6-e22b1534fe19)
