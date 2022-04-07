import java.util.Arrays;

class Test{
    public static void main(String[] args) {
        Student std1 = new Student("Nguyen Van Hoang",7.0,8.2,6.5);
        Student std2 = new Student("Nguyen Van Thi Binh",9.2,8.2,8.5);
        Student std3 = new Student("Nguyen Van Tran Thi Dieu",7.0,8.2,4.5);
        Student std4 = new Student("Nguyen Van Hoang Cuong",7.2,7.2,7.8);
        Student std5 = new Student("Nguyen Van Anh",5.0,8.2,7.5);
        Student std6 = new Student("Nguyen Van Khoa",4.4,8.2,9.5);

        Student[] list = {std1,std2,std3,std4,std5,std6};
        for(int i = 0 ; i<list.length;i++){
            System.out.println(list[i]);
        }
        System.out.println("Sau khi sort theo AVG:");
        /////////////
        Arrays.sort(list, new StudentComparator());

        for(int i = 0 ; i<list.length;i++){
            System.out.println(list[i]);
        }

        System.out.println("Sau khi sort theo Ten:");
        //////////////////////
        Arrays.sort(list, new NameComparator());

        for(int i = 0 ; i<list.length;i++){
            System.out.println(list[i]);
        }
    }
}