import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class dishapp {
    //泛型
    static List<dish> dishList = new ArrayList<>();

    static List<dish> person = new ArrayList<>();



    public static void main(String[] args) {

        //int id;
        //dish dish1 = new dish(1,"鱼香肉丝",29.0 );
        //dish dish2 = new dish(2,"肉",50.0 );
        initdish();
        Scanner s = new Scanner(System.in);
        //扫描机器
        while (true) {
            showmenu();

            int num = s.nextInt(); //程序阻塞效果
            //System.out.println("输入的值：" + num);
            switch (num){
                case 1:
                    while (true){
                        showdish();
                        int id = s.nextInt();
                        if (id==0)
                            break;
                        dish dish = dishList.get(id - 1);
                        System.out.println(dish.name+",您点了");
                        person.add(dish);

                        //break;
                    }

                case 2:
                    showperson();
                    break;
                case 3:
                    buy();
                    return;
            }
        }








    }

    public static void showmenu(){
        System.out.println("--------------主菜单----------");
        System.out.println("菜单\t\t\t 1");
        System.out.println("已经点菜\t\t 2");
        System.out.println("买单\t\t\t 3");
        System.out.println("------根据编号请选择----------");
    }
    public static void showdish(){
        System.out.println("------请您点菜------");
        //遍历集合
        for (int i = 0; i < dishList.size(); i++) {
            dish dish = dishList.get(i);
            System.out.println(dish.id+"\t"+dish.name+"\t"+dish.price);
        }
        System.out.println("------输入序号点菜，0返回上一级------");
    }

    public static void showperson(){
        //遍历已经点菜集合
        for (dish dish : person){
            System.out.println(dish.id+"\t"+dish.name+"\t"+dish.price);
        }

    }

    public static void buy(){

        System.out.println("-----------正在结算----------");
        double totle=0.0;
        for (dish dish : person){ //price相加
            totle += dish.price;
        }
        System.out.println("本次消费："+totle+"元");

    }


    public static void initdish(){
        dish dish1 = new dish(1,"鱼香肉丝",29.0 );
        dishList.add(dish1);
        dish dish2 = new dish(2,"肉",50.0 );
        dishList.add(dish2);

        dishList.add(new dish(3,"凉菜",30.0));
    }

}
