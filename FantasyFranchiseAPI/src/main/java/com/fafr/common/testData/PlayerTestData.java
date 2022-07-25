package com.fafr.common.testData;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fafr.model.player.Player;

public class PlayerTestData {

	private static Logger logger = LogManager.getLogger();
	private static List<Player> playersRepository = new ArrayList<>();

	public static void readPlayerCSV() {
		final String playerCSV = "src/main/resources/testData/playersUpdated.csv";
		try (Scanner z = new Scanner(new FileReader(new File(playerCSV)))) {
			logger.info("Attempting to read the player CSV {}", playerCSV);
			Player player = null;
			while (z.hasNextLine()) {
				String line = z.nextLine();
				String[] split = line.split(",");
//				try {
//					player = new Player(split[6].split(" ")[0].trim(), split[6].split(" ")[1].trim(),
//							new Date(formatDateUsingDTF(split[3].trim())), Integer.parseInt(split[2].trim()),
//							removeDoubleQuotes(split[4].trim()), Integer.parseInt(split[0].trim()), split[5].trim(),
//							Integer.parseInt(split[1].trim()));
//				} catch (ArrayIndexOutOfBoundsException | NumberFormatException exx) {
//					logger.warn("Error at Index -- {},{},{}", split[0], exx.getMessage(),
//							exx.getClass().toGenericString());
//					logger.error("Unable to parse Data: {},{},{},*{},{},{}", split[1], split[2], split[3], split[4],
//							split[5], split[6]);
//				}
				if (player != null) {
					playersRepository.add(player);
				}
			}
		} catch (IOException ex) {
			logger.error(ex);
		} finally {
			logger.info("Finished Initializing the Player Test Data", playerCSV);
		}
	}

	private static Long formatDateUsingDTF(String date) {
		LocalDate d = LocalDate.of(Integer.parseInt(date.split("/")[2]), Integer.parseInt(date.split("/")[0]),
				Integer.parseInt(date.split("/")[1]));
		return d.getLong(ChronoField.EPOCH_DAY);
	}

	private static String removeDoubleQuotes(String string) {
		return string.contains("\"") ? string.replaceAll("\"", "") : string;
	}

	public static List<Player> getPlayerTestData() {
		return playersRepository;
	}

}
