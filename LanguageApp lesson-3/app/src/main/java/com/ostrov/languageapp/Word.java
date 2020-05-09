package com.ostrov.languageapp;

/**
 * Contains word and it's translation.
 */
class Word {
    private String mDefaultWord;
    private String mEnglishWord;
    private int mImageResourceId;
    private int mSoundResourceId;

    /** Constant value that represents no image was provided for this word */
    private static final int NO_IMAGE_PROVIDED = -1;

    /**
     * Create a new Word object.
     * @param defaultWord is the word in the Default language
     * @param englishWord is the word in the English language
     * @param soundResourceId is sound resource id
     */
    Word(String defaultWord, String englishWord, int soundResourceId) {
        this.mDefaultWord = defaultWord;
        this.mEnglishWord = englishWord;
        this.mSoundResourceId = soundResourceId;
        this.mImageResourceId = NO_IMAGE_PROVIDED;
    }

    /**
     * Create a new Word object.
     * @param defaultWord is the word in the Default language
     * @param englishWord is the word in the English language
     * @param imageResourceId is image resource id
     * @param soundResourceId is sound resource id
     */
    Word(String defaultWord, String englishWord, int imageResourceId, int soundResourceId) {
        this.mDefaultWord = defaultWord;
        this.mEnglishWord = englishWord;
        this.mImageResourceId = imageResourceId;
        this.mSoundResourceId = soundResourceId;
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
     * Get sound resource id
     */
    public int getSoundResourceId() {
        return mSoundResourceId;
    }

    /**
     * Returns whether or not there is an image for this word.
     */
    boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
