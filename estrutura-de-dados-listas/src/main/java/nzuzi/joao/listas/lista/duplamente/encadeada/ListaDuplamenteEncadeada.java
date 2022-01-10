package nzuzi.joao.listas.lista.duplamente.encadeada;

import nzuzi.joao.listas.lista.encadeada.No;

public class ListaDuplamenteEncadeada<T> {

    private NoDuplo<T> primeiroNo, ultimoNo;
    private int tamanho = 0;

    public ListaDuplamenteEncadeada(){
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanho = 0;
    }

    public int size(){
        return tamanho;
    }

    private NoDuplo<T> getNo(int index){
        NoDuplo<T> noAux = primeiroNo;
        for(int i = 0; (i < index) && (noAux != null); i++){
            noAux = noAux.getProximoNo();
        }
        return noAux;
    }

    public T get(int index){
        return getNo(index).getConteudo();
    }

    public void add(T elemento){
        NoDuplo<T> novoNo = new NoDuplo<T>(elemento);
        novoNo.setProximoNo(null);
        novoNo.setNoAnterior(ultimoNo);
        if(primeiroNo == null){
            primeiroNo = novoNo;
        }
        if(ultimoNo != null){
            ultimoNo.setProximoNo(novoNo);
        }
        ultimoNo = novoNo;
        tamanho++;
    }

    public void add(int index, T elemento){
        NoDuplo<T> noAuxiliar = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<T>(elemento);
        novoNo.setProximoNo(noAuxiliar);

        if(novoNo.getProximoNo() != null){
            novoNo.setNoAnterior(noAuxiliar.getNoAnterior());
            novoNo.getProximoNo().setNoAnterior(novoNo);
        }else{
            novoNo.setNoAnterior(ultimoNo);
            ultimoNo = novoNo;
        }

        if(index == 0){
            primeiroNo = novoNo;
        }else{
            novoNo.getNoAnterior().setProximoNo(novoNo);
        }

        tamanho++;
    }

    public void remove(int index){
        if(index == 0){
            primeiroNo = primeiroNo.getProximoNo();
            if(primeiroNo != null){
                primeiroNo.setNoAnterior(null);
            }
        }else{
            NoDuplo<T> noAuxiliar = getNo(index);
            noAuxiliar.getNoAnterior().setProximoNo(noAuxiliar.getProximoNo());
            if(noAuxiliar != ultimoNo){
                noAuxiliar.getProximoNo().setNoAnterior(noAuxiliar.getNoAnterior());
            }else{
                ultimoNo = noAuxiliar;
            }
        }
        this.tamanho--;
    }

    @Override
    public String toString(){
        String retorno = "";
        NoDuplo<T> noAuxiliar = primeiroNo;
        for(int i = 0; i < this.size(); i++){
            retorno += "[" +noAuxiliar.getConteudo() + "], ";
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        retorno += "null";
        return retorno;
    }
}
