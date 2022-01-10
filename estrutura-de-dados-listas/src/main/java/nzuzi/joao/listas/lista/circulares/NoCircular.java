package nzuzi.joao.listas.lista.circulares;

public class NoCircular<T> {

    private T conteudo;
    private NoCircular<T> proximoNo;

    public NoCircular(T conteudo) {
        this.proximoNo = null;
        this.conteudo = conteudo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public NoCircular<T> getProximoNo() {
        return proximoNo;
    }

    public void setProximoNo(NoCircular<T> proximoNo) {
        this.proximoNo = proximoNo;
    }

    @Override
    public String toString() {
        return "NoCircular{" +
                "conteudo=" + conteudo +
                '}';
    }
}
