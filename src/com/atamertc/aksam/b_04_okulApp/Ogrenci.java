package com.atamertc.aksam.b_04_okulApp;

import java.io.Serializable;
import java.time.LocalDate;

public class Ogrenci implements Serializable {

	private String isim;

	private double ortalama;

	private EDurum durum;

	private LocalDate dogumTarihi;

	public Ogrenci(String isim, double ortalama, EDurum durum, LocalDate dogumTarihi) {
		super();
		this.isim = isim;
		this.ortalama = ortalama;
		this.durum = durum;
		this.dogumTarihi = dogumTarihi;
	}

	public Ogrenci(String isim, double ortalama, LocalDate dogumTarihi) {
		super();
		this.isim = isim;
		this.ortalama = ortalama;
		this.dogumTarihi = dogumTarihi;
		durumBelirle(ortalama);
	}

	public Ogrenci(String isim, LocalDate dogumTarihi) {
		super();
		this.isim = isim;
		this.dogumTarihi = dogumTarihi;
	}

	public String getIsim() {
		return isim;
	}

	public double getOrtalama() {
		return ortalama;
	}

	public EDurum getDurum() {
		return durum;
	}

	public LocalDate getDogumTarihi() {
		return dogumTarihi;
	}

	public void setIsim(String isim) {
		this.isim = isim;
	}

	public void setOrtalama(double ortalama) {
		this.ortalama = ortalama;
	}

	public void setDurum(EDurum durum) {
		this.durum = durum;
	}

	public void setDogumTarihi(LocalDate dogumTarihi) {
		this.dogumTarihi = dogumTarihi;
	}

	public void durumBelirle(double ort) {
		if (ort > 60) {
			setDurum(EDurum.GECTI);
		} else {
			setDurum(EDurum.KALDI);
		}
	}


	@Override
	public String toString() {

		return "Ogrenci [isim=" + isim + ", ortalama=" + ortalama + ", durum=" + durum + ", dogumTarihi=" + dogumTarihi
				+ "]";
	}

}
