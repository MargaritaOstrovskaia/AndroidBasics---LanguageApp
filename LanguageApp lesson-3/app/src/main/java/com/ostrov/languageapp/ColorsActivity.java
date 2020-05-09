package com.ostrov.languageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    /** Handles playback of all the sound files */
    private MediaPlayer mPlayer;

    /** Handles audio focus when playing a sound file */
    AudioManager mAudioManager;

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focus) {
            switch (focus) {
                case AudioManager.AUDIOFOCUS_GAIN:
                    // We have regained focus and can resume playback.
                    mPlayer.start();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS:
                    // Lost audio focus. Stop playback and clean up resources.
                    releaseMediaPlayer();
                    break;
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                    // We've lost audio focus for a short amount of time.
                case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                    // Our app is allowed to continue playing sound but at a lower volume.
                    mPlayer.pause();
                    mPlayer.seekTo(0);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create and setup the {@link AudioManager} to request audio focus
        mAudioManager = (AudioManager) this.getSystemService(AUDIO_SERVICE);

        // Create a list of words
        final ArrayList<Word> colors = new ArrayList<>();
        colors.add(new Word("weṭeṭṭi", "red", R.drawable.color_red, R.raw.color_red));
        colors.add(new Word("chokokki", "green", R.drawable.color_green, R.raw.color_green));
        colors.add(new Word("ṭakaakki", "brown", R.drawable.color_brown, R.raw.color_brown));
        colors.add(new Word("ṭopoppi", "gray", R.drawable.color_gray, R.raw.color_gray));
        colors.add(new Word("kululli", "black", R.drawable.color_black, R.raw.color_black));
        colors.add(new Word("kelelli", "white", R.drawable.color_white, R.raw.color_white));
        colors.add(new Word("chiwiiṭә", "mustard yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));
        colors.add(new Word("ṭopiisә", "dusty yellow", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        final WordAdapter adapter = new WordAdapter(this, colors, getColor(R.color.category_colors));

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = findViewById(R.id.root);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Release the media player if it currently exists because we are about to
                // play a different sound file
                releaseMediaPlayer();

                // Get the {@link Word} object at the given position the user clicked on
                Word word = colors.get(position);

                // Request audio focus so in order to play the audio file.
                // The app needs to play a short audio file,
                // so we will request audio focus with a short amount of time.
                mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC,
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                // Create and setup the {@link MediaPlayer} for the audio resource associated
                // with the current word
                mPlayer = MediaPlayer.create(ColorsActivity.this, word.getSoundResourceId());

                // Start the audio file
                mPlayer.start();

                // Setup a listener on the media player, so that we can stop and release the
                // media player once the sound has finished playing.
                mPlayer.setOnCompletionListener(mCompletionListener);
            }
        });
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        // When the activity is stopped, release the media player resources
        // because we won't be playing any more sounds.
        releaseMediaPlayer();
    }
}
