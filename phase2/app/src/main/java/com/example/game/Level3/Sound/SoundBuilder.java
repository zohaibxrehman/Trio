package com.example.game.Level3.Sound;

import android.media.MediaPlayer;

public class SoundBuilder {
    private SoundFacade soundFacade;
    private MediaPlayer success;
    private MediaPlayer failure;
    private MediaPlayer whooshSound;

    public SoundBuilder(MediaPlayer success, MediaPlayer failure, MediaPlayer whoosh) {
        this.success = success;
        this.failure = failure;
        this.whooshSound = whoosh;
        this.soundFacade = new SoundFacade();
    }

    void buildWhooshSound() {
        soundFacade.setWhooshSound(this.whooshSound);
    }

    void buildFailureSound() {
        soundFacade.setFailure(this.failure);
    }

    void buildSuccessSound() {
        soundFacade.setSuccess(this.success);
    }

    SoundFacade getSoundFacade() {
        return this.soundFacade;
    }
}
