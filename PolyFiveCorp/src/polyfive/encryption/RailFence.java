package polyfive.encryption;

public class RailFence {

	public static java.lang.String encrypt(java.lang.String plainTextString) {
		boolean tf = true;
		String str1 = "", str2 = "";
		for (int i = 0; i < plainTextString.length(); i++) {
			if (tf == true) {
				str1 += plainTextString.charAt(i);
				tf = false;
			} else {
				str2 += plainTextString.charAt(i);
				tf = true;
			}
		}

		String cipherTextString = str1 + str2;

		return cipherTextString;
	}

	public static java.lang.String decrypt(java.lang.String cipherTextString) {
		String plainText = "";
		String str1 = "", str2 = "";
		String string = "";
		int len = cipherTextString.length();
		if (len % 2 == 0) {
			str1 = cipherTextString.substring(0, (len / 2));
			str2 = cipherTextString.substring((len / 2), len);
			for (int i = 0; i < str1.length(); i++) {
				string += str1.charAt(i);
				string += str2.charAt(i);
				plainText = string;

			}
		}

		else if (len % 2 != 0) {
			str1 = cipherTextString.substring(0, (len / 2) + 1);
			str2 = cipherTextString.substring((len / 2) + 1, len);
			String string2 = "";
			boolean tf = true;
			for (int i = 0; i < str1.length(); i++) {

				if (tf) {
					string2 += str1.charAt(i);
					tf = false;
					i--;
				} else if (tf == false) {
					if (i < str2.length()) {
						string2 += str2.charAt(i);
						tf = true;
					} else
						tf = true;
				}

				plainText = string2;

			}
		}
		return plainText;
	}
}
