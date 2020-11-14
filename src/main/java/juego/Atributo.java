package juego;

public class Atributo {
    private String nombreAtributo;
    private int valor;

    public Atributo(String nombreAtributo, int valor){
        this.nombreAtributo = nombreAtributo;
        this.valor = valor;
    }
    public Atributo(){}

    public String getNombreAtributo() {
        return nombreAtributo;
    }

    public void setNombreAtributo(String nombreAtributo) {
        this.nombreAtributo = nombreAtributo;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public Atributo getCopiaAtr(){
        Atributo copia = new Atributo(this.nombreAtributo,this.valor);
        return copia;
    }


    @Override
    public boolean equals(Object obj) {
        try{
            Atributo otroAtr = (Atributo) obj;
            return this.getNombreAtributo().equals(otroAtr.getNombreAtributo());
        }
        catch (Exception e){
            return false;
        }
    }

    @Override
    public String toString() {
        return "("+ this.getNombreAtributo()+" : "+ this.getValor()+")";
    }
}
