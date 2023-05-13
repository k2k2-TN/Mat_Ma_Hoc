package vn.iotstar.config;
import java.util.Arrays;

public class Decode_1 {
	
	
	public static String RC4Encrypt(String input) {
		String key = "SecretKey";
        StringBuilder result = new StringBuilder();
        int x, y, j = 0;
        int[] box = new int[256];

        for (int i = 0; i < 256; i++) {
            box[i] = i;
        }

        for (int i = 0; i < 256; i++) {
            j = (key.charAt(i % key.length()) + box[i] + j) % 256;
            x = box[i];
            box[i] = box[j];
            box[j] = x;
        }

        for (int i = 0; i < input.length(); i++) {
            y = i % 256;
            j = (box[y] + j) % 256;
            x = box[y];
            box[y] = box[j];
            box[j] = x;

            result.append((char) (input.charAt(i) ^ box[(box[y] + box[j]) % 256]));
        }
        return result.toString();
    }
}
