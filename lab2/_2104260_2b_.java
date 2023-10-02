
import java.util.*;

public class _2104260_2b_ {
    
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        
        String details = scanner.nextLine();
        String[] parts = details.split(",");
        String investorName = parts[0].trim();
        int numCompanies = Integer.parseInt(parts[1].trim());

		Investor investor = new Investor(investorName, numCompanies);
		readInput(scanner, investor);
		report(investor);

		scanner.close();
	}

	public static void readInput(Scanner scanner, Investor investor) {
		for (int i = 0; i < investor.getCostList().length; i++) {
            String det = scanner.nextLine();
            String[] p = det.split(",");
            String symbol = p[0].trim();
            double currentPrice = Double.parseDouble(p[1].trim());
            int numPurchases = Integer.parseInt(p[2].trim());


			Stock stock = new Stock(symbol, currentPrice);
			for (int j = 0; j < numPurchases; j++) {

                String a = scanner.nextLine();
                String[] b = a.split(",");
                int shares = Integer.parseInt(b[0].trim());
                double pricePerShare = Double.parseDouble(b[1].trim());
				stock.purchase(shares, pricePerShare);
			}

			investor.addStock(stock);
		}
	}

	public static void report(Investor investor) {
		investor.displayStockSummary();
	}
}

class Stock {
	private String symbol;
	private int totalShares;
	private double totalCost;
	private double currentPrice;

	public Stock(String symbol, double currentPrice) {
		this.symbol = symbol;
		this.currentPrice = currentPrice;
	}

	public double getProfit() {
	   
		double p = (totalShares * currentPrice) - totalCost;
		return p;
	}

	public void purchase(int shares, double pricePerShare) {
		totalShares += shares;
		totalCost += shares * pricePerShare;
	}

	public String getSymbol() {
		return symbol;
	}

	public double getCurrentPrice() {
		return currentPrice;
	}
}

class Investor {
	private String investorName;
	private Stock[] cosList;

	public Investor(String investorName, int numCompanies) {
		this.investorName = investorName;
		this.cosList = new Stock[numCompanies];
	}

	public void addStock(Stock stock) {
		for (int i = 0; i < cosList.length; i++) {
			if (cosList[i] == null) {
				cosList[i] = stock;
				break;
			}
		}
	}

	public Stock[] getCostList() {
		return cosList;
	}

	public double getTotalProfitLoss() {
		double totalProfitLoss = 0;
		for (Stock stock : cosList) {
			if (stock != null) {
				totalProfitLoss += stock.getProfit();
			}
		}
		return totalProfitLoss;
	}

	public void displayStockSummary() {
		System.out.println("Investor Name: " + investorName);
		System.out.println("Stock\tCurr Price\tProfit/Loss");
		for (Stock stock : cosList) {
			if (stock != null) {
				System.out.println(stock.getSymbol() + "\t" + stock.getCurrentPrice() + "\t\t" + String.format("%.2f",stock.getProfit()) );
			}
		}
		System.out.println("Nett. Profit/Loss as of today: $" + getTotalProfitLoss());
	}
}