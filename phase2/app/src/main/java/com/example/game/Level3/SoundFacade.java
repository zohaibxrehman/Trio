package com.example.game.Level3;

import android.media.MediaPlayer;

public class SoundFacade {
    MediaPlayer success;
    MediaPlayer failure;
    MediaPlayer whooshSound;

    public void setFailure(MediaPlayer failure) {
        this.failure = failure;
    }

    public void setWhooshSound(MediaPlayer whooshSound) {
        this.whooshSound = whooshSound;
    }

    public void setSuccess(MediaPlayer success) {
        this.success = success;
    }
}
