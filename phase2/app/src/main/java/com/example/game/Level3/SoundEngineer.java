package com.example.game.Level3;

public class SoundEngineer {
    private SoundBuilder soundBuilder;
    public SoundEngineer(SoundBuilder soundBuilder) {
        this.soundBuilder = soundBuilder;
    }

    public void constructSound() {
        soundBuilder.buildSuccessSound();
        soundBuilder.buildFailureSound();
        soundBuilder.buildWhooshSound();
    }

    public SoundFacade getSoundFacade() {
        return this.soundBuilder.getSoundFacade();
    }
}
