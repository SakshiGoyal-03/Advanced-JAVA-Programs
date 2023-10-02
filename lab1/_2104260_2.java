import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class _2104260_2 {
	
	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
            System.out.println("Enter a date in the format yyyy-MM-dd");
			String dateStr = sc.nextLine();
			
			DateFormat srcDf = new SimpleDateFormat("yyyy-MM-dd");
			
			Date date = srcDf.parse(dateStr);
			
			DateFormat destDf = new SimpleDateFormat("dd/MM/yyyy");
			 

			dateStr = destDf.format(date);
			
			System.out.println("Converted date is : " + dateStr);
			sc.close();
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		
	}

}

