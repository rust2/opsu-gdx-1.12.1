package fluddokt.opsu.fake;

// Use integers and etc.
public class Color extends com.badlogic.gdx.graphics.Color {

	public static final Color black = new Color(0f, 0f, 0f);
	public static final Color white = new Color(1f, 1f, 1f);
	public static final Color transparent = new Color(0f, 0f, 0f, 0.5f);
	public static final Color lightGray = new Color(0.8f, 0.8f, 0.8f);
	public static final Color green = new Color(0f, 1f, 0f);
	public static final Color red = new Color(1f, 0f, 0f);
	public static final Color orange = new Color(1f, 0.5f, 0f);
	public static final Color blue = new Color(0f, 0f, 1f);
	public static final Color lightgreen = new Color(0.5f, 1f, 0.5f);
	public static final Color lightred = new Color(1f, 0.5f, 0.5f);
	public static final Color lightorange = new Color(1f, 0.75f, 0.5f);
	public static final Color lightblue = new Color(0.5f, 0.5f, 1f);
	public static final Color gray = new Color(0.5f, 0.5f, 0.5f);
	public static final Color magenta = new Color(1f, 0f, 1f);
	public static final Color cyan = new Color(0f, 1f, 1f);
	public static final Color darkGray = new Color(0.2f, 0.2f, 0.2f);
	public static final Color yellow = new Color(1f, 1f, 0f);

	public Color() {}

	public Color(float r, float g, float b) {
		super(r, g, b, 1f);
	}

	public Color(float r, float g, float b, float a) {
		super(r, g, b, a);
	}

	public Color(int r, int g, int b, float a) {
		super(r / 255f, g / 255f, b / 255f, a);
	}

	public Color(int r, int g, int b, int a) {
		super(r / 255f, g / 255f, b / 255f, a / 255f);
	}

	public Color(int r, int g, int b) {
		this(r, g, b, 1f);
	}

	public Color(Color color) {
		super(color);
	}

	public Color(int rgba) {
		init(rgba);
	}

	public void init(int rgba) {
		init(
			(rgba >> 24) & 0xff,
			(rgba >> 16) & 0xff,
			(rgba >>  8) & 0xff,
			(rgba      ) & 0xff
		);
	}
	public void init(int r, int g, int b, int a) {
		this.r = r / 255f;
		this.g = g / 255f;
		this.b = b / 255f;
		this.a = a / 255f;
	}

	public int getRed() {
		return (int) (r * 255);
	}

	public int getGreen() {
		return (int) (g * 255);
	}

	public int getBlue() {
		return (int) (b * 255);
	}

	public int getAlpha() {
		return (int) (a * 255);
	}
}
