
import java.util.ArrayList;
import java.util.Random;

public class Matr {

    Random random = new Random();

    ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>();

    int arithmetic1;
    int arithmetic2;


    public Matr(int size,int min,int max){
        infill(size,min,max);
        output(size);
        getMainD(size);
        getSideD(size);
        if(arithmetic1 > arithmetic2){
            setItemValue(size/2,size/2,arithmetic1);
            System.out.println("Новая мтарица");
            output(size);
        }

        if(arithmetic1 < arithmetic2){
            setItemValue(size/2,size/2,arithmetic2);
            System.out.println("Новая матрица");
            output(size);
        }

    }

    public void infill(int size,int min,int max){

        for(int i=0; i < size; i++){
            matrix.add(i,new ArrayList<>());
        }
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                matrix.get(i).add(random.nextInt(max - min + 1) + min);
            }
        }
    }


    public void output(int size){
        for(int r=0; r < size; r++){
            System.out.println();
            for(int c=0;c<size;c++){
                System.out.printf("%3d ", matrix.get(r).get(c));
            }
        }

    }

    public void getMainD(int size) {
        int sum = 0;
        for(int i=0; i < size; i++) {
            sum += matrix.get(i).get(i);
        }
        arithmetic1 = sum/size;
        System.out.println("\nСреднее-арифметическое главной диагонали: "+ arithmetic1);
    }

    public void getSideD(int size) {
        int sum = 0;
        for(int i=0,t = size-1; i < size; i++,t--) {
            sum += matrix.get(i).get(t);
        }
        arithmetic2 = sum/size;
        System.out.println("Среднее-арифметическое побочной диагонали: " + arithmetic2 + "\n");
    }


    public Integer setItemValue(int x, int y, int value)
    {
        return matrix.get(x).set(y,value);
    }

    public int getItemValue(int x,int y)
    {
        return matrix.get(x).get(y);
    }
}