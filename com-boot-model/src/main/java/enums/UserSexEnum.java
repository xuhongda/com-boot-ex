package enums;

public enum UserSexEnum {
	/**
	 * 男
	 */
	MAN(0),
	/**
	 * 女
	 */
	WOMAN(1);

	private int sexFlag;

	UserSexEnum(int sexFlag) {
		this.sexFlag = sexFlag;
	}

	public int getSexFlag() {
		return sexFlag;
	}
}
