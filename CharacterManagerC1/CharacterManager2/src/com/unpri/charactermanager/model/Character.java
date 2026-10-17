package com.unpri.charactermanager.model;

public class Character {
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana; // Atribut baru dari ekstensi mandiri

    // Constructor 1: Default
    public Character() {
        this.name = "Unknown";
        this.type = CharacterType.WARRIOR;
        this.level = 1;
        this.hitPoints = 100;
        this.attackPower = 15;
        this.mana = 50;
    }

    // Constructor 2: Berparameter lengkap
    public Character(String name, CharacterType type, int level, int hitPoints, int attackPower, int mana) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        setMana(mana); // Menggunakan setter agar tervalidasi
    }

    // Getter dan Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    // Getter & Setter khusus untuk Mana dengan validasi IllegalArgumentException
    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("Mana tidak boleh bernilai negatif!");
        }
        this.mana = mana;
    }

    // Method isAlive untuk mengecek apakah karakter masih hidup
    public boolean isAlive() {
        return this.hitPoints > 0;
    }

    // Method toString yang diperbarui dengan mana
    @Override
    public String toString() {
        return "Character [Name=" + name + ", Type=" + type + ", Level=" + level + 
               ", HP=" + hitPoints + ", Attack=" + attackPower + ", Mana=" + mana + 
               ", Alive=" + isAlive() + "]";
    }
}