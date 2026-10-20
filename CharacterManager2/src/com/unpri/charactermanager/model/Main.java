package com.unpri.charactermanager.model;

import com.unpri.charactermanager.manager.CharacterManager;
import view.MainWindow;   // <-- Import package view untuk GUI
import javax.swing.*;      // <-- Import library Swing
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // 1. Membuat tiga karakter awal
        Character c1 = new Character(
            "Arthas", CharacterType.WARRIOR, 1, 120, 20, 30
        );

        Character c2 = new Character(
            "Jaina", CharacterType.MAGE, 1, 80, 25, 100
        );

        Character c3 = new Character(
            "Sylvanas", CharacterType.ARCHER, 1, 90, 22, 40
        );

        System.out.println("=== DAFTAR KARAKTER AWAL ===");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);

        // 2. Demo level up dan modifikasi atribut
        System.out.println("\n=== DEMO LEVEL UP (ARTHAS) ===");

        c1.setLevel(2);
        c1.setHitPoints(150);
        c1.setAttackPower(28);

        System.out.println(c1);

        // 3. Demo ekstensi fitur mandiri
        System.out.println("\n=== DEMO EKSTENSI MANDIRI ===");

        Character c4 = new Character();
        c4.setName("Khadgar");
        c4.setType(CharacterType.MAGE);
        c4.setMana(120);

        System.out.println(c4);
        System.out.println("Status isAlive: " + c4.isAlive());

        try {
            c4.setMana(-15);
        } catch (IllegalArgumentException e) {
            System.out.println("Validasi berhasil: " + e.getMessage());
        }

        // 4. Pengujian CharacterManager
        System.out.println("\n=== CHARACTER MANAGER ===");

        CharacterManager manager = new CharacterManager();

        System.out.println("Tambah Arthas: " + manager.addCharacter(c1));
        System.out.println("Tambah Jaina: " + manager.addCharacter(c2));
        System.out.println("Tambah Sylvanas: " + manager.addCharacter(c3));
        System.out.println("Tambah Khadgar: " + manager.addCharacter(c4));

        // Tambah karakter ke-5 agar memenuhi minimal 5 data untuk GUI
        Character c5 = new Character(
            "Gandalf", CharacterType.MAGE, 5, 150, 35, 200
        );
        System.out.println("Tambah Gandalf: " + manager.addCharacter(c5));

        Character duplicate = new Character(
            "Arthas", CharacterType.WARRIOR, 2, 150, 28, 30
        );

        System.out.println(
            "Tambah nama duplikat Arthas: "
            + manager.addCharacter(duplicate)
        );

        System.out.println("Cari Jaina: " + manager.findByName("Jaina"));
        System.out.println(
            "Cari nama dengan huruf kecil: "
            + manager.findByName("arthas")
        );

        System.out.println(
            "Total karakter: " + manager.getTotalCharacters()
        );

        System.out.println(
            "Rata-rata level: " + manager.getAverageLevel()
        );

        // 5. Pengujian findByType dan countByType
        System.out.println("\n=== KARAKTER BERTIPE WARRIOR ===");

        for (Character character :
                manager.findByType(CharacterType.WARRIOR)) {
            System.out.println(character);
        }

        System.out.println(
            "Jumlah WARRIOR: "
            + manager.countByType(CharacterType.WARRIOR)
        );

        System.out.println(
            "Jumlah MAGE: "
            + manager.countByType(CharacterType.MAGE)
        );

        // 6. Pengujian getAllCharacters
        System.out.println("\n=== UJI GET ALL CHARACTERS ===");

        List<Character> salinan = manager.getAllCharacters();

        System.out.println("Jumlah dalam salinan: " + salinan.size());

        // 7. Pengujian removeCharacter
        System.out.println("\n=== UJI REMOVE ===");

        System.out.println(
            "Hapus Jaina: " + manager.removeCharacter("Jaina")
        );

        System.out.println(
            "Total setelah hapus: " + manager.getTotalCharacters()
        );

        // 8. Pengujian equals
        System.out.println("\n=== UJI EQUALS ===");

        Character a = new Character(
            "Aragorn", CharacterType.WARRIOR, 1, 120, 20, 30
        );

        Character b = new Character(
            "aragorn", CharacterType.MAGE, 1, 80, 25, 100
        );

        System.out.println("a.equals(b): " + a.equals(b));
        System.out.println("a == b: " + (a == b));

        // 9. Pengujian fitur findStrongest
        System.out.println("\n=== FITUR FIND STRONGEST ===");

        Character strongest = manager.findStrongest();

        if (strongest != null) {
            System.out.println(
                "Karakter terkuat: " + strongest.getName()
            );
            System.out.println(
                "Attack tertinggi: " + strongest.getAttackPower()
            );
        } else {
            System.out.println("Belum ada karakter.");
        }

        System.out.println("\n=== PROGRAM CONSOLE SELESAI, MEMBUKA JENDELA GUI ===");

        // =========================================================
        // BAGIAN UTAMA TP8: Membuka Jendela GUI via Event Dispatch Thread
        // =========================================================
        SwingUtilities.invokeLater(() -> {
            MainWindow window = new MainWindow(manager.getAllCharacters());
            window.setVisible(true);
        });
    }
}