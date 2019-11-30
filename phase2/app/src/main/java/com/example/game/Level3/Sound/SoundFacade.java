package com.example.game.Level3.Sound;

import android.media.MediaPlayer;

public class SoundFacade {
    public MediaPlayer success;
    public MediaPlayer failure;
    public MediaPlayer whooshSound;

    void setFailure(MediaPlayer failure) {
        this.failure = failure;
    }

    void setWhooshSound(MediaPlayer whooshSound) {
        this.whooshSound = whooshSound;
    }

    void setSuccess(MediaPlayer success) {
        this.success = success;
    }
}
