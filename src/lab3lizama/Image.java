package lab3lizama;
import java.utils.*
public class Image {
	public int width;
	public int height;
        public Image(int width, int height)
}

abstract class Pixel {
	public int x;
	public int y;
}

public class PixBit extends Pixel {
	public int bit;
}

public class PixRGB extends Pixel {
	public int red;
	public int green;
	public int blue;
}

public class PixHex extends Pixel {
	public string hex;
}


