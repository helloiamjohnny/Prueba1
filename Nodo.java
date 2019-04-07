import java.util.Optional;
 
public class Nodo {
    private Integer valor;
    private Nodo izq;
    private Nodo Der;
 
    public Nodo(Integer valor) {
        this.valor = valor;
    }
 
    public Integer getValor() {
        return valor;
    }
 
    public void setValor(Integer valor) {
        this.valor = valor;
    }
 
    public Nodo getIzq() {
        return izq;
    }
 
    public void setIzq(Nodo izq) {
        this.izq = izq;
    }
 
    public Nodo getDer() {
        return Der;
    }
 
    public void setDer(Nodo Der) {
        this.Der = Der;
    }
 
    public void agregar(Integer valor) {
        if (valor < this.valor) {
            if (izq != null) {
                izq.agregar(valor);
            } else {
                izq = new Nodo(valor);
                           }
        } else {
            if (Der != null) {
                Der.agregar(valor);
            } else {
                Der = new Nodo(valor);
            }
        }
    }
 
    
 
    public void ImprimirInOrder() {
        if (izq != null) {
            izq.ImprimirInOrder();
        }
        System.out.println(valor);
        if (Der != null) {
            Der.ImprimirInOrder();
        }
    }

 
    public Nodo Encontrarpredecesor() {
        if (this.getDer() == null) {
            return this;
        } else {
            return this.getDer().Encontrarpredecesor();
        }
    }
 
    public Nodo Encontrarsucesor() {
        if (this.getIzq() == null) {
            return this;
        } else {
            return this.getIzq().Encontrarsucesor();
        }
    }
 
 
    public Nodo eliminar(Integer valor) {
        Nodo respuesta = this;
        if (valor < this.valor) {            this.izq = this.izq.eliminar(valor);        } else if (valor > this.valor) {
            this.Der = this.Der.eliminar(valor);
        } else {
            if (this.izq != null && this.Der != null) {
                Nodo temp = this;
                Nodo maxOfTheizq = this.izq.Encontrarsucesor();
                this.valor = maxOfTheizq.getValor();
                temp.izq = temp.izq.eliminar(maxOfTheizq.getValor());
            } else if (this.izq != null) {
                respuesta = this.izq;
            } else if (this.Der != null) {
                respuesta = this.Der;
            } else {
                respuesta = null;
            }
        }
        return respuesta;
    }
 
    @Override
    public String toString() {
        return "Node [valor=" + valor + ", izq=" + izq + ", Der=" + Der + "]";
    }
    public Optional<Nodo> find(Integer valor) {
        if (valor == this.valor) {
            return Optional.of(this);
        } else if (valor < this.valor) {
            if (this.izq != null) {
                return this.izq.find(valor);
            } else {
                return Optional.empty();
            }
        } else {
            if (this.Der != null) {
                return this.Der.find(valor);
            } else {
                return Optional.empty();
            }
        }
    }
 
}
