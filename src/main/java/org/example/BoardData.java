package org.example;

public enum BoardData {
    ALPHABET("ABCDEFGHIJKLMNOPRTSU"),
    NUMBERS("1\uFE0F⃣ 2\uFE0F⃣ 3\uFE0F⃣ 4\uFE0F⃣ 5\uFE0F⃣ 6\uFE0F⃣ 7\uFE0F⃣ 8\uFE0F⃣ 9\uFE0F⃣ \uD83D\uDD1F"+
            " 1\uFE0F⃣ 2\uFE0F⃣ 3\uFE0F⃣ 4\uFE0F⃣ 5\uFE0F⃣ 6\uFE0F⃣ 7\uFE0F⃣ 8\uFE0F⃣ 9\uFE0F⃣ \uD83D\uDD1F");

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
