public class Calc {
    public static void main (String[] args) {
        //System.out.println(args.length);
        if (args.length == 3) {
        
	  switch (args[0].toUpperCase()){
	  
	    case "SOMAR":
	      System.out.println("Operaçao De Somar");
	      System.out.println("Resultado: " + (Double.parseDouble(args[1]) + Double.parseDouble(args[2])));
	      break;
	    case "DIVIDIR":
	      System.out.println("Operaçao De Dividir");
	      System.out.println("Resultado: " + (Double.parseDouble(args[1]) / Double.parseDouble(args[2])));
	      break;
	    case "MULTIPLICAR":
	      System.out.println("Operaçao De Multiplicar");
	      System.out.println("Resultado: " + (Double.parseDouble(args[1]) * Double.parseDouble(args[2])));
	      break;
	    case "SUBTRAIR":
	      System.out.println("Operaçao De Subtrair");
	      System.out.println("Resultado: " + (Double.parseDouble(args[1]) - Double.parseDouble(args[2])));
	      break;
	    default:
	      System.out.println("Operaçao não suportada");
	      break;
	  }
  
        
	 }else{
	    System.out.println("Pelo menos 3 parametros sao necessários!");
	 }
   }
}
