package com.example.game.Level3.Sound;

import android.media.MediaPlayer;

public class SoundBuilder {
    private SoundFacade soundFacade;
    private MediaPlayer success;
    private MediaPlayer failure;
    private MediaPlayer whooshSound;
    private MediaPlayer boost;

    public SoundBuilder(MediaPlayer success, MediaPlayer failure, MediaPlayer whoosh, MediaPlayer boost) {
        this.success = success;
        this.failure = failure;
        this.whooshSound = whoosh;
        this.boost = boost;
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

    void buildBoostSound(){
        soundFacade.setBoostSound(this.boost);
    }

    SoundFacade getSoundFacade() {
        return this.soundFacade;
    }
}
