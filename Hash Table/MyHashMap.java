import java.util.ArrayList;

class MyHashMap{

    private class Data{
        int key;
        int value;

        public Data(int key, int val){
            this.key = key;
            this.value = val;
        }

        //cho nay sieu quan trong.
        //khi goi. indexOf, remove cua arr list no': mac dinh no' se check equals ca key lan value
        //=> override equals de no' chi check key thoi 
        public boolean equals(Object other){
            if(other instanceof Data)
                return this.key == ((Data) other).key;
            return false;
        }
    }

    private final int SIZE = 1000;
    private ArrayList<Data>[] myBuckets;

    MyHashMap(){
        myBuckets = new ArrayList[SIZE];
        
        for(int i=0; i<SIZE;i++){
            myBuckets[i] = new ArrayList<>();
        }
    }

    public int hashFunction(int key){
        return key % SIZE;
    }

    public void put(int key, int value){
        //tim hashIndex -> tim vi. tri' Data trong arr list -> check xem ton tai chua
        int hashIndex = hashFunction(key);
        ArrayList<Data> bucket = myBuckets[hashIndex];
        Data keyForAdd = new Data(key,value);
        int keyIndex = bucket.indexOf(keyForAdd);

        if(keyIndex >= 0){ //key nay da ton tai -> cap nhat value
            bucket.get(keyIndex).value = keyForAdd.value; //get nay` la cua array list
        }else{ //key chua ton tai -> add moi
            bucket.add(keyForAdd);
        }
    }

    public void remove(int key){
        int hashIndex = hashFunction(key);
        ArrayList<Data> bucket = myBuckets[hashIndex];
        Data keyBeRemoved = new Data(key,0);
        bucket.remove(keyBeRemoved);
    }

    public int get(int key){ //get value cua key
        int hashIndex = hashFunction(key);
        ArrayList<Data> bucket = myBuckets[hashIndex];
        Data keyForGet = new Data(key,0);
        int keyIndex = bucket.indexOf(keyForGet);

        if(keyIndex >= 0) return bucket.get(keyIndex).value;
        return -1;
    }

}