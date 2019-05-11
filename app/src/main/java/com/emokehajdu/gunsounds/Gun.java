package com.emokehajdu.gunsounds;

import android.content.Context;
import android.media.MediaPlayer;

public class Gun {
    private String name;
    private int imageResourceID;
    private int soundResourceID;
    private MediaPlayer mediaPlayer;
    private static Gun gunPlaying = null;

    public Gun(String name, int imageResourceID, int soundResourceID) {
        this.name = name;
        this.imageResourceID = imageResourceID;
        this.soundResourceID = soundResourceID;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public int getSoundResourceID() {
        return soundResourceID;
    }

    public boolean isPlaying() {
        return mediaPlayer != null && mediaPlayer.isPlaying();
    }

    public void clicked(Context context) {
        MediaPlayer mediaPlayer = getMediaPlayer(context);
        if(mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
            resetMediaPlayer();
            gunPlaying = null;

        }
        else {
            mediaPlayer.setLooping(true);
            mediaPlayer.start();
            if(gunPlaying != null) {
                gunPlaying.clicked(context);
            }
            gunPlaying = this;
        }
    }

    public MediaPlayer getMediaPlayer(Context context) {
        if(mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(context, getSoundResourceID());
        }

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                if(mediaPlayer != null) {
                    mediaPlayer.release();
                }
            }
        });

        return mediaPlayer;
    }

    public void resetMediaPlayer() {
        mediaPlayer = null;
    }
}
