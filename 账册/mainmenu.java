package cn.tx;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class mainmenu {

    //创建一个集合
    static List<bill> billList = new ArrayList<>();
    static {
        billList.add(new bill("工作收入","aaa",12,"支出","2022-06-01","工资"));
        billList.add(new bill("吃饭   ","aas",22,"收入","2022-05-01","干饭"));

    }
public static void showmain(){
    System.out.println("--------记账本--------------------------");
    System.out.println("1.添加账务   2.删除账务    3.查询账务    4.推出");
    System.out.println("请输入序号：");
}


    public static void main(String[] args) {
        r();
    }

    private static void r() {
        showmain();


        boolean flag = true;

        Scanner scanner = new Scanner(System.in);
        while (flag) {
            int num = scanner.nextInt();
            switch (num) {
                case 1:
                    System.out.println("添加账务");
                    addbill();
                    break;
                case 2:
                    System.out.println("删除账务");
                    delbill();

                    break;
                case 3:
                    System.out.println("查询账务");
                    select();
                    break;
                case 4:
                    System.out.println("退出");
                    flag=false;
                    break;
                default:
                    System.out.println("重新输入");

            }
        }
    }

    private static void delbill() {
        Scanner inScanner = new Scanner(System.in);
        int id = inScanner.nextInt();
        billList.remove(id-1);
        System.out.println("删除成功！！！");
        showmain();
    }

    private static void addbill() {
        Scanner inScanner = new Scanner(System.in);
        bill bills = new bill();
        bills.setName(inScanner.next());
        bills.getTotal(inScanner.next());
////等等
        billList.add(bills);     //加入集合中
        System.out.println("ok!!!!");
        showmain();
    }

    private static void select(){
        System.out.println("账务查询");
        System.out.println("1.全部遍历   2.时间查询   3.收入、支出查询");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        switch (num){
            case 1:
                selectall();
               break;
            case 2:
                selectdate();
                break;
            case 3:
                selecttype();
               break;

        }
        showmain();
    }

    private static void selecttype() {
        System.out.println("3");
        System.out.println("账务查询>>收入、支出查询");
        System.out.println("输入收入或者支出");
        Scanner scanner = new Scanner(System.in);
        //收入或者支出
        String type = scanner.next();

        billList.stream()
                     .filter(bill -> {
           String type1 = bill.getType();
           return type1.equals(type);
        }).collect(Collectors.toList());
        print(billList);
    }

    private static void selectdate() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        System.out.println("账务查询>>时间查询");

        Scanner scanner = new Scanner(System.in);
        System.out.println("输入开始时间");
        String start = scanner.next();

        System.out.println("输入结束时间");
        String end = scanner.next();

        billList.stream().filter(bill -> {
            final String time = bill.getTime();
            try {
               Date startDate= format.parse(start);
                Date endDate= format.parse(end);
                Date timeDate= format.parse(time);
                if (timeDate.before(endDate)&&timeDate.after(startDate)){
                    return true;
                }

            } catch (ParseException e) {
                e.printStackTrace();
            }
            return false;

        }).collect(Collectors.toList());
        print(billList);

    }

    private static void selectall() {
        System.out.println("所有查询");
        print(billList);
    }

    public static void print(List<bill>billList){
        System.out.println("ID\t\t类别\t\t\t类型\t\t\t金额\t\t\t时间\t\t\t备注");
        for (int i = 0; i < billList.size(); i++) {
            bill bills = billList.get(i);
            System.out.println(i+1+"\t\t"+bills.getName()+"\t\t"+bills.getAccount()+"\t\t"+bills.getType()+"\t\t"+bills.getTime()+"\t\t"+bills.getDesc());

        }

    }


}
