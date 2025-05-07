package com.rafaelsitompul.apimahsiswa;

public class Mahasiswa {
    private String nama;
    private String nim;
    private String jurusan;
    private String foto; // URL foto

    public Mahasiswa(String nama, String nim, String jurusan, String foto) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.foto = foto;
    }

    public String getNama() { return nama; }
    public String getNim() { return nim; }
    public String getJurusan() { return jurusan; }
    public String getFoto() { return foto; }
}