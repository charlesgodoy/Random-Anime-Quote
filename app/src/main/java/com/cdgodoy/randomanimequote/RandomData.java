package com.cdgodoy.randomanimequote;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RandomData {
    @SerializedName("quote")
    @Expose
    private String quote;
    @SerializedName("character")
    @Expose
    private String character;
    @SerializedName("anime")
    @Expose
    private String anime;

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getAnime() {
        return anime;
    }

    public void setAnime(String anime) {
        this.anime = anime;
    }

}
