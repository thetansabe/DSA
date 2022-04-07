import java.util.Comparator;

class StudentComparator implements Comparator{
    @Override
    public int compare(Object o1,Object o2){
        Student s1 = (Student) o1;
        Student s2 = (Student) o2;

        //tang dan
        double hieu = s1.avg() - s2.avg();

        if(hieu > 0) return 1; //s1 > s2
        if(hieu < 0) return -1; //s1 < s2
        return 0;
    }
}