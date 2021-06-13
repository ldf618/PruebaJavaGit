import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;

public class Main2 {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000), 
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950));

	
	transactions.stream()
		.filter(a->a.getYear()==2011)
		.sorted(Comparator.comparing(Transaction::getValue))
		.forEach(System.out::println);
	
	transactions.stream()
		.map(Transaction::getTrader)
		.map(Trader::getCity)
		.distinct()
		.forEach(System.out::println);
	
	transactions.stream()
		.map(t->t.getTrader().getCity())
		.distinct()
		.forEach(System.out::println);
	
	System.out.println("------------------");
	transactions.stream()
		.map(Transaction::getTrader)
		.filter(a->a.getCity().equalsIgnoreCase("cambridge"))
		.distinct()
		.sorted(Comparator.comparing(Trader::getName))
		.forEach(System.out::println);
	
	System.out.println("------------------");
	System.out.println(
			transactions.stream()
				.map(Transaction::getTrader).map(Trader::getName)
				.distinct()
				.sorted()
				.reduce((a, b) ->a.concat(b))
				.get()
				);
	System.out.println("------------------");
	System.out.println(	
	transactions.stream()
		.map(t->t.getTrader().getCity())
		.filter(a->a.equalsIgnoreCase("milan"))
		.findFirst()
		.isPresent()
	);

	System.out.println("------------------");
	System.out.println(	
			transactions.stream()
				.reduce((t1, t2) ->t1.getValue() < t2.getValue() ? t1 : t2)
	);

	}

}
