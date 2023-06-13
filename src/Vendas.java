import java.time.LocalDate;

public class Vendas {
    
    @Override
    public String toString() {
        return String.format("Data: %s - Produto: %s - Quantidade Vendidas: %d", data, getPdt(), getQtdv());
    }

    protected LocalDate data;
    protected Produto pdt;
    protected int qtdv;

    public Vendas(LocalDate data, Produto pdt, int qtdv){
        this.data = data;
        this.pdt = pdt;
        this.qtdv = qtdv;
    }

    public Vendas(LocalDate date, String produtoVendido, int quantidadevendida, double valortotal) {
    }

    public Produto getPdt() {
        return pdt;
    }
    public void setPdt(Produto pdt) {
        this.pdt = pdt;
    }
    public int getQtdv() {
        return qtdv;
    }
    public void setQtdv(int qtdv) {
        this.qtdv = qtdv;
    }

}
