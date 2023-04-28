import java.util.ArrayList;
/**Clase publica para la ejecucion del código completo*/
public class Tarea1{
    public static void main(String[] args) {
        Expendedor exp = new Expendedor(4, 1000);
        Moneda m = null;
        Comprador c = null;

/**Bebida que NO vende*/
        m = new Moneda500();
        c = new Comprador(m, 657, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// null $500
        m = new Moneda500();
        c = new Comprador(m, 657, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// null $500
        m = new Moneda500();
        c = new Comprador(m, 657, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// null $500
        m = new Moneda500();
        c = new Comprador(m, 657, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// null $500

/**trata de comprar SIN Moneda*/
        m = null;
        c = new Comprador(m, Expendedor.SPRITE, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// null $0
        m = null;
        c = new Comprador(m, Expendedor.SPRITE, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// null $0
        m = null;
        c = new Comprador(m, Expendedor.SPRITE, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// null $0
        m = null;
        c = new Comprador(m, Expendedor.SPRITE, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// null $0

/*con dinero JUSTO para el precio*/
        m = new Moneda1000();
        c = new Comprador(m, Expendedor.COCA, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// cocacola $0
        m = new Moneda1000();
        c = new Comprador(m, Expendedor.COCA, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// cocacola $0
        m = new Moneda1000();
        c = new Comprador(m, Expendedor.COCA, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// cocacola $0
        m = new Moneda1000();
        c = new Comprador(m, Expendedor.COCA, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// cocacola $0

/**con MENOS dinero que el precio*/
        m = new Moneda500();
        c = new Comprador(m, Expendedor.SPRITE, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// null $500
        m = new Moneda500();
        c = new Comprador(m, Expendedor.SPRITE, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// null $500
        m = new Moneda500();
        c = new Comprador(m, Expendedor.SPRITE, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// null $500
        m = new Moneda500();
        c = new Comprador(m, Expendedor.SPRITE, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// null $500

/**con MAS dinero que el precio*/
        m = new Moneda1500();
        c = new Comprador(m, Expendedor.SPRITE, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// sprite $500
        m = new Moneda1500();
        c = new Comprador(m, Expendedor.SPRITE, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// sprite $500
        m = new Moneda1500();
        c = new Comprador(m, Expendedor.SPRITE, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// sprite $500
        m = new Moneda1500();
        c = new Comprador(m, Expendedor.SPRITE, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// sprite $500

/**Deposito VACIO*/
        m = new Moneda1500();
        c = new Comprador(m, Expendedor.SPRITE, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// null $1500
        m = new Moneda1500();
        c = new Comprador(m, Expendedor.SPRITE, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// null $1500
        m = new Moneda1500();
        c = new Comprador(m, Expendedor.SPRITE, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// null $1500
        m = new Moneda1500();
        c = new Comprador(m, Expendedor.SPRITE, exp);
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());// null $1500
        System.out.println(c.queBebiste() + ", " + c.cuantoVuelto());//// null $1500
    }

}
/**clase expendedor que recrea un expendedor, el cual funciona creando depositos de bebidas, uno de monedas, y agregando bebidas...*/
class Expendedor{
    private Deposito coca;
    private Deposito sprite;
    private Deposito monVu;
    public static final int COCA=1; 
    public static final int SPRITE=2;
    private int precios=0;
    private int vuelto=0;
    private int depositos=0;
   
    public Expendedor(int bebidas, int precioBebidas) {
        coca = new Deposito();
        sprite = new Deposito();
        monVu = new Deposito();
        precios= precioBebidas;

        for (int i = 0; i < bebidas; i++) {//si el numero de bebidas es 0, no se agregan bebidas
            coca.addBebida(new CocaCola(100 + i));
            sprite.addBebida(new Sprite(200 + i));
        }
    }

    public Bebida comprarBebida(Moneda m, int codigo) { 
        if (m == null) {//si la moneda no es valida
            return null;
        }
        else if (precios > m.getSerie().getValor()) { //si los precios son mayores al valor de la moneda, se almacena la moneda y retorna null
            monVu.addMoneda(m);
            
        } else if (precios <= m.getSerie().getValor()) {//si los precios son menores a la moneda, se almacena el vuelto y se ve los casos para la bebida
           if(coca.size()==0) precios=0;
           else if (sprite.size()==0) precios=0; 
            vuelto=m.getSerie().getValor() - precios;
            int numLoops= vuelto/100;
            for(int i=0;i<numLoops;i++){
                monVu.addMoneda(new Moneda100());
            }

            switch (codigo) {
                case COCA:
                    return coca.getBebida();
                case SPRITE:
                    return sprite.getBebida();
                default:
                    return null;
            }
        }
        return null;
    }
    
    public Moneda getVuelto(){
        Moneda mon1= monVu.getMoneda();
        if(mon1==null) return null;
        else return mon1;
    }
}


class Deposito{
    private ArrayList<Bebida> be;
    private ArrayList<Moneda> mon;
    
    public Deposito() {
       this.be = new ArrayList<Bebida>();//deposito bebida
       this.mon= new ArrayList<Moneda>();//deposito moneda
    }
    
    public void addBebida(Bebida bebida){
        be.add(bebida);
    }
    
    public int size(){
        return be.size();
    }
    
    public Bebida getBebida(){
       int tam= be.size();
       if(tam!=0){ 
       Bebida b= be.remove(0);
       return b;
       }else{
           return null;
       }
    }
    
    public void addMoneda(Moneda moneda){
        mon.add(moneda);
    }
    
    public Moneda getMoneda(){
       int tam= mon.size();
       if(tam!=0){ 
       Moneda mo= mon.remove(0);
       return mo;
       }else{
           return null;
       }
    } 
}

/*******Comprador*******/
class Comprador{
    private String sonido;
    private int vuelto=0;

    public Comprador(Moneda m, int cualBebida, Expendedor exp) {//1500,1400
        
        Bebida beb=exp.comprarBebida(m, cualBebida);
        
        if(beb!=null){
            sonido= beb.beber();
        }
        
        Moneda monedin= exp.getVuelto();
        
         while(monedin != null){
            this.vuelto= vuelto + monedin.getValor();
            monedin=exp.getVuelto();
        }
    }
    
    public int cuantoVuelto(){
        return vuelto;
    }
    
    public String queBebiste(){
        return sonido;
    }
}




/********Bebida********/
abstract class Bebida{//no se puede instanciar directamente
    private int serie;
    
    public Bebida(int prueba){
       this.serie=prueba;
    }

    public int getSerie(){
       return serie;
    }

    public abstract String beber();   
}

//"sabor: "+"sprite";
class Sprite extends Bebida{
    public Sprite(int serie){
        super(serie);
    }
    @Override
    public String beber(){
        return "sprite";
    }
}

class CocaCola extends Bebida{
    public CocaCola(int serie){
        super(serie);
    }
    @Override
    public String beber(){
        return "cocacola";
    }
}

/*********Monedas***********/
abstract class Moneda{

    public Moneda() {
       
    }  
    public Moneda getSerie(){
        return this;
    }
    public abstract int getValor();
}

class Moneda1500 extends Moneda{
    public Moneda1500() {
       super();
    }  
    @Override
    public int getValor(){
        return 1500;
    }
}
class Moneda1000 extends Moneda{
    public Moneda1000() {
       super();
    }
    @Override
    public int getValor(){
        return 1000;
    }
}
class Moneda500 extends Moneda{

    public Moneda500() {
       super();
    } 
    @Override
    public int getValor(){
        return 500;
    }
}
class Moneda100 extends Moneda{
    public Moneda100() {
       super();
    }
    @Override
    public int getValor(){
        return 100;
    }
}


