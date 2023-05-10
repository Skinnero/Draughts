package org.example;

public enum BoardData {
    ALPHABET("ABCDEFGHIJKLMNOPRTSU"),
    NUMBERS("");

    private String value;

    BoardData(){

    }

    BoardData(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
