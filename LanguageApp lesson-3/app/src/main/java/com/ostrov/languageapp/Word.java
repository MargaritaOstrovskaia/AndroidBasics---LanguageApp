package com.ostrov.languageapp;

/**
 * Contains word and it's translation.
 */
class Word {
    private String mDefaultWord;
    private String mEnglishWord;
    private int mImageResourceId;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Word object.
     * @param defaultWord is the word in the Default language
     * @param englishWord is the word in the English language
     */
    Word(String defaultWord, String englishWord) {
        this.mDefaultWord = defaultWord;
        this.mEnglishWord = englishWord;
        this.mImageResourceId = NO_IMAGE_PROVIDED;
    }

    /**
     * Create a new Word object.
     * @param defaultWord is the word in the Default language
     * @param englishWord is the word in the English language
     * @param imageResourceId is image source code
     */
    Word(String defaultWord, String englishWord, int imageResourceId) {
        this.mDefaultWord = defaultWord;
        this.mEnglishWord = englishWord;
        this.mImageResourceId = imageResourceId;
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
     * Get image resource id
     */
    int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
