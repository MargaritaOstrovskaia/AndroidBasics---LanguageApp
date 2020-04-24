package com.ostrov.languageapp;

/**
 * Contains word and it's translation.
 */
class Word {
    private String mDefaultWord;
    private String mEnglishWord;
    private int mImage;

    /**
     * Create a new Word object.
     * @param defaultWord is the word in the Default language
     * @param englishWord is the word in the English language
     * @param img is image source code
     */
    Word(String defaultWord, String englishWord, int img) {
        this.mDefaultWord = defaultWord;
        this.mEnglishWord = englishWord;
        this.mImage = img;
    }

    /**
     * Get string of default word
     */
    String getDefaultWord() {
        return mDefaultWord;
    }

    /**
     * Get string of english word
     */
    String getEnglishWord() {
        return mEnglishWord;
    }

    /**
     * Get image source id
     */
    public int getmImage() {
        return mImage;
    }
}
