package com.example.simples.sm.web.jdk8;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Locale;

public class Main {

    public static void main(String[] args) {
        //		List<Integer> nums=new ArrayList<>();
        //		Collections.addAll(nums, 1, 2, 6, 3, 5);

//        Comparator<Integer> c = (Integer n1, Integer n2) -> n1.compareTo(n2);
//        int result = c.compare(1, 0);
//        System.out.println(result);

        //		Collections.sort(nums, (Integer n1, Integer n2) -> n1.compareTo(n2));
        //		nums.forEach(n -> System.out.println(n));
        //
        //		List<String> list = Arrays.asList("Hello", "JDK8", "and", "Lambda");
        //		List<String> newList = list.stream().map(s -> s.toLowerCase()).collect(Collectors.toList());
        //		newList = list.stream().map(String::toLowerCase).collect(Collectors.toList());
        //		newList.forEach(s -> System.out.println(s));
        //		String str = list.stream().map(String::toLowerCase).collect(Collectors.joining(","));
        //		System.out.println(str);

        //		// guava
        //		ArrayList<Integer> list2 = Lists.newArrayList(1, 2, 3);
        //		String str2 = Joiner.on(",").join(list2);
        //		System.out.println(str2);

//        JSONArray arr = new JSONArray();
//        arr.add("1");
//        arr.add("2");
//        String str3 = Joiner.on(",").join(arr);
//        System.out.println(str3);

        // 使用lambda表达式简化匿名内部类的书写
//        int num = 1;
        // 访问权限
        // 我们可以访问lambda表达式外部的final局部变量,变量num并不需要一定是final, 但是在编译的时候被隐式地当做final变量来处理.
        // 在lambda表达式的内部能获取到对成员变量或静态变量的读写权
//        Converter<String, Integer> converter = (from) -> Integer.valueOf(from + num);
        // 使用::引用静态方法
//        Converter<String, Integer> converter = Integer::valueOf;
//        Integer converted = converter.convert("123");
//        System.out.println(converted);    // 123

        // 使用::引用对象方法
//        Something something = new Something();
//        Converter<String, String> converter = (s) -> {
//            return something.startsWith(s);
//        };
////        Converter<String, String> converter = something::startsWith;
//        String converted = converter.convert("Java");
//        System.out.println(converted);    // "J"

        // JDK 1.8 API中包含了很多内置的函数式接口
//        Consumer<Person> greeter = (p) -> System.out.println("Hello, " + p.firstName);
//        greeter.accept(new Person("Luke", "Skywalker"));
//        greeter.accept(new Person("tian", "yi"));

        // streams
//        List<String> strings = Arrays.asList("s12", "2", "s35", "ss");
//        strings.stream()
//                .sorted((a, b) -> a.length() - b.length())
//                .map(String::toUpperCase)
//                .filter((a) -> a.startsWith("S"))
//                .forEach((i) -> System.out.println(i));
//
        // 将任何数量的字符串连接为一个字符串。
//        String join = String.join(":", strings);
//        System.out.println(join);

        // 从字符串所有字符创建数据流，所以你可以在这些字符上使用流式操作
//        String collect = "foobar:foo:bar"
//                .chars()
//                .distinct()
//                .mapToObj(c -> String.valueOf((char) c))
//                .sorted()
//                .collect(Collectors.joining());
//        System.out.println(collect);

        newDateApiTest();

    }

    public static void newDateApiTest() {
        // 时间日期API
        Clock clock = Clock.systemDefaultZone();
        long millis = clock.millis();
        System.out.println(millis);

        Instant instant = clock.instant();
        Date legacyDate = Date.from(instant);
        System.out.println(legacyDate);

        System.out.println(ZoneId.getAvailableZoneIds());

        ZoneId zone1 = ZoneId.of("Asia/Shanghai");
        ZoneId zone2 = ZoneId.of("Asia/Bangkok");
        System.out.println(zone1.getRules());
        System.out.println(zone2.getRules());

        LocalTime now1 = LocalTime.now(zone1);
        LocalTime now2 = LocalTime.now(zone2);

        System.out.println(now1.isBefore(now2)); // false

        long hoursBetween = ChronoUnit.HOURS.between(now1, now2);
        long minutesBetween = ChronoUnit.MINUTES.between(now1, now2);

        System.out.println(hoursBetween);       // -1
        System.out.println(minutesBetween);     // -60

        LocalTime late = LocalTime.of(23, 59, 59);
        System.out.println(late);       // 23:59:59

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

        // LocalTime只表示时间,不包含日期
        LocalTime leetTime = LocalTime.parse("2018-01-11 11:12:13", dateTimeFormatter);
        System.out.println(leetTime);

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate yesterday = tomorrow.minusDays(2);

        LocalDate independenceDay = LocalDate.of(2014, Month.JULY, 4);
        DayOfWeek dayOfWeek = independenceDay.getDayOfWeek();
        System.out.println(dayOfWeek);

        // LocalDate只表示时间,不包含时间
        LocalDate date = LocalDate.parse("2018-01-11 11:12:13", dateTimeFormatter);
        System.out.println(date);

        // LocalDateTime表示的是日期-时间
        LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);

        sylvester = LocalDateTime.parse("2018-01-11 11:12:13", dateTimeFormatter);
        System.out.println(sylvester);

        dayOfWeek = sylvester.getDayOfWeek();
        System.out.println(dayOfWeek);

        Month month = sylvester.getMonth();
        System.out.println(month);

        long minuteOfDay = sylvester.getLong(ChronoField.MINUTE_OF_DAY);
        System.out.println(minuteOfDay);

        // LocalDateTime转成java.util.Date
        instant = sylvester
                .atZone(ZoneId.systemDefault())
                .toInstant();

        legacyDate = Date.from(instant);
        System.out.println(legacyDate);
    }


}

/**
 * 函数式接口:
 * 1. 一个所谓的函数式接口必须要有且仅有一个抽象方法声明
 * 2. 你应当在接口前加上@FunctionalInterface 标注。编译器会注意到这个标注，如果你的接口中定义了第二个抽象方法的话，编译器会抛出异常。
 *
 * @param <F>
 * @param <T>
 */
@FunctionalInterface
interface Converter<F, T> {
    T convert(F from);
}

class Something {
    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Person {
    String firstName;
    String lastName;
}
