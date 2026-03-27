Trong **Java**, **Interface** là một khái niệm rất quan trọng trong lập trình hướng đối tượng (OOP). Nó giúp bạn **định nghĩa một “bộ quy tắc” (contract)** mà các class khác phải tuân theo.

---

## 1️⃣ Interface là gì?

**Interface** là một kiểu dữ liệu trong Java dùng để khai báo **các phương thức nhưng không có phần thân (body)**.

Nói đơn giản:
👉 Interface giống như **bản thiết kế**.
👉 Class nào **implements** interface thì **phải viết code cho các phương thức đó**.

Ví dụ:

```java
interface Animal {
    void sound();   // phương thức không có body
}
```

Class sử dụng interface:

```java
class Dog implements Animal {
    public void sound() {
        System.out.println("Gâu gâu");
    }
}
```

Main:

```java
public class Main {
    public static void main(String[] args) {
        Dog d = new Dog();
        d.sound();
    }
}
```

Kết quả:

```
Gâu gâu
```

---

## 2️⃣ Cú pháp Interface

```java
interface TenInterface {
    // constant
    // abstract method
}
```

Ví dụ:

```java
interface Vehicle {
    void start();
    void stop();
}
```

Class implement:

```java
class Car implements Vehicle {

    public void start() {
        System.out.println("Car started");
    }

    public void stop() {
        System.out.println("Car stopped");
    }
}
```

---

## 3️⃣ Vì sao cần Interface?

Interface giúp:

### ✔ Tạo chuẩn chung cho nhiều class

Ví dụ:

```
Animal
   ↑
Dog
Cat
Bird
```

Interface:

```java
interface Animal {
    void sound();
}
```

Các class:

```java
class Dog implements Animal { ... }
class Cat implements Animal { ... }
class Bird implements Animal { ... }
```

---

### ✔ Hỗ trợ đa hình (Polymorphism)

```java
Animal a = new Dog();
a.sound();
```

Sau này có thể thay bằng:

```java
Animal a = new Cat();
```

Code **không cần sửa nhiều**.

---

### ✔ Java không hỗ trợ đa kế thừa class nhưng hỗ trợ nhiều interface

Ví dụ:

```java
interface Flyable {
    void fly();
}

interface Swimable {
    void swim();
}
```

Class có thể implement nhiều interface:

```java
class Duck implements Flyable, Swimable {

    public void fly() {
        System.out.println("Duck can fly");
    }

    public void swim() {
        System.out.println("Duck can swim");
    }
}
```

---

## 4️⃣ Một số đặc điểm quan trọng của Interface

| Đặc điểm                | Giải thích                        |
| ----------------------- | --------------------------------- |
| Method                  | Mặc định là `public abstract`     |
| Variable                | Mặc định là `public static final` |
| Không có constructor    | Không thể tạo object trực tiếp    |
| Class dùng `implements` | Không dùng `extends`              |

---

## 5️⃣ Interface vs Abstract Class

| Interface                   | Abstract Class           |
| --------------------------- | ------------------------ |
| Chỉ khai báo method         | Có thể có method có body |
| Không có biến thường        | Có biến instance         |
| Hỗ trợ multiple inheritance | Không hỗ trợ             |

---

## 6️⃣ Ví dụ thực tế dễ hiểu

Interface giống như **ổ cắm điện**.

Ổ cắm quy định:

```
phải có 2 chân
```

Nhưng:

* Laptop
* Quạt
* Sạc điện thoại

👉 mỗi thiết bị **cài đặt cách hoạt động khác nhau**.

---

💡 **Tóm tắt ngắn gọn**

Interface:

* Là **bản thiết kế**
* Chỉ định nghĩa **method**
* Class dùng **implements**
* Hỗ trợ **đa hình và multiple inheritance**

