package com.Naive.JavaSource;

import java.sql.DriverManager;

import javax.xml.parsers.ParserConfigurationException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class Naive_Predict {

	/**
	 * @param args
	 * @return
	 * @throws ParserConfigurationException
	 */

	public String predict(String inputWaterDepth, String inputAvgRainfall, String inputPopulation) throws Exception {

		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/localdb", "root",
					"");
			// here sonoo is database name, root is username and password
			Statement stmt = (Statement) con.createStatement();
			rs = (ResultSet) stmt.executeQuery("select * from datasets");

		} catch (Exception e) {
			System.out.println(e);
		}

		int affected = 0, nonAffected = 0;

		int affectedPopulation[] = new int[8];
		int nonAffectedPopulation[] = new int[8];

		int affectedWaterDepth[] = new int[3];
		int nonAffectedWaterDepth[] = new int[3];

		int affectedAvgRainfall[] = new int[15];
		int nonAffectedAvgRainfall[] = new int[15];

		for (int i = 0; i < 15; i++) {
			affectedAvgRainfall[i] = nonAffectedAvgRainfall[i] = 0;
		}

		for (int i = 0; i < 3; i++) {
			affectedWaterDepth[i] = nonAffectedWaterDepth[i] = 0;
		}

		for (int i = 0; i < 8; i++) {
			affectedPopulation[i] = nonAffectedPopulation[i] = 0;
		}

		/* Preparing parameters for prediction */

		int t = 0;

		while (rs.next()) {
			t++;
			String population = rs.getString(2);
			String rainfallAvg = rs.getString(1);
			String waterDepth = rs.getString(3);
			String result = rs.getString(4);

			if (result.equals("affected")) {
				affected++;
				// population
				if (population.equals("0-50000")) {
					affectedPopulation[0]++;
				} else if (population.equals("50000-100000")) {
					affectedPopulation[1]++;
				} else if (population.equals("100000-200000")) {

					affectedPopulation[2]++;
				} else if (population.equals("200000-300000")) {
					affectedPopulation[3]++;
				} else if (population.equals("300000-400000")) {
					affectedPopulation[4]++;
				} else if (population.equals("400000-500000")) {

					affectedPopulation[5]++;
				} else if (population.equals("500000-600000")) {
					affectedPopulation[6]++;
				} else {
					affectedPopulation[7]++;
				}

				// waterDepth
				if (waterDepth.equals("2")) {
					affectedWaterDepth[0]++;
				} else if (waterDepth.equals("2 to 5")) {
					affectedWaterDepth[1]++;
				} else {
					affectedWaterDepth[2]++;
				}

				// averageRainfall
				if (rainfallAvg.equals("300-400")) {
					affectedAvgRainfall[0]++;
				} else if (rainfallAvg.equals("400-500")) {

					affectedAvgRainfall[1]++;
				} else if (rainfallAvg.equals("500-600")) {

					affectedAvgRainfall[2]++;
				} else if (rainfallAvg.equals("600-700")) {

					affectedAvgRainfall[3]++;
				} else if (rainfallAvg.equals("700-800")) {

					affectedAvgRainfall[4]++;
				} else if (rainfallAvg.equals("800-900")) {

					affectedAvgRainfall[5]++;
				} else if (rainfallAvg.equals("1000-1100")) {

					affectedAvgRainfall[6]++;
				} else if (rainfallAvg.equals("1000-1200")) {

					affectedAvgRainfall[7]++;
				} else if (rainfallAvg.equals("1200-1300")) {

					affectedAvgRainfall[8]++;
				} else if (rainfallAvg.equals("1500-1800")) {

					affectedAvgRainfall[9]++;
				} else if (rainfallAvg.equals("1800-2000")) {

					affectedAvgRainfall[10]++;
				} else if (rainfallAvg.equals("1900-2000")) {

					affectedAvgRainfall[11]++;
				} else if (rainfallAvg.equals("2000-2100")) {

					affectedAvgRainfall[12]++;
				} else if (rainfallAvg.equals("2100-2200")) {

					affectedAvgRainfall[13]++;
				} else // 2100-2300
				{
					affectedAvgRainfall[14]++;
				}

			} else {
				nonAffected++;

				// population
				if (population.equals("0-50000")) {
					nonAffectedPopulation[0]++;
				} else if (population.equals("50000-100000")) {
					nonAffectedPopulation[1]++;
				} else if (population.equals("100000-200000")) {
					nonAffectedPopulation[2]++;
				} else if (population.equals("200000-300000")) {
					nonAffectedPopulation[3]++;
				} else if (population.equals("300000-400000")) {
					nonAffectedPopulation[4]++;
				} else if (population.equals("400000-500000")) {
					nonAffectedPopulation[5]++;
				} else if (population.equals("500000-600000")) {
					nonAffectedPopulation[6]++;
				} else {
					nonAffectedPopulation[7]++;
				}

				// waterDepth
				if (waterDepth.equals("2")) {
					nonAffectedWaterDepth[0]++;
				} else if (waterDepth.equals("2 to 5")) {
					nonAffectedWaterDepth[1]++;
				} else {
					nonAffectedWaterDepth[2]++;
				}

				// averageRainfall
				if (rainfallAvg.equals("300-400")) {
					nonAffectedAvgRainfall[0]++;
				} else if (rainfallAvg.equals("400-500")) {

					nonAffectedAvgRainfall[1]++;
				} else if (rainfallAvg.equals("500-600")) {

					nonAffectedAvgRainfall[2]++;
				} else if (rainfallAvg.equals("600-700")) {

					nonAffectedAvgRainfall[3]++;
				} else if (rainfallAvg.equals("700-800")) {

					nonAffectedAvgRainfall[4]++;
				} else if (rainfallAvg.equals("800-900")) {

					nonAffectedAvgRainfall[5]++;
				} else if (rainfallAvg.equals("1000-1100")) {

					nonAffectedAvgRainfall[6]++;
				} else if (rainfallAvg.equals("1000-1200")) {

					nonAffectedAvgRainfall[7]++;
				} else if (rainfallAvg.equals("1200-1300")) {

					nonAffectedAvgRainfall[8]++;
				} else if (rainfallAvg.equals("1500-1800")) {

					nonAffectedAvgRainfall[9]++;
				} else if (rainfallAvg.equals("1800-2000")) {

					nonAffectedAvgRainfall[10]++;
				} else if (rainfallAvg.equals("1900-2000")) {

					nonAffectedAvgRainfall[11]++;
				} else if (rainfallAvg.equals("2000-2100")) {

					nonAffectedAvgRainfall[12]++;
				} else if (rainfallAvg.equals("2100-2200")) {
					nonAffectedAvgRainfall[13]++;
				} else // 2100-2300
				{
					nonAffectedAvgRainfall[14]++;
				}

			}

		}

		/* Setting final values for calculation as per input */

		int finalAffectedWaterDepth;
		int finalAffectedAvgRainfall;
		int finalAffectedPopulation;

		int finalNonAffectedWaterDepth;
		int finalNonAffectedAvgRainfall;
		int finalNonAffectedPopulation;

		if (inputPopulation.equals("0-50000")) {
			finalAffectedPopulation = affectedPopulation[0];
			finalNonAffectedPopulation = nonAffectedPopulation[0];
		} else if (inputPopulation.equals("50000-100000")) {

			finalAffectedPopulation = affectedPopulation[1];

			finalNonAffectedPopulation = nonAffectedPopulation[1];
		} else if (inputPopulation.equals("100000-200000")) {

			finalAffectedPopulation = affectedPopulation[2];

			finalNonAffectedPopulation = nonAffectedPopulation[2];
		} else if (inputPopulation.equals("200000-300000")) {

			finalAffectedPopulation = affectedPopulation[3];

			finalNonAffectedPopulation = nonAffectedPopulation[3];
		} else if (inputPopulation.equals("300000-400000")) {

			finalAffectedPopulation = affectedPopulation[4];

			finalNonAffectedPopulation = nonAffectedPopulation[4];
		} else if (inputPopulation.equals("400000-500000")) {

			finalAffectedPopulation = affectedPopulation[5];

			finalNonAffectedPopulation = nonAffectedPopulation[5];
		} else if (inputPopulation.equals("500000-600000")) {
			finalAffectedPopulation = affectedPopulation[6];
			finalNonAffectedPopulation = nonAffectedPopulation[6];
		} else {

			finalAffectedPopulation = affectedPopulation[7];

			finalNonAffectedPopulation = nonAffectedPopulation[7];
		}

		// waterDepth
		if (inputWaterDepth.equals("2")) {
			finalAffectedWaterDepth = affectedWaterDepth[0];
			finalNonAffectedWaterDepth = nonAffectedWaterDepth[0];
		} else if (inputWaterDepth.equals("2 to 5")) {
			finalAffectedWaterDepth = affectedWaterDepth[1];
			finalNonAffectedWaterDepth = nonAffectedWaterDepth[1];
		} else {
			finalAffectedWaterDepth = affectedWaterDepth[2];
			finalNonAffectedWaterDepth = nonAffectedWaterDepth[2];
		}

		// averageRainfall
		if (inputAvgRainfall.equals("300-400")) {
			finalAffectedAvgRainfall = affectedAvgRainfall[0];
			finalNonAffectedAvgRainfall = nonAffectedAvgRainfall[0];

		} else if (inputAvgRainfall.equals("400-500")) {

			finalAffectedAvgRainfall = affectedAvgRainfall[1];
			finalNonAffectedAvgRainfall = nonAffectedAvgRainfall[1];
		} else if (inputAvgRainfall.equals("500-600")) {

			finalAffectedAvgRainfall = affectedAvgRainfall[2];
			finalNonAffectedAvgRainfall = nonAffectedAvgRainfall[2];
		} else if (inputAvgRainfall.equals("600-700")) {

			finalAffectedAvgRainfall = affectedAvgRainfall[3];
			finalNonAffectedAvgRainfall = nonAffectedAvgRainfall[3];
		} else if (inputAvgRainfall.equals("700-800")) {

			finalAffectedAvgRainfall = affectedAvgRainfall[4];
			finalNonAffectedAvgRainfall = nonAffectedAvgRainfall[4];
		} else if (inputAvgRainfall.equals("800-900")) {

			finalAffectedAvgRainfall = affectedAvgRainfall[5];
			finalNonAffectedAvgRainfall = nonAffectedAvgRainfall[5];
		} else if (inputAvgRainfall.equals("1000-1100")) {

			finalAffectedAvgRainfall = affectedAvgRainfall[6];
			finalNonAffectedAvgRainfall = nonAffectedAvgRainfall[6];
		} else if (inputAvgRainfall.equals("1000-1200")) {

			finalAffectedAvgRainfall = affectedAvgRainfall[7];
			finalNonAffectedAvgRainfall = nonAffectedAvgRainfall[7];
		} else if (inputAvgRainfall.equals("1200-1300")) {

			finalAffectedAvgRainfall = affectedAvgRainfall[8];
			finalNonAffectedAvgRainfall = nonAffectedAvgRainfall[8];
		} else if (inputAvgRainfall.equals("1500-1800")) {

			finalAffectedAvgRainfall = affectedAvgRainfall[9];
			finalNonAffectedAvgRainfall = nonAffectedAvgRainfall[9];
		} else if (inputAvgRainfall.equals("1800-2000")) {

			finalAffectedAvgRainfall = affectedAvgRainfall[10];
			finalNonAffectedAvgRainfall = nonAffectedAvgRainfall[10];
		} else if (inputAvgRainfall.equals("1900-2000")) {

			finalAffectedAvgRainfall = affectedAvgRainfall[11];
			finalNonAffectedAvgRainfall = nonAffectedAvgRainfall[11];
		} else if (inputAvgRainfall.equals("2000-2100")) {

			finalAffectedAvgRainfall = affectedAvgRainfall[12];
			finalNonAffectedAvgRainfall = nonAffectedAvgRainfall[12];
		} else if (inputAvgRainfall.equals("2100-2200")) {

			finalAffectedAvgRainfall = affectedAvgRainfall[13];
			finalNonAffectedAvgRainfall = nonAffectedAvgRainfall[13];
		} else // 2100-2300
		{
			finalAffectedAvgRainfall = affectedAvgRainfall[14];
			finalNonAffectedAvgRainfall = nonAffectedAvgRainfall[14];

		}

		if (finalAffectedAvgRainfall == 0) {
			finalAffectedAvgRainfall = 1;
		}
		if (finalAffectedPopulation == 0) {
			finalAffectedPopulation = 1;
		}
		if (finalAffectedWaterDepth == 0) {
			finalAffectedWaterDepth = 1;
		}

		if (finalNonAffectedAvgRainfall == 0) {
			finalNonAffectedAvgRainfall = 1;
		}
		if (finalNonAffectedPopulation == 0) {
			finalNonAffectedPopulation = 1;
		}
		if (finalNonAffectedWaterDepth == 0) {
			finalNonAffectedWaterDepth = 1;
		}

		System.out.println(finalAffectedAvgRainfall + "\n" + affected + "\n" + finalAffectedPopulation + "\n"
				+ finalAffectedWaterDepth);

		double cAffected = (double) finalAffectedAvgRainfall / affected * (double) finalAffectedPopulation / affected
				* (double) finalAffectedWaterDepth / affected * (double) affected / t;
		double cNonAffected = (double) finalNonAffectedAvgRainfall / nonAffected * (double) finalNonAffectedPopulation
				/ nonAffected * (double) finalNonAffectedWaterDepth / nonAffected * (double) nonAffected / t;

		System.out.println(cAffected + " " + cNonAffected);

		String pre_wt = null;

		if (cAffected > cNonAffected) {
			pre_wt = "affected";
		} else {
			pre_wt = "not affected";
		}

		int affectedPop = 0;
		int affectedRain = 0;
		int affectedDepth = 0;
		for (int i = 0; i < affectedPopulation.length; i++) {
			affectedPop += affectedPopulation[i];
		}
		for (int i = 0; i < affectedAvgRainfall.length; i++) {
			affectedRain += affectedAvgRainfall[i];
		}
		for (int i = 0; i < affectedWaterDepth.length; i++) {
			affectedDepth += affectedWaterDepth[i];
		}

		System.out.println(affectedPop + "\t" + affectedRain + "\t" + affectedDepth);

		int naffectedPop = 0;
		int naffectedRain = 0;
		int naffectedDepth = 0;
		for (int i = 0; i < nonAffectedPopulation.length; i++) {
			naffectedPop += nonAffectedPopulation[i];
		}
		for (int i = 0; i < nonAffectedAvgRainfall.length; i++) {
			naffectedRain += nonAffectedAvgRainfall[i];
		}
		for (int i = 0; i < nonAffectedWaterDepth.length; i++) {
			naffectedDepth += nonAffectedWaterDepth[i];
		}

		System.out.println(naffectedPop + "\t" + naffectedRain + "\t" + naffectedDepth);

		// System.out.println("Drought prediction: " + pre_wt);

		return pre_wt;

	}

	private static boolean isBetween(int x, int i, int j) {
		// TODO Auto-generated method stub
		if (x >= i && x <= j) {
			return true;
		} else {
			return false;
		}
	}
}
