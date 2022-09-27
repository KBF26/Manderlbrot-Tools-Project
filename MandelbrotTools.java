import java.awt.Color;

public class MandelbrotTools {

	/*This method returns a value which is the color. This method depends on 
	 * the divergence method and if colors are going to be bigger on the image
	 * compared to other colors. */
	public static Color getColor(int divergence) {
		Color returnValue;

		if (Controller.colorScheme == Controller.RED_AND_WHITE_BANDS) {
			returnValue = (divergence  % 2 == 0)? Color.WHITE : Color.RED;
		}

		else if (Controller.colorScheme == Controller.CRAZY_COLORS) {
			int value = divergence * 2;
			int redAmount = (value % 5) * (255/5);
			int greenAmount = (value % 7) * (255/7);
			int blueAmount = (value % 9) * (255/9);
			returnValue = new Color(redAmount, greenAmount, blueAmount); 
		}

		else if (Controller.colorScheme == Controller.STUDENT_DEFINED){
			returnValue = Color.WHITE;  
		}else
			throw new RuntimeException("Unknown color scheme selected!");
		return returnValue;
	}
	/*This method returns true if the value is great than the 
	 * Divergent_Boundary */
	public static boolean isBig(ComplexNumber complexNumber){
		MyDouble realPart = complexNumber.getReal();
		MyDouble imagPart = complexNumber.getImag();

		MyDouble updateReal = realPart.multiply(realPart);
		MyDouble updateImag = imagPart.multiply(imagPart);

		MyDouble number = new MyDouble(updateReal.add(updateImag));

		boolean returnValue = false;

		if(number.compareTo(Controller.DIVERGENCE_BOUNDARY) > 0)
		{
			returnValue = true;
		}

		return returnValue;

	}
	/*This method will return a number. This test whether it is bigger than the
	 * isBig method*/
	public static int divergence(ComplexNumber otherComplexNumber){

		int count = 0;

		ComplexNumber complex = new ComplexNumber(otherComplexNumber);

		do
		{
			if(isBig(complex)) return count;

			complex = complex.multiply(complex).add(otherComplexNumber);

			count = count + 1;

		} while(count < Controller.LIMIT);

		return -1;
	}
}




