public class Produto {

    @Override
    public java.lang.String toString() {
        return String.format("Nome: %s - Codigo: %s - Valor: %.2f - Quantidade Vendida: %d", getNome(), getCodigo(), getValor(), getQtdVendida());
    }

    protected String nome;
    protected String codigo;
    protected double valor;
    protected int qtdVendida;

    public Produto(String nome, String codigo, double valor, int qtdVendida){
        this.nome=nome;
        this.codigo=codigo;
        this.valor=valor;
        this.qtdVendida=qtdVendida;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    public int getQtdVendida() {
        return qtdVendida;
    }
    public void setQtdVendida(int qtdVendida) {
        this.qtdVendida = qtdVendida;
    }

}
