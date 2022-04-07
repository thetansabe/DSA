import java.util.Comparator;

class NameComparator implements Comparator{
    @Override
    public int compare(Object o1,Object o2){
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;

        String[] hoVaTen1 = s1.getName().split(" ");
        String[] hoVaTen2 = s2.getName().split(" ");

        String ten1 = hoVaTen1[hoVaTen1.length - 1];
        String ten2 = hoVaTen2[hoVaTen2.length - 1];
        
        Character kiTuDau1 = ten1.charAt(0);
        Character kiTuDau2 = ten2.charAt(0);

        if(kiTuDau1 > kiTuDau2) return 1; //s1 > s2
        if(kiTuDau1 < kiTuDau2) return -1; //s1 < s2
        return 0;
    }
}