public class CartaoDeCredito{
  
  private double Saldo;
  private double Limite;
  
  public CartaoDeCredito(double saldo, double limite){
    this.Saldo = saldo;
    this.Limite = limite;
  }
  
  public void setSaldo(double saldo){
    this.Saldo = saldo;
  }
  
  public void setLimite(double limite){  
    this.Limite = limite;
  }
  
  public double getSaldo(){
    return this.Saldo;
  }
  
  public void comprar(){};
  
  public void sacar (){};
  
}