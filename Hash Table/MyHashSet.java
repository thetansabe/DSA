import java.util.ArrayList;
//Day la set => value tuong ung voi' index chinh la key
class MyHashSet{
    private final int SIZE = 1000;
    private ArrayList<Integer>[] myBuckets;
    
    //constructor
    MyHashSet(){
        //myBuckets la 1 array. 
        myBuckets = new ArrayList[SIZE]; //CHU Y cach tao 1 arr chua nh` array list
        //Tao array list cho tung phan tu trong buckets
        for (int i = 0; i < SIZE; i++) {
            myBuckets[i] = new ArrayList<Integer>();
        }
    }

    private int hashFunction(int key){
        return key % SIZE;
    }

    public boolean contains(int key){
        //hashIndex -> index gan lien voi' value
        int hashIndex = hashFunction(key);
        
        //CHU Y doan nay dung var (bucket la 1 array list)
        ArrayList<Integer> bucket = myBuckets[hashIndex];
        
        //Kiem tra ton tai chua
            //keyIndex la index cua cai' value(key) nam trong array list
        int keyIndex = bucket.indexOf(key);

        return keyIndex >= 0; 
        //neu true => keyIndex co' ton` tai.
        //=> co value (key) trong array list
        //=> CANNOT add
        //=> CAN remove
    }



    public void add(int key){
        int hashIndex = hashFunction(key);
        ArrayList<Integer> bucket = myBuckets[hashIndex];
        int keyIndex = bucket.indexOf(key);
        
        //convert tu key ra hashIndex -> tim trong arrlist -> add(key)
        if(keyIndex < 0) bucket.add(key);
    }

    public void remove(int key){
        int hashIndex = hashFunction(key);
        ArrayList<Integer> bucket = myBuckets[hashIndex];
        int keyIndex = bucket.indexOf(key);

        //convert tu key ra hashIndex -> tim trong array list -> .remove(index)
        if(keyIndex >= 0)
            bucket.remove(keyIndex);
        else
            System.out.println("Key not found");
    }

    public static void main(String[] args) {
        MyHashSet mySet = new MyHashSet();
        mySet.add(1);
        mySet.add(1);
        mySet.add(3);
        mySet.add(4);
        
        mySet.remove(1);
        
        mySet.remove(3);
        mySet.remove(4);
    }
}