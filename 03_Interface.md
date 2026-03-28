Trong **Java**, **Interface** là một khái niệm rất quan trọng trong lập trình hướng đối tượng (OOP). Nó giúp bạn **định nghĩa một “bộ quy tắc” (contract)** mà các class khác phải tuân theo.

---

## 1️⃣ Interface là gì?

**Interface** là một kiểu dữ liệu trong Java dùng để khai báo **các phương thức nhưng không có phần thân (body)**.

Nói đơn giản: \
👉 Interface giống như **bản thiết kế**. \
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

---

# 🔥 Ví dụ: Hệ thống thanh toán (Payment)

## 1️⃣ Interface

```java
interface Payment {
    boolean pay(int amount);
}
```

👉 Ý nghĩa:

* Bất kỳ cách thanh toán nào cũng phải có:

```
pay(số tiền)
```

---

## 2️⃣ Các class implement (logic KHÁC NHAU)

### 💳 Thanh toán bằng thẻ

```java
class CreditCardPayment implements Payment {

    private int balance = 1000;

    public boolean pay(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Paid " + amount + " by Credit Card");
            return true;
        }
        return false;
    }
}
```

---

### 📱 Thanh toán bằng ví điện tử

```java
class MomoPayment implements Payment {

    private int wallet = 500;

    public boolean pay(int amount) {
        if (wallet >= amount) {
            wallet -= amount;
            System.out.println("Paid " + amount + " by Momo");
            return true;
        }
        return false;
    }
}
```

---

## 3️⃣ Class sử dụng Interface (đây là phần QUAN TRỌNG)

```java
class OrderService {

    private Payment payment;

    public OrderService(Payment payment) {
        this.payment = payment;
    }

    public void checkout(int amount) {
        boolean success = payment.pay(amount);

        if (success) {
            System.out.println("Order success");
        } else {
            System.out.println("Payment failed");
        }
    }
}
```

👉 Notice:

```java
private Payment payment;
```

KHÔNG phải:

```java
private CreditCardPayment payment;
```

---

## 4️⃣ Main chạy thử

```java
public class Main {
    public static void main(String[] args) {

        // dùng Credit Card
        Payment payment1 = new CreditCardPayment();
        OrderService order1 = new OrderService(payment1);
        order1.checkout(300);

        // đổi sang Momo (không sửa OrderService)
        Payment payment2 = new MomoPayment();
        OrderService order2 = new OrderService(payment2);
        order2.checkout(300);
    }
}
```

---

# 🎯 Điều quan trọng bạn cần thấy

## 👉 1. Logic KHÁC NHAU nhưng dùng chung interface

| Class        | Logic       |
| ------------ | ----------- |
| CreditCard   | trừ balance |
| Momo         | trừ ví      |
| Nhưng đều có | `pay()`     |

---

## 👉 2. Không cần sửa code cũ

Bạn chỉ đổi:

```java
new CreditCardPayment()
→ new MomoPayment()
```

👉 `OrderService` **không cần sửa**

---

## 👉 3. Đây chính là sức mạnh của Interface

Nếu không dùng interface:

```java
class OrderService {
    CreditCardPayment payment; // ❌ cứng
}
```

👉 Sau này thêm Momo → phải sửa class

---

## 👉 4. Thực tế ngoài đời

Giống hệt:

* Shopee 
* Tiki 
* Grab

Bạn chọn:

```
Thẻ
Ví điện tử
Chuyển khoản
```

👉 App vẫn chạy bình thường

---

# ✅ Tóm lại

Interface giúp bạn:

* Tách **logic sử dụng** và **logic thực thi**
* Dễ thêm tính năng mới
* Code **không bị phụ thuộc cứng**

---

Haha câu hỏi này rất “đúng chất” người đang bắt đầu hiểu sâu rồi 😄

👉 **80% bạn vừa hiểu = cách dùng Interface cơ bản**
👉 **20% còn lại = thứ khiến bạn code như dev chuyên nghiệp**

Mình tóm lại 20% đó cho bạn, nhưng giải thích kiểu **dễ hiểu nhất có thể** nhé.

---

# 🔥 1️⃣ Dependency Injection (DI) – cái bạn vừa chạm vào

Bạn đã thấy:

```java
OrderService order = new OrderService(new MomoPayment());
```

👉 Đây chính là **Dependency Injection (DI)**

Thay vì:

```java
class OrderService {
    Payment payment = new MomoPayment(); // ❌ hard-code
}
```

👉 Bạn **inject từ bên ngoài**

💡 Trong thực tế (Spring Boot):

```java
@Autowired
Payment payment;
```

👉 Framework tự nhét vào cho bạn

---

# 🔥 2️⃣ Dùng Interface để “mock” khi test

Ví dụ:

Bạn không muốn test thật (vì tốn tiền, gọi API thật, etc.)

👉 Bạn tạo fake:

```java
class FakePayment implements Payment {
    public boolean pay(int amount) {
        return true; // luôn thành công
    }
}
```

👉 Test:

```java
OrderService order = new OrderService(new FakePayment());
```

👉 Không cần:

* kết nối ngân hàng
* gọi API thật

---

# 🔥 3️⃣ Interface + nhiều implementation (Strategy pattern)

Bạn đã làm rồi, nhưng tên “xịn” của nó là:

👉 **Strategy Pattern**

Ví dụ:

```id="zrqylm"
Payment
 ├── MomoPayment
 ├── CreditCardPayment
 └── BankTransferPayment
```

👉 Chọn strategy runtime:

```java
if (userChoice == 1) payment = new MomoPayment();
else payment = new CreditCardPayment();
```

---

# 🔥 4️⃣ Default method (Java 8+)

Interface giờ **có thể có code luôn**

```java
interface Payment {

    void pay(int amount);

    default void log() {
        System.out.println("Logging payment...");
    }
}
```

👉 Class implement **không cần override `log()`**

---

# 🔥 5️⃣ Functional Interface + Lambda (rất hay dùng)

Ví dụ:

```java
interface Calculator {
    int calculate(int a, int b);
}
```

👉 Thay vì viết class:

```java
Calculator c = new Calculator() {
    public int calculate(int a, int b) {
        return a + b;
    }
};
```

👉 Viết gọn:

```java
Calculator c = (a, b) -> a + b;
```

💥 Đây là nền tảng của:

* Stream API
* xử lý list, filter, map

---

# 🔥 6️⃣ Interface trong framework (level thực tế)

Ví dụ trong Spring:

```id="6c48q3"
UserService (interface)
UserServiceImpl (class)
```

Controller chỉ dùng:

```java
UserService userService;
```

👉 Bạn có thể thay:

* DB → API
* MySQL → MongoDB
* Local → Cloud

**không cần sửa controller**

---

# 🎯 Tóm lại “20% còn lại”

| Level | Bạn học được gì          |
| ----- | ------------------------ |
| 80%   | implements, polymorphism |
| +5%   | Dependency Injection     |
| +5%   | Test (mock)              |
| +5%   | Strategy pattern         |
| +3%   | default method           |
| +2%   | lambda                   |

---

# 💡 Nói thẳng cho bạn dễ nhớ

👉 Interface không phải để “viết method”

👉 Nó là để:

```id="g8ce3g"
tách phần "dùng" và phần "làm"
```

---

# 🚀 Nếu bạn muốn lên trình nhanh

Mình có thể cho bạn:

1. 🔧 Mini project: **Order + Payment + nhiều method (real hơn)**
2. 🧠 Bài tập: đoán khi nào dùng interface
3. 💼 Ví dụ kiểu **Spring Boot thật (Service + Repository)**
