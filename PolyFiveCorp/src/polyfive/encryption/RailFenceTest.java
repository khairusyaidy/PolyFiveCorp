package polyfive.encryption;

import java.util.Scanner;

public class RailFenceTest {
	public static void main(String args[]) {
		RailFence test = new RailFence();
		String plainTextString = "";
		String cipherTextString = "";
		Scanner sc = new Scanner(System.in);
		System.out.println("Rail Fence");
		System.out.println("---------");
		System.out.print("Enter plain text :");
		plainTextString = sc.nextLine();
		System.out.println("Cipher text      :" + test.encrypt(plainTextString)
				+ "\n");
		System.out.print("Enter cipher text:");
		cipherTextString = sc.nextLine();
		System.out.println("Plain text       :"
				+ test.decrypt(cipherTextString));
	}

}
