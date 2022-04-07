class life{
    public static void main(String[] args) {
        int UCLN = 1;
        int mau = -14;
        int tu = -49;

        if(mau > tu){
            for(int i=2; i <= mau;i++){
                if((mau % i == 0) && (tu % i == 0)) {
                    UCLN = i;
                    System.out.println("mau > tu: "+i);
                } 
            }
            
        }else{
            for(int i=2; i <= tu;i++){
                if((mau % i == 0) && (tu % i == 0)){
                    UCLN = i;
                    System.out.println("Gia tri cua i: "+i);
                }
                System.out.println("Ngoai if ");

            }
        }
        System.out.println("Gia tri cua UCLN: "+UCLN);
    }
}