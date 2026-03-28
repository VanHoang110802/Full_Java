**Lambda Expression** là một tính năng rất quan trọng được giới thiệu từ **Java 8**. Nó giúp viết code **ngắn gọn hơn, dễ đọc hơn**, đặc biệt khi làm việc với **functional programming** và **Stream API**.

---

## 1. Lambda Expression là gì?

**Lambda Expression** là **một cách viết ngắn gọn của một hàm (method) không tên**.

Nó thường dùng khi làm việc với **Functional Interface** (interface chỉ có 1 method).

### Cú pháp chung

```java
(parameters) -> expression
```

hoặc

```java
(parameters) -> { statements }
```

Ý nghĩa:

| Phần                      | Ý nghĩa         |
| ------------------------- | --------------- |
| `parameters`              | tham số đầu vào |
| `->`                      | ký hiệu lambda  |
| `expression / statements` | phần xử lý      |

---

## 2. Ví dụ đơn giản nhất

### Không dùng Lambda

```java
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Hello Java");
    }
};
```

### Dùng Lambda

```java
Runnable r = () -> {
    System.out.println("Hello Java");
};
```

➡ Code **ngắn hơn rất nhiều**.

---

## 3. Ví dụ với phép tính

### Interface

```java
interface Calculator {
    int calculate(int a, int b);
}
```

### Dùng Lambda

```java
Calculator sum = (a, b) -> a + b;

System.out.println(sum.calculate(5, 3));
```

Kết quả:

```
8
```

---

## 4. Ví dụ với List (thường gặp nhất)

```java
import java.util.*;

public class Main {
    public static void main(String[] args) {

        List<String> list = Arrays.asList("Java", "Python", "C++");

        list.forEach(item -> System.out.println(item));
    }
}
```

Lambda ở đây:

```java
item -> System.out.println(item)
```

---

## 5. Khi nào nên dùng Lambda?

Lambda thường dùng với:

* `forEach`
* `Stream API`
* `Comparator`
* `Thread`
* `Event Listener`

Ví dụ sort:

```java
list.sort((a, b) -> a.compareTo(b));
```

---

## 6. So sánh dễ hiểu

| Kiểu     | Code              |
| -------- | ----------------- |
| Cách cũ  | class ẩn danh     |
| Cách mới | lambda expression |

Lambda giúp:

* code **gọn**
* **ít boilerplate**
* dễ dùng với **Stream API**

---

## 7. Một số dạng Lambda phổ biến

### Không có tham số

```java
() -> System.out.println("Hello")
```

### 1 tham số

```java
x -> x * x
```

### Nhiều tham số

```java
(a, b) -> a + b
```

### Nhiều dòng

```java
(a, b) -> {
    int sum = a + b;
    return sum;
}
```

---

**Lambda Expression thực chất là cách viết ngắn gọn để triển khai (implement) một Functional Interface.** 

---

## 1. Functional Interface là gì?

**Functional Interface** là interface chỉ có **1 abstract method**.

Ví dụ:

```java
interface Calculator {
    int calculate(int a, int b);
}
```

Interface này chỉ có **1 method** → nên nó là **Functional Interface**.

---

## 2. Cách triển khai Functional Interface (3 cách)

### Cách 1 — Tạo class bình thường

```java
class SumCalculator implements Calculator {
    public int calculate(int a, int b) {
        return a + b;
    }
}
```

Dùng:

```java
Calculator cal = new SumCalculator();
```

---

### Cách 2 — Anonymous class

```java
Calculator cal = new Calculator() {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
};
```

---

### Cách 3 — Lambda Expression (ngắn nhất)

```java
Calculator cal = (a, b) -> a + b;
```

➡ Lambda **viết ngắn lại** phần implementation của method.

---

## 3. Lambda thực sự thay thế cái gì?

Lambda **không thay thế Interface**.

Lambda chỉ thay thế **anonymous class của Functional Interface**.

Tức là:

```java
new InterfaceName() {
    public method() { ... }
}
```

➡ có thể viết thành

```java
(parameters) -> expression
```

---

## 4. Ví dụ cực rõ với Runnable

`Runnable` là Functional Interface trong Java.

### Cách cũ

```java
Runnable r = new Runnable() {
    @Override
    public void run() {
        System.out.println("Hello");
    }
};
```

### Lambda

```java
Runnable r = () -> System.out.println("Hello");
```

---

## 5. Sơ đồ dễ hiểu

```
Functional Interface
        │
        │ cần implement method
        │
   Anonymous Class
        │
        ▼
   Lambda Expression
```

➡ Lambda = **cách viết ngắn gọn để implement Functional Interface**

---

## 6. Một điểm rất quan trọng người mới hay nhầm

Lambda **chỉ dùng được khi interface có đúng 1 method**.

Ví dụ:

```java
interface Test {
    void a();
    void b();
}
```

❌ Không dùng được lambda.

---

## 7. Một số Functional Interface nổi tiếng trong Java

Trong package `java.util.function`:

| Interface       | Lambda dạng    |
| --------------- | -------------- |
| `Predicate<T>`  | `T -> boolean` |
| `Function<T,R>` | `T -> R`       |
| `Consumer<T>`   | `T -> void`    |
| `Supplier<T>`   | `() -> T`      |

Ví dụ:

```java
Predicate<Integer> isEven = x -> x % 2 == 0;
```

---

✅ **Kết luận ngắn gọn**

Lambda Expression:

> là **cách viết ngắn gọn để implement Functional Interface**, thay thế cho **anonymous class**.

---

**Lambda chỉ dùng được với Functional Interface vì:**

> 👉 Compiler cần biết **Lambda này đang implement method nào** \
> 👉 Nếu interface có **nhiều hơn 1 method → không biết map vào đâu**

---

## 1. Bản chất Lambda trong Java

Khi bạn viết:

```java
Calculator cal = (a, b) -> a + b;
```

Thực tế **compiler của Java sẽ hiểu là:**

```java
Calculator cal = new Calculator() {
    @Override
    public int calculate(int a, int b) {
        return a + b;
    }
};
```

➡ Tức là Lambda **phải gắn vào đúng 1 method cụ thể**

---

## 2. Nếu có nhiều method thì chuyện gì xảy ra?

Giả sử:

```java
interface Test {
    int a(int x);
    int b(int x);
}
```

Bạn viết:

```java
Test t = x -> x * 2;
```

❓ Câu hỏi: Lambda này là implement cho `a()` hay `b()`?

👉 **Không thể biết được** \
👉 Compiler bị “mù” → lỗi ngay

---

## 3. Đây gọi là “Target Type”

Lambda trong Java **không tự đứng một mình được**
Nó cần một thứ gọi là:

> 🎯 **Target Type (kiểu đích)**

Ví dụ:

```java
Calculator cal = (a, b) -> a + b;
```

* `Calculator` chính là **target type**
* Và vì `Calculator` chỉ có 1 method → compiler biết chắc:

👉 Lambda này = method `calculate`

---

## 4. Nếu có nhiều method → mất target rõ ràng

```java
interface Multi {
    void a();
    void b();
}
```

```java
Multi m = () -> System.out.println("Hello");
```

➡ Compiler sẽ hỏi:

* gọi `a()`?
* hay `b()`?

👉 Không xác định được → ❌ lỗi

---

## 5. So sánh dễ hiểu

| Trường hợp | Có dùng Lambda được không? | Lý do                  |
| ---------- | -------------------------- | ---------------------- |
| 1 method   | ✅                          | map rõ ràng            |
| 2+ method  | ❌                          | không biết map vào đâu |

---

## 6. Một insight quan trọng (rất đáng nhớ)

Lambda trong Java **KHÔNG phải function độc lập** như JavaScript.

👉 Nó luôn là:

> **“implementation của một method duy nhất trong interface”**

---

## 7. Vì sao Java thiết kế như vậy?

Java là ngôn ngữ:

* **Strongly typed** (kiểu dữ liệu chặt chẽ)
* Ưu tiên **an toàn & rõ ràng**

Nên:

* Không cho phép “mơ hồ”
* Phải xác định chính xác method

➡ Functional Interface ra đời để đảm bảo điều đó

---

## 8. Câu chốt (rất quan trọng)

👉 Lambda hoạt động được vì:

> **Interface chỉ có 1 method → compiler biết chính xác phải gán code vào đâu**

---

# 🧠 📌 BẢNG ĐỌC HIỂU LAMBDA + STREAM (FULL CHEAT SHEET)

## 🔥 1. Quy trình đọc (quan trọng nhất)

| Bước | Làm gì                           | Cách đọc               |
| ---- | -------------------------------- | ---------------------- |
| 1    | Xác định nguồn (`list.stream()`) | lấy dữ liệu từ đâu     |
| 2    | Gặp `filter`                     | giữ lại những cái mà…  |
| 3    | Gặp `map`                        | biến thành…            |
| 4    | Gặp `sorted / limit / skip`      | sắp xếp / lấy / bỏ qua |
| 5    | Gặp `forEach / collect`          | xử lý / trả kết quả    |
| 6    | Gặp `->`                         | với … thì…             |

---

## ⚡ 2. Từ khóa “focus” (phải nhớ)

| Từ khóa     | Nghĩa     | Cách đọc nhanh |
| ----------- | --------- | -------------- |
| `stream()`  | tạo luồng | bắt đầu xử lý  |
| `filter()`  | lọc       | giữ lại…       |
| `map()`     | biến đổi  | biến thành…    |
| `forEach()` | xử lý     | với mỗi… thì…  |
| `->`        | lambda    | với … thì…     |

---

## 🧩 3. Từ khóa phụ trợ (hay gặp)

| Từ khóa      | Nghĩa         | Cách đọc         |
| ------------ | ------------- | ---------------- |
| `sorted()`   | sắp xếp       | sắp xếp lại      |
| `limit(n)`   | lấy n phần tử | lấy n cái đầu    |
| `skip(n)`    | bỏ qua        | bỏ qua n cái đầu |
| `distinct()` | loại trùng    | lấy không trùng  |

---

## 💣 4. Từ khóa nâng cao (gặp sau)

| Từ khóa        | Nghĩa      | Cách đọc        |
| -------------- | ---------- | --------------- |
| `flatMap()`    | trải phẳng | gộp nhiều list  |
| `reduce()`     | gộp        | tính tổng / gom |
| `collect()`    | thu gom    | trả về kết quả  |
| `groupingBy()` | nhóm       | nhóm theo       |

---

## 🧠 5. Công thức đọc chuẩn

👉 Luôn đọc theo flow:

> **Lấy → Lọc → Biến → (Sắp xếp / Cắt) → Xử lý**

---

## 🔥 6. Mẫu câu “auto hiểu”

| Code                     | Đọc                     |
| ------------------------ | ----------------------- |
| `x -> x > 10`            | với x thì kiểm tra > 10 |
| `x -> x * 2`             | biến x thành x * 2      |
| `user -> user.getName()` | lấy tên user            |

---

## 🎯 7. Ví dụ áp dụng

```java
list.stream()
    .filter(x -> x > 5)
    .map(x -> x * 2)
    .limit(3)
    .forEach(System.out::println);
```

👉 Đọc:

> lấy phần tử \
> → lọc > 5 \
> → nhân 2 \
> → lấy 3 cái đầu \
> → in ra

---

# 🚀 Câu chốt (quan trọng nhất)

> ❗ Không đọc code từng dòng \
> 👉 hãy đọc như **dòng chảy dữ liệu**

---

Luyện “đọc dòng chảy” là cách nhanh nhất để giỏi Lambda + Stream.


# 🟢 Level 1 — Cơ bản (1 bước)

```java
list.stream()
    .forEach(x -> System.out.println(x));
```

👉 Nhiệm vụ:

* Đọc thành **1 câu tiếng Việt**

---

```java
list.stream()
    .filter(x -> x > 10)
    .forEach(x -> System.out.println(x));
```

👉 Gợi ý:

* Có 2 bước: lọc + in

---

# 🟡 Level 2 — 2 bước (filter + map)

```java
list.stream()
    .filter(x -> x % 2 == 0)
    .map(x -> x * 3)
    .forEach(x -> System.out.println(x));
```

👉 Nhiệm vụ:

* Đọc theo dạng:

> “Lấy từng phần tử → … → … → …”

---

# 🔵 Level 3 — đổi kiểu dữ liệu

```java
list.stream()
    .map(s -> s.length())
    .forEach(len -> System.out.println(len));
```

👉 Câu hỏi:

* `s` là gì?
* `len` là gì?

---

# 🟣 Level 4 — bắt đầu “rối nhẹ”

```java
list.stream()
    .filter(s -> s.startsWith("A"))
    .map(s -> s.toUpperCase())
    .forEach(s -> System.out.println(s));
```

👉 Nhiệm vụ:

* Đọc trôi chảy như tiếng Việt
* Không đọc ký hiệu code

---

# 🔴 Level 5 — Lambda lồng nhau

```java
list1.forEach(x -> {
    list2.forEach(y -> {
        System.out.println(x * y);
    });
});
```

👉 Nhiệm vụ:

* Đọc theo kiểu:

> “với mỗi x… → với mỗi y…”

---

# 🔥 Level 6 — giống code thực tế

```java
users.stream()
    .filter(u -> u.getAge() > 18)
    .forEach(u -> {
        orders.stream()
            .filter(o -> o.getUserId() == u.getId())
            .forEach(o -> System.out.println(o));
    });
```

👉 Nhiệm vụ:

* Đọc thành **1 đoạn mô tả logic**
* Hiểu quan hệ giữa `u` và `o`

---

# 💣 Level 7 — hơi “não xoắn” (pro)

```java
list.stream()
    .filter(x -> {
        return x > 5 && x < 20;
    })
    .map(x -> {
        int y = x * 2;
        return y + 1;
    })
    .forEach(result -> {
        System.out.println(result);
    });
```

👉 Nhiệm vụ:

* Đọc rõ từng bước
* Không bị mất luồng

---

# 🧠 Cách luyện đúng (quan trọng hơn bài)

Khi bạn làm, hãy follow đúng quy trình này:

---

## Bước 1: Tìm “đối tượng chính”

```java
list.stream()
```

👉 đang xử lý **list**

---

## Bước 2: Mỗi dòng = 1 hành động

* filter → lọc
* map → biến đổi
* forEach → xử lý cuối

---

## Bước 3: Đọc theo flow

👉 Luôn đọc kiểu:

> “Lấy từng phần tử → … → … → …”

---

## Bước 4: Thay `x`, `s`, `u` bằng nghĩa thật

❌

> x → ???

✅

> user → người dùng \
> s → chuỗi

---

# 🎯 Mục tiêu luyện

Khi bạn đạt level này:

* Nhìn vào code → hiểu ngay không cần dịch
* Đọc trong đầu như tiếng Việt

👉 là bạn đã “qua cửa” Lambda
