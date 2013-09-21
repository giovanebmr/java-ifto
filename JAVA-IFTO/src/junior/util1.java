
public class util1 {

	/**
	 * @param args
	 */
	public boolean isNumero(String numero) {
		
		try {
			Integer.parseInt(numero);
			 return true;
		
		}catch (NumberFormatException e){
			return false;
		}
		// TODO Auto-generated method stub

	}
	
	public boolean isNumero2(String numero) throws NumberFormatException{
		Integer.parseInt(numero);
		return true;
		
	}

}
