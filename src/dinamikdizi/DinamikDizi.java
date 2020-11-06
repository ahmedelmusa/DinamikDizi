package dinamikdizi;
    // 1-Yazacağımız yeni dinamik dizi sınıfının ismi DinamikDizi olsun
public class DinamikDizi{
    // 2-Kolaylık açısından geliştireceğiniz dinamik diziniz int verileri ile işlem yapabilsin.
    private int array[];
    private int size;
    private int capacity;
     
    // 3-Dinamik dizi ilk yapıldığında varsayılan olarak 5 elemanlı (length i 5 olsun) olsun
    public DinamikDizi(){
        array = new int[5];
        size=0;
        capacity=5;
    }
     
    // 4-Dinamik diziye yeni bir veri girmek için ekle(veri) metodu tanımlanmalıdır.
    public void addElement(int element){
        if (size == capacity){
            ensureCapacity(5); 
        }
        array[size] = element;
        size++;
    }
    
    /* 4-Dinamik diziye yeni bir veriyi istenilen indekse  
    *  bırakabilmek için ekle(veri,index) metodu tanımlanmalıdır*/     
    public void addElement(int index, int element){
        
        if (size == capacity){
            ensureCapacity(2); 
        }

        for(int i=size-1;i>=index;i--){
            array[i+1] = array[i];
        }

        array[index] = element;
        size++;
    }
 
    // 5-indexten veri almak için
    public int getElement(int index){
        return array[index];
    }
     
    // 6-Dinamik diziden eleman silmek için sil(), sil(veri), sil(index) metodları tanımlanmaldır
    public void remove(int index){
        if(index>=size || index<0){
            System.out.println("No element at this index");
        }else{
            for(int i=index;i<size-1;i++){
                array[i] = array[i+1];
            }
            array[size-1]=0;
            size--;
        }
    }
     
    // 7-Dinamik dizinin kapasitesini öğrenebilmek için kapasite() metodu tanımlanmalıdır

    public void ensureCapacity(int minCapacity){
        int temp[] = new int[capacity*minCapacity];
        for (int i=0; i < capacity; i++){
            temp[i] = array[i];
        }
        array = temp;
        capacity = capacity * minCapacity;
    }
     
    /* 8-Dinamik diziden verileri sildikçe dizinin kapasitesini 
    de orantılı bir şekilde otomatik küçültmelisiniz*/
    public void trimToSize(){
        System.out.println("Trimming the array");
        int temp[] = new int[size];
        for (int i=0; i < size; i++){
            temp[i] = array[i];
        }
        array = temp;
        capacity = array.length;
         
    }
     
    /* 9-Dinamik dizinin uzunluğunu (size)
    öğrenebilmek için uzunluk() metodu tanımlanmalıdır.*/
    public int size(){
        return size;
    }
     
    /* 10-Dinamik dizinin uzunluğunu (capacity)
    öğrenebilmek için uzunluk() metodu tanımlanmalıdır.*/
    public int capacity(){
        return capacity;
    }
   
}
     
