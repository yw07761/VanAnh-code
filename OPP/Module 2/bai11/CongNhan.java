package hoHoangVanAnh.bai11;

public class CongNhan {
	private int maCN;
	private String mHo;
	private String mTen;
	private int mSoSP;

	public CongNhan() {
	}

	public CongNhan(int maCN, String mHo, String mTen, int mSoSP) {
		this.maCN = maCN;
		this.mHo = mHo;
		this.mTen = mTen;
		this.mSoSP = mSoSP;
	}

	public int getMaCN() {
		return maCN;
	}

	public void setMaCN(int maCN) {
		this.maCN = maCN;
	}

	public String getmHo() {
		return mHo;
	}

	public void setmHo(String mHo) {
		this.mHo = mHo;
	}

	public String getmTen() {
		return mTen;
	}

	public void setmTen(String mTen) {
		this.mTen = mTen;
	}

	public int getmSoSP() {
		return mSoSP;
	}

	public void setmSoSP(int mSoSP) {
		this.mSoSP = mSoSP;
	}

	public double tinhLuong() {
		float DonGia;
		if (mSoSP > 1 && mSoSP < 200)
			DonGia = 0.5f;
		else if (mSoSP > 200 && mSoSP < 400)
			DonGia = 0.55f;
		else if (mSoSP > 400 && mSoSP < 600)
			DonGia = 0.6f;
		else
			DonGia = 0.65f;
		return mSoSP * DonGia;
	}

	@Override
	public String toString() {
		return "CongNhan{" + "maCN=" + maCN + ", mHo=" + mHo + ", mTen=" + mTen + ", mSoSP=" + mSoSP + '}';
	}

	public void HienThiCongNhan() {
		System.out.printf("%-10d %-20s %-15s %-20s \n", maCN, mHo, mTen, mSoSP);
	}
}
