
public class Factura{
		private String concepto;
		private int precio;
		
		
		public Factura(String concepto, int precio) {
			super();
			this.concepto = concepto;
			this.precio = precio;
		}
		
		public String getConcepto() {
			return concepto;
		}
		public void setConcepto(String concepto) {
			this.concepto = concepto;
		}
		public int getPrecio() {
			return precio;
		}
		public void setPrecio(int precio) {
			this.precio = precio;
		}

		@Override
		public String toString() {
			return "Factura [concepto=" + concepto + ", precio=" + precio + "]";
		}
		
		
	}
