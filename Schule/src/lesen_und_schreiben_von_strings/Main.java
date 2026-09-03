package lesen_und_schreiben_von_strings;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.print.DocFlavor.BYTE_ARRAY;

public class Main {

	private final String mc_logloc = "C:\\Users\\Dennis\\Downloads\\logfile.txt";
	private File mr_logfile;
	private FileWriter mr_logwrite;
	private int mv_byte_sum;
	private DateTimeFormatter mr_formatter;

	public static void main(String[] args) {
		Main lr_main = new Main();
		lr_main.append_log(LocalDate.of(2026, Month.APRIL, 9), 1234);
		lr_main.append_log(LocalDate.of(2026, Month.APRIL, 9), 64634151);
		lr_main.append_log(LocalDate.of(2026, Month.APRIL, 9), 100);
		lr_main.close_writer();
		lr_main.read_entries(LocalDate.of(2026, Month.APRIL, 9));
		lr_main.output_sum();
	}

	private void close_writer() {
		try {
			mr_logwrite.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Main() {
		mr_logfile = new File(mc_logloc);
		try {
			mr_logwrite = new FileWriter(mr_logfile, true);
		} catch (IOException e) {
			e.printStackTrace();
		}
		mv_byte_sum = 0;
		mr_formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy", Locale.ENGLISH);
	}

	private void append_log(LocalDate iv_datum, int iv_bytes) {
		try {
			String lv_date = iv_datum.format(mr_formatter);
			mr_logwrite.append("\n[" + lv_date + ":10:42:45 -0800] sandbox.sambar.com -- \"Get/HTTP/1.0\" 200 "
					+ iv_bytes + " \"http://www.skyweb.se/sambar/\" \"Mozilla/4.0 (Win7;I)\"");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void read_entries(LocalDate iv_date) {
		try {
			Scanner lr_reader = new Scanner(mr_logfile);
			while (lr_reader.hasNextLine()) {
				String lv_line = lr_reader.nextLine();
				String lv_date = iv_date.format(mr_formatter);
				if (lv_line.contains(lv_date)) {
					mv_byte_sum += Integer.parseInt(extract_bytes(lv_line));
				}
			}
			lr_reader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private String extract_bytes(String iv_line) {
		Pattern pattern = Pattern.compile("\"\\s+\\d+\\s+(\\d+)\\s+\"");
		Matcher matcher = pattern.matcher(iv_line);
		if (matcher.find()) {
			return matcher.group(1);
		}
		return null;
	}

	private void output_sum() {
		double lv_bytes = mv_byte_sum;
		String[] lt_units = { "B", "KB", "MB", "GB", "TB" };

		int lv_index = 0;

		while (lv_bytes >= 1000 && lv_index < lt_units.length - 1) {
			lv_bytes /= 1000;
			lv_index++;
		}

		System.out.printf("%.2f %s", lv_bytes, lt_units[lv_index]);
	}

}
