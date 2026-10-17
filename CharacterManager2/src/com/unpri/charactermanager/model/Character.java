
package com.unpri.charactermanager.model;

import java.util.Objects;

public class Character {

    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    // Menghitung jumlah objek Character yang berhasil dibuat
    private static int totalCharacterCreated = 0;

    // Constructor default
    public Character() {
        this.name = "Unknown";
        this.type = CharacterType.WARRIOR;
        this.level = 1;
        this.hitPoints = 100;
        this.attackPower = 15;
        this.mana = 50;

        totalCharacterCreated++;
    }

    // Constructor berparameter
    public Character(String name, CharacterType type, int level,
                     int hitPoints, int attackPower, int mana) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        setMana(mana);

        totalCharacterCreated++;
    }

    // Getter untuk jumlah objek yang telah dibuat
    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    // Getter dan setter nama
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter dan setter tipe karakter
    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    // Getter dan setter level
    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    // Getter dan setter hit points
    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    // Getter dan setter attack power
    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    // Getter dan setter mana dengan validasi
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                "Mana tidak boleh bernilai negatif!"
            );
        }

        this.mana = mana;
    }

    // Memeriksa apakah karakter masih hidup
    public boolean isAlive() {
        return this.hitPoints > 0;
    }

    // Membandingkan objek Character berdasarkan nama
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Character other = (Character) obj;
        return Objects.equals(this.name, other.name);
    }

    // Menjaga konsistensi dengan equals()
    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    // Menampilkan informasi karakter
    @Override
    public String toString() {
        return "Character [Name=" + name
                + ", Type=" + type
                + ", Level=" + level
                + ", HP=" + hitPoints
                + ", Attack=" + attackPower
                + ", Mana=" + mana
                + ", Alive=" + isAlive() + "]";
    }
}
