package ru.acmp.task670;

import java.io.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {

		ArrayList<Integer> Sqnc = new ArrayList<>();

		String myJarPath = Main.class.getProtectionDomain().getCodeSource()
				.getLocation().getPath();
		String dirPath = new File(myJarPath).getParent();
		dirPath = dirPath + "\\files";

		FileInputStream fstream = new FileInputStream(dirPath + "\\INPUT.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
		String strValue = br.readLine();
		int value = Integer.parseInt(strValue);
		br.close();

		for (int i = 1; i < 10000; i++) {
			if (i < 100) {
				if (i % 10 != (i / 10) % 100) {
					Sqnc.add(i);
				}
			} else {
				if (i >= 100 && i < 1000) {
					if (i % 10 != (i / 10) % 10 && i % 10 != (i / 100) % 10
							&& (i / 10) % 10 != (i / 100) % 10) {
						Sqnc.add(i);
					}
				} else {
					if (i % 10 != (i / 10) % 10 && i % 10 != (i / 100) % 10
							&& i % 10 != (i / 1000) % 10
							&& (i / 10) % 10 != (i / 100) % 10
							&& (i / 10) % 10 != (i / 1000) % 10
							&& (i / 100) % 10 != (i / 1000) % 10) {
						Sqnc.add(i);
					}
				}
			}

		}
		int toText = Sqnc.get(value - 1);
		String text = Integer.toString(toText);
		try (FileWriter writer = new FileWriter(dirPath + "\\OUTPUT.txt", false)) {
			writer.write(text);
			writer.flush();
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}

	}

}
