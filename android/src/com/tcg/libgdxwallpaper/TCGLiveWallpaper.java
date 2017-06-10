package com.tcg.libgdxwallpaper;

import android.util.Log;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.badlogic.gdx.backends.android.AndroidLiveWallpaperService;
import com.badlogic.gdx.backends.android.AndroidWallpaperListener;

/**
 * Created by JoseR on 6/9/2017.
 */
public class TCGLiveWallpaper extends AndroidLiveWallpaperService {

    @Override
    public void onCreateApplication() {
        super.onCreateApplication();

        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();

        initialize(new Game(), config);

    }

    public static class TCGLiveWallpaperListener implements AndroidWallpaperListener {
        @Override
        public void offsetChange(float xOffset, float yOffset, float xOffsetStep, float yOffsetStep, int xPixelOffset, int yPixelOffset) {
            Log.i("LiveWallpaper test", "offsetChange(xOffset:"+xOffset+" yOffset:"+yOffset+" xOffsetSteep:"+xOffsetStep+" yOffsetStep:"+yOffsetStep+" xPixelOffset:"+xPixelOffset+" yPixelOffset:"+yPixelOffset+")");
        }

        @Override
        public void previewStateChange(boolean isPreview) {
            Log.i("LiveWallpaper test", "previewStateChange(isPreview:"+isPreview+")");
        }
    }
}
