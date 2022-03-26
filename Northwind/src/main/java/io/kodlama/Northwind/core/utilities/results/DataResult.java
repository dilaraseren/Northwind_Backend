package io.kodlama.Northwind.core.utilities.results;

public class DataResult<T> extends Result {

   private T data;
    public DataResult(T data,boolean success, String message) {
        super(success, message);  //super:base sınıfın constructorlarını çalıştırır.
        this.data=data;
    }

    public DataResult(T data,boolean success) {
        super(success);
        this.data=data;
    }

    public T getData(){
        return this.data;
    }


}
