import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PruebaMain {

	static List<Dish> menu = Arrays.asList(
			new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT),
			new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER),
			new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER),
			new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH),
			new Dish("salmon", false, 450, Dish.Type.FISH) );
	public static void main (String args[]){
		
		/*sorted by calories*/
		List<Dish> sortedMenu = 
				menu.stream()
				.sorted(Comparator.comparing(Dish::getCalories))
				.collect(Collectors.toList());
		/*page 1*/
		System.out.println("PAGINA 1");
		sortedMenu.stream().limit(5).forEach(System.out::println);
		/*page 2. it doesn't throw any exception if limit is set beyond the list's boundaries*/
		System.out.println("PAGINA 2");
		sortedMenu.stream().skip(5).limit(4).forEach(System.out::println);
		/*working with distinct. Must implement equals on Dish*/
		System.out.println("DISTINCT");
		menu.stream().distinct().forEach(System.out::println);
		
		/*first two MEAT dishes*/
		System.out.println("MEAT");
	    menu.stream()
				.filter(dish->dish.getType().equals(Dish.Type.MEAT))
				.limit(2)
				.forEach(System.out::println);
	    
	     menu.stream()
	    		.map(dish->dish.getName().length())
	    		.forEach(System.out::println);
	     
	     Integer[] enteros = {1,2,3,4,5};
	     Stream<Integer> streamInt = Arrays.stream(enteros);
	     streamInt.map(i->i*i).collect(Collectors.toList());
	     
	     
	     //menu.stream().count() same as
	     System.out.println("Cuenta:"+menu.stream().collect(Collectors.counting()));
	     
	     System.out.println(
	    	menu.stream()
	    		 .collect(Collectors.maxBy(Comparator.comparingInt(Dish::getCalories)))
	     );
	     
	     //averagingInt summingInt summingDouble
	     System.out.println(
	    	menu.stream().collect(Collectors.averagingInt(Dish::getCalories))
	     );
	     
	     System.out.println(
	     menu.stream().collect(Collectors.partitioningBy(Dish::isVegetarian,
	    		 Collectors.partitioningBy(d -> d.getCalories() > 500)))
	     );
	     
	     }
	
	public static Optional<Integer> parseInt (String value){
		try {
			return Optional.ofNullable(Integer.parseInt(value));
		} catch (NumberFormatException nfe) {
			return Optional.empty();
		}
	}
			public int readDuration(Properties props, String name) {
				Optional <String> opValue = Optional.ofNullable(props.getProperty(name));
				return opValue.flatMap(PruebaMain::parseInt).filter(i -> i.intValue()>0).orElse(0);
			}
	}
	
	
