package util;

/**
 * 将org.apache.commons.lang3.builder.HashCodeBuilder移植过来
 * 版本 : commons-lang3-3.3.2.jar
 */
public class HashCodeBuilder {

	private final int iConstant;
	private int iTotal = 0;
	
	public HashCodeBuilder() {
		this.iConstant = 37;
		this.iTotal = 17;
	}
	
	public HashCodeBuilder append(final Object object) {
		if (object == null) {
			this.iTotal *= this.iConstant;
		} 
		else if (object.getClass().isArray()) {
			if (object instanceof long[]){
				append((long[]) (long[]) object);
			}
			else if (object instanceof int[]) {
				append((int[]) (int[]) object);
			}
			else if (object instanceof short[]) {
				append((short[]) (short[]) object);
			}
			else if (object instanceof char[]) {
				append((char[]) (char[]) object);
			}
			else if (object instanceof byte[]) {
				append((byte[]) (byte[]) object);
			}
			else if (object instanceof double[]) {
				append((double[]) (double[]) object);
			}
			else if (object instanceof float[]) {
				append((float[]) (float[]) object);
			}
			else if (object instanceof boolean[]) {
				append((boolean[]) (boolean[]) object);
			} else {
				append((Object[]) (Object[]) object);
			}
		} 
		else {
			this.iTotal = (this.iTotal * this.iConstant + object.hashCode());
		}
		return this;
	}
	
	@Override
	public int hashCode() {
		return this.iTotal;
	}
}
