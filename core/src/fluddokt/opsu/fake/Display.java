package fluddokt.opsu.fake;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Graphics.DisplayMode;

public class Display {

	public static void setTitle(String title) {
		Gdx.graphics.setTitle(title);
	}

	static Resolution deskRes;
	public static Resolution getDesktopDisplayMode() {
		if(deskRes == null) {
			//region oldcode
			/*
			DisplayMode d = Gdx.graphics.getDesktopDisplayMode();
			*/
			//endregion
			DisplayMode d = Gdx.graphics.getDisplayMode();

			deskRes = new Resolution(d.width, d.height);
		}
		return deskRes;
	}

}
