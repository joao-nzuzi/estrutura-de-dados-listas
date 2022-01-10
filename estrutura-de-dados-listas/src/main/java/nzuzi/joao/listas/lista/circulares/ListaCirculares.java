package nzuzi.joao.listas.lista.circulares;

import nzuzi.joao.listas.lista.duplamente.encadeada.NoDuplo;

public class ListaCirculares<T> {

    private NoCircular<T> cabeca, cauda;
    private int tamanho;

    public ListaCirculares(){
        this.cauda = null;
        this.cabeca = null;
        this.tamanho = 0;
    }
    public boolean isEmpty(){
        return this.tamanho == 0 ? true : false;
    }

    public int size(){
        return this.tamanho;
    }

    private NoCircular<T> getNo(int index){
        if(this.isEmpty()){
            throw new IndexOutOfBoundsException("A lista está vazia");
        }

        if(index == 0){
            return this.cauda;
        }

        NoCircular<T> noAux = this.cauda;
        for(int i = 0; (i < index) && (noAux != null); i++){
            noAux = noAux.getProximoNo();
        }
        return noAux;
    }

    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    public void remove(int index){
        if (index >= this.tamanho){
            throw new IndexOutOfBoundsException("O índice é maior que o tamanho da lista.");
        }

        NoCircular<T> noAux = this.cauda;
        if(index == 0){
            this.cauda = cauda.getProximoNo();
            this.cabeca.setProximoNo(this.cauda);
        }else if(index == 1){
            this.cauda.setProximoNo(this.cauda.getProximoNo().getProximoNo());
        }else{
            for (int i = 0; i < index - 1; i++){
                noAux = noAux.getProximoNo();
            }
            noAux.setProximoNo(noAux.getProximoNo().getProximoNo());
        }
        this.tamanho--;
    }

    public void add(T conteudo){
        NoCircular<T> novoNo = new NoCircular<T>(conteudo);
        if(this.tamanho == 0){
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setProximoNo(cauda);
        }else{
            novoNo.setProximoNo(this.cauda);
            this.cabeca.setProximoNo(novoNo);
            this.cauda = novoNo;
        }
        this.tamanho++;
    }

    @Override
    public String toString(){
        String retorno = "";
        NoCircular<T> noAuxiliar = this.cauda;
        for(int i = 0; i < this.size(); i++){
            retorno += "[" +noAuxiliar.getConteudo() + "] --> ";
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        retorno += this.size() != 0 ? "(Retorna ao inicio)" : "[]";
        return retorno;
    }
}
