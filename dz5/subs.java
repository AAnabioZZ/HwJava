package dz5;
public class subs {
    public static void main(String[] args) {
        int[] a = new int[] {12,2,23,4,23,4,54,67,754,6463,535,34,345,3,54,53,5,534,535,6,45,76};
        int[] b = new int[] {12,2,535,34,345,3,54,53,5,23,4,23,4,54,67,754,6463,534,535,6,45,76};
    

        if i == j count++ i++,j++
        if i != j рекурс(i,j++)
    }
    
    public static void sudseq(int[] a,int[] b, int i, int j,int count) {
        int tempi=i;
        int tempj=j;
        while (i < a.length){
            if (b[j]==a[i]) {
                count++;
                sudseq(a, b, i+1, j+1, count);
            }else{
                i++;
            }
        }
        i=tempi;
        while (j < b.length){
            if (b[j]==a[i]) {
                count++;
                sudseq(a, b, i+1, j+1, count);
            }else{
                i++;
            }
        if (!finish){
            
        }
        }

        
    }
}
