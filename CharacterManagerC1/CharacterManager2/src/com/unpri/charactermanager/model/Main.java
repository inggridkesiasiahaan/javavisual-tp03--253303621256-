package com.unpri.charactermanager.model;

public class Main {
    public static void main(String[] args) {
        // 1. Membuat 3 karakter awal (Sesuai Bagian A)
        Character c1 = new Character("Arthas", CharacterType.WARRIOR, 1, 120, 20, 30);
        Character c2 = new Character("Jaina", CharacterType.MAGE, 1, 80, 25, 100);
        Character c3 = new Character("Sylvanas", CharacterType.ARCHER, 1, 90, 22, 40);

        // Menampilkan output 3 karakter awal
        System.out.println("=== DAFTAR KARAKTER AWAL ===");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        // 2. Demo Level Up & Modifikasi Atribut (Sesuai Bagian A)
        System.out.println("\n=== DEMO LEVEL UP (ARTHAS) ===");
        c1.setLevel(2);
        c1.setHitPoints(150);
        c1.setAttackPower(28);
        System.out.println(c1);

        // 3. Demo Ekstensi Fitur Mandiri (Sesuai Bagian B)
        System.out.println("\n=== DEMO EKSTENSI MANDIRI (MAGE BARU) ===");
        Character c4 = new Character();
        c4.setName("Khadgar");
        c4.setType(CharacterType.MAGE);
        c4.setMana(120); // Mengatur atribut mana
        
        System.out.println(c4);
        
        // Memanggil method isAlive() dan mencetak hasilnya ke console
        System.out.println("Status isAlive: " + c4.isAlive());

        // Uji validasi exception jika mana bernilai negatif (Opsional / pembuktian validasi)
        try {
            c4.setMana(-15);
        } catch (IllegalArgumentException e) {
            System.out.println("Validasi Berhasil: " + e.getMessage());
        }
    }
}