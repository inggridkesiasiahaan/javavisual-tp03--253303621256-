package com.unpri.charactermanager.manager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CharacterManager {

    private final List<Character> characters = new ArrayList<>();

    public boolean addCharacter(Character character) {
        if (character == null || findByName(character.getName()) != null) {
            return false;
        }

        characters.add(character);
        return true;
    }

    public boolean removeCharacter(String name) {
        Character character = findByName(name);

        if (character == null) {
            return false;
        }

        characters.remove(character);
        return true;
    }

    public Character findByName(String name) {
        if (name == null) {
            return null;
        }

        for (Character character : characters) {
            if (character.getName().equalsIgnoreCase(name)) {
                return character;
            }
        }

        return null;
    }

    public List<Character> findByType(CharacterType type) {
        List<Character> result = new ArrayList<>();

        if (type == null) {
            return result;
        }

        for (Character character : characters) {
            if (character.getType() == type) {
                result.add(character);
            }
        }

        return result;
    }

    public List<Character> getAllCharacters() {
        return Collections.unmodifiableList(
            new ArrayList<>(characters)
        );
    }

    public double getAverageLevel() {
        if (characters.isEmpty()) {
            return 0.0;
        }

        int total = 0;

        for (Character character : characters) {
            total += character.getLevel();
        }

        return (double) total / characters.size();
    }

    public int getCharacterCount() {
        return characters.size();
    }

    public int getTotalCharacters() {
        return characters.size();
    }

    /**
     * Menghitung jumlah karakter berdasarkan tipe tertentu.
     *
     * @param type tipe karakter yang ingin dihitung
     * @return jumlah karakter dengan tipe tersebut
     */
    public int countByType(CharacterType type) {
        if (type == null) {
            return 0;
        }

        return findByType(type).size();
    }

    /**
     * Mencari karakter dengan nilai attack tertinggi.
     *
     * @return karakter dengan attack tertinggi,
     *         atau null jika daftar kosong
     */
    public Character findStrongest() {
        if (characters.isEmpty()) {
            return null;
        }

        Character strongest = characters.get(0);

        for (Character character : characters) {
            if (character.getAttackPower() > strongest.getAttackPower()) {
                strongest = character;
            }
        }

        return strongest;
    }
}