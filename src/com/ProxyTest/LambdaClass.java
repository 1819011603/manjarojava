package com.ProxyTest;


import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaClass {
    static List<String> p = new ArrayList<>();

    //函数式接口参数
    static void lambdaInterfaceDemo(LambdaFunctionalInterface i){
        p.add("sss");
        p.add("a1");
        p.add("b1");
        p.forEach(i::f);
    }

    public static void printList(List<? extends Number> list){
        System.out.println(list);
    }

    public static void get(List<? super Integer> list){
        list.add(1);
        list.add(2);
        System.out.println(list);
    }

    public static void main(String[] args) {
//        Stream<String> stream = Stream.of("黄药师", "冯蘅", "郭靖", "黄蓉", "郭芙", "郭襄", "郭破虏");
//
//        stream.filter(x -> x.startsWith("郭")).forEach(System.out::println);
//        stream = Stream.of("黄药师", "冯蘅", "郭靖", "黄蓉", "郭芙", "郭襄", "郭破虏");
//        stream.limit(2).forEach(System.out::println);
//        stream = Stream.of("黄药师", "冯蘅", "郭靖", "黄蓉", "郭芙", "郭襄", "郭破虏");
//        stream.skip(5).forEach(System.out::println);
        Stream<Integer> stream = Stream.of(1, -2, -3, 4, -5);
        stream.map(Math::abs).forEach(System.out::println);
        stream = Stream.of(1, -2, -3, 4, -5);
        stream.map(x->x*x).forEach(System.out::println);
        ArrayList<String> manArray = new ArrayList<>();
        manArray.add("刘德华");
        manArray.add("成龙");
        manArray.add("吴彦祖");
        manArray.add("周润发");
        manArray.add("周星驰");
        manArray.add("吴京");

        ArrayList<String> womanList = new ArrayList<>();
        womanList.add("林心如");
        womanList.add("孙俪");
        womanList.add("柳岩");
        womanList.add("林青霞");
        womanList.add("王祖贤");
        womanList.add("张曼玉");
        class Actor{
            String name;

            public Actor(String name) {
                this.name = name;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "Actor{" +
                        "name='" + name + '\'' +
                        '}';
            }
        }
        Stream.concat(manArray.stream().filter(x->x.length()==3).limit(3),womanList.stream().filter(x->x.startsWith("林")).skip(1)).map(Actor::new).forEach(System.out::println);

        List<String> list = Arrays.asList("java", "JAVAse", "javaee", "html", "css", "JavaScript");
        list.stream().filter(x->!x.toLowerCase().startsWith("java")).forEach(System.out::println);

        List<String> strings = Arrays.asList("123", "123456", "abcdef", "abc123", "ab123cd", "7654321", "123abc", "123s456", "123456789123");

        strings.stream().filter(x-> {
            boolean f = x.length() >=5 && x.length()<=10;
            if(!f)return false;
            for (int i = 0; i < x.length(); i++){
                char c = x.charAt(i);
                if(c < '0' || c > '9')return false;
            }
            return true;
        }).forEach(System.out::println);
        Map<String,Integer> map = new HashMap<>();
        map.put("张三",85);
        map.put("李四",80);
        map.put("王五",90);
        map.put("赵六",95);
        map.put("田七",70);
        map.values().stream().collect(Collectors.toList()).stream().reduce(Integer::sum).ifPresent(x-> System.out.println(x/map.size()));

        String[] arr = {"河北省", "山西省", "吉林省", "辽宁省",
                "黑龙江省", "陕西省", "甘肃省", "青海省", "山东省",
                "福建省", "浙江省", "台湾省", "河南省", "湖北省",
                "湖南省", "江西省", "江苏省", "安徽省", "广东省",
                "海南省", "四川省", "贵州省", "云南省", "北京市",
                "天津市", "上海市", "重庆市", "内蒙古自治区",
                "新疆维吾尔自治区", "宁夏回族自治区", "广西壮族自治区",
                "西藏自治区", "香港特别行政区", "澳门特别行政区"};
        System.out.println(Arrays.stream(arr).filter(x->x.contains("省") && x.length() == 3).count());
        System.out.println(Arrays.stream(arr).filter(x->x.contains("省") && (x.indexOf('东')!= -1 || x.indexOf('南')!=-1 ||x.indexOf('西')!=-1 ||x.indexOf('北')!=-1 )).count());
        Arrays.stream(arr).filter(x-> !x.contains("区") && !x.contains("市")).filter(x->  x.indexOf('东')!= -1 || x.indexOf('南')!=-1 ||x.indexOf('西')!=-1 ||x.indexOf('北')!=-1 ).forEach(System.out::println);
        String[] strings1 = Arrays.stream(arr).filter(x -> x.contains("区") || x.contains("市")).toArray(String[]::new);
        System.out.println(Arrays.toString(strings1));

        long count = Stream.of(arr).filter(s -> s.endsWith("省")).filter(s -> s.length() == 3).count();
        System.out.println("三个字的省份有："+count+"个");

        long cou = Stream.of(arr).filter(s -> s.endsWith("省"))
                .filter(s -> s.contains("东") || s.contains("南") || s.contains("西") || s.contains("北")).count();

        System.out.println("名字中包含方位名词的省份有："+cou+"个");

        System.out.println("名字中包含方位名词的普通省份：");
        Stream.of(arr).filter(s -> s.endsWith("省")).filter(s -> s.contains("东") || s.contains("南") || s.contains("西") || s.contains("北")).forEach(System.out::println);

        System.out.println();
        String[] stringss = Stream.of(arr).filter(s -> s.endsWith("市") || s.endsWith("自治区") || s.endsWith("行政区")).toArray(String[]::new);
        System.out.println("特殊省份分别是：");
        for (String string : stringss) {
            System.out.println(string);
        }



    }
}
