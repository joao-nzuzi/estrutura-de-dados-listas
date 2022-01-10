package nzuzi.joao.listas.lista.encadeada;

public class ListaEncadeada<T> {

    No<T> referenciaEntrada;

    public ListaEncadeada() {
        this.referenciaEntrada = null;
    }

    public boolean isEmpty(){
        return referenciaEntrada == null ? true : false;
    }

    public int size(){
        int tamanho = 0;
        No<T> referenciaAuxiliar = referenciaEntrada;
        while (true){
            if(referenciaAuxiliar != null){
                tamanho++;
                if(referenciaAuxiliar.getProximoNo() != null){
                    referenciaAuxiliar = referenciaAuxiliar.getProximoNo();
                }else{
                    break;
                }
            }else{
                break;
            }
        }
        return tamanho;
    }

    public void add(T conteudo){
        No<T> novoNo = new No<T>(conteudo);
        if (this.isEmpty()){
            referenciaEntrada = novoNo;
            return;
        }

        No<T> noAux = referenciaEntrada;
        for (int i = 0; i < this.size() - 1; i++){
            noAux = noAux.getProximoNo();
        }

        noAux.setProximoNo(novoNo);
    }

    private void validateIndex(int index){
        if(index >= size()){
            throw new IndexOutOfBoundsException("Não existe informação para o índice "+index + ". Esta lista possui apenas " +(size()-1)+ " índice(s).");
        }
    }

    private No<T> getNo(int index){
        validateIndex(index);
        No<T> noAux = referenciaEntrada;
        No<T> retorno = null;
        for(int i = 0; i <= index; i++){
            retorno = noAux;
            noAux = noAux.getProximoNo();
        }
        return retorno;
    }

    public T get(int index){
        return getNo(index).getConteudo();
    }

    public T remove(int index){
        No<T> noReferencia = this.getNo(index);
        if(index == 0){
            referenciaEntrada = noReferencia.getProximoNo();
            return noReferencia.getConteudo();
        }

        No<T> noAnterior = getNo(index - 1);
        noAnterior.setProximoNo(noReferencia.getProximoNo());
        return noReferencia.getConteudo();
    }

    @Override
    public String toString(){
        String retorno = "";
        No<T> noAuxiliar = referenciaEntrada;
        for(int i = 0; i < this.size(); i++){
            retorno += "[" +noAuxiliar.getConteudo() + "], ";
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        retorno += "null";
        return retorno;
    }
}
