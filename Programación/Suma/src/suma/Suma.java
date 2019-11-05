
package suma;


public class Suma {
    
    private int kilos = 0, llenadoCompleto = 0,
        TipodeRopa = 0, LavadoCompleto = 0, SecadoCompleto = 0;
    
    public Suma(int kilos, int TipodeRopa){
        this.kilos = kilos;
        this.TipodeRopa = TipodeRopa;
    }
    
    private void Llenado(){
        if(kilos <= 12 ){
            llenadoCompleto = 1;
            System.out.println("Llenando...");
            System.out.println("Llenado completo.");
        } else {
            System.out.println("Es mucha ropa, reduce la cantidad");
        }
    }
    
    private void Lavado(){
        Llenado();
        if (llenadoCompleto == 1) {
            if (TipodeRopa == 1) {
                System.out.println("Ropa Blanca / Lavado suave");
                System.out.println("Lavando...");
                LavadoCompleto = 1;
            }else if(TipodeRopa == 2){
                System.out.println("Ropa de color / Lavado intenso");
                System.out.println("Lavando...");
                LavadoCompleto = 1;
            } else {
                System.out.println("El tipo de ropa no esta disponible");
                System.out.println("Se lavara como ropa de color / Lavado intenso");
                LavadoCompleto = 1;
            }
        }
    }
    
    private void Secado (){
        Lavado();
        if(LavadoCompleto == 1 ){
            System.out.println("Secando...");
            SecadoCompleto = 1;
        }
    }
    
    public void CicloFinalizado(){
        Secado();
        if (SecadoCompleto == 1 ) {
            System.out.println("Tu ropa esta lista");
        }
    }
    
    
    public int getTipodeRopa(){
        return TipodeRopa;
    }
    
    public void setTipodeRopa(int TipodeRopa){
        this.TipodeRopa = TipodeRopa;
    }
    
}
