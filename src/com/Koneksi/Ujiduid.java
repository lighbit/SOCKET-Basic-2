package com.Koneksi;

import java.text.NumberFormat;
import java.util.Locale;

public class Ujiduid {
	Locale locale = null;
	NumberFormat rupiahFormat = null;

	public String toRupiahFormat(String nominal) {
		String rupiah = "";
		locale = new Locale("ca", "CA");
		rupiahFormat = NumberFormat.getCurrencyInstance(locale);
		rupiah = rupiahFormat.format(Double.parseDouble(nominal)).substring(4);

		return rupiah;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String nominal = "8500000";

		Ujiduid rcf = new Ujiduid();
		System.out.println(rcf.toRupiahFormat(nominal));

	}

}
