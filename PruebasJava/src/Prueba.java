import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Prueba {

	public static void main(String args[]) {

		var stream1 = Stream.empty();

		var stream2 = Stream.of("a", "b", "c", "l", "s", "a");

		//stream2.distinct().forEach(System.out::print);

		Factura f = new Factura("ordenador", 1000);
		Factura f2 = new Factura("movil", 300);
		Factura f3 = new Factura("impresora", 200);
		Factura f4 = new Factura("imac", 1500);
		List<Factura> lista = new ArrayList<Factura>();
		lista.add(f2);
		lista.add(f);
		lista.add(f3);
		lista.add(f4);
		
		List<Factura> lista2 = 
				lista.stream()
				.filter((factura)->factura.getPrecio()>20)
				.sorted(Comparator.comparing(Factura::getPrecio).reversed())
				.collect(Collectors.toList());
		lista2.stream().forEach(System.out::println);
		
		//int n = lista.stream().mapToInt(factura->factura.getPrecio()).sum();
		lista.stream().mapToDouble(Factura::getPrecio).average().ifPresent(System.out::println);;
		int n = lista.stream().mapToInt(Factura::getPrecio).sum();
		long l = lista.stream().count();
		System.out.println("Suma:"+n);
		System.out.println("Cuenta:"+l);
		
		//Function<String, Integer> stringToInteger = (String s) -> Integer.parseInt(s);
		Function<String, Integer> stringToInteger = Integer::parseInt;
		Integer i = stringToInteger.apply("123");
		System.out.println(i);
		
		//BiPredicate<List<String>, String> contains =(list, element) -> list.contains(element);
		BiPredicate<List<String>, String> contains =List::contains;
		
		/*
		 Predicate<Factura> predicado= new Predicate<Factura>() {
			 @Override
			 public boolean test(Factura f) {
				 System.out.println(" iteracion ");
				 return f.getPrecio()>300;
			 }
		  };
		
		  Factura facturaFiltro=
				  lista.stream()
				  .filter(predicado)
				  .findFirst()
				  .get();
			 System.out.println("UNICA :"+facturaFiltro.getPrecio());*/
			 		
		/*
		Factura facturaFiltro = lista.stream()
				.filter(elemento -> elemento.getPrecio() > 300)
				.findFirst()
				.get();
		System.out.println(facturaFiltro.getPrecio());*/

	}
}
