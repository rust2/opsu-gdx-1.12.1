package com.mygdx.game;

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application;
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration;
import itdelatrisu.opsu.Opsu;
import itdelatrisu.opsu.OpsuConstants;

public class DesktopLauncherLwjgl3 {
    public static void main(String[] args)
    {
        // todo: parse options before even game class was created?
        new Lwjgl3Application(new Opsu(args), getConfig());
    }

    private static Lwjgl3ApplicationConfiguration getConfig()
    {
        Lwjgl3ApplicationConfiguration config = new Lwjgl3ApplicationConfiguration();
        //config.setResizable(false);
        config.setWindowIcon("res/icon32.png", "res/icon16.png");
        config.useVsync(false);
        config.setWindowSizeLimits(800, 600, -1, -1);
        config.setForegroundFPS(240); // 240
        config.setIdleFPS(30);
        config.setBackBufferConfig(8, 8, 8, 8, 16, 0, 2);
        config.setTitle(OpsuConstants.PROJECT_NAME);

        return config;
    }
}
